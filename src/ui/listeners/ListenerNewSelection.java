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
import exceptions.SavedSelectionException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import ui.form.FrmNewSelection;

/**
 *
 * @author veljko
 */
public class ListenerNewSelection implements ActionListener {

    private final FrmNewSelection frmNewSelection;
    private String selectionName;
    private final Logger LOGGER = Logger.getLogger(ListenerNewSelection.class);
    private ResourceBundle resourceBundle;

    public ListenerNewSelection(FrmNewSelection frmNewSelection) {
        this.frmNewSelection = frmNewSelection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            readSelectionName();
            resourceBundle = frmNewSelection.getResourceBundle();

            Selection selection = new Selection(selectionName);
            selection.setConfederation((Confederation) frmNewSelection.getPanelInputConfederation().getValue());
            selection.setUser(new User(Controller.getInstance().readId(), Controller.getInstance().readUsername()));

            Controller.getInstance().saveSelection(selection);
            JOptionPane.showMessageDialog(frmNewSelection, resourceBundle.getString("SuccesfullAdded"), resourceBundle.getString("Title"),
                    1);
            frmNewSelection.setVisible(false);
        } catch (SavedSelectionException ex) {
            JOptionPane.showMessageDialog(frmNewSelection, resourceBundle.getString("AlreadySaved"), resourceBundle.getString("Title"),
                    1);
            LOGGER.info(ex.getMessage());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frmNewSelection, resourceBundle.getString("UnsuseccsfullAdded"), resourceBundle.getString("Title"),
                    1);
            LOGGER.error(ex.getMessage());
        }

    }

    private void readSelectionName() throws Exception {
        selectionName = (String) frmNewSelection.getPanelInputName().getValue();
    }
}
