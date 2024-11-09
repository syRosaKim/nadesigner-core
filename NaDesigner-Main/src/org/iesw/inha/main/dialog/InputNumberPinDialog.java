package org.iesw.inha.main.dialog;

import javax.xml.ws.Action; 

public class InputNumberPinDialog extends javax.swing.JDialog {
    
    public static final int H_IoT_sevenSegment = 2;   
    public static final int H_IoT_LED = 3;  
    public static final int H_IoT_UltraSonic = 4;
    
    private String hDirectory="";
    public int flagIotType = 0; 
    public int inputGpioPinNum;
    public int check_board = 0;
    public InputNumberPinDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public InputNumberPinDialog(java.awt.Frame parent, boolean modal,int value, String hDir) {
        super(parent, modal);
        hDirectory = hDir;
        check_board = value;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        numberOfPinsTextField = new javax.swing.JTextField();
        numberOfPinsLabel = new javax.swing.JLabel();
        iotTypeLabel = new javax.swing.JLabel();
        iotTypeComboBox = new javax.swing.JComboBox();
        Next = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(InputNumberPinDialog.class, "InputNumberPinDialog.title")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(InputNumberPinDialog.class, "InputNumberPinDialog.jPanel1.border.title"))); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(224, 139));

        numberOfPinsTextField.setText(org.openide.util.NbBundle.getMessage(InputNumberPinDialog.class, "InputNumberPinDialog.numberOfPinsTextField.text")); // NOI18N
        numberOfPinsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfPinsTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(numberOfPinsLabel, org.openide.util.NbBundle.getMessage(InputNumberPinDialog.class, "InputNumberPinDialog.numberOfPinsLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(iotTypeLabel, org.openide.util.NbBundle.getMessage(InputNumberPinDialog.class, "InputNumberPinDialog.iotTypeLabel.text")); // NOI18N

        iotTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "7 Segments", "LED", "Ultrasonic Waves", "None" }));
        iotTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iotTypeComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numberOfPinsLabel)
                    .addComponent(iotTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numberOfPinsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(iotTypeComboBox, 0, 1, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iotTypeLabel)
                    .addComponent(iotTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfPinsLabel)
                    .addComponent(numberOfPinsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(Next, org.openide.util.NbBundle.getMessage(InputNumberPinDialog.class, "InputNumberPinDialog.Next.text")); // NOI18N
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(InputNumberPinDialog.class, "InputNumberPinDialog.cancelButton.text")); // NOI18N
        cancelButton.setActionCommand(org.openide.util.NbBundle.getMessage(InputNumberPinDialog.class, "InputNumberPinDialog.cancelButton.actionCommand")); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Next)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        inputGpioPinNum = Integer.parseInt(numberOfPinsTextField.getText());
        if(iotTypeComboBox.getSelectedItem()=="7 Segments"){
            flagIotType = H_IoT_sevenSegment;
            showGPIOLayerConfigDialog(hDirectory, inputGpioPinNum,check_board, flagIotType);
        }
        else if(iotTypeComboBox.getSelectedItem()=="LED"){
            flagIotType = H_IoT_LED;
            showGPIOLayerConfigDialog(hDirectory, inputGpioPinNum,check_board, flagIotType);
        }
        else if(iotTypeComboBox.getSelectedItem()=="Ultrasonic Waves"){
            flagIotType = H_IoT_UltraSonic;
            showGPIOLayerConfigDialog(hDirectory, inputGpioPinNum,check_board, flagIotType);
        }
        cancel();

    }//GEN-LAST:event_NextActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cancel();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void numberOfPinsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfPinsTextFieldActionPerformed

    }//GEN-LAST:event_numberOfPinsTextFieldActionPerformed

    private void iotTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iotTypeComboBoxActionPerformed
        javax.swing.JComboBox iotTypeComboBox = (javax.swing.JComboBox)evt.getSource();
        Object selected = iotTypeComboBox.getSelectedItem();
        if(selected.toString().equals("7 Segments"))
            numberOfPinsTextField.setText("8");
        else if(selected.toString().equals("Ultrasonic Waves"))
            numberOfPinsTextField.setText("2");
        else
            numberOfPinsTextField.setText("1");
    }//GEN-LAST:event_iotTypeComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(InputNumberPinDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputNumberPinDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputNumberPinDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputNumberPinDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InputNumberPinDialog dialog = new InputNumberPinDialog(new javax.swing.JFrame(), true);
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
    private void showRaspberryGPIOOutConfigDialog(String hDirectory){
        RaspberryGPIOOutConfigDialog dialog = new RaspberryGPIOOutConfigDialog(null, true, hDirectory); 
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
  
    private void showGPIOLayerConfigDialog(String hDirectory,int num,int board, int flag){
        RaspberryGPIOPinConfigDialog dialog = new RaspberryGPIOPinConfigDialog(null, true, hDirectory,num, board, flagIotType);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Next;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox iotTypeComboBox;
    private javax.swing.JLabel iotTypeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel numberOfPinsLabel;
    private javax.swing.JTextField numberOfPinsTextField;
    // End of variables declaration//GEN-END:variables
}
