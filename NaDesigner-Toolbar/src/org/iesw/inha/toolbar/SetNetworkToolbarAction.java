package org.iesw.inha.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import org.iesw.inha.generator.HGenerator;
import org.iesw.inha.generator.ai.HSNNGenRun;
import org.iesw.inha.main.dialog.SpikingNeuralNetworkDialog;
import org.iesw.inha.main.dialog.ArtificialNeuralNetworkDialog;
import org.iesw.inha.main.dialog.ParameterWarningDialog;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.netbeans.api.project.Project;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle.Messages;


@ActionID(
        category = "NaDesigner",
        id = "org.iesw.inha.toolbar.SetNetworkToolbarAction"
)
@ActionRegistration(
        iconBase = "org/iesw/inha/toolbar/icons/icon_Net24.png",
        displayName = "#CTL_SetNetworkToolbarAction"
)
@ActionReference(path = "Toolbars/NaDesigner", position = 100)
@Messages("CTL_SetNetworkToolbarAction=Set Network")
public final class SetNetworkToolbarAction implements ActionListener {
    
    private final Project context;
    
    public SetNetworkToolbarAction(Project context) {
        this.context = context;
    }
    
    public static final int H_SNN = 1;
    public static final int H_ANN = 2;
    public static final int H_IoT = 3; 
    
    public static final int H_IoT_Param_Error = 2;    
    
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
        
        if(hState==H_ANN){    
            showArtificialNeuralNetworkDialog(hDir);
        }
        else if(hState==H_SNN){
            showSpikingNeuralNetowrkDialog(hDir);
        }
        else{
            errorCode = H_IoT_Param_Error;
            showParameterWarningDialog(errorCode);
        }
    }
     
    private void showArtificialNeuralNetworkDialog(String hDirectory){
        ArtificialNeuralNetworkDialog dialog = new ArtificialNeuralNetworkDialog(null, true, hDirectory);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    private void showSpikingNeuralNetowrkDialog(String hDirectory){
        SpikingNeuralNetworkDialog dialog = new SpikingNeuralNetworkDialog(null, true, hDirectory);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    private void showParameterWarningDialog(int errorCode){
        ParameterWarningDialog dialog = new ParameterWarningDialog(null, true, errorCode);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    
    }
}