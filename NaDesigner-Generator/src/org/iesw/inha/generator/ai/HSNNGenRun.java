package org.iesw.inha.generator.ai;

import org.iesw.inha.generator.ai.HSNNGenerator;
import org.iesw.inha.generator.file.HFunctionGenerator;
import org.iesw.inha.generator.file.HManifestGenerator;
import org.iesw.inha.generator.file.HUIGenerator;
import org.iesw.inha.ioconfig.HComponentConfig;

public class HSNNGenRun {
    
    public static final int H_SNN = 1;   
    public static final int H_ANN = 2;       
    public static final int HNUM_PRJ = 1; 
    public static final int HNUM_DIAL = 2;
       
    public static String hPrjDir_Run;
    public static String hPrjCompName;
    public static String hPrjCategory;     
    public static int hDataSetOpt_Run;
    HSNNGenerator hSGen;
    
    private HComponentConfig hCompCfg = new HComponentConfig();
    private HFunctionGenerator hFGen;
    private HManifestGenerator hMGen;
    private HUIGenerator hUIGen;
    
    public HSNNGenRun(){
        hSGen = new HSNNGenerator();
    }
    public HSNNGenRun(String Dir){
        hSGen = new HSNNGenerator();
        hPrjDir_Run = Dir;

    }
    
    public void initRun(String category){
        String[] sub = hPrjDir_Run.split("\\\\");
        hPrjCompName = sub[(sub.length)-1];
        
        hCompCfg.setComponentDir(hPrjDir_Run);       
        hCompCfg.setComponentName(hPrjCompName);
        hCompCfg.setCategory(category);
        
        hMGen = new HManifestGenerator(hCompCfg, H_SNN, HNUM_PRJ, hPrjDir_Run);  
        hFGen = new HFunctionGenerator(hCompCfg, H_SNN, HNUM_PRJ, hPrjDir_Run);
        hUIGen = new HUIGenerator(hCompCfg, H_SNN, HNUM_PRJ, hPrjDir_Run);
        
    }
    
    public void snnRun(){
        hMGen.destroy();
        hFGen.destroy();
        hSGen.destroy();
        hUIGen.destroy();
    }
    
}
