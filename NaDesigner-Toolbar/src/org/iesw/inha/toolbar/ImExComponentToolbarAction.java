package org.iesw.inha.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import org.iesw.inha.main.dialog.ComponentPortStateDialog;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "NaDesigner",
        id = "org.iesw.inha.toolbar.ImExComponentToolbarAction"
)
@ActionRegistration(
        iconBase = "org/iesw/inha/toolbar/icons/icon_comp_IO24.png",
        displayName = "#CTL_ImExComponentToolbarAction"
)
@ActionReference(path = "Toolbars/NaDesigner", position = 400)
@Messages("CTL_ImExComponentToolbarAction=Impot/Export Component")
public final class ImExComponentToolbarAction implements ActionListener {

    private final Project context;
    
    public static final int IMPORT_SUCCESS = 1; 
    public static final int EXPORT_SUCCESS = 2;
    public static final int PORT_FAIL = 3;
    
    private String hDir = "";

    public ImExComponentToolbarAction(Project context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        FileObject f = context.getProjectDirectory();
        
        hDir = FileUtil.getFileDisplayName(f); 
        
        
        portComponentManifestFile();
    }
    
    private void portComponentManifestFile(){
        
        File manifestDir = new File(hDir + File.separatorChar + "src" + File.separatorChar + "package.json");
        File portManifest = new File(hDir + File.separatorChar + "package.json");
        int portState = 0;
        if(manifestDir.exists()){
            
            boolean exportManifestState = manifestDir.renameTo(portManifest);
            if(exportManifestState)
                portState = EXPORT_SUCCESS;
            else
                portState = PORT_FAIL;
        }
        else{
            boolean importManifestState = portManifest.renameTo(manifestDir);
            if(importManifestState)
                portState = IMPORT_SUCCESS;
            else
                portState = PORT_FAIL;
        }
        showComponentPortStateDialog(portState);
    }
    
    private void showComponentPortStateDialog(int state){
        ComponentPortStateDialog dialog = new ComponentPortStateDialog(null, true, state);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
