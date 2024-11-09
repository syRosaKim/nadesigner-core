/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.inha.generator.n3ml;

import org.iesw.inha.ioconfig.ai.HN3MLIOConfig;

/**
 *
 * @author SeoyeonKim
 */
public class HN3MLStdpGenerator extends HN3MLGeneratorConfig{
        
    
    private int hN3mlNeuronModel = 0; 
    
    private HN3MLIOConfig hn3mlCfg=new HN3MLIOConfig();
    
    public HN3MLStdpGenerator(HN3MLIOConfig n3mlCfg, int neuronmodel) {
        super();
        hN3mlNeuronModel = neuronmodel;
        hn3mlCfg = n3mlCfg;
    }

    public String createSTDP(){
        String source = importLibrary() + CreateApp() + mainTest();
        return source;
    }
    private String importLibrary() {
        String source = "import time\r\n"
                + "import argparse\r\n"
                + "\r\n"
                + "import numpy as np\r\n"
                + "\r\n"
                + "import torch\r\n"
                + "import torchvision\r\n"
                + "from torchvision.transforms import transforms\r\n"
                + "\r\n"
                + "from n3ml.model import DiehlAndCook2015\r\n"
                + "from n3ml.visualizer import plot\r\n"
                + "from n3ml.encoder import PoissonEncoder\r\n"
                + "\r\n"
                + "np.set_printoptions(precision=3, linewidth=np.inf)\r\n";
        return source + "\r\n";
    }

    private String CreateApp() {
        String source = "def app(opt):\r\n"
                + "    print(opt)\r\n"
                + "\r\n"
                + "    # Load MNIST dataset\r\n"
                + "    train_loader = torch.utils.data.DataLoader(\r\n"
                + "        torchvision.datasets.MNIST(\r\n"
                + "            opt.data,\r\n"
                + "            train=True,\r\n"
                + "            transform=torchvision.transforms.Compose([\r\n"
                + "                # transforms.ToTensor(), transforms.Lambda(lambda x: x * 32)])),\r\n"
                + "                transforms.ToTensor(), transforms.Lambda(lambda x: x * 32 * 4)])),\r\n"
                + "        batch_size=opt.batch_size,\r\n"
                + "        shuffle=True)\r\n"
                + "\r\n"
                + "    # Define an encoder to generate spike train for an image\r\n"
                + "    encoder = PoissonEncoder(opt.time_interval)\r\n"
                + "\r\n"
                + "    # Define a model\r\n"
                + "    model = DiehlAndCook2015(neurons=opt.neurons).cuda()\r\n"
                + "\r\n"
                + "    fig = None\r\n"
                + "    mat = None\r\n"
                + "\r\n"
                + "    # Conduct training phase\r\n"
                + "    for epoch in range(opt.num_epochs):\r\n"
                + "        start = time.time()\r\n"
                + "        for step, (images, labels) in enumerate(train_loader):\r\n"
                + "            # Initialize a model\r\n"
                + "            model.init_param()\r\n"
                + "\r\n"
                + "            # print(images.view(28, 28).detach().numpy())\r\n"
                + "\r\n"
                + "            # Encode images into spiked_images\r\n"
                + "            images = images.view(1, 28, 28)\r\n"
                + "\r\n"
                + "            spiked_images = encoder(images)\r\n"
                + "            spiked_images = spiked_images.view(opt.time_interval, -1)\r\n"
                + "#            spiked_images = spiked_images.cuda()\r\n"
                + "\r\n"
                + "            # Train a model\r\n"
                + "            for t in range(opt.time_interval):\r\n"
                + "                # print(spiked_images[t].detach().cpu().numpy().reshape(28, 28))\r\n"
                + "\r\n"
                + "                model.run({'inp': spiked_images[t]})\r\n"
                + "\r\n"
                + "                # print(model.inp.s.cpu().numpy().reshape(28, 28))\r\n"
                + "                # print(model.exc.v)\r\n"
                + "                # print(model.exc.s.cpu().numpy())\r\n"
                + "\r\n"
                + "                # Update weights using learning rule\r\n"
                + "                model.update()\r\n"
                + "\r\n"
                + "            # Normalize weights\r\n"
                + "            model.normalize()\r\n"
                + "\r\n"
                + "            w = model.xe.w.detach().cpu().numpy()\r\n"
                + "            fig, mat = plot(fig, mat, w)\r\n"
                + "\r\n"
                + "            if (step+1) % 500 == 0: \r\n"
                + "                # check training time\r\n"
                + "                end = time.time()\r\n"
                + "                print(\"elpased time: {}\".format(end-start))\r\n"
                + "                print(\"{} images are used to train\".format(step+1))\r\n"
                + "\r\n"
                + "                # save model\r\n"
                + "                torch.save({\r\n"
                + "                    'epoch': epoch,\r\n"
                + "                    'step': step,\r\n"
                + "                    'model_state_dict': model.state_dict()\r\n"
                + "                }, 'pretrained/stdp_epoch-{}_step-{}.pt'.format(epoch, step+1))\r\n";
        return source + "\r\n";
    }

    private String mainTest() {
        String source = "if __name__ == '__main__':\r\n"
                + "    parser = argparse.ArgumentParser()\r\n"
                + "\r\n"
                + "    parser.add_argument('--data', default='../DataSets')\r\n"
                + "    parser.add_argument('--batch_size', default="+hn3mlCfg.getBatch_size()+", type=int)\r\n"
                + "    parser.add_argument('--time_step', default="+hn3mlCfg.getTimeStepsMs()+", type=int)         # 1ms\r\n"
                + "    parser.add_argument('--time_interval', default="+hn3mlCfg.getIntervalTime()+", type=int)   # 250ms\r\n"
                + "    parser.add_argument('--neurons', default=400, type=int)\r\n"
                + "\r\n"
                + "    parser.add_argument('--num_epochs', default="+hn3mlCfg.getEpoch()+", type=int)\r\n"
                + "\r\n"
                + "    app(parser.parse_args())\r\n";
        return source + "\r\n";
    }
}
