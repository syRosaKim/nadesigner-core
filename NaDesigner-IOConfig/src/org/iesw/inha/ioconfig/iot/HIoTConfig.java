package org.iesw.inha.ioconfig.iot;

import org.iesw.inha.ioconfig.ai.HSNNIOConfig;

public class HIoTConfig extends HSNNIOConfig{
    private int gpioPin = 0;
    private int dutyCycle;
    private int durationTime;
    private String gpioParamName;
    private int flagIoT;
    private String micChannels;
    private String recordTime;
    int sleepPI;
    private String resolution;
    private String resizeResolution;
    private String type_pin;
       
    
    
    private int board;
    public HIoTConfig(){
    }
    
    public HIoTConfig(int gpioPin,int dutyCycle, int durationTime, int flagIoT){
        setDutyCycle(dutyCycle);
        setDurationTime(durationTime);
        setGpioPin(gpioPin);  
        setFlagIoT(flagIoT);
    }
    public HIoTConfig(int gpioPin, String gpioParamName, String type_pin, int flagIoT, int board){
        setGpioPin(gpioPin);
        setGpioParamName(gpioParamName);       
        setTypePin(type_pin);
        setFlagIoT(flagIoT);
        setBoard(board);
        
    }
    public HIoTConfig(int board){
        setBoard(board);     
    }
    public HIoTConfig(String resolution,int captureTime, String resizeResolution, int flagIoT){   
        setFlagIoT(flagIoT);
        setSleepPI(captureTime);
        setResolution(resolution);
        setResizeResolution(resizeResolution);
    }
    public HIoTConfig(String resolution, String resizeResolution, int flagIoT){   
        setFlagIoT(flagIoT);
        setResolution(resolution);
        setResizeResolution(resizeResolution);
    }
    public HIoTConfig(int flagIotType, String micChannels, String recordTime){   
        setmicChannels(micChannels);
        setrecordTime(recordTime);
        setFlagIoT(flagIotType);
}

    public String getTypePin(){
        return type_pin;
    }
    public void setTypePin(String type_pin) {
        this.type_pin=type_pin;
    }
    
    public String getResolution(){
        return resolution;
    }
    public void setResolution(String resolution) {
        this.resolution=resolution;
    }
    public String getmicChannels(){
        return micChannels;
    }
    public void setmicChannels(String micChannels) {
        this.micChannels=micChannels;
    }
    
    public String getrecordTime(){
        return recordTime;
    }
    public void setrecordTime(String recordTime) {
        this.recordTime=recordTime;
    }
    public int getSleepPI(){
        return sleepPI;
    }
    public void setSleepPI(int sleepPI) {
        this.sleepPI=sleepPI;
    }
    public String getGpioParamName(){
        return gpioParamName;
    }
    public void setGpioParamName(String gpioParamName) {
        this.gpioParamName=gpioParamName;
    }
    
    public int getDutyCycle(){
        return dutyCycle;
    }
    public void setDutyCycle(int dutyCycle) {
        this.dutyCycle = dutyCycle;
    }
    public int getFlagIoT(){
        return flagIoT;
    }
    public void setFlagIoT(int flagIoT) {
        this.flagIoT = flagIoT;
    }

      public int getGpioPin(){
        return gpioPin;
    }
    public void setGpioPin(int gpioPin) {
        this.gpioPin = gpioPin;
    }   
    
    public int getDurationTime(){
        return durationTime;
    }
    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    public String getResizeResolution() {
        return resizeResolution;
    }

    public void setResizeResolution(String resizeResolution) {
        this.resizeResolution = resizeResolution;
    }

    public String getType_pin() {
        return type_pin;
    }

    public void setType_pin(String type_pin) {
        this.type_pin = type_pin;
    }
    
    public int getBoard(){
        return board;
    }
    public void setBoard(int board) {
        this.board = board;
    }
}
