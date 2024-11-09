package org.iesw.inha.generator.ai;

import org.iesw.inha.generator.HGenerator;
import org.iesw.inha.ioconfig.ai.HN3MLoldIOConfig;
import org.iesw.inha.ai.snn.n3ml.HN3MLConnectionIOConfig;
import org.iesw.inha.ai.snn.n3ml.HN3MLNetworkIOConfig;
import org.iesw.inha.ai.snn.n3ml.HN3MLPopulationIOConfig;
import org.iesw.inha.ai.snn.n3ml.HN3MLSourceIOConfig;

public class HSNNoldN3MLGenerator extends HGenerator{
    
    private HN3MLoldIOConfig hn3mlCfg;
    private HN3MLNetworkIOConfig[] hn3mlNetCfg;
    private HN3MLSourceIOConfig[] hn3mlSrcCfg;
    private HN3MLPopulationIOConfig[] hn3mlPopCfg;
    private HN3MLConnectionIOConfig[] hn3mlConnCfg;
    
    private int allObjectNumber=0; 
    
    public String modelName="";
    public String modelDir="";
    public String componentName="";
    
    public HSNNoldN3MLGenerator(){
        super();
    }
    
    public HSNNoldN3MLGenerator(HN3MLoldIOConfig hn3mlCfg, String mName, String mDir){
        super();
        this.hn3mlCfg = hn3mlCfg;
        modelName=mName;
        modelDir=mDir;  
        getN3MLALL();
    }
    
    
    private void getN3MLALL(){ 
        hn3mlNetCfg = hn3mlCfg.getN3MLNetwork();
        hn3mlSrcCfg = hn3mlCfg.getN3MLSource();
        hn3mlPopCfg = hn3mlCfg.getN3MLPopulation();
        hn3mlConnCfg = hn3mlCfg.getN3MLConnection();
        
        allObjectNumber = hn3mlNetCfg.length + hn3mlSrcCfg.length + hn3mlPopCfg.length + hn3mlConnCfg.length;
    }
    
    public void writeN3MLGen(){
        writeFile(importLibrary());
        writeFile(demoMainTest());
    }
    
       
    public String importLibrary(){
        String source = "import n3ml.Network as Network\r\n" +
"import n3ml.Source as Source\r\n" +
"import n3ml.Population as Population\r\n" +
"import n3ml.Connection as Connection\r\n" +
"import n3ml.Simulator as Simulator\r\n" +
"import n3ml.Learning as Learning\r\n";
        return source + "\r\n";
    }
    
    public String createMain(){
        String source = "if __name__ == '__main__':\r\n\r\n";
        return source;
    }
    
    public String createNetwork(){
        int rotation = hn3mlNetCfg.length;
        String source ="";
        for(int i=0; i<rotation; i++){
            source=source + "    net"+(i+1)+" = Network.Network(code='"+hn3mlNetCfg[i].getSpikeProcess()+"', learning=Learning."+hn3mlNetCfg[i].getLearningAlgorithm()+"())\r\n";
        }
        
        return source + "\r\n";
    }
    
    public String createSource(){
        int rotation = hn3mlSrcCfg.length;
        String source="";
        for(int i=0; i<rotation; i++){
            source = "    src"+(i+1)+" = Source.MNISTSource(code='"+hn3mlSrcCfg[i].getEncodingProcess()+"', num_neurons="+hn3mlSrcCfg[i].getNeuronOfSource()+")\r\n";
        }
        return source + "\r\n";
    }
    
    public String createPopulation(){
        int rotation = hn3mlPopCfg.length;
        String source="";
        for(int i=0; i<rotation; i++){
            source = "    pop"+(i+1)+" = Population."+hn3mlPopCfg[i].getTypeOfPop()+"(num_neurons="+hn3mlPopCfg[i].getNumberOfNeurons()+")\r\n";
        }
        return source + "\r\n";
    }
    
    public String createConnection(){
        int rotation = hn3mlConnCfg.length;
        String source="";
        for(int i=0; i<rotation; i++){
            source="    conn"+(i+1)+" = Connection.Connection(pre="+hn3mlConnCfg[i].getPreConnection()+", post="+hn3mlConnCfg[i].getPostConnection()+")\r\n";
        }
        return source + "\r\n";
    }
    
    public String addLayer(){
        for(int i=0; i<allObjectNumber; i++){
            
        }
        String source="    net.add(src)\r\n" +
"    net.add(conn_1)\r\n" +
"    net.add(pop_1)\r\n" +
"    net.add(conn_2)\r\n" +
"    net.add(pop_2)\r\n";
        return source + "\r\n";
    }
    
    public String createSimulator(){
        String source="    sim = Simulator.Simulator(network=net)\r\n" +
"    sim.run(simulation_time=0.1)\r\n";
        return source + "\r\n";
    }
    
    public String demoMainTest(){
        String source = "if __name__ == '__main__':\r\n" +
"    net = Network.Network(code='single', learning=Learning.SpikeProp())\r\n" +
"\r\n" +
"    src = Source.MNISTSource(code='population', num_neurons=20)\r\n" +
"\r\n" +
"    pop_1 = Population.SRMPopulation(num_neurons=100)\r\n" +
"    pop_2 = Population.SRMPopulation(num_neurons=10)\r\n" +
"\r\n" +
"    conn_1 = Connection.Connection(pre=src, post=pop_1)\r\n" +
"    conn_2 = Connection.Connection(pre=pop_1, post=pop_2)\r\n" +
"\r\n" +
"    net.add(src)\r\n" +
"    net.add(conn_1)\r\n" +
"    net.add(pop_1)\r\n" +
"    net.add(conn_2)\r\n" +
"    net.add(pop_2)\r\n" +
"\r\n" +
"    sim = Simulator.Simulator(network=net)\r\n" +
"\r\n" +
"    sim.run(simulation_time=0.1)";
        return source;
    }
}
