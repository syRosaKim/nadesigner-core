package org.iesw.inha.generator.ai;

import org.iesw.inha.generator.HAIGenerator;
import org.iesw.inha.ioconfig.ai.HSNNIOConfig;
import org.iesw.inha.ioconfig.ai.HSNNLayerConfig;

public class HSNNGenerator extends HAIGenerator{
    
    public static final int H_DATA_SET_TRAINING = 0;   
    public static final int H_DATA_SET_TEST = 1; 
    
    
    public static final int CONV = 0;
    public static final int POOL = 1;
        
    
    private static final int Linear = 1;
    private static final int Logistic = 2;
    private static final int MNIST = 3;   
    
    private static final int pyData = 0;
    private static final int pyImp = 1;
    
    private int model = 0; //Linear, Logistic, MNIST
    
    public int dataSetOpt=-1;
    
    private HSNNIOConfig hSCfg = new HSNNIOConfig();
    private HSNNLayerConfig[] hSLCfg;
    
    public String modelName="";
    public String modelDir="";
    public String componentName="";
    public String componentDir="";
    
    public String loadDataFile="";
    public String dataFileDelimiter=""; 
    int numLayer = 0;
    String addLayerSource = "";
    String[] inp;
    
    public HSNNGenerator(){
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
        dataSetOpt = hSCfg.getData_opt();
    }
    
    public void setNumLayer(int numLayer){
        hSLCfg = new HSNNLayerConfig[numLayer];
        this.numLayer = numLayer;
    }
    
    public void initLayerConfig(int layerN, HSNNLayerConfig hSNNLayerConfig){
        hSLCfg[layerN] = hSNNLayerConfig;
        int cnt=0; 
        for(int i=0; i<numLayer; i++){
            if(hSLCfg[i] != null){
                cnt+=1;
            }
        }
        if(cnt >= numLayer){
            addLayerSource = setAddLayer(hSLCfg);
        }
    }

    public void setInputData(String input){
        String[] inputD = input.split(",");
        inp = inputD;
    }
    
    public void writeSNNGen_Temp(){
        String source = "";
        source += importLibrary();
        source += setParameter();
        if(!(loadDataFile.equals("")))
            source += setInput();
        source += setNetwork();
        source += setTimestep();
        source += defAccuracy();
        source += setCompileFit();
        source += accuracyAfterTraining();
        writeFile(source);
    }
    
     public void writeSNNSingleGen(){
        String source = "";
        source += importLibrary();
        source += setParameter();
        source += setInput();
        source += setNetwork();
        source += setTimestep();
        writeFile(source);
    }
     
    public void writeSNNGenDL(int hModel, String compDir, int dataSetOpt){ 
        componentDir = compDir;
        componentName = compDir.substring(compDir.lastIndexOf("\\")+1);
        model = hModel; 
        this.dataSetOpt = dataSetOpt; 
        
        if (dataSetOpt == H_DATA_SET_TEST) {

            String dataSource = "";
            String impSource = "";

           
            dataSource += setConnectionPrev();
            dataSource += importLibrary(hModel, pyData);
            dataSource += setInput(hModel, pyData);
            dataSource += setConnectionNext(hModel, pyData);

            impSource += setConnectionPrev();
            impSource += importLibrary(hModel, pyImp);
            impSource += setInput(hModel, pyImp);
            impSource += setParameter(hModel);
            impSource += setNetwork(hModel);
            impSource += setTimestep(hModel);
            impSource += setConnectionNext(hModel, pyImp);

            writeFile(dataSource, pyData);
            writeFile(impSource, pyImp);

            destroy(8);
        } else {
            if (hModel == Linear)
                writeSNNSingleGen();
            else
               writeSNNGen_Temp(); 
        }
    }
    
    public String temp(int hModel, int type){
        String source = "";
        switch (hModel) {
            case Linear:
                if (type == pyData) {
                    source = "";
                } else if (type == pyImp) {
                    source = "";
                }
                break;
        }
        return source;
    }
     
    public String setConnectionPrev(){
        String source = "import os\r\n"
                + "import sys\r\n"
                + "class NullWriter (object):\r\n"
                + "    def write (self, arg):\r\n"
                + "        pass\r\n"
                + "    def flush(args):\r\n"
                + "        pass\r\n\r\n"
                + "nullwrite = NullWriter()\r\n"
                + "oldstdout = sys.stdout\r\n"
                + "sys.stdout = nullwrite\r\n\r\n";
        return source;
    }
    
    public String setConnectionNext(int hModel, int type) {
        String source = "";
        switch (hModel) {
            case Linear:
                if (type == pyData) {
                    source = "sys.stdout = oldstdout\r\n"
                            + "res = str(random_x_test).replace('[', '').replace(']', '') + '|' + str(result_y_test).replace('[', '').replace(']', '')\r\n"
                            + "print(res)\r\n"
                            + "sys.out.flush()\r\n";
                } else if (type == pyImp) {
                    source = "sys.stdout = oldstdout\r\n"
                            + "print(sim.data[out_p_filt][-1][-1])\r\n"
                            + "sys.stdout.flush()\r\n"
                            + "try:\r\n"
                            + "    output = {}\r\n"
                            + "    output[\"last\"] = sim.data[out_p_filt][0][-1].tolist()\r\n"
                            + "    output[\"data\"] = sim.data[out_p_filt][0].tolist()\r\n"
                            + "    output[\"trange\"] = sim.trange().tolist()\r\n"
                            + "    output[\"sim\"] = \"true\"\r\n"
                            + "    jstr = json.dumps(output)\r\n"
                            + "    print(\"sim:\"+jstr)\r\n"
                            + "    sys.stdout.flush()\r\n"
                            + "#except Exception as e:\r\n"
                            + "except Exception, e:\r\n"
                            + "    print(e)\r\n"
                            + "finally:\r\n"
                            + "    sys.stdout.flush()\r\n"
                            + "    \r\n"
                            + "try:\r\n"
                            + "    plt.figure()\r\n"
                            + "    plt.subplot(1, 2, 1)\r\n"
                            + "    plt.text(0, 0.8, f\"sepal width : {input_x}\")\r\n"
                            + "    plt.text(0, 0.7, f\"petal width : {res_y}\")\r\n"
                            + "    plt.text(0, 0.5, f\"result width : {sim.data[out_p_filt][-1][-1]}\")\r\n"
                            + "    plt.axis('off')\r\n"
                            + "    plt.subplot(1, 2, 2)\r\n"
                            + "    plt.plot(sim.trange(), sim.data[out_p_filt][0])\r\n"
                            + "    #plt.legend([str(i) for i in range(10)], loc=\"upper left\")\r\n"
                            + "    plt.show()\r\n"
                            + "#except Exception as e:\r\n"
                            + "except Exception, e:\r\n"
                            + "    print(e)\r\n"
                            + "sim.close()\r\n";
                }
                break;
            case MNIST:
                if(type == pyData){
                    source = "sys.stdout = oldstdout\r\n"
                            + "print(str(test_data[1][idx]) + \"|\" + str(test_data[0][idx]))\r\n"
                            + "sys.stdout.flush()\r\n\r\n";
                } else{
                    source = "sys.stdout = oldstdout\r\n"
                            + "try:\r\n"
                            + "    output = {}\r\n"
                            + "    output[\"last\"] = sim.data[out_p_filt][0][-1].tolist()\r\n"
                            + "    output[\"data\"] = sim.data[out_p_filt][0].tolist()\r\n"
                            + "    output[\"trange\"] = sim.trange().tolist()\r\n"
                            + "    output[\"sim\"] = \"true\"\r\n"
                            + "    jstr = json.dumps(output)\r\n"
                            + "    print(\"sim:\"+jstr)\r\n"
                            + "    sys.stdout.flush()\r\n"
                            + "#except Exception as e:\r\n"
                            + "except Exception, e:\r\n"
                            + "    print(e)\r\n"
                            + "finally:\r\n"
                            + "    sys.stdout.flush()\r\n"
                            + "\r\n"
                            + "\r\n"
                            + "plt.figure()\r\n"
                            + "plt.subplot(1, 2, 1)\r\n"
                            + "plt.imshow(np.reshape(test_data[inp][0, 0], (28, 28)),cmap=\"gray\")\r\n"
                            + "plt.axis('off')\r\n"
                            + "plt.subplot(1, 2, 2)\r\n"
                            + "plt.plot(sim.trange(), sim.data[out_p_filt][0])\r\n"
                            + "plt.legend([str(i) for i in range(10)], loc=\"upper left\")\r\n"
                            + "\r\n"
                            + "plt.show()\r\n";
                }
        }
        return source;
    }
    
    public String importLibrary(){
        String source = "import os\r\n" + 
                        "import numpy as np\r\n" + 
			"import tensorflow as tf\r\n" + 
			"import matplotlib.pyplot as plt\r\n" + 
			"import nengo\r\n" + 
			"import nengo_dl\r\n" +
                        "from sklearn import datasets\r\n" +
                        "from urllib.request import urlretrieve\r\n\r\n";
        return source;
    }
    
    public String importLibrary(int hModel, int type){
        String source = "";
        switch (hModel) {
            case Linear:
                if (type == pyData) {
                    source = "import numpy as np\r\n"
                            + "import random\r\n"
                            + "from sklearn import datasets\r\n\r\n";
                } else if (type == pyImp) {
                    source = "import numpy as np\r\n"
                            + "import matplotlib.pyplot as plt\r\n"
                            + "import random\r\n"
                            + "import nengo\r\n"
                            + "import nengo_dl\r\n"
                            + "import json\r\n\r\n";
                }
                break;
            case MNIST:
                if (type == pyData) {
                    source = "import gzip\r\n"
                            + "import pickle\r\n"
                            + "import zipfile\r\n"
                            + "from urllib.request import urlretrieve\r\n"
                            + "import random\r\n\r\n";
                } else if (type == pyImp) {
                    source = "import nengo\r\n"
                            + "import nengo_dl\r\n"
                            + "import numpy as np\r\n"
                            + "import tensorflow as tf\r\n"
                            + "import matplotlib.pyplot as plt\r\n"
                            + "from urllib.request import urlretrieve\r\n"
                            + "import json\r\n\r\n";
                }
                break;
        }

        return source;
    }
    
    public String setParameter(){
        String source = "amp = " + hSCfg.getAmplitude() + " \r\n"
                        + "max_rates = " + hSCfg.getMax_rates() + "\r\n"
                        + "tau_rc = " + hSCfg.getTau_rc() + "\r\n"
                        + "noise_filter = " + hSCfg.getSynapse()+ "\r\n"
                        + "intercepts = " + hSCfg.getIntercepts() + "\r\n"
                        + "synapse = "+hSCfg.getSynapse()+"\r\n" //20220519
                        +"minibatch_size = "+hSCfg.getBatch_size() + "\r\n\r\n";
        if(dataSetOpt ==H_DATA_SET_TRAINING){
            source += "epochs = "+hSCfg.getEpoch()+"\r\n";
            source += "seed = 1\r\n";} 
        else
            source += "seed = 1\r\n";
        return source;
    }
    
    public String setParameter(int hModel) {
        String source = "";
        switch (hModel) {
            case Linear:
                source = "amp = " + hSCfg.getAmplitude() + " \r\n"
                        + "max_rates = " + hSCfg.getMax_rates() + "\r\n"
                        + "tau_rc = " + hSCfg.getTau_rc() + "\r\n"
                        + "noise_filter = " + hSCfg.getSynapse()+ "\r\n"
                        + "intercepts = " + hSCfg.getIntercepts() + "\r\n"
                        + "minibatch_size = " + hSCfg.getBatch_size() + "\r\n\r\n";
                if (dataSetOpt == H_DATA_SET_TRAINING) {
                    source += "epochs = " + hSCfg.getEpoch() + "\r\n";
                } else {
                    source += "seed = 1\r\n";
                }
                break;
            case MNIST:
                source = "# neuron type\r\n"
                        + "amp = " + hSCfg.getAmplitude() + "\r\n"
                        + "max_rates = " + hSCfg.getMax_rates() + "\r\n"
                        + "intercepts = " + hSCfg.getIntercepts() + "\r\n"
                        + "tau_rc = " + hSCfg.getTau_rc() + "\r\n"
                        + "synapse = " + hSCfg.getSynapse()+ " #noise_filter\r\n"
                        + "\r\n"
                        + "#evaluation\r\n"
                        + "minibatch_size = " + hSCfg.getBatch_size() + "\r\n"
                        + "n_steps = 20\r\n\r\n";
        }

        return source;
    }
    
    public void setData(String dataFileDir, String delimiter){
        loadDataFile = dataFileDir; 
        dataFileDelimiter = delimiter;
        
    }
    
    public String setInput(){ //
        int yRange_temp = 0;
            
        String source ="";
        
        if(model == Linear){ 
            
            source += "iris = datasets.load_iris()\r\n"
                    + "x_data = np.array([[x[1] for x in iris.data]]).T # sepal width  #(150, 1)\r\n"
                    + "y_data = np.array([[y[3] for y in iris.data]]).T # petal width  #(150, 1)\r\n"
                    + "\r\n"
                    + "# Random Value\r\n"
                    + "ridx = 0 #random.randrange(0, 3)\r\n"
                    + "rv = int(tf.random.uniform([1], 0, 7))\r\n"
                    + "\r\n"
                    + "# Train Data (43~50)\r\n"
                    + "x_test = x_data[ridx * 50 + 43:ridx * 50 + 50] # setosa test  #(15, 1)\r\n"
                    + "y_test = y_data[ridx * 50 + 43:ridx * 50 + 50] # setosa test  #(15, 1)\r\n"
                    + "\r\n"
                    + "random_x_test = x_test[rv]\r\n"
                    + "result_y_test = y_test[rv]\r\n"
                    + "\r\n"
                    + "res = str(random_x_test).replace('[', '').replace(']', '') + '|' + str(result_y_test).replace('[', '').replace(']', '')\r\n"
                    + "\r\n"
                    + "data = res.split('|')\r\n"
                    + "input_x = float(data[0])\r\n"
                    + "res_y =float(data[1])\r\n"
                    + "\r\n"
                    + "x_data = np.array([[input_x]]).T # sepal width  #(150, 1)\r\n"
                    + "y_data = np.array([[res_y]]).T # petal width #(150, 1)\r\n"
                    + "\r\n"
                    + "x_test = x_data[0] # setosa test  #(15, 1)\r\n"
                    + "y_test = y_data[0] # setosa test  #(15, 1)\r\n\r\n";
        } else {
            if (dataSetOpt == H_DATA_SET_TRAINING) {
                source = source + "data = np.loadtxt(\"../DataSets/" + loadDataFile + "\", delimiter=\"" + dataFileDelimiter + "\", dtype = np.float32)\r\n"
                        + "train_images = data[:," + (hSCfg.getxRange1() - 1) + ":" + hSCfg.getxRange2() + "]\r\n";
                if (hSCfg.getyRange2() - hSCfg.getyRange1() == 1 && hSCfg.getyRange1() == 0) {
                    source = source + "train_labels = data[:," + yRange_temp + "]\r\n\r\n";
                } else {
                    source = source + "train_labels = data[:," + (hSCfg.getyRange1() - 1) + ":" + hSCfg.getyRange2() + "]\r\n\r\n";
                }
            } else {
                source = source + "data = np.loadtxt(\"nodes/" + componentName + "/src/DataSets/" + loadDataFile + "\", delimiter=\"" + dataFileDelimiter + "\", dtype = np.float32)\r\n"
                        + "test_images = data[:," + (hSCfg.getxRange1() - 1) + ":" + hSCfg.getxRange2() + "]\r\n";
                if (hSCfg.getyRange2() - hSCfg.getyRange1() == 1 && hSCfg.getyRange1() == 0) {
                    source = source + "test_labels = data[:," + yRange_temp + "]\r\n\r\n";
                } else {
                    source = source + "test_labels = data[:," + (hSCfg.getyRange1() - 1) + ":" + hSCfg.getyRange2() + "]\r\n\r\n";
                }
            }
        }
        return source;
    }
    
    public String setInput(int hModel, int type){

            
        String source ="";
        switch (hModel) {
            case Linear:
                if (type == pyData) {
                    source = "iris = datasets.load_iris()\r\n"
                            + "x_data = np.array([[x[1] for x in iris.data]]).T # sepal width  #(150, 1)\r\n"
                            + "y_data = np.array([[y[3] for y in iris.data]]).T # petal width  #(150, 1)\r\n"
                            + "\r\n"
                            + "# Random Value\r\n"
                            + "ridx = 0 #random.randrange(0, 3)\r\n"
                            + "# sys.in (range 0 ~ 6)\r\n"
                            + "rv = int(sys.argv[1])\r\n"
                            + "\r\n"
                            + "# Train Data (43~50)\r\n"
                            + "x_test = x_data[ridx * 50 + 43:ridx * 50 + 50] # setosa test  #(15, 1)\r\n"
                            + "y_test = y_data[ridx * 50 + 43:ridx * 50 + 50] # setosa test  #(15, 1)\r\n"
                            + "\r\n"
                            + "random_x_test = x_test[rv]\r\n"
                            + "result_y_test = y_test[rv]\r\n\r\n";
                } else if (type == pyImp) {
                    source = "data = sys.argv[1].split('|')\r\n"
                            + "input_x = float(data[0])\r\n"
                            + "res_y =float(data[1])\r\n"
                            + "x_data = np.array([[input_x]]).T # sepal width  #(150, 1)\r\n"
                            + "y_data = np.array([[res_y]]).T # petal width #(150, 1)\r\n"
                            + "\r\n"
                            + "x_test = x_data[0] # setosa test  #(15, 1)\r\n"
                            + "y_test = y_data[0] # setosa test  #(15, 1)\r\n\r\n";
                }
                break;
            case MNIST:
                if(type == pyData){
                    source = "with gzip.open(\"na-components/"+componentName+"/src/DataSets/mnist.pkl.gz\") as f:\r\n"
                            + "    train_data, _, test_data = pickle.load(f, encoding=\"latin1\")\r\n"
                            + "\r\n"
                            + "train_data = list(train_data)\r\n"
                            + "test_data = list(test_data)\r\n"
                            + "idx = int(sys.argv[1])\r\n\r\n";
                }else {
                    source = "# String Data Parse\r\n"
                            + "select_number = int(sys.argv[2])\r\n"
                            + "data_arg = sys.argv[1]\r\n"
                            + "\r\n"
                            + "parse = data_arg.replace(\"\\r\", \"\")\r\n"
                            + "parse = parse.replace(\"\\n\", \"\")\r\n"
                            + "parse = parse.replace(\"[\", \"\")\r\n"
                            + "parse = parse.replace(\"]\", \"\")\r\n"
                            + "parse = parse.replace(\"0.\", \"#0.\")\r\n"
                            + "parse = parse.replace(\"1.\", \"#1.\")\r\n"
                            + "parse = parse.replace(\" \", \"\")\r\n"
                            + "parse_list = parse.split(\"#\")\r\n"
                            + "x_data = []\r\n"
                            + "y_data = []\r\n"
                            + "for i in range(1, len(parse_list)):\r\n"
                            + "    sd = parse_list[i]\r\n"
                            + "    fd = float(sd)\r\n"
                            + "    x_data.append(fd)\r\n"
                            + "x_data = np.array([x_data])\r\n"
                            + "for i in range(10):\r\n"
                            + "    if (i == select_number):\r\n"
                            + "        y_data.append(1.0)\r\n"
                            + "    else:\r\n"
                            + "        y_data.append(0.0)\r\n"
                            + "y_data = np.array([y_data])\r\n\r\n";
                }
        }

        return source;
    }
    public String setNetwork(){
        
        String source = "";
        if (model == Linear) {
            source += "with nengo.Network(seed=seed) as net:\r\n"
                    + "    net.config[nengo.Ensemble].max_rates = nengo.dists.Choice([max_rates])\r\n"
                    + "    net.config[nengo.Ensemble].intercepts = nengo.dists.Choice([intercepts])    \r\n"
                    + "    neuron_type=nengo.LIF(amplitude=amp, tau_rc=tau_rc)\r\n"
                    + "    inp = nengo.Node([0] * 1)    \r\n"
                    + "    ens = nengo.Ensemble(1, 1, neuron_type=neuron_type)\r\n"
                    + "    x = nengo.Connection(inp, ens.neurons, transform=nengo_dl.dists.Glorot(), synapse=None)\r\n"
                    + "    inp_p = nengo.Probe(inp)\r\n"
                    + "    out_p = nengo.Probe(x)\r\n"
                    + "    out_p_filt = nengo.Probe(x, synapse=noise_filter)\r\n"
                    + "sim = nengo_dl.Simulator(net, minibatch_size=minibatch_size)\r\n"
                    + "\r\n";
            if(dataSetOpt == H_DATA_SET_TRAINING)
                    source += "sim.load_params(\"../DataSets/iris_train_data/train\")\r\n\r\n";
            else{
                    source += "sim.load_params(\"nodes/"+componentName+"/iris_train_data/train\")\r\n\r\n";
            }
        } else {
            source = "with nengo.Network(seed=0) as net:\r\n" + //20220519
            "    net.config[nengo.Ensemble].max_rates = nengo.dists.Choice([100])\r\n" +
            "    net.config[nengo.Ensemble].intercepts = nengo.dists.Choice([0])\r\n" +
            "    net.config[nengo.Connection].synapse = None\r\n" +
            "    neuron_type = nengo." + hSCfg.getNeuron_type() + "(amplitude=0.01)\r\n" +
            "\r\n" +
            "    nengo_dl.configure_settings(stateful=False)\r\n" +
            "\r\n" +
            "    inp = nengo.Node(np.zeros(" + inp[0] + "*" + inp[1] + "))\r\n" +
            "\r\n" +
            "    layer = nengo_dl.Layer(tf.keras.layers.Conv2D(filters=32, kernel_size=3))(inp, shape_in=(" + inp[0] + ", " + inp[1] + ", 1))\r\n" +
            "    layer = nengo_dl.Layer(neuron_type)(layer)\r\n" +
            "\r\n" +
            "    layer = nengo_dl.Layer(tf.keras.layers.Conv2D(filters=64, strides=2, kernel_size=3))(layer, shape_in=(26, 26, 32))\r\n" +
            "    layer = nengo_dl.Layer(neuron_type)(layer)\r\n" +
            "\r\n" +
            "    layer = nengo_dl.Layer(tf.keras.layers.Conv2D(filters=128, strides=2, kernel_size=3))(layer, shape_in=(12, 12, 64))\r\n" +
            "    layer = nengo_dl.Layer(neuron_type)(layer)\r\n" +
            "\r\n" +
            "    out = nengo_dl.Layer(tf.keras.layers.Dense(units=" + hSCfg.getOutput() + "))(layer)\r\n" +
            "\r\n" +
            "    out_p = nengo.Probe(out, label=\"out_p\")\r\n" +
            "    out_p_filt = nengo.Probe(out, synapse=0.1, label=\"out_p_filt\")\r\n" +
            "\r\n" +
            "sim = nengo_dl.Simulator(net, minibatch_size=minibatch_size)\r\n";
        }
        return source;
    }
    public String setNetwork(int hModel){
        String source = "";
        switch (hModel) {
            case Linear:
                source += "with nengo.Network(seed=seed) as net:\r\n"
                    + "    net.config[nengo.Ensemble].max_rates = nengo.dists.Choice([max_rates])\r\n"
                    + "    net.config[nengo.Ensemble].intercepts = nengo.dists.Choice([intercepts])    \r\n"
                    + "    neuron_type=nengo.LIF(amplitude=amp, tau_rc=tau_rc)\r\n"
                    + "    inp = nengo.Node([0] * 1)    \r\n"
                    + "    ens = nengo.Ensemble(1, 1, neuron_type=neuron_type)\r\n"
                    + "    x = nengo.Connection(inp, ens.neurons, transform=nengo_dl.dists.Glorot(), synapse=None)\r\n"
                    + "    inp_p = nengo.Probe(inp)\r\n"
                    + "    out_p = nengo.Probe(x)\r\n"
                    + "    out_p_filt = nengo.Probe(x, synapse=noise_filter)\r\n"
                    + "sim = nengo_dl.Simulator(net, minibatch_size=minibatch_size)\r\n"
                    + "\r\n";
                if (dataSetOpt == H_DATA_SET_TRAINING) {
                    source += "sim.load_params(\"../DataSets/iris_train_data/train\")\r\n\r\n";
                } else {
                    source += "sim.load_params(\"na-components/" + componentName + "/src/DataSets/iris_train_data/train\")\r\n\r\n";
                }
               
                break;
            case MNIST:
                source = "with nengo.Network(seed=0) as net:\r\n"
                    + "    neuron_type = nengo.LIF(amplitude=amp, tau_rc=tau_rc)\r\n"    
                    + "    net.config[nengo.Ensemble].max_rates = nengo.dists.Choice([max_rates])\r\n"
                    + "    net.config[nengo.Ensemble].intercepts = nengo.dists.Choice([intercepts])\r\n"
                    + "    nengo_dl.configure_settings(trainable=False)\r\n"

                    + "    \r\n"
                    + "    inp = nengo.Node(np.zeros(" + inp[0] + "*" + inp[1] + "))  \r\n" + 
                    "\r\n"
                    + addLayerSource
                    + "\r\n"
                    + "    out_p = nengo.Probe(layer)\r\n"
                    + "    out_p_filt = nengo.Probe(layer, synapse=synapse)\r\n"
                    + "\r\n"
                    + "sim = nengo_dl.Simulator(net, minibatch_size=minibatch_size)\r\n\r\n";
        }

        return source;
        
    }
    
    public String setTimestep(){
        String source = "";
        if (numLayer == 0 && dataSetOpt==H_DATA_SET_TEST){
            source += "n_steps = 300\r\n"
                    + "test_data = {\r\n"
                    + "        inp: np.tile(np.reshape(x_test, (x_test.shape[0], 1, 1)), (1, n_steps, 1)),\r\n"
                    + "        out_p_filt: np.tile(np.reshape(y_test, (y_test.shape[0], 1, 1)), (1, n_steps, 1))\r\n"
                    + "    }\r\n"
                    + "sim.run_steps(n_steps, data={inp: test_data[inp][:minibatch_size]})\r\n\r\n";
        }else if(!(numLayer == 0) && dataSetOpt==H_DATA_SET_TRAINING){
            source += "n_steps = 30\r\n"
                    + "train_images = train_images[:, None, :]\r\n"
                    + "train_labels = train_labels[:, None, None]\r\n"
                    + "\r\n";
        }
        else{
            
            source= source+"n_steps = 300\r\n" 
                    + "test_images = np.tile(test_images[:, None, :], (1, n_steps, 1))\r\n" 
                    + "test_labels = np.tile(test_labels[:, None, None], (1, n_steps, 1))\r\n\r\n";
        }
        return source;
    }
    
    public String setTimestep(int hModel){
        String source = "";
        switch (hModel) {
            case Linear:

                    source += "n_steps = 300\r\n"
                            + "test_data = {\r\n"
                            + "        inp: np.tile(np.reshape(x_test, (x_test.shape[0], 1, 1)), (1, n_steps, 1)),\r\n"
                            + "        out_p_filt: np.tile(np.reshape(y_test, (y_test.shape[0], 1, 1)), (1, n_steps, 1))\r\n"
                            + "    }\r\n"
                            + "sim.run_steps(n_steps, data={inp: test_data[inp][:minibatch_size]})\r\n\r\n";

            case MNIST:
                source += "n_steps = 20\r\n"
                        + "test_data = {\r\n"
                        + "    inp: np.tile(x_data, (1, n_steps, 1)),\r\n"
                        + "    out_p_filt: np.tile(y_data,(1, n_steps, 1))\r\n"
                        + "}\r\n"
                        + "sim.load_params(\"na-components/"+componentName+"/src/DataSets/mnist_params\")\r\n"
                        + "sim.run_steps(n_steps, data={inp: test_data[inp][:minibatch_size]})\r\n\r\n";
        }
        return source;
    }
    
    public String defAccuracy(){
        String source ="\r\ndef classification_accuracy(y_true, y_pred):\r\n" +
        "    return tf.metrics.sparse_categorical_accuracy(\r\n" +
        "        y_true[:, -1], y_pred[:, -1])\r\n\r\n" +
        "sim.compile(loss={out_p_filt: classification_accuracy})\r\n" +
        "print(\"accuracy before training:\",\r\n";
        if(dataSetOpt==H_DATA_SET_TRAINING){
          source = source+"      sim.evaluate(train_images, {out_p_filt: train_labels}, verbose=0)[\"loss\"])\r\n\r\n\r\n";
        }
        else{
            source = source+"      sim.evaluate(test_images, {out_p_filt: test_labels}, verbose=0)[\"loss\"])\r\n\r\n\r\n";
        }
        
        return source;
    }
    public String setCompileFit(){
        String modelDir_t = modelDir.replaceAll("\\\\", "/");
        String source = "";
        if(dataSetOpt==H_DATA_SET_TRAINING){
               source = source + 
                "sim.compile(\r\n"+
            "    optimizer=tf.optimizers."+hSCfg.getOptimizer()+"(learning_rate=0.01),\r\n"+
            "    loss = {out_p: tf.losses.";
        
            if(hSCfg.getLoss().equals("Cross Entropy")){
                source = source + "SparseCategoricalCrossentropy(from_logits=True)}\r\n";
            }
            source = source +"    )\r\n"+
            "sim.fit(train_images, {out_p: train_labels}, epochs=epochs)\r\n" +      
            "sim.save_params(\""+modelDir_t+"/"+modelName+"\")\r\n";
        }
        else{
            source = source + "if os.path.isfile(\"nodes/"+componentName+"/"+modelName+".npz\"):\r\n" +
            "    sim.load_params(\"nodes/"+componentName+"/"+modelName+"\")\r\n" +
            "    print(\"file load success\")\r\n" +
            "else:\r\n" +
            "    print(\"file does not existed\")\r\n" +
            "    urlretrieve(\r\n" +
            "        \"https://drive.google.com/uc?export=download&\"\r\n" +
            "        \"id=1l5aivQljFoXzPP5JVccdFXbOYRv3BCJR\",\r\n" +
            "        \"nodes/"+componentName+"/"+modelName+".npz\")\r\n\r\n";
        }
        source = source +"\r\nsim.load_params(\""+modelDir_t+"/"+modelName+"\")\r\n"
                +"\r\n"
                +"data = np.loadtxt(\"../DataSets/mnist_test_100.csv\", delimiter=\"" + dataFileDelimiter + "\", dtype = np.float32)\r\n"
                        + "test_images = data[:," + (hSCfg.getxRange1() - 1) + ":" + hSCfg.getxRange2() + "]\r\n"
                        + "test_labels = data[:,0]\r\n\r\n"; 
        return source;
    }
    
    public String accuracyAfterTraining(){
        String source="sim.compile(loss={out_p_filt: classification_accuracy})\r\n\r\n";
        if(dataSetOpt==H_DATA_SET_TRAINING){
                source += "test_images = np.tile(test_images[:, None, :], (1, n_steps, 1))\r\n"
                    + "test_labels = np.tile(test_labels[:, None, None], (1, n_steps, 1))\r\n"
                    + "print(\"accuracy after training:\", sim.evaluate(test_images, {out_p_filt: test_labels}, verbose=0)[\"loss\"])\r\n\""
                    + "\r\n";        
        }
        else{
            source= source + "print(\"accuracy after training:\", sim.evaluate(test_images, {out_p_filt: test_labels}, verbose=0)[\"loss\"])\r\n";
        }
        source = source + "\r\n" +
        "print(\"finished\")\r\n" +
        "\r\n";
        
        return source;
    }
    
    public String setAddLayer(HSNNLayerConfig[] hSLCfg_p){
        String source = "";
        int i;
        int shape[] = new int[numLayer];
        int filter[] = new int[numLayer];
        int stride[] = new int[numLayer];
       
      
        for(i=0; i<numLayer; i++){
            filter[i]=hSLCfg_p[i].getFilter();
            
            source += "    layer = nengo_dl.tensor_layer(";
            if(i==0) {
                shape[i] = Integer.parseInt(inp[0]);
                source += "inp, tf.layers.conv2d, shape_in=("+shape[i]+", "+shape[i]+", 1), filters=" + hSLCfg_p[i].getFilter()+", "
                    + "kernel_size="+hSLCfg_p[i].getKernel()+")\r\n"
                    + "    layer = nengo_dl.tensor_layer(layer, neuron_type)\r\n";
            }
            else {
                source += "layer, ";
                if (hSLCfg_p[i].getOption() == CONV){
                    stride[i] = hSLCfg_p[i].getStride();
                    if(stride[i-1]==0) shape[i]=(shape[i-1] - hSLCfg_p[i-1].getKernel() +1);
                    else shape[i]=(shape[i-1] - hSLCfg_p[i-1].getKernel())/(stride[i-1]) + 1;
                    source +="tf.layers.conv2d, shape_in=("+shape[i]+", "+shape[i]+", "+hSLCfg_p[i-1].getFilter()+"), filters=" + hSLCfg_p[i].getFilter()+", "
                    + "kernel_size="+hSLCfg_p[i].getKernel()+")\r\n"
                    + "    layer = nengo_dl.tensor_layer(layer, neuron_type)\r\n";
                }
                else {//getOption() == POOL
                    stride[i] = hSLCfg_p[i].getStride();
                    if(stride[i-1]==0) shape[i]=(shape[i-1] - hSLCfg_p[i-1].getKernel() +1);
                    else shape[i]=(shape[i-1] - hSLCfg_p[i-1].getKernel())/(stride[i-1]) + 1;
                    source +="tf.layers.average_pooling2d, shape_in=("+shape[i]+", "+shape[i]+", "+hSLCfg_p[i-1].getFilter()+"),pool_size=" + hSLCfg_p[i].getKernel()+", "
                    + "strides="+hSLCfg_p[i].getStride()+")\r\n";
                }
            }

        }
        source += "    layer = nengo_dl.tensor_layer(layer, tf.layers.dense, units="+hSCfg.getOutput()+")";
 
        
        return source;
    }
    
    public String reAdjustInput(){
        String hIOinput = inp[0]; 
        return hIOinput;
    }
    
    public String errorDataSet(){
        String source = "print(\"Data Set Error!!\")";
        return source;
    }
   
}

