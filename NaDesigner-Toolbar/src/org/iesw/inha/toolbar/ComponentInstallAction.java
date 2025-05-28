package org.iesw.inha.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "NaDesigner",
        id = "org.embedded.hnu.toolbar.ComponentInstallAction"
)
@ActionRegistration(
        displayName = "#CTL_ComponentInstallAction"
)
@ActionReference(path = "Menu/Install", position = 100)
@Messages("CTL_ComponentInstallAction=Component Install")
public final class ComponentInstallAction implements ActionListener {

    private final Project context;

    public ComponentInstallAction(Project context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        String projDir = FileUtil.getFileDisplayName(context.getProjectDirectory());
        String[] cmd = new String[]{"cmd", "/c", "c:&cd/&cd "+projDir+"&npm install"}; 
        String str = null;
        
        Process process;
        
        try{
            process = new ProcessBuilder(cmd).start();
            BufferedReader stdOut = new BufferedReader( new InputStreamReader(process.getInputStream()) );
            while( (str = stdOut.readLine()) != null ) {
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

