package org.iesw.inha.generator.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.iesw.inha.ioconfig.HComponentConfig;
import org.iesw.inha.ioconfig.ai.HSNNIOConfig;

public class HUIGenerator {
    public static final int H_SNN = 1;  
    public static final int H_ANN = 2;   
    public static final int H_IoT = 3;  
    
    public static final int HNUM_PRJ = 1; //프로젝트 생성시
    public static final int HNUM_DIAL = 2; //컴포넌트 다이얼로그로 접근시
    public static final int HNUM_DL = 3; //nengoDL 소스코드생성시
    
    private static final int Linear = 1;
    private static final int Logistic = 2;
    private static final int MNIST = 3;   
    
    public static final int H_DATA_SET_TRAINING = 0;   
    public static final int H_DATA_SET_TEST = 1; 
    
    
    private static final int DATA_F = 0;
    private static final int IMP_F = 1;
    private static final int PRINT_F = 2;
    
    private int hState = 0; //SNN, ANN, IoT
    private int hNum = 0; //PRJ, DIAL, DL
    private int hModel = 0; //Linear, Logistic, MNIST
    private int hDataSetOpt = -1; //dataset 옵션 트레이닝 or 테스트 
    
    private HComponentConfig hCompCfg;
    private HSNNIOConfig hSnnCfg;
    
    public String hProjectDirectory;
    public String hComponentName;
    //public String hComponentName;

    public FileWriter hFW;
    public BufferedWriter hBW;
    public PrintWriter hPW;
    public FileReader hFR;
    public BufferedReader hBR;
    
    public String beforeSource; 
    public String afterSource;
    
    public String originalString;
    public String replaceString; 
    
    private String[] hFileName;// = new String[3];
    
    public FileWriter[] hFWarr;
    public BufferedWriter[] hBWarr;
    public PrintWriter[] hPWarr;
    
    public HUIGenerator(HComponentConfig hComponentConfig, int state, int num, String dir){
        hCompCfg = hComponentConfig;
        hState = state;
        hNum = num;
        String name = dir.substring(dir.lastIndexOf("\\")+1); 

        if(hNum == HNUM_PRJ){
            if(hCompCfg.getComponentName()==null){
                hComponentName = name;
                loadFile(dir, name);
            }
            else 
                loadFile(dir, hCompCfg.getComponentName());
            initFile();
            writeFile(createFile());
        }
        else{
            hProjectDirectory = dir;
            loadFile(dir, null);
            initReadFile();
        }
    }
    public HUIGenerator(int state, int num, String dir, int model, HSNNIOConfig snnCfg, int dataSetOpt){
        hState = state;
        hNum = num;
        hModel = model;
        hDataSetOpt = dataSetOpt;
        
        hSnnCfg = snnCfg;
        hProjectDirectory = dir;
        hComponentName = hProjectDirectory.substring(hProjectDirectory.lastIndexOf("\\")+1);
        
        if (hState == H_SNN && hDataSetOpt == H_DATA_SET_TEST) {
            initFiles(model);
            
            for (int i = 0; i < 3; i++) {
                writeFiles(createFiles(model, i), i);
            }
        }
        else{
            loadFile(hProjectDirectory,hComponentName);
            initFile();
            writeFile(createFile());
        }
    }
    private String stateName(){
        String name="";
        if(hState == H_SNN)
            name = "snn";
        else if(hState == H_ANN)
            name = "ann";
        else
            name = "iot";
        return name;
    }
    public void loadFile(String hDir, String hCompName){
        
        String nnFile ="component";
        if(hState == H_SNN)
            nnFile = "snn-component";
        else if(hState == H_ANN)
            nnFile = "ann-component";
        else
            nnFile = "iot-component";
        hProjectDirectory = hDir+"\\src\\hnu\\"+nnFile+".html"; 
    }
    
    public void componentNameReplace(String cName){
        if(cName == null)
            originalString = "snn-component";
        else
            originalString = cName;
        replaceString = hCompCfg.getComponentName();
        replaceSource();
        
    }
    
    public void componentDirReplace(String cDir){
        if(cDir == null)
            originalString = "%COMPONENTDIR%";
        else
            originalString = cDir;
        replaceString = hCompCfg.getComponentDir();
        replaceSource();
    }
    
    public void componentInputReplace(int cInput){
        if(cInput == 0)
            originalString = "%COMPONENTINPUT%";
        else
            originalString = Integer.toString(cInput);
        replaceString = Integer.toString(hCompCfg.getComponentInput());
        replaceSource();
    }
    
    public void componentOutputReplace(int cOutput){
        if(cOutput == 0)
            originalString = "%COMPONENTOUTPUT%";
        else
            originalString = Integer.toString(cOutput);
        replaceString = Integer.toString(hCompCfg.getComponentOutput());
        replaceSource();
    }
    
    public void descriptionReplace(String cDescription){
        if(cDescription == null)
            originalString = "%DESCRIPTION%";
        else
            originalString = cDescription;
        replaceString = hCompCfg.getDescription();
        replaceSource();
    }
    
    public void replaceSource(){
        if(hBR ==null)
            initReadFile();
        try{
        while((beforeSource = hBR.readLine()) != null){
            afterSource = beforeSource.replaceAll(originalString, replaceString);
            writeFile(afterSource+"\r\n");
        }
        if(hNum != HNUM_PRJ )
            renameFile();
        }
        catch(IOException ex){
            
        }
    }
    
    public String createFile(){
        String categoryTemp="";
        String componentName="";
        if (hCompCfg != null) {
            if (hCompCfg.getCategory() != null) {
                categoryTemp = hCompCfg.getCategory();
            }
            if (hCompCfg.getComponentName() != null) {
                componentName = hCompCfg.getComponentName();
            }
        } else {
            componentName = hComponentName;
            if (hState == H_SNN || hState == H_ANN) {
                categoryTemp = "Neuromorphic";
            } else {
                categoryTemp = "IoT";
            }
        }
        String source="";
        source = "<script type=\"text/x-red\" data-template-name=\"" + componentName + "\">\r\n"
                + "    <div class=\"form-row\">\r\n"
                + "        <label for=\"component-input-name\"><i class=\"icon-tag\"></i> name</label>\r\n"
                + "        <input type=\"text\" id=\"component-input-name\" placeholder=\"input name\">\r\n"
                + "    </div>\r\n"
                + "</script>\r\n"
                + "\r\n"
                + "<script type=\"text/x-red\" data-help-name=\"" + componentName + "\">\r\n"
                + "    <p>%DESCRIPTION%</p>\r\n"
                + "</script>\r\n"
                + "\r\n"
                + "<script type=\"text/javascript\">\r\n"
                + "    RED.nodes.registerType('" + componentName + "',{\r\n"
                + "        category: '" + categoryTemp + "',\r\n"
                + "        color: '#999999',\r\n"
                + "        defaults: {\r\n"
                + "            name: {value: \"\"}\r\n"
                + "        },\r\n"
                + "        inputs:1,\r\n"
                + "        outputs:1,\r\n"
                + "        icon: \"file.png\",\r\n"
                + "        label: function() {\r\n"
                + "            return this.name||\"" + componentName + "\";\r\n"
                + "        },\r\n"
                + "        oneditprepare: function() {\r\n"
                + "        },\r\n"
                + "        oneditsave: function() {\r\n"
                + "        }\r\n"
                + "    });\r\n"
                + "</script>";
        return source;
        
    }
    
    //여기서 nengoDL일때 소스코드들을 생성해야함
    public String createFiles(int model, int type) {
        String categoryTemp = "";
        String componentName = "";
        if (hCompCfg != null) {
            if (hCompCfg.getCategory() != null) {
                categoryTemp = hCompCfg.getCategory();
            }
            if (hCompCfg.getComponentName() != null) {
                componentName = hCompCfg.getComponentName();
            }
        } else {
            componentName = hComponentName;
            if (hState == H_SNN || hState == H_ANN) {
                categoryTemp = "Neuromorphic";
            } else {
                categoryTemp = "IoT";
            }
        }
        String source = "";
        switch (type) {
            case DATA_F:
                source = "<script type=\"text/x-red\" data-template-name=\"" + componentName + "-dataset\">\r\n"
                        + "    <div class=\"form-row\">\r\n"
                        + "        <label for=\"node-input-name\"><i class=\"icon-tag\"></i> 이름</label>\r\n"
                        + "        <input type=\"text\" id=\"node-input-name\" placeholder=\"이름 입력\">\r\n"
                        + "    </div>\r\n"
                        + "</script>\r\n"
                        + "\r\n"
                        + "<script type=\"text/x-red\" data-help-name=\"" + componentName + "-dataset\">\r\n";
                if (model == Linear) {
                    source += "    <p>임의의 IRIS 데이터 정보를 뽑아 String 데이터를 내보냅니다.</p>\r\n"
                            + "    <p>IRIS 데이터는 입력되는 time 값에 따라 범위를 제한할 수 있습니다.</p>\r\n";
                } else if (model == MNIST) {
                    source += "    <p>임의의 MNIST 데이터 정보를 뽑아 String 데이터를 내보냅니다.</p>\r\n"
                            + "    <p>MNIST 데이터는 입력되는 time 값에 따라 범위를 제한할 수 있습니다. 범위 : 0 ~ 10000</p>\r\n";
                }
                source += "</script>\r\n"
                        + "\r\n"
                        + "<script type=\"text/javascript\">\r\n"
                        + "    RED.nodes.registerType('" + componentName + "-dataset',{\r\n"
                        + "        category: '" + categoryTemp + "',\r\n"
                        + "        color: '#999999',\r\n"
                        + "        defaults: {\r\n"
                        + "            name: {value: \"" + componentName + "-Dataset\"},\r\n"
                        + "        },\r\n"
                        + "        codeEditable: true,\r\n"
                        + "        inputs:1,\r\n"
                        + "        outputs:1,\r\n"
                        + "        icon: \"file.png\",\r\n"
                        + "        label: function() {\r\n"
                        + "            return this.name||\"" + componentName + "-dataset\";\r\n"
                        + "        },\r\n"
                        + "        oneditprepare: function() {\r\n"
                        + "        },\r\n"
                        + "        oneditsave: function() {\r\n"
                        + "        }\r\n"
                        + "    });\r\n"
                        + "</script>";
                break;
            case IMP_F:
                source = "<script type=\"text/x-red\" data-template-name=\"" + componentName + "-implement\">\r\n"
                        + "    <div class=\"form-row\">\r\n"
                        + "        <label for=\"node-input-name\"><i class=\"icon-tag\"></i> 이름</label>\r\n"
                        + "        <input type=\"text\" id=\"node-input-name\" placeholder=\"이름 입력\">\r\n"
                        + "    </div>\r\n"
                        + "</script>\r\n"
                        + "\r\n"
                        + "<script type=\"text/x-red\" data-help-name=\"" + componentName + "-implement\">\r\n";
                if (model == Linear)
                    source += "    <p>Train 데이터를 기반으로 입력된 IRIS Data에 대한 Linear Regression 결과값을 내보냅니다.</p>\r\n";
                else if (model == MNIST)
                    source += "<p>Train 데이터를 기반으로 입력된 MNIST Data에 대한 10개의 숫자들로 추론 결과값을 내보냅니다.</p>\r\n";
                source += "</script>\r\n"
                        + "\r\n"
                        + "<script type=\"text/javascript\">\r\n"
                        + "    RED.nodes.registerType('" + componentName + "-implement',{\r\n"
                        + "        category: '" + categoryTemp + "',\r\n"
                        + "        color: '#669933',\r\n"
                        + "        defaults: {\r\n"
                        + "            name: {value: \"" + componentName + "-Implement\"}\r\n"
                        + "        },\r\n";
                if (model == MNIST) source += "        codeEditable: true,\r\n";
                source += "        inputs:1,\r\n"
                        + "        outputs:1,\r\n"
                        + "        icon: \"function.png\",\r\n"
                        + "        label: function() {\r\n"
                        + "            return this.name||\"" + componentName + "-implement\";\r\n"
                        + "        },\r\n"
                        + "        oneditprepare: function() {\r\n"
                        + "        },\r\n"
                        + "        oneditsave: function() {\r\n"
                        + "        }\r\n"
                        + "    });\r\n"
                        + "</script>";
                break;
            case PRINT_F:
                source = "<script type=\"text/x-red\" data-template-name=\"" + componentName + "-print\">\r\n"
                        + "    <div class=\"form-row\">\r\n"
                        + "        <label for=\"node-input-name\"><i class=\"icon-tag\"></i> 이름</label>\r\n"
                        + "        <input type=\"text\" id=\"node-input-name\" placeholder=\"이름 입력\">\r\n"
                        + "    </div>\r\n"
                        + "</script>\r\n"
                        + "\r\n"
                        + "<script type=\"text/x-red\" data-help-name=\"" + componentName + "-print\">\r\n";
                if (model == Linear) 
                    source += "    <p>입력된 IRIS Train 결과를 시각화 정리하여 내보냅니다.</p>\r\n";
                 else if (model == MNIST) 
                    source += "    <p>입력된 MNIST Data의 숫자 10개에 대한 추론 결과를 시각화 정리하여 내보냅니다.</p>\r\n";
                source += "    <p>이 노드의 출력값은 NA-PackageManager 노드를 통해 자세하게 확인할 수 있습니다.</p>\r\n"
                        + "</script>\r\n"
                        + "\r\n"
                        + "<script type=\"text/javascript\">\r\n"
                        + "    RED.nodes.registerType('" + componentName + "-print',{\r\n"
                        + "        category: '" + categoryTemp + "',\r\n"
                        + "        color: '#6699FF',\r\n"
                        + "        defaults: {\r\n"
                        + "            name: {value: \"" + componentName + "-Print\"}\r\n"
                        + "        },\r\n";
                if (model == MNIST) source += "        codeEditable: true,\r\n";
                source += "        inputs:1,\r\n"
                        + "        outputs:1,\r\n"
                        + "        icon: \"comment.png\",\r\n"
                        + "        label: function() {\r\n"
                        + "            return this.name||\"" + componentName + "-print\";\r\n"
                        + "        },\r\n"
                        + "        oneditprepare: function() {\r\n"
                        + "        },\r\n"
                        + "        oneditsave: function() {\r\n"
                        + "        }\r\n"
                        + "    });\r\n"
                        + "</script>";
                break;
        }
        return source;
    }
 
    public void initFile(){

        initReadFile();
        initWriteFile();
    }
    
    public void initFiles(int model){ //NengoDL 런타임을 통해 들어왔을 때
       String prjDir = hProjectDirectory+ File.separatorChar + "src" +File.separatorChar + "hnu"+File.separatorChar +hComponentName;

       int fNum = 3;

       hFileName = new String[fNum];
       hFileName[0] = prjDir + "-dataset.html";
       hFileName[1] = prjDir + "-implement.html";
       hFileName[2] = prjDir + "-print.html";
       
       if(hFileName!=null && hFWarr == null){
            try{
                hFWarr = new FileWriter[fNum];
                hBWarr = new BufferedWriter[fNum];
                hPWarr = new PrintWriter[fNum];
                for(int i=0; i<fNum; i++){
                    hFWarr[i] = new FileWriter(hFileName[i], false);
                    hBWarr[i] = new BufferedWriter(hFWarr[i]);
                    hPWarr[i] = new PrintWriter(hBWarr[i]);
                }
            } catch(IOException ex){
                
            }
        }
   }
    
    public void initWriteFile(){

        String compDir = hProjectDirectory;
        if(hNum == HNUM_DIAL)
            compDir = hProjectDirectory+".temp";
                
        try{
        if(compDir!=null&&hFW==null){    
            
                hFW = new FileWriter(compDir, false);
                hBW = new BufferedWriter(hFW);
                hPW = new PrintWriter(hBW);
            } 
        }
        catch(IOException ex) {
        }
    }
   
    
    public void initReadFile(){
        try{
        
        if(hProjectDirectory!=null&&hFR==null){    
            
                hFR = new FileReader(hProjectDirectory);
                hBR = new BufferedReader(hFR);
                
            }
        }
        catch(IOException ex) {
        }
    }
    
    public void renameFile(){
        destroy();
        File rFile = new File(hProjectDirectory);
        File wFile = new File(hProjectDirectory+".temp");
        rFile.delete();
        wFile.renameTo(new File(hProjectDirectory));
    }
    
    public void writeFile(String contents){
        if(hPW==null)
            initWriteFile();
        
        if(hPW!=null){
            hPW.print(contents);
            hPW.flush();
        }       
    }
    
    public void destroy(){
        try{
            if(hFR!=null && hBR!=null){
                hBR.close(); hBR = null;
                hFR.close(); hFR = null;
            }
            if(hPW!=null && hBW!=null && hFW!=null){

                hPW.close(); hPW = null;
                hBW.close(); hBW = null;
                hFW.close(); hFW = null;
            } 
        }
        catch (IOException ex) {
        }
    }
    
    private void writeFiles(String contents, int type){

       if(hFileName!=null && hPWarr !=null){
           hPWarr[type].print(contents);
           hPWarr[type].flush();
       }

    }
}
