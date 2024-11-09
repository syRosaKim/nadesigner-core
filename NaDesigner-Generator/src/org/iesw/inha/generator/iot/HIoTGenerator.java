package org.iesw.inha.generator.iot;

import org.iesw.inha.generator.HGenerator;
import org.iesw.inha.generator.iot.HIoTGenerator.pin_Color;
import org.iesw.inha.ioconfig.iot.HIoTConfig;
import org.iesw.inha.ioconfig.iot.HIoTPinConfig;

public class HIoTGenerator extends HGenerator {
    public static final int H_IoT_PICamera = 1;  
    public static final int H_IoT_7Segment = 2;   
    public static final int H_IoT_LED = 3;  
    public static final int H_IoT_GPIO = 4;   
    public static final int H_IoT_USBCamera = 5;  
    public static final int H_IoT_Mic = 6; 
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
    public int flagIotType =0;
    int numPin = 0;
    int num[];
    String name[];
    String type_pin[];
    String addPinSource = "";
    String micChannels;
    String recordTime;
    public int board =0;
    enum pin_Color{
        green, yellow, red, blue, orange        
    }
    public HIoTGenerator(){
        super();
    }
    
    public void initGenerator(String hDirectory){
        hSTATE = H_IoT;
        this.modelDir = hDirectory;
        initConfig(hICfg, modelDir);
        createFile(this.modelDir);
        writeIoTGen();
    }
    public void set_config(int pin, String name, String type_name, int flagIotType, int check_board){
        hICfg = new HIoTConfig(pin,name,type_name,flagIotType, check_board);
        board = check_board;
    }
    
    public void set_config(int pin, int dutyCycle, int duration, int flagIotType){
        hICfg = new HIoTConfig(pin, dutyCycle, duration,flagIotType);
    }
    public void set_configPI( String resolution, int captureTime, String resizeResolution, int flagIotType){
        hICfg = new HIoTConfig(resolution, captureTime, resizeResolution, flagIotType);
    }
     public void set_configUSBCamera( String resolution, String resizeResolution, int flagIotType){
        hICfg = new HIoTConfig(resolution, resizeResolution, flagIotType);
    }
    public void set_configMic(int flagIotType,String micChannels, String recordTime){
        hICfg = new HIoTConfig(flagIotType, micChannels, recordTime);
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
        flagIotType = HIoTConfig.getFlagIoT();
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
        if(flagIotType == H_IoT_Mic){
             writeFile(importLibMic());
             writeFile(functionMic());
             writeFile(runMic());
        }
        else if(flagIotType==H_IoT_7Segment){
            if(board == coral){
                writeFile(importCoralLibrary());
                writeFile(coralSeg());
                writeFile(setParameter());
                 writeFile(parsingData());
                writeFile(segmentSetup());
                writeFile(setStart());
            }
            else if(board==tinker){
                writeFile(importTinkerLibrary());
                writeFile(PlSeg());
                writeFile(setParameter());
                writeFile(parsingData());
                writeFile(segmentSetup());
                writeFile(setStart());
            }
            else if(board == panda){
                writeFile(importPandaLibrary());
                writeFile(Arduino_start());
            }
            else{
                writeFile(importLibrary());
                writeFile(PlSeg());
                writeFile(setParameter());
                writeFile(parsingData());
                writeFile(segmentSetup());
                writeFile(setStart());
            }

        }
        else if(flagIotType==H_IoT_PICamera){
            writeFile(PiCameraImportLibrary());
            writeFile(PiSetParameter());
            writeFile(setPiImage());
        }
        else if(flagIotType==H_IoT_USBCamera){
           writeFile(USBCameraImportLibrary());
           writeFile(USBCamerParameter());
           writeFile(setUSBCameraStart());    
              
        }
        else if(flagIotType==H_IoT_LED) {
            if(board==coral){
                 writeFile(importCoralLibrary());
                writeFile(setParameter());
                writeFile(setSetup());
                writeFile(setStart());
            }
            else if(board==tinker){
                writeFile(importTinkerLibrary());
                writeFile(setParameter());
                writeFile(setSetup());
                writeFile(setStart());
            }
            else if(board == panda){
                writeFile(importPandaLibrary());
                writeFile(Arduino_start());
            }
            else{
                 writeFile(importLibrary());
                writeFile(setParameter());
                writeFile(setSetup());
                writeFile(setStart());
            }
        }
    }
    public String PiCameraImportLibrary(){
        String source = "import io\r\n" +
        "import sys\r\n" +
        "from PIL import Image\r\n" +
        "import picamera\r\n" +
        "import time\r\n" +
        "import numpy as np\r\n\r\n";
        return source;
    }
    public String PiSetParameter(){
        String source = "stream = io.BytesIO()\r\n" +
        "with picamera.PiCamera() as camera:\r\n" +
        "\r\n" +
        "    camera.resolution = ("+hICfg.getResolution()+")\r\n" +
        "    camera.color_effects = (128,128)\r\n" +
        "    camera.start_preview()\r\n" +
        "    time.sleep("+hICfg.getSleepPI()+")\r\n" +
        "    camera.capture(stream,format='png')\r\n" +
        "stream.seek(0)\r\n\r\n";
        return source;
    }
    public String setPiStart(){
        String source = "camera.start_preview()\r\n"+
                        "time.sleep("+hICfg.getSleepPI()+")\r\n"+
                        "camera.stop_preview()\r\n"+
                        "camera.close()\r\n";
        return source;
    }
    
    public String setPiImage(){
        String[] resizeTemp = hICfg.getResizeResolution().split(",");
        int resizeInt= Integer.parseInt(resizeTemp[0]);
        
        String source = "image = Image.open(stream)\r\n" +
                "image = image.convert('L')\r\n" +
                "image = np.array(image)\r\n" +
                "image = Image.fromarray(image)\r\n" +
                "image = image.resize(("+hICfg.getResizeResolution()+"))\r\n" +
                "image = np.array(image)\r\n" +
                "image = np.resize(image, (1, "+(resizeInt*resizeInt)+"))\r\n" +
                "print(image)\r\n"+
                "sys.stdout.flush()\r\n";
        return source;
    }
    
    public String USBCameraImportLibrary(){
        String source = "import io\r\n" +
        "import sys\r\n" +
        "import cv2\r\n" +
        "from PIL import Image\r\n" +
        "import time\r\n" +
        "import numpy as np\r\n\r\n";
        return source;
    }
    public String USBCamerParameter(){
         String source = "";
        if(board == panda){
            source = "cam = cv2.VideoCapture(0,cv2.CAP_DSHOW)\r\n"+
                        "cam.set(3,112)\r\n"+
                        "cam.set(4,112)\r\n";
        }else{
            source = "cam = cv2.VideoCapture(0)\r\n"+
                        "cam.set(3,112)\r\n"+
                        "cam.set(4,112)\r\n";
        }
       
        return source;
    }
     public String setUSBCameraStart(){
        String source = "while True:\r\n"+
                        "    ret_val, img = cam.read()\r\n"+
                        "    img = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)\r\n"+
                        "    cv2.imshow('CamViewr',img)\r\n"+
                        "    if cv2.waitKey(1) == 27:\r\n"+
                        "        cv2.imwrite('image.png',img)\r\n"+
                        "        break\r\n"+
                       "image = Image.open('image.png')\r\n" +
                       "image = image.convert('L')\r\n" +
                       "image = np.array(image)\r\n" +
                       "image = Image.fromarray(image)\r\n" +
                       "image = image.resize(("+hICfg.getResizeResolution()+"))\r\n" +
                       "image = np.array(image)\r\n" +
                       "image = np.resize(image, (1,196))\r\n" +
                       "print(image)\r\n"+
                       "sys.stdout.flush()\r\n";
        return source;
    }
    public String importLibrary(){
        String source = "import os\r\n" + 
                         "import sys\r\n" +
                         "import RPi.GPIO as GPIO\r\n" +
                         "from time import sleep\r\n\n"+
                         "GPIO.setwarnings(False)\r\n"+
                         "GPIO.setmode(GPIO.BOARD)\r\n\n"; 
        return source;
     }
    public String importTinkerLibrary(){
        String source = "import os\r\n" + 
                         "import sys\r\n" +
                         "import ASUS.GPIO as GPIO\r\n" +
                         "GPIO.setwarnings(False)\r\n"+
                         "GPIO.setmode(GPIO.ASUS)\r\n\n"; 
        return source;
     }
      public String importCoralLibrary(){
        String source = "import os\r\n" + 
                         "import sys\r\n" +
                         "from periphery import GPIO\r\n"; 
        return source;
     }
       public String importPandaLibrary(){
        String source = "import os\r\n" + 
                         "import sys\r\n" +
                         "import serial\r\n"; 
        return source;
     }
    public String setParameter(){
            String source = "";
            if(flagIotType==H_IoT_7Segment){
                for(int i=0;i<numPin;i++){
                    source += name[i] +" = " + num[i]+"\r\n";
                    if(board == coral){
                        source += name[i] +" = GPIO("+name[i]+", \"out\")\r\n";
                }
                }               
            }/*
            if(flagIotType==H_IoT_LED){
                source = "pinNumber = " + hICfg.getGpioPin() + "\r\n"+
                        "dutyCycle = " + hICfg.getDutyCycle() + "\r\n"+
                        "durationTime = "+hICfg.getDurationTime() +"\r\n\n\n";
            }*/
            if(flagIotType==H_IoT_LED){
                 for(int i=0;i<numPin;i++){
                     source += name[i]+ " = "+num[i]+"\r\n";                              
                 }
            }
            return source;
    }
    public String coralSeg(){
        String source = "";
        source += "def display_seg(index):\r\n"+
                           "    for i in range(0,8):\r\n"+
                           "        if(index == 0):\r\n"+
                           "            if(i==6):\r\n"+
                           "                segments[i].write(False)\r\n"+
                           "            else:\r\n"+
                           "                segments[i].write(True)\r\n\r\n"+
                           "        if(index == 1):\r\n"+
                           "            if(i==1 or i==2):\r\n"+
                           "                segments[i].write(True)\r\n"+
                           "            else:\r\n"+
                           "                segments[i].write(False)\r\n\r\n"+
                           "        if(index == 2):\r\n"+
                           "            if(i==2 or i==5):\r\n"+
                           "                segments[i].write(False)\r\n"+
                           "            else:\r\n"+
                           "                segments[i].write(True)\r\n\r\n"+
                           "        if(index == 3):\r\n"+
                           "            if(i==4 or i==5):\r\n"+
                           "                segments[i].write(False)\r\n"+
                           "            else:\r\n"+
                           "                segments[i].write(True)\r\n\r\n"+
                           "        if(index == 4):\r\n"+
                           "            if(i==0 or i==3 or i==4):\r\n"+
                           "                segments[i].write(False)\r\n"+
                           "            else:\r\n"+
                           "                segments[i].write(True)\r\n\r\n"+
                           "        if(index == 5):\r\n"+
                           "            if(i==1 or i==4):\r\n"+
                           "                segments[i].write(False)\r\n"+
                           "            else:\r\n"+
                           "                segments[i].write(True)\r\n\r\n"+
                           "        if(index == 6):\r\n"+
                           "            if(i==0 or i==1):\r\n"+
                           "                segments[i].write(False)\r\n"+
                           "            else:\r\n"+
                           "                segments[i].write(True)\r\n\r\n"+
                           "        if(index == 7):\r\n"+
                           "            if(i==3 or i==4 or i==5 or i==6):\r\n"+
                           "                segments[i].write(False)\r\n"+
                           "            else:\r\n"+
                           "                segments[i].write(True)\r\n\r\n"+
                           "        if(index == 8):\r\n"+
                           "            segments[i].write(True)\r\n\r\n"+
                           "        if(index == 9):\r\n"+
                           "            if(i==3 or i==4):\r\n"+
                           "                segments[i].write(False)\r\n"+
                           "            else:\r\n"+
                           "                segments[i].write(True)\r\n\r\n";       
       return source;
    }
    public String PlSeg(){
        String source = "";
        source += "def display_seg(index):\r\n"+
                           "    for i in range(0,8):\r\n"+
                           "        if(index == 0):\r\n"+
                           "            if(i==6):\r\n"+
                           "                GPIO.output(segments[i], GPIO.LOW)\r\n"+
                           "            else:\r\n"+
                           "                GPIO.output(segments[i], GPIO.HIGH)\r\n\r\n"+
                           "        if(index == 1):\r\n"+
                           "            if(i==1 or i==2):\r\n"+
                           "                GPIO.output(segments[i], GPIO.HIGH)\r\n"+
                           "            else:\r\n"+
                           "               GPIO.output(segments[i], GPIO.LOW)\r\n\r\n"+
                           "        if(index == 2):\r\n"+
                           "            if(i==2 or i==5):\r\n"+
                           "                GPIO.output(segments[i], GPIO.LOW)\r\n"+
                           "            else:\r\n"+
                           "                GPIO.output(segments[i], GPIO.HIGH)\r\n\r\n"+
                           "        if(index == 3):\r\n"+
                           "            if(i==4 or i==5):\r\n"+
                           "                GPIO.output(segments[i], GPIO.LOW)\r\n"+
                           "            else:\r\n"+
                           "                GPIO.output(segments[i], GPIO.HIGH)\r\n\r\n"+
                           "        if(index == 4):\r\n"+
                           "            if(i==0 or i==3 or i==4):\r\n"+
                           "                GPIO.output(segments[i], GPIO.LOW)\r\n"+
                           "            else:\r\n"+
                           "                GPIO.output(segments[i], GPIO.HIGH)\r\n\r\n"+
                           "        if(index == 5):\r\n"+
                           "            if(i==1 or i==4):\r\n"+
                           "                GPIO.output(segments[i], GPIO.LOW)\r\n"+
                           "            else:\r\n"+
                           "                GPIO.output(segments[i], GPIO.HIGH)\r\n\r\n"+
                           "        if(index == 6):\r\n"+
                           "            if(i==0 or i==1):\r\n"+
                           "                GPIO.output(segments[i], GPIO.LOW)\r\n"+
                           "            else:\r\n"+
                           "                GPIO.output(segments[i], GPIO.HIGH)\r\n\r\n"+
                           "        if(index == 7):\r\n"+
                           "            if(i==3 or i==4 or i==5 or i==6):\r\n"+
                           "                GPIO.output(segments[i], GPIO.LOW)\r\n"+
                           "            else:\r\n"+
                           "                GPIO.output(segments[i], GPIO.HIGH)\r\n\r\n"+
                           "        if(index == 8):\r\n"+
                           "            GPIO.output(segments[i], GPIO.HIGH)\r\n\r\n"+
                           "        if(index == 9):\r\n"+
                           "            if(i==3 or i==4):\r\n"+
                           "                GPIO.output(segments[i], GPIO.LOW)\r\n"+
                           "            else:\r\n"+
                           "                GPIO.output(segments[i], GPIO.HIGH)\r\n\r\n";       
       return source;
    }
    public String segmentSetup(){
        String pinNum ="";
        String source = "";
          for(int i=0;i<numPin;i++){
              pinNum += name[i];
              if(i!=numPin-1){
                  pinNum+=",";
              }             
          }
        if(board == panda){
            
        }
        else{
            if(board == rspi || board == nano || board == tinker){/*
                source += "segments = ("+pinNum+")\r\n"+
                          "for segment in segments:\r\n"+
                          "    GPIO.setupt(segment,GPIO.OUT)\r\n"+
                          "    GPIO.output(segment, 0)\r\n"+
                          "num = {'':(0,0,0,0,0,0,0),\r\n"+
                            "    '0':(1,1,1,1,1,1,0),\r\n"+
                            "    '1':(0,1,1,0,0,0,0),\r\n"+
                            "    '2':(1,1,0,1,1,0,1),\r\n"+
                            "    '3':(1,1,1,1,0,0,1),\r\n"+
                            "    '4':(0,1,1,0,0,1,1),\r\n"+
                            "    '5':(1,0,1,1,0,1,1),\r\n"+
                            "    '6':(0,0,1,1,1,1,1),\r\n"+
                            "    '8':(1,1,1,1,1,1,1),\r\n"+
                            "    '9':(1,1,1,0,0,1,1)}\r\n\n";   */
                source += "segments = ("+pinNum+")\r\n"+
                          "for i in range(0,8):\r\n"+
                          "    GPIO.output(segments[i],GPIO.LOW)\r\n";
            }
            else if(board == coral){
                source += "segments = ("+pinNum+")\r\n"+
                          "for i in range(0,8):\r\n"+
                          "    segments[i].write(False)\r\n"+
                          "try:\r\n"+
                          "    display_seg(index)\r\n"+
                          "finally:\r\n"+
                          "    pass\r\n";
            }
                
        }             
            return source;
    }
    public String parsingData(){
        String source = "index = sys.argv[1]\r\n"+
                        "index = index.replace(\"\\n\",\"\")\r\n"+
                        "index = int(index)\r\n"+
                        "print(\"result: \",index)\r\n"+
                        "sys.stdout.flush()\r\n";
            return source;
    }
    public String setSetup(){
        String source = "";
        for(int i=0;i>numPin;i++){
            if(flagIotType==H_IoT_7Segment){

           }
            else if(type_pin[i]=="IN"){
                source += "GPIO.setup("+name[i]+","+type_pin[i]+","+"pull_up_down=GPIO.PUD_UP\r\n";
            }
            else if(type_pin[i]=="OUT"){
                source += "GPIO.setup("+name[i]+","+type_pin[i]+","+"initial=GPIO.LOW\r\n";
            }
            if(flagIotType==H_IoT_LED){
                source ="GPIO.setup("+hICfg.getGpioPin()+","+"GPIO.OUT"+", initial=GPIO.LOW)\r\n";
            }
        }
        return source;
    }
    public String setStart(){
        String source = "";
        if(flagIotType==H_IoT_7Segment){
            if(board == coral){
            }
            else{
                /*
                source ="try:\r\n"+
                        "    s = index\r\n"+
                        "    for loop in range(0,7):\r\n"+
                        "        GPIO.output(segments[loop],num[s][loop])\r\n"+
                        "finally:\r\n"+
                        "    pass";
                */
                source += "try:\t\n"+
                          "    display_seg(index)\r\n"+
                          "finally:\r\n"+
                          "    pass";
            }
        }
        else if(flagIotType==H_IoT_LED){
            pin_Color color[] = pin_Color.values();
            String pin_h = "GPIO.HIGH";
            String pin_l = "GPIO.LOW"; 
            if(board == coral){
               for(int i=0;i<numPin;i++){
                   source += name[i]+ " = GPIO("+name[i]+",\"out\")\r\n"; 
               }        
           }
           else{
             for(int i=0;i<numPin;i++){
                    source += "GPIO.setup("+name[i]+","+"GPIO.OUT)\r\n";
                }         
           }
             source += "num = sys.argv[1]\r\n"+
                     "num = num.replace(\"\\n\",\"\")\r\n"+
                     "num = int(num)\r\n"+
                     "res = \"none\"\r\n"+
                     "if (num>=0 and num<=3):\r\n"+
                     "    res = \"green\"\r\n"+
                     "elif (num<=6):\r\n"+
                     "    res = \"yellow\"\r\n"+
                     "elif(num<=9):\r\n"+
                     "    res = \"red\"\r\n"+
                     "print(res)\r\n"+
                     "sys.stdout.flush()\r\n";    
             if(board == coral){
                for(int i=0;i<numPin;i++){
                    if(i==0){
                        source += "if(res == "+color[i]+"):\r\n";
                    }else{
                        source += "elif(res == "+color[i]+"):\r\n";
                    }
                    for(int j=0;j<numPin;j++){
                     if(i==j){
                          source +="    "+name[j]+".write(True)\r\n";
                     }else{
                         source += "    "+name[j]+".write(False)\r\n";
                     }
                 }
                }
             }
             else{
                 for(int i=0;i<numPin;i++){
                    if(i==0){
                        source += "if(res == "+color[i]+"):\r\n";
                    }else{
                        source += "elif(res == "+color[i]+"):\r\n";
                    }
                 for(int j=0;j<numPin;j++){
                     if(i==j){
                          source += "    GPIO.output("+name[j]+","+pin_h+")\r\n";
                     }else{
                         source += "    GPIO.output("+name[j]+","+pin_l+")\r\n";
                     }
                 }
             }          
             
           }
           
             /*
                     for(int j=0; j<numPin;j++){
                         if(j==0){
                            source += "    GPIO.output("+name[j]+","+pin_h+")\r\n";
                         }else{
                             source += "    GPIO.output("+name[j]+","+pin_l+")\r\n";
                         }
                     }
                     source += "elif(res == \"yellow\"):\r\n";
                    for(int j=0; j<numPin;j++){
                         if(j==1){
                            source += "    GPIO.output("+name[j]+","+pin_h+")\r\n";
                         }else{
                             source += "    GPIO.output("+name[j]+","+pin_l+")\r\n";
                         }
                     }
                     source += "elif(res == \"red\"):\r\n";
                   for(int j=0; j<numPin;j++){
                         if(j==2){
                            source += "    GPIO.output("+name[j]+","+pin_h+")\r\n";
                         }else{
                             source += "    GPIO.output("+name[j]+","+pin_l+")\r\n";
                         }
                     }
             */
                    /*
                     "    GPIO.output("+name[0]+", GPIO.HIGH)\r\n"+
                     "    GPIO.output(pin_number_y, GPIO.LOW)\r\n"+
                     "    GPIO.output(pin_number_r, GPIO.LOW)\r\n"+
                     "elif(res == \"yellow\"):\r\n"+
                     "    GPIO.output(pin_number_g, GPIO.LOW)\r\n"+
                     "    GPIO.output(pin_number_y, GPIO.HIGH)\r\n"+
                     "    GPIO.output(pin_number_r, GPIO.LOW)\r\n"+
                      "elif(res == \"red\"):\r\n"+
                     "    GPIO.output(pin_number_g, GPIO.LOW)\r\n"+
                     "    GPIO.output(pin_number_y, GPIO.LOW)\r\n"+
                     "    GPIO.output(pin_number_r, GPIO.HIGH)\r\n";
             */
        }
        else if(flagIotType==H_IoT_GPIO){
            for(int i=0;i<numPin;i++){
                source = "while True:\r\n"+
                            "    state = GPIO.input("+name[i]+")\r\n"+
                            "    if(state != c_state)\r\n"+
                            "        c_state = GPIO.input("+name[i] +")\r\n"+
                            "        print(state)\r\n"+
                            "        sys.stdout.flush()";
            }
        }
        return source;
    }
    
    public String Arduino_start(){
          String source = "";
                source += "ser = serial.Serial('COM6',9600)\r\n"+
                        "num = sys.argv[1]\r\n"+
                        "num = num.replace(\"\\n\",\"\")\r\n"+
                        "if(ser.readable()):\r\n"+
                        "    num = num.encode('utf-8')\r\n"+
                        "    ser.write(num)\r\n";
        return source;
    }

    public String importLibMic(){
          String source = "";
                source += "import os\r\n"+
                          "import glob\r\n"+
                          "import pyaudio\r\n"+
                        "import wave\r\n"+
                        "import scipy.io.wavfile\r\n\r\n";
        return source;
 }
    public String functionMic(){
          String source = "";
                source += "def record_voice(path = \"/na-components/NAAL/NAAL_Model_Prediction/src/hnu/voice_rec.wav\"):\r\n" +
"    po = pyaudio.PyAudio()\r\n\r\n" +
"    for index in range(po.get_device_count()): \r\n\r\n" +
"        desc = po.get_device_info_by_index(index)\r\n\r\n" +
"        if \"USB\" in desc[\"name\"] or \"usb\" in desc[\"name\"]:\r\n" +
"            mic_index = index\r\n\r\n" +
"    FORMAT = pyaudio.paInt16\r\n" +
"    CHANNELS = "+hICfg.getmicChannels()+"\r\n" +
"    RATE = 44100\r\n" +
"    CHUNK = 1024\r\n" +
"    RECORD_SECONDS = "+hICfg.getrecordTime()+"\r\n" +
"    WAVE_OUTPUT_FILENAME = path\r\n" +
"    audio = pyaudio.PyAudio()\r\n\r\n" +
"    # start Recording\r\n" +
"    stream = audio.open(format=pyaudio.paInt16, \r\n" +
"                    channels=CHANNELS, \r\n" +
"                    rate=RATE, \r\n" +
"                    input=True, \r\n" +
"                    input_device_index=mic_index,\r\n" +
"                    frames_per_buffer=CHUNK)\r\n" +
"    print(\"recording...\")\r\n\r\n" +
"    frames = []\r\n\r\n" +
"    for i in range(0, int(RATE / CHUNK * RECORD_SECONDS)):\r\n" +
"        data = stream.read(CHUNK, exception_on_overflow = False)\r\n" +
"        frames.append(data)\r\n\r\n" +
"    print(\"finished recording\")\r\n\r\n" +
"    # stop Recording]\r\n" +
"    stream.stop_stream()\r\n" +
"    stream.close()\r\n" +
"    audio.terminate()\r\n\r\n" +
"    waveFile = wave.open(WAVE_OUTPUT_FILENAME, 'wb')\r\n" +
"    waveFile.setnchannels(CHANNELS)\r\n" +
"    waveFile.setsampwidth(audio.get_sample_size(FORMAT))\r\n" +
"    waveFile.setframerate(RATE)\r\n" +
"    waveFile.writeframes(b''.join(frames))\r\n" +
"    waveFile.close()\r\n\r\n" +
"    return path\r\n";
        return source;
 }
    public String runMic(){
          String source = "record_voice()\r\n";
              
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
