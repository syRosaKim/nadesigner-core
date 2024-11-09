package org.iesw.inha.ai.snn.n3ml;

public class HN3MLNetworkIOConfig {
    private String spikeProcess;
    private String learningAlgorithm;
    private double threshold;

    public String getLearningAlgorithm() {
        return learningAlgorithm;
    }

    public void setLearningAlgorithm(String learningAlgorithm) {
        this.learningAlgorithm = learningAlgorithm;
    }
    
    public String getSpikeProcess() {
        return spikeProcess;
    }

    public void setSpikeProcess(String spikeProcess) {
        this.spikeProcess = spikeProcess;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
    
    
}
