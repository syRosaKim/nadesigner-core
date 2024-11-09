/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.inha.main.dialog;

import javax.xml.ws.Action;
import org.iesw.inha.generator.iot.HIoTGenerator;
import org.iesw.inha.generator.iot.HIoTGeneratorJS;

/**
 *
 * @author jjh
 */
public class IoTUSBCameraDialog extends javax.swing.JDialog {

    /**
     * Creates new form IoTUSBCameraDialog
     */
    public static final int H_SNN = 1; 
    public static final int H_IoT = 3; 
    
    public static final int rspi = 1;
    public static final int nano = 2;
    public static final int coral = 3;
    public static final int tinker =4;
    public static final int panda = 5; 
    
    private int check_board = 0;
    
    public static final int H_IoT_PICamera = 1;  
    public static final int H_IoT_USBCamera = 5; 
    private HIoTGeneratorJS hIoTGenJ = new HIoTGeneratorJS();
    public int state = 0;
    public static  String userDir;
    private String resolution;
    private String resizeResolution;
    private int check_flag = H_IoT_USBCamera; 
    private HIoTGenerator hIoTGen = new HIoTGenerator();
    private String hDirectory="";
    public IoTUSBCameraDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public IoTUSBCameraDialog(java.awt.Frame parent, boolean modal, String hDir) {
        super(parent, modal);
        hDirectory = hDir;
        initComponents();
    }
    public IoTUSBCameraDialog(java.awt.Frame parent, boolean modal, String hDir, int board) {
        super(parent, modal);
        hDirectory = hDir;
        check_board = board;
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

        GenerateButton = new javax.swing.JButton();
        cancelButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        resolutionLabel = new javax.swing.JLabel();
        resolutionTextField = new javax.swing.JTextField();
        resizeLabel = new javax.swing.JLabel();
        resizeTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(IoTUSBCameraDialog.class, "IoTUSBCameraDialog.title")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(GenerateButton, org.openide.util.NbBundle.getMessage(IoTUSBCameraDialog.class, "IoTUSBCameraDialog.GenerateButton.text")); // NOI18N
        GenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton1, org.openide.util.NbBundle.getMessage(IoTUSBCameraDialog.class, "IoTUSBCameraDialog.cancelButton1.text")); // NOI18N
        cancelButton1.setActionCommand(org.openide.util.NbBundle.getMessage(IoTUSBCameraDialog.class, "IoTUSBCameraDialog.cancelButton1.actionCommand")); // NOI18N
        cancelButton1.setMaximumSize(new java.awt.Dimension(100, 23));
        cancelButton1.setMinimumSize(new java.awt.Dimension(100, 23));
        cancelButton1.setPreferredSize(new java.awt.Dimension(100, 23));
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(IoTUSBCameraDialog.class, "IoTUSBCameraDialog.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(resolutionLabel, org.openide.util.NbBundle.getMessage(IoTUSBCameraDialog.class, "IoTUSBCameraDialog.resolutionLabel.text")); // NOI18N

        resolutionTextField.setText(org.openide.util.NbBundle.getMessage(IoTUSBCameraDialog.class, "IoTUSBCameraDialog.resolutionTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(resizeLabel, org.openide.util.NbBundle.getMessage(IoTUSBCameraDialog.class, "IoTUSBCameraDialog.resizeLabel.text")); // NOI18N

        resizeTextField.setText(org.openide.util.NbBundle.getMessage(IoTUSBCameraDialog.class, "IoTUSBCameraDialog.resizeTextField.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resolutionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resizeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resolutionTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(resizeTextField))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resolutionLabel)
                    .addComponent(resolutionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resizeLabel)
                    .addComponent(resizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GenerateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenerateButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateButtonActionPerformed
        resolution = resolutionTextField.getText();
        resizeResolution = resizeTextField.getText();

        generateConfig();
        generateSource();
        cancel();
    }//GEN-LAST:event_GenerateButtonActionPerformed

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        cancel();
    }//GEN-LAST:event_cancelButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(IoTUSBCameraDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IoTUSBCameraDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IoTUSBCameraDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IoTUSBCameraDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IoTUSBCameraDialog dialog = new IoTUSBCameraDialog(new javax.swing.JFrame(), true);
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
    public void generateConfig(){
        hIoTGen.set_configUSBCamera(resolution, resizeResolution, check_flag);
    }
    public void generateSource(){
        hIoTGen.initGenerator(hDirectory);
        hIoTGenJ.set_configCamera(check_board);
        hIoTGenJ.initGenerator(hDirectory);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GenerateButton;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel resizeLabel;
    private javax.swing.JTextField resizeTextField;
    private javax.swing.JLabel resolutionLabel;
    private javax.swing.JTextField resolutionTextField;
    // End of variables declaration//GEN-END:variables
}
