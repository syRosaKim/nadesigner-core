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
public class HN3MLBpStdpGenerator extends HN3MLGeneratorConfig{
    
    
    private int hN3mlNeuronModel = 0; 
    
    private HN3MLIOConfig hn3mlCfg=new HN3MLIOConfig();
    
    public HN3MLBpStdpGenerator(HN3MLIOConfig n3mlCfg, int neuronmodel) {
        super();
        hN3mlNeuronModel = neuronmodel;
        hn3mlCfg = n3mlCfg;
    }
    public String createBpSTDP(){
        String source = importLibrary() + CreatePlot() + CreateAccuracy()
                + CreateMSE() + CreateLabelEncoder() + CreateValidate() + CreateTrain()
                + CreateApp() + mainTest();
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
                + "import torchvision.transforms as transforms\r\n"
                + "\r\n"
                + "import n3ml.model\r\n"
                + "import n3ml.encoder\r\n"
                + "import n3ml.optimizer\r\n"
                + "\r\n"
                + "np.set_printoptions(threshold=np.inf, linewidth=np.nan)\r\n";
        return source + "\r\n";
    }

    private String CreatePlot() {
        String source = "class Plot:\r\n"
                + "    def __init__(self):\r\n"
                + "        plt.ion()\r\n"
                + "        self.fig, self.ax = plt.subplots(figsize=(10, 10))\r\n"
                + "        self.ax2 = self.ax.twinx()\r\n"
                + "        plt.title('BP-STDP')\r\n"
                + "\r\n"
                + "    def update(self, y1, y2):\r\n"
                + "        x = torch.arange(y1.shape[0]) * 30\r\n"
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

    private String CreateAccuracy() {
        String source = "def accuracy(r: torch.Tensor, label: int) -> torch.Tensor:\r\n"
                + "    \"\"\"\r\n"
                + "    :param r: (time interval, # classes) the spike trains of output neurons in T ms\r\n"
                + "    :param label:\r\n"
                + "    :return:\r\n"
                + "    \"\"\"\r\n"
                + "    return (torch.argmax(torch.sum(r, dim=0)) == label).float()\r\n";
        return source + "\r\n";
    }

    private String CreateMSE() {
        String source = "def mse(r: torch.Tensor,\r\n"
                + "        z: torch.Tensor,\r\n"
                + "        label: int,\r\n"
                + "        epsilon: int = 4) -> torch.Tensor:\r\n"
                + "    \"\"\"\r\n"
                + "    :param r: (time interval, # classes) the spike trains of output neurons in T ms\r\n"
                + "    :param z: (time interval, # classes) the desired spike trains in T ms\r\n"
                + "    :return:\r\n"
                + "    \"\"\"\r\n"
                + "    e = torch.zeros_like(r)\r\n"
                + "    for t in range(e.size(0)):\r\n"
                + "        if z[t, label] > 0.5:\r\n"
                + "            tt = t-epsilon if t-epsilon > 0 else 0\r\n"
                + "            for i in range(e.size(1)):\r\n"
                + "                if i == label:\r\n"
                + "                    if torch.sum(r[tt:t, i]) < 0.5:\r\n"
                + "                        e[t, i] = 1\r\n"
                + "                else:\r\n"
                + "                    if torch.sum(r[tt:t, i]) > 0.5:\r\n"
                + "                        e[t, i] = -1\r\n"
                + "    T = r.size(0)\r\n"
                + "    return (torch.sum(e, dim=[0, 1])/T)**2\r\n";
        return source + "\r\n";
    }

    private String CreateLabelEncoder() {
        String source = "def label_encoder(label, beta, num_classes, time_interval):\r\n"
                + "    r = torch.zeros((time_interval, num_classes))\r\n"
                + "    r[:, label] = torch.rand(time_interval) <= (beta/1000)\r\n"
                + "    return r\r\n";
        return source + "\r\n";
    }

    private String CreateValidate() {
        String source = "def validate(loader, model, encoder, criterion, opt):\r\n"
                + "    num_images = 0\r\n"
                + "    total_loss = 0.0\r\n"
                + "    num_corrects = 0\r\n"
                + "\r\n"
                + "    for image, label in loader:\r\n"
                + "        image = image.squeeze(dim=0).cuda()\r\n"
                + "        label = label.squeeze().cuda()\r\n"
                + "\r\n"
                + "        spiked_image = encoder(image)\r\n"
                + "        spiked_image = spiked_image.view(spiked_image.size(0), -1)\r\n"
                + "\r\n"
                + "        spiked_label = label_encoder(label, opt.beta, opt.num_classes, opt.time_interval)\r\n"
                + "\r\n"
                + "        loss_buffer = []\r\n"
                + "\r\n"
                + "        for t in range(opt.time_interval):\r\n"
                + "            model(spiked_image[t])\r\n"
                + "\r\n"
                + "            loss_buffer.append(model.fc2.o.clone())\r\n"
                + "\r\n"
                + "        model.reset_variables(w=False)\r\n"
                + "\r\n"
                + "        num_images += 1\r\n"
                + "        num_corrects += accuracy(r=torch.stack(loss_buffer), label=label)\r\n"
                + "        total_loss += criterion(r=torch.stack(loss_buffer), z=spiked_label, label=label, epsilon=opt.epsilon)\r\n"
                + "\r\n"
                + "    return total_loss/num_images, float(num_corrects)/num_images\r\n";
        return source + "\r\n";
    }

    private String CreateTrain() {
        String source = "def train(loader, model, encoder, optimizer, criterion, opt) -> None:\r\n"
                + "    plotter = Plot()\r\n"
                + "\r\n"
                + "    num_images = 0\r\n"
                + "    total_loss = 0.0\r\n"
                + "    num_corrects = 0\r\n"
                + "\r\n"
                + "    list_loss = []\r\n"
                + "    list_acc = []\r\n"
                + "\r\n"
                + "    for image, label in loader:\r\n"
                + "        # Squeeze batch dimension\r\n"
                + "        # Now, batch processing isn't supported\r\n"
                + "        image = image.squeeze(dim=0)\r\n"
                + "        label = label.squeeze()\r\n"
                + "\r\n"
                + "        spiked_image = encoder(image)\r\n"
                + "        spiked_image = spiked_image.view(spiked_image.size(0), -1)\r\n"
                + "\r\n"
                + "        spiked_label = label_encoder(label, opt.beta, opt.num_classes, opt.time_interval)\r\n"
                + "\r\n"
                + "        # print(label)\r\n"
                + "        # print(spiked_label)\r\n"
                + "        # exit(0)\r\n"
                + "\r\n"
                + "        # np_spiked_image = spiked_image.numpy()\r\n"
                + "\r\n"
                + "        spike_buffer = {\r\n"
                + "            'inp': [],\r\n"
                + "            'fc1': [],\r\n"
                + "            'fc2': []\r\n"
                + "        }\r\n"
                + "\r\n"
                + "        loss_buffer = []\r\n"
                + "\r\n"
                + "        print()\r\n"
                + "        print(\"label: {}\".format(label))\r\n"
                + "\r\n"
                + "        for t in range(opt.time_interval):\r\n"
                + "            # print(np_spiked_image[t])\r\n"
                + "\r\n"
                + "            model(spiked_image[t])\r\n"
                + "\r\n"
                + "            spike_buffer['inp'].append(spiked_image[t].clone())\r\n"
                + "            spike_buffer['fc1'].append(model.fc1.o.clone())\r\n"
                + "            spike_buffer['fc2'].append(model.fc2.o.clone())\r\n"
                + "\r\n"
                + "            loss_buffer.append(model.fc2.o.clone())\r\n"
                + "\r\n"
                + "            for l in spike_buffer.values():\r\n"
                + "                if len(l) > 5:  \r\n"
                + "                    l.pop(0)\r\n"
                + "\r\n"
                + "            # print(model.fc1.u.numpy())\r\n"
                + "            # print(model.fc1.o.numpy())\r\n"
                + "            # print(model.fc2.u.numpy())\r\n"
                + "            print(model.fc2.o.numpy())\r\n"
                + "\r\n"
                + "            # time.sleep(1)\r\n"
                + "\r\n"
                + "            optimizer.step(spike_buffer, spiked_label[t], label)\r\n"
                + "\r\n"
                + "        model.reset_variables(w=False)\r\n"
                + "\r\n"
                + "        num_images += 1\r\n"
                + "        num_corrects += accuracy(r=torch.stack(loss_buffer), label=label)\r\n"
                + "        total_loss += criterion(r=torch.stack(loss_buffer), z=spiked_label, label=label, epsilon=opt.epsilon)\r\n"
                + "\r\n"
                + "        if num_images > 0 and num_images % 30 == 0:\r\n"
                + "            list_loss.append(total_loss / num_images)\r\n"
                + "            list_acc.append(float(num_corrects) / num_images)\r\n"
                + "\r\n"
                + "            plotter.update(y1=np.array(list_acc), y2=np.array(list_loss))\r\n"
                + "\r\n"
                + "        # print(\"loss: {} - accuracy: {}\".format(total_loss/num_images, float(num_corrects)/num_images))\r\n"
                + "\r\n"
                + "    # return total_loss/num_images, float(num_corrects)/num_images\r\n";
        return source + "\r\n";
    }

    private String CreateApp() {
        String source = "def app(opt):\r\n"
                + "    print(opt)\r\n"
                + "\r\n"
                + "    # Load MNIST\r\n"
                + "    train_loader = torch.utils.data.DataLoader(\r\n"
                + "        torchvision.datasets.MNIST(\r\n"
                + "            opt.data,\r\n"
                + "            train=True,\r\n"
                + "            transform=torchvision.transforms.Compose([transforms.ToTensor()])),\r\n"
                + "        batch_size=opt.batch_size,\r\n"
                + "        shuffle=True)\r\n"
                + "\r\n"
                + "    val_loader = torch.utils.data.DataLoader(\r\n"
                + "        torchvision.datasets.MNIST(\r\n"
                + "            opt.data,\r\n"
                + "            train=False,\r\n"
                + "            transform=torchvision.transforms.Compose([transforms.ToTensor()])),\r\n"
                + "        batch_size=opt.batch_size,\r\n"
                + "        shuffle=False)\r\n"
                + "\r\n"
                + "    # Make a model\r\n"
                + "    model = n3ml.model.TravanaeiAndMaida2017(opt.num_classes, hidden_neurons=opt.hidden_neurons)\r\n"
                + "    model.reset_variables()\r\n"
                + "\r\n"
                + "    # Make an encoder\r\n"
                + "    encoder = n3ml.encoder.Simple(time_interval=opt.time_interval)\r\n"
                + "\r\n"
                + "    # Make an optimizer\r\n"
                + "    optimizer = n3ml.optimizer.TavanaeiAndMaida(model, lr=opt.lr)\r\n"
                + "\r\n"
                + "    # Define a loss\r\n"
                + "    criterion = mse\r\n"
                + "\r\n"
                + "    for epoch in range(opt.num_epochs):\r\n"
                + "        # loss, acc = train(train_loader, model, encoder, optimizer, criterion, opt)\r\n"
                + "        # print(\"epoch: {} - loss: {} - accuracy: {}\".format(epoch, loss, acc))\r\n"
                + "        train(train_loader, model, encoder, optimizer, criterion, opt)\r\n"
                + "\r\n"
                + "        loss, acc = validate(val_loader, model, encoder, criterion, opt)\r\n"
                + "        print(\"In test, loss: {} - accuracy: {}\".format(loss, acc))\r\n";
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
                + "    parser.add_argument('--time_interval', default="+hn3mlCfg.getIntervalTime()+", type=int)\r\n"
                + "    parser.add_argument('--beta', default="+hn3mlCfg.getBeta()+", type=float)            # 250 Hz\r\n"
                + "    parser.add_argument('--lr', default="+hn3mlCfg.getLearning_rate()+", type=float)\r\n"
                + "    parser.add_argument('--hidden_neurons', default="+hn3mlCfg.getHiddenNeuron()+", type=int)\r\n"
                + "    parser.add_argument('--epsilon', default="+hn3mlCfg.getEpsilon()+", type=int)\r\n"
                + "\r\n"
                + "    app(parser.parse_args())\r\n";
        return source + "\r\n";
    }
}
