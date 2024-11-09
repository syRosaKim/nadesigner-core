package org.iesw.inha.ioconfig;

public class HIOConfig {
    
    private int data_opt; 
    private int state; 
    private String input;
    private String output;

    
    private int board; 
   
            
    public int getData_opt() {
        return data_opt;
    }

    public void setData_opt(int data_opt) {
        this.data_opt = data_opt;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    
    public HIOConfig(){
    }
    

    
}

