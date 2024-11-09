/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.inha.generator.iot;

import org.iesw.inha.generator.HGenerator;
import static org.iesw.inha.generator.HGenerator.H_IoT;
import static org.iesw.inha.generator.HGenerator.hSTATE;
import org.iesw.inha.ioconfig.iot.HIoTConfig;
import org.iesw.inha.ioconfig.iot.HIoTPinConfig;

/**
 *
 * @author jjh
 */
public class HIoTGeneratorArduino extends HGenerator {
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
    public HIoTConfig hICfg;
    private HIoTPinConfig[] hIPCfg;
    public String modelDir="";
    public String componentName="";
    public int flagIot_Type =0;
    int numPin = 0;
    int num[];
    String name[];
    String type_pin[];
    String addPinSource = "";
    public int board =0;
    enum pin_Color{
        green, yellow, red, blue, orange        
    }
    public HIoTGeneratorArduino(){
        super();
    }
    
    public void initGenerator(String hDirectory){
        hSTATE = H_IoT;

        this.modelDir = hDirectory;
        initConfig(hICfg, modelDir);
        createFileArduino(this.modelDir);
        writeIoTGen();
    }
       public void set_config(int pin, String name, String type_name, int flagIotType, int check_board){
        hICfg = new HIoTConfig(pin,name,type_name,flagIotType, check_board);
        flagIot_Type = flagIotType;
        board = check_board;
    }
    public void initConfig(HIoTConfig HIoTConfig, String mDir){
        modelDir=mDir;       
        String componentNameT[] =mDir.split("\\\\");
        for(int i=0; i<componentNameT.length; i++){
            if(i+1==componentNameT.length)
                componentName = componentNameT[i];
        }
        hICfg = HIoTConfig;
        dataSetOpt = hICfg.getData_opt();
        flagIot_Type = HIoTConfig.getFlagIoT();
    }
    public void setNumPin(int numPin){
        hIPCfg = new HIoTPinConfig[numPin];
        this.numPin = numPin;
    }
    
    public void addPinConfig(int pinN, HIoTPinConfig hIoTPinConfig){
        hIPCfg[pinN] = hIoTPinConfig;
        int cnt=0;
        for(int i=0; i<numPin; i++){
            if(hIPCfg[i] != null){
                cnt+=1;
            }
        }
        if(cnt >= numPin){
            setAddPin(hIPCfg);
        } 
    }
    public void writeIoTGen(){
         writeFile(Arduino());   
         
    }
     public String Arduino(){
         pin_Color color[] = pin_Color.values();
        String source = "";
        if(flagIot_Type == H_IoT_LED){
            source += "int num;\r\n"+
                "void setup(){\r\n"+
                "    Serial.begin(9600);\r\n";
        for(int i=0;i<numPin;i++){
            source += "    pinMode("+num[i]+",OUTPUT);\r\n"+
                    "    digitalWrite("+num[i]+",LOW);\r\n";                    
        }
        source += "}\r\n";
        source += "\r\nvoid loop(){\r\n"+
                "    while(Serial.available()){\r\n"+
                "        num = Serial.parseInt();\r\n"+
                "    }\r\n"+
                "String res = \"none\";\r\n"+
                "if (num>=0 and num<=3){\r\n"+
                "    res = \"green\";\r\n"+
                "    }\r\n"+
                "else if (num<=6){\r\n"+
                "    res = \"yellow\";\r\n"+
                "    }\r\n"+
                "else if(num<=9){\r\n"+
                "    res = \"red\";\r\n"+
                "    }\r\n";
         for(int i=0;i<numPin;i++){
              if(i==0){
                        source += "if(res == \""+color[i]+"\"){\r\n";
                    }else{
                        source += "else if(res ==  \""+color[i]+" \"){\r\n";
                    }
             for(int j=0; j<numPin;j++){
                  if(i==j){
                          source += "    digitalWrite("+num[j]+",HIGH);\r\n";
                     }else{
                         source += "    digitalWrite("+num[j]+", LOW);\r\n";
                     }
             }
             source += "    }\r\n";
        }        
         source += "}\r\n";
         }
      else if(flagIot_Type == H_IoT_7Segment){
          String pinNum = "";
          for(int i=0;i<numPin;i++){
              pinNum += name[i];
              if(i!=numPin-1){
                  pinNum+=",";
              }             
          }
          source += "int num;\r\n";
          /*
          for(int i=0;i<numPin;i++){
              source += "int pin"+i+"="+num[i]+";\r\n";
          }
          */
          source +=  "byte Seven[10][7]=\r\n"+
                    "    {{1,1,1,1,1,1,0},\r\n"+
                    "    {0,1,1,0,0,0,0},\r\n"+
                    "    {1,1,0,1,1,0,1},\r\n"+
                    "    {1,1,1,1,0,0,1},\r\n"+
                    "    {0,1,1,0,0,1,1},\r\n"+
                    "    {1,0,1,1,0,1,1},\r\n"+
                    "    {0,0,1,1,1,1,1},\r\n"+
                    "    {1,1,1,0,0,1,0},\r\n"+
                    "    {1,1,1,1,1,1,1},\r\n"+
                    "    {1,1,1,0,0,1,1}};\r\n\n\n";
          source += "void setup(){\r\n";
        for(int i=0;i<numPin;i++){
            source += "    pinMode("+num[i]+",OUTPUT);\r\n";
        }
          source += "    Serial.begin(9600);\r\n}\r\n"+
                  "void loop(){\r\n"+
                  "    if(Serial.available()){\r\n"+
                  "        num = Serial.parsInt();\r\n    }\r\n"+
                "    displayDigit(num);\r\n"+
                  "    delay(100);\r\n}\r\n";

        source += "void displayDigit(int val){\r\n"+
                "    int pin ="+num[0] +";\r\n"+
                "    for(int i=0; i<7; i++){\r\n"+
                "        digitalWrite(pin+i, Seven[num][i]);\r\n"+
                "    }\r\n"+
                "}\r\n";
      }
        return source;
    }
     public void setAddPin(HIoTPinConfig[] hIPCfg_p){
        int i;
        num = new int[numPin];
        name = new String[numPin];  
        type_pin = new String[numPin];
        for(i=0; i<numPin; i++){
            num[i]=hIPCfg_p[i].getNum();
            name[i]=hIPCfg_p[i].getName();
            type_pin[i] =hIPCfg_p[i].getTypePin();
        }
     }
}
