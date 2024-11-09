/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.ihu.ioconfig.ai;

import org.iesw.inha.ioconfig.HIOConfig;

/**
 *
 * @author SeoyeonKim
 */
//public class HAIIOConfig extends HIOConfig{
//    private String learning_rate;
//    private int epoch;
//    private int batch_size;
//    private String optimizer; 
//    private String initializer; 
//    private String loss;
//
//    private int xRange1; 
//    private int xRange2; 
//    private int yRange1; 
//    private int yRange2;
//    
//    public void setXY_range(String xRange1, String xRange2, String yRange1, String yRange2) {
//        this.xRange1 = Integer.parseInt(xRange1);
//        this.xRange2 = Integer.parseInt(xRange2);
//        this.yRange1 = Integer.parseInt(yRange1);
//        this.yRange2 = Integer.parseInt(yRange2);
//    }
//    
//    public int getxRange1() { 
//        return xRange1;
//    }
//}
//
///**
// *
// * @author SeoyeonKim
// */
//public class HAIIOConfig extends HIOConfig{
//    private String learning_rate;
//    private int epoch;
//    private int batch_size;
//    private String optimizer; 
//    private String initializer; 
//    private String loss;
//
//    private int xRange1; 
//    private int xRange2; 
//    private int yRange1; 
//    private int yRange2;
//    
//    public void setXY_range(String xRange1, String xRange2, String yRange1, String yRange2) {
//        this.xRange1 = Integer.parseInt(xRange1);
//        this.xRange2 = Integer.parseInt(xRange2);
//        this.yRange1 = Integer.parseInt(yRange1);
//        this.yRange2 = Integer.parseInt(yRange2);
//    }
//    
//    public int getxRange1() { 
//        return xRange1;
//    }

/**
 *
 * @author SeoyeonKim
 */
public class HAIIOConfig extends HIOConfig{
    private String learning_rate;
    private int epoch;
    private int batch_size;
    private String optimizer; 
    private String initializer; 
    private String loss;

    private int xRange1; 
    private int xRange2; 
    private int yRange1; 
    private int yRange2;
    
    public void setXY_range(String xRange1, String xRange2, String yRange1, String yRange2) {
        this.xRange1 = Integer.parseInt(xRange1);
        this.xRange2 = Integer.parseInt(xRange2);
        this.yRange1 = Integer.parseInt(yRange1);
        this.yRange2 = Integer.parseInt(yRange2);
    }
    
    public int getxRange1() { 
        return xRange1;
    }

    public int getyRange1() {
        return yRange1;
    }

    public int getxRange2() {
        return xRange2;
    }

    public int getyRange2() {
        return yRange2;
    }         
    
    public String getLearning_rate() {
        return learning_rate;
    }

    public void setLearning_rate(String learning_rate) {
        this.learning_rate = learning_rate;
    }

    public int getEpoch() {
        return epoch;
    }

    public void setEpoch(int epoch) {
        this.epoch = epoch;
    }

    public int getBatch_size() {
        return batch_size;
    }

    public void setBatch_size(int batch_size) {
        this.batch_size = batch_size;
    }
    
    public String getOptimizer() {
        return optimizer;
    }

    public void setOptimizer(String optimizer) {
        this.optimizer = optimizer;
    }

    public String getInitializer() {
        return initializer;
    }

    public void setInitializer(String initializer) {
        this.initializer = initializer;
    }

    public String getLoss() {
        return loss;
    }

    public void setLoss(String loss) {
        this.loss = loss;
    }
}
