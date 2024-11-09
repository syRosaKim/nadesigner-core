/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.inha.generator.ai;

import org.iesw.inha.generator.HAIGenerator;
import org.iesw.inha.generator.HGenerator;
import org.iesw.inha.ioconfig.ai.HSNNIOConfig;

/**
 *
 * @author jjh
 */
public class HSNNNAALGenerator extends HAIGenerator {
     private HSNNIOConfig hSCfg = new HSNNIOConfig();
    
    public String modelName="";
    public String modelDir="";
    public String componentName="";
    public String board = "";
    public String model_pre = "";
    String[] inp;
    
    public HSNNNAALGenerator(){
        super();
    }
    
    public void initConfig(HSNNIOConfig hSNNIOConfig, String mDir ){
        modelDir = mDir;
        hSCfg = hSNNIOConfig;
        board = hSCfg.getBoards();
        model_pre = hSCfg.getModelPrediction();
        String componentNameT[] =mDir.split("\\\\");
        for(int i=0; i<componentNameT.length; i++){
            if(i+1==componentNameT.length)
                componentName = componentNameT[i];
        }
        
    }
    
    public void writeSNN_NAALGen(){
        writeFile(importLibrary());
        writeFile(setFunction());    
        writeFile(setConfig());    
        writeFile(runCode());    
    }
    
    public String importLibrary(){
        String source = "from Naal.naal import Naal\r\n"+
                        "import Naal.input.naal_data_load as nl\r\n"+
                        "import sys\r\n"+
                        "import numpy as np\r\n\r\n";
        return source;
    }
     public String setFunction(){
         String source ="def get_key():\r\n"+
                        "    print('===========================================')\r\n"+
                        "    print('[1] run sinmulator    [enter] exit program')\r\n"+
                        "    print('===========================================')\r\n"+
                        "    key = input()\r\n"+
                        "    return str(key)\r\n"+
                        "class NullWriter:\r\n"+
                        "    def write(self,arg):\r\n"+
                        "        pass\r\n"+
                        "    def flush(args):\r\n"+
                        "        pass\r\n"+
                        "nullwriter = NullWriter()\r\n"+
                        "oldstdout = sys.stdout\r\n"+
                        "sys.stdout = nullwriter\r\n\r\n";
        return source;
    }
     public String setConfig(){
         String source = "";
         if(board=="DE1-SoC" && model_pre=="MNIST"){
             source = "hardware = \"de1\"\r\n"+
                     "simulation_time = 1.000\r\n"+
                     "dt = 0.001\r\n"+
                     "image_labels = [\"0\", \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\"]\r\n"+
                     "input_size = 196\r\n"+
                     "npz_path = \"./de1_mnist.npz\"\r\n";
         }
         else if(board=="DE1-SoC" && model_pre=="SpeechRecognition"){
             source = "hardware = \"de1\"\r\n"+
                     "simulation_time = 0.030\r\n"+
                     "dt = 0.001\r\n"+
                     "voice_labels = [\"up\", \"down\", \"center\", \"left\", \"right\"]\r\n"+
                     "input_size = 196\r\n"+
                     "npz_path = \"./de1_voice.npz\"\r\n";
         }
         else if(board=="PYNQ" && model_pre=="MNIST"){
             source = "hardware =\"pynq\"\r\n"+
                     "simulation_time = 1.000\r\n"+
                     "dt = 0.001\r\n"+
                     "image_labels = [\"0\", \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\"]\r\n"+
                     "input_size = 196\r\n"+
                     "npz_path = \"./pynq_mnist.npz\"\r\n";
         }
         else if(board == "Loihi" && model_pre=="MNIST"){
             source = "hardware = \"loihi\"\r\n"+
                     "simulation_time = 0.100\r\n"+
                     "dt = 0.001\r\n"+
                     "image_labels = [\"0\", \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\"]\r\n"+
                     "input_size = 784\r\n"+
                     "npz_path = \"mnist_loihi_test\"\r\n"+
                     "n_parallel = 1\r\n";
         }else{
             source = "지원하지 않는 모드\r\n";
         }
         return source;
     }
     public String runCode(){
         String source = "";
         if(board=="DE1-SoC" && model_pre=="MNIST"){
             source = "naal = Naal(hardware = hardware, dt = dt, \n" +
                      "            input_size = input_size, output_size = len(image_labels), \r\n" +
                      "            npz_path = npz_path)\r\n"+
                     "naal.set_sim_data(labels = image_labels, data_type = \"img\")\r\n"+
                     "print(\"============capture image, record voice===============\")\r\n"+
                     "path = nl.capture_image(board = 'pi')\n" +
                    "data = nl.load_img(path, input_size)\n" +
                    "naal.run(data, sim_time = simulation_time)\r\n\r\n\r\n" +
                    "results, execution_time = naal.get_result()\r\n" +
                    "max_idx = np.argmax(results)\r\n" +
                    "print(\"===============Printresult===================\")\r\n" +
                    "print(\"result spikes : \" , results)\r\n" +
                    "sys.stdout = oldstout\r\n"+
                    "print(\"predicted answer : \", image_labels[max_idx])\r\n" +
                    "sys.stdout.flush()\r\n"+
                    "print(\"execution time : \", execution_time * 256)\r\n" ;
         }
         else if(board=="DE1-SoC" && model_pre=="SpeechRecognition"){
             source = "naal = Naal(hardware = hardware, dt = dt, \r\n" +
                        "            input_size = input_size, output_size = len(voice_labels), \r\n" +
                        "            npz_path = npz_path)\r\n" +
                        "naal.set_sim_data(labels = voice_labels, data_type = \"voice\")\r\n" +
                        "print(\"init\")\r\n" +
                        "print(naal.get_sim_status())\r\n\r\n" +
                        "print(\"============capture image, record voice===============\")\r\n" +
                        "path = \"na-components/NAAL/"+componentName+"/src/hnu/"+"voice_rec.wav\"\r\n" +
                        "data = nl.load_voice(path, input_size)\r\n\r\n" +
                        "naal.run(data, sim_time = simulation_time)# Start \r\n" +
                        "results, execution_time = naal.get_result()\r\n" +
                        "max_idx = np.argmax(results)\r\n" +
                        "print(\"===============Printresult===================\")\r\n" +
                        "print(\"result spikes : \" , results)\r\n" +
                        "sys.stdout = oldstout\r\n"+
                        "print(\"predicted answer : \", voice_labels[max_idx])\r\n" +
                        "sys.stdout.flush()\r\n";

         }
         else if(board=="PYNQ" && model_pre=="MNIST"){
              source = "naal = Naal(hardware = hardware, dt = dt, \r\n" +
                        "            input_size = input_size, output_size = len(image_labels), \r\n" +
                        "            npz_path = npz_path)\r\n" +
                        "naal.set_sim_data(labels = image_labels, data_type = \"img\")\r\n\r\n" +
                        "print(\"============capture image, record voice===============\")\r\n" +
                        "path = nl.capture_image(board = 'pi')\r\n" +
                        "data = nl.load_img(path, input_size)\r\n" +
                        "naal.run(data, sim_time = simulation_time)\r\n\r\n\r\n" +
                        "results, execution_time = naal.get_result()\r\n" +
                        "max_idx = np.argmax(results)\r\n" +
                        "print(\"===============Printresult===================\")\r\n" +
                        "print(\"result spikes : \" , results)\r\n" +
                        "sys.stdout = oldstout\r\n"+
                        "print(\"predicted answer : \", image_labels[max_idx])\r\n" +
                        "print(\"execution time : \", execution_time * 256)\r\n" +
                        "sys.stdout.flush()\r\n";
         }
         else if(board == "Loihi" && model_pre=="MNIST"){
              source = "naal = Naal(hardware = hardware, dt = dt, \r\n" +
                        "            input_size = input_size, output_size = len(image_labels), \r\n" +
                        "            npz_path = npz_path)\r\n" +
                        "#(train_images, train_labels), (test_images, test_labels) = tf.keras.datasets.mnist.load_data()\r\n\r\n" +
                        "naal.build_loihi(simulation_time, (1, 28, 28), n_parallel)\r\n" +
                        "print(naal.get_sim_status())\r\n" +
                        "i = 0\r\n" +
                        "while \"1\" == get_key():\r\n" +
                        "    print(\"============capture image, record voice===============\")\r\n" +
                        "    path = nl.capture_image(board = 'pi')\r\n" +
                        "    data = nl.load_img('test_tmp.png', input_size)\r\n" +
                        "    test_image = test_images[i:i+1]\r\n" +
                        "    test_image = test_image.reshape((test_image.shape[0], -1))\r\n" +
                        "    #Pause\r\n" +
                        "    naal.run(data, sim_time = simulation_time)# Start \r\n" +
                        "    #Pause\r\n" +
                        "    results, execution_time = naal.get_result()\r\n" +
                        "    max_idx = np.argmax(results)\r\n" +
                        "    print(\"===============Printresult===================\")\r\n" +
                        "    print(\"result spikes : \" , results)\r\n" +
                        "sys.stdout = oldstout\r\n"+
                        "    print(\"predicted answer : \", image_labels[max_idx])\r\n" +
                        "    print(\"execution time : \", execution_time)\r\n" +
                        "    i += 1\r\n\r\n" +
                        "sys.stdout.flush()\r\n"+
                        "naal.stop_hardware()\r\n";
         }
         return source;
     }
   
}
