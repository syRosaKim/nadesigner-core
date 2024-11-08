/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.inha.main.dialog;

import java.io.File;
import javax.xml.ws.Action;
import org.iesw.inha.generator.ai.HSNNGenerator;
import org.iesw.inha.generator.ai.HSNNN3MLGenerator;
import org.iesw.inha.ioconfig.ai.HN3MLIOConfig;
import org.iesw.inha.ioconfig.ai.HSNNIOConfig;
import org.iesw.inha.ai.snn.n3ml.HN3MLSoftLIFIOConfig;
import static org.iesw.inha.main.dialog.N3MLAlgorithmDialog.H_SNN;

/**
 *
 * @author SeoyeonKim
 */
public class N3MLSoftLIFLayerConfigDialog extends javax.swing.JDialog {

    private int maxNumLayer = 0;
    private HSNNGenerator hSGen;
    private HSNNIOConfig hSIOConf;
    private HN3MLSoftLIFIOConfig hNSoftConf;
    private HN3MLIOConfig hN3mlIOConf;
    private HSNNN3MLGenerator hN3mlGen;
    
    private String hDirectory;
    private boolean saveLayer[];
    private boolean flag;
    
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
    
    
    private int h_state = 0; //ANN? or SNN?
    
    /**
     * Creates new form N3MLSoftLIFLayerConfigDialog
     */
    public N3MLSoftLIFLayerConfigDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public N3MLSoftLIFLayerConfigDialog(java.awt.Frame parent, boolean modal, int numLayer, HSNNGenerator hSGen, HSNNIOConfig hSIOConf, String dir) {
        super(parent, modal);
        maxNumLayer = numLayer;
        this.hSGen = hSGen;
        this.hSIOConf = hSIOConf;
        hDirectory = dir;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        //layerField[] = new javax.swing.JTextField[insertNumLayer];
        //layerLabel[] = new javax.swing.JLabel[insertNumLayer];
        //javax.swing.JLabel "layerLabel"+insertNumber = new javax.swing.JLabel();
        SNNPanel = new javax.swing.JPanel();
        layerLabel1 = new javax.swing.JLabel();
        layerComboBox = new javax.swing.JComboBox();
        inChannelLabel1 = new javax.swing.JLabel();
        filterTextField = new javax.swing.JTextField();
        kernelSizeLabel1 = new javax.swing.JLabel();
        kernelSizeTextField = new javax.swing.JTextField();
        paddingLabel1 = new javax.swing.JLabel();
        strideLabel1 = new javax.swing.JLabel();
        strideTextField = new javax.swing.JTextField();
        logLabel1 = new java.awt.Label();
        optionLabel1 = new javax.swing.JLabel();
        convRadioButton = new javax.swing.JRadioButton();
        fullyRadioButton = new javax.swing.JRadioButton();
        outChannelLabel1 = new javax.swing.JLabel();
        filterTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        flattenCheckBox = new javax.swing.JCheckBox();
        dropoutCheckBox = new javax.swing.JCheckBox();
        paddingTextField = new javax.swing.JTextField();
        biasLabel1 = new javax.swing.JLabel();
        biasComboBox = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        softLIFCheckBox = new javax.swing.JCheckBox();
        addPoolCheckBox = new javax.swing.JCheckBox();
        poolSizeTextField = new javax.swing.JTextField();
        poolSizeLabel1 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        SNNPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.SNNPanel.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(layerLabel1, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.layerLabel1.text")); // NOI18N

        String[] layerArrANN= new String[maxNumLayer];
        for(int i=0; i<maxNumLayer; i++){
            layerArrANN[i] = "Layer "+(i+1);
        }
        javax.swing.DefaultComboBoxModel layerDataANN = new javax.swing.DefaultComboBoxModel(layerArrANN);
        layerComboBox.setModel(layerDataANN);
        //for(int i=1; i<10; i++){
            //    if(!layerArr[i].equals(""))
            //        layerComboBox.add(layerArr[i]);
            //}
        layerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layerComboBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(inChannelLabel1, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.inChannelLabel1.text")); // NOI18N

        filterTextField.setText(org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.filterTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(kernelSizeLabel1, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.kernelSizeLabel1.text")); // NOI18N

        kernelSizeTextField.setText(org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.kernelSizeTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(paddingLabel1, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.paddingLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(strideLabel1, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.strideLabel1.text")); // NOI18N

        strideTextField.setText(org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.strideTextField.text")); // NOI18N

        logLabel1.setFont(new java.awt.Font("굴림", 0, 12)); // NOI18N
        logLabel1.setForeground(new java.awt.Color(255, 0, 0));
        logLabel1.setMinimumSize(new java.awt.Dimension(229, 19));
        logLabel1.setText(org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.logLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(optionLabel1, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.optionLabel1.text")); // NOI18N

        convRadioButton.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(convRadioButton, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.convRadioButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(fullyRadioButton, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.fullyRadioButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(outChannelLabel1, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.outChannelLabel1.text")); // NOI18N

        filterTextField2.setText(org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.filterTextField2.text")); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.jPanel2.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(flattenCheckBox, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.flattenCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(dropoutCheckBox, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.dropoutCheckBox.text")); // NOI18N
        dropoutCheckBox.setActionCommand(org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.dropoutCheckBox.actionCommand")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(flattenCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dropoutCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flattenCheckBox)
                    .addComponent(dropoutCheckBox))
                .addContainerGap())
        );

        paddingTextField.setText(org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.paddingTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(biasLabel1, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.biasLabel1.text")); // NOI18N

        biasComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FALSE", "TRUE" }));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.jPanel3.border.title"))); // NOI18N

        softLIFCheckBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(softLIFCheckBox, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.softLIFCheckBox.text")); // NOI18N

        addPoolCheckBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(addPoolCheckBox, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.addPoolCheckBox.text")); // NOI18N

        poolSizeTextField.setText(org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.poolSizeTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(poolSizeLabel1, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.poolSizeLabel1.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(softLIFCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addPoolCheckBox)
                .addGap(18, 18, 18)
                .addComponent(poolSizeLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(poolSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(softLIFCheckBox)
                    .addComponent(addPoolCheckBox)
                    .addComponent(poolSizeLabel1)
                    .addComponent(poolSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout SNNPanelLayout = new javax.swing.GroupLayout(SNNPanel);
        SNNPanel.setLayout(SNNPanelLayout);
        SNNPanelLayout.setHorizontalGroup(
            SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SNNPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SNNPanelLayout.createSequentialGroup()
                        .addGroup(SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(layerLabel1)
                            .addComponent(inChannelLabel1)
                            .addComponent(kernelSizeLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paddingLabel1)
                            .addComponent(strideLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addGroup(SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(layerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filterTextField)
                            .addComponent(kernelSizeTextField)
                            .addComponent(strideTextField)
                            .addComponent(paddingTextField)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(SNNPanelLayout.createSequentialGroup()
                        .addGroup(SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(SNNPanelLayout.createSequentialGroup()
                                .addComponent(optionLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(convRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fullyRadioButton))
                            .addGroup(SNNPanelLayout.createSequentialGroup()
                                .addComponent(outChannelLabel1)
                                .addGap(21, 21, 21)
                                .addComponent(filterTextField2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(SNNPanelLayout.createSequentialGroup()
                        .addComponent(biasLabel1)
                        .addGap(66, 66, 66)
                        .addComponent(biasComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        SNNPanelLayout.setVerticalGroup(
            SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SNNPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(layerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(layerLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionLabel1)
                    .addComponent(convRadioButton)
                    .addComponent(fullyRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(inChannelLabel1)
                    .addComponent(filterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(outChannelLabel1)
                    .addComponent(filterTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kernelSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kernelSizeLabel1))
                .addGap(10, 10, 10)
                .addGroup(SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(strideTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strideLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paddingLabel1)
                    .addComponent(paddingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SNNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(biasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(biasLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(logLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(saveButton, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.saveButton.text")); // NOI18N
        saveButton.setMaximumSize(new java.awt.Dimension(100, 23));
        saveButton.setMinimumSize(new java.awt.Dimension(100, 23));
        saveButton.setPreferredSize(new java.awt.Dimension(100, 23));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(generateButton, org.openide.util.NbBundle.getMessage(N3MLSoftLIFLayerConfigDialog.class, "N3MLSoftLIFLayerConfigDialog.generateButton.text")); // NOI18N
        generateButton.setMaximumSize(new java.awt.Dimension(100, 23));
        generateButton.setMinimumSize(new java.awt.Dimension(100, 23));
        generateButton.setPreferredSize(new java.awt.Dimension(100, 23));
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SNNPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SNNPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myInitComponents(){
        logLabel1.setText("");
        saveLayer = new boolean[maxNumLayer];
        layerComboBox.setSelectedIndex(0);
        
    }
    
    
    
    private void generateSNNN3MLSource(){
        hN3mlGen.hSTATE = H_SNN;
        hN3mlGen.createFile(hN3mlGen.modelDir);
        hN3mlGen.inputN3MLIO(hN3mlIOConf);
        hN3mlGen.writeN3MLGen();
    }
    private void layerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layerComboBoxActionPerformed
        javax.swing.JComboBox layerComboBox = (javax.swing.JComboBox)evt.getSource();
        Object selected = layerComboBox.getSelectedItem();
        if(selected.toString().equals("Layer 1")){
            filterTextField.setText("3");
            filterTextField2.setText("64");
            kernelSizeTextField.setText("3");
            strideTextField.setEnabled(true);
            strideTextField.setText("2");
            paddingTextField.setText("1");
            convRadioButton.setSelected(true);
            softLIFCheckBox.setSelected(true);
            addPoolCheckBox.setSelected(true);
            poolSizeTextField.setText("2");
        }
        else if(selected.toString().equals("Layer 2")){
            filterTextField.setText("64");
            filterTextField2.setText("192");
            kernelSizeTextField.setText("3");
            strideTextField.setEnabled(false);
            paddingTextField.setText("1");
            convRadioButton.setSelected(true);
            fullyRadioButton.setSelected(false);
            softLIFCheckBox.setSelected(true);
            addPoolCheckBox.setSelected(true);
            poolSizeTextField.setText("2");
        }
        else if(selected.toString().equals("Layer 3")){ //pooling
            filterTextField.setText("192");
            filterTextField2.setText("256");
            kernelSizeTextField.setText("3");
            strideTextField.setEnabled(false);
            paddingTextField.setText("1");
            convRadioButton.setSelected(true);
            fullyRadioButton.setSelected(false);
            softLIFCheckBox.setSelected(true);
            addPoolCheckBox.setSelected(true);
            poolSizeTextField.setText("2");
        }
        else if (selected.toString().equals("Layer 4")){
            convRadioButton.setSelected(false);
            fullyRadioButton.setSelected(true);
            flattenCheckBox.setSelected(true);
            dropoutCheckBox.setSelected(true);
            filterTextField.setText("256");
            filterTextField2.setText("1024");
            softLIFCheckBox.setSelected(false);
        }
        else if (selected.toString().equals("Layer 5")){ //pooling
            convRadioButton.setSelected(false);
            fullyRadioButton.setSelected(true);
            flattenCheckBox.setSelected(false);
            dropoutCheckBox.setSelected(false);
            filterTextField.setText("1024");
            filterTextField2.setText("");
            softLIFCheckBox.setSelected(true);
        }
    }//GEN-LAST:event_layerComboBoxActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        int layerN = layerComboBox.getSelectedIndex();
//        setLayerConfig(layerN);
        saveLayer[layerN] = true;
        for(int i=0; i<saveLayer.length;i++){
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        flag = true;
        int num = 1;
        for(int i=0 ; i<saveLayer.length ; i++){
            flag = flag && saveLayer[i];
            if(flag && true){
                num = i+2;
            }
        }
        if(flag && true){
            generateSource();
            cancel();
        }else{
            logLabel1.setText("Layer"+num+" has not been saved.");
        }
    }//GEN-LAST:event_generateButtonActionPerformed

    
    @Action
    public void cancel() {
        this.dispose();
    }
    
    public void initGenerator(){
        hSGen.hSTATE = H_SNN;
//        hSGen.createFile(hSGen.modelDir, true, H_DL_Model, hDataSetOpt);
//        hMfGen = new HManifestGenerator(hSGen.hSTATE, HNUM_DL, hDirectory, H_DL_Model, hDataSetOpt);
//
//            hFGen = new HFunctionGenerator(hSGen.hSTATE, HNUM_DL, hDirectory, H_DL_Model, hSIOConf, hDataSetOpt); 
//            hUGen = new HUIGenerator(hSGen.hSTATE, HNUM_DL, hDirectory, H_DL_Model, hSIOConf, hDataSetOpt); 
    }
    
    public void generateSource(){
        initGenerator();
//        hSGen.writeSNNGenDL(H_DL_Model, hDirectory, hDataSetOpt);
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(N3MLSoftLIFLayerConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(N3MLSoftLIFLayerConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(N3MLSoftLIFLayerConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(N3MLSoftLIFLayerConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                N3MLSoftLIFLayerConfigDialog dialog = new N3MLSoftLIFLayerConfigDialog(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SNNPanel;
    private javax.swing.JCheckBox addPoolCheckBox;
    private javax.swing.JComboBox biasComboBox;
    private javax.swing.JLabel biasLabel1;
    private javax.swing.JRadioButton convRadioButton;
    private javax.swing.JCheckBox dropoutCheckBox;
    private javax.swing.JTextField filterTextField;
    private javax.swing.JTextField filterTextField2;
    private javax.swing.JCheckBox flattenCheckBox;
    private javax.swing.JRadioButton fullyRadioButton;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel inChannelLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel kernelSizeLabel1;
    private javax.swing.JTextField kernelSizeTextField;
    private javax.swing.JComboBox layerComboBox;
    private javax.swing.JLabel layerLabel1;
    private java.awt.Label logLabel1;
    private javax.swing.JLabel optionLabel1;
    private javax.swing.JLabel outChannelLabel1;
    private javax.swing.JLabel paddingLabel1;
    private javax.swing.JTextField paddingTextField;
    private javax.swing.JLabel poolSizeLabel1;
    private javax.swing.JTextField poolSizeTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBox softLIFCheckBox;
    private javax.swing.JLabel strideLabel1;
    private javax.swing.JTextField strideTextField;
    // End of variables declaration//GEN-END:variables
}
