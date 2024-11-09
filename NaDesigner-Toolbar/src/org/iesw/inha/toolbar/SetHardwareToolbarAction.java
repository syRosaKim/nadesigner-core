/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.inha.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "NaDesigner",
        id = "org.iesw.inha.toolbar.SetHardwareToolbarAction"
)
@ActionRegistration(
        iconBase = "org/iesw/inha/toolbar/icons/icon_Hw24_v2.png",
        displayName = "#CTL_SetHardwareToolbarAction"
)
@ActionReference(path = "Toolbars/NaDesigner", position = 200)
@Messages("CTL_SetHardwareToolbarAction=Set Hardware")
public final class SetHardwareToolbarAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
