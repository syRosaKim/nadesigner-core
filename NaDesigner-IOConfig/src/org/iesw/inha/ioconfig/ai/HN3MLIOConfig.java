/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.inha.ioconfig.ai;

/**
 *
 * @author SeoyeonKim
 */
public class HN3MLIOConfig extends HSNNIOConfig{
    
    private int numofClasses;

    private int simulationTime;
    private double timeSteps;
    private double timeFrames;
    private double momentum;
    private double tauRef;
    private double gain;
    private double sigma;
    private int numofSteps;
    private int dtTime;
    private int maxFiringTime;
    private int notToFire;
    private int timeStepsMs;
    private int intervalTime;
    private int beta;
    private int hiddenNeuron;
    private int epsilon;
    private int workers;

    
    
    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    public int getBeta() {
        return beta;
    }

    public void setBeta(int beta) {
        this.beta = beta;
    }

    public int getHiddenNeuron() {
        return hiddenNeuron;
    }

    public void setHiddenNeuron(int hiddenNeuron) {
        this.hiddenNeuron = hiddenNeuron;
    }

    public int getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(int epsilon) {
        this.epsilon = epsilon;
    }

    public int getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

    public int getTimeStepsMs() {
        return timeStepsMs;
    }

    public void setTimeStepsMs(int timeStepsMs) {
        this.timeStepsMs = timeStepsMs;
    }

    public int getDtTime() {
        return dtTime;
    }

    public void setDtTime(int dtTime) {
        this.dtTime = dtTime;
    }

    public int getMaxFiringTime() {
        return maxFiringTime;
    }

    public void setMaxFiringTime(int maxFiringTime) {
        this.maxFiringTime = maxFiringTime;
    }

    public int getNotToFire() {
        return notToFire;
    }

    public void setNotToFire(int notToFire) {
        this.notToFire = notToFire;
    }

    public int getNumofSteps() {
        return numofSteps;
    }

    public void setNumofSteps(int numofSteps) {
        this.numofSteps = numofSteps;
    }
    
    public double getTauRef() {
        return tauRef;
    }

    public void setTauRef(double tauRef) {
        this.tauRef = tauRef;
    }

    public double getGain() {
        return gain;
    }

    public void setGain(double gain) {
        this.gain = gain;
    }

    public double getSigma() {
        return sigma;
    }


    public void setSigma(double sigma) {
        this.sigma = sigma;
    }

    public double getMomentum() {
        return momentum;
    }

    public void setMomentum(double momentum) {
        this.momentum = momentum;
    }

    public int getNumofClasses() {
        return numofClasses;
    }

    public void setNumofClasses(int numofClasses) {
        this.numofClasses = numofClasses;
    }

    public int getSimulationTime() {
        return simulationTime;
    }

    public void setSimulationTime(int simmulationTime) {
        this.simulationTime = simmulationTime;
    }

    public double getTimeSteps() {
        return timeSteps;
    }

    public void setTimeSteps(double timeSteps) {
        this.timeSteps = timeSteps;
    }

    public double getTimeFrames() {
        return timeFrames;
    }

    public void setTimeFrames(double timeFrames) {
        this.timeFrames = timeFrames;
    }
}
