package org.iesw.inha.generator.ai;

import org.iesw.inha.generator.HAIGenerator;
import org.iesw.inha.generator.HGenerator;
import org.iesw.inha.ioconfig.ai.HSNNIOConfig;
public class HSNNHardwareGenerator extends HAIGenerator{
    
    
    private static final int DE1 = 0;
    private static final int PYNQ = 1;
    private static final int LOIHI = 2;
    
    private HSNNIOConfig hSCfg = new HSNNIOConfig();
    
    public String modelName="";
    public String modelDir="";
    public String componentName="";
    
    String[] inp;
    
    public HSNNHardwareGenerator(){
        super();
    }
    
    public void initConfig(HSNNIOConfig hSNNIOConfig, String mName, String mDir){
        modelName=mName;
        modelDir=mDir;       
        String componentNameT[] =mDir.split("\\\\");
        for(int i=0; i<componentNameT.length; i++){
            if(i+1==componentNameT.length)
                componentName = componentNameT[i];
        }
        hSCfg = hSNNIOConfig;
        
    }
    public void initConfig(HSNNIOConfig hSNNIOConfig){

        hSCfg = hSNNIOConfig;
        
    }
    
    public void writeSNNGen(){
        writeFile(importLibrary());
        writeFile(setFunction());
        writeFile(setParameter());
        writeFile(setData());
        writeFile(setNetwork());
        writeFile(setSimulator());
        
    }
    
    public void writeNeuroHWGen(){
        String L = hSCfg.getLayers();
        String N = hSCfg.getNeurons();
        String D = hSCfg.getDataSize();
        System.out.println("write Neuro HW Generator: "+L+" "+N+" "+D);
        
    }
    
    public String importLibrary(){ 
        String source = "import os\r\n"+
                        "import sys\r\n"+
                        "import numpy as np\r\n"+
                        "import nengo\r\n"+
                        "import logging\r\n"+
                        "import gzip\r\n"+
                        "import pickle\r\n"+
                        "from PIL import Image\r\n"+
                        "from nengo_extras.data import load_mnist\r\n"+
                        "from nengo_extras.vision import Gabor, Mask\r\n"+
                        "from nengo_extras.gui import image_display_function\r\n"+
                        "import time\r\n"+
                        "import matplotlib.pyplot as plt\r\n"+
                        "from nengo_fpga.networks import FpgaPesEnsembleNetwork\r\n"+
                        "import nengo_fpga\r\n";
        return source;
    }
     public String setFunction(){
         String source = "class NullWriter():\r\n"+
                        "    def write(self,arg):\r\n"+
                        "        pass\r\n"+
                        "    def flush(args):\r\n"+
                        "        pass\r\n"+
                        "nullwriter = NullWriter()\r\n"+
                        "oldstdout = sys.stdout\r\n"+
                        "sys.stdout = nullwriter\r\n\n"+
                        "def resize_img(img, _im_size, _im_size_new):\r\n"+
                        "    img = Image.fromarray(img.reshape((_im_size, _im_size)) * 256, \"F\")\r\n"+
                        "    img = img.resize((_im_size_new, _im_size_new), Image.ANTIALIAS)\r\n"+
                        "    return np.array(img.getdata(), np.float32) / 256.0\r\n"+
                        "def one_hot(labels, c=None):\r\n"+
                        "    assert labels.ndim == 1\r\n"+
                        "    n = labels.shape[0]\r\n"+
                        "    c = len(np.unique(labels))\r\n"+
                        "    y = np.zeros((n, c))\r\n"+
                        "    y[np.arange(n), labels] = 1\r\n"+
                        "    return y\r\n\n"+
                        "def result_data(data):\r\n"+
                        "    result = []\r\n"+
                        "    for i in range(0,len(data)):\r\n"+
                        "       result.append(np.argmax(data[i]))\r\n"+
                        "    result.remove(0)\r\n"+
                        "    result = np.bincount(result)\r\n"+
                        "    #print(result)\r\n"+
                        "    return result\r\n";
        return source;
    }
    public String setParameter(){
         String source = "try:\r\n"+
                         "    im_resize = sys.argv[1]\r\n"+
                         "    im_resize = im_resize.replace(\"]\",\"\")\r\n"+
                         "    im_resize = im_resize.replace(\"[\",\"\")\r\n"+
                         "    im_resize = im_resize.split()\r\n"+
                         "    im_resize = np.array(im_resize)\r\n"+
                         "    im_resize = im_resize.astype('int32')\r\n"+
                         "    im_resize = np.resize(im_resize,(1,196))\r\n"+
                         "    im_resize = im_resize / 256.0\r\n"+
                         "    epoc = "+ hSCfg.getEpoch()+"\r\n"+
                         "    neuronSize = "+ hSCfg.getNeuronSize()+"\r\n"+
                         "    board = \"de1\"\r\n"+
                         "    logging.basicConfig(format=\"%(levelname)s:%(message)s\", level=logging.INFO)\r\n"+
                         "    rng = np.random.RandomState(9)\r\n"+
                         "    with gzip.open(\"na-components/nengo-fpga/NeuromorphicBoard/src/hnu/mnist.pkl.gz\") as f:\r\n"+
                         "        train_data, _, test_data = pickle.load(f, encoding=\"latin1\")\r\n";
        return source;
    }
    public String setData(){
         String source = "    train_data = list(train_data)\r\n"+
                         "    test_data = list(test_data)\r\n"+
                         "    (x_train, y_train) = train_data\r\n"+
                         "    (x_test, y_test) = test_data\r\n"+
                         "    x_train = 2 * x_train - 1\r\n"+
                         "    x_test = 2 * x_test - 1\r\n"+
                         "    im_resize = 2 * im_resize - 1\r\n"+
                         "    im_size = int(np.sqrt(x_train.shape[1]))\r\n"+
                         "    reduction_factor = "+ hSCfg.getImageSize()+"\r\n"+    
                         "    if reduction_factor > 0:\r\n"+
                         "        im_size_new = int(im_size * reduction_factor)\r\n"+
                         "        x_train_resized = np.zeros((x_train.shape[0], im_size_new ** 2))\r\n"+
                         "        for i in range(x_train.shape[0]):\r\n"+
                         "            x_train_resized[i, :] = resize_img(x_train[i], im_size, im_size_new)\r\n"+
                         "        x_train = x_train_resized\r\n\n"+
                         "        x_test_resized = np.zeros((x_test.shape[0], im_size_new ** 2))\r\n"+
                         "        for i in range(x_test.shape[0]):\r\n"+
                         "            x_test_resized[i, :] = resize_img(x_test[i], im_size, im_size_new)\r\n"+
                         "        x_test = x_test_resized\r\n\n"+
                         "        im_size = im_size_new\r\n\n"+
                         "    train_targets = one_hot(y_train, 10)\r\n"+
                         "    test_targets = one_hot(y_test, 10)\r\n"+
                         "    n_vis = x_train.shape[1]\r\n"+
                         "    n_out = train_targets.shape[1]\r\n"+
                         "    n_hid = int(16000 * neuronSize) // (im_size ** 2)\r\n"+ 
                         "    gabor_size = (int(im_size / 2.5), int(im_size / 2.5))\r\n"+
                         "    encoders = Gabor().generate(n_hid, gabor_size, rng=rng)\r\n"+
                         "    encoders = Mask((im_size, im_size)).populate(encoders, rng=rng, flatten=True)\r\n"+
                         "    max_firing_rates = "+hSCfg.getMax_rates()+"\r\n"+
                         "    ens_neuron_type = nengo.neurons."+hSCfg.getNeuron_type()+"()\r\n"+
                         "    ens_intercepts = nengo.dists.Choice(["+hSCfg.getIntercepts()+"])\r\n"+
                         "    ens_max_rates = nengo.dists.Choice([max_firing_rates])\r\n"+
                         "    conn_synapse = "+ hSCfg.getSynapse()+"\r\n"+
                         "    conn_eval_points = x_train\r\n"+
                         "    conn_function = train_targets\r\n"+
                         "    conn_solver = nengo.solvers.LstsqL2(reg=0.01)\r\n"+
                         "    presentation_time = 0.25\r\n\n";                  
        return source;
    }
    public String setNetwork(){
         String source = "    with nengo.Network(seed=3) as model:\r\n"+
                         "        input_node = nengo.Node(\r\n"+
                         "            nengo.processes.PresentInput(im_resize, presentation_time), label=\"input\"\r\n"+
                         "        )\r\n"+
                         "        ens = FpgaPesEnsembleNetwork(\r\n"+
                         "            board,\r\n"+
                         "            n_neurons=n_hid,\r\n"+
                         "            dimensions=n_vis,\r\n"+
                         "            learning_rate=0,\r\n"+
                         "            function=conn_function,\r\n"+
                         "            eval_points=conn_eval_points,\r\n"+
                         "            label=\"output class\",\r\n"+
                         "        )\r\n"+
                         "        ens.ensemble.neuron_type = ens_neuron_type\r\n"+
                         "        ens.ensemble.intercepts = ens_intercepts\r\n"+
                         "        ens.ensemble.max_rates = ens_max_rates\r\n"+  
                         "        ens.ensemble.encoders = encoders\r\n"+
                         "        ens.connection.synapse = conn_synapse\r\n"+
                         "        ens.connection.solver = conn_solver\r\n"+
                         "        p2 = nengo.Probe(ens.output, synapse=None)\r\n"+
                         "        output_node = nengo.Node(size_in=n_out, label=\"output class\")\r\n"+
                         "        nengo.Connection(input_node, ens.input, synapse=None)\r\n"+
                         "        nengo.Connection(ens.output, output_node, synapse=None)\r\n"+
                         "        image_shape = (1, im_size, im_size)\r\n"+
                         "        display_func = image_display_function(image_shape, offset=1, scale=128)\r\n"+
                         "        display_node = nengo.Node(display_func, size_in=input_node.size_out)\r\n"+
                         "        nengo.Connection(input_node, display_node, synapse=None)\r\n\n";                       
        return source;
    }
    public String setSimulator(){
         String source = "    with nengo_fpga.Simulator(model) as sim:\r\n"+
                         "       sim.run_steps(epoc*1000)\r\n"+
                         "    data = sim.data[p2]\r\n"+
                         "    sys.stdout = oldstdout\r\n"+
                         "    result = result_data(data)\r\n"+
                         "    result = result.argmax()\r\n"+
                         "    print(result)\r\n"+
                         "    sys.stdout.flush()\r\n"+
                         "    plt.figure()\r\n"+
                         "    plt.plot(sim.data[p2], label=\"\")\r\n"+
                         "    plt.xlabel(\"Timesteps\")\r\n"+
                         "    plt.ylabel(\"Output\")\r\n"+
                         "    plt.legend(['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'], loc='upper right')\r\n"+
                         "    plt.show()\r\n"+
                         "    sim.close()\r\n"+
                         "except Exception as e:\r\n"+
                         "    sys.stdout.flush()\r\n";   
        return source;
    }
}