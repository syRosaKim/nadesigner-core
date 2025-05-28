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

public class HFunctionGenerator {
    
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
   
    
    public static int board = 0;
    public static final int rspi = 1;
    public static final int nano = 2;
    public static final int coral = 3;
    public static final int tinker =4;
    public static final int panda = 5; 
    
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
    
    String nnFile ="";
    
    public HFunctionGenerator(HComponentConfig hComponentConfig, int state, int num, String dir){
        hCompCfg = hComponentConfig;
        hState = state;
        hNum = num;
        if(hNum == HNUM_PRJ){
            loadFile(dir, hCompCfg.getComponentName());
            initFile();
            writeFile(createFile());
        }
        else{
            hProjectDirectory = dir;
            loadFile(dir, null);
            initFile();
        }
    }
    
    public HFunctionGenerator(int state, int num, String dir, int model, HSNNIOConfig snnCfg, int dataSetOpt){
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
    
        
    
    public void loadFile(String hDir, String hCompName){
        
        nnFile ="iot-component";
        if(hState == H_SNN)
            nnFile = "snn-component";
        else if(hState == H_ANN)
            nnFile = "ann-component";
        hProjectDirectory = hDir+"\\src\\hnu\\"+nnFile+".js"; 
    }
    
    public void componentNameReplace(String cName){
        if(cName == null)
            originalString = "%COMPONENTNAME%";
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
    
     public String createFile() {
         String componentName="";
        if(hCompCfg!=null)
            componentName = hCompCfg.getComponentName();
        else
            componentName = hComponentName;
         String source = "";
        source += "module.exports = function(RED) {\r\n"
                + "    function " + componentName + "(config) {\r\n"
                + "       RED.nodes.createNode(this, config);\r\n"
                + "        var component = this;\r\n"
                + "        var callPython = function(msg) {\r\n";
        if (hState == H_IoT) {
            source = source + "            const data = msg.payload;\r\n";
        }
        source = source
                + "//rspi && jetson nano && panda\r\n"
                + "            const spawn = require(\"child_process\").spawn;\r\n"
                + "            const pythonProcess = spawn('python3',[\"nodes/" + componentName + "/src/hnu/" + nnFile + ".py\"";
        if (hState == H_IoT) {
            source = source + ",data";
        }
        source = source + "]);\r\n"
                + "            pythonProcess.stdout.on('data', function(data) {\r\n"
                + "                sendFunction(Buffer.from(data, 'utf-8').toString());\r\n"
                + "            });\r\n"
                + "        }\r\n"
                + "//coral && tinker\r\n"
                + "//npm install sudo-js --save 필요\r\n"
                + "//            const sudo = require('sudo-js);\r\n"
                + "//            sudo.setPassword('1234');//board password \r\n"
                + "//            sudo.exec([\"python3\",`${__dirname}/" + nnFile + ".py`,data],function(err,pid,data){\r\n"
                + "//                sendFunction(Buffer.from(data, 'uft-8).toString)());\r\n"
                + "//            });\r\n"
                + "//           }\r\n"
                + "        var sendFunction = (data) => {\r\n"
                + "                var msg = {};\r\n"
                + "                msg.payload = data.replace('\\r\\n', '').toString();\r\n"
                + "                split_data = data.split(\"|\", 2);\r\n"
                + "                msg.select_number = Number(split_data[0]);\r\n"
                + "                this.send(msg);\r\n"
                + "            };\r\n"
                + "        component.on('input', function(msg) {\r\n"
                + "            callPython(msg);\r\n"
                + "        });\r\n"
                + "    }\r\n"
                + "    RED.nodes.registerType(\"" + componentName + "\"," + componentName + ");\r\n"
                + "}";
        return source;

    }
    

    public String createFiles(int model, int type) {
        String source = "";
        switch (type) {
            case DATA_F:
                source = "module.exports = function(RED) {\r\n"
                        + "    function " + hComponentName + "_Dataset(n) {\r\n"
                        + "        RED.nodes.createNode(this, n);\r\n"
                        + "        var node = this;\r\n"
                        + "        var callPython = function(msg) {\r\n";
                if (model == Linear) {
                    source += "            const rand = msg.payload ** 2 % 7;\r\n";
                } else {
                    source += "            const rand = msg.payload ** 2 % 10000;\r\n";
                }

                source += "            const spawn = require(\"child_process\").spawn;\r\n"
                        + "            const pythonProcess = spawn('python', [\"na-components/" + hComponentName + "/src/hnu/" + hComponentName + "-data.py\", rand]);\r\n"
                        + "            pythonProcess.stdout.on('data', function(data) {\r\n"
                        + "                sendFunction(Buffer.from(data, 'utf-8').toString());\r\n"
                        + "            });\r\n"
                        + "        }\r\n"
                        + "        var sendFunction = (data) => {\r\n"
                        + "            var msg = {};\r\n"
                        + "            console.log(data.toString());\r\n"
                        + "            msg.payload = data.replace('\\r\\n', '').toString();\r\n"
                        + "            split_data = data.split(\"|\", 2);\r\n";
                if (model == Linear) {
                    source += "            msg.x_data = Number(split_data[0]);\r\n"
                            + "            msg.y_data = Number(split_data[1]);\r\n";
                } else {
                    source += "            msg.select_number = Number(split_data[0]);\r\n";
                }

                source += "            msg.x_data = Number(split_data[0]);\r\n"
                        + "            msg.y_data = Number(split_data[1]);\r\n"
                        + "            this.send(msg);\r\n"
                        + "        };\r\n"
                        + "        var codeEditor = RED.NAIDE.codeEditor.init(this, {\r\n"
                        + "            codeText: n.codeText,\r\n"
                        + "            callbackFunc: function(c){}\r\n"
                        + "        });\r\n"
                        + "        this.on('input', function(msg, send, done) {\r\n";
                if (model == MNIST) {
                    source += "            console.log(msg);\r\n";
                }
                source += "            callPython(msg);\r\n"
                        + "            codeEditor.run(msg, send, done);\r\n"
                        + "        });\r\n"
                        + "        \r\n"
                        + "    }\r\n"
                        + "    RED.nodes.registerType(\"" + hComponentName + "-dataset\", " + hComponentName + "_Dataset);\r\n"
                        + "}";
                break;
            case IMP_F:
                source = "module.exports = function(RED) {\r\n"
                        + "    function " + hComponentName + "_Implement(n) {\r\n"
                        + "        RED.nodes.createNode(this, n);\r\n"
                        + "        var node = this;\r\n"
                        + "        var callPython = function(msg) {\r\n"
                        + "            const spawn = require(\"child_process\").spawn;\r\n"
                        + "            const pythonProcess = spawn('python', [\"na-components/" + hComponentName + "/src/hnu/" + hComponentName + "-imp.py\", ";
                if(model == MNIST)  source += "msg.payload, ";
                source += "msg.payload.toString()]);\r\n"
                        + "            pythonProcess.stdout.on('data', function(data) {\r\n"
                        + "                sendFunction(msg, Buffer.from(data, 'utf-8').toString());\r\n"
                        + "            });\r\n"
                        + "        }\r\n"
                        + "        var sendFunction = (msg, data) => {\r\n";
                if(model == MNIST) source += "            console.log(data);\r\n";
                source += "            if (data.includes(\"sim:\")) {\r\n"
                        + "                parse = data.replace('sim:', '').replace('\\r\\n', '').toString();\r\n"
                        + "                console.log(\"log: \", parse);\r\n"
                        + "                msg.payload = JSON.parse(parse);\r\n"
                        + "            }\r\n"
                        + "            else {\r\n";
                if(model == Linear){
                        source += "                msg.implement = parseFloat(msg.payload.replace('[', '').replace(']', ''));\r\n"
                        + "                msg.err_rate = msg.y_data - msg.implement;\r\n";
                }
                source += "                msg.payload = data;\r\n"
                        + "            }\r\n"
                        + "            this.send(msg);\r\n"
                        + "        };\r\n"
                        + "        node.on('input', function(msg) {\r\n"
                        + "            console.log(msg);\r\n"
                        + "            callPython(msg);\r\n"
                        + "        });\r\n"
                        + "        \r\n"
                        + "    }\r\n"
                        + "    RED.nodes.registerType(\"" + hComponentName + "-implement\", " + hComponentName + "_Implement);\r\n"
                        + "}";
                break;
            case PRINT_F:
                source = "module.exports = function(RED) {\r\n"
                        + "    function " + hComponentName + "_Print(n) {\r\n"
                        + "        RED.nodes.createNode(this, n);\r\n"
                        + "        var node = this;\r\n"
                        + "        var parseJson = (json, level=0) => {\r\n"
                        + "            res = \"\";\r\n"
                        + "            for(data in json) {\r\n"
                        + "                if (level == 0)\r\n"
                        + "                    res += \"[\" + data + \"]\" + '\\n';\r\n"
                        + "                if (typeof(json[data]) == \"object\"){\r\n"
                        + "                    res += parseJson(json[data], level + 1);\r\n"
                        + "                }\r\n"
                        + "                else {\r\n"
                        + "                    res += \"  \".repeat(level < 2 ? 1 : level);\r\n"
                        + "                    res += (level > 0 ? data + \" : \" + json[data] : json[data]) + '\\n';\r\n"
                        + "                }\r\n"
                        + "            }\r\n"
                        + "            return res;\r\n"
                        + "        };\r\n"
                        + "        var sendFunction = (msg) => {\r\n"
                        + "            // Debug / PkgMgr\r\n";
                if(model == Linear){
                    source += "        var sendFunction = (msg) => {\r\n"
                        + "            json = {\r\n"
                        + "                random_select_param:{x_data:msg.x_data, y_data:msg.y_data},\r\n"
                        + "                implement:msg.implement,\r\n"
                        + "                err_rate:msg.err_rate\r\n"
                        + "            }\r\n"
                        + "            debug = parseJson(json);\r\n"
                        + "            pkgmgr = \"\";\r\n"
                        + "            msg.payload = debug;\r\n"
                        + "            msg.pkgmgr = pkgmgr;\r\n"
                        + "                \r\n"
                        + "            }\r\n"
                        + "            else {\r\n"
                        + "                msg.payload = msg.sim_result;\r\n"
                        + "            }\r\n"
                        + "            this.send(msg);\r\n"
                        + "        };\r\n"
                        + "        node.on('input', function(msg) {\r\n"
                        + "            console.log(msg);\r\n"
                        + "            sendFunction(msg);\r\n"
                        + "        });\r\n";
            }
                else {
                    source += "            if (typeof(msg.sim_result) === \"undefined\") {\r\n"
                            + "                parse = msg.payload.split(\"\\r\\n\");\r\n"
                            + "                number_rate = {};\r\n"
                            + "                top_rate_number = null;\r\n"
                            + "                for(var data in parse){\r\n"
                            + "                    if (parse[data].includes(':')){\r\n"
                            + "                        n_data = parse[data].split(':');\r\n"
                            + "                        number_rate[n_data[0]] = Number(n_data[1]);\r\n"
                            + "                        top_rate_number = top_rate_number == null ? n_data[0] : number_rate[top_rate_number] < number_rate[n_data[0]] ? n_data[0] : top_rate_number\r\n"
                            + "                    }\r\n"
                            + "                }\r\n"
                            + "                json = {\r\n"
                            + "                    random_select_param:msg.select_number,\r\n"
                            + "                    top_rate_number:top_rate_number,\r\n"
                            + "                    number_rate:number_rate\r\n"
                            + "                }\r\n"
                            + "                console.log(json);\r\n"
                            + "                debug = parseJson(json);\r\n"
                            + "                pkgmgr = \"\";\r\n"
                            + "                msg.payload = debug;\r\n"
                            + "                msg.pkgmgr = pkgmgr;\r\n"
                            + "            }\r\n"
                            + "            else {\r\n"
                            + "                msg.payload = msg.sim_result;\r\n"
                            + "            }\r\n"
                            + "            this.send(msg);\r\n"
                            + "        };\r\n"
                            + "        codeEditor = RED.NAIDE.codeEditor.init(this, {\r\n"
                            + "            codeText: n.codeText,\r\n"
                            + "            callbackFunc: function(c){\r\n"
                            + "                //sendFunction(c.msg);\r\n"
                            + "            }\r\n"
                            + "        })\r\n"
                            + "        node.on('input', function(msg, send, done) {\r\n"
                            + "            console.log(msg);\r\n"
                            + "            codeEditor.run(msg, send, done);\r\n"
                            + "        });\r\n";
                }             

                source += "        \r\n"
                        + "    }\r\n"
                        + "    RED.nodes.registerType(\"" + hComponentName + "-print\", " + hComponentName + "_Print);\r\n"
                        + "}";
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
       hFileName[0] = prjDir + "-dataset.js";
       hFileName[1] = prjDir + "-implement.js";
       hFileName[2] = prjDir + "-print.js";
       
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
                hBR.close();
                hFR.close();
            }
            if(hPW!=null && hBW!=null && hFW!=null){
                hPW.close();
                hBW.close();
                hFW.close(); 
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

