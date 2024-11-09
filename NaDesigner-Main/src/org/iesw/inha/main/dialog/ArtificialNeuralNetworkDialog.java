package org.iesw.inha.main.dialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.xml.ws.Action;
import org.iesw.inha.generator.ai.HANNGenerator;
import org.iesw.inha.ioconfig.ai.HANNIOConfig;
import static org.iesw.inha.main.dialog.SpikingNeuralNetworkDialog.ndPrjDir;
import org.openide.filesystems.FileUtil;

public class ArtificialNeuralNetworkDialog extends javax.swing.JDialog {

    public static final int H_ANN = 2;  
    
    public static final int H_DATA_SET_TRAINING = 0;
    public static final int H_DATA_SET_TEST = 1;      
    
    public static final int H_SPIKE_NORM_DEFAULT = 0;
    public static final int H_SPIKE_NORM_VGG16 = 1;
    
    private JFileChooser fileChooser = new JFileChooser();
    private HANNIOConfig hAIOConf = new HANNIOConfig();
    private HANNGenerator hANNGen = new HANNGenerator();
    
    private int hDataSetOpt = H_DATA_SET_TRAINING;
    
    private String hDirectory="";
    
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
    
    public ArtificialNeuralNetworkDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public ArtificialNeuralNetworkDialog(java.awt.Frame parent, boolean modal, String hDir) {
        super(parent, modal);
        hDirectory = hDir;
        initComponents();
        modelDirTextField.setText(hDirectory+File.separatorChar+"DataSets");
        LOADDATA = false;        
        srcFile = new File("");
        destDir = new File("hDir");
        myInitComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datasetOptionButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        datasetOptionLabel = new javax.swing.JLabel();
        datasetTrainingRadioButton = new javax.swing.JRadioButton();
        datasetTestRadioButton = new javax.swing.JRadioButton();
        cnnPanel = new javax.swing.JPanel();
        cnnCheckBox = new javax.swing.JCheckBox();
        cnnPanel1 = new javax.swing.JPanel();
        conversionPanel = new javax.swing.JPanel();
        conversionCheckBox = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        modelNameLabel = new javax.swing.JLabel();
        modelNameTextField = new javax.swing.JTextField();
        modelDirLabel = new javax.swing.JLabel();
        modelDirTextField = new javax.swing.JTextField();
        modelDirBrowseButton = new javax.swing.JButton();
        modelTypeLabel = new javax.swing.JLabel();
        modelTypeComboBox = new javax.swing.JComboBox();
        conversionModelLabel = new javax.swing.JLabel();
        conversionModelComboBox = new javax.swing.JComboBox();
        modelParameterPanel = new javax.swing.JPanel();
        inputsLabel = new javax.swing.JLabel();
        inputsTextField = new javax.swing.JTextField();
        outputsLabel = new javax.swing.JLabel();
        outputsTextField = new javax.swing.JTextField();
        epochsLabel = new javax.swing.JLabel();
        epochsTextField = new javax.swing.JTextField();
        learningRateLabel = new javax.swing.JLabel();
        learningRateTextField = new javax.swing.JTextField();
        activationFunctionLabel = new javax.swing.JLabel();
        activationFunctionComboBox = new javax.swing.JComboBox();
        costFunctionLabel = new javax.swing.JLabel();
        costFunctionComboBox = new javax.swing.JComboBox();
        optimizerLabel = new javax.swing.JLabel();
        optimizerComboBox = new javax.swing.JComboBox();
        initializerLabel = new javax.swing.JLabel();
        initializerComboBox = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        loadDataFromFileCheckBox = new javax.swing.JCheckBox();
        modelFileLabel = new javax.swing.JLabel();
        modelFileTextField = new javax.swing.JTextField();
        DelimiterLabel = new javax.swing.JLabel();
        delimiterComboBox = new javax.swing.JComboBox();
        IncludeFirstLineCheckBox = new javax.swing.JCheckBox();
        fileDirBrowseButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        varificationLogTextArea1 = new javax.swing.JTextArea();
        nextButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        conversionParametersPanel = new javax.swing.JPanel();
        epochsLabel2 = new javax.swing.JLabel();
        epochsTextField2 = new javax.swing.JTextField();
        batchSizeLabel = new javax.swing.JLabel();
        batchSizeTextField = new javax.swing.JTextField();
        learningRateLabel2 = new javax.swing.JLabel();
        learningRateTextField2 = new javax.swing.JTextField();
        momentumLabel = new javax.swing.JLabel();
        momentumTextField = new javax.swing.JTextField();
        weightDecayLabel = new javax.swing.JLabel();
        weightDecayTextField = new javax.swing.JTextField();
        pathLabel = new javax.swing.JLabel();
        pathTextField = new javax.swing.JTextField();
        conversionEvalParameterPanel = new javax.swing.JPanel();
        batchSizeLabel2 = new javax.swing.JLabel();
        batchSizeTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.title_1")); // NOI18N
        setPreferredSize(new java.awt.Dimension(595, 730));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.jPanel1.border.title_1"))); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 750));

        org.openide.awt.Mnemonics.setLocalizedText(datasetOptionLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.datasetOptionLabel.text_1")); // NOI18N

        datasetOptionButtonGroup.add(datasetTrainingRadioButton);
        datasetTrainingRadioButton.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(datasetTrainingRadioButton, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.datasetTrainingRadioButton.text_1")); // NOI18N
        datasetTrainingRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datasetTrainingRadioButtonActionPerformed(evt);
            }
        });

        datasetOptionButtonGroup.add(datasetTestRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(datasetTestRadioButton, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.datasetTestRadioButton.text_1")); // NOI18N
        datasetTestRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datasetTestRadioButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cnnCheckBox, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.cnnCheckBox.text")); // NOI18N

        javax.swing.GroupLayout cnnPanelLayout = new javax.swing.GroupLayout(cnnPanel);
        cnnPanel.setLayout(cnnPanelLayout);
        cnnPanelLayout.setHorizontalGroup(
            cnnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cnnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cnnCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cnnPanelLayout.setVerticalGroup(
            cnnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cnnPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cnnCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout cnnPanel1Layout = new javax.swing.GroupLayout(cnnPanel1);
        cnnPanel1.setLayout(cnnPanel1Layout);
        cnnPanel1Layout.setHorizontalGroup(
            cnnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );
        cnnPanel1Layout.setVerticalGroup(
            cnnPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(conversionCheckBox, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.conversionCheckBox.text")); // NOI18N
        conversionCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conversionCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout conversionPanelLayout = new javax.swing.GroupLayout(conversionPanel);
        conversionPanel.setLayout(conversionPanelLayout);
        conversionPanelLayout.setHorizontalGroup(
            conversionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conversionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(conversionCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        conversionPanelLayout.setVerticalGroup(
            conversionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conversionPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(conversionCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(datasetOptionLabel)
                .addGap(32, 32, 32)
                .addComponent(datasetTrainingRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datasetTestRadioButton)
                .addGap(106, 106, 106)
                .addComponent(cnnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conversionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cnnPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(conversionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cnnPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cnnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(datasetOptionLabel)
                        .addComponent(datasetTrainingRadioButton)
                        .addComponent(datasetTestRadioButton)))
                .addGap(16, 16, 16))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.jPanel2.border.title_1"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(modelNameLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelNameLabel.text_1")); // NOI18N

        modelNameTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelNameTextField.text_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(modelDirLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelDirLabel.text_1")); // NOI18N

        modelDirTextField.setEditable(false);
        modelDirTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        modelDirTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelDirTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(modelDirBrowseButton, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelDirBrowseButton.text_1")); // NOI18N
        modelDirBrowseButton.setEnabled(false);
        modelDirBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelDirBrowseButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(modelTypeLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelTypeLabel.text")); // NOI18N

        modelTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Customize", "Linear Regression", "Rogistic Regression", "Multi Layer Classification" }));
        modelTypeComboBox.setSelectedIndex(1);
        modelTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelTypeComboBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(conversionModelLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.conversionModelLabel.text")); // NOI18N

        conversionModelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Spike Norm", "VGG16" }));
        conversionModelComboBox.setMinimumSize(new java.awt.Dimension(169, 21));
        conversionModelComboBox.setPreferredSize(new java.awt.Dimension(169, 21));
        conversionModelComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conversionModelComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(conversionModelLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(conversionModelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modelTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modelNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modelDirLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modelDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modelTypeComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modelNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modelDirBrowseButton)))
                .addGap(8, 8, 8))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {modelDirLabel, modelNameLabel});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelTypeLabel)
                    .addComponent(modelTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conversionModelLabel)
                    .addComponent(conversionModelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelNameLabel)
                    .addComponent(modelNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelDirLabel)
                    .addComponent(modelDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelDirBrowseButton))
                .addGap(10, 10, 10))
        );

        modelParameterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelParameterPanel.border.title_1"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(inputsLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.inputsLabel.text")); // NOI18N

        inputsTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.inputsTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(outputsLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.outputsLabel.text")); // NOI18N

        outputsTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.outputsTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(epochsLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.epochsLabel.text")); // NOI18N

        epochsTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.epochsTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(learningRateLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.learningRateLabel.text")); // NOI18N

        learningRateTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.learningRateTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(activationFunctionLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.activationFunctionLabel.text")); // NOI18N

        activationFunctionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "sigmoid", "ReLU", "tanh", "Softmax" }));
        activationFunctionComboBox.setSelectedIndex(1);

        org.openide.awt.Mnemonics.setLocalizedText(costFunctionLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.costFunctionLabel.text")); // NOI18N

        costFunctionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MSE", "Cross Entropy" }));

        org.openide.awt.Mnemonics.setLocalizedText(optimizerLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.optimizerLabel.text")); // NOI18N

        optimizerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GD", "Adam" }));

        org.openide.awt.Mnemonics.setLocalizedText(initializerLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.initializerLabel.text")); // NOI18N

        initializerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Random", "Xavier" }));

        javax.swing.GroupLayout modelParameterPanelLayout = new javax.swing.GroupLayout(modelParameterPanel);
        modelParameterPanel.setLayout(modelParameterPanelLayout);
        modelParameterPanelLayout.setHorizontalGroup(
            modelParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modelParameterPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(modelParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modelParameterPanelLayout.createSequentialGroup()
                        .addComponent(inputsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(modelParameterPanelLayout.createSequentialGroup()
                        .addComponent(optimizerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optimizerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(modelParameterPanelLayout.createSequentialGroup()
                        .addComponent(epochsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(epochsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(modelParameterPanelLayout.createSequentialGroup()
                        .addComponent(activationFunctionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activationFunctionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(modelParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modelParameterPanelLayout.createSequentialGroup()
                        .addComponent(outputsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modelParameterPanelLayout.createSequentialGroup()
                        .addComponent(learningRateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(learningRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modelParameterPanelLayout.createSequentialGroup()
                        .addComponent(costFunctionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(costFunctionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modelParameterPanelLayout.createSequentialGroup()
                        .addComponent(initializerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(initializerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        modelParameterPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {activationFunctionLabel, costFunctionLabel, epochsLabel, initializerLabel, inputsLabel, learningRateLabel, optimizerLabel, outputsLabel});

        modelParameterPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {activationFunctionComboBox, costFunctionComboBox, epochsTextField, initializerComboBox, inputsTextField, learningRateTextField, optimizerComboBox, outputsTextField});

        modelParameterPanelLayout.setVerticalGroup(
            modelParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modelParameterPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(modelParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputsLabel)
                    .addComponent(inputsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputsLabel)
                    .addComponent(outputsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modelParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(epochsLabel)
                    .addComponent(epochsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(learningRateLabel)
                    .addComponent(learningRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modelParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activationFunctionLabel)
                    .addComponent(activationFunctionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costFunctionLabel)
                    .addComponent(costFunctionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modelParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optimizerLabel)
                    .addComponent(optimizerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(initializerLabel)
                    .addComponent(initializerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        modelParameterPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {activationFunctionLabel, costFunctionLabel, epochsLabel, initializerLabel, inputsLabel, learningRateLabel, optimizerLabel, outputsLabel});

        modelParameterPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {activationFunctionComboBox, costFunctionComboBox, epochsTextField, initializerComboBox, inputsTextField, learningRateTextField, optimizerComboBox, outputsTextField});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.jPanel3.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(loadDataFromFileCheckBox, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.loadDataFromFileCheckBox.text")); // NOI18N
        loadDataFromFileCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                loadDataFromFileCheckBoxItemStateChanged(evt);
            }
        });
        loadDataFromFileCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDataFromFileCheckBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(modelFileLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelFileLabel.text")); // NOI18N

        modelFileTextField.setEditable(false);
        modelFileTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.modelFileTextField.text")); // NOI18N
        modelFileTextField.setPreferredSize(new java.awt.Dimension(152, 21));
        modelFileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelFileTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(DelimiterLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.DelimiterLabel.text")); // NOI18N
        DelimiterLabel.setEnabled(false);

        delimiterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ",", ";", "space", "tab" }));
        delimiterComboBox.setEnabled(false);
        delimiterComboBox.setMinimumSize(new java.awt.Dimension(83, 23));
        delimiterComboBox.setPreferredSize(new java.awt.Dimension(83, 23));
        delimiterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delimiterComboBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(IncludeFirstLineCheckBox, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.IncludeFirstLineCheckBox.text")); // NOI18N
        IncludeFirstLineCheckBox.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(fileDirBrowseButton, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.fileDirBrowseButton.text")); // NOI18N
        fileDirBrowseButton.setActionCommand(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.fileDirBrowseButton.actionCommand")); // NOI18N
        fileDirBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileDirBrowseButtonmodelFileBrowseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IncludeFirstLineCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(loadDataFromFileCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DelimiterLabel))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(modelFileLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modelFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delimiterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileDirBrowseButton))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {delimiterComboBox, fileDirBrowseButton});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadDataFromFileCheckBox)
                    .addComponent(DelimiterLabel)
                    .addComponent(delimiterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileDirBrowseButton)
                    .addComponent(modelFileLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(IncludeFirstLineCheckBox)
                .addGap(10, 10, 10))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.jPanel5.border.title"))); // NOI18N

        jScrollPane2.setEnabled(false);
        jScrollPane2.setWheelScrollingEnabled(false);

        varificationLogTextArea1.setEditable(false);
        varificationLogTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        varificationLogTextArea1.setColumns(20);
        varificationLogTextArea1.setRows(3);
        varificationLogTextArea1.setAutoscrolls(false);
        varificationLogTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        varificationLogTextArea1.setPreferredSize(new java.awt.Dimension(144, 34));
        jScrollPane2.setViewportView(varificationLogTextArea1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(nextButton, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.nextButton.text")); // NOI18N
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(closeButton, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.closeButton.text")); // NOI18N
        closeButton.setLabel(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.closeButton.label")); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        conversionParametersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.conversionParametersPanel.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(epochsLabel2, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.epochsLabel2.text")); // NOI18N

        epochsTextField2.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.epochsTextField2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(batchSizeLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.batchSizeLabel.text")); // NOI18N

        batchSizeTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.batchSizeTextField.text")); // NOI18N
        batchSizeTextField.setPreferredSize(new java.awt.Dimension(120, 21));

        org.openide.awt.Mnemonics.setLocalizedText(learningRateLabel2, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.learningRateLabel2.text")); // NOI18N

        learningRateTextField2.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.learningRateTextField2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(momentumLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.momentumLabel.text")); // NOI18N

        momentumTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.momentumTextField.text")); // NOI18N
        momentumTextField.setPreferredSize(new java.awt.Dimension(120, 21));

        org.openide.awt.Mnemonics.setLocalizedText(weightDecayLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.weightDecayLabel.text")); // NOI18N

        weightDecayTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.weightDecayTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(pathLabel, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.pathLabel.text")); // NOI18N

        pathTextField.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.pathTextField.text")); // NOI18N
        pathTextField.setToolTipText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.pathTextField.toolTipText")); // NOI18N

        javax.swing.GroupLayout conversionParametersPanelLayout = new javax.swing.GroupLayout(conversionParametersPanel);
        conversionParametersPanel.setLayout(conversionParametersPanelLayout);
        conversionParametersPanelLayout.setHorizontalGroup(
            conversionParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conversionParametersPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(conversionParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(epochsLabel2)
                    .addComponent(learningRateLabel2)
                    .addComponent(weightDecayLabel))
                .addGap(28, 28, 28)
                .addGroup(conversionParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(epochsTextField2)
                    .addComponent(learningRateTextField2)
                    .addComponent(weightDecayTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(conversionParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(batchSizeLabel)
                    .addComponent(momentumLabel)
                    .addComponent(pathLabel))
                .addGap(46, 46, 46)
                .addGroup(conversionParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(batchSizeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(momentumTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pathTextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        conversionParametersPanelLayout.setVerticalGroup(
            conversionParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conversionParametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(conversionParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(epochsLabel2)
                    .addComponent(epochsTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batchSizeLabel)
                    .addComponent(batchSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(conversionParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(learningRateLabel2)
                    .addComponent(learningRateTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(momentumLabel)
                    .addComponent(momentumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(conversionParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weightDecayLabel)
                    .addComponent(weightDecayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pathLabel)
                    .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        conversionEvalParameterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.conversionEvalParameterPanel.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(batchSizeLabel2, org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.batchSizeLabel2.text")); // NOI18N

        batchSizeTextField2.setText(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.batchSizeTextField2.text")); // NOI18N

        javax.swing.GroupLayout conversionEvalParameterPanelLayout = new javax.swing.GroupLayout(conversionEvalParameterPanel);
        conversionEvalParameterPanel.setLayout(conversionEvalParameterPanelLayout);
        conversionEvalParameterPanelLayout.setHorizontalGroup(
            conversionEvalParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conversionEvalParameterPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(batchSizeLabel2)
                .addGap(43, 43, 43)
                .addComponent(batchSizeTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        conversionEvalParameterPanelLayout.setVerticalGroup(
            conversionEvalParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conversionEvalParameterPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(conversionEvalParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batchSizeLabel2)
                    .addComponent(batchSizeTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(nextButton)
                        .addGap(83, 83, 83)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(conversionEvalParameterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(conversionParametersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(modelParameterPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {closeButton, nextButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(modelParameterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conversionParametersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conversionEvalParameterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(nextButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {closeButton, nextButton});

        jPanel1.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.jPanel1.AccessibleContext.accessibleName_1")); // NOI18N

        getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ArtificialNeuralNetworkDialog.class, "ArtificialNeuralNetworkDialog.AccessibleContext.accessibleName")); // NOI18N

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
        

        conversionParametersPanel.setVisible(false);
        conversionModelLabel.setVisible(false);
        conversionModelComboBox.setVisible(false);
        conversionEvalParameterPanel.setVisible(false);

    }
    private void datasetTrainingRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datasetTrainingRadioButtonActionPerformed
        datasetTrainingRadioButton.setActionCommand("Training");
        hDataSetOpt = H_DATA_SET_TRAINING;
        if(conversionCheckBox.isSelected()){
            if(conversionModelComboBox.getSelectedIndex()==H_SPIKE_NORM_DEFAULT){
                cnnCheckBox.setSelected(true);
                UiConvSpikeNormTrain();
            }
            else{
                cnnCheckBox.setSelected(false);
                UiConvSpikeNormVGG16Train();
            }
        }
        else{
            if(modelTypeComboBox.getSelectedIndex()==1)
                UiLinearRegression();
            else if(modelTypeComboBox.getSelectedIndex()==2)
                UiLogisticRegression();
            else
                UiMultiLayerClassification();
        }
    }//GEN-LAST:event_datasetTrainingRadioButtonActionPerformed

    private void datasetTestRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datasetTestRadioButtonActionPerformed
        datasetTestRadioButton.setActionCommand("Test");
        cnnCheckBox.setSelected(false);
        hDataSetOpt = H_DATA_SET_TEST;
        if(modelTypeComboBox.getSelectedIndex()==0)
            UiConvSpikeNormEval();
        else if(modelTypeComboBox.getSelectedIndex()==1)
            UiLinearRegression();
        else if(modelTypeComboBox.getSelectedIndex()==2)
            UiLogisticRegression();
        else
            UiMultiLayerClassification();
       
    }//GEN-LAST:event_datasetTestRadioButtonActionPerformed

    private void modelDirBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelDirBrowseButtonActionPerformed
        evt.setSource(modelDirBrowseButton);
        selectDirectory();
    }//GEN-LAST:event_modelDirBrowseButtonActionPerformed

    private void modelDirTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelDirTextFieldActionPerformed
        
    }//GEN-LAST:event_modelDirTextFieldActionPerformed

    private void fileDirBrowseButtonmodelFileBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileDirBrowseButtonmodelFileBrowseButtonActionPerformed

        if(loadDataFromFileCheckBox.isSelected())
            selectFile();        
        else{
            evt.setSource(fileDirBrowseButton);
            selectDirectory();
        }
    }//GEN-LAST:event_fileDirBrowseButtonmodelFileBrowseButtonActionPerformed

    private void delimiterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delimiterComboBoxActionPerformed
       
    }//GEN-LAST:event_delimiterComboBoxActionPerformed

    private void modelFileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelFileTextFieldActionPerformed
     
    }//GEN-LAST:event_modelFileTextFieldActionPerformed

    private void loadDataFromFileCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDataFromFileCheckBoxActionPerformed
       
    }//GEN-LAST:event_loadDataFromFileCheckBoxActionPerformed

    private void loadDataFromFileCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_loadDataFromFileCheckBoxItemStateChanged
        if (loadDataFromFileCheckBox.isSelected()) {

            delimiterComboBox.setEnabled(true);
            fileDirBrowseButton.setEnabled(true);
        } else {

            delimiterComboBox.setEnabled(false);
            fileDirBrowseButton.setEnabled(false);
        }
    }//GEN-LAST:event_loadDataFromFileCheckBoxItemStateChanged

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        initIOConf();
        createRuntimeFile();
        
        if (loadDataFromFileCheckBox.isSelected() && !modelFileTextField.getText().equals("")) { //데이타가 폴더로 있는경우
            loadDir = modelFileTextField.getText();
            loadData(loadDir);
        } else if (!loadDataFromFileCheckBox.isSelected() && !modelFileTextField.getText().equals("")) { //데이터가 단일 파일인경우
            loadLib();
            copyLib(libDir, destLib);
        }
        showInputNumberLayerDialog(hAIOConf, cnnCheckBox.isSelected(), modelTypeComboBox.getSelectedIndex());
    }//GEN-LAST:event_nextButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void conversionCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conversionCheckBoxActionPerformed
        
        if(conversionCheckBox.isSelected()){ //conversion 모델일경우
            modelTypeComboBox.setSelectedIndex(0);
            UiConvSpikeNormTrain();
            if(hDataSetOpt == H_DATA_SET_TEST){
                if(conversionModelComboBox.getSelectedIndex()==H_SPIKE_NORM_DEFAULT )
                    UiConvSpikeNormEval();
                else
                    UiConvSpikeNormVGG16Eval();
            }
            else{
                if(conversionModelComboBox.getSelectedIndex()==H_SPIKE_NORM_DEFAULT )
                    UiConvSpikeNormTrain();
                else
                    UiConvSpikeNormVGG16Train();
            }
        }
        else{
            modelTypeComboBox.setSelectedIndex(1);
            UiLinearRegression();
        }
    }//GEN-LAST:event_conversionCheckBoxActionPerformed

    private void modelTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelTypeComboBoxActionPerformed
        // TODO add your handling code here:
        if(modelTypeComboBox.getSelectedIndex()==0){
            conversionCheckBox.setSelected(true);
            cnnCheckBox.setSelected(true);
            if(hDataSetOpt == H_DATA_SET_TEST){
                cnnCheckBox.setSelected(false);
                UiConvSpikeNormEval();
            }
            else
                UiConvSpikeNormTrain();
        }
        else if(modelTypeComboBox.getSelectedIndex()==1){
            UiLinearRegression();
            conversionCheckBox.setSelected(false);
        }
        else if(modelTypeComboBox.getSelectedIndex()==2){
            UiLogisticRegression();
            conversionCheckBox.setSelected(false);
        }
        else{
            UiMultiLayerClassification();
            conversionCheckBox.setSelected(false);
        }
    }//GEN-LAST:event_modelTypeComboBoxActionPerformed

    private void conversionModelComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conversionModelComboBoxActionPerformed
        if(conversionModelComboBox.getSelectedIndex()==H_SPIKE_NORM_DEFAULT){
            
            if(hDataSetOpt == H_DATA_SET_TEST){
                UiConvSpikeNormEval();
                cnnCheckBox.setSelected(true);
            }
            else{
                UiConvSpikeNormTrain();
                cnnCheckBox.setSelected(false);
            }
        }
        else{
            if(hDataSetOpt == H_DATA_SET_TEST)
                UiConvSpikeNormVGG16Eval();
            else{
                UiConvSpikeNormVGG16Train();
            }
            cnnCheckBox.setSelected(false);
        }
    }//GEN-LAST:event_conversionModelComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(ArtificialNeuralNetworkDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArtificialNeuralNetworkDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArtificialNeuralNetworkDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArtificialNeuralNetworkDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                ArtificialNeuralNetworkDialog dialog = new ArtificialNeuralNetworkDialog(new javax.swing.JFrame(), true);
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
    
    public void selectDirectory() {
        FileUtil.preventFileChooserSymlinkTraversal(fileChooser, null);
        fileChooser.setDialogTitle("Select Project Location");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String path = this.modelDirTextField.getText();
        if (path.length() > 0) {
            File f = new File(path);
            if (f.exists()) {
                fileChooser.setSelectedFile(f);
            }
        }
        if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(this)) {
            File projectDir = fileChooser.getSelectedFile();
            modelDirTextField.setText(FileUtil.normalizeFile(projectDir).getAbsolutePath());
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
            File projectDir = fileChooser.getSelectedFile();
            modelFileTextField.setText(FileUtil.normalizeFile(projectDir).getAbsolutePath());
        }
    }

    private void showInputNumberLayerDialog(HANNIOConfig hAIOConf, boolean selectedCNN, int type){
        //InputNumberLayerDialog dialog = new InputNumberLayerDialog(null, true, hANNGen, hAIOConf, selectedCNN, hDirectory, hDataSetOpt);        
        InputNumberLayerDialog dialog = new InputNumberLayerDialog(null, true, hANNGen, hAIOConf, selectedCNN, hDirectory, type, hDataSetOpt);
        dialog.setLocationRelativeTo(null);
        cancel();
        dialog.setVisible(true);
    }
    
    private void initIOConf(){
        hAIOConf.setData_opt(hDataSetOpt);
        String modelName = modelNameTextField.getText();
        String modelDir = modelDirTextField.getText();
        
        hAIOConf.setInput(inputsTextField.getText());
        hAIOConf.setOutput(outputsTextField.getText());
        hAIOConf.setEpoch(Integer.parseInt(epochsTextField.getText()));
        hAIOConf.setLoss((String)costFunctionComboBox.getSelectedItem());
        hAIOConf.setOptimizer((String)optimizerComboBox.getSelectedItem());
        hAIOConf.setInitializer((String)initializerComboBox.getSelectedItem());
        hAIOConf.setLearning_rate((String)learningRateTextField.getText());
        
        hANNGen.initConfig(hAIOConf, modelName, modelDir);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DelimiterLabel;
    private javax.swing.JCheckBox IncludeFirstLineCheckBox;
    private javax.swing.JComboBox activationFunctionComboBox;
    private javax.swing.JLabel activationFunctionLabel;
    private javax.swing.JLabel batchSizeLabel;
    private javax.swing.JLabel batchSizeLabel2;
    private javax.swing.JTextField batchSizeTextField;
    private javax.swing.JTextField batchSizeTextField2;
    private javax.swing.JButton closeButton;
    private javax.swing.JCheckBox cnnCheckBox;
    private javax.swing.JPanel cnnPanel;
    private javax.swing.JPanel cnnPanel1;
    private javax.swing.JCheckBox conversionCheckBox;
    private javax.swing.JPanel conversionEvalParameterPanel;
    private javax.swing.JComboBox conversionModelComboBox;
    private javax.swing.JLabel conversionModelLabel;
    private javax.swing.JPanel conversionPanel;
    private javax.swing.JPanel conversionParametersPanel;
    private javax.swing.JComboBox costFunctionComboBox;
    private javax.swing.JLabel costFunctionLabel;
    private javax.swing.ButtonGroup datasetOptionButtonGroup;
    private javax.swing.JLabel datasetOptionLabel;
    private javax.swing.JRadioButton datasetTestRadioButton;
    private javax.swing.JRadioButton datasetTrainingRadioButton;
    private javax.swing.JComboBox delimiterComboBox;
    private javax.swing.JLabel epochsLabel;
    private javax.swing.JLabel epochsLabel2;
    private javax.swing.JTextField epochsTextField;
    private javax.swing.JTextField epochsTextField2;
    private javax.swing.JButton fileDirBrowseButton;
    private javax.swing.JComboBox initializerComboBox;
    private javax.swing.JLabel initializerLabel;
    private javax.swing.JLabel inputsLabel;
    private javax.swing.JTextField inputsTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel learningRateLabel;
    private javax.swing.JLabel learningRateLabel2;
    private javax.swing.JTextField learningRateTextField;
    private javax.swing.JTextField learningRateTextField2;
    private javax.swing.JCheckBox loadDataFromFileCheckBox;
    private javax.swing.JButton modelDirBrowseButton;
    private javax.swing.JLabel modelDirLabel;
    private javax.swing.JTextField modelDirTextField;
    private javax.swing.JLabel modelFileLabel;
    private javax.swing.JTextField modelFileTextField;
    private javax.swing.JLabel modelNameLabel;
    private javax.swing.JTextField modelNameTextField;
    private javax.swing.JPanel modelParameterPanel;
    private javax.swing.JComboBox modelTypeComboBox;
    private javax.swing.JLabel modelTypeLabel;
    private javax.swing.JLabel momentumLabel;
    private javax.swing.JTextField momentumTextField;
    private javax.swing.JButton nextButton;
    private javax.swing.JComboBox optimizerComboBox;
    private javax.swing.JLabel optimizerLabel;
    private javax.swing.JLabel outputsLabel;
    private javax.swing.JTextField outputsTextField;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JTextField pathTextField;
    private javax.swing.JTextArea varificationLogTextArea1;
    private javax.swing.JLabel weightDecayLabel;
    private javax.swing.JTextField weightDecayTextField;
    // End of variables declaration//GEN-END:variables

    private void loadData(String loadDir) {
        LOADDATA = true;
        srcFile = new File(loadDir);
    }

    private void loadLib() {
        LOADLIB = true;

        libDir = new File(modelFileTextField.getText());
        destLib = new File(srcDir.getAbsolutePath() + File.separatorChar + "src" + File.separatorChar + "DataSets" + File.separatorChar + libDir.getName());

        destLib.mkdirs();
    }

    public void copyLib(File libDir, File destLib) {

        File[] childrenList = libDir.listFiles();

        for (File file : childrenList) {
            File temp = new File(destLib.getAbsolutePath() + File.separatorChar + file.getName());

            FileInputStream fis = null;
            FileOutputStream fos = null;

            if (file.isDirectory()) {
                temp.mkdirs();
                copyLib(file, temp);
            } else {
                try {
                    fis = new FileInputStream(file);
                    fos = new FileOutputStream(temp);

                    byte[] b = new byte[4096];
                    int count = 0;

                    while ((count = fis.read(b)) != -1) {
                        fos.write(b, 0, count);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fis.close();
                        fos.close();
                    } catch (Exception e) {
                    }
                }
            }
        }

    }

    @Action
    public void cancel() {
        this.dispose();
    }
    private void createRuntimeFile(){ //SeoyeonKim 2021.08.25
        //ANN폴더("프로젝트명\ann")안에 모델 이름으로 파일을 생성한다.
        //1. 생성하기 전에 이미 다른 파일이 존재하는지 확인하여 전체 삭제
        //2. 현재 선택된 런타임 이름으로 파일 생성
        
        String checkPath = hDirectory + File.separatorChar + "ann";
        File path = new File(checkPath);
        File[] fileList = path.listFiles();

        
        File runtimeFile = new File(checkPath+ File.separatorChar + (String)modelTypeComboBox.getSelectedItem());
        try {
            if (runtimeFile.createNewFile()) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void UiLinearRegression(){
        
        modelParameterPanel.setVisible(true);
        //modelTypeComboBox.setSelectedIndex(1);
        conversionModelLabel.setVisible(false);
        conversionModelComboBox.setVisible(false);
        conversionParametersPanel.setVisible(false);
        conversionEvalParameterPanel.setVisible(false);
        
        modelNameTextField.setText("model_ex");
        inputsTextField.setText("1");
        outputsTextField.setText("1");
        epochsTextField.setText("200");
        learningRateTextField.setText("0.1");
        activationFunctionComboBox.setSelectedIndex(1);
        costFunctionComboBox.setSelectedIndex(0);
        optimizerComboBox.setSelectedIndex(0);
        initializerComboBox.setSelectedIndex(0);
    }
    private void UiLogisticRegression(){
        
        modelParameterPanel.setVisible(true);
        //modelTypeComboBox.setSelectedIndex(2);
        conversionModelLabel.setVisible(false);
        conversionModelComboBox.setVisible(false);
        conversionParametersPanel.setVisible(false);
        conversionEvalParameterPanel.setVisible(false);
        
        modelNameTextField.setText("model_ex");
        inputsTextField.setText("2");
        outputsTextField.setText("1");
        epochsTextField.setText("200");
        learningRateTextField.setText("0.1");
        activationFunctionComboBox.setSelectedIndex(1);
        costFunctionComboBox.setSelectedIndex(0);
        optimizerComboBox.setSelectedIndex(0);
        initializerComboBox.setSelectedIndex(0);
    }
    
    
    private void UiMultiLayerClassification(){
        
        modelParameterPanel.setVisible(true);
        //modelTypeComboBox.setSelectedIndex(3);
        conversionModelLabel.setVisible(false);
        conversionModelComboBox.setVisible(false);
        conversionParametersPanel.setVisible(false);
        conversionEvalParameterPanel.setVisible(false);
        
        modelNameTextField.setText("model_ex");
        inputsTextField.setText("28,28");
        outputsTextField.setText("1");
        epochsTextField.setText("200");
        learningRateTextField.setText("0.1");
        activationFunctionComboBox.setSelectedIndex(1);
        costFunctionComboBox.setSelectedIndex(0);
        optimizerComboBox.setSelectedIndex(0);
        initializerComboBox.setSelectedIndex(0);
    }
    
    private void UiConvSpikeNormTrain(){
        conversionParametersPanel.setVisible(true);
        conversionModelLabel.setVisible(true);
        conversionModelComboBox.setVisible(true);
        modelParameterPanel.setVisible(false);
        conversionEvalParameterPanel.setVisible(false);
        
        //modelTypeComboBox.setSelectedIndex(0);
        pathLabel.setVisible(false);
        pathTextField.setVisible(false);
        
        modelNameTextField.setText("ann.pt");
        epochsTextField2.setText("300");
        batchSizeTextField.setText("64");
        learningRateTextField2.setText("0.01");
        momentumTextField.setText("0.9");
        weightDecayTextField.setText("5e-4");
        
       
    }
    private void UiConvSpikeNormEval(){
        conversionParametersPanel.setVisible(false);
        conversionModelLabel.setVisible(true);
        conversionModelComboBox.setVisible(true);
        modelParameterPanel.setVisible(false);
        conversionEvalParameterPanel.setVisible(true);
        
        modelNameTextField.setText("ann.pt");
        //modelTypeComboBox.setSelectedIndex(0);
        pathLabel.setVisible(false);
        pathTextField.setVisible(false);
        
    }
    private void UiConvSpikeNormVGG16Train(){
        conversionParametersPanel.setVisible(true);
        conversionModelLabel.setVisible(true);
        conversionModelComboBox.setVisible(true);
        modelParameterPanel.setVisible(false);
        conversionEvalParameterPanel.setVisible(false);
        
        modelNameTextField.setText("vgg16.pt");
        //modelTypeComboBox.setSelectedIndex(0);
        pathLabel.setVisible(false);
        pathTextField.setVisible(false);
        
        epochsTextField2.setText("300");
        batchSizeTextField.setText("64");
        learningRateTextField2.setText("0.01");
        momentumTextField.setText("0.9");
        weightDecayTextField.setText("5e-4");
        
        
    }
    private void UiConvSpikeNormVGG16Eval(){
        conversionParametersPanel.setVisible(false);
        conversionModelLabel.setVisible(true);
        conversionModelComboBox.setVisible(true);
        modelParameterPanel.setVisible(false);
        conversionEvalParameterPanel.setVisible(true);
        
        modelNameTextField.setText("vgg16.pt");
        //modelTypeComboBox.setSelectedIndex(0);
        pathLabel.setVisible(false);
        pathTextField.setVisible(false);
        
    }
    

}


