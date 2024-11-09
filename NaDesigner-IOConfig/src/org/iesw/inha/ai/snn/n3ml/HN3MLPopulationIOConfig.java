package org.iesw.inha.ai.snn.n3ml;

public class HN3MLPopulationIOConfig{ 
    
    private int numberOfNeurons;
    private String typeOfPop; 
    
    public String getTypeOfPop() {
        return typeOfPop;
    }

    public void setTypeOfPop(String typeOfPop) {
        this.typeOfPop = typeOfPop;
    }

    public int getNumberOfNeurons() {
        return numberOfNeurons;
    }

    public void setNumberOfNeurons(int numberOfNeurons) {
        this.numberOfNeurons = numberOfNeurons;
    }
    
    
}
