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
public class HN3MLSoftLIFGenerator extends HN3MLGeneratorConfig{
        
    
    private int hN3mlNeuronModel = 0; 
    
    private HN3MLIOConfig hn3mlCfg=new HN3MLIOConfig();
    
    public HN3MLSoftLIFGenerator(HN3MLIOConfig n3mlCfg, int neuronmodel) {
        super();
        hN3mlNeuronModel = neuronmodel;
        hn3mlCfg = n3mlCfg;
    }

    public String createSoftLIF() {
        String source = importLibrary() + CreateHunsberger2015() + CreateValidate() + 
                CreateTrain() + CreateApp() + mainTest();
        return source;
    }

    private String importLibrary() {
        String source = "import time\r\n"
                + "import argparse\r\n"
                + "\r\n"
                + "import numpy as np\r\n"
                + "\r\n"
                + "import matplotlib.pyplot as plt\r\n"
                + "\r\n"
                + "import torch\r\n"
                + "import torchvision\r\n"
                + "import torch.nn as nn\r\n"
                + "import torch.optim as optim\r\n"
                + "\r\n"
                + "from n3ml.model import Hunsberger2015\r\n";
        return source + "\r\n";
    }

    private String CreateHunsberger2015() {
        String source = "class Hunsberger2015(Network):\r\n"
                + "    def __int__(self):\r\n"
                + "        super(Hunsberger2015, self).__init__()\r\n"
                + "\r\n"
                + "    def forward(self, x):\r\n"
                + "        for m in self.named_children():\r\n"
                + "            x = m[1](x)\r\n"
                + "        return x\r\n";
        return source + "\r\n";
    }

    private String CreateValidate() {
        String source = "def validate(val_loader, model, criterion):\r\n"
                + "    model.eval()\r\n"
                + "\r\n"
                + "    total_images = 0\r\n"
                + "    num_corrects = 0\r\n"
                + "    total_loss = 0\r\n"
                + "\r\n"
                + "    for step, (images, labels) in enumerate(val_loader):\r\n"
                + "        images = images.cuda()\r\n"
                + "        labels = labels.cuda()\r\n"
                + "\r\n"
                + "        preds = model(images)\r\n"
                + "\r\n"
                + "        loss = criterion(preds, labels)\r\n"
                + "\r\n"
                + "        num_corrects += torch.argmax(preds, dim=1).eq(labels).sum(dim=0)\r\n"
                + "        total_loss += loss.cpu().detach().numpy() * images.size(0)\r\n"
                + "        total_images += images.size(0)\r\n"
                + "\r\n"
                + "    val_acc = num_corrects.float() / total_images\r\n"
                + "    val_loss = total_loss / total_images\r\n"
                + "\r\n"
                + "    return val_acc, val_loss\r\n";
        return source + "\r\n";
    }

    private String CreateTrain() {
        String source = "def train(train_loader, model, criterion, optimizer):\r\n"
                + "    model.train()\r\n"
                + "\r\n"
                + "    total_images = 0\r\n"
                + "    num_corrects = 0\r\n"
                + "    total_loss = 0\r\n"
                + "\r\n"
                + "    for step, (images, labels) in enumerate(train_loader):\r\n"
                + "        images = images.cuda()\r\n"
                + "        labels = labels.cuda()\r\n"
                + "\r\n"
                + "        preds = model(images)\r\n"
                + "\r\n"
                + "        loss = criterion(preds, labels)\r\n"
                + "\r\n"
                + "        optimizer.zero_grad()\r\n"
                + "        loss.backward()\r\n"
                + "        optimizer.step()\r\n"
                + "\r\n"
                + "        num_corrects += torch.argmax(preds, dim=1).eq(labels).sum(dim=0)\r\n"
                + "        total_loss += loss.cpu().detach().numpy() * images.size(0)\r\n"
                + "        total_images += images.size(0)\r\n"
                + "\r\n"
                + "    train_acc = num_corrects.float() / total_images\r\n"
                + "    train_loss = total_loss / total_images\r\n"
                + "\r\n"
                + "    return train_acc, train_loss\r\n";
        return source + "\r\n";
    }

    private String CreateApp() {
        String source = "def app(opt):\r\n"
                + "    print(opt)\r\n"
                + "\r\n"
                + "    train_loader = torch.utils.data.DataLoader(\r\n"
                + "        torchvision.datasets.CIFAR10(\r\n"
                + "            opt.data,\r\n"
                + "            train=True,\r\n"
                + "            transform=torchvision.transforms.Compose([\r\n"
                + "                torchvision.transforms.RandomCrop(24),\r\n"
                + "                torchvision.transforms.RandomHorizontalFlip(),\r\n"
                + "                torchvision.transforms.ToTensor(),\r\n"
                + "                torchvision.transforms.Normalize((0.4914, 0.4822, 0.4465), (0.2023, 0.1994, 0.2010))])),\r\n"
                + "        batch_size=opt.batch_size,\r\n"
                + "        shuffle=True)\r\n"
                + "\r\n"
                + "    val_loader = torch.utils.data.DataLoader(\r\n"
                + "        torchvision.datasets.CIFAR10(\r\n"
                + "            opt.data,\r\n"
                + "            train=False,\r\n"
                + "            transform=torchvision.transforms.Compose([\r\n"
                + "                torchvision.transforms.CenterCrop(24),\r\n"
                + "                torchvision.transforms.ToTensor(),\r\n"
                + "                torchvision.transforms.Normalize((0.4914, 0.4822, 0.4465), (0.2023, 0.1994, 0.2010))])),\r\n"
                + "        batch_size=opt.batch_size)\r\n"
                + "\r\n"
                + "    model = Hunsberger2015()\r\n";
        return source + "\r\n";
    }

    private String mainTest() {
        String source = "if __name__ == '__main__':\r\n"
                + "    parser = argparse.ArgumentParser()\r\n"
                + "\r\n"
                + "    parser.add_argument('--data', default='../DataSets')\r\n"
                + "    parser.add_argument('--num_classes', default="+hn3mlCfg.getNumofClasses()+", type=int)\r\n"
                + "    parser.add_argument('--num_epochs', default="+hn3mlCfg.getEpoch()+", type=int)\r\n"
                + "    parser.add_argument('--batch_size', default="+hn3mlCfg.getBatch_size()+", type=int)\r\n"
                + "    parser.add_argument('--num_workers', default=8, type=int)\r\n"
                + "    parser.add_argument('--lr', default="+hn3mlCfg.getLearning_rate()+", type=float)\r\n"
                + "    parser.add_argument('--momentum', default="+hn3mlCfg.getMomentum()+", type=float)\r\n"
                + "    parser.add_argument('--pretrained', default='pretrained/softlif.pt')\r\n"
                + "\r\n"
                + "    parser.add_argument('--amplitude', default="+hn3mlCfg.getAmplitude()+", type=float)\r\n"
                + "    parser.add_argument('--tau_ref', default="+hn3mlCfg.getTauRef()+", type=float)\r\n"
                + "    parser.add_argument('--tau_rc', default="+hn3mlCfg.getTau_rc()+", type=float)\r\n"
                + "    parser.add_argument('--gain', default="+hn3mlCfg.getGain()+", type=float)\r\n"
                + "    parser.add_argument('--sigma', default="+hn3mlCfg.getSigma()+", type=float)\r\n"
                + "\r\n"
                + "    app(parser.parse_args())\r\n";
        return source + "\r\n";
    }
        
}
