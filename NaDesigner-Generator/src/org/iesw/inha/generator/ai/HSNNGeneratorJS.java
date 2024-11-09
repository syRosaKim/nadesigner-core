/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.inha.generator.ai;

import org.iesw.inha.generator.HAIGenerator;
import org.iesw.inha.generator.HGenerator;
import static org.iesw.inha.generator.HGenerator.H_IoT;
import static org.iesw.inha.generator.HGenerator.hSTATE;
import org.iesw.inha.ioconfig.iot.HIoTConfig;
import org.iesw.inha.ioconfig.iot.HIoTPinConfig;

/**
 *
 * @author jjh
 */
public class HSNNGeneratorJS extends HAIGenerator {
    public static final int H_SNN = 1;    
    public static final int H_ANN = 2;    
    public static final int H_IoT = 3;
    
    public static final int H_IoT_PICamera = 1;  
    public static final int H_IoT_7Segment = 2;   
    public static final int H_IoT_LED = 3;  
    public static final int H_IoT_GPIO = 4;   
    public static final int H_IoT_USBCamera = 5;  
    public int dataSetOpt=-1;
    public static final int rspi = 1;
    public static final int nano = 2;
    public static final int coral = 3;
    public static final int tinker =4;
    public static final int panda = 5; 
    
    private int hState = 0;
    
    public HIoTConfig hICfg;
    private HIoTPinConfig[] hIPCfg;
    public String modelDir="";
    public String componentName="";
    public int flagIotType =0;
    int numPin = 0;
    int num[];
    String nnFile ="";
    String name[];
    String type_pin[];
    String addPinSource = "";
    public int board =0;

    public HSNNGeneratorJS(){
        super();
    }
    
    public void initGenerator(String hDirectory){
        hSTATE = H_SNN;
        this.modelDir = hDirectory;
        initConfig(hICfg, modelDir);
        createFileJS(this.modelDir);
        writeIoTGen();
    }
       public void set_configDe1(int flag){
        hICfg = new HIoTConfig(flag);
        hSTATE = H_SNN;
    }
    public void initConfig(HIoTConfig HIoTConfig, String mDir){
        modelDir=mDir;       
        String componentNameT[] =mDir.split("\\\\");
        for(int i=0; i<componentNameT.length; i++){
            if(i+1==componentNameT.length)
                componentName = componentNameT[i];
        }
    }
    public void writeIoTGen(){
         writeFile(CreateJS());            
    }
     public String CreateJS(){
         String source="";
        nnFile ="snn-component";
        if(hState == H_IoT)
            nnFile = "iot-component";
        else if(hState == H_ANN)
            nnFile = "ann-component";
        
        source += "module.exports = function(RED) {\r\n" +
"    function "+componentName+"(config) {\r\n" +
"       RED.nodes.createNode(this, config);\r\n" +
"        var component = this;\r\n" +
"        var callPython = function(msg) {\r\n"+
"        const data = msg.payload;\r\n";
        if(board == coral || board == tinker){
            source += "//npm install sudo-js --save 필요\r\n"+
"            const sudo = require('sudo-js');\r\n"+
"            sudo.setPassword('1234');//board password \r\n"+
"            sudo.exec([\"python3\",`${__dirname}/"+nnFile+".py`,data],function(err,pid,data){\r\n"+
"                sendFunction(Buffer.from(data, 'uft-8').toString());\r\n"+
"            });\r\n"+
"           };\r\n";
        }
        else {
            source +="//rspi && jetson nano && panda\r\n"+
"            const spawn = require(\"child_process\").spawn;\r\n";
                source += "            const pythonProcess = spawn('python3',[\"na-components/NAAL/"+componentName+"/src/hnu/"+nnFile+".py\",data]);\r\n";
        source += "            pythonProcess.stdout.on('data', function(data) {\r\n" +
"                sendFunction(Buffer.from(data, 'utf-8').toString());\r\n" +
"            });\r\n" +
"        };\r\n";
        }
source +="        var sendFunction = (data) => {\r\n" +
"                var msg = {};\r\n" +
"                msg.payload = data.replace('\\r\\n', '').toString();\r\n" +
"                split_data = data.split(\"|\", 2);\r\n" +
"                msg.select_number = Number(split_data[0]);\r\n" +
"                this.send(msg);\r\n" +
"            };\r\n" +
"        component.on('input', function(msg) {\r\n" +
"            callPython(msg);\r\n" +
"        });\r\n" +
"    };\r\n" +
"    RED.nodes.registerType(\""+componentName+"\","+componentName+");\r\n" +
"}\r\n";
        return source;
    }

}
