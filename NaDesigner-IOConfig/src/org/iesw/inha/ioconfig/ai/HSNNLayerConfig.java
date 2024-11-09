package org.iesw.inha.ioconfig.ai;

import org.iesw.inha.ioconfig.ai.HSNNIOConfig;

public class HSNNLayerConfig extends HSNNIOConfig{
    
    public static final int CONV = 0;
    public static final int POOL = 1;
    
    private int numofLayer = 0;
    private int filter;
    private int kernel;
    private int stride;
    private String padding;
    private int option; //convolution or pooling
    
    public HSNNLayerConfig(){
    }
        
    public HSNNLayerConfig(int filter, int kernel, int stride, String padding, int opt){
        setFilter(filter);
        setKernel(kernel);
        setStride(stride);
        setPadding(padding);
        setOption(opt);
    }

    public int getOption() {
        return option;
    }

    public void setOption(int opt) {
        this.option = opt;
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
    

}
