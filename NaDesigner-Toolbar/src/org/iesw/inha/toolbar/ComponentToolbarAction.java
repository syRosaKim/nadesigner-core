package org.iesw.inha.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import org.iesw.inha.main.dialog.ComponentConfigDialog;
import org.iesw.inha.main.dialog.ParameterWarningDialog;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "NaDesigner",
        id = "org.iesw.inha.toolbar.ComponentToolbarAction"
)
@ActionRegistration(
        iconBase = "org/iesw/inha/toolbar/icons/icon_Comp24.png",
        displayName = "#CTL_ComponentToolbarAction"
)
@ActionReference(path = "Toolbars/NaDesigner", position = 300)
@Messages("CTL_ComponentToolbarAction=ComponentToolbarAction")
public final class ComponentToolbarAction implements ActionListener {
    
    private final Project context;
    
    public static final int H_SNN = 1;    
    public static final int H_ANN = 2;   
    public static final int H_IoT = 3;  

    public static final int HNUM_PRJ = 1; 
    public static final int HNUM_DIAL = 2; 
        
    public static final int H_UI_Error = 3;
    
    private String hDir = "";
    private int hState = 0;
    private String compRuntime=null;
    
    private int errorCode=0;

    public ComponentToolbarAction(Project context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        FileObject f = context.getProjectDirectory();
        
        hDir = FileUtil.getFileDisplayName(f);  
        
        File hAnnDirectory = new File(hDir + File.separatorChar + "ann");
        File hSnnDirectory = new File(hDir + File.separatorChar + "snn");
        File hIoTDirectory = new File(hDir + File.separatorChar + "iot");
        String[] runtimeFiles;
                
        if (hAnnDirectory.isDirectory()){
            hState = H_ANN;
            runtimeFiles = hAnnDirectory.list(); 
        }
        else if (hSnnDirectory.isDirectory()){
            hState = H_SNN;
            runtimeFiles = hSnnDirectory.list();
        }
        else{
            hState = H_IoT;
            runtimeFiles = hIoTDirectory.list();
        }
        
        if(runtimeFiles.length == 0){
            errorCode=H_UI_Error;
            showParameterWarningDialog(errorCode);
        }
        else 
            {
                compRuntime = runtimeFiles[0];
                showComponentConfigDialog();
            }
        
    }
    
    private void showComponentConfigDialog(){
        ComponentConfigDialog dialog = new ComponentConfigDialog(null, true, hState, HNUM_DIAL, hDir, compRuntime);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    private void showParameterWarningDialog(int errorCode){
        ParameterWarningDialog dialog = new ParameterWarningDialog(null, true, errorCode);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    
    }
    
}
