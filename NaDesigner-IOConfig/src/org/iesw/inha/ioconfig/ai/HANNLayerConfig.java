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
public class HANNLayerConfig {
    
    public static final int CONV = 0;
    public static final int POOL = 1;
    
    private int numofLayer = 0;
    private int filter;
    private int kernel;
    private int stride;
    private String padding;
    private int option; //convolution or pooling
    
    public HANNLayerConfig(){
    }
        
    public HANNLayerConfig(int filter, int kernel, int stride, String padding, int opt){
        setFilter(filter);
        setKernel(kernel);
        setStride(stride);
        setPadding(padding);
        setOption(opt);
    }

    public int getNumofLayer() {
        return numofLayer;
    }

    public void setNumofLayer(int numofLayer) {
        this.numofLayer = numofLayer;
    }

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }

    public int getKernel() {
        return kernel;
    }

    public void setKernel(int kernel) {
        this.kernel = kernel;
    }

    public int getStride() {
        return stride;
    }

    public void setStride(int stride) {
        this.stride = stride;
    }

    public String getPadding() {
        return padding;
    }

    public void setPadding(String padding) {
        this.padding = padding;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    
}
