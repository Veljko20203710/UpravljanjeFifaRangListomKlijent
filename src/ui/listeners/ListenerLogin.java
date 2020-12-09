/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listeners;

import controller.Controller;
import exceptions.DeletedUserException;
import exceptions.EmptyUsernameException;
import exceptions.NoSuchUserException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import ui.form.FrmLogin;
import ui.form.FrmMain;

/**
 *
 * @author Veljko
 */
public class ListenerLogin implements ActionListener {

    private final FrmLogin frmLogin;
    private final ResourceBundle resourceBundle;
    private final Logger LOGGER = Logger.getLogger(ListenerLogin.class);

    public ListenerLogin(FrmLogin frmLogin) {
        this.frmLogin = frmLogin;
        this.resourceBundle = frmLogin.getResourceBundle();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String username = String.valueOf(frmLogin.getPanelUsername().getValue());
            String password = String.valueOf(frmLogin.getPanelPassword().getValue());
            Controller.getInstance().login(username, password);
            frmLogin.setVisible(false);
            new FrmMain().setVisible(true);
        } catch (EmptyUsernameException ex) {
            String message = resourceBundle.getString("EmptyUsername");
            JOptionPane.showMessageDialog(frmLogin, message, resourceBundle.getString("title"),
                    1);
        } catch (NoSuchUserException ex) {
            String message = resourceBundle.getString("NoSuchUserException");
            JOptionPane.showMessageDialog(frmLogin, message, resourceBundle.getString("title"),
                    1);
        } catch (DeletedUserException ex) {
            String message = resourceBundle.getString("DeletedUserException");
            JOptionPane.showMessageDialog(frmLogin, message);
        } catch (Exception ex) {
            String message = resourceBundle.getString("Error");
            JOptionPane.showMessageDialog(frmLogin, message);
            LOGGER.error(ex);
        }
    }
}
