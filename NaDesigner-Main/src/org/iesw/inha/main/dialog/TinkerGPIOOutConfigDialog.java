package org.iesw.inha.main.dialog;

import javax.xml.ws.Action;
import org.iesw.inha.generator.iot.HIoTGenerator;

public class TinkerGPIOOutConfigDialog extends javax.swing.JDialog {
    
    public static final int H_SNN = 1;
    public static final int H_IoT = 3; 
    public int num = 0;
    private int check_flag =3;
    private HIoTGenerator hIoTGen = new HIoTGenerator();
    private String hDirectory="";
        
    public TinkerGPIOOutConfigDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
      public TinkerGPIOOutConfigDialog(java.awt.Frame parent, boolean modal, String hDir) {
        super(parent, modal);
        hDirectory = hDir;
        
        initComponents();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RadioBtnGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton34 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jRadioButton28 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton36 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton30 = new javax.swing.JRadioButton();
        jRadioButton27 = new javax.swing.JRadioButton();
        jRadioButton38 = new javax.swing.JRadioButton();
        jRadioButton35 = new javax.swing.JRadioButton();
        jRadioButton32 = new javax.swing.JRadioButton();
        jRadioButton29 = new javax.swing.JRadioButton();
        jRadioButton40 = new javax.swing.JRadioButton();
        jRadioButton37 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton31 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jRadioButton39 = new javax.swing.JRadioButton();
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
        jRadioButton33 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DutyCycleTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        DurationTimeTextField = new javax.swing.JTextField();
        GenerateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.title")); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jPanel2.border.title"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jRadioButton8.setBackground(new java.awt.Color(208, 230, 244));
        RadioBtnGroup.add(jRadioButton8);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton8, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton8.text")); // NOI18N
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

        jRadioButton16.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton16);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton16, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton16.text")); // NOI18N
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

        jRadioButton26.setBackground(new java.awt.Color(208, 230, 244));
        RadioBtnGroup.add(jRadioButton26);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton26, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton26.text")); // NOI18N
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

        jRadioButton10.setBackground(new java.awt.Color(208, 230, 244));
        RadioBtnGroup.add(jRadioButton10);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton10, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton10.text")); // NOI18N
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

        jRadioButton18.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton18);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton18, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton18.text")); // NOI18N
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

        jRadioButton34.setBackground(new java.awt.Color(221, 221, 221));
        RadioBtnGroup.add(jRadioButton34);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton34, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton34.text")); // NOI18N
        jRadioButton34.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton34.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton34.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton34StateChanged(evt);
            }
        });
        jRadioButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton34ActionPerformed(evt);
            }
        });

        jRadioButton12.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton12);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton12, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton12.text")); // NOI18N
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
        RadioBtnGroup.add(jRadioButton20);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton20, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton20.text")); // NOI18N
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

        jRadioButton28.setBackground(new java.awt.Color(255, 253, 208));
        RadioBtnGroup.add(jRadioButton28);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton28, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton28.text")); // NOI18N
        jRadioButton28.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton28.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton28.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton28StateChanged(evt);
            }
        });
        jRadioButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton28ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(254, 203, 206));
        RadioBtnGroup.add(jRadioButton2);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton2, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton2.text")); // NOI18N
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
        RadioBtnGroup.add(jRadioButton17);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton17, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton17.text")); // NOI18N
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

        jRadioButton36.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton36);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton36, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton36.text")); // NOI18N
        jRadioButton36.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton36.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton36.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton36StateChanged(evt);
            }
        });
        jRadioButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton36ActionPerformed(evt);
            }
        });

        jRadioButton19.setBackground(new java.awt.Color(208, 230, 244));
        RadioBtnGroup.add(jRadioButton19);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton19, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton19.text")); // NOI18N
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

        jRadioButton30.setBackground(new java.awt.Color(221, 221, 221));
        RadioBtnGroup.add(jRadioButton30);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton30, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton30.text")); // NOI18N
        jRadioButton30.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton30.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton30.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton30StateChanged(evt);
            }
        });
        jRadioButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton30ActionPerformed(evt);
            }
        });

        jRadioButton27.setBackground(new java.awt.Color(255, 253, 208));
        RadioBtnGroup.add(jRadioButton27);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton27, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton27.text")); // NOI18N
        jRadioButton27.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton27.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton27.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton27StateChanged(evt);
            }
        });
        jRadioButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton27ActionPerformed(evt);
            }
        });

        jRadioButton38.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton38);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton38, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton38.text")); // NOI18N
        jRadioButton38.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton38.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton38.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton38StateChanged(evt);
            }
        });
        jRadioButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton38ActionPerformed(evt);
            }
        });

        jRadioButton35.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton35);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton35, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton35.text")); // NOI18N
        jRadioButton35.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton35.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton35.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton35StateChanged(evt);
            }
        });
        jRadioButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton35ActionPerformed(evt);
            }
        });

        jRadioButton32.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton32);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton32, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton32.text")); // NOI18N
        jRadioButton32.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton32.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton32.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton32StateChanged(evt);
            }
        });
        jRadioButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton32ActionPerformed(evt);
            }
        });

        jRadioButton29.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton29);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton29, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton29.text")); // NOI18N
        jRadioButton29.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton29.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton29.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton29StateChanged(evt);
            }
        });
        jRadioButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton29ActionPerformed(evt);
            }
        });

        jRadioButton40.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton40);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton40, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton40.text")); // NOI18N
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

        jRadioButton37.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton37);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton37, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton37.text")); // NOI18N
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

        jRadioButton4.setBackground(new java.awt.Color(254, 203, 206));
        RadioBtnGroup.add(jRadioButton4);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton4, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton4.text")); // NOI18N
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

        jRadioButton31.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton31);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton31, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton31.text")); // NOI18N
        jRadioButton31.setToolTipText(org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton31.toolTipText")); // NOI18N
        jRadioButton31.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton31.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton31.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton31StateChanged(evt);
            }
        });
        jRadioButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton31ActionPerformed(evt);
            }
        });

        jRadioButton22.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton22);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton22, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton22.text")); // NOI18N
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

        jRadioButton39.setBackground(new java.awt.Color(221, 221, 221));
        RadioBtnGroup.add(jRadioButton39);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton39, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton39.text")); // NOI18N
        jRadioButton39.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton39.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton39.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton39StateChanged(evt);
            }
        });
        jRadioButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton39ActionPerformed(evt);
            }
        });

        jRadioButton6.setBackground(new java.awt.Color(221, 221, 221));
        RadioBtnGroup.add(jRadioButton6);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton6, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton6.text")); // NOI18N
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

        jRadioButton21.setBackground(new java.awt.Color(208, 230, 244));
        RadioBtnGroup.add(jRadioButton21);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton21, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton21.text")); // NOI18N
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

        jRadioButton23.setBackground(new java.awt.Color(208, 230, 244));
        RadioBtnGroup.add(jRadioButton23);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton23, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton23.text")); // NOI18N
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

        jRadioButton1.setBackground(new java.awt.Color(254, 203, 206));
        RadioBtnGroup.add(jRadioButton1);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton1, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton1.text")); // NOI18N
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

        jRadioButton3.setBackground(new java.awt.Color(208, 230, 244));
        RadioBtnGroup.add(jRadioButton3);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton3, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton3.text")); // NOI18N
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

        jRadioButton5.setBackground(new java.awt.Color(208, 230, 244));
        RadioBtnGroup.add(jRadioButton5);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton5, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton5.text")); // NOI18N
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

        jRadioButton7.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton7);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton7, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton7.text")); // NOI18N
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
        RadioBtnGroup.add(jRadioButton9);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton9, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton9.text")); // NOI18N
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

        jRadioButton11.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton11);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton11, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton11.text")); // NOI18N
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

        jRadioButton13.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton13);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton13, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton13.text")); // NOI18N
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

        jRadioButton15.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton15);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton15, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton15.text")); // NOI18N
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

        jRadioButton14.setBackground(new java.awt.Color(221, 221, 221));
        RadioBtnGroup.add(jRadioButton14);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton14, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton14.text")); // NOI18N
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

        jRadioButton24.setBackground(new java.awt.Color(208, 230, 244));
        RadioBtnGroup.add(jRadioButton24);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton24, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton24.text")); // NOI18N
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

        jRadioButton25.setBackground(new java.awt.Color(221, 221, 221));
        RadioBtnGroup.add(jRadioButton25);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton25, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton25.text")); // NOI18N
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

        jRadioButton33.setBackground(new java.awt.Color(191, 235, 191));
        RadioBtnGroup.add(jRadioButton33);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton33, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jRadioButton33.text")); // NOI18N
        jRadioButton33.setMaximumSize(new java.awt.Dimension(105, 18));
        jRadioButton33.setMinimumSize(new java.awt.Dimension(105, 18));
        jRadioButton33.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton33StateChanged(evt);
            }
        });
        jRadioButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jRadioButton22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRadioButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
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
                        .addComponent(jRadioButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jRadioButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jPanel3.border.title"))); // NOI18N
        jPanel3.setToolTipText(org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jPanel3.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jLabel1.text")); // NOI18N

        DutyCycleTextField.setText(org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.DutyCycleTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jLabel2.text")); // NOI18N

        DurationTimeTextField.setText(org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.DurationTimeTextField.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(DurationTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DutyCycleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(DutyCycleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(DurationTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(GenerateButton, org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.GenerateButton.text")); // NOI18N
        GenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(GenerateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GenerateButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jPanel2.AccessibleContext.accessibleName")); // NOI18N
        jPanel3.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(TinkerGPIOOutConfigDialog.class, "TinkerGPIOOutConfigDialog.jPanel3.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        num = 1; 
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton1StateChanged

    }//GEN-LAST:event_jRadioButton1StateChanged

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        num = 4;
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton4StateChanged

    }//GEN-LAST:event_jRadioButton4StateChanged

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        num = 6;  
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton6StateChanged
        
    }//GEN-LAST:event_jRadioButton6StateChanged

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        num = 8;
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton8StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton8StateChanged

    }//GEN-LAST:event_jRadioButton8StateChanged

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        num = 10;
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    private void jRadioButton10StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton10StateChanged
       
    }//GEN-LAST:event_jRadioButton10StateChanged

    private void jRadioButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton12ActionPerformed
        num = 12;   
    }//GEN-LAST:event_jRadioButton12ActionPerformed

    private void jRadioButton12StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton12StateChanged
        
    }//GEN-LAST:event_jRadioButton12StateChanged

    private void jRadioButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton14ActionPerformed
        num = 14;  
    }//GEN-LAST:event_jRadioButton14ActionPerformed

    private void jRadioButton14StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton14StateChanged
        
    }//GEN-LAST:event_jRadioButton14StateChanged

    private void jRadioButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton16ActionPerformed
        num = 16; 
    }//GEN-LAST:event_jRadioButton16ActionPerformed

    private void jRadioButton16StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton16StateChanged
       
    }//GEN-LAST:event_jRadioButton16StateChanged

    private void jRadioButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton18ActionPerformed
        num = 18;
    }//GEN-LAST:event_jRadioButton18ActionPerformed

    private void jRadioButton18StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton18StateChanged
       
    }//GEN-LAST:event_jRadioButton18StateChanged

    private void jRadioButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton20ActionPerformed
        num = 20;
    }//GEN-LAST:event_jRadioButton20ActionPerformed

    private void jRadioButton20StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton20StateChanged
        
    }//GEN-LAST:event_jRadioButton20StateChanged

    private void jRadioButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton22ActionPerformed
        num = 22; 
    }//GEN-LAST:event_jRadioButton22ActionPerformed

    private void jRadioButton22StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton22StateChanged
       
    }//GEN-LAST:event_jRadioButton22StateChanged

    private void jRadioButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton24ActionPerformed
        num = 24;
    }//GEN-LAST:event_jRadioButton24ActionPerformed

    private void jRadioButton24StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton24StateChanged
        
    }//GEN-LAST:event_jRadioButton24StateChanged

    private void jRadioButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton26ActionPerformed
        num = 26;
    }//GEN-LAST:event_jRadioButton26ActionPerformed

    private void jRadioButton26StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton26StateChanged
        
    }//GEN-LAST:event_jRadioButton26StateChanged

    private void jRadioButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton28ActionPerformed
        num = 28;
    }//GEN-LAST:event_jRadioButton28ActionPerformed

    private void jRadioButton28StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton28StateChanged
      
    }//GEN-LAST:event_jRadioButton28StateChanged

    private void jRadioButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton30ActionPerformed
        num = 30;
    }//GEN-LAST:event_jRadioButton30ActionPerformed

    private void jRadioButton30StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton30StateChanged
       
    }//GEN-LAST:event_jRadioButton30StateChanged

    private void jRadioButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton32ActionPerformed
        num = 32;
    }//GEN-LAST:event_jRadioButton32ActionPerformed

    private void jRadioButton32StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton32StateChanged
       
    }//GEN-LAST:event_jRadioButton32StateChanged

    private void jRadioButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton34ActionPerformed
        num = 34;
    }//GEN-LAST:event_jRadioButton34ActionPerformed

    private void jRadioButton34StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton34StateChanged
       
    }//GEN-LAST:event_jRadioButton34StateChanged

    private void jRadioButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton36ActionPerformed
        num = 36;
    }//GEN-LAST:event_jRadioButton36ActionPerformed

    private void jRadioButton36StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton36StateChanged
       
    }//GEN-LAST:event_jRadioButton36StateChanged

    private void jRadioButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton38ActionPerformed
        num = 38;
    }//GEN-LAST:event_jRadioButton38ActionPerformed

    private void jRadioButton38StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton38StateChanged
       
    }//GEN-LAST:event_jRadioButton38StateChanged

    private void jRadioButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton40ActionPerformed
        num = 40;
    }//GEN-LAST:event_jRadioButton40ActionPerformed

    private void jRadioButton40StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton40StateChanged
        
    }//GEN-LAST:event_jRadioButton40StateChanged

    private void jRadioButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton39ActionPerformed
        num = 39;
    }//GEN-LAST:event_jRadioButton39ActionPerformed

    private void jRadioButton39StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton39StateChanged
       
    }//GEN-LAST:event_jRadioButton39StateChanged

    private void jRadioButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton37ActionPerformed
        num = 37;
    }//GEN-LAST:event_jRadioButton37ActionPerformed

    private void jRadioButton37StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton37StateChanged
        
    }//GEN-LAST:event_jRadioButton37StateChanged

    private void jRadioButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton35ActionPerformed
        num = 35;
    }//GEN-LAST:event_jRadioButton35ActionPerformed

    private void jRadioButton35StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton35StateChanged
        
    }//GEN-LAST:event_jRadioButton35StateChanged

    private void jRadioButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton31ActionPerformed
        num = 31;
    }//GEN-LAST:event_jRadioButton31ActionPerformed

    private void jRadioButton31StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton31StateChanged
        
    }//GEN-LAST:event_jRadioButton31StateChanged

    private void jRadioButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton33ActionPerformed
        num = 33;
    }//GEN-LAST:event_jRadioButton33ActionPerformed

    private void jRadioButton33StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton33StateChanged
        
    }//GEN-LAST:event_jRadioButton33StateChanged

    private void jRadioButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton29ActionPerformed
        num = 29;
    }//GEN-LAST:event_jRadioButton29ActionPerformed

    private void jRadioButton29StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton29StateChanged
        
    }//GEN-LAST:event_jRadioButton29StateChanged

    private void jRadioButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton27ActionPerformed
        num = 27;
    }//GEN-LAST:event_jRadioButton27ActionPerformed

    private void jRadioButton27StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton27StateChanged
        
    }//GEN-LAST:event_jRadioButton27StateChanged

    private void jRadioButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton25ActionPerformed
        num = 25;
    }//GEN-LAST:event_jRadioButton25ActionPerformed

    private void jRadioButton25StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton25StateChanged
        
    }//GEN-LAST:event_jRadioButton25StateChanged

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

    private void jRadioButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton19ActionPerformed
        num = 19;
    }//GEN-LAST:event_jRadioButton19ActionPerformed

    private void jRadioButton19StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton19StateChanged
        
    }//GEN-LAST:event_jRadioButton19StateChanged

    private void jRadioButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton17ActionPerformed
       num = 17;
    }//GEN-LAST:event_jRadioButton17ActionPerformed

    private void jRadioButton17StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton17StateChanged
        
    }//GEN-LAST:event_jRadioButton17StateChanged

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
        num = 9;
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void jRadioButton9StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton9StateChanged
       
    }//GEN-LAST:event_jRadioButton9StateChanged

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        num = 7;
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton7StateChanged
       
    }//GEN-LAST:event_jRadioButton7StateChanged

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        num = 3;
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton3StateChanged
        
    }//GEN-LAST:event_jRadioButton3StateChanged

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        num = 5;
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton5StateChanged
        
    }//GEN-LAST:event_jRadioButton5StateChanged

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        num = 2;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton2StateChanged
        
    }//GEN-LAST:event_jRadioButton2StateChanged

    private void GenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateButtonActionPerformed
        gpioConfig();
        generateSource();
        cancel();
    }//GEN-LAST:event_GenerateButtonActionPerformed
 
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
            java.util.logging.Logger.getLogger(TinkerGPIOOutConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TinkerGPIOOutConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TinkerGPIOOutConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TinkerGPIOOutConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TinkerGPIOOutConfigDialog dialog = new TinkerGPIOOutConfigDialog(new javax.swing.JFrame(), true);
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
    public void gpioConfig(){
        hIoTGen.set_config(num, Integer.parseInt(DutyCycleTextField.getText()), Integer.parseInt(DurationTimeTextField.getText()),check_flag);
    }
    public void generateSource(){ 
        hIoTGen.initGenerator(hDirectory);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DurationTimeTextField;
    private javax.swing.JTextField DutyCycleTextField;
    private javax.swing.JButton GenerateButton;
    private javax.swing.ButtonGroup RadioBtnGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JRadioButton jRadioButton27;
    private javax.swing.JRadioButton jRadioButton28;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton30;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton33;
    private javax.swing.JRadioButton jRadioButton34;
    private javax.swing.JRadioButton jRadioButton35;
    private javax.swing.JRadioButton jRadioButton36;
    private javax.swing.JRadioButton jRadioButton37;
    private javax.swing.JRadioButton jRadioButton38;
    private javax.swing.JRadioButton jRadioButton39;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton40;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    // End of variables declaration//GEN-END:variables
}
