/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.inha.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.api.project.Project;
import java.io.File;
import org.iesw.inha.generator.HGenerator;
import org.iesw.inha.generator.ai.HSNNGenRun;
import org.iesw.inha.main.dialog.NeuromorphicHWDialog;
import org.iesw.inha.main.dialog.ParameterWarningDialog;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "NaDesigner",
        id = "org.iesw.inha.toolbar.SetNeuromorphicToolbarAction"
)
@ActionRegistration(
        iconBase = "org/iesw/inha/toolbar/icons/icon_Neuro24.png",
        displayName = "#CTL_SetNeuromorphicToolbarAction"
)
@ActionReference(path = "Toolbars/NaDesigner", position = 0)
@Messages("CTL_SetNeuromorphicToolbarAction=Set NeuromorphicHW")
public final class SetNeuromorphicToolbarAction implements ActionListener {
    
    private final Project context;
    
    public SetNeuromorphicToolbarAction(Project context) {
        this.context = context;
    }
    
    public static final int H_SNN = 1;
    public static final int H_ANN = 2;
    public static final int H_IoT = 3; 
    
    public static final int H_NeuroHW_Param_Error = 4;    
    
    private int errorCode=0;
    
    HGenerator hGenerator = new HGenerator();
    HSNNGenRun hSnnGenRun = new HSNNGenRun();
    private String hDir = "";
    private int hState = 0;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        FileObject f = context.getProjectDirectory();
        
        hDir = FileUtil.getFileDisplayName(f);
        
        File hAnnDirectory = new File(hDir + File.separatorChar + "ann");
        File hSnnDirectory = new File(hDir + File.separatorChar + "snn");
        
        if (hAnnDirectory.isDirectory())
            hState = H_ANN;
        else if (hSnnDirectory.isDirectory())
            hState = H_SNN;
        else
            hState = H_IoT;
        
        if(hState==H_SNN){    
            showNeuromorphicHWDialog(hDir);
        }
        else{
            errorCode = H_NeuroHW_Param_Error;
            showParameterWarningDialog(errorCode);
        }
    }
    private void showNeuromorphicHWDialog(String hDirectory){
        NeuromorphicHWDialog dialog = new NeuromorphicHWDialog(null, true, hDirectory);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    private void showParameterWarningDialog(int errorCode){
        ParameterWarningDialog dialog = new ParameterWarningDialog(null, true, errorCode);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    
    }
}
