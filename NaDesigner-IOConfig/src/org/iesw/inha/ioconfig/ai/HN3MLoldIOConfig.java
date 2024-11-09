package org.iesw.inha.ioconfig.ai;

import org.iesw.inha.ai.snn.n3ml.HN3MLConnectionIOConfig;
import org.iesw.inha.ai.snn.n3ml.HN3MLNetworkIOConfig;
import org.iesw.inha.ai.snn.n3ml.HN3MLPopulationIOConfig;
import org.iesw.inha.ai.snn.n3ml.HN3MLSimulationIOConfig;
import org.iesw.inha.ai.snn.n3ml.HN3MLSourceIOConfig;

public class HN3MLoldIOConfig extends HSNNIOConfig{
    
    private HN3MLConnectionIOConfig[] n3mlConn;
    private HN3MLNetworkIOConfig[] n3mlNet;
    private HN3MLPopulationIOConfig[] n3mlPop;
    private HN3MLSourceIOConfig[] n3mlSrc;
    private HN3MLSimulationIOConfig n3mlSim;
    
    private int connNum = 0;
    private int netNum = 0;
    private int popNum = 0;
    private int srcNum = 0; 
    
    
    public HN3MLoldIOConfig(int netNum, int srcNum, int popNum, int connNum ){
    
        this.netNum = netNum;
        this.srcNum = srcNum;
        this.popNum = popNum;
        this.connNum = connNum;
        
        initN3ML();
        
    }
    
    private void initN3ML(){
        if(netNum==0 || srcNum==0 || popNum==0 || connNum==0){
            return;
        }
        n3mlNet = new HN3MLNetworkIOConfig[netNum];
        n3mlSrc = new HN3MLSourceIOConfig[srcNum];
        n3mlPop = new HN3MLPopulationIOConfig[popNum];
        n3mlConn = new HN3MLConnectionIOConfig[connNum];
        n3mlSim = new HN3MLSimulationIOConfig();
    }
    
    public void initNetwork(String spikeProcess, String learningAlgorithm, double threshold, int num){
        n3mlNet[num].setLearningAlgorithm(learningAlgorithm);
        n3mlNet[num].setSpikeProcess(spikeProcess);
        n3mlNet[num].setThreshold(threshold);
    }
    
    public void initSource(String encodingProcess, int neuronOfSource, int samplingPeriod, double beta, int num){
        n3mlSrc[num].setEncodingProcess(encodingProcess);
        n3mlSrc[num].setNeuronOfSource(neuronOfSource);
        n3mlSrc[num].setSamplingPeriod(samplingPeriod);
        n3mlSrc[num].setBeta(beta);
    }
    
    public void initPopulation(int numberofNeurons, String typeOfPop, int num){
        n3mlPop[num].setNumberOfNeurons(numberofNeurons);
        n3mlPop[num].setTypeOfPop(typeOfPop);
    }
    
    public void initConnection(String preConnection, String postConnection, int num){
        n3mlConn[num].setPreConnection(preConnection);
        n3mlConn[num].setPostConnection(postConnection);
    }
    
    public void initSimulation(double timeStep, double simulationTime){
        n3mlSim.setSimulationTime(simulationTime);
        n3mlSim.setTimeStep(timeStep);
    }
    
    public HN3MLNetworkIOConfig[] getN3MLNetwork(){
        return n3mlNet;
    }
    public HN3MLSourceIOConfig[] getN3MLSource(){
        return n3mlSrc;
    }    
    public HN3MLPopulationIOConfig[] getN3MLPopulation(){
        return n3mlPop;
    }    
    public HN3MLConnectionIOConfig[] getN3MLConnection(){
        return n3mlConn;
    }
    public HN3MLSimulationIOConfig getN3MLSimulation(){
        return n3mlSim;
    }
    
    public HN3MLoldIOConfig(){
         
    }

}
