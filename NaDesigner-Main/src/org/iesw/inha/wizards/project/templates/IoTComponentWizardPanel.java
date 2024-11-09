package org.iesw.inha.wizards.project.templates;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.iesw.inha.generator.iot.HIoTGenRun;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;

public class IoTComponentWizardPanel implements WizardDescriptor.Panel,
        WizardDescriptor.ValidatingPanel, WizardDescriptor.FinishablePanel {

    private WizardDescriptor wizardDescriptor;
    private IoTComponentPanelVisual component;
      private int hTestint = 0;
    private HIoTGenRun hIoTGRun = new HIoTGenRun();

    public IoTComponentWizardPanel() {
    }

    public Component getComponent() {
        if (component == null) {
            component = new IoTComponentPanelVisual(this);
            component.setName(NbBundle.getMessage(IoTComponentWizardPanel.class, "LBL_CreateProjectStep"));
        }
        return component;
    }

    public HelpCtx getHelp() {
        return new HelpCtx(IoTComponentWizardPanel.class);
    }

    public boolean isValid() {
        getComponent();
        return component.valid(wizardDescriptor);
    }

    private final Set<ChangeListener> listeners = new HashSet<ChangeListener>(1); // or can use ChangeSupport in NB 6.0

    public final void addChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.add(l);
        }
    }

    public final void removeChangeListener(ChangeListener l) {
        synchronized (listeners) {
            listeners.remove(l);
        }
    }

    protected final void fireChangeEvent() {
        Set<ChangeListener> ls;
        synchronized (listeners) {
            ls = new HashSet<ChangeListener>(listeners);
        }
        ChangeEvent ev = new ChangeEvent(this);
        for (ChangeListener l : ls) {
            l.stateChanged(ev);
        }
    }

    public void readSettings(Object settings) {
        wizardDescriptor = (WizardDescriptor) settings;
        component.read(wizardDescriptor);
    }

    public void storeSettings(Object settings) {
        WizardDescriptor d = (WizardDescriptor) settings;
        component.store(d);
        if(hTestint == 1){ 
            hGenTest();
        }
        hTestint++;
    }

    public boolean isFinishPanel() {
        return true;
    }

    public void validate() throws WizardValidationException {
        getComponent();
        component.validate(wizardDescriptor);
    }
    public void hGenTest(){
        hIoTGRun.initRun(component.hComponentCategory);
        hIoTGRun.iotRun();
    }
}
