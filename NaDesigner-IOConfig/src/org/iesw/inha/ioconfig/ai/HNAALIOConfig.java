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
public class HNAALIOConfig extends HSNNIOConfig{

    private double simulationTime;
    private double timeInterval;
    private int dataType;
    private int ioTdevice;

    public double getSimulationTime() {
        return simulationTime;
    }

    public void setSimulationTime(double simulationTime) {
        this.simulationTime = simulationTime;
    }

    public double getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(double timeInterval) {
        this.timeInterval = timeInterval;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getIoTdevice() {
        return ioTdevice;
    }

    public void setIoTdevice(int ioTdevice) {
        this.ioTdevice = ioTdevice;
    }
    
    
}
