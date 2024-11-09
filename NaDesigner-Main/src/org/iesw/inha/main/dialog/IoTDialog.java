package org.iesw.inha.main.dialog;

import java.io.File;
import javax.xml.ws.Action;

public class IoTDialog extends javax.swing.JDialog {

    public static final int H_SNN = 1;
    public static final int H_IoT = 3;
    
    public static final int H_IoT_PICamera = 1; 
    public static final int H_IoT_GPIO = 2;  
    public static final int H_IoT_Mic = 6; 
    public static final int H_IoT_USBCamera = 5;  
    
    public static final int rspi = 1;
    public static final int nano = 2;
    public static final int coral = 3;
    public static final int tinker =4;
    public static final int panda = 5;
    private int flagIoT = 0;
    private int board = 0;
    private String hDirectory="";
    public IoTDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public IoTDialog(java.awt.Frame parent, boolean modal, String hDir) {
        super(parent, modal);
        hDirectory = hDir;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogGroup = new javax.swing.ButtonGroup();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        USBCameraRadioButton = new javax.swing.JRadioButton();
        CSICameraRadioButton = new javax.swing.JRadioButton();
        GPIORadioButton = new javax.swing.JRadioButton();
        typeLabel = new javax.swing.JLabel();
        MICInputRadioButton1 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        hardwareLabel = new javax.swing.JLabel();
        hardwareComboBox = new javax.swing.JComboBox();
        Next = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(IoTDialog.class, "IoTDialog.title")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(IoTDialog.class, "IoTDialog.jPanel1.border.title"))); // NOI18N

        dialogGroup.add(USBCameraRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(USBCameraRadioButton, org.openide.util.NbBundle.getMessage(IoTDialog.class, "IoTDialog.USBCameraRadioButton.text")); // NOI18N
        USBCameraRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USBCameraRadioButtonActionPerformed(evt);
            }
        });

        dialogGroup.add(CSICameraRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(CSICameraRadioButton, org.openide.util.NbBundle.getMessage(IoTDialog.class, "IoTDialog.CSICameraRadioButton.text")); // NOI18N
        CSICameraRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSICameraRadioButtonActionPerformed(evt);
            }
        });

        dialogGroup.add(GPIORadioButton);
        GPIORadioButton.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(GPIORadioButton, org.openide.util.NbBundle.getMessage(IoTDialog.class, "IoTDialog.GPIORadioButton.text")); // NOI18N
        GPIORadioButton.setContentAreaFilled(false);
        GPIORadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        org.openide.awt.Mnemonics.setLocalizedText(typeLabel, org.openide.util.NbBundle.getMessage(IoTDialog.class, "IoTDialog.typeLabel.text")); // NOI18N

        dialogGroup.add(MICInputRadioButton1);
        org.openide.awt.Mnemonics.setLocalizedText(MICInputRadioButton1, org.openide.util.NbBundle.getMessage(IoTDialog.class, "IoTDialog.MICInputRadioButton1.text")); // NOI18N
        MICInputRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MICInputRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typeLabel)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(GPIORadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(66, 66, 66))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(USBCameraRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CSICameraRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MICInputRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(118, 118, 118))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GPIORadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel)
                    .addComponent(MICInputRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USBCameraRadioButton)
                    .addComponent(CSICameraRadioButton))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(IoTDialog.class, "IoTDialog.jPanel2.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(hardwareLabel, org.openide.util.NbBundle.getMessage(IoTDialog.class, "IoTDialog.hardwareLabel.text")); // NOI18N

        hardwareComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RaspberryPI", "LattePanda", "JetsonNano", "Coral", "Tinker" }));
        hardwareComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardwareComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hardwareLabel)
                .addGap(18, 18, 18)
                .addComponent(hardwareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hardwareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hardwareLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(Next, org.openide.util.NbBundle.getMessage(IoTDialog.class, "IoTDialog.Next.text")); // NOI18N
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(IoTDialog.class, "IoTDialog.cancelButton.text")); // NOI18N
        cancelButton.setActionCommand(org.openide.util.NbBundle.getMessage(IoTDialog.class, "IoTDialog.cancelButton.actionCommand")); // NOI18N
        cancelButton.setMaximumSize(new java.awt.Dimension(100, 23));
        cancelButton.setMinimumSize(new java.awt.Dimension(100, 23));
        cancelButton.setPreferredSize(new java.awt.Dimension(100, 23));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Next))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        if(CSICameraRadioButton.isSelected())
            flagIoT = H_IoT_PICamera;
        else if(USBCameraRadioButton.isSelected())
            flagIoT = H_IoT_USBCamera;
        else if(MICInputRadioButton1.isSelected())
            flagIoT = H_IoT_Mic;
        else
            flagIoT = H_IoT_GPIO;
        
        if(flagIoT == H_IoT_Mic){
            cancel();
            showMicInputDialog(hDirectory);
        }
        
        if(flagIoT == H_IoT_PICamera && hardwareComboBox.getSelectedItem()=="RaspberryPI"){
            cancel();
            showPICameraDialog(hDirectory);
        }
        else if(flagIoT == H_IoT_GPIO && hardwareComboBox.getSelectedItem()=="RaspberryPI"){
            cancel();
            showIoTGPIODialog(hDirectory,rspi);
        }
       else if(flagIoT == H_IoT_USBCamera&&hardwareComboBox.getSelectedItem()=="RaspberryPI"){
           board = rspi;
            cancel();
            showUSBCameraDialog(hDirectory,board);
        }
         else if(flagIoT == H_IoT_USBCamera&&hardwareComboBox.getSelectedItem()=="JetsonNano"){
           board = nano;
            cancel();
            showUSBCameraDialog(hDirectory,board);
        }
        else if(flagIoT == H_IoT_GPIO&&hardwareComboBox.getSelectedItem()=="JetsonNano"){
            cancel();
            showIoTGPIODialog(hDirectory,nano);
        }
        else if(flagIoT == H_IoT_GPIO&&hardwareComboBox.getSelectedItem()=="Coral"){
            cancel();
            showIoTGPIODialog(hDirectory,coral);
        }
        else if(flagIoT == H_IoT_USBCamera&&hardwareComboBox.getSelectedItem()=="Coral"){
           board = coral;
            cancel();
            showUSBCameraDialog(hDirectory,board);
        }
        else if(flagIoT == H_IoT_GPIO&&hardwareComboBox.getSelectedItem()=="LattePanda"){
            cancel();
            showIoTGPIODialog(hDirectory,panda);//수정필요
            
        }
        else if(flagIoT == H_IoT_USBCamera&&hardwareComboBox.getSelectedItem()=="LattePanda"){
           board = panda;
            cancel();
            showUSBCameraDialog(hDirectory,board);
        }
        else if(flagIoT == H_IoT_GPIO&&hardwareComboBox.getSelectedItem()=="Tinker"){
            cancel();
            showIoTGPIODialog(hDirectory,tinker);//수정필요
            
        }
        else if(flagIoT == H_IoT_USBCamera&&hardwareComboBox.getSelectedItem()=="Tinker"){
           board = tinker;
            cancel();
            showUSBCameraDialog(hDirectory,board);
        }
         createRuntimeFile();
    }//GEN-LAST:event_NextActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cancel();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void hardwareComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardwareComboBoxActionPerformed
        if(hardwareComboBox.getSelectedItem()=="RaspberryPI"){
            CSICameraRadioButton.setVisible(true);
        }else{
            CSICameraRadioButton.setVisible(false);
        }
    }//GEN-LAST:event_hardwareComboBoxActionPerformed

    private void CSICameraRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSICameraRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CSICameraRadioButtonActionPerformed

    private void USBCameraRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USBCameraRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_USBCameraRadioButtonActionPerformed

    private void MICInputRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MICInputRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MICInputRadioButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(IoTDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IoTDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IoTDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IoTDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IoTDialog dialog = new IoTDialog(new javax.swing.JFrame(), true);
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
    private void showIoTGPIODialog(String hDirectory, int value){  
        InputNumberPinDialog dialog = new InputNumberPinDialog(null, true,value, hDirectory); 
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
}

    private void showPICameraDialog(String hDirectory){
        RaspberryPiCameraDialog dialog = new RaspberryPiCameraDialog(null, true, hDirectory); 
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
}
     private void showUSBCameraDialog(String hDirectory, int board){
        IoTUSBCameraDialog dialog = new IoTUSBCameraDialog(null, true, hDirectory, board); 
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
}
     private void showMicInputDialog(String hDirectory){
        MicInput dialog = new MicInput(null, true, hDirectory); 
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CSICameraRadioButton;
    private javax.swing.JRadioButton GPIORadioButton;
    private javax.swing.JRadioButton MICInputRadioButton1;
    private javax.swing.JButton Next;
    private javax.swing.JRadioButton USBCameraRadioButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.ButtonGroup dialogGroup;
    private javax.swing.JComboBox hardwareComboBox;
    private javax.swing.JLabel hardwareLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables

private void createRuntimeFile(){ //SeoyeonKim 
        //iot폴더("프로젝트명\iot")안에 런타임 이름으로 파일을 생성한다.
        //1. 생성하기 전에 이미 다른 파일이 존재하는지 확인하여 전체 삭제
        //2. 현재 선택된 런타임 이름으로 파일 생성
        
        String checkPath = hDirectory + File.separatorChar + "iot";
        File path = new File(checkPath);
        File[] fileList = path.listFiles();
        
        File runtimeFile = new File(checkPath+ File.separatorChar + (String)hardwareComboBox.getSelectedItem());
        try {
            if (runtimeFile.createNewFile()) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
