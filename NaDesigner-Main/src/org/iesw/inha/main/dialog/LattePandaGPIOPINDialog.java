package org.iesw.inha.main.dialog;

import javax.xml.ws.Action;
import org.iesw.inha.ioconfig.iot.HIoTPinConfig;

public class LattePandaGPIOPINDialog extends javax.swing.JDialog {
    
    public int num;
    private String hDirectory="";
    
    public LattePandaGPIOPINDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
     public LattePandaGPIOPINDialog(java.awt.Frame parent, boolean modal, String hDir) {
        super(parent, modal);
        hDirectory = hDir;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton52 = new javax.swing.JRadioButton();
        jRadioButton53 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton23 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton24 = new javax.swing.JRadioButton();
        jRadioButton25 = new javax.swing.JRadioButton();
        jRadioButton47 = new javax.swing.JRadioButton();
        jRadioButton48 = new javax.swing.JRadioButton();
        jRadioButton49 = new javax.swing.JRadioButton();
        jRadioButton50 = new javax.swing.JRadioButton();
        jRadioButton37 = new javax.swing.JRadioButton();
        jRadioButton40 = new javax.swing.JRadioButton();
        jRadioButton41 = new javax.swing.JRadioButton();
        jRadioButton42 = new javax.swing.JRadioButton();
        jRadioButton43 = new javax.swing.JRadioButton();
        jRadioButton44 = new javax.swing.JRadioButton();
        jRadioButton45 = new javax.swing.JRadioButton();
        jRadioButton46 = new javax.swing.JRadioButton();
        jRadioButton77 = new javax.swing.JRadioButton();
        jRadioButton78 = new javax.swing.JRadioButton();
        jRadioButton79 = new javax.swing.JRadioButton();
        jRadioButton80 = new javax.swing.JRadioButton();
        jRadioButton81 = new javax.swing.JRadioButton();
        jRadioButton82 = new javax.swing.JRadioButton();
        jRadioButton83 = new javax.swing.JRadioButton();
        jRadioButton84 = new javax.swing.JRadioButton();
        jRadioButton85 = new javax.swing.JRadioButton();
        jRadioButton86 = new javax.swing.JRadioButton();
        jRadioButton87 = new javax.swing.JRadioButton();
        jRadioButton88 = new javax.swing.JRadioButton();
        NextButton = new javax.swing.JButton();

        jRadioButton52.setBackground(new java.awt.Color(191, 235, 191));
        buttonGroup1.add(jRadioButton52);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton52, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton52.text")); // NOI18N
        jRadioButton52.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton52.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton52.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton52StateChanged(evt);
            }
        });
        jRadioButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton52ActionPerformed(evt);
            }
        });

        jRadioButton53.setBackground(new java.awt.Color(242, 226, 165));
        buttonGroup1.add(jRadioButton53);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton53, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton53.text")); // NOI18N
        jRadioButton53.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton53.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton53.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton53StateChanged(evt);
            }
        });
        jRadioButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton53ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.title")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jPanel1.border.title"))); // NOI18N

        jRadioButton8.setBackground(new java.awt.Color(254, 203, 206));
        buttonGroup1.add(jRadioButton8);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton8, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton8.text")); // NOI18N
        jRadioButton8.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton8.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton8.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton8StateChanged(evt);
            }
        });
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        jRadioButton16.setBackground(new java.awt.Color(165, 219, 236));
        buttonGroup1.add(jRadioButton16);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton16, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton16.text")); // NOI18N
        jRadioButton16.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton16.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton16.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton16StateChanged(evt);
            }
        });
        jRadioButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton16ActionPerformed(evt);
            }
        });

        jRadioButton26.setBackground(new java.awt.Color(221, 221, 221));
        buttonGroup1.add(jRadioButton26);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton26, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton26.text")); // NOI18N
        jRadioButton26.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton26.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton26.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton26StateChanged(evt);
            }
        });
        jRadioButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton26ActionPerformed(evt);
            }
        });

        jRadioButton10.setBackground(new java.awt.Color(254, 203, 206));
        buttonGroup1.add(jRadioButton10);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton10, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton10.text")); // NOI18N
        jRadioButton10.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton10.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton10.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton10StateChanged(evt);
            }
        });
        jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10ActionPerformed(evt);
            }
        });

        jRadioButton18.setBackground(new java.awt.Color(165, 219, 236));
        buttonGroup1.add(jRadioButton18);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton18, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton18.text")); // NOI18N
        jRadioButton18.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton18.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton18.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton18StateChanged(evt);
            }
        });
        jRadioButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton18ActionPerformed(evt);
            }
        });

        jRadioButton12.setBackground(new java.awt.Color(221, 221, 221));
        buttonGroup1.add(jRadioButton12);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton12, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton12.text")); // NOI18N
        jRadioButton12.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton12.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton12.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton12StateChanged(evt);
            }
        });
        jRadioButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton12ActionPerformed(evt);
            }
        });

        jRadioButton20.setBackground(new java.awt.Color(221, 221, 221));
        buttonGroup1.add(jRadioButton20);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton20, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton20.text")); // NOI18N
        jRadioButton20.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton20.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton20.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton20StateChanged(evt);
            }
        });
        jRadioButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton20ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(254, 203, 206));
        buttonGroup1.add(jRadioButton2);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton2, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton2.text")); // NOI18N
        jRadioButton2.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton2.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton2StateChanged(evt);
            }
        });
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton17.setBackground(new java.awt.Color(254, 203, 206));
        buttonGroup1.add(jRadioButton17);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton17, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton17.text")); // NOI18N
        jRadioButton17.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton17.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton17.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton17StateChanged(evt);
            }
        });
        jRadioButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton17ActionPerformed(evt);
            }
        });

        jRadioButton19.setBackground(new java.awt.Color(221, 221, 221));
        buttonGroup1.add(jRadioButton19);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton19, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton19.text")); // NOI18N
        jRadioButton19.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton19.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton19.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton19StateChanged(evt);
            }
        });
        jRadioButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton19ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(254, 203, 206));
        buttonGroup1.add(jRadioButton4);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton4, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton4.text")); // NOI18N
        jRadioButton4.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton4.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton4StateChanged(evt);
            }
        });
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton22.setBackground(new java.awt.Color(254, 203, 206));
        buttonGroup1.add(jRadioButton22);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton22, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton22.text")); // NOI18N
        jRadioButton22.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton22.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton22.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton22StateChanged(evt);
            }
        });
        jRadioButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton22ActionPerformed(evt);
            }
        });

        jRadioButton6.setBackground(new java.awt.Color(254, 203, 206));
        buttonGroup1.add(jRadioButton6);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton6, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton6.text")); // NOI18N
        jRadioButton6.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton6.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton6StateChanged(evt);
            }
        });
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jRadioButton21.setBackground(new java.awt.Color(242, 226, 165));
        buttonGroup1.add(jRadioButton21);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton21, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton21.text")); // NOI18N
        jRadioButton21.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton21.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton21.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton21StateChanged(evt);
            }
        });
        jRadioButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton21ActionPerformed(evt);
            }
        });

        jRadioButton23.setBackground(new java.awt.Color(242, 226, 165));
        buttonGroup1.add(jRadioButton23);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton23, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton23.text")); // NOI18N
        jRadioButton23.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton23.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton23.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton23StateChanged(evt);
            }
        });
        jRadioButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton23ActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(221, 221, 221));
        buttonGroup1.add(jRadioButton1);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton1, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton1.text")); // NOI18N
        jRadioButton1.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton1.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton1StateChanged(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(221, 221, 221));
        buttonGroup1.add(jRadioButton3);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton3, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton3.text")); // NOI18N
        jRadioButton3.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton3.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton3StateChanged(evt);
            }
        });
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton5.setBackground(new java.awt.Color(221, 221, 221));
        buttonGroup1.add(jRadioButton5);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton5, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton5.text")); // NOI18N
        jRadioButton5.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton5.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton5StateChanged(evt);
            }
        });
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioButton7.setBackground(new java.awt.Color(221, 221, 221));
        buttonGroup1.add(jRadioButton7);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton7, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton7.text")); // NOI18N
        jRadioButton7.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton7.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton7StateChanged(evt);
            }
        });
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        jRadioButton9.setBackground(new java.awt.Color(221, 221, 221));
        buttonGroup1.add(jRadioButton9);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton9, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton9.text")); // NOI18N
        jRadioButton9.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton9.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton9.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton9StateChanged(evt);
            }
        });
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        jRadioButton11.setBackground(new java.awt.Color(165, 219, 236));
        buttonGroup1.add(jRadioButton11);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton11, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton11.text")); // NOI18N
        jRadioButton11.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton11.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton11.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton11StateChanged(evt);
            }
        });
        jRadioButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton11ActionPerformed(evt);
            }
        });

        jRadioButton13.setBackground(new java.awt.Color(165, 219, 236));
        buttonGroup1.add(jRadioButton13);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton13, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton13.text")); // NOI18N
        jRadioButton13.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton13.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton13.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton13StateChanged(evt);
            }
        });
        jRadioButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton13ActionPerformed(evt);
            }
        });

        jRadioButton15.setBackground(new java.awt.Color(165, 219, 236));
        buttonGroup1.add(jRadioButton15);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton15, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton15.text")); // NOI18N
        jRadioButton15.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton15.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton15.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton15StateChanged(evt);
            }
        });
        jRadioButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton15ActionPerformed(evt);
            }
        });

        jRadioButton14.setBackground(new java.awt.Color(165, 219, 236));
        buttonGroup1.add(jRadioButton14);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton14, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton14.text")); // NOI18N
        jRadioButton14.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton14.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton14.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton14StateChanged(evt);
            }
        });
        jRadioButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton14ActionPerformed(evt);
            }
        });

        jRadioButton24.setBackground(new java.awt.Color(242, 226, 165));
        buttonGroup1.add(jRadioButton24);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton24, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton24.text")); // NOI18N
        jRadioButton24.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton24.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton24.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton24StateChanged(evt);
            }
        });
        jRadioButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton24ActionPerformed(evt);
            }
        });

        jRadioButton25.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton25);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton25, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton25.text")); // NOI18N
        jRadioButton25.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton25.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton25.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton25StateChanged(evt);
            }
        });
        jRadioButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton25ActionPerformed(evt);
            }
        });

        jRadioButton47.setBackground(new java.awt.Color(221, 221, 221));
        buttonGroup1.add(jRadioButton47);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton47, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton47.text")); // NOI18N
        jRadioButton47.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton47.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton47.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton47StateChanged(evt);
            }
        });
        jRadioButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton47ActionPerformed(evt);
            }
        });

        jRadioButton48.setBackground(new java.awt.Color(254, 203, 206));
        buttonGroup1.add(jRadioButton48);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton48, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton48.text")); // NOI18N
        jRadioButton48.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton48.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton48.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton48StateChanged(evt);
            }
        });
        jRadioButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton48ActionPerformed(evt);
            }
        });

        jRadioButton49.setBackground(new java.awt.Color(221, 221, 221));
        buttonGroup1.add(jRadioButton49);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton49, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton49.text")); // NOI18N
        jRadioButton49.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton49.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton49.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton49StateChanged(evt);
            }
        });
        jRadioButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton49ActionPerformed(evt);
            }
        });

        jRadioButton50.setBackground(new java.awt.Color(254, 203, 206));
        buttonGroup1.add(jRadioButton50);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton50, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton50.text")); // NOI18N
        jRadioButton50.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton50.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton50.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton50StateChanged(evt);
            }
        });
        jRadioButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton50ActionPerformed(evt);
            }
        });

        jRadioButton37.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton37);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton37, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton37.text")); // NOI18N
        jRadioButton37.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton37.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton37.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton37StateChanged(evt);
            }
        });
        jRadioButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton37ActionPerformed(evt);
            }
        });

        jRadioButton40.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton40);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton40, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton40.text")); // NOI18N
        jRadioButton40.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton40.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton40.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton40StateChanged(evt);
            }
        });
        jRadioButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton40ActionPerformed(evt);
            }
        });

        jRadioButton41.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton41);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton41, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton41.text")); // NOI18N
        jRadioButton41.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton41.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton41.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton41StateChanged(evt);
            }
        });
        jRadioButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton41ActionPerformed(evt);
            }
        });

        jRadioButton42.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton42);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton42, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton42.text")); // NOI18N
        jRadioButton42.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton42.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton42.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton42StateChanged(evt);
            }
        });
        jRadioButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton42ActionPerformed(evt);
            }
        });

        jRadioButton43.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton43);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton43, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton43.text")); // NOI18N
        jRadioButton43.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton43.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton43.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton43StateChanged(evt);
            }
        });
        jRadioButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton43ActionPerformed(evt);
            }
        });

        jRadioButton44.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton44);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton44, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton44.text")); // NOI18N
        jRadioButton44.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton44.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton44.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton44StateChanged(evt);
            }
        });
        jRadioButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton44ActionPerformed(evt);
            }
        });

        jRadioButton45.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton45);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton45, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton45.text")); // NOI18N
        jRadioButton45.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton45.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton45.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton45StateChanged(evt);
            }
        });
        jRadioButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton45ActionPerformed(evt);
            }
        });

        jRadioButton46.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton46);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton46, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton46.text")); // NOI18N
        jRadioButton46.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton46.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton46.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton46StateChanged(evt);
            }
        });
        jRadioButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton46ActionPerformed(evt);
            }
        });

        jRadioButton77.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton77);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton77, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton77.text")); // NOI18N
        jRadioButton77.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton77.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton77.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton77StateChanged(evt);
            }
        });
        jRadioButton77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton77ActionPerformed(evt);
            }
        });

        jRadioButton78.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton78);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton78, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton78.text")); // NOI18N
        jRadioButton78.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton78.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton78.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton78StateChanged(evt);
            }
        });
        jRadioButton78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton78ActionPerformed(evt);
            }
        });

        jRadioButton79.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton79);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton79, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton79.text")); // NOI18N
        jRadioButton79.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton79.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton79.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton79StateChanged(evt);
            }
        });
        jRadioButton79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton79ActionPerformed(evt);
            }
        });

        jRadioButton80.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton80);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton80, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton80.text")); // NOI18N
        jRadioButton80.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton80.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton80.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton80StateChanged(evt);
            }
        });
        jRadioButton80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton80ActionPerformed(evt);
            }
        });

        jRadioButton81.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton81);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton81, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton81.text")); // NOI18N
        jRadioButton81.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton81.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton81.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton81StateChanged(evt);
            }
        });
        jRadioButton81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton81ActionPerformed(evt);
            }
        });

        jRadioButton82.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton82);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton82, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton82.text")); // NOI18N
        jRadioButton82.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton82.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton82.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton82StateChanged(evt);
            }
        });
        jRadioButton82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton82ActionPerformed(evt);
            }
        });

        jRadioButton83.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton83);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton83, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton83.text")); // NOI18N
        jRadioButton83.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton83.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton83.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton83StateChanged(evt);
            }
        });
        jRadioButton83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton83ActionPerformed(evt);
            }
        });

        jRadioButton84.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton84);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton84, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton84.text")); // NOI18N
        jRadioButton84.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton84.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton84.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton84StateChanged(evt);
            }
        });
        jRadioButton84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton84ActionPerformed(evt);
            }
        });

        jRadioButton85.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton85);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton85, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton85.text")); // NOI18N
        jRadioButton85.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton85.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton85.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton85StateChanged(evt);
            }
        });
        jRadioButton85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton85ActionPerformed(evt);
            }
        });

        jRadioButton86.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton86);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton86, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton86.text")); // NOI18N
        jRadioButton86.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton86.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton86.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton86StateChanged(evt);
            }
        });
        jRadioButton86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton86ActionPerformed(evt);
            }
        });

        jRadioButton87.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton87);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton87, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton87.text")); // NOI18N
        jRadioButton87.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton87.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton87.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton87StateChanged(evt);
            }
        });
        jRadioButton87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton87ActionPerformed(evt);
            }
        });

        jRadioButton88.setBackground(new java.awt.Color(189, 219, 190));
        buttonGroup1.add(jRadioButton88);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton88, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.jRadioButton88.text")); // NOI18N
        jRadioButton88.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton88.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton88.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton88StateChanged(evt);
            }
        });
        jRadioButton88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton88ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jRadioButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jRadioButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jRadioButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton84, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton85, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton86, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton88, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton84, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton85, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton86, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton88, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jRadioButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jRadioButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(NextButton, org.openide.util.NbBundle.getMessage(LattePandaGPIOPINDialog.class, "LattePandaGPIOPINDialog.NextButton.text")); // NOI18N
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NextButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        RaspberryGPIOPinConfigDialog Dialog = new RaspberryGPIOPinConfigDialog(null,true);
        Dialog.number=num;
        cancel();
    }//GEN-LAST:event_NextButtonActionPerformed

    private void jRadioButton52StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton52StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton52StateChanged

    private void jRadioButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton52ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton52ActionPerformed

    private void jRadioButton53StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton53StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton53StateChanged

    private void jRadioButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton53ActionPerformed

    private void jRadioButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton50ActionPerformed
        num = 1;
    }//GEN-LAST:event_jRadioButton50ActionPerformed

    private void jRadioButton50StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton50StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton50StateChanged

    private void jRadioButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton49ActionPerformed
        num = 0;
    }//GEN-LAST:event_jRadioButton49ActionPerformed

    private void jRadioButton49StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton49StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton49StateChanged

    private void jRadioButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton48ActionPerformed
        num = 1;        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton48ActionPerformed

    private void jRadioButton48StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton48StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton48StateChanged

    private void jRadioButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton47ActionPerformed
        num = 0;        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton47ActionPerformed

    private void jRadioButton47StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton47StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton47StateChanged

    private void jRadioButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton25ActionPerformed
        num = 25;
    }//GEN-LAST:event_jRadioButton25ActionPerformed

    private void jRadioButton25StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton25StateChanged

    }//GEN-LAST:event_jRadioButton25StateChanged

    private void jRadioButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton24ActionPerformed
        num = 24;
    }//GEN-LAST:event_jRadioButton24ActionPerformed

    private void jRadioButton24StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton24StateChanged

    }//GEN-LAST:event_jRadioButton24StateChanged

    private void jRadioButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton14ActionPerformed
        num = 14;
    }//GEN-LAST:event_jRadioButton14ActionPerformed

    private void jRadioButton14StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton14StateChanged

    }//GEN-LAST:event_jRadioButton14StateChanged

    private void jRadioButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton15ActionPerformed
        num = 15;
    }//GEN-LAST:event_jRadioButton15ActionPerformed

    private void jRadioButton15StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton15StateChanged

    }//GEN-LAST:event_jRadioButton15StateChanged

    private void jRadioButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton13ActionPerformed
        num = 13;
    }//GEN-LAST:event_jRadioButton13ActionPerformed

    private void jRadioButton13StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton13StateChanged

    }//GEN-LAST:event_jRadioButton13StateChanged

    private void jRadioButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton11ActionPerformed
        num = 11;
    }//GEN-LAST:event_jRadioButton11ActionPerformed

    private void jRadioButton11StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton11StateChanged

    }//GEN-LAST:event_jRadioButton11StateChanged

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        num = 0;
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void jRadioButton9StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton9StateChanged

    }//GEN-LAST:event_jRadioButton9StateChanged

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        num = 0;
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton7StateChanged

    }//GEN-LAST:event_jRadioButton7StateChanged

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        num = 0;
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton5StateChanged

    }//GEN-LAST:event_jRadioButton5StateChanged

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        num = 0;
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton3StateChanged

    }//GEN-LAST:event_jRadioButton3StateChanged

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        num = 0;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton1StateChanged

    }//GEN-LAST:event_jRadioButton1StateChanged

    private void jRadioButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton23ActionPerformed
        num = 23;
    }//GEN-LAST:event_jRadioButton23ActionPerformed

    private void jRadioButton23StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton23StateChanged

    }//GEN-LAST:event_jRadioButton23StateChanged

    private void jRadioButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton21ActionPerformed
        num = 21;
    }//GEN-LAST:event_jRadioButton21ActionPerformed

    private void jRadioButton21StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton21StateChanged

    }//GEN-LAST:event_jRadioButton21StateChanged

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        num = 1;
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton6StateChanged

    }//GEN-LAST:event_jRadioButton6StateChanged

    private void jRadioButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton22ActionPerformed
        num = 1;
    }//GEN-LAST:event_jRadioButton22ActionPerformed

    private void jRadioButton22StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton22StateChanged

    }//GEN-LAST:event_jRadioButton22StateChanged

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        num = 1;
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton4StateChanged

    }//GEN-LAST:event_jRadioButton4StateChanged

    private void jRadioButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton19ActionPerformed
        num = 0;
    }//GEN-LAST:event_jRadioButton19ActionPerformed

    private void jRadioButton19StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton19StateChanged

    }//GEN-LAST:event_jRadioButton19StateChanged

    private void jRadioButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton17ActionPerformed
        num = 1;
    }//GEN-LAST:event_jRadioButton17ActionPerformed

    private void jRadioButton17StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton17StateChanged

    }//GEN-LAST:event_jRadioButton17StateChanged

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        num = 2;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton2StateChanged

    }//GEN-LAST:event_jRadioButton2StateChanged

    private void jRadioButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton20ActionPerformed
        num = 20;
    }//GEN-LAST:event_jRadioButton20ActionPerformed

    private void jRadioButton20StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton20StateChanged

    }//GEN-LAST:event_jRadioButton20StateChanged

    private void jRadioButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton12ActionPerformed
        num = 12;
    }//GEN-LAST:event_jRadioButton12ActionPerformed

    private void jRadioButton12StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton12StateChanged

    }//GEN-LAST:event_jRadioButton12StateChanged

    private void jRadioButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton18ActionPerformed
        num = 18;
    }//GEN-LAST:event_jRadioButton18ActionPerformed

    private void jRadioButton18StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton18StateChanged

    }//GEN-LAST:event_jRadioButton18StateChanged

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        num = 10;
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    private void jRadioButton10StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton10StateChanged

    }//GEN-LAST:event_jRadioButton10StateChanged

    private void jRadioButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton26ActionPerformed
        num = 26;
    }//GEN-LAST:event_jRadioButton26ActionPerformed

    private void jRadioButton26StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton26StateChanged

    }//GEN-LAST:event_jRadioButton26StateChanged

    private void jRadioButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton16ActionPerformed
        num = 16;
    }//GEN-LAST:event_jRadioButton16ActionPerformed

    private void jRadioButton16StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton16StateChanged

    }//GEN-LAST:event_jRadioButton16StateChanged

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        num = 8;
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton8StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton8StateChanged

    }//GEN-LAST:event_jRadioButton8StateChanged

    private void jRadioButton37StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton37StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton37StateChanged

    private void jRadioButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton37ActionPerformed
       num = 7;
    }//GEN-LAST:event_jRadioButton37ActionPerformed

    private void jRadioButton40StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton40StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton40StateChanged

    private void jRadioButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton40ActionPerformed
       num = 0;
    }//GEN-LAST:event_jRadioButton40ActionPerformed

    private void jRadioButton41StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton41StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton41StateChanged

    private void jRadioButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton41ActionPerformed
        num = 8;
    }//GEN-LAST:event_jRadioButton41ActionPerformed

    private void jRadioButton42StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton42StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton42StateChanged

    private void jRadioButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton42ActionPerformed
        num = 1;
    }//GEN-LAST:event_jRadioButton42ActionPerformed

    private void jRadioButton43StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton43StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton43StateChanged

    private void jRadioButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton43ActionPerformed
        num = 9;
    }//GEN-LAST:event_jRadioButton43ActionPerformed

    private void jRadioButton44StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton44StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton44StateChanged

    private void jRadioButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton44ActionPerformed
        num = 2;
    }//GEN-LAST:event_jRadioButton44ActionPerformed

    private void jRadioButton45StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton45StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton45StateChanged

    private void jRadioButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton45ActionPerformed
        num = 10;
    }//GEN-LAST:event_jRadioButton45ActionPerformed

    private void jRadioButton46StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton46StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton46StateChanged

    private void jRadioButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton46ActionPerformed
        num = 3;
    }//GEN-LAST:event_jRadioButton46ActionPerformed

    private void jRadioButton77StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton77StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton77StateChanged

    private void jRadioButton77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton77ActionPerformed
        num = 11;
    }//GEN-LAST:event_jRadioButton77ActionPerformed

    private void jRadioButton78StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton78StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton78StateChanged

    private void jRadioButton78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton78ActionPerformed
        num = 4;
    }//GEN-LAST:event_jRadioButton78ActionPerformed

    private void jRadioButton79StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton79StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton79StateChanged

    private void jRadioButton79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton79ActionPerformed
        num = 12;
    }//GEN-LAST:event_jRadioButton79ActionPerformed

    private void jRadioButton80StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton80StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton80StateChanged

    private void jRadioButton80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton80ActionPerformed
        num = 5;
    }//GEN-LAST:event_jRadioButton80ActionPerformed

    private void jRadioButton81StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton81StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton81StateChanged

    private void jRadioButton81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton81ActionPerformed
        num = 13;
    }//GEN-LAST:event_jRadioButton81ActionPerformed

    private void jRadioButton82StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton82StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton82StateChanged

    private void jRadioButton82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton82ActionPerformed
        num = 6;
    }//GEN-LAST:event_jRadioButton82ActionPerformed

    private void jRadioButton83StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton83StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton83StateChanged

    private void jRadioButton83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton83ActionPerformed
        num = 21;
    }//GEN-LAST:event_jRadioButton83ActionPerformed

    private void jRadioButton84StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton84StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton84StateChanged

    private void jRadioButton84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton84ActionPerformed
       num = 18;
    }//GEN-LAST:event_jRadioButton84ActionPerformed

    private void jRadioButton85StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton85StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton85StateChanged

    private void jRadioButton85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton85ActionPerformed
        num = 22;
    }//GEN-LAST:event_jRadioButton85ActionPerformed

    private void jRadioButton86StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton86StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton86StateChanged

    private void jRadioButton86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton86ActionPerformed
       num = 19;
    }//GEN-LAST:event_jRadioButton86ActionPerformed

    private void jRadioButton87StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton87StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton87StateChanged

    private void jRadioButton87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton87ActionPerformed
        num = 23;
    }//GEN-LAST:event_jRadioButton87ActionPerformed

    private void jRadioButton88StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton88StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton88StateChanged

    private void jRadioButton88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton88ActionPerformed
        num = 20;
    }//GEN-LAST:event_jRadioButton88ActionPerformed

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
            java.util.logging.Logger.getLogger(LattePandaGPIOPINDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LattePandaGPIOPINDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LattePandaGPIOPINDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LattePandaGPIOPINDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                LattePandaGPIOPINDialog dialog = new LattePandaGPIOPINDialog(new javax.swing.JFrame(), true);
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NextButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton24;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton37;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton40;
    private javax.swing.JRadioButton jRadioButton41;
    private javax.swing.JRadioButton jRadioButton42;
    private javax.swing.JRadioButton jRadioButton43;
    private javax.swing.JRadioButton jRadioButton44;
    private javax.swing.JRadioButton jRadioButton45;
    private javax.swing.JRadioButton jRadioButton46;
    private javax.swing.JRadioButton jRadioButton47;
    private javax.swing.JRadioButton jRadioButton48;
    private javax.swing.JRadioButton jRadioButton49;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton50;
    private javax.swing.JRadioButton jRadioButton52;
    private javax.swing.JRadioButton jRadioButton53;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton77;
    private javax.swing.JRadioButton jRadioButton78;
    private javax.swing.JRadioButton jRadioButton79;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton80;
    private javax.swing.JRadioButton jRadioButton81;
    private javax.swing.JRadioButton jRadioButton82;
    private javax.swing.JRadioButton jRadioButton83;
    private javax.swing.JRadioButton jRadioButton84;
    private javax.swing.JRadioButton jRadioButton85;
    private javax.swing.JRadioButton jRadioButton86;
    private javax.swing.JRadioButton jRadioButton87;
    private javax.swing.JRadioButton jRadioButton88;
    private javax.swing.JRadioButton jRadioButton9;
    // End of variables declaration//GEN-END:variables

}
