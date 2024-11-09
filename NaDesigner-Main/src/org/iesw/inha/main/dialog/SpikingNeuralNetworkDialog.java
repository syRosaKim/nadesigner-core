package org.iesw.inha.main.dialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.xml.ws.Action;
import org.iesw.inha.generator.ai.HSNNGenerator;
import org.iesw.inha.generator.ai.HSNNGeneratorJS;
import org.iesw.inha.generator.ai.HSNNHardwareGenerator;
import org.iesw.inha.generator.ai.HSNNN3MLGenerator;
import org.iesw.inha.generator.ai.HSNNNAALGenerator;
import org.iesw.inha.ioconfig.ai.HN3MLIOConfig;
import org.iesw.inha.ioconfig.ai.HSNNIOConfig;
import org.openide.filesystems.FileUtil;

public class SpikingNeuralNetworkDialog extends javax.swing.JDialog {

    public static final int H_DATA_SET_TRAINING = 0;   
    public static final int H_DATA_SET_TEST = 1;   
    
    public static final int H_NengoDL = 0;   
    public static final int H_NAAL = 1;       
    public static final int H_ONNX = 2;   
    public static final int H_DE1_SOC = 3;     
    public static final int H_N3ML = 4;
    public static final int H_NAAL_Pre = 5;
    
    public static final int H_SNN = 1;
    
    public static final int H_N3ML_NM_LIF_MODEL = 0; 
    public static final int H_N3ML_NM_Soft_LIF_MODEL = 1;
    public static final int H_N3ML_NM_IF_MODEL = 2;
    public static final int H_N3ML_NM_SRM_MODEL = 3;
    public static final int H_N3ML_NM_Adaptive_LIF_MODEL = 4;
    
    public static final int H_N3ML_A_softLIF = 0;
    public static final int H_N3ML_A_SpikeProp = 1;
    public static final int H_N3ML_A_STDP = 2;
    public static final int H_N3ML_A_BP_STDP = 3;
    public static final int H_N3ML_A_STBP = 4;
    public static final int H_N3ML_A_SpikeNorm = 5;
    
    private static final int Linear = 1;
    private static final int Logistic = 2;
    private static final int MNIST = 3;   
    
    public static boolean LOADDATA = false;    
    public static boolean LOADLIB = false;  
    
    public static File libDir = new File(""); 
    public static File srcDir = new File("");  
    public static File srcFile = new File("");  
    public static File destDir = new File(""); 
    public static File destLib = new File("");  
    
    public static String delim = "";
    public static String loadDir = ""; 
    
    public static final String userDir = System.getenv("USERPROFILE");
    public static final String ndPrjDir = userDir + File.separatorChar + "Documents"+File.separatorChar+"NaDesigner"+File.separatorChar+"Projects";
    
    private JFileChooser fileChooser = new JFileChooser();
    private HSNNIOConfig hSIOConf = new HSNNIOConfig();
    private HN3MLIOConfig hN3mlIOConf = new HN3MLIOConfig();
    private HSNNGeneratorJS hSNNGenJ = new HSNNGeneratorJS();
    private HSNNGenerator hSNNGen = new HSNNGenerator();
    private HSNNHardwareGenerator hSNNHWGen = new HSNNHardwareGenerator(); 
    private HSNNNAALGenerator hNAALGen = new HSNNNAALGenerator();
    private HSNNN3MLGenerator hN3mlGen;
    
    private int hDataSetOpt = H_DATA_SET_TRAINING;
    private String hDirectory="";
    private int flagType = 0;
    private int hN3mlNeuronModel = 0; 
    private int hN3mlAlgorithm = 0;
    
    public SpikingNeuralNetworkDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInitComponents(); 
    }
    public SpikingNeuralNetworkDialog(java.awt.Frame parent, boolean modal, String hDir) {
        super(parent, modal);
        hDirectory = hDir;
        initComponents();
        myInitComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datasetOptionButtonGroup = new javax.swing.ButtonGroup();
        RuntimePanel = new javax.swing.JPanel();
        runtimeOptionLabel = new javax.swing.JLabel();
        runtimeTrainingRadioButton = new javax.swing.JRadioButton();
        runtimeTestRadioButton = new javax.swing.JRadioButton();
        runtimeComboBox = new javax.swing.JComboBox();
        runtimeLabel = new javax.swing.JLabel();
        cnnPanel = new javax.swing.JPanel();
        cnnCheckBox = new javax.swing.JCheckBox();
        modelDirPanel = new javax.swing.JPanel();
        modelNameLabel = new javax.swing.JLabel();
        modelNameTextField = new javax.swing.JTextField();
        modelDirLabel = new javax.swing.JLabel();
        modelDirTextField = new javax.swing.JTextField();
        modelDirBrowseButton = new javax.swing.JButton();
        nengoDLModelPanel = new javax.swing.JPanel();
        modelTypeLabel = new javax.swing.JLabel();
        modelTypeComboBox = new javax.swing.JComboBox();
        trainingPanel = new javax.swing.JPanel();
        inputsLabel = new javax.swing.JLabel();
        inputsTextField = new javax.swing.JTextField();
        outputsLabel = new javax.swing.JLabel();
        outputsTextField = new javax.swing.JTextField();
        epochsLabel = new javax.swing.JLabel();
        epochsTextField = new javax.swing.JTextField();
        learningRateLabel = new javax.swing.JLabel();
        learningRateTextField = new javax.swing.JTextField();
        optimizerLabel = new javax.swing.JLabel();
        optimizerComboBox = new javax.swing.JComboBox();
        costFunctionLabel = new javax.swing.JLabel();
        costFunctionComboBox = new javax.swing.JComboBox();
        neuronModelPanel = new javax.swing.JPanel();
        amplitudeLabel = new javax.swing.JLabel();
        minibatchSizeTextField = new javax.swing.JTextField();
        interceptsLabel = new javax.swing.JLabel();
        synapseLabel = new javax.swing.JLabel();
        synapseTextField = new javax.swing.JTextField();
        interceptsTextField = new javax.swing.JTextField();
        amplitudeTextArea = new javax.swing.JTextField();
        maxRateLabel = new javax.swing.JLabel();
        minibatchSizeLabel = new javax.swing.JLabel();
        maxRateTextField = new javax.swing.JTextField();
        neuronModelLabel = new javax.swing.JLabel();
        neuronModelComboBox = new javax.swing.JComboBox();
        tauRcLabel = new javax.swing.JLabel();
        tauRcTextField = new javax.swing.JTextField();
        loadDataPanel = new javax.swing.JPanel();
        loadDataFromFileCheckBox = new javax.swing.JCheckBox();
        modelFileLabel = new javax.swing.JLabel();
        modelFileTextField = new javax.swing.JTextField();
        DelimiterLabel = new javax.swing.JLabel();
        delimiterComboBox = new javax.swing.JComboBox();
        IncludeFirstLineCheckBox = new javax.swing.JCheckBox();
        fileDirBrowseButton = new javax.swing.JButton();
        xRangeLabel = new javax.swing.JLabel();
        xRangeField1 = new javax.swing.JTextField();
        toRabel1 = new javax.swing.JLabel();
        xRangeField2 = new javax.swing.JTextField();
        yRangeLabel = new javax.swing.JLabel();
        yRangeField1 = new javax.swing.JTextField();
        toRabel2 = new javax.swing.JLabel();
        yRangeField2 = new javax.swing.JTextField();
        logPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        varificationLogTextArea = new javax.swing.JTextArea();
        nextButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        fpgaNeuronModelPanel = new javax.swing.JPanel();
        neuronModelLabel2 = new javax.swing.JLabel();
        neuronModelComboBox2 = new javax.swing.JComboBox();
        synapseLabel2 = new javax.swing.JLabel();
        synapseTextField2 = new javax.swing.JTextField();
        maxRateLabel2 = new javax.swing.JLabel();
        maxRateTextField2 = new javax.swing.JTextField();
        interceptsLabel2 = new javax.swing.JLabel();
        interceptsTextField2 = new javax.swing.JTextField();
        neuronSizeLabel = new javax.swing.JLabel();
        imageSizeLabel = new javax.swing.JLabel();
        neuronSizeSpinner = new javax.swing.JSpinner();
        imageSizeTextField = new javax.swing.JTextField();
        libraryDirPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        libraryDirTextField = new javax.swing.JTextField();
        libraryDirBrowseButton = new javax.swing.JButton();
        fpgaTrainingPanel = new javax.swing.JPanel();
        inputsLabel2 = new javax.swing.JLabel();
        epochsLabel2 = new javax.swing.JLabel();
        epochsTextField2 = new javax.swing.JTextField();
        inputsTextField2 = new javax.swing.JTextField();
        outputsLabel2 = new javax.swing.JLabel();
        outputsTextField2 = new javax.swing.JTextField();
        n3mlLoadDataPanel1 = new javax.swing.JPanel();
        loadDirLabel1 = new javax.swing.JLabel();
        n3mlLoadDirBrowseButton = new javax.swing.JButton();
        n3mlLoadDirTextField = new javax.swing.JTextField();
        n3mlModelOptionPanel = new javax.swing.JPanel();
        n3mlNeuronModelLabel = new javax.swing.JLabel();
        n3mlNeuronModelComboBox = new javax.swing.JComboBox();
        n3mlPopulationPanel = new javax.swing.JPanel();
        learningComboBox3 = new javax.swing.JComboBox();
        populationLabel = new javax.swing.JLabel();
        n3mlConnectionPanel = new javax.swing.JPanel();
        preLabel = new javax.swing.JLabel();
        preComboBox = new javax.swing.JComboBox();
        postLabel = new javax.swing.JLabel();
        connectionComboBox = new javax.swing.JComboBox();
        connectionLabel = new javax.swing.JLabel();
        postComboBox = new javax.swing.JComboBox();
        n3mlAlogorithmOptionPanel = new javax.swing.JPanel();
        n3mlLearningAlgorithmLabel = new javax.swing.JLabel();
        n3mlLearningAlgorithmComboBox = new javax.swing.JComboBox();
        NAALHardwarePanel = new javax.swing.JPanel();
        runtimeBoardLabel = new javax.swing.JLabel();
        runtimeBoardComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        SelectExampleComboBox2 = new javax.swing.JComboBox();
        naalNeuronModelPanel = new javax.swing.JPanel();
        simulationTimeLabel3 = new javax.swing.JLabel();
        simulationTimeTextField3 = new javax.swing.JTextField();
        dtLabel3 = new javax.swing.JLabel();
        dtTextField3 = new javax.swing.JTextField();
        inputSizeLabel3 = new javax.swing.JLabel();
        inputSizeTextField3 = new javax.swing.JTextField();
        outputSizeLabel3 = new javax.swing.JLabel();
        outputSizeTextField3 = new javax.swing.JTextField();
        dataTypeLabel3 = new javax.swing.JLabel();
        dataTypeComboBox3 = new javax.swing.JComboBox();
        deviceLabel3 = new javax.swing.JLabel();
        deviceComboBox3 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.title")); // NOI18N
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(625, 650));
        setPreferredSize(new java.awt.Dimension(625, 710));

        RuntimePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.RuntimePanel.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(runtimeOptionLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.runtimeOptionLabel.text")); // NOI18N

        datasetOptionButtonGroup.add(runtimeTrainingRadioButton);
        runtimeTrainingRadioButton.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(runtimeTrainingRadioButton, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.runtimeTrainingRadioButton.text")); // NOI18N
        runtimeTrainingRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                runtimeTrainingRadioButtonItemStateChanged(evt);
            }
        });
        runtimeTrainingRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runtimeTrainingRadioButtonActionPerformed(evt);
            }
        });

        datasetOptionButtonGroup.add(runtimeTestRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(runtimeTestRadioButton, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.runtimeTestRadioButton.text")); // NOI18N
        runtimeTestRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                runtimeTestRadioButtonItemStateChanged(evt);
            }
        });
        runtimeTestRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runtimeTestRadioButtonActionPerformed(evt);
            }
        });

        runtimeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NengoDL", "NAAL", "ONNX", "DE1-SoC", "N3ML", "NAALModelPrediction" }));
        runtimeComboBox.setMinimumSize(new java.awt.Dimension(83, 23));
        runtimeComboBox.setPreferredSize(new java.awt.Dimension(83, 23));
        runtimeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                runtimeComboBoxItemStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(runtimeLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.runtimeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cnnCheckBox, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.cnnCheckBox.text")); // NOI18N
        cnnCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnnCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cnnPanelLayout = new javax.swing.GroupLayout(cnnPanel);
        cnnPanel.setLayout(cnnPanelLayout);
        cnnPanelLayout.setHorizontalGroup(
            cnnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cnnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cnnCheckBox)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        cnnPanelLayout.setVerticalGroup(
            cnnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cnnPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cnnCheckBox))
        );

        javax.swing.GroupLayout RuntimePanelLayout = new javax.swing.GroupLayout(RuntimePanel);
        RuntimePanel.setLayout(RuntimePanelLayout);
        RuntimePanelLayout.setHorizontalGroup(
            RuntimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RuntimePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(runtimeOptionLabel)
                .addGap(21, 21, 21)
                .addComponent(runtimeTrainingRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(runtimeTestRadioButton)
                .addGap(72, 72, 72)
                .addComponent(cnnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(runtimeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(runtimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        RuntimePanelLayout.setVerticalGroup(
            RuntimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RuntimePanelLayout.createSequentialGroup()
                .addGroup(RuntimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RuntimePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cnnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RuntimePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(RuntimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(runtimeOptionLabel)
                            .addComponent(runtimeTrainingRadioButton)
                            .addComponent(runtimeTestRadioButton)
                            .addComponent(runtimeLabel)
                            .addComponent(runtimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //String jPanel2Title = "SpikingNeuralNetworkDialog.jPanel2.border.title";
        modelDirPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.modelDirPanel.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(modelNameLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.modelNameLabel.text")); // NOI18N

        modelNameTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.modelNameTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(modelDirLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.modelDirLabel.text")); // NOI18N

        modelDirTextField.setEditable(false);
        modelDirTextField.setText(org.iesw.inha.main.dialog.SpikingNeuralNetworkDialog.ndPrjDir);
        //modelDirTextField.addActionListener(new ActionListener() {
            //         public void actionPerformed(ActionEvent ae) {
                //            modelDirTextField.setText(hDirectory);
                //         }
            //      });
    modelDirTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    //modelDirTextField.setText(hDirectory);

    org.openide.awt.Mnemonics.setLocalizedText(modelDirBrowseButton, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.modelDirBrowseButton.text")); // NOI18N
    modelDirBrowseButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            modelDirBrowseButtonActionPerformed(evt);
        }
    });

    org.openide.awt.Mnemonics.setLocalizedText(modelTypeLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.modelTypeLabel.text")); // NOI18N

    modelTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Customize", "Linear Regression", "Rogistic Regression", "Multi Layer Classification" }));
    modelTypeComboBox.setSelectedIndex(1);
    modelTypeComboBox.setPreferredSize(new java.awt.Dimension(61, 21));
    modelTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            modelTypeComboBoxItemStateChanged(evt);
        }
    });

    javax.swing.GroupLayout nengoDLModelPanelLayout = new javax.swing.GroupLayout(nengoDLModelPanel);
    nengoDLModelPanel.setLayout(nengoDLModelPanelLayout);
    nengoDLModelPanelLayout.setHorizontalGroup(
        nengoDLModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(nengoDLModelPanelLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(modelTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addComponent(modelTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    nengoDLModelPanelLayout.setVerticalGroup(
        nengoDLModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nengoDLModelPanelLayout.createSequentialGroup()
            .addGap(5, 5, 5)
            .addGroup(nengoDLModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(modelTypeLabel)
                .addComponent(modelTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(5, 5, 5))
    );

    javax.swing.GroupLayout modelDirPanelLayout = new javax.swing.GroupLayout(modelDirPanel);
    modelDirPanel.setLayout(modelDirPanelLayout);
    modelDirPanelLayout.setHorizontalGroup(
        modelDirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(modelDirPanelLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(modelDirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(modelNameLabel)
                .addComponent(modelDirLabel))
            .addGap(10, 10, 10)
            .addGroup(modelDirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(modelNameTextField)
                .addComponent(modelDirTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(modelDirBrowseButton)
            .addContainerGap())
        .addComponent(nengoDLModelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    modelDirPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {modelDirLabel, modelNameLabel});

    modelDirPanelLayout.setVerticalGroup(
        modelDirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(modelDirPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(nengoDLModelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(modelDirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(modelNameLabel)
                .addComponent(modelNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(modelDirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(modelDirBrowseButton)
                .addComponent(modelDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(modelDirLabel))
            .addGap(10, 10, 10))
    );

    modelDirPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {modelDirLabel, modelNameLabel});

    trainingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.trainingPanel.border.title"))); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(inputsLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.inputsLabel.text")); // NOI18N

    inputsTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.inputsTextField.text")); // NOI18N
    inputsTextField.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.inputsTextField.toolTipText")); // NOI18N
    inputsTextField.setMaximumSize(new java.awt.Dimension(120, 21));
    inputsTextField.setMinimumSize(new java.awt.Dimension(120, 21));
    inputsTextField.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(outputsLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.outputsLabel.text")); // NOI18N

    outputsTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.outputsTextField.text")); // NOI18N
    outputsTextField.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.outputsTextField.toolTipText")); // NOI18N
    outputsTextField.setMaximumSize(new java.awt.Dimension(120, 21));
    outputsTextField.setMinimumSize(new java.awt.Dimension(120, 21));
    outputsTextField.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(epochsLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.epochsLabel.text")); // NOI18N

    epochsTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.epochsTextField.text")); // NOI18N
    epochsTextField.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.epochsTextField.toolTipText")); // NOI18N
    epochsTextField.setMaximumSize(new java.awt.Dimension(120, 21));
    epochsTextField.setMinimumSize(new java.awt.Dimension(120, 21));
    epochsTextField.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(learningRateLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.learningRateLabel.text")); // NOI18N

    learningRateTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.learningRateTextField.text")); // NOI18N
    learningRateTextField.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.learningRateTextField.toolTipText")); // NOI18N
    learningRateTextField.setMaximumSize(new java.awt.Dimension(120, 21));
    learningRateTextField.setMinimumSize(new java.awt.Dimension(120, 21));
    learningRateTextField.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(optimizerLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.optimizerLabel.text")); // NOI18N

    optimizerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adam", "GD" }));
    optimizerComboBox.setSelectedIndex(1);
    optimizerComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.optimizerComboBox.toolTipText")); // NOI18N
    optimizerComboBox.setMaximumSize(new java.awt.Dimension(120, 21));
    optimizerComboBox.setMinimumSize(new java.awt.Dimension(120, 21));
    optimizerComboBox.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(costFunctionLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.costFunctionLabel.text")); // NOI18N

    costFunctionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cross Entropy", "MSE" }));
    costFunctionComboBox.setSelectedIndex(1);
    costFunctionComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.costFunctionComboBox.toolTipText")); // NOI18N
    costFunctionComboBox.setMaximumSize(new java.awt.Dimension(120, 21));
    costFunctionComboBox.setMinimumSize(new java.awt.Dimension(120, 21));
    costFunctionComboBox.setPreferredSize(new java.awt.Dimension(120, 21));

    javax.swing.GroupLayout trainingPanelLayout = new javax.swing.GroupLayout(trainingPanel);
    trainingPanel.setLayout(trainingPanelLayout);
    trainingPanelLayout.setHorizontalGroup(
        trainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trainingPanelLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(trainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(inputsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(epochsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(optimizerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(trainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(epochsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(optimizerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(inputsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(40, 40, 40)
            .addGroup(trainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(outputsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(learningRateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addComponent(costFunctionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(trainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(outputsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(learningRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(costFunctionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    trainingPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {costFunctionComboBox, epochsTextField, learningRateTextField, optimizerComboBox, outputsTextField});

    trainingPanelLayout.setVerticalGroup(
        trainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(trainingPanelLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addGroup(trainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(inputsLabel)
                .addComponent(inputsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(outputsLabel)
                .addComponent(outputsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(trainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(epochsLabel)
                .addComponent(epochsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(learningRateLabel)
                .addComponent(learningRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(trainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(optimizerLabel)
                .addComponent(optimizerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(costFunctionLabel)
                .addComponent(costFunctionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(10, 10, 10))
    );

    trainingPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {costFunctionComboBox, epochsTextField, inputsTextField, learningRateTextField, optimizerComboBox, outputsTextField});

    trainingPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {costFunctionLabel, epochsLabel, inputsLabel, learningRateLabel, optimizerLabel, outputsLabel});

    neuronModelPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.neuronModelPanel.border.title"))); // NOI18N
    neuronModelPanel.setMinimumSize(new java.awt.Dimension(40, 0));

    org.openide.awt.Mnemonics.setLocalizedText(amplitudeLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.amplitudeLabel.text")); // NOI18N
    amplitudeLabel.setMaximumSize(new java.awt.Dimension(85, 15));
    amplitudeLabel.setMinimumSize(new java.awt.Dimension(85, 15));

    minibatchSizeTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.minibatchSizeTextField.text")); // NOI18N
    minibatchSizeTextField.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.minibatchSizeTextField.toolTipText")); // NOI18N
    minibatchSizeTextField.setMaximumSize(new java.awt.Dimension(120, 21));
    minibatchSizeTextField.setMinimumSize(new java.awt.Dimension(120, 21));
    minibatchSizeTextField.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(interceptsLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.interceptsLabel.text")); // NOI18N
    interceptsLabel.setMaximumSize(new java.awt.Dimension(85, 15));
    interceptsLabel.setMinimumSize(new java.awt.Dimension(85, 15));

    org.openide.awt.Mnemonics.setLocalizedText(synapseLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.synapseLabel.text")); // NOI18N
    synapseLabel.setMaximumSize(new java.awt.Dimension(85, 15));
    synapseLabel.setMinimumSize(new java.awt.Dimension(85, 15));

    synapseTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.synapseTextField.text")); // NOI18N
    synapseTextField.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.synapseTextField.toolTipText")); // NOI18N
    synapseTextField.setMaximumSize(new java.awt.Dimension(120, 21));
    synapseTextField.setMinimumSize(new java.awt.Dimension(120, 21));
    synapseTextField.setPreferredSize(new java.awt.Dimension(120, 21));

    interceptsTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.interceptsTextField.text")); // NOI18N
    interceptsTextField.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.interceptsTextField.toolTipText")); // NOI18N
    interceptsTextField.setMaximumSize(new java.awt.Dimension(120, 21));
    interceptsTextField.setMinimumSize(new java.awt.Dimension(120, 21));
    interceptsTextField.setPreferredSize(new java.awt.Dimension(120, 21));

    amplitudeTextArea.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.amplitudeTextArea.text")); // NOI18N
    amplitudeTextArea.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.amplitudeTextArea.toolTipText")); // NOI18N
    amplitudeTextArea.setMaximumSize(new java.awt.Dimension(120, 21));
    amplitudeTextArea.setMinimumSize(new java.awt.Dimension(120, 21));
    amplitudeTextArea.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(maxRateLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.maxRateLabel.text")); // NOI18N
    maxRateLabel.setMaximumSize(new java.awt.Dimension(85, 15));
    maxRateLabel.setMinimumSize(new java.awt.Dimension(85, 15));

    org.openide.awt.Mnemonics.setLocalizedText(minibatchSizeLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.minibatchSizeLabel.text")); // NOI18N
    minibatchSizeLabel.setMaximumSize(new java.awt.Dimension(85, 15));
    minibatchSizeLabel.setMinimumSize(new java.awt.Dimension(85, 15));

    maxRateTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.maxRateTextField.text")); // NOI18N
    maxRateTextField.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.maxRateTextField.toolTipText")); // NOI18N
    maxRateTextField.setMaximumSize(new java.awt.Dimension(120, 21));
    maxRateTextField.setMinimumSize(new java.awt.Dimension(120, 21));
    maxRateTextField.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(neuronModelLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.neuronModelLabel.text")); // NOI18N

    neuronModelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LIF", "Izhikevich" }));
    neuronModelComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.neuronModelComboBox.toolTipText")); // NOI18N
    neuronModelComboBox.setMaximumSize(new java.awt.Dimension(120, 21));
    neuronModelComboBox.setMinimumSize(new java.awt.Dimension(120, 21));
    neuronModelComboBox.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(tauRcLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.tauRcLabel.text")); // NOI18N

    tauRcTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.tauRcTextField.text")); // NOI18N

    javax.swing.GroupLayout neuronModelPanelLayout = new javax.swing.GroupLayout(neuronModelPanel);
    neuronModelPanel.setLayout(neuronModelPanelLayout);
    neuronModelPanelLayout.setHorizontalGroup(
        neuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(neuronModelPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(neuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(maxRateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tauRcLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(synapseLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(neuronModelLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(neuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(neuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(maxRateTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(neuronModelComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(synapseTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(tauRcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(neuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(neuronModelPanelLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(neuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(interceptsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(minibatchSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, neuronModelPanelLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(amplitudeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(neuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(interceptsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(amplitudeTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(minibatchSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    neuronModelPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {interceptsTextField, minibatchSizeTextField});

    neuronModelPanelLayout.setVerticalGroup(
        neuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, neuronModelPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(neuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(amplitudeTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(neuronModelLabel)
                .addComponent(neuronModelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(amplitudeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(neuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(maxRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(maxRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(interceptsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(interceptsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(neuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(synapseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(minibatchSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(minibatchSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(synapseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(neuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tauRcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tauRcLabel))
            .addContainerGap())
    );

    neuronModelPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {amplitudeLabel, interceptsLabel, maxRateLabel, minibatchSizeLabel, neuronModelLabel, synapseLabel});

    neuronModelPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {amplitudeTextArea, interceptsTextField, maxRateTextField, minibatchSizeTextField, neuronModelComboBox, synapseTextField});

    tauRcLabel.getAccessibleContext().setAccessibleParent(neuronModelPanel);

    loadDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.loadDataPanel.border.title"))); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(loadDataFromFileCheckBox, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.loadDataFromFileCheckBox.text")); // NOI18N
    loadDataFromFileCheckBox.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            loadDataFromFileCheckBoxItemStateChanged(evt);
        }
    });

    org.openide.awt.Mnemonics.setLocalizedText(modelFileLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.modelFileLabel.text")); // NOI18N

    modelFileTextField.setEditable(false);
    modelFileTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    modelFileTextField.setPreferredSize(new java.awt.Dimension(152, 21));

    org.openide.awt.Mnemonics.setLocalizedText(DelimiterLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.DelimiterLabel.text")); // NOI18N
    DelimiterLabel.setEnabled(false);

    delimiterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ",", ";", "space", "tab" }));
    delimiterComboBox.setEnabled(false);
    delimiterComboBox.setMinimumSize(new java.awt.Dimension(83, 23));
    delimiterComboBox.setPreferredSize(new java.awt.Dimension(83, 23));

    org.openide.awt.Mnemonics.setLocalizedText(IncludeFirstLineCheckBox, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.IncludeFirstLineCheckBox.text")); // NOI18N
    IncludeFirstLineCheckBox.setEnabled(false);

    org.openide.awt.Mnemonics.setLocalizedText(fileDirBrowseButton, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.fileDirBrowseButton.text")); // NOI18N
    fileDirBrowseButton.setActionCommand(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.fileDirBrowseButton.actionCommand")); // NOI18N
    fileDirBrowseButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            fileDirBrowseButtonActionPerformed(evt);
        }
    });

    org.openide.awt.Mnemonics.setLocalizedText(xRangeLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.xRangeLabel.text")); // NOI18N
    xRangeLabel.setEnabled(false);

    xRangeField1.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.xRangeField1.text")); // NOI18N
    xRangeField1.setEnabled(false);

    org.openide.awt.Mnemonics.setLocalizedText(toRabel1, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.toRabel1.text")); // NOI18N
    toRabel1.setEnabled(false);

    xRangeField2.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.xRangeField2.text")); // NOI18N
    xRangeField2.setEnabled(false);

    org.openide.awt.Mnemonics.setLocalizedText(yRangeLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.yRangeLabel.text")); // NOI18N
    yRangeLabel.setEnabled(false);

    yRangeField1.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.yRangeField1.text")); // NOI18N
    yRangeField1.setEnabled(false);

    org.openide.awt.Mnemonics.setLocalizedText(toRabel2, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.toRabel2.text")); // NOI18N
    toRabel2.setEnabled(false);

    yRangeField2.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.yRangeField2.text")); // NOI18N
    yRangeField2.setEnabled(false);

    javax.swing.GroupLayout loadDataPanelLayout = new javax.swing.GroupLayout(loadDataPanel);
    loadDataPanel.setLayout(loadDataPanelLayout);
    loadDataPanelLayout.setHorizontalGroup(
        loadDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(loadDataPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(loadDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(loadDataPanelLayout.createSequentialGroup()
                    .addComponent(IncludeFirstLineCheckBox)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xRangeLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(xRangeField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(toRabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(xRangeField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(yRangeLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(yRangeField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(toRabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(yRangeField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15))
                .addGroup(loadDataPanelLayout.createSequentialGroup()
                    .addGroup(loadDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loadDataPanelLayout.createSequentialGroup()
                            .addComponent(modelFileLabel)
                            .addGap(18, 18, 18)
                            .addComponent(modelFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(fileDirBrowseButton))
                        .addGroup(loadDataPanelLayout.createSequentialGroup()
                            .addComponent(loadDataFromFileCheckBox)
                            .addGap(246, 246, 246)
                            .addComponent(DelimiterLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(delimiterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())))
    );
    loadDataPanelLayout.setVerticalGroup(
        loadDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(loadDataPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(loadDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(loadDataFromFileCheckBox)
                .addComponent(DelimiterLabel)
                .addComponent(delimiterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(loadDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(fileDirBrowseButton)
                .addComponent(modelFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(modelFileLabel))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(loadDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(IncludeFirstLineCheckBox)
                .addComponent(xRangeLabel)
                .addComponent(xRangeField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(toRabel1)
                .addComponent(xRangeField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(yRangeLabel)
                .addComponent(yRangeField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(toRabel2)
                .addComponent(yRangeField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    fileDirBrowseButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.fileDirBrowseButton.AccessibleContext.accessibleName")); // NOI18N

    logPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.logPanel.border.title"))); // NOI18N
    logPanel.setMaximumSize(new java.awt.Dimension(32767, 50));
    logPanel.setPreferredSize(new java.awt.Dimension(192, 20));

    jScrollPane1.setEnabled(false);
    jScrollPane1.setMaximumSize(new java.awt.Dimension(32767, 23));
    jScrollPane1.setWheelScrollingEnabled(false);

    varificationLogTextArea.setEditable(false);
    varificationLogTextArea.setBackground(new java.awt.Color(240, 240, 240));
    varificationLogTextArea.setColumns(20);
    varificationLogTextArea.setRows(1);
    varificationLogTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    varificationLogTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    varificationLogTextArea.setEnabled(false);
    varificationLogTextArea.setMaximumSize(new java.awt.Dimension(2147483647, 58));
    varificationLogTextArea.setMinimumSize(new java.awt.Dimension(164, 10));
    varificationLogTextArea.setPreferredSize(new java.awt.Dimension(142, 10));
    jScrollPane1.setViewportView(varificationLogTextArea);

    javax.swing.GroupLayout logPanelLayout = new javax.swing.GroupLayout(logPanel);
    logPanel.setLayout(logPanelLayout);
    logPanelLayout.setHorizontalGroup(
        logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(logPanelLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(18, 18, 18))
    );
    logPanelLayout.setVerticalGroup(
        logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(logPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
            .addContainerGap())
    );

    org.openide.awt.Mnemonics.setLocalizedText(nextButton, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.nextButton.text")); // NOI18N
    nextButton.setMaximumSize(new java.awt.Dimension(100, 23));
    nextButton.setMinimumSize(new java.awt.Dimension(100, 23));
    nextButton.setPreferredSize(new java.awt.Dimension(100, 23));
    nextButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            nextButtonActionPerformed(evt);
        }
    });

    org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.cancelButton.text")); // NOI18N
    cancelButton.setActionCommand(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.cancelButton.actionCommand")); // NOI18N
    cancelButton.setMaximumSize(new java.awt.Dimension(100, 23));
    cancelButton.setMinimumSize(new java.awt.Dimension(100, 23));
    cancelButton.setPreferredSize(new java.awt.Dimension(100, 23));
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cancelButtonActionPerformed(evt);
        }
    });

    fpgaNeuronModelPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.fpgaNeuronModelPanel.border.title"))); // NOI18N
    fpgaNeuronModelPanel.setMinimumSize(new java.awt.Dimension(576, 143));

    org.openide.awt.Mnemonics.setLocalizedText(neuronModelLabel2, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.neuronModelLabel2.text")); // NOI18N

    neuronModelComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RectifiedLinear", "SpikingRectifiedLinear" }));
    neuronModelComboBox2.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.neuronModelComboBox2.toolTipText")); // NOI18N
    neuronModelComboBox2.setMaximumSize(new java.awt.Dimension(120, 21));
    neuronModelComboBox2.setMinimumSize(new java.awt.Dimension(120, 21));
    neuronModelComboBox2.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(synapseLabel2, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.synapseLabel2.text")); // NOI18N

    synapseTextField2.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.synapseTextField2.text")); // NOI18N
    synapseTextField2.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.synapseTextField2.toolTipText")); // NOI18N
    synapseTextField2.setMaximumSize(new java.awt.Dimension(120, 21));
    synapseTextField2.setMinimumSize(new java.awt.Dimension(120, 21));
    synapseTextField2.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(maxRateLabel2, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.maxRateLabel2.text")); // NOI18N

    maxRateTextField2.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.maxRateTextField2.text")); // NOI18N
    maxRateTextField2.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.maxRateTextField2.toolTipText")); // NOI18N
    maxRateTextField2.setMaximumSize(new java.awt.Dimension(120, 21));
    maxRateTextField2.setMinimumSize(new java.awt.Dimension(120, 21));
    maxRateTextField2.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(interceptsLabel2, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.interceptsLabel2.text")); // NOI18N

    interceptsTextField2.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.interceptsTextField2.text")); // NOI18N
    interceptsTextField2.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.interceptsTextField2.toolTipText")); // NOI18N
    interceptsTextField2.setMaximumSize(new java.awt.Dimension(120, 21));
    interceptsTextField2.setMinimumSize(new java.awt.Dimension(120, 21));
    interceptsTextField2.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(neuronSizeLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.neuronSizeLabel.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(imageSizeLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.imageSizeLabel.text")); // NOI18N

    neuronSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 1.0d, 0.1d));
    neuronSizeSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

    imageSizeTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.imageSizeTextField.text")); // NOI18N
    imageSizeTextField.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.imageSizeTextField.toolTipText")); // NOI18N
    imageSizeTextField.setMaximumSize(new java.awt.Dimension(120, 21));
    imageSizeTextField.setMinimumSize(new java.awt.Dimension(120, 21));
    imageSizeTextField.setPreferredSize(new java.awt.Dimension(120, 21));
    imageSizeTextField.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            imageSizeTextFieldActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout fpgaNeuronModelPanelLayout = new javax.swing.GroupLayout(fpgaNeuronModelPanel);
    fpgaNeuronModelPanel.setLayout(fpgaNeuronModelPanelLayout);
    fpgaNeuronModelPanelLayout.setHorizontalGroup(
        fpgaNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(fpgaNeuronModelPanelLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(fpgaNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(neuronModelLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addComponent(maxRateLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(neuronSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(fpgaNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(maxRateTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(neuronModelComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(neuronSizeSpinner))
            .addGap(39, 39, 39)
            .addGroup(fpgaNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fpgaNeuronModelPanelLayout.createSequentialGroup()
                    .addComponent(synapseLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addGap(20, 20, 20))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fpgaNeuronModelPanelLayout.createSequentialGroup()
                    .addGroup(fpgaNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(imageSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(interceptsLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)))
            .addGroup(fpgaNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(synapseTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addComponent(interceptsTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageSizeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );

    fpgaNeuronModelPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {interceptsTextField2, synapseTextField2});

    fpgaNeuronModelPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {interceptsLabel2, synapseLabel2});

    fpgaNeuronModelPanelLayout.setVerticalGroup(
        fpgaNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fpgaNeuronModelPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(fpgaNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(neuronModelLabel2)
                .addComponent(neuronModelComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(synapseLabel2)
                .addComponent(synapseTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(fpgaNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(maxRateTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(maxRateLabel2)
                .addComponent(interceptsLabel2)
                .addComponent(interceptsTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(fpgaNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(neuronSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(neuronSizeLabel)
                .addComponent(imageSizeLabel)
                .addComponent(imageSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    fpgaNeuronModelPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {interceptsLabel2, maxRateLabel2, neuronModelLabel2, synapseLabel2});

    fpgaNeuronModelPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {interceptsTextField2, maxRateTextField2, neuronModelComboBox2, neuronSizeSpinner, synapseTextField2});

    libraryDirPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.libraryDirPanel.border.title"))); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.jLabel1.text")); // NOI18N

    libraryDirTextField.setEditable(false);
    libraryDirTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.libraryDirTextField.text")); // NOI18N
    libraryDirTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    //modelDirTextField.setText(hDirectory);

    org.openide.awt.Mnemonics.setLocalizedText(libraryDirBrowseButton, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.libraryDirBrowseButton.text")); // NOI18N
    libraryDirBrowseButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            libraryDirBrowseButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout libraryDirPanelLayout = new javax.swing.GroupLayout(libraryDirPanel);
    libraryDirPanel.setLayout(libraryDirPanelLayout);
    libraryDirPanelLayout.setHorizontalGroup(
        libraryDirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(libraryDirPanelLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(libraryDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(libraryDirBrowseButton)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    libraryDirPanelLayout.setVerticalGroup(
        libraryDirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(libraryDirPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(libraryDirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(libraryDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(libraryDirBrowseButton))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    fpgaTrainingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.fpgaTrainingPanel.border.title"))); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(inputsLabel2, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.inputsLabel2.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(epochsLabel2, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.epochsLabel2.text")); // NOI18N

    epochsTextField2.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.epochsTextField2.text")); // NOI18N
    epochsTextField2.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.epochsTextField2.toolTipText")); // NOI18N
    epochsTextField2.setMaximumSize(new java.awt.Dimension(120, 21));
    epochsTextField2.setMinimumSize(new java.awt.Dimension(120, 21));
    epochsTextField2.setPreferredSize(new java.awt.Dimension(120, 21));

    inputsTextField2.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.inputsTextField2.text")); // NOI18N
    inputsTextField2.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.inputsTextField2.toolTipText")); // NOI18N
    inputsTextField2.setMaximumSize(new java.awt.Dimension(120, 21));
    inputsTextField2.setMinimumSize(new java.awt.Dimension(120, 21));
    inputsTextField2.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(outputsLabel2, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.outputsLabel2.text")); // NOI18N

    outputsTextField2.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.outputsTextField2.text")); // NOI18N
    outputsTextField2.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.outputsTextField2.toolTipText")); // NOI18N
    outputsTextField2.setMaximumSize(new java.awt.Dimension(120, 21));
    outputsTextField2.setMinimumSize(new java.awt.Dimension(120, 21));
    outputsTextField2.setPreferredSize(new java.awt.Dimension(120, 21));

    javax.swing.GroupLayout fpgaTrainingPanelLayout = new javax.swing.GroupLayout(fpgaTrainingPanel);
    fpgaTrainingPanel.setLayout(fpgaTrainingPanelLayout);
    fpgaTrainingPanelLayout.setHorizontalGroup(
        fpgaTrainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(fpgaTrainingPanelLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(fpgaTrainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(epochsLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addComponent(inputsLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(fpgaTrainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(inputsTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(epochsTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(40, 40, 40)
            .addComponent(outputsLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(outputsTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    fpgaTrainingPanelLayout.setVerticalGroup(
        fpgaTrainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(fpgaTrainingPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(fpgaTrainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(outputsTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(outputsLabel2)
                .addComponent(inputsTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(inputsLabel2))
            .addGap(18, 18, 18)
            .addGroup(fpgaTrainingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(epochsLabel2)
                .addComponent(epochsTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    fpgaTrainingPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {inputsLabel2, inputsTextField2, outputsLabel2, outputsTextField2});

    n3mlLoadDataPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlLoadDataPanel1.border.title"))); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(loadDirLabel1, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.loadDirLabel1.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(n3mlLoadDirBrowseButton, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlLoadDirBrowseButton.text")); // NOI18N
    n3mlLoadDirBrowseButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            n3mlLoadDirBrowseButtonActionPerformed(evt);
        }
    });

    n3mlLoadDirTextField.setEditable(false);
    n3mlLoadDirTextField.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlLoadDirTextField.text")); // NOI18N
    n3mlLoadDirTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

    javax.swing.GroupLayout n3mlLoadDataPanel1Layout = new javax.swing.GroupLayout(n3mlLoadDataPanel1);
    n3mlLoadDataPanel1.setLayout(n3mlLoadDataPanel1Layout);
    n3mlLoadDataPanel1Layout.setHorizontalGroup(
        n3mlLoadDataPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(n3mlLoadDataPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(loadDirLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(n3mlLoadDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(n3mlLoadDirBrowseButton)
            .addGap(9, 9, 9))
    );
    n3mlLoadDataPanel1Layout.setVerticalGroup(
        n3mlLoadDataPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, n3mlLoadDataPanel1Layout.createSequentialGroup()
            .addContainerGap(20, Short.MAX_VALUE)
            .addGroup(n3mlLoadDataPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(n3mlLoadDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(n3mlLoadDirBrowseButton)
                .addComponent(loadDirLabel1))
            .addGap(22, 22, 22))
    );

    n3mlModelOptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlModelOptionPanel.border.title"))); // NOI18N
    n3mlModelOptionPanel.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlModelOptionPanel.toolTipText")); // NOI18N
    n3mlModelOptionPanel.setMinimumSize(new java.awt.Dimension(576, 143));

    org.openide.awt.Mnemonics.setLocalizedText(n3mlNeuronModelLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlNeuronModelLabel.text")); // NOI18N
    n3mlNeuronModelLabel.setMaximumSize(new java.awt.Dimension(126, 15));
    n3mlNeuronModelLabel.setMinimumSize(new java.awt.Dimension(126, 15));
    n3mlNeuronModelLabel.setPreferredSize(new java.awt.Dimension(126, 15));

    n3mlNeuronModelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LIF Model", "Soft LIF Model", "IF Model", "SRM Model", "Adaptive LIF Model" }));
    n3mlNeuronModelComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlNeuronModelComboBox.toolTipText")); // NOI18N
    n3mlNeuronModelComboBox.setMaximumSize(new java.awt.Dimension(120, 21));

    javax.swing.GroupLayout n3mlModelOptionPanelLayout = new javax.swing.GroupLayout(n3mlModelOptionPanel);
    n3mlModelOptionPanel.setLayout(n3mlModelOptionPanelLayout);
    n3mlModelOptionPanelLayout.setHorizontalGroup(
        n3mlModelOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(n3mlModelOptionPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(n3mlNeuronModelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(n3mlNeuronModelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    n3mlModelOptionPanelLayout.setVerticalGroup(
        n3mlModelOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(n3mlModelOptionPanelLayout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addGroup(n3mlModelOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(n3mlNeuronModelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(n3mlNeuronModelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    n3mlPopulationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlPopulationPanel.border.title"))); // NOI18N
    n3mlPopulationPanel.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlPopulationPanel.toolTipText")); // NOI18N
    n3mlPopulationPanel.setMinimumSize(new java.awt.Dimension(576, 143));

    learningComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Population1" }));
    learningComboBox3.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.learningComboBox3.toolTipText")); // NOI18N
    learningComboBox3.setMaximumSize(new java.awt.Dimension(120, 21));
    learningComboBox3.setMinimumSize(new java.awt.Dimension(120, 21));
    learningComboBox3.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(populationLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.populationLabel.text")); // NOI18N
    populationLabel.setMaximumSize(new java.awt.Dimension(126, 15));
    populationLabel.setMinimumSize(new java.awt.Dimension(126, 15));
    populationLabel.setPreferredSize(new java.awt.Dimension(126, 15));

    javax.swing.GroupLayout n3mlPopulationPanelLayout = new javax.swing.GroupLayout(n3mlPopulationPanel);
    n3mlPopulationPanel.setLayout(n3mlPopulationPanelLayout);
    n3mlPopulationPanelLayout.setHorizontalGroup(
        n3mlPopulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(n3mlPopulationPanelLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(populationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(learningComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    n3mlPopulationPanelLayout.setVerticalGroup(
        n3mlPopulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, n3mlPopulationPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(n3mlPopulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(learningComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(populationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    n3mlConnectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlConnectionPanel.border.title"))); // NOI18N
    n3mlConnectionPanel.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlConnectionPanel.toolTipText")); // NOI18N
    n3mlConnectionPanel.setMinimumSize(new java.awt.Dimension(576, 143));

    org.openide.awt.Mnemonics.setLocalizedText(preLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.preLabel.text")); // NOI18N
    preLabel.setMaximumSize(new java.awt.Dimension(126, 15));
    preLabel.setMinimumSize(new java.awt.Dimension(126, 15));
    preLabel.setPreferredSize(new java.awt.Dimension(126, 15));

    preComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Source" }));
    preComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.preComboBox.toolTipText")); // NOI18N
    preComboBox.setMaximumSize(new java.awt.Dimension(120, 21));
    preComboBox.setMinimumSize(new java.awt.Dimension(120, 21));
    preComboBox.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(postLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.postLabel.text")); // NOI18N
    postLabel.setMaximumSize(new java.awt.Dimension(110, 15));
    postLabel.setMinimumSize(new java.awt.Dimension(110, 15));
    postLabel.setPreferredSize(new java.awt.Dimension(110, 15));

    connectionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Connection1" }));
    connectionComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.connectionComboBox.toolTipText")); // NOI18N
    connectionComboBox.setMaximumSize(new java.awt.Dimension(120, 21));
    connectionComboBox.setMinimumSize(new java.awt.Dimension(120, 21));
    connectionComboBox.setPreferredSize(new java.awt.Dimension(120, 21));

    org.openide.awt.Mnemonics.setLocalizedText(connectionLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.connectionLabel.text")); // NOI18N
    connectionLabel.setMaximumSize(new java.awt.Dimension(126, 15));
    connectionLabel.setMinimumSize(new java.awt.Dimension(126, 15));
    connectionLabel.setPreferredSize(new java.awt.Dimension(126, 15));

    postComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Population1" }));
    postComboBox.setPreferredSize(new java.awt.Dimension(120, 21));

    javax.swing.GroupLayout n3mlConnectionPanelLayout = new javax.swing.GroupLayout(n3mlConnectionPanel);
    n3mlConnectionPanel.setLayout(n3mlConnectionPanelLayout);
    n3mlConnectionPanelLayout.setHorizontalGroup(
        n3mlConnectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(n3mlConnectionPanelLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(n3mlConnectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(preLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(connectionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(n3mlConnectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(n3mlConnectionPanelLayout.createSequentialGroup()
                    .addComponent(preComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(postLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(connectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(postComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27))
    );
    n3mlConnectionPanelLayout.setVerticalGroup(
        n3mlConnectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, n3mlConnectionPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(n3mlConnectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(connectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(connectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(n3mlConnectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(postLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(preComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(preLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(postComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    n3mlAlogorithmOptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlAlogorithmOptionPanel.border.title"))); // NOI18N
    n3mlAlogorithmOptionPanel.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlAlogorithmOptionPanel.toolTipText")); // NOI18N
    n3mlAlogorithmOptionPanel.setMinimumSize(new java.awt.Dimension(576, 143));

    org.openide.awt.Mnemonics.setLocalizedText(n3mlLearningAlgorithmLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlLearningAlgorithmLabel.text")); // NOI18N
    n3mlLearningAlgorithmLabel.setMaximumSize(new java.awt.Dimension(126, 15));
    n3mlLearningAlgorithmLabel.setMinimumSize(new java.awt.Dimension(126, 15));
    n3mlLearningAlgorithmLabel.setPreferredSize(new java.awt.Dimension(126, 15));

    n3mlLearningAlgorithmComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SoftLIF", "SpikeProp", "STDP", "BP-STDP", "STBP", "SpikeNorm" }));
    n3mlLearningAlgorithmComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.n3mlLearningAlgorithmComboBox.toolTipText")); // NOI18N
    n3mlLearningAlgorithmComboBox.setMaximumSize(new java.awt.Dimension(120, 21));
    n3mlLearningAlgorithmComboBox.setMinimumSize(new java.awt.Dimension(120, 21));
    n3mlLearningAlgorithmComboBox.setPreferredSize(new java.awt.Dimension(120, 21));
    n3mlLearningAlgorithmComboBox.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            n3mlLearningAlgorithmComboBoxItemStateChanged(evt);
        }
    });

    javax.swing.GroupLayout n3mlAlogorithmOptionPanelLayout = new javax.swing.GroupLayout(n3mlAlogorithmOptionPanel);
    n3mlAlogorithmOptionPanel.setLayout(n3mlAlogorithmOptionPanelLayout);
    n3mlAlogorithmOptionPanelLayout.setHorizontalGroup(
        n3mlAlogorithmOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(n3mlAlogorithmOptionPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(n3mlLearningAlgorithmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(n3mlLearningAlgorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    n3mlAlogorithmOptionPanelLayout.setVerticalGroup(
        n3mlAlogorithmOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(n3mlAlogorithmOptionPanelLayout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addGroup(n3mlAlogorithmOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(n3mlLearningAlgorithmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(n3mlLearningAlgorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    NAALHardwarePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.NAALHardwarePanel.border.title"))); // NOI18N
    NAALHardwarePanel.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.NAALHardwarePanel.toolTipText")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(runtimeBoardLabel, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.runtimeBoardLabel.text")); // NOI18N

    runtimeBoardComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DE1-SoC", "PYNQ", "Loihi" }));
    runtimeBoardComboBox.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.runtimeBoardComboBox.toolTipText")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.jLabel3.text")); // NOI18N

    SelectExampleComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MNIST", "SpeechRecognition", "Custom" }));
    SelectExampleComboBox2.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.SelectExampleComboBox2.toolTipText")); // NOI18N

    javax.swing.GroupLayout NAALHardwarePanelLayout = new javax.swing.GroupLayout(NAALHardwarePanel);
    NAALHardwarePanel.setLayout(NAALHardwarePanelLayout);
    NAALHardwarePanelLayout.setHorizontalGroup(
        NAALHardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(NAALHardwarePanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(runtimeBoardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(runtimeBoardComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(43, 43, 43)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(SelectExampleComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    NAALHardwarePanelLayout.setVerticalGroup(
        NAALHardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NAALHardwarePanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(NAALHardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(runtimeBoardLabel)
                .addComponent(runtimeBoardComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3)
                .addComponent(SelectExampleComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    runtimeBoardComboBox.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.runtimeBoardComboBox.AccessibleContext.accessibleName")); // NOI18N
    SelectExampleComboBox2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.SelectExampleComboBox2.AccessibleContext.accessibleName")); // NOI18N

    naalNeuronModelPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.naalNeuronModelPanel.border.title"))); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(simulationTimeLabel3, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.simulationTimeLabel3.text")); // NOI18N

    simulationTimeTextField3.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.simulationTimeTextField3.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(dtLabel3, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.dtLabel3.text")); // NOI18N

    dtTextField3.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.dtTextField3.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(inputSizeLabel3, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.inputSizeLabel3.text")); // NOI18N

    inputSizeTextField3.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.inputSizeTextField3.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(outputSizeLabel3, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.outputSizeLabel3.text")); // NOI18N

    outputSizeTextField3.setText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.outputSizeTextField3.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(dataTypeLabel3, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.dataTypeLabel3.text")); // NOI18N

    dataTypeComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Image", "Camera", "Voice" }));
    dataTypeComboBox3.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.dataTypeComboBox3.toolTipText")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(deviceLabel3, org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.deviceLabel3.text")); // NOI18N

    deviceComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Raspberry PI", "Latte Panda", "Coral", "Tinker", "Jetson" }));
    deviceComboBox3.setToolTipText(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.deviceComboBox3.toolTipText")); // NOI18N

    javax.swing.GroupLayout naalNeuronModelPanelLayout = new javax.swing.GroupLayout(naalNeuronModelPanel);
    naalNeuronModelPanel.setLayout(naalNeuronModelPanelLayout);
    naalNeuronModelPanelLayout.setHorizontalGroup(
        naalNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(naalNeuronModelPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(naalNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(simulationTimeLabel3)
                .addComponent(inputSizeLabel3)
                .addComponent(dataTypeLabel3))
            .addGap(41, 41, 41)
            .addGroup(naalNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(inputSizeTextField3)
                .addComponent(simulationTimeTextField3)
                .addComponent(dataTypeComboBox3, 0, 120, Short.MAX_VALUE))
            .addGap(43, 43, 43)
            .addGroup(naalNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dtLabel3)
                .addComponent(outputSizeLabel3)
                .addComponent(deviceLabel3))
            .addGap(37, 37, 37)
            .addGroup(naalNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(dtTextField3)
                .addComponent(outputSizeTextField3)
                .addComponent(deviceComboBox3, 0, 118, Short.MAX_VALUE))
            .addContainerGap())
    );
    naalNeuronModelPanelLayout.setVerticalGroup(
        naalNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(naalNeuronModelPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(naalNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(inputSizeLabel3)
                .addComponent(inputSizeTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(outputSizeLabel3)
                .addComponent(outputSizeTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(naalNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(simulationTimeLabel3)
                .addComponent(simulationTimeTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dtLabel3)
                .addComponent(dtTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(naalNeuronModelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(dataTypeLabel3)
                .addComponent(dataTypeComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(deviceLabel3)
                .addComponent(deviceComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(156, 156, 156)
            .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(152, 152, 152))
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(logPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addComponent(n3mlConnectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 571, Short.MAX_VALUE)
                .addComponent(n3mlPopulationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 571, Short.MAX_VALUE)
                .addComponent(n3mlAlogorithmOptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 571, Short.MAX_VALUE)
                .addComponent(fpgaTrainingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(trainingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(naalNeuronModelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fpgaNeuronModelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 571, Short.MAX_VALUE)
                .addComponent(RuntimePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modelDirPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NAALHardwarePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(n3mlLoadDataPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(neuronModelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(n3mlModelOptionPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 571, Short.MAX_VALUE)
                .addComponent(libraryDirPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 571, Short.MAX_VALUE)
                .addComponent(loadDataPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, nextButton});

    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(RuntimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(modelDirPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(NAALHardwarePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(libraryDirPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(loadDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(n3mlLoadDataPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(neuronModelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(fpgaNeuronModelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(naalNeuronModelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(trainingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(fpgaTrainingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(n3mlAlogorithmOptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(n3mlModelOptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(n3mlPopulationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(n3mlConnectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(logPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );

    layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelButton, nextButton});

    RuntimePanel.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.RuntimePanel.AccessibleContext.accessibleName")); // NOI18N
    cancelButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(SpikingNeuralNetworkDialog.class, "SpikingNeuralNetworkDialog.cancelButton.AccessibleContext.accessibleName")); // NOI18N

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myInitComponents(){
        modelDirTextField.setText(hDirectory);
        LOADDATA = false;
        LOADLIB = false; 
        libDir = new File("");    
        srcDir = new File(hDirectory + File.separatorChar);   
        srcFile = new File("");
        destDir = new File(hDirectory + File.separatorChar + "src" + File.separatorChar + "DataSets"); /*--- Jaehee Kim 2020.10.08 수정 ---*/
        
        int runtime = setRuntime();
        switch(runtime){
            case H_NengoDL:
                runtimeComboBox.setSelectedIndex(H_NengoDL);
                UiNengoDL();break;
            case H_NAAL:
                runtimeComboBox.setSelectedIndex(H_NAAL);
                UiNAAL();break;
            case H_DE1_SOC:
                runtimeComboBox.setSelectedIndex(H_DE1_SOC);
                UiDe1SoC();break;
            case H_N3ML:
                runtimeComboBox.setSelectedIndex(H_N3ML);
                UiN3ML();break;
            case H_ONNX:
                runtimeComboBox.setSelectedIndex(H_ONNX);
                UiONNX();break;
            default:
                runtimeComboBox.setSelectedIndex(H_NengoDL);
                RuntimePanel.setVisible(true);
                modelDirPanel.setVisible(true);
                libraryDirPanel.setVisible(false);
                loadDataPanel.setVisible(true);
                n3mlLoadDataPanel1.setVisible(false);
                neuronModelPanel.setVisible(true);
                fpgaNeuronModelPanel.setVisible(false);
                n3mlModelOptionPanel.setVisible(false);
                n3mlAlogorithmOptionPanel.setVisible(false);
                n3mlPopulationPanel.setVisible(false);
                n3mlConnectionPanel.setVisible(false);
                trainingPanel.setVisible(true);
                fpgaTrainingPanel.setVisible(false);
                NAALHardwarePanel.setVisible(false);
                logPanel.setVisible(false);
                naalNeuronModelPanel.setVisible(false);
        }

    }
    
    private int setRuntime(){
        String checkPath = hDirectory + File.separatorChar + "snn";
        File path = new File(checkPath);
        File[] fileList = path.listFiles();
        String[] runtimeFile = path.list();
        
        if (runtimeFile.length == 0)
            return -1;
        else{
            if(runtimeFile[0].equals("NengoDL"))
                return H_NengoDL;
            else if (runtimeFile[0].equals("NAAL"))
                return H_NAAL;
            else if (runtimeFile[0].equals("DE1-SoC"))
                return H_DE1_SOC;
            else if (runtimeFile[0].equals("N3ML"))
                return H_N3ML;
            else
                return H_ONNX;
        }
            
    }
    
    private void runtimeTrainingRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runtimeTrainingRadioButtonActionPerformed
        runtimeTrainingRadioButton.setActionCommand("Training");
        hDataSetOpt = H_DATA_SET_TRAINING;
    }//GEN-LAST:event_runtimeTrainingRadioButtonActionPerformed

    private void runtimeTestRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runtimeTestRadioButtonActionPerformed
        runtimeTestRadioButton.setActionCommand("Test");
        hDataSetOpt = H_DATA_SET_TEST;
    }//GEN-LAST:event_runtimeTestRadioButtonActionPerformed

    private void modelDirBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelDirBrowseButtonActionPerformed
        evt.setSource(modelDirBrowseButton);
        selectDirectory(evt);
    }//GEN-LAST:event_modelDirBrowseButtonActionPerformed

    private void loadDataFromFileCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_loadDataFromFileCheckBoxItemStateChanged
        if (loadDataFromFileCheckBox.isSelected()) {
            modelFileTextField.setEnabled(true);
            DelimiterLabel.setEnabled(true);
            delimiterComboBox.setEnabled(true);
            fileDirBrowseButton.setEnabled(true);
            modelFileLabel.setEnabled(true);
            IncludeFirstLineCheckBox.setEnabled(true);
            toRabel1.setEnabled(true);
            toRabel2.setEnabled(true);
            xRangeField1.setEnabled(true);
            xRangeField2.setEnabled(true);
            xRangeLabel.setEnabled(true);
            yRangeField1.setEnabled(true);
            yRangeField2.setEnabled(true);
            yRangeLabel.setEnabled(true);
            
        } else {
            DelimiterLabel.setEnabled(false);
            delimiterComboBox.setEnabled(false);
            IncludeFirstLineCheckBox.setEnabled(false);
            toRabel1.setEnabled(false);
            toRabel2.setEnabled(false);
            xRangeField1.setEnabled(false);
            xRangeField2.setEnabled(false);
            xRangeLabel.setEnabled(false);
            yRangeField1.setEnabled(false);
            yRangeField2.setEnabled(false);
            yRangeLabel.setEnabled(false);
        }
    }//GEN-LAST:event_loadDataFromFileCheckBoxItemStateChanged

    private void fileDirBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileDirBrowseButtonActionPerformed
        if(loadDataFromFileCheckBox.isSelected())
            selectFile();        
        else{
            evt.setSource(fileDirBrowseButton);
            selectDirectory(evt);
        }
    }//GEN-LAST:event_fileDirBrowseButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        initIOConf();
        createRuntimeFile();

        if (loadDataFromFileCheckBox.isSelected() && !modelFileTextField.getText().equals("")) {
            loadDir = modelFileTextField.getText();
            loadData(loadDir);
        } else if (!loadDataFromFileCheckBox.isSelected() && !modelFileTextField.getText().equals("")) {
            loadLib(H_NengoDL);
            copyLib(libDir, destLib);
        }


        int runtime = runtimeComboBox.getSelectedIndex();
        switch (runtime) {
            case H_DE1_SOC:
                if (LOADDATA == true) {
                    copyFile(srcFile, destDir);
                }
                if (!libraryDirTextField.getText().equals("This is your Nengo FPGA library directory.")) {
                    loadLib(H_DE1_SOC);
                    if (LOADLIB == true) {
                        copyLib(libDir, destLib);
                    }
                }
                cancel();
                break;
            case H_NAAL:
                if (LOADDATA == true) {
                    copyFile(srcFile, destDir);
                }
                if (!libraryDirTextField.getText().equals("This is your NAAL library directory.")) {
                    loadLib(H_NAAL);
                    if (LOADLIB == true) {
                        copyLib(libDir, destLib);
                    }
                }
                cancel();
                break;
            case H_N3ML:
                if (!n3mlLoadDirTextField.getText().equals("This is your data directory.")) {
                    loadLib(H_N3ML);
                    copyLib(libDir, destLib);
                }
                showN3MLAlgorithmAdialog(hN3mlNeuronModel, hN3mlAlgorithm);
                break;
            case H_NengoDL:
                showInputNumberLayerDialog(hSIOConf, cnnCheckBox.isSelected(), modelTypeComboBox.getSelectedIndex());
                break;
            default:
                break;
        }

    }//GEN-LAST:event_nextButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cancel();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void runtimeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_runtimeComboBoxItemStateChanged
        if(runtimeComboBox.getSelectedIndex() == H_DE1_SOC ){              
            UiDe1SoC();
        }else if(runtimeComboBox.getSelectedIndex() == H_NAAL ){              
            UiNAAL();
        }else if(runtimeComboBox.getSelectedIndex() == H_N3ML){     
            UiN3ML();
        }else if(runtimeComboBox.getSelectedIndex() == H_NengoDL){
            UiNengoDL();
        }
        else{                                                     
            UiONNX();
        }
    }//GEN-LAST:event_runtimeComboBoxItemStateChanged

    private void runtimeTestRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_runtimeTestRadioButtonItemStateChanged

        if(runtimeComboBox.getSelectedIndex() == H_NengoDL && cnnCheckBox.isSelected()){

        }else if (runtimeComboBox.getSelectedIndex() == H_NengoDL && !(cnnCheckBox.isSelected())){
            minibatchSizeTextField.setVisible(true);
            minibatchSizeLabel.setVisible(true);
            minibatchSizeTextField.setText("1");
        }
            
    }//GEN-LAST:event_runtimeTestRadioButtonItemStateChanged

    private void runtimeTrainingRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_runtimeTrainingRadioButtonItemStateChanged

        if(runtimeComboBox.getSelectedIndex() == H_NengoDL){
            minibatchSizeTextField.setVisible(true);
            minibatchSizeLabel.setVisible(true);
        }
    }//GEN-LAST:event_runtimeTrainingRadioButtonItemStateChanged

    private void libraryDirBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libraryDirBrowseButtonActionPerformed
        evt.setSource(libraryDirBrowseButton);
        selectDirectory(evt);
    }//GEN-LAST:event_libraryDirBrowseButtonActionPerformed

    private void n3mlLoadDirBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n3mlLoadDirBrowseButtonActionPerformed
        evt.setSource(n3mlLoadDirBrowseButton);
        selectDirectory(evt);
    }//GEN-LAST:event_n3mlLoadDirBrowseButtonActionPerformed

    private void imageSizeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageSizeTextFieldActionPerformed
    }//GEN-LAST:event_imageSizeTextFieldActionPerformed

    private void n3mlLearningAlgorithmComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_n3mlLearningAlgorithmComboBoxItemStateChanged
        if(n3mlLearningAlgorithmComboBox.getSelectedIndex()==H_N3ML_A_softLIF){
            runtimeTrainingRadioButton.setEnabled(true); 
            runtimeTrainingRadioButton.setSelected(true);  
            n3mlNeuronModelComboBox.setSelectedIndex(H_N3ML_NM_Soft_LIF_MODEL);
        }
        else if(n3mlLearningAlgorithmComboBox.getSelectedIndex()==H_N3ML_A_SpikeProp){
            runtimeTrainingRadioButton.setEnabled(false);  
            runtimeTestRadioButton.setSelected(true);  
            n3mlNeuronModelComboBox.setSelectedIndex(H_N3ML_NM_SRM_MODEL);
        }
        else if(n3mlLearningAlgorithmComboBox.getSelectedIndex()==H_N3ML_A_STDP){
            runtimeTrainingRadioButton.setEnabled(true);  
            runtimeTrainingRadioButton.setSelected(true);  
            n3mlNeuronModelComboBox.setSelectedIndex(H_N3ML_NM_Adaptive_LIF_MODEL);
        }
        else if(n3mlLearningAlgorithmComboBox.getSelectedIndex()==H_N3ML_A_BP_STDP ){
            runtimeTrainingRadioButton.setEnabled(true);  
            runtimeTrainingRadioButton.setSelected(true);  
            n3mlNeuronModelComboBox.setSelectedIndex(H_N3ML_NM_IF_MODEL);
        }
        else if(n3mlLearningAlgorithmComboBox.getSelectedIndex()==H_N3ML_A_STBP  ){
            runtimeTrainingRadioButton.setEnabled(true);  
            runtimeTrainingRadioButton.setSelected(true);  
            n3mlNeuronModelComboBox.setSelectedIndex(H_N3ML_NM_IF_MODEL);
        }
        else{
            runtimeTrainingRadioButton.setEnabled(true);  
            runtimeTrainingRadioButton.setSelected(true);  
            n3mlNeuronModelComboBox.setSelectedIndex(H_N3ML_NM_Soft_LIF_MODEL);
        }
    }//GEN-LAST:event_n3mlLearningAlgorithmComboBoxItemStateChanged

    private void cnnCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnnCheckBoxActionPerformed
        
        if (cnnCheckBox.isSelected()) {
            runtimeTrainingRadioButton.setEnabled(true);
            runtimeTrainingRadioButton.setSelected(false);
            inputsTextField.setText("28,28");
            outputsTextField.setText("10");
            modelTypeComboBox.setSelectedIndex(MNIST);
                
            if (runtimeTrainingRadioButton.isSelected()) {
                amplitudeTextArea.setText("0.01");
                maxRateTextField.setText("100");
                synapseTextField.setText("None");
                minibatchSizeTextField.setVisible(true);
                minibatchSizeLabel.setVisible(true);
                minibatchSizeTextField.setText("20");
                costFunctionComboBox.setSelectedIndex(0);
                runtimeTrainingRadioButton.setEnabled(true);
                runtimeTestRadioButton.setEnabled(true);
            }
            else{
            }
        } else {
                amplitudeTextArea.setText("1");
                maxRateTextField.setText("200");
                synapseTextField.setText("0.01");
                minibatchSizeLabel.setVisible(true);
                minibatchSizeTextField.setVisible(true);
                minibatchSizeTextField.setText("1");
                costFunctionComboBox.setSelectedIndex(1);
                inputsTextField.setText("1");
                outputsTextField.setText("1");
                modelTypeComboBox.setSelectedIndex(Linear);

        }
    }//GEN-LAST:event_cnnCheckBoxActionPerformed

    private void modelTypeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_modelTypeComboBoxItemStateChanged
        if(modelTypeComboBox.getSelectedIndex() == Linear){
            amplitudeTextArea.setText("1");
                maxRateTextField.setText("200");
                synapseTextField.setText("0.01");
                minibatchSizeLabel.setVisible(true);
                minibatchSizeTextField.setVisible(true);
                minibatchSizeTextField.setText("1");
                optimizerComboBox.setSelectedIndex(1);
                costFunctionComboBox.setSelectedIndex(1);
                inputsTextField.setText("1");
                outputsTextField.setText("1");
        }
        else if(modelTypeComboBox.getSelectedIndex() == MNIST){
            runtimeTrainingRadioButton.setEnabled(true);
            runtimeTrainingRadioButton.setSelected(false);
            inputsTextField.setText("28,28");
            outputsTextField.setText("10");
                minibatchSizeTextField.setVisible(true);
                minibatchSizeLabel.setVisible(true);
                minibatchSizeTextField.setText("1");
                optimizerComboBox.setSelectedIndex(0);
                
            if (runtimeTrainingRadioButton.isSelected()) {
                amplitudeTextArea.setText("0.01");
                maxRateTextField.setText("100");
                synapseTextField.setText("None");
                costFunctionComboBox.setSelectedIndex(0);
            }
            else{
            }
        }
    }//GEN-LAST:event_modelTypeComboBoxItemStateChanged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SpikingNeuralNetworkDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpikingNeuralNetworkDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpikingNeuralNetworkDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpikingNeuralNetworkDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SpikingNeuralNetworkDialog dialog = new SpikingNeuralNetworkDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    
    @Action
    public void cancel() {
        this.dispose();
    }
    
    public void selectDirectory(java.awt.event.ActionEvent evt) {
        String title="Select Project Location";
        String path = "";
        int evtDir = 0; 
        
        if(evt.getSource() == libraryDirBrowseButton ){
            title = "Select Library Location";
            evtDir = 1;
        }else if(evt.getSource() == n3mlLoadDirBrowseButton ){
            evtDir = 2;
            title = "Select Data Location";
        }
        else if(evt.getSource() == fileDirBrowseButton ){
            evtDir = 3;
            title = "Select Data Location";
        }
        
        FileUtil.preventFileChooserSymlinkTraversal(fileChooser, null);
        fileChooser.setDialogTitle(title);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(evtDir ==0)
            path = modelDirTextField.getText();
        else if(evtDir ==1)
            path = libraryDirTextField.getText();
        else
            path = n3mlLoadDirTextField.getText();
        
        if (path.length() > 0) {
            File f = new File(path);
            if (f.exists()) {
                fileChooser.setSelectedFile(f);
            }
        }
        if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(this)) {
            File projectDir = fileChooser.getSelectedFile();
            if(evtDir ==0){
                modelDirTextField.setText(FileUtil.normalizeFile(projectDir).getAbsolutePath());
            }
            else if(evtDir ==1){
                libraryDirTextField.setText(FileUtil.normalizeFile(projectDir).getAbsolutePath());
            }else if(evtDir==2){
                n3mlLoadDirTextField.setText(FileUtil.normalizeFile(projectDir).getAbsolutePath());
            }else{
                modelFileTextField.setText(FileUtil.normalizeFile(projectDir).getAbsolutePath());
            }
            
        }
    }
    
    private void selectFile() {
        FileUtil.preventFileChooserSymlinkTraversal(fileChooser, null);
        fileChooser.setDialogTitle("Load File");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        String path = ndPrjDir;
        if (path.length() > 0) {
            File f = new File(path);
            if (f.exists()) {
                fileChooser.setSelectedFile(f);
            }
        }
        if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(this)) {
            File fileDir = fileChooser.getSelectedFile();
            modelFileTextField.setText(FileUtil.normalizeFile(fileDir).getAbsolutePath());
        }
    }
    
    private void initIOConf(){
        hSIOConf.setData_opt(hDataSetOpt);
                
        String modelName = modelNameTextField.getText();
        String modelDir = modelDirTextField.getText();
        
        if(runtimeComboBox.getSelectedIndex()==H_NengoDL){
            initNengoDL(modelName,modelDir);
        }
        
        else if(runtimeComboBox.getSelectedIndex()==H_DE1_SOC ){ 
            initDE1SoC(modelName,modelDir);
        }
        else if(runtimeComboBox.getSelectedIndex()==H_NAAL){
            initNAAL_model_prediction(modelDir);
        }
        else if(runtimeComboBox.getSelectedIndex()==H_N3ML){ 
            initN3ML(modelName,modelDir, n3mlNeuronModelComboBox.getSelectedIndex(), n3mlLearningAlgorithmComboBox.getSelectedIndex());
        }
        
    }
    
    private void generateSNNHardwareSource(){ 
        hSNNHWGen.hSTATE = H_SNN;
        hSNNHWGen.createFile(hSNNHWGen.modelDir);
        hSNNHWGen.writeSNNGen();
    }
    private void generateNAAL_Model_Prediction(){ 
        hNAALGen.hSTATE = H_SNN;
        hNAALGen.createFile(hNAALGen.modelDir);
        hNAALGen.writeSNN_NAALGen();
    }    
    private void generateSNNN3MLSource(){
        hN3mlGen.hSTATE = H_SNN;
        hN3mlGen.createFile(hN3mlGen.modelDir);
        hN3mlGen.writeN3MLGen();
    }
    
    private void showInputNumberLayerDialog(HSNNIOConfig hSIOConf, boolean selectedCNN, int type){
        InputNumberLayerDialog dialog = new InputNumberLayerDialog(null, true, hSNNGen, hSIOConf, selectedCNN, hDirectory, type, hDataSetOpt);        
        dialog.setLocationRelativeTo(null);
        cancel();
        dialog.setVisible(true);
    }
    
    private void showN3MLAlgorithmAdialog(int neuronModel, int algorithm){
        N3MLAlgorithmDialog dialog = new N3MLAlgorithmDialog(null, true, hN3mlGen, hN3mlIOConf, neuronModel, algorithm, hDataSetOpt, hDirectory);
        dialog.setLocationRelativeTo(null);
        cancel();
        dialog.setVisible(true);
    }
    
    private void initNengoDL(String modelName, String modelDir){
        hSIOConf.setInput(inputsTextField.getText());
        hSIOConf.setOutput(outputsTextField.getText());
        hSIOConf.setEpoch(Integer.parseInt(epochsTextField.getText()));
        hSIOConf.setLearning_rate(learningRateTextField.getText());
        hSIOConf.setOptimizer((String)optimizerComboBox.getSelectedItem());
        hSIOConf.setLoss((String)costFunctionComboBox.getSelectedItem());
            
        hSIOConf.setNeuron_type((String)neuronModelComboBox.getSelectedItem());
        hSIOConf.setAmplitude(Double.parseDouble(amplitudeTextArea.getText()));
        hSIOConf.setMax_rates(Integer.parseInt(maxRateTextField.getText()));
        hSIOConf.setIntercepts(Double.parseDouble(interceptsTextField.getText()));
        hSIOConf.setSynapse((String)synapseTextField.getText());
        hSIOConf.setBatch_size(Integer.parseInt(minibatchSizeTextField.getText()));
            
        hSIOConf.setXY_range(xRangeField1.getText(), xRangeField2.getText(), yRangeField1.getText(), yRangeField2.getText());
        delim = (String)delimiterComboBox.getSelectedItem();
        
        hSIOConf.setTau_rc(Double.parseDouble(tauRcTextField.getText()));

        hSNNGen.initConfig(hSIOConf, modelName, modelDir);
        hSNNGen.setInputData(hSIOConf.getInput()); 
    }

    private void initDE1SoC(String modelName, String modelDir){
        hSIOConf.setInput(inputsTextField2.getText());
        hSIOConf.setOutput(outputsTextField2.getText());
        hSIOConf.setEpoch(Integer.parseInt(epochsTextField2.getText()));
        
        hSIOConf.setNeuron_type((String)neuronModelComboBox2.getSelectedItem());
        hSIOConf.setMax_rates(Integer.parseInt(maxRateTextField2.getText()));
        hSIOConf.setIntercepts(Double.parseDouble(interceptsTextField2.getText()));
        hSIOConf.setSynapse((String)synapseTextField2.getText());

        hSIOConf.setNeuronSize((Object)neuronSizeSpinner.getModel().getValue());
        hSIOConf.setImageSize(Double.parseDouble(imageSizeTextField.getText()));
        hSNNHWGen.initConfig(hSIOConf, modelName, modelDir);        
        hSNNGenJ.set_configDe1(3);
        hSNNGenJ.initGenerator(hDirectory);
        generateSNNHardwareSource(); 
    }
        private void initNAAL_model_prediction(String modelDir){
        hSIOConf.setBoards((String)runtimeBoardComboBox.getSelectedItem());
        hSIOConf.setModelPrediction((String)SelectExampleComboBox2.getSelectedItem());
        hNAALGen.initConfig(hSIOConf, modelDir);        
        hSNNGenJ.set_configDe1(3);
        hSNNGenJ.initGenerator(hDirectory);
        generateNAAL_Model_Prediction(); 
    }
    
    private void initN3ML(String modelName, String modelDir, int neuronmodel, int algorithm){
        hN3mlGen = new HSNNN3MLGenerator(modelName, modelDir);
        switch(neuronmodel){
            case H_N3ML_NM_LIF_MODEL :
                hN3mlNeuronModel = H_N3ML_NM_LIF_MODEL ; break;
            case H_N3ML_NM_Soft_LIF_MODEL :
                hN3mlNeuronModel = H_N3ML_NM_Soft_LIF_MODEL ; break;
            case H_N3ML_NM_IF_MODEL:
                hN3mlNeuronModel = H_N3ML_NM_IF_MODEL; break;
            case H_N3ML_NM_SRM_MODEL:
                hN3mlNeuronModel = H_N3ML_NM_SRM_MODEL; break;
            case H_N3ML_NM_Adaptive_LIF_MODEL :
                hN3mlNeuronModel = H_N3ML_NM_Adaptive_LIF_MODEL ; break;
        }
        switch(algorithm){
            case H_N3ML_A_SpikeProp:
                hN3mlAlgorithm = H_N3ML_A_SpikeProp; break;
            case H_N3ML_A_STDP:
                hN3mlAlgorithm = H_N3ML_A_STDP; break;
            case H_N3ML_A_BP_STDP:
                hN3mlAlgorithm = H_N3ML_A_BP_STDP; break;
            case H_N3ML_A_softLIF:
                hN3mlAlgorithm = H_N3ML_A_softLIF; break;
            case H_N3ML_A_STBP:
                hN3mlAlgorithm = H_N3ML_A_STBP; break;
            case H_N3ML_A_SpikeNorm:
                hN3mlAlgorithm = H_N3ML_A_SpikeNorm; break;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DelimiterLabel;
    private javax.swing.JCheckBox IncludeFirstLineCheckBox;
    private javax.swing.JPanel NAALHardwarePanel;
    private javax.swing.JPanel RuntimePanel;
    private javax.swing.JComboBox SelectExampleComboBox2;
    private javax.swing.JLabel amplitudeLabel;
    private javax.swing.JTextField amplitudeTextArea;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox cnnCheckBox;
    private javax.swing.JPanel cnnPanel;
    private javax.swing.JComboBox connectionComboBox;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JComboBox costFunctionComboBox;
    private javax.swing.JLabel costFunctionLabel;
    private javax.swing.JComboBox dataTypeComboBox3;
    private javax.swing.JLabel dataTypeLabel3;
    private javax.swing.ButtonGroup datasetOptionButtonGroup;
    private javax.swing.JComboBox delimiterComboBox;
    private javax.swing.JComboBox deviceComboBox3;
    private javax.swing.JLabel deviceLabel3;
    private javax.swing.JLabel dtLabel3;
    private javax.swing.JTextField dtTextField3;
    private javax.swing.JLabel epochsLabel;
    private javax.swing.JLabel epochsLabel2;
    private javax.swing.JTextField epochsTextField;
    private javax.swing.JTextField epochsTextField2;
    private javax.swing.JButton fileDirBrowseButton;
    private javax.swing.JPanel fpgaNeuronModelPanel;
    private javax.swing.JPanel fpgaTrainingPanel;
    private javax.swing.JLabel imageSizeLabel;
    private javax.swing.JTextField imageSizeTextField;
    private javax.swing.JLabel inputSizeLabel3;
    private javax.swing.JTextField inputSizeTextField3;
    private javax.swing.JLabel inputsLabel;
    private javax.swing.JLabel inputsLabel2;
    private javax.swing.JTextField inputsTextField;
    private javax.swing.JTextField inputsTextField2;
    private javax.swing.JLabel interceptsLabel;
    private javax.swing.JLabel interceptsLabel2;
    private javax.swing.JTextField interceptsTextField;
    private javax.swing.JTextField interceptsTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox learningComboBox3;
    private javax.swing.JLabel learningRateLabel;
    private javax.swing.JTextField learningRateTextField;
    private javax.swing.JButton libraryDirBrowseButton;
    private javax.swing.JPanel libraryDirPanel;
    private javax.swing.JTextField libraryDirTextField;
    private javax.swing.JCheckBox loadDataFromFileCheckBox;
    private javax.swing.JPanel loadDataPanel;
    private javax.swing.JLabel loadDirLabel1;
    private javax.swing.JPanel logPanel;
    private javax.swing.JLabel maxRateLabel;
    private javax.swing.JLabel maxRateLabel2;
    private javax.swing.JTextField maxRateTextField;
    private javax.swing.JTextField maxRateTextField2;
    private javax.swing.JLabel minibatchSizeLabel;
    private javax.swing.JTextField minibatchSizeTextField;
    private javax.swing.JButton modelDirBrowseButton;
    private javax.swing.JLabel modelDirLabel;
    private javax.swing.JPanel modelDirPanel;
    private javax.swing.JTextField modelDirTextField;
    private javax.swing.JLabel modelFileLabel;
    private javax.swing.JTextField modelFileTextField;
    private javax.swing.JLabel modelNameLabel;
    private javax.swing.JTextField modelNameTextField;
    private javax.swing.JComboBox modelTypeComboBox;
    private javax.swing.JLabel modelTypeLabel;
    private javax.swing.JPanel n3mlAlogorithmOptionPanel;
    private javax.swing.JPanel n3mlConnectionPanel;
    private javax.swing.JComboBox n3mlLearningAlgorithmComboBox;
    private javax.swing.JLabel n3mlLearningAlgorithmLabel;
    private javax.swing.JPanel n3mlLoadDataPanel1;
    private javax.swing.JButton n3mlLoadDirBrowseButton;
    private javax.swing.JTextField n3mlLoadDirTextField;
    private javax.swing.JPanel n3mlModelOptionPanel;
    private javax.swing.JComboBox n3mlNeuronModelComboBox;
    private javax.swing.JLabel n3mlNeuronModelLabel;
    private javax.swing.JPanel n3mlPopulationPanel;
    private javax.swing.JPanel naalNeuronModelPanel;
    private javax.swing.JPanel nengoDLModelPanel;
    private javax.swing.JComboBox neuronModelComboBox;
    private javax.swing.JComboBox neuronModelComboBox2;
    private javax.swing.JLabel neuronModelLabel;
    private javax.swing.JLabel neuronModelLabel2;
    private javax.swing.JPanel neuronModelPanel;
    private javax.swing.JLabel neuronSizeLabel;
    private javax.swing.JSpinner neuronSizeSpinner;
    private javax.swing.JButton nextButton;
    private javax.swing.JComboBox optimizerComboBox;
    private javax.swing.JLabel optimizerLabel;
    private javax.swing.JLabel outputSizeLabel3;
    private javax.swing.JTextField outputSizeTextField3;
    private javax.swing.JLabel outputsLabel;
    private javax.swing.JLabel outputsLabel2;
    private javax.swing.JTextField outputsTextField;
    private javax.swing.JTextField outputsTextField2;
    private javax.swing.JLabel populationLabel;
    private javax.swing.JComboBox postComboBox;
    private javax.swing.JLabel postLabel;
    private javax.swing.JComboBox preComboBox;
    private javax.swing.JLabel preLabel;
    private javax.swing.JComboBox runtimeBoardComboBox;
    private javax.swing.JLabel runtimeBoardLabel;
    private javax.swing.JComboBox runtimeComboBox;
    private javax.swing.JLabel runtimeLabel;
    private javax.swing.JLabel runtimeOptionLabel;
    private javax.swing.JRadioButton runtimeTestRadioButton;
    private javax.swing.JRadioButton runtimeTrainingRadioButton;
    private javax.swing.JLabel simulationTimeLabel3;
    private javax.swing.JTextField simulationTimeTextField3;
    private javax.swing.JLabel synapseLabel;
    private javax.swing.JLabel synapseLabel2;
    private javax.swing.JTextField synapseTextField;
    private javax.swing.JTextField synapseTextField2;
    private javax.swing.JLabel tauRcLabel;
    private javax.swing.JTextField tauRcTextField;
    private javax.swing.JLabel toRabel1;
    private javax.swing.JLabel toRabel2;
    private javax.swing.JPanel trainingPanel;
    private javax.swing.JTextArea varificationLogTextArea;
    private javax.swing.JTextField xRangeField1;
    private javax.swing.JTextField xRangeField2;
    private javax.swing.JLabel xRangeLabel;
    private javax.swing.JTextField yRangeField1;
    private javax.swing.JTextField yRangeField2;
    private javax.swing.JLabel yRangeLabel;
    // End of variables declaration//GEN-END:variables

    private void loadData(String loadDir) {
        LOADDATA = true;    
        srcFile = new File(loadDir);
    }
    
    private void loadLib(int state) {
        LOADLIB = true;
        
        if(state == H_DE1_SOC ){
            libDir = new File(libraryDirTextField.getText());
            destLib = new File(srcDir.getAbsolutePath() + File.separatorChar + libDir.getName());
        }else if(state == H_N3ML){
            libDir = new File(n3mlLoadDirTextField.getText());
            destLib = new File(srcDir.getAbsolutePath() + File.separatorChar + "src" +File.separatorChar +"DataSets" + File.separatorChar + libDir.getName());
        }else if(state == H_NengoDL){
            libDir = new File(modelFileTextField.getText());
            destLib = new File(srcDir.getAbsolutePath() + File.separatorChar + "src" +File.separatorChar + "hnu" + File.separatorChar + libDir.getName());
        }
        else if(state == H_NAAL ){
            libDir = new File(libraryDirTextField.getText());
            destLib = new File(srcDir.getAbsolutePath() + File.separatorChar + "src"+ File.separatorChar + "hnu"+ File.separatorChar + libDir.getName());
        }
        destLib.mkdirs();
    }
    
    public void copyFile(File srcFile, File destDir){         

        destDir.mkdirs();
        
        try{
            FileInputStream fin = new FileInputStream(srcFile.getAbsolutePath());
            FileOutputStream fout = new FileOutputStream(destDir.getAbsolutePath() + File.separatorChar + srcFile.getName());

            int tmp = 0;
            while ((tmp = fin.read()) != -1) {
                fout.write(tmp);
            }
            fin.close();
            fout.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void copyLib(File libDir, File destLib){
        
        File[] childrenList = libDir.listFiles();
        
        for(File file : childrenList){
            File temp = new File(destLib.getAbsolutePath() + File.separatorChar + file.getName());
            
            FileInputStream fis = null ;
            FileOutputStream fos = null;
                    
            if(file.isDirectory()){
                temp.mkdirs();
                copyLib(file, temp);
            }else {
                try {
                    fis = new FileInputStream(file);
                    fos = new FileOutputStream(temp);
                    
                    byte[] b = new byte[4096];
                    int count = 0;
                    
                    while((count = fis.read(b)) != -1) {
                        fos.write(b , 0 , count);
                    }
                    
                }catch(Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fis.close();
                        fos.close();
                    }catch(Exception e) {}
                }
            }
        }
        
    }
    
    private void createRuntimeFile(){ //SeoyeonKim 2021.08.25
        
        String checkPath = hDirectory + File.separatorChar + "snn";
        File path = new File(checkPath);
        File[] fileList = path.listFiles();

        
        File runtimeFile = new File(checkPath+ File.separatorChar + (String)runtimeComboBox.getSelectedItem());
        try {
            if (runtimeFile.createNewFile()) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void UiNengoDL() {
        modelDirPanel.setVisible(true);
        libraryDirPanel.setVisible(false);
        loadDataPanel.setVisible(true);
        n3mlLoadDataPanel1.setVisible(false);
        neuronModelPanel.setVisible(true);
        fpgaNeuronModelPanel.setVisible(false);
        n3mlModelOptionPanel.setVisible(false);
        n3mlAlogorithmOptionPanel.setVisible(false);
        n3mlPopulationPanel.setVisible(false);
        n3mlConnectionPanel.setVisible(false);
        trainingPanel.setVisible(true);
        fpgaTrainingPanel.setVisible(false);
        NAALHardwarePanel.setVisible(false);
        naalNeuronModelPanel.setVisible(false);
        logPanel.setVisible(false);
        //cnnCheckBox.setVisible(true);
        cnnPanel.setVisible(true);
        nengoDLModelPanel.setVisible(true);
        runtimeTrainingRadioButton.setEnabled(true);
        modelTypeComboBox.setSelectedIndex(Linear);

//        if (runtimeTestRadioButton.isSelected() && cnnCheckBox.isSelected()) {
//            minibatchSizeTextField.setVisible(false);
//            minibatchSizeLabel.setVisible(false);
//        } else {
//            minibatchSizeTextField.setVisible(true);
//            minibatchSizeLabel.setVisible(true);
//        }
    }
    
    private void UiNAAL(){
        modelDirPanel.setVisible(false);
        libraryDirPanel.setVisible(true);
        libraryDirPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("NAAL Library"));
        libraryDirTextField.setText("This is your NAAL library directory.");
        loadDataPanel.setVisible(false);
        n3mlLoadDataPanel1.setVisible(false);
        neuronModelPanel.setVisible(false);
        fpgaNeuronModelPanel.setVisible(false);
        n3mlModelOptionPanel.setVisible(false);
        n3mlAlogorithmOptionPanel.setVisible(false);
        n3mlPopulationPanel.setVisible(false);
        n3mlConnectionPanel.setVisible(false);
        trainingPanel.setVisible(false);
        fpgaTrainingPanel.setVisible(false);
        NAALHardwarePanel.setVisible(true);
        naalNeuronModelPanel.setVisible(true);
        logPanel.setVisible(true);
        runtimeTestRadioButton.setSelected(true);
        runtimeTrainingRadioButton.setEnabled(false);
        //cnnCheckBox.setVisible(false);
        cnnPanel.setVisible(false);
        nengoDLModelPanel.setVisible(false);
    }
    
    private void UiN3ML(){
                    //runtimeTrainingRadioButton.setEnabled(false);  
        //runtimeTestRadioButton.setSelected(true);   
        modelDirPanel.setVisible(false);
        libraryDirPanel.setVisible(false);
//            libraryDirPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("N3ML Library"));
//            libraryDirTextField.setText("This is your N3ML library directory.");
        loadDataPanel.setVisible(false);
        n3mlLoadDataPanel1.setVisible(true);
        neuronModelPanel.setVisible(false);
        fpgaNeuronModelPanel.setVisible(false);
        n3mlModelOptionPanel.setVisible(true);
        n3mlAlogorithmOptionPanel.setVisible(true);
        n3mlPopulationPanel.setVisible(false);           //2021.06.09 true-->false
        n3mlConnectionPanel.setVisible(false);           //2021.06.09 true-->false
        trainingPanel.setVisible(false);
        fpgaTrainingPanel.setVisible(false);
        NAALHardwarePanel.setVisible(false);
        naalNeuronModelPanel.setVisible(false);
        runtimeTrainingRadioButton.setEnabled(true);
        logPanel.setVisible(true);
        //cnnCheckBox.setVisible(false);
        cnnPanel.setVisible(false);
        nengoDLModelPanel.setVisible(false);
    }
    
    private void UiDe1SoC(){
        modelDirPanel.setVisible(false);
        libraryDirPanel.setVisible(true);
        libraryDirPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Nengo FPGA Library"));
        libraryDirTextField.setText("This is your Nengo FPGA library directory.");
        loadDataPanel.setVisible(true);
        n3mlLoadDataPanel1.setVisible(false);
        neuronModelPanel.setVisible(false);
        fpgaNeuronModelPanel.setVisible(true);
        n3mlModelOptionPanel.setVisible(false);
        n3mlAlogorithmOptionPanel.setVisible(false);
        n3mlPopulationPanel.setVisible(false);
        n3mlConnectionPanel.setVisible(false);
        trainingPanel.setVisible(false);
        fpgaTrainingPanel.setVisible(true);
        NAALHardwarePanel.setVisible(false);
        naalNeuronModelPanel.setVisible(false);
        runtimeTrainingRadioButton.setEnabled(false);
        logPanel.setVisible(true);
        //cnnCheckBox.setVisible(false);
        cnnPanel.setVisible(false);
        nengoDLModelPanel.setVisible(false);
    }
    
    private void UiONNX(){
        //이부분은 아직 구현전이므로 수정해야함 !!
        modelDirPanel.setVisible(true);
        libraryDirPanel.setVisible(false);
        loadDataPanel.setVisible(true);
        n3mlLoadDataPanel1.setVisible(false);
        neuronModelPanel.setVisible(true);
        fpgaNeuronModelPanel.setVisible(false);
        n3mlModelOptionPanel.setVisible(false);
        n3mlAlogorithmOptionPanel.setVisible(false);
        n3mlPopulationPanel.setVisible(false);
        n3mlConnectionPanel.setVisible(false);
        trainingPanel.setVisible(true);
        fpgaTrainingPanel.setVisible(false);
        NAALHardwarePanel.setVisible(false);
        naalNeuronModelPanel.setVisible(false);
        logPanel.setVisible(false);
        //cnnCheckBox.setVisible(false);
        cnnPanel.setVisible(false);
        nengoDLModelPanel.setVisible(false);
    }
}
