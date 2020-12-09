/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import controller.Controller;
import domain.Selection;
import domain.User;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import ui.form.FrmViewRangList;

/**
 *
 * @author Veljko
 */
public class ListenerDeleteSelection implements ActionListener {

    private final FrmViewRangList frmViewRangList;
    private ResourceBundle resourceBundle;
    private final Logger LOGGER = Logger.getLogger(ListenerDeleteSelection.class);

    public ListenerDeleteSelection(FrmViewRangList frmViewRangList) {
        this.frmViewRangList = frmViewRangList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = frmViewRangList.getjTableRangList().getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        resourceBundle = frmViewRangList.getResourceBundle();
        Object[] options = {resourceBundle.getString("PermenanentlyDelete"), resourceBundle.getString("Deactive"), resourceBundle.getString("Cancel")};
        int option = JOptionPane.showOptionDialog(frmViewRangList, resourceBundle.getString("Message"), resourceBundle.getString("Title"),
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]);
        if (option == 0) {
            deleteSelection();
        }
        if (option == 1) {
            deactiveSelection();
        }
        frmViewRangList.setTable();
    }

    private void deleteSelection() {
        Selection selection = frmViewRangList.getSelections().get(frmViewRangList.getjTableRangList().getSelectedRow() + frmViewRangList.getStartPositon());
        try {
            Controller.getInstance().deleteSelection(selection);
            frmViewRangList.removeSelection(selection);
            JOptionPane.showMessageDialog(frmViewRangList, resourceBundle.getString("sucesfullyDeleted"));
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            JOptionPane.showMessageDialog(frmViewRangList, resourceBundle.getString("ussucesfullyDeleted"));
        }
    }

    private void deactiveSelection() {
        try {
            Selection selection = frmViewRangList.getSelections().get(frmViewRangList.getjTableRangList().getSelectedRow() + frmViewRangList.getStartPositon());
            selection.setUser(new User(Controller.getInstance().readId(), Controller.getInstance().readUsername()));
            Controller.getInstance().deactivateSelection(selection);
            JOptionPane.showMessageDialog(frmViewRangList, resourceBundle.getString("sucesfullyDeactivated"));
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            JOptionPane.showMessageDialog(frmViewRangList, resourceBundle.getString("unsucesfullyDeactivated"));
        }
    }
}
