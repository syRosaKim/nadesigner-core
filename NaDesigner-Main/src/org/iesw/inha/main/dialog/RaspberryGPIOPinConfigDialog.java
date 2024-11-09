package org.iesw.inha.main.dialog;

import javax.xml.ws.Action;
import org.iesw.inha.generator.iot.HIoTGenRun;
import org.iesw.inha.generator.iot.HIoTGenerator;
import org.iesw.inha.generator.iot.HIoTGeneratorArduino;
import org.iesw.inha.generator.iot.HIoTGeneratorJS;
import org.iesw.inha.ioconfig.iot.HIoTConfig;
import org.iesw.inha.ioconfig.iot.HIoTPinConfig;

public class RaspberryGPIOPinConfigDialog extends javax.swing.JDialog {
    
    public static final int H_IoT = 3;
    
    public static final int H_IoT_sevenSegment = 2; 
    public static final int H_IoT_LED = 3;  
    public static final int H_IoT_UltraSonic = 4;
    
    public static final int rspi = 1;
    public static final int nano = 2;
    public static final int coral = 3;
    public static final int tinker =4;
    public static final int panda = 5; 

    private int maxNumPins = 0; 
    private HIoTGenerator hIoTGen = new HIoTGenerator();
    private HIoTGeneratorArduino hIoTGenA = new HIoTGeneratorArduino();
    private HIoTGeneratorJS hIoTGenJ = new HIoTGeneratorJS();
    private HIoTGenRun hIoTRun = new HIoTGenRun();
    private HIoTPinConfig hILCfg;
    private boolean savePins[];
    private boolean flag; 
    private String hDirectory="";
    public int num;
    public String type_pin;
    public static int number;
    public String name;
    private int check_board = 0;
    private HIoTConfig hICfg;
    private int flagIotType =0;
    Object selected;
    public RaspberryGPIOPinConfigDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public RaspberryGPIOPinConfigDialog(java.awt.Frame parent,boolean modal,String hDir,int numPins, int board, int flagIot) {
        super(parent, modal);
        maxNumPins = numPins;
        hDirectory = hDir;
        flagIotType = flagIot;
        hIoTGen.setNumPin(maxNumPins);
        hIoTGenA.setNumPin(maxNumPins);
        check_board = board;
        initComponents();
        myInitComponents();  
    }
    private void myInitComponents(){
        savePins = new boolean[maxNumPins];
        pinComboBox.setSelectedIndex(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        GPIOPin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        GPIONameTextField = new javax.swing.JTextField();
        GPIOPinTextField = new javax.swing.JTextField();
        SelectGPIOButton = new javax.swing.JButton();
        pinComboBox = new javax.swing.JComboBox();
        typeLabel = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();
        saveButton = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(RaspberryGPIOPinConfigDialog.class, "RaspberryGPIOPinConfigDialog.title")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(RaspberryGPIOPinConfigDialog.class, "RaspberryGPIOPinConfigDialog.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(RaspberryGPIOPinConfigDialog.class, "RaspberryGPIOPinConfigDialog.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(GPIOPin, org.openide.util.NbBundle.getMessage(RaspberryGPIOPinConfigDialog.class, "RaspberryGPIOPinConfigDialog.GPIOPin.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(RaspberryGPIOPinConfigDialog.class, "RaspberryGPIOPinConfigDialog.jLabel3.text")); // NOI18N

        GPIONameTextField.setText(org.openide.util.NbBundle.getMessage(RaspberryGPIOPinConfigDialog.class, "RaspberryGPIOPinConfigDialog.GPIONameTextField.text")); // NOI18N

        GPIOPinTextField.setText(org.openide.util.NbBundle.getMessage(RaspberryGPIOPinConfigDialog.class, "RaspberryGPIOPinConfigDialog.GPIOPinTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(SelectGPIOButton, org.openide.util.NbBundle.getMessage(RaspberryGPIOPinConfigDialog.class, "RaspberryGPIOPinConfigDialog.SelectGPIOButton.text")); // NOI18N
        SelectGPIOButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectGPIOButtonActionPerformed(evt);
            }
        });

        String[] layerArr= new String[maxNumPins];
        for(int i=0; i<maxNumPins; i++){
            layerArr[i] = "Pin "+(i+1);
        }
        javax.swing.DefaultComboBoxModel layerData = new javax.swing.DefaultComboBoxModel(layerArr);
        pinComboBox.setModel(layerData);
        //for(int i=1; i<10; i++){
            //    if(!layerArr[i].equals(""))
            //        pinComboBox.add(layerArr[i]);
            //}
        pinComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinComboBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(typeLabel, org.openide.util.NbBundle.getMessage(RaspberryGPIOPinConfigDialog.class, "RaspberryGPIOPinConfigDialog.typeLabel.text")); // NOI18N

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IN", "OUT" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(GPIOPin)
                    .addComponent(typeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(GPIOPinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectGPIOButton))
                    .addComponent(GPIONameTextField)
                    .addComponent(pinComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GPIOPin)
                    .addComponent(pinComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(GPIONameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GPIOPinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SelectGPIOButton)))
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(saveButton, org.openide.util.NbBundle.getMessage(RaspberryGPIOPinConfigDialog.class, "RaspberryGPIOPinConfigDialog.saveButton.text")); // NOI18N
        saveButton.setMaximumSize(new java.awt.Dimension(100, 23));
        saveButton.setMinimumSize(new java.awt.Dimension(100, 23));
        saveButton.setPreferredSize(new java.awt.Dimension(100, 23));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(generateButton, org.openide.util.NbBundle.getMessage(RaspberryGPIOPinConfigDialog.class, "RaspberryGPIOPinConfigDialog.generateButton.text")); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pinComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinComboBoxActionPerformed
        javax.swing.JComboBox pinComboBox = (javax.swing.JComboBox)evt.getSource();
        selected = pinComboBox.getSelectedIndex();
        int selectedInt = ((Integer)selected).intValue();
        String gpioNameTemp = "GPIO"+(selectedInt+1);
        GPIONameTextField.setText(gpioNameTemp);
        if(flagIotType==H_IoT_sevenSegment){
           if(selectedInt==0)
                GPIOPinTextField.setText("29");
           else if(selectedInt==1)
                GPIOPinTextField.setText("31");
           else if(selectedInt==2)
                GPIOPinTextField.setText("33");
           else if(selectedInt==3)
                GPIOPinTextField.setText("35");
           else if(selectedInt==4)
                GPIOPinTextField.setText("37");
           else if(selectedInt==5)
                GPIOPinTextField.setText("36");
           else if(selectedInt==6)
                GPIOPinTextField.setText("38");
           else if(selectedInt==7)
                GPIOPinTextField.setText("40");
        }
    }//GEN-LAST:event_pinComboBoxActionPerformed

    private void SelectGPIOButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectGPIOButtonActionPerformed
        if(check_board == coral){
            showCoralGPIOPINDialog(hDirectory);
            GPIOPinTextField.setText(""+number);
        }
        else if(check_board == tinker){
            showTinkerGPIOPINDialog(hDirectory);
            GPIOPinTextField.setText(""+number);
        }
        else if(check_board == panda){
            showPandaGPIOPINDialog(hDirectory);
            GPIOPinTextField.setText(""+number);
        }
            else{
            showRaspberryGPIOPINDialog(hDirectory);
            GPIOPinTextField.setText(""+number);
        }
        
    }//GEN-LAST:event_SelectGPIOButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        int pinN = pinComboBox.getSelectedIndex();
        setPinConfig(pinN);
        savePins[pinN] = true;
        for(int i=0; i<savePins.length;i++){
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        flag = true;
        int num = 1;
        for(int i=0 ; i<savePins.length ; i++){
            flag = flag && savePins[i];         
            if(flag && true){
                num = i+2;
            }
        }
        if(flag && true){ 
            generateSource();
            cancel();
        }
    }//GEN-LAST:event_generateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RaspberryGPIOPinConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RaspberryGPIOPinConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RaspberryGPIOPinConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RaspberryGPIOPinConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                RaspberryGPIOPinConfigDialog dialog = new RaspberryGPIOPinConfigDialog(new javax.swing.JFrame(), true);
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
    public void setPinConfig(int pinN){
         num = Integer.parseInt(GPIOPinTextField.getText());
         name = (String)GPIONameTextField.getText();
         type_pin = (String) typeComboBox.getSelectedItem();
         hILCfg = new HIoTPinConfig(num, name);
         hIoTGen.addPinConfig(pinN, hILCfg);
         hIoTGenA.addPinConfig(pinN, hILCfg);
    }
    
  private void showPandaGPIOPINDialog(String hDirectory){
        LattePandaGPIOPINDialog dialog = new LattePandaGPIOPINDialog(null, true, hDirectory);  
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
}           
 private void showCoralGPIOPINDialog(String hDirectory){
        CoralGPIOPINDialog1 dialog = new CoralGPIOPINDialog1(null, true, hDirectory);  
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
}
 
private void showTinkerGPIOPINDialog(String hDirectory){
        TinkerGPIOPINDialog dialog = new TinkerGPIOPINDialog(null, true, hDirectory);  
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
}

    private void showRaspberryGPIOPINDialog(String hDirectory){
        RaspberryGPIOPINDialog dialog = new RaspberryGPIOPINDialog(null, true, hDirectory);  
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
}
    public void generateSource(){
        if(check_board == panda){
            hIoTGen.set_config(num, name, type_pin, flagIotType,check_board);
            hIoTGen.initGenerator(hDirectory);
            hIoTGenA.set_config(num, name, type_pin, flagIotType,check_board);
            hIoTGenA.initGenerator(hDirectory);
            hIoTGenJ.set_config(num, name, type_pin, flagIotType,check_board);
            hIoTGenJ.initGenerator(hDirectory);
            
        }else{
            hIoTGen.set_config(num, name, type_pin, flagIotType,check_board);
            hIoTGen.initGenerator(hDirectory);
            hIoTGenJ.set_config(num, name, type_pin, flagIotType,check_board);
            hIoTGenJ.initGenerator(hDirectory);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GPIONameTextField;
    private javax.swing.JLabel GPIOPin;
    private javax.swing.JTextField GPIOPinTextField;
    private javax.swing.JButton SelectGPIOButton;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox pinComboBox;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
