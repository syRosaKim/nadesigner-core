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
public class HN3MLResumeGenerator extends HN3MLGeneratorConfig{
        
    private int hN3mlNeuronModel = 0; 
    
    private HN3MLIOConfig hn3mlCfg=new HN3MLIOConfig();
    
    public HN3MLResumeGenerator(HN3MLIOConfig n3mlCfg, int neuronmodel) {
        super();
        hN3mlNeuronModel = neuronmodel;
        hn3mlCfg = n3mlCfg;
    }
    
    public String createResume(){
        String source = importLibrary() + CreateEncoder() + CreatePoissonEncoder()
                + CreateLabelEncoder() + CreatePopulationLIF() + CreateSNN() + CreateOptimizerReSuMe()
                + CreateLossReSuMe() + CreateDataLoader() + CreateApp() + CreateRasterplot() + mainTest();
        
        return source;
    }
    private void test(){
        if(hN3mlNeuronModel==H_N3ML_NM_LIF_MODEL){
        }
    }
    
    private String importLibrary() {
        String source = "import argparse\r\n"
                + "\r\n"
                + "import torch\r\n"
                + "import torchvision\r\n"
                + "import numpy as np\r\n"
                + "\r\n"
                + "import matplotlib.pyplot as plt\r\n";
        return source + "\r\n";
    }

    private String CreateEncoder() {
        String source = "class Encoder:\r\n"
                + "    def __init__(self):\r\n"
                + "        pass\r\n"
                + "\r\n"
                + "    def __call__(self, *args, **kwargs):\r\n"
                + "        raise NotImplementedError\r\n";
        return source + "\r\n";
    }

    private String CreatePoissonEncoder() {
        String source = "class PoissonEncoder(Encoder):\r\n"
                + "    def __init__(self):\r\n"
                + "        super(PoissonEncoder, self).__init__()\r\n"
                + "        self.records = []\r\n"
                + "\r\n"
                + "    def __call__(self, image, trace=False):\r\n"
                + "        # image.size: [c, h, w]\r\n"
                + "        # spike_image.size: [c, h, w]\r\n"
                + "        c, h, w = image.shape\r\n"
                + "        spike_image = np.random.uniform(size=(c, h, w))\r\n"
                + "        for i in range(c):\r\n"
                + "            for j in range(h):\r\n"
                + "                for k in range(w):\r\n"
                + "                    if spike_image[i, j, k] < image[i, j, k]:\r\n"
                + "                        spike_image[i, j, k] = 1\r\n"
                + "                    else:\r\n"
                + "                        spike_image[i, j, k] = 0\r\n"
                + "        self.records.append(spike_image)\r\n"
                + "        if trace:\r\n"
                + "            return self.records\r\n"
                + "        return spike_image\r\n";
        return source + "\r\n";
    }

    private String CreateLabelEncoder() {
        String source = "class LabelEncoder(Encoder):\r\n"
                + "    def __init__(self, num_classes, tau_ref):\r\n"
                + "        super(LabelEncoder, self).__init__()\r\n"
                + "        self.num_classes = num_classes\r\n"
                + "        self.tau_ref = tau_ref\r\n"
                + "        self.records = [np.zeros(self.num_classes)]\r\n"
                + "\r\n"
                + "    def __call__(self, t, label, trace=False):\r\n"
                + "        o = np.zeros(self.num_classes)\r\n"
                + "        tt = int(t*1000)\r\n"
                + "        rr = int(self.tau_ref*1000+1)\r\n"
                + "        if tt%rr == 0:\r\n"
                + "            o[label] = 1\r\n"
                + "        self.records.append(o)\r\n"
                + "        if trace:\r\n"
                + "            return self.records\r\n"
                + "        return o\r\n";
        return source + "\r\n";
    }

    private String CreatePopulationLIF() {
        String source = "class PopulationLIF:\r\n"
                + "    def __init__(self, in_neurons, neurons, q=1, resting=0, threshold=1, tau_m=0.01, tau_ref=0.002):\r\n"
                + "        self.in_neurons = in_neurons\r\n"
                + "        self.neurons = neurons\r\n"
                + "        self.q = q\r\n"
                + "        self.u_r = resting\r\n"
                + "        self.th = threshold\r\n"
                + "        self.tau_m = tau_m\r\n"
                + "        self.tau_ref = tau_ref\r\n"
                + "        self.W = np.zeros((self.neurons, self.in_neurons))\r\n"
                + "        self.a = [np.zeros(self.in_neurons)]\r\n"
                + "        self.I = [np.zeros(self.neurons)]\r\n"
                + "        self.u = [np.zeros(self.neurons)]\r\n"
                + "        self.s = [np.zeros(self.neurons)]\r\n"
                + "        self.ref = np.zeros(self.neurons)\r\n"
                + "        self.t_hat = np.zeros(self.neurons)\r\n"
                + "\r\n"
                + "        self.reset_parameters()\r\n"
                + "\r\n"
                + "    def reset_parameters(self):\r\n"
                + "        self.W[:] = np.random.uniform(low=-0.5, high=0.5, size=(self.neurons, self.in_neurons))\r\n"
                + "\r\n"
                + "    def __call__(self, t, x):\r\n"
                + "        self.psc(t=t,\r\n"
                + "                 s=x,\r\n"
                + "                 q=self.q,\r\n"
                + "                 a=self.a)\r\n"
                + "        self.current(t=t,\r\n"
                + "                     W=self.W,\r\n"
                + "                     a=self.a,\r\n"
                + "                     I=self.I)\r\n"
                + "        self.integrate(t=t,\r\n"
                + "                       I=self.I,\r\n"
                + "                       u=self.u,\r\n"
                + "                       t_hat=self.t_hat,\r\n"
                + "                       ref=self.ref,\r\n"
                + "                       u_r=self.u_r,\r\n"
                + "                       tau_m=self.tau_m)\r\n"
                + "        self.fire(t=t,\r\n"
                + "                  u=self.u,\r\n"
                + "                  t_hat=self.t_hat,\r\n"
                + "                  s=self.s,\r\n"
                + "                  ref=self.ref,\r\n"
                + "                  th=self.th,\r\n"
                + "                  u_r=self.u_r,\r\n"
                + "                  tau_ref=self.tau_ref)\r\n"
                + "        self.refractory(t=t,\r\n"
                + "                        ref=self.ref,\r\n"
                + "                        s=self.s)\r\n"
                + "        return self.s\r\n"
                + "\r\n"
                + "    def psc(self, t, s, q, a):\r\n"
                + "        \"\"\"\r\n"
                + "        a(t-t_) = q*d(t-t_)\r\n"
                + "        :param t: time\r\n"
                + "        :param s: presynaptic spikes\r\n"
                + "        :param q:\r\n"
                + "        :param a: postsynaptic currents (output)\r\n"
                + "        :return:\r\n"
                + "        \"\"\"\r\n"
                + "        aa = np.zeros(self.in_neurons)\r\n"
                + "        aa[:] = q * s[-1]\r\n"
                + "        a.append(aa)\r\n"
                + "\r\n"
                + "    def current(self, t, W, a, I):\r\n"
                + "        \"\"\"\r\n"
                + "        :param t: time\r\n"
                + "        :param W: weights\r\n"
                + "        :param a: PSC\r\n"
                + "        :param I: input currents (output)\r\n"
                + "        :return:\r\n"
                + "        \"\"\"\r\n"
                + "        II = np.zeros(self.neurons)\r\n"
                + "        II[:] = np.dot(W, a[-1])\r\n"
                + "        I.append(II)\r\n"
                + "\r\n"
                + "    def integrate(self, t, I, u, t_hat, ref, u_r, tau_m):\r\n"
                + "        \"\"\"\r\n"
                + "        :param t:\r\n"
                + "        :param I:\r\n"
                + "        :param u:\r\n"
                + "        :param t_hat:\r\n"
                + "        :param ref:\r\n"
                + "        :param u_r:\r\n"
                + "        :param tau_m:\r\n"
                + "        :return:\r\n"
                + "        \"\"\"\r\n"
                + "        uu = np.zeros(self.neurons)\r\n"
                + "        for i in range(uu.shape[0]):\r\n"
                + "            if ref[i] <= 0:\r\n"
                + "                tt = int(t*1000)\r\n"
                + "                tt_hat = int(t_hat[i]*1000)\r\n"
                + "                uu[i] = u_r*np.exp(-(t-t_hat[i])/tau_m)\r\n"
                + "                for s in range(tt-tt_hat+1):\r\n"
                + "                    uu[i] += np.exp(-(s*0.001)/tau_m) * I[tt-s][i]\r\n"
                + "        u.append(uu)\r\n"
                + "\r\n"
                + "    def fire(self, t, u, t_hat, s, ref, th, u_r, tau_ref):\r\n"
                + "        \"\"\"\r\n"
                + "        :param t:\r\n"
                + "        :param u:\r\n"
                + "        :param t_hat:\r\n"
                + "        :param s:\r\n"
                + "        :param ref:\r\n"
                + "        :param th:\r\n"
                + "        :param u_r:\r\n"
                + "        :param tau_ref:\r\n"
                + "        :return:\r\n"
                + "        \"\"\"\r\n"
                + "        ss = np.zeros(self.neurons)\r\n"
                + "        for i in range(ss.shape[0]):\r\n"
                + "            if ref[i] <= 0 and u[-1][i] > th:\r\n"
                + "                ss[i] = 1\r\n"
                + "                t_hat[i] = t\r\n"
                + "                u[-1][i] = u_r\r\n"
                + "                ref[i] += tau_ref\r\n"
                + "        s.append(ss)\r\n"
                + "\r\n"
                + "    def refractory(self, t, ref, s):\r\n"
                + "        \"\"\"\r\n"
                + "        :param t:\r\n"
                + "        :param ref:\r\n"
                + "        :param s:\r\n"
                + "        :return:\r\n"
                + "        \"\"\"\r\n"
                + "        for i in range(ref.shape[0]):\r\n"
                + "            if s[-1][i] == 0 and ref[i] > 0:\r\n"
                + "                ref[i] -= 0.001\r\n";
        return source + "\r\n";
    }

    private String CreateSNN() {
        String source = "class SNN:\r\n"
                + "    def __init__(self):\r\n"
                + "        self.pop1 = PopulationLIF(28*28, 10)\r\n"
                + "        self.pop2 = PopulationLIF(10, 10)\r\n"
                + "\r\n"
                + "    def __call__(self, t, x):\r\n"
                + "        return self._forward(t, x)\r\n"
                + "\r\n"
                + "    def _forward(self, t, x):\r\n"
                + "\r\n"
                + "        if isinstance(x, list):\r\n"
                + "            for i in range(len(x)):\r\n"
                + "                x[i] = x[i].reshape(-1)\r\n"
                + "        else:\r\n"
                + "            x = x.reshape(-1)\r\n"
                + "        o = self.pop1(t, x)\r\n"
                + "        o = self.pop2(t, o)\r\n"
                + "        return o\r\n";
        return source + "\r\n";
    }

    private String CreateOptimizerReSuMe() {
        String source = "class OptimizerReSuMe:\r\n"
                + "    def __init__(self, W, delta_W, lr=0.1):\r\n"
                + "        self.W = W\r\n"
                + "        self.delta_W = delta_W\r\n"
                + "        self.lr = lr\r\n"
                + "\r\n"
                + "    def step(self):\r\n"
                + "        self.W[:] = self.W + self.delta_W*self.lr\r\n";
        return source + "\r\n";
    }

    private String CreateLossReSuMe() {
        String source = "class LossReSuMe:\r\n"
                + "    def __init__(self, W, a_d=0, a_l=0, A_d=1, A_l=1, W_d=None, W_l=None, tau_d=1, tau_l=1):\r\n"
                + "        self.W = W\r\n"
                + "        self.delta_W = np.zeros(W.shape)\r\n"
                + "        self.a_d = a_d\r\n"
                + "        self.a_l = a_l\r\n"
                + "        self.A_d = A_d\r\n"
                + "        self.A_l = A_l\r\n"
                + "        self.tau_d = tau_d\r\n"
                + "        self.tau_l = tau_l\r\n"
                + "        if W_d is None:\r\n"
                + "            self.W_d = self.W_d_f\r\n"
                + "        else:\r\n"
                + "            self.W_d = W_d\r\n"
                + "        if W_l is None:\r\n"
                + "            self.W_l = self.W_l_f\r\n"
                + "        else:\r\n"
                + "            self.W_l = W_l\r\n"
                + "\r\n"
                + "    def W_d_f(self, s_d):\r\n"
                + "        if s_d > 0:\r\n"
                + "            return self.A_d * np.exp(-s_d/self.tau_d)\r\n"
                + "        return 0\r\n"
                + "\r\n"
                + "    def W_l_f(self, s_l):\r\n"
                + "        if s_l > 0:\r\n"
                + "            return -self.A_l * np.exp(-s_l/self.tau_l)\r\n"
                + "        return 0\r\n"
                + "\r\n"
                + "    def __call__(self, t, S_in, S_l, S_d):\r\n"
                + "        for k in range(S_in[-1].shape[0]):\r\n"
                + "            for i in range(S_l[-1].shape[0]):\r\n"
                + "                delta_w = 0\r\n"
                + "                if S_l[-1][i] == 1:\r\n"
                + "                    delta_w_l = self.a_l\r\n"
                + "                    for j in range(len(S_in)):\r\n"
                + "                        s_l = t-j*0.001\r\n"
                + "                        delta_w_l += self.W_l(s_l) * S_in[j][k]\r\n"
                + "                    delta_w += delta_w_l\r\n"
                + "                if S_d[-1][i] == 1:\r\n"
                + "                    delta_w_d = self.a_d\r\n"
                + "                    for j in range(len(S_in)):\r\n"
                + "                        s_d = t-j*0.001\r\n"
                + "                        delta_w_d += self.W_d(s_d) * S_in[j][k]\r\n"
                + "                    delta_w += delta_w_d\r\n"
                + "                # print(delta_w)\r\n"
                + "                self.delta_W[i][k] = delta_w\r\n";
        return source + "\r\n";
    }

    private String CreateDataLoader() {
        String source = "class DataLoader:\r\n"
                + "    def __init__(self, data, batch_size, shuffle, train):\r\n"
                + "        self.data = data\r\n"
                + "        self.batch_size = batch_size\r\n"
                + "        self.shuffle = shuffle\r\n"
                + "        self.train = train\r\n"
                + "        self.loader = torch.utils.data.DataLoader(\r\n"
                + "            torchvision.datasets.MNIST(\r\n"
                + "                self.data,\r\n"
                + "                train=self.train,\r\n"
                + "                transform=torchvision.transforms.Compose([torchvision.transforms.ToTensor()]),\r\n"
                + "                download=True), ### syKim_0531\r\n"
                + "            batch_size=self.batch_size,\r\n"
                + "            shuffle=self.shuffle)\r\n"
                + "        self.it = iter(self.loader)\r\n"
                + "        self.o = next(self.it)\r\n"
                + "\r\n"
                + "    def next(self):\r\n"
                + "        self.o = next(self.it)\r\n"
                + "\r\n"
                + "    def __call__(self):\r\n"
                + "        return self.o\r\n";
        return source + "\r\n";
    }

    private String CreateApp() {
        String source = "def app(opt):\r\n"
                + "    train_loader = DataLoader(data=opt.data, batch_size=opt.batch_size, shuffle=True, train=True)\r\n"
                + "\r\n"
                + "    encoder_img = PoissonEncoder()\r\n"
                + "    encoder_lb = LabelEncoder(opt.num_classes, tau_ref=0.002)\r\n"
                + "\r\n"
                + "    model = SNN()\r\n"
                + "\r\n"
                + "    loss = LossReSuMe(W=model.pop2.W)\r\n"
                + "\r\n"
                + "    optimizer = OptimizerReSuMe(W=model.pop2.W, delta_W=loss.delta_W, lr=0.01)\r\n"
                + "\r\n"
                + "    num_steps = int(opt.simulation_times/opt.time_steps)\r\n"
                + "\r\n"
                + "    for step in range(1, num_steps):\r\n"
                + "        t = step * opt.time_steps\r\n"
                + "\r\n"
                + "        # image.shape: [1, 1, 28, 28]\r\n"
                + "        # label.shape: [1]\r\n"
                + "        if step % int(opt.time_frames/opt.time_steps) == 0:\r\n"
                + "            train_loader.next()\r\n"
                + "        image, label = train_loader()\r\n"
                + "        image = image.numpy()\r\n"
                + "        label = label.numpy()\r\n"
                + "        image = np.squeeze(image, 0)  # image.shape: [1, 28, 28]\r\n"
                + "\r\n"
                + "        spiked_image = encoder_img(image, trace=True)\r\n"
                + "        spiked_label = encoder_lb(t, label, trace=True)\r\n"
                + "\r\n"
                + "        model(t, spiked_image)\r\n"
                + "\r\n"
                + "        loss(t=t, S_in=model.pop1.s, S_l=model.pop2.s, S_d=spiked_label)\r\n"
                + "\r\n"
                + "        optimizer.step()\r\n"
                + "\r\n"
                + "    a = np.array(encoder_lb.records)\r\n"
                + "    d = np.array(spiked_label)\r\n"
                + "    s1 = np.array(model.pop1.s)\r\n"
                + "    s2 = np.array(model.pop2.s)\r\n"
                + "\r\n"
                + "    time = np.arange(0, num_steps)\r\n"
                + "\r\n"
                + "    print(time.size)\r\n"
                + "    print(s2.size)\r\n"
                + "\r\n"
                + "    rasterplot(time, s2)\r\n";
        return source + "\r\n";
    }

    private String CreateRasterplot() {
        String source = "def rasterplot(time, spikes, **kwargs):\r\n"
                + "    ax = plt.gca()\r\n"
                + "\r\n"
                + "    n_spike, n_neuron = spikes.shape\r\n"
                + "\r\n"
                + "    kwargs.setdefault(\"linestyle\", \"None\")\r\n"
                + "    kwargs.setdefault(\"marker\", \"|\")\r\n"
                + "\r\n"
                + "    spiketimes = []\r\n"
                + "\r\n"
                + "    for i in range(n_neuron):\r\n"
                + "        temp = time[spikes[:, i] > 0].ravel()\r\n"
                + "        spiketimes.append(temp)\r\n"
                + "\r\n"
                + "    spiketimes = np.array(spiketimes)\r\n"
                + "\r\n"
                + "    indexes = np.zeros(n_neuron, dtype=np.int)\r\n"
                + "\r\n"
                + "    for t in range(time.shape[0]):\r\n"
                + "        for i in range(spiketimes.shape[0]):\r\n"
                + "            if spiketimes[i].shape[0] <= 0:\r\n"
                + "                continue\r\n"
                + "            if indexes[i] < spiketimes[i].shape[0] and \\\r\n"
                + "                    time[t] == spiketimes[i][indexes[i]]:\r\n"
                + "                ax.plot(spiketimes[i][indexes[i]], i + 1, 'k', **kwargs)\r\n"
                + "\r\n"
                + "                plt.draw()\r\n"
                + "                plt.pause(0.002)\r\n"
                + "\r\n"
                + "                indexes[i] += 1\r\n";
        return source + "\r\n";
    }

    private String mainTest() {
        String source = "if __name__ == '__main__':\r\n"
                + "    parser = argparse.ArgumentParser()\r\n"
                + "\r\n"
                + "    parser.add_argument('--data', default='../DataSets')\r\n"
                + "    parser.add_argument('--num_classes', default="+hn3mlCfg.getNumofClasses()+", type=int)\r\n"
                + "    parser.add_argument('--batch_size', default="+hn3mlCfg.getBatch_size()+", type=int)\r\n"
                + "    parser.add_argument('--simulation_times', default="+hn3mlCfg.getSimulationTime()+", type=float)  # 2s\r\n"
                + "    parser.add_argument('--time_steps', default="+hn3mlCfg.getTimeSteps()+", type=float)  # 1ms\r\n"
                + "    parser.add_argument('--time_frames', default="+hn3mlCfg.getTimeFrames()+", type=float)  # 50ms\r\n"
                + "\r\n"
                + "    app(parser.parse_args())\r\n";
        return source + "\r\n";
    }
}
