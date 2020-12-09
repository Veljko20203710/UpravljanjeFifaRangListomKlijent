/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listeners;

import controller.Controller;
import domain.Confederation;
import domain.Selection;
import domain.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import ui.form.FrmChangeSelection;

/**
 *
 * @author Veljko
 */
public class ListenerChangeSelection implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        setSelectionProperties();
        updateSelection();
    }

    private ResourceBundle resourceBundle;
    private final FrmChangeSelection FRM_CHANGE_SELECTION;

    private Selection selection;

    private final Logger LOGGER = Logger.getLogger(ListenerChangeSelection.class);

    public ListenerChangeSelection(FrmChangeSelection frmChangeSelection) {
        this.FRM_CHANGE_SELECTION = frmChangeSelection;
        initResourceBundle();
    }

    private void setSelectionProperties() {
        try {
            selection = FRM_CHANGE_SELECTION.getSelection();
            selection.setName((String) FRM_CHANGE_SELECTION.getPanelInputName().getValue());
            selection.setConfederation((Confederation) (FRM_CHANGE_SELECTION.getPanelInputConfederation().getValue()));
            selection.setUser(new User(Controller.getInstance().readId(), Controller.getInstance().readUsername()));
        } catch (Exception ex) {
            LOGGER.error(ex);
        }

    }

    private void updateSelection() {
        try {
            Controller.getInstance().updateSelection(selection, FRM_CHANGE_SELECTION.getMatches());
            JOptionPane.showMessageDialog(FRM_CHANGE_SELECTION, resourceBundle.getString("SuccesfullUpdated"), resourceBundle.getString("Title"),
                    1);
            FRM_CHANGE_SELECTION.dispose();
        } catch (Exception ex) {
            LOGGER.error(ex);
            JOptionPane.showMessageDialog(FRM_CHANGE_SELECTION, resourceBundle.getString("UnsuseccsfullUpdated"), resourceBundle.getString("Title"),
                    1);
        }
    }

    private void initResourceBundle() {
        resourceBundle = FRM_CHANGE_SELECTION.getResourceBundle();
    }

}
