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
public class HN3MLStbpGenerator extends HN3MLGeneratorConfig{
        
    
    private int hN3mlNeuronModel = 0; 
    
    private HN3MLIOConfig hn3mlCfg=new HN3MLIOConfig();
    
    public HN3MLStbpGenerator(HN3MLIOConfig n3mlCfg, int neuronmodel) {
        super();
        hN3mlNeuronModel = neuronmodel;
        hn3mlCfg = n3mlCfg;
    }
    public String createSTBP(){
        String source = importLibrary() + CreatePlot() + CreateValidate()
                + CreateTrain() + CreateApp() + mainTest();
        return source;
    }
    
    private String importLibrary() {
        String source = "import numpy as np\r\n"
                + "import time\r\n"
                + "import argparse\r\n"
                + "\r\n"
                + "import torch\r\n"
                + "import torchvision\r\n"
                + "from torchvision.transforms import transforms\r\n"
                + "\r\n"
                + "import torch.nn as nn\r\n"
                + "import torch.optim as optim\r\n"
                + "\r\n"
                + "import matplotlib.pyplot as plt\r\n"
                + "\r\n"
                + "import n3ml.model\r\n";
        return source + "\r\n";
    }

    private String CreatePlot() {
        String source = "class Plot:\r\n"
                + "    def __init__(self):\r\n"
                + "        plt.ion()\r\n"
                + "        self.fig, self.ax = plt.subplots(figsize=(10, 10))\r\n"
                + "        self.ax2 = self.ax.twinx()\r\n"
                + "        plt.title('STBP')\r\n"
                + "\r\n"
                + "    def update(self, y1, y2):\r\n"
                + "        x = torch.arange(y1.shape[0]) * 64\r\n"
                + "\r\n"
                + "        ax1 = self.ax\r\n"
                + "        ax2 = self.ax2\r\n"
                + "\r\n"
                + "        ax1.plot(x, y1, 'g')\r\n"
                + "        ax2.plot(x, y2, 'b')\r\n"
                + "\r\n"
                + "        ax1.set_xlabel('number of images')\r\n"
                + "        ax1.set_ylabel('accuracy', color='g')\r\n"
                + "        ax2.set_ylabel('loss', color='b')\r\n"
                + "\r\n"
                + "        self.fig.canvas.draw()\r\n"
                + "        self.fig.canvas.flush_events()\r\n";
        return source + "\r\n";
    }

    private String CreateValidate() {
        String source = "def validate(val_loader, model, criterion):\r\n"
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
                + "        labels_ = torch.zeros(torch.numel(labels), 10).cuda()\r\n"
                + "        labels_ = labels_.scatter_(1, labels.view(-1, 1), 1)\r\n"
                + "\r\n"
                + "        loss = criterion(preds, labels_)\r\n"
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
                + "    plotter = Plot()\r\n"
                + "\r\n"
                + "    total_images = 0\r\n"
                + "    num_corrects = 0\r\n"
                + "    total_loss = 0\r\n"
                + "\r\n"
                + "    list_loss = []\r\n"
                + "    list_acc = []\r\n"
                + "\r\n"
                + "    for step, (images, labels) in enumerate(train_loader):\r\n"
                + "\r\n"
                + "        images = images.cuda()\r\n"
                + "        labels = labels.cuda()\r\n"
                + "\r\n"
                + "        preds = model(images)\r\n"
                + "\r\n"
                + "        labels_ = torch.zeros(torch.numel(labels), 10).cuda()\r\n"
                + "        labels_ = labels_.scatter_(1, labels.view(-1, 1), 1)\r\n"
                + "\r\n"
                + "        # print(\"label: {} - prediction: {}\".format(labels.detach().cpu().numpy()[0], preds.detach().cpu().numpy()[0]))\r\n"
                + "\r\n"
                + "        o = preds.detach().cpu().numpy()[0]\r\n"
                + "\r\n"
                + "        # print(\"label: {} - prediction:\\n\".format(labels.detach().cpu().numpy()[0]))\r\n"
                + "        # pp.print(\"neuron's index\\t0\\t1\\t2\\t3\\t4\\t5\\t6\\t7\\t8\\t9\")\r\n"
                + "        # print(\"neuron's voltages\\t{}\\t{}\\t{}\\t{}\\t{}\\t{}\\t{}\\t{}\\t{}\".format(o[0], o[1], o[2], o[3], o[4], o[5], o[6], o[7], o[8], o[9]))\r\n"
                + "\r\n"
                + "        print(\"label: {} - output neuron's voltages: {}\".format(labels.detach().cpu().numpy()[0], o))\r\n"
                + "\r\n"
                + "        loss = criterion(preds, labels_)\r\n"
                + "\r\n"
                + "        optimizer.zero_grad()\r\n"
                + "        loss.backward()\r\n"
                + "        optimizer.step()\r\n"
                + "\r\n"
                + "        num_corrects += torch.argmax(preds, dim=1).eq(labels).sum(dim=0)\r\n"
                + "        total_loss   += loss.cpu().detach().numpy() * images.size(0)\r\n"
                + "        total_images += images.size(0)\r\n"
                + "\r\n"
                + "        if total_images > 0:  #  and total_images % 30 == 0\r\n"
                + "            list_loss.append(total_loss / total_images)\r\n"
                + "            list_acc.append(float(num_corrects) / total_images)\r\n"
                + "            plotter.update(y1=np.array(list_acc), y2=np.array(list_loss))\r\n"
                + "\r\n"
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
                + "    # Load MNIST / FashionMNIST dataset\r\n"
                + "    train_loader = torch.utils.data.DataLoader(\r\n"
                + "        torchvision.datasets.MNIST(\r\n"
                + "            opt.data,\r\n"
                + "            train=True,\r\n"
                + "            download = True,\r\n"
                + "            transform=torchvision.transforms.Compose([\r\n"
                + "                transforms.ToTensor(), transforms.Lambda(lambda x: x * 32)])),\r\n"
                + "        drop_last = True,\r\n"
                + "        batch_size=opt.batch_size,\r\n"
                + "        shuffle=True)\r\n"
                + "\r\n"
                + "    # Load MNIST/ FashionMNIST dataset\r\n"
                + "    val_loader = torch.utils.data.DataLoader(\r\n"
                + "        torchvision.datasets.MNIST(\r\n"
                + "            opt.data,\r\n"
                + "            train=False,\r\n"
                + "            download=True,\r\n"
                + "            transform=torchvision.transforms.Compose([\r\n"
                + "                transforms.ToTensor(), transforms.Lambda(lambda x: x * 32)])),\r\n"
                + "        drop_last=True,\r\n"
                + "        batch_size=opt.batch_size,\r\n"
                + "        shuffle=True)\r\n"
                + "\r\n"
                + "\r\n"
                + "    model = n3ml.model.Wu2018(batch_size=opt.batch_size, time_interval=opt.time_interval).cuda()\r\n"
                + "\r\n"
                + "    criterion = nn.MSELoss()\r\n"
                + "    optimizer = torch.optim.Adam(model.parameters(), lr = opt.lr)\r\n"
                + "    lr_scheduler = optim.lr_scheduler.MultiStepLR(optimizer, milestones=[30, 60, 90])\r\n"
                + "    best_acc = 0\r\n"
                + "\r\n"
                + "    for epoch in range(opt.num_epochs):\r\n"
                + "        start = time.time()\r\n"
                + "        train_acc, train_loss = train(train_loader, model, criterion, optimizer)\r\n"
                + "        end = time.time()\r\n"
                + "        print('total time: {:.2f}s - epoch: {} - accuracy: {} - loss: {}'.format(end-start, epoch, train_acc, train_loss))\r\n"
                + "\r\n"
                + "        val_acc, val_loss = validate(val_loader, model, criterion)\r\n"
                + "\r\n"
                + "        if val_acc > best_acc:\r\n"
                + "            best_acc = val_acc\r\n"
                + "            state = {\r\n"
                + "                'epoch': epoch,\r\n"
                + "                'model': model.state_dict(),\r\n"
                + "                'best_acc': best_acc,\r\n"
                + "                'optimizer': optimizer.state_dict()}\r\n"
                + "\r\n"
                + "            print('in test, epoch: {} - best accuracy: {} - loss: {}'.format(epoch, best_acc, val_loss))\r\n"
                + "\r\n"
                + "        lr_scheduler.step()\r\n";
        return source + "\r\n";
    }

    private String mainTest() {
        String source = "if __name__ == '__main__':\r\n"
                + "    parser = argparse.ArgumentParser()\r\n"
                + "    parser.add_argument('--data',          default='../DataSets')\r\n"
                + "    parser.add_argument('--num_classes',   default="+hn3mlCfg.getNumofClasses()+",    type=int)\r\n"
                + "    parser.add_argument('--num_epochs',    default="+hn3mlCfg.getEpoch()+",   type=int)\r\n"
                + "    parser.add_argument('--batch_size',    default="+hn3mlCfg.getBatch_size()+",    type=int)\r\n"
                + "    parser.add_argument('--num_workers',   default="+hn3mlCfg.getWorkers()+",     type=int)\r\n"
                + "    parser.add_argument('--time_interval', default="+hn3mlCfg.getIntervalTime()+",     type=int)\r\n"
                + "    parser.add_argument('--lr',            default="+hn3mlCfg.getLearning_rate()+", type=float)\r\n"
                + "\r\n"
                + "    app(parser.parse_args())\r\n";
        return source + "\r\n";
    }
}
