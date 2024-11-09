/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.inha.ai.snn.n3ml;

import org.iesw.inha.ioconfig.ai.HN3MLIOConfig;

/**
 *
 * @author SeoyeonKim
 */
public class HN3MLSoftLIFIOConfig extends HN3MLIOConfig {
    private int inchannel;
    private int outchannel;
    private int kernelSize;
    private int stride;
    private int padding;
    private int bias;
    
    private int softLif;
    private int poolkernel;
    
    private int flatten;
    private int drop;
    private int fcInchannel;
    private int fcOutchannel;
    private int fcBias;
    
    
    public HN3MLSoftLIFIOConfig(int inchannel,int outchannel, int kernel, int stride, int padding, int bias, int softLif, int poolkernel){
        setInchannel(inchannel);
        setOutchannel(outchannel);
        setKernelSize(kernel);
        setStride(stride);
        setPadding(padding);
        setBias(bias);
        setSoftLif(softLif);
        setPoolkernel(poolkernel);
    }
    
    public HN3MLSoftLIFIOConfig(int flatten, int drop, int fcInchannel,int fcOutchanel, int softLif, int fcBias){
        setFlatten(flatten);
        setDrop(drop);
        setFcInchannel(fcInchannel);
        setFcOutchannel(fcOutchannel);
        setSoftLif(softLif);
        setFcBias(fcBias);
    }
    
    

    public int getInchannel() {
        return inchannel;
    }

    public void setInchannel(int inchannel) {
        this.inchannel = inchannel;
    }

    public int getOutchannel() {
        return outchannel;
    }

    public void setOutchannel(int outchannel) {
        this.outchannel = outchannel;
    }

    public int getKernelSize() {
        return kernelSize;
    }

    public void setKernelSize(int kernelSize) {
        this.kernelSize = kernelSize;
    }

    public int getStride() {
        return stride;
    }

    public void setStride(int stride) {
        this.stride = stride;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    public int getBias() {
        return bias;
    }

    public void setBias(int bias) {
        this.bias = bias;
    }

    public int getSoftLif() {
        return softLif;
    }

    public void setSoftLif(int softLif) {
        this.softLif = softLif;
    }

    public int getPoolkernel() {
        return poolkernel;
    }

    public void setPoolkernel(int poolkernel) {
        this.poolkernel = poolkernel;
    }

    public int getFlatten() {
        return flatten;
    }

    public void setFlatten(int flatten) {
        this.flatten = flatten;
    }

    public int getDrop() {
        return drop;
    }

    public void setDrop(int drop) {
        this.drop = drop;
    }

    public int getFcInchannel() {
        return fcInchannel;
    }

    public void setFcInchannel(int fcInchannel) {
        this.fcInchannel = fcInchannel;
    }

    public int getFcOutchannel() {
        return fcOutchannel;
    }

    public void setFcOutchannel(int fcOutchannel) {
        this.fcOutchannel = fcOutchannel;
    }

    public int getFcBias() {
        return fcBias;
    }

    public void setFcBias(int fcBias) {
        this.fcBias = fcBias;
    }
    
}
