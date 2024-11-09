package org.iesw.inha.ioconfig.iot;

public class HIoTPinConfig extends HIoTConfig {
    private int num;
    private String name;
    public HIoTPinConfig(){
    }    
    public HIoTPinConfig(int num,String name){
        setNum(num);
        setName(name);
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
