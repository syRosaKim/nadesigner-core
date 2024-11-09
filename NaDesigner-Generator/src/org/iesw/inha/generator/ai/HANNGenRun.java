package org.iesw.inha.generator.ai;

public class HANNGenRun {
    
    public static String hPrjDir_Run;
    public int hModel_Run_Temp=0;
    HANNGenerator hAGen;
    public HANNGenRun(){
        hAGen = new HANNGenerator();
    }
    public HANNGenRun(String Dir){
        hAGen = new HANNGenerator();
        hPrjDir_Run = Dir;
    }
    
    public void initRun(){
        hAGen.createFile(hPrjDir_Run);
    }
    
    public void annRun(){
        hAGen.destroy();
    }
    
}
