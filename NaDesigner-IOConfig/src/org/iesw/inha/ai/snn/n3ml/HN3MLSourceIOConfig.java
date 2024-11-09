package org.iesw.inha.ai.snn.n3ml;

public class HN3MLSourceIOConfig {
    
    private String encodingProcess;
    private int neuronOfSource;
    private int samplingPeriod;
    private double beta;


    public String getEncodingProcess() {
        return encodingProcess;
    }

    public void setEncodingProcess(String encodingProcess) {
        this.encodingProcess = encodingProcess;
    }

    public int getNeuronOfSource() {
        return neuronOfSource;
    }

    public void setNeuronOfSource(int neuronOfSource) {
        this.neuronOfSource = neuronOfSource;
    }

    public int getSamplingPeriod() {
        return samplingPeriod;
    }

    public void setSamplingPeriod(int samplingPeriod) {
        this.samplingPeriod = samplingPeriod;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }
    
    
}
