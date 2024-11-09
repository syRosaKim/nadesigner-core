package org.iesw.inha.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import static org.iesw.inha.main.dialog.SpikingNeuralNetworkDialog.userDir;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "NaDesigner",
        id = "org.iesw.inha.toolbar.InstallToNodeREDAction"
)
@ActionRegistration(
        displayName = "#CTL_InstallToNodeREDAction"
)
@ActionReference(path = "Menu/Install", position = 200)
@Messages("CTL_InstallToNodeREDAction=Install to Node-RED")
public final class InstallToNodeREDAction implements ActionListener {

    private final Project context;

    public InstallToNodeREDAction(Project context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        String projDir = FileUtil.getFileDisplayName(context.getProjectDirectory());
        String noderedDir = userDir + File.separatorChar + ".node-red";
        String noderedStartDir = userDir + File.separatorChar + "node-red";
        String[] cmd = new String[]{"cmd", "/c", "c:&cd/&cd "+noderedDir+"&npm install "+projDir};
        
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
