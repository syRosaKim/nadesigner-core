/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.ihu.ioconfig.ai;

import org.iesw.inha.ioconfig.HIOConfig;

public class HSNNIOConfig extends org.iesw.inha.ioconfig.ai.HAIIOConfig{
    
    private String neuron_type; 
    private double tau_rc; 
    private double amplitude; 
    private int max_rates; 
    private Double intercepts; 
    private String synapse; 
    private String boards;
    private String model_prediction; 
    
    private Object neuronSize;
    private double imageSize;

    
    private String Layers;
    private String Neurons;
    private String DataSize;

    public HSNNIOConfig() {  
    }
        
    public void initIOConfig() {
      	
    }
    
    public String getNeuron_type() {
        return neuron_type;
    }

    public void setNeuron_type(String neuron_type) {
        this.neuron_type = neuron_type;
    }
    
    public String getBoards() {
        return boards;
    }

    public void setBoards(String board) {
        this.boards = board;
    }    
    
    public String getModelPrediction() {
        return model_prediction;
    }

    public void setModelPrediction(String model_prediction) {
        this.model_prediction = model_prediction;
    }
    public double getTau_rc() {
        return tau_rc;
    }

    public void setTau_rc(double tau_rc) {
        this.tau_rc = tau_rc;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;        
    }

    public int getMax_rates() {
        return max_rates;
    }

    public void setMax_rates(int max_rates) {
        this.max_rates = max_rates;
    }

    public Double getIntercepts() {
        return intercepts;
    }

    public void setIntercepts(Double intercepts) {
        this.intercepts = intercepts;
    }

    public String getSynapse() {
        return synapse;
    }

    public void setSynapse(String synapse) {
        this.synapse = synapse;
    }
    
    public Object getNeuronSize() {
        return neuronSize;
    }

    public void setNeuronSize(Object neuronSize) {
        this.neuronSize = neuronSize;
    }
    
    public double getImageSize() {
        return imageSize;
    }

    public void setImageSize(double imageSize) {
        this.imageSize = imageSize;
    }

    public String getLayers() {
        return Layers;
    }

    public void setLayers(String Layers) {
        this.Layers = Layers;
    }

    public String getNeurons() {
        return Neurons;
    }

    public void setNeurons(String Neurons) {
        this.Neurons = Neurons;
    }

    public String getDataSize() {
        return DataSize;
    }

    public void setDataSize(String DataSize) {
        this.DataSize = DataSize;
    }
}