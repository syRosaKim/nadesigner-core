package org.iesw.inha.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import org.iesw.inha.generator.HGenerator;
import org.iesw.inha.generator.iot.HIoTGenRun;
import org.iesw.inha.main.dialog.ArtificialNeuralNetworkDialog;
import org.iesw.inha.main.dialog.IoTDialog;
import org.iesw.inha.main.dialog.ParameterWarningDialog;
import org.iesw.inha.main.dialog.SpikingNeuralNetworkDialog;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "NaDesigner",
        id = "org.iesw.inha.toolbar.SetIoTToolbarAction"
)
@ActionRegistration(
        iconBase = "org/iesw/inha/toolbar/icons/icon_IoT24_v2.png",
        displayName = "#CTL_SetIoTToolbarAction"
)
@ActionReference(path = "Toolbars/NaDesigner", position = 150)
@Messages("CTL_SetIoTToolbarAction=Set IoT")
public final class SetIoTToolbarAction implements ActionListener {
    
    private final Project context;
    
    public SetIoTToolbarAction(Project context){
        this.context = context;
    }
    public static final int H_SNN = 1;
    public static final int H_ANN = 2;
    public static final int H_IoT = 3; 
    
    public static final int H_NN_Param_Error = 1; 
    
    private int errorCode=0;
    
    HGenerator hGenerator = new HGenerator();
    HIoTGenRun hIotGenRun = new HIoTGenRun();
    private String hDir = "";
    private int hState = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        
        FileObject f = context.getProjectDirectory();
        
        hDir = FileUtil.getFileDisplayName(f); 
        
        File hAnnDirectory = new File(hDir + File.separatorChar + "ann");
        File hSnnDirectory = new File(hDir + File.separatorChar + "snn");
        File hIotDirectory = new File(hDir + File.separatorChar + "iot");
        
        hState = (hAnnDirectory.isDirectory()) ? H_ANN : ((hSnnDirectory.isDirectory())) ? H_SNN :((hIotDirectory.isDirectory()) ? H_IoT: 0); 
        
        if(hState==H_IoT){
            showIoTDialog(hDir);
        }
        else{
            errorCode=H_NN_Param_Error;
            showParameterWarningDialog(H_NN_Param_Error);
        }
    }
    private void showParameterWarningDialog(int errorCode){
        ParameterWarningDialog dialog = new ParameterWarningDialog(null, true, errorCode);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    
    }
    private void showIoTDialog(String hDirectory){
        IoTDialog dialog = new IoTDialog(null, true, hDirectory);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
