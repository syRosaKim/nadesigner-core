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
public class HN3MLSpikePropGenerator extends HN3MLGeneratorConfig{
        
    
    private int hN3mlNeuronModel = 0; 
    
    private HN3MLIOConfig hn3mlCfg=new HN3MLIOConfig();
    
    public HN3MLSpikePropGenerator(HN3MLIOConfig n3mlCfg, int neuronmodel) {
        super();
        hN3mlNeuronModel = neuronmodel;
        hn3mlCfg = n3mlCfg;
    }
    
    public String createSpikeProp(){
        String source = importLibrary() + CreatePlot() + CreateLabelEncoder()
                + CreateRMSE() + CreateDoCorrect() + CreateValidate() + CreateTrain()
                + CreateApp() + mainTest();
        return source;
    }
    
    private String importLibrary() {
        String source = "import argparse\r\n"
                + "\r\n"
                + "import numpy as np\r\n"
                + "\r\n"
                + "import matplotlib.pyplot as plt\r\n"
                + "\r\n"
                + "import torch\r\n"
                + "\r\n"
                + "import n3ml.model\r\n"
                + "import n3ml.data\r\n"
                + "import n3ml.encoder\r\n"
                + "import n3ml.optimizer\r\n";
        return source + "\r\n";
    }

    private String CreatePlot() {
        String source = "class Plot:\r\n"
                + "    def __init__(self):\r\n"
                + "        plt.ion()\r\n"
                + "        self.fig, self.ax = plt.subplots(figsize=(10, 10))\r\n"
                + "        self.ax2 = self.ax.twinx()\r\n"
                + "        plt.title('SpikeProp')\r\n"
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

    private String CreateLabelEncoder() {
        String source = "class LabelEncoder:\r\n"
                + "    def __init__(self, num_classes):\r\n"
                + "        self.num_classes = num_classes\r\n"
                + "\r\n"
                + "    def run(self, label):\r\n"
                + "        o = torch.zeros(self.num_classes)\r\n"
                + "        o.fill_(13)  # 15 13\r\n"
                + "        o[label].fill_(8)  # 5 7\r\n"
                + "        return o\r\n";
        return source + "\r\n";
    }

    private String CreateRMSE() {
        String source = "def rmse(pred, target):\r\n"
                + "    # print(\"pred: {} - target: {}\".format(pred, target))\r\n"
                + "    return torch.sum((pred[pred >= 0]-target[pred >= 0])**2)/2\r\n";
        return source + "\r\n";
    }

    private String CreateDoCorrect() {
        String source = "def do_correct(o, y):\r\n"
                + "    if torch.argmin(o) == (o.size(0)-torch.argmin(torch.flip(o, [0]))-1):\r\n"
                + "        return torch.argmin(o) == torch.argmin(y)\r\n"
                + "    return torch.tensor(False)\r\n";
        return source + "\r\n";
    }

    private String CreateValidate() {
        String source = "def validate(data, model, data_encoder, label_encoder, loss, opt):\r\n"
                + "    total_data = 0\r\n"
                + "    corrects = 0\r\n"
                + "    total_loss = 0\r\n"
                + "\r\n"
                + "    for i in range(data['test.data'].size(0)):\r\n"
                + "        model.initialize(delay=False)\r\n"
                + "\r\n"
                + "        input = data['test.data'][i]\r\n"
                + "        label = data['test.target'][i]\r\n"
                + "\r\n"
                + "        spiked_input = data_encoder.run(input)\r\n"
                + "        spiked_input = torch.cat((spiked_input.view(-1), torch.zeros(2)))\r\n"
                + "        spiked_label = label_encoder.run(label)\r\n"
                + "\r\n"
                + "        for t in range(opt.num_steps):\r\n"
                + "            model(torch.tensor(t).float(), spiked_input)\r\n"
                + "        o = model.fc2.s\r\n"
                + "\r\n"
                + "        total_data += 1\r\n"
                + "        corrects += do_correct(o, spiked_label)\r\n"
                + "        total_loss += loss(o, spiked_label)\r\n"
                + "\r\n"
                + "    avg_acc = corrects.float() / total_data\r\n"
                + "    avg_loss = total_loss / total_data\r\n"
                + "\r\n"
                + "    return avg_loss, avg_acc\r\n";
        return source + "\r\n";
    }

    private String CreateTrain() {
        String source = "def train(data, model, data_encoder, label_encoder, optimizer, loss, epoch, meter, acc_buffer, loss_buffer, plotter, opt):\r\n"
                + "    for i in range(data['train.data'].size(0)):\r\n"
                + "        model.initialize(delay=False)\r\n"
                + "\r\n"
                + "        input = data['train.data'][i]\r\n"
                + "        label = data['train.target'][i]\r\n"
                + "\r\n"
                + "        spiked_input = data_encoder.run(input)\r\n"
                + "        spiked_input = torch.cat((spiked_input.view(-1), torch.zeros(2)))\r\n"
                + "        spiked_label = label_encoder.run(label)\r\n"
                + "\r\n"
                + "        for t in range(opt.num_steps):\r\n"
                + "            model(torch.tensor(t).float(), spiked_input)\r\n"
                + "        o = model.fc2.s\r\n"
                + "\r\n"
                + "        # print(model.fc1.s)\r\n"
                + "        # print(model.fc2.s)\r\n"
                + "        # print(\"pred: {} - target: {}\".format(o, spiked_label))\r\n"
                + "        # l = loss(o, spiked_label)\r\n"
                + "        # print(\"loss: {}\".format(l))\r\n"
                + "\r\n"
                + "        optimizer.step(model, spiked_input, spiked_label, epoch)\r\n"
                + "\r\n"
                + "        meter['num_images'] += 1\r\n"
                + "        meter['num_corrects'] += do_correct(o, spiked_label)\r\n"
                + "        meter['total_losses'] += loss(o, spiked_label)\r\n"
                + "\r\n"
                + "        if (i+1) % 30 == 0:\r\n"
                + "            print(\"label: {} - target: {} - pred: {} - result: {}\".format(label, spiked_label, o, do_correct(o, spiked_label)))\r\n"
                + "\r\n"
                + "            acc_buffer.append(1.0*meter['num_corrects']/meter['num_images'])\r\n"
                + "            loss_buffer.append(meter['total_losses']/meter['num_images'])\r\n"
                + "\r\n"
                + "            plotter.update(y1=np.array(acc_buffer), y2=np.array(loss_buffer))\r\n";
        return source + "\r\n";
    }

    private String CreateApp() {
        String source = "def app(opt):\r\n"
                + "    np.set_printoptions(threshold=np.inf)\r\n"
                + "\r\n"
                + "    print(opt)\r\n"
                + "\r\n"
                + "    data_loader = n3ml.data.IRISDataLoader(ratio=0.8)\r\n"
                + "    data = data_loader.run()\r\n"
                + "    summary = data_loader.summarize()\r\n"
                + "\r\n"
                + "    data_encoder = n3ml.encoder.Population(neurons=12,\r\n"
                + "                                           minimum=summary['min'],\r\n"
                + "                                           maximum=summary['max'],\r\n"
                + "                                           max_firing_time=opt.max_firing_time,\r\n"
                + "                                           not_to_fire=opt.not_to_fire,\r\n"
                + "                                           dt=opt.dt)\r\n"
                + "    label_encoder = LabelEncoder(opt.num_classes)\r\n"
                + "\r\n"
                + "    model = n3ml.model.Bohte2002()\r\n"
                + "    model.initialize()\r\n"
                + "\r\n"
                + "    optimizer = n3ml.optimizer.Bohte()\r\n"
                + "\r\n"
                + "    # for plot\r\n"
                + "    plotter = Plot()\r\n"
                + "\r\n"
                + "    meter = {\r\n"
                + "        'total_losses': 0.0,\r\n"
                + "        'num_corrects': 0,\r\n"
                + "        'num_images': 0\r\n"
                + "    }\r\n"
                + "\r\n"
                + "    acc_buffer = []\r\n"
                + "    loss_buffer = []\r\n"
                + "\r\n"
                + "    for epoch in range(opt.num_epochs):\r\n"
                + "        train(data, model, data_encoder, label_encoder, optimizer, rmse, epoch, meter, acc_buffer, loss_buffer, plotter, opt)\r\n"
                + "        # print(\"epoch: {} - tr. loss: {} - tr. acc: {}\".format(epoch, loss, acc))\r\n"
                + "\r\n"
                + "        loss, acc = validate(data, model, data_encoder, label_encoder, rmse, opt)\r\n"
                + "        print(\"epoch: {} - val. loss: {} - val. acc: {}\".format(epoch, loss, acc))\r\n"
                + "\r\n"
                + "        data = data_loader.run()\r\n";
        return source + "\r\n";
    }

    private String mainTest() {
        String source = "if __name__ == '__main__':\r\n"
                + "    parser = argparse.ArgumentParser()\r\n"
                + "\r\n"
                + "    parser.add_argument('--num_classes', default="+hn3mlCfg.getNumofClasses()+", type=int)\r\n"
                + "    parser.add_argument('--batch_size', default="+hn3mlCfg.getBatch_size()+", type=int)\r\n"
                + "    parser.add_argument('--num_epochs', default="+hn3mlCfg.getEpoch()+", type=int)\r\n"
                + "    parser.add_argument('--dt', default="+hn3mlCfg.getDtTime()+", type=int)\r\n"
                + "    parser.add_argument('--num_steps', default="+hn3mlCfg.getNumofSteps()+", type=int)\r\n"
                + "    parser.add_argument('--max_firing_time', default="+hn3mlCfg.getMaxFiringTime()+", type=int)\r\n"
                + "    parser.add_argument('--not_to_fire', default="+hn3mlCfg.getNotToFire()+", type=int)\r\n"
                + "\r\n"
                + "    app(parser.parse_args())\r\n";
        return source + "\r\n";
    }
    
}

