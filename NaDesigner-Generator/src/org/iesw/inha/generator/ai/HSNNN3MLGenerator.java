/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.inha.generator.ai;

import org.iesw.inha.generator.HAIGenerator;
import org.iesw.inha.generator.HGenerator;
import org.iesw.inha.generator.n3ml.HN3MLBpStdpGenerator;
import org.iesw.inha.generator.n3ml.HN3MLResumeGenerator;
import org.iesw.inha.generator.n3ml.HN3MLSoftLIFGenerator;
import org.iesw.inha.generator.n3ml.HN3MLSpikePropGenerator;
import org.iesw.inha.generator.n3ml.HN3MLStbpGenerator;
import org.iesw.inha.generator.n3ml.HN3MLStdpGenerator;
import org.iesw.inha.ioconfig.ai.HN3MLIOConfig;
import org.iesw.inha.ai.snn.n3ml.HN3MLSoftLIFIOConfig;

/**
 *
 * @author SeoyeonKim
 */
public class HSNNN3MLGenerator extends HAIGenerator {
    
    public static final int H_N3ML_NM_LIF_MODEL = 0; 
    public static final int H_N3ML_NM_Soft_LIF_MODEL = 1;
    public static final int H_N3ML_NM_IF_MODEL = 2;
    public static final int H_N3ML_NM_SRM_MODEL = 3;
    public static final int H_N3ML_NM_Adaptive_LIF_MODEL = 4;
    
    public static final int H_N3ML_A_softLIF = 0;
    public static final int H_N3ML_A_SpikeProp = 1;
    public static final int H_N3ML_A_STDP = 2;
    public static final int H_N3ML_A_BP_STDP = 3;
    public static final int H_N3ML_A_STBP = 4;
    
    
    private HN3MLIOConfig hn3mlCfg=new HN3MLIOConfig();
    private HN3MLSoftLIFIOConfig[] hSLCfg;

    int numLayer = 0;
    String addLayerSource = "";
    
    public String modelName = "";
    public String modelDir = "";
    
    private int hN3mlNeuronModel = 0;  
    private int hN3mlAlgorithm = 0;
   
    
    public HSNNN3MLGenerator(String mName, String mDir) {
        super();
        modelName = mName;
        modelDir = mDir;
    }
    
    public void setModelAlgorithm(int neuronmodel, int algorithm){
        hN3mlNeuronModel = neuronmodel;
        hN3mlAlgorithm = algorithm;
    }
    
    public void inputN3MLIO(HN3MLIOConfig hn3mlCfg){
        this.hn3mlCfg = hn3mlCfg;
    }
    
    public void initSoftLIFLayerConfig(int layerN, HN3MLSoftLIFIOConfig hSoftLIFConfig){
        hSLCfg[layerN] = hSoftLIFConfig;
        int cnt=0; 
        for(int i=0; i<numLayer; i++){
            if(hSLCfg[i] != null){
                cnt+=1;
            }
        }
        if(cnt >= numLayer){
            addLayerSource = setAddLayer(hSLCfg);
        }
    }
    
    public String setAddLayer (HN3MLSoftLIFIOConfig[] hSLCfg_p){
        String source="";
        
        return source;
    }

    public void writeN3MLGen() {
        switch (hN3mlAlgorithm) {

            case H_N3ML_A_softLIF:
                HN3MLSoftLIFGenerator n3mlSoftLifGen = new HN3MLSoftLIFGenerator(hn3mlCfg, hN3mlNeuronModel);
                writeFile(n3mlSoftLifGen.createSoftLIF());
                break;
            case H_N3ML_A_SpikeProp:
                HN3MLSpikePropGenerator n3mlSpikePropGen = new HN3MLSpikePropGenerator(hn3mlCfg, hN3mlNeuronModel);
                writeFile(n3mlSpikePropGen.createSpikeProp());
                break;
            case H_N3ML_A_STDP:
                HN3MLStdpGenerator n3mlStdpGen = new HN3MLStdpGenerator(hn3mlCfg, hN3mlNeuronModel);
                writeFile(n3mlStdpGen.createSTDP());
                break;
            case H_N3ML_A_BP_STDP:
                HN3MLBpStdpGenerator n3mlBpStdpGen = new HN3MLBpStdpGenerator(hn3mlCfg, hN3mlNeuronModel);
                writeFile(n3mlBpStdpGen.createBpSTDP());
                break;
            case H_N3ML_A_STBP:
                HN3MLStbpGenerator n3mlStbpGen = new HN3MLStbpGenerator(hn3mlCfg, hN3mlNeuronModel);
                writeFile(n3mlStbpGen.createSTBP());
                break;
            default:
                writeFile(mainTest());
                break;
        }

    }

    

    public String mainTest() {
        String source = "if __name__ == '__main__':\r\n"
                + "    parser = argparse.ArgumentParser()\r\n"
                + "\r\n"
                + "    parser.add_argument('--data', default='../DataSets')\r\n"
                + "    parser.add_argument('--num_classes', default="+hn3mlCfg.getNumofClasses()+", type=int)\r\n"
                + "    parser.add_argument('--batch_size', default="+hn3mlCfg.getBatch_size()+", type=int)\r\n"
                + "    parser.add_argument('--simulation_times', default="+hn3mlCfg.getSimulationTime()+", type=float)  # 2s\r\n"
                + "    parser.add_argument('--time_steps', default="+hn3mlCfg.getTimeSteps()+", type=float)  # 1ms\r\n"
                + "    parser.add_argument('--time_frames', default="+hn3mlCfg.getTimeFrames()+", type=float)  # 50ms\r\n"
                + "\r\n"
                + "    app(parser.parse_args())\r\n";
        return source + "\r\n";
    }
    
}
