package org.iesw.inha.main.dialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.xml.ws.Action;
import org.iesw.inha.generator.ai.HANNGenerator;
import org.iesw.inha.generator.ai.HSNNGenerator;
import org.iesw.inha.generator.file.HManifestGenerator;
import org.iesw.inha.generator.file.HFunctionGenerator;
import org.iesw.inha.generator.file.HUIGenerator;
import org.iesw.inha.ioconfig.HComponentConfig;
import org.iesw.inha.ioconfig.ai.HANNIOConfig;
import org.iesw.inha.ioconfig.ai.HN3MLIOConfig;
import org.iesw.inha.ioconfig.ai.HSNNIOConfig;
import static org.iesw.inha.main.dialog.SpikingNeuralNetworkDialog.LOADDATA;
import static org.iesw.inha.main.dialog.SpikingNeuralNetworkDialog.delim;
import static org.iesw.inha.main.dialog.SpikingNeuralNetworkDialog.destDir;
import static org.iesw.inha.main.dialog.SpikingNeuralNetworkDialog.srcFile;

public class InputNumberLayerDialog extends javax.swing.JDialog {
    
    public static final int H_SNN = 1;
    public static final int H_ANN = 2;  
    
    public static final int H_DATA_SET_TRAINING = 0;   
    public static final int H_DATA_SET_TEST = 1; 
    
    public static final int H_N3ML_A_softLIF = 0;
    public static final int H_N3ML_A_SpikeProp = 1;
    public static final int H_N3ML_A_STDP = 2;
    public static final int H_N3ML_A_BP_STDP = 3;
    public static final int H_N3ML_A_STBP = 4;
    public static final int H_N3ML_A_SpikeNorm = 5;
    
    public static final int H_N3ML = 4;
    
    private static final int NOT_SNN = -1; //snn이 아님을 구분하는 상수

    private HSNNGenerator hSGen = new HSNNGenerator();
    private HSNNIOConfig hSIOConf = new HSNNIOConfig();
    
    private HANNGenerator hAGen = new HANNGenerator();
    private HANNIOConfig hAIOConf = new HANNIOConfig();
    
    private HManifestGenerator hMfGen;// = new HManifestGenerator();
    private HFunctionGenerator hFGen;
    private HUIGenerator hUGen;
        
    private int inputNum;
    private boolean selectedCNN;
    private String hDirectory;
    private int hDataSetOpt; //training or infer
    private int state = 0;
    private int n3mlAlgo = -1;
    
    private int H_DL_Model = -1;
    
    public static final int HNUM_PRJ = 1; //프로젝트 생성시
    public static final int HNUM_DL = 3; //nengoDL 소스코드생성시
    
    private static final int Linear = 1;
    private static final int Logistic = 2;
    private static final int MNIST = 3;   
    
    private String titleDialog = "";
    
    public InputNumberLayerDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public InputNumberLayerDialog(java.awt.Frame parent, boolean modal, HSNNGenerator hSGen, HSNNIOConfig hSIOConf, boolean selectedCNN) {
        super(parent, modal);
        initComponents();        
        this.hSGen = hSGen;
        this.hSIOConf = hSIOConf;
        this.selectedCNN = selectedCNN;
        state = H_SNN;
    }
    //SNN을 통해왔을때
    public InputNumberLayerDialog(java.awt.Frame parent, boolean modal, HSNNGenerator hSGen, HSNNIOConfig hSIOConf, boolean selectedCNN, String hDirectory, int type, int dataSetOpt) {
        super(parent, modal);
              
        this.hSGen = hSGen;
        this.hSIOConf = hSIOConf;
        this.selectedCNN = selectedCNN;
        this.hDirectory = hDirectory;
        H_DL_Model = type;
        hDataSetOpt = dataSetOpt;
        state = H_SNN;
        titleDialog = "Spiking Neural Network";
        initComponents();  
    }
    //ANN을 통해 왔을때
    public InputNumberLayerDialog(java.awt.Frame parent, boolean modal, HANNGenerator hAGen, HANNIOConfig hAIOConf, boolean selectedCNN, String hDirectory, int type, int dataSetOpt) {
        super(parent, modal);
               
        this.hAGen = hAGen;
        this.hAIOConf = hAIOConf;
        this.selectedCNN = selectedCNN;
        this.hDirectory = hDirectory;
        H_DL_Model = type;
        hDataSetOpt = dataSetOpt;
        state = H_ANN;
        titleDialog = "Artificial Neural Network";
        initComponents(); 
    }
    //N3ML을 통해왔을때//H_N3ML, hDirectory, type
    public InputNumberLayerDialog(java.awt.Frame parent, boolean modal, HN3MLIOConfig hN3mlIOConf, int n3ml, String hDirectory, int type) {
        super(parent, modal);
              
        this.hDirectory = hDirectory;

        state = n3ml;
        n3mlAlgo = type;
        
        titleDialog = "Spiking Neural Network";
        initComponents();  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inputNumberLayerLabel = new javax.swing.JLabel();
        inputNumberLayerTextField = new javax.swing.JTextField();
        cancelNumberLayerButton = new javax.swing.JButton();
        nextNumberLayerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(titleDialog);
        setMinimumSize(new java.awt.Dimension(260, 168));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(InputNumberLayerDialog.class, "InputNumberLayerDialog.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(inputNumberLayerLabel, org.openide.util.NbBundle.getMessage(InputNumberLayerDialog.class, "InputNumberLayerDialog.inputNumberLayerLabel.text")); // NOI18N

        if(selectedCNN && state == H_ANN){
            inputNumberLayerTextField.setText(org.openide.util.NbBundle.getMessage(InputNumberLayerDialog.class, "InputNumberLayerDialog.inputNumberLayerTextField.text")); // NOI18N
        }
        else if(selectedCNN && state==H_SNN){ //H_DL_Model == MNIST){
            inputNumberLayerTextField.setText("5");
        }
        else if(state == H_N3ML){
            inputNumberLayerTextField.setText("5");
        }
        else{
            inputNumberLayerTextField.setText("0");
            inputNumberLayerTextField.setEnabled(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(inputNumberLayerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(inputNumberLayerTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(inputNumberLayerLabel)
                    .addComponent(inputNumberLayerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {inputNumberLayerLabel, inputNumberLayerTextField});

        org.openide.awt.Mnemonics.setLocalizedText(cancelNumberLayerButton, org.openide.util.NbBundle.getMessage(InputNumberLayerDialog.class, "InputNumberLayerDialog.cancelNumberLayerButton.text")); // NOI18N
        cancelNumberLayerButton.setMaximumSize(new java.awt.Dimension(100, 23));
        cancelNumberLayerButton.setMinimumSize(new java.awt.Dimension(100, 23));
        cancelNumberLayerButton.setPreferredSize(new java.awt.Dimension(100, 23));
        cancelNumberLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelNumberLayerButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(nextNumberLayerButton, org.openide.util.NbBundle.getMessage(InputNumberLayerDialog.class, "InputNumberLayerDialog.nextNumberLayerButton.text")); // NOI18N
        nextNumberLayerButton.setMaximumSize(new java.awt.Dimension(100, 23));
        nextNumberLayerButton.setMinimumSize(new java.awt.Dimension(100, 23));
        nextNumberLayerButton.setPreferredSize(new java.awt.Dimension(100, 23));
        nextNumberLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextNumberLayerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(nextNumberLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(cancelNumberLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cancelNumberLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextNumberLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelNumberLayerButton, nextNumberLayerButton});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextNumberLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextNumberLayerButtonActionPerformed
        if(state == H_SNN){
            inputNum = Integer.parseInt(inputNumberLayerTextField.getText());
            this.hSGen.setNumLayer(inputNum);
            if(inputNum!=0 && selectedCNN){
                showAddLayerConfigDialog(inputNum, state);
            }else if(inputNum == 0){
                if(LOADDATA == true){ 
                    copyFile();

                }
                initGenerator();
     
                hSGen.writeSNNGenDL(H_DL_Model, hDirectory, hDataSetOpt);
                hMfGen = new HManifestGenerator(state, HNUM_DL, hDirectory, H_DL_Model, hDataSetOpt);
                hFGen = new HFunctionGenerator(state, HNUM_DL, hDirectory, H_DL_Model, hSIOConf, hDataSetOpt); 
                hUGen = new HUIGenerator(state, HNUM_DL, hDirectory, H_DL_Model, hSIOConf, hDataSetOpt); 
                cancel();
            }    
        }
        else if(state == H_N3ML){
            inputNum = Integer.parseInt(inputNumberLayerTextField.getText());
        }
        else{
            inputNum = Integer.parseInt(inputNumberLayerTextField.getText());
            this.hAGen.setNumLayer(inputNum);
            if(inputNum!=0 && selectedCNN){
                showAddLayerConfigDialog(inputNum, state);
            }else if(inputNum == 0){
                if(LOADDATA == true){ 
                    copyFile();
                }
                initGenerator();         
                hAGen.writeANNGen(H_DL_Model, hDataSetOpt);
                hMfGen = new HManifestGenerator(state, HNUM_DL, hDirectory, H_DL_Model, hDataSetOpt);
                hFGen = new HFunctionGenerator(state, HNUM_DL, hDirectory, H_DL_Model, hSIOConf, hDataSetOpt); 
                hUGen = new HUIGenerator(state, HNUM_DL, hDirectory, H_DL_Model, hSIOConf, hDataSetOpt); 
                cancel();
            }
        }

    }//GEN-LAST:event_nextNumberLayerButtonActionPerformed

    private void cancelNumberLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelNumberLayerButtonActionPerformed
        cancel();
    }//GEN-LAST:event_cancelNumberLayerButtonActionPerformed

    public void initGenerator(){
        if(state == H_SNN){
            hSGen.hSTATE = H_SNN;
            hSGen.dataSetOpt = hDataSetOpt;
            hSGen.createFile(hSGen.modelDir, true, H_DL_Model, hDataSetOpt);
        }
        else{
            hAGen.hSTATE = H_ANN;
            hAGen.dataSetOpt = hDataSetOpt;
            hAGen.createFile(hAGen.modelDir, false, NOT_SNN, hDataSetOpt);
        }
    }
    
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
            java.util.logging.Logger.getLogger(InputNumberLayerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputNumberLayerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputNumberLayerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputNumberLayerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InputNumberLayerDialog dialog = new InputNumberLayerDialog(new javax.swing.JFrame(), true);
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
    
    private void showAddLayerConfigDialog(int inputNum, int state){
        if(state == H_SNN){
            AddLayerConfigDialog dialog = new AddLayerConfigDialog(null, true, inputNum, hSGen, hSIOConf,hDirectory, H_DL_Model, hDataSetOpt);
            dialog.setLocationRelativeTo(null);
            cancel();
            dialog.setVisible(true);
        }
        else{
            AddLayerConfigDialog dialog = new AddLayerConfigDialog(null, true, inputNum, hAGen, hAIOConf,hDirectory, H_DL_Model, hDataSetOpt);
            dialog.setLocationRelativeTo(null);
            cancel();
            dialog.setVisible(true);
        }
    }
    private void showN3MLSoftLIFLayerConfigDialog(){
        N3MLSoftLIFLayerConfigDialog dialog = new N3MLSoftLIFLayerConfigDialog(null, true, inputNum,  hSGen,  hSIOConf, hDirectory);
        dialog.setLocationRelativeTo(null);
        cancel();
        dialog.setVisible(true);
    }
    
    public void copyFile(){

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelNumberLayerButton;
    private javax.swing.JLabel inputNumberLayerLabel;
    private javax.swing.JTextField inputNumberLayerTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nextNumberLayerButton;
    // End of variables declaration//GEN-END:variables
}

