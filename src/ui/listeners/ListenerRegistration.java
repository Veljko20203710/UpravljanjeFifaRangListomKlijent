/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listeners;

import controller.Controller;
import exceptions.BusyUsernameException;
import exceptions.DifferentPasswordException;
import exceptions.ShortPasswordException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import ui.form.FrmLogin;
import ui.form.FrmRegistration;

/**
 *
 * @author veljko
 */
public class ListenerRegistration implements ActionListener {

    private final FrmRegistration frmRegistration;
    private String username;
    private String password;
    private String password2;
    private final ResourceBundle resourceBundle;

    public ListenerRegistration(FrmRegistration frmRegistration) {
        this.frmRegistration = frmRegistration;
        resourceBundle = frmRegistration.getResourceBundle();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            username = (String) frmRegistration.getPanelInputUsername().getValue();
            password = (String) frmRegistration.getPanelInputPasswordFirstTime().getValue();
            password2 = (String) frmRegistration.getPanelInputPasswordSecondTime().getValue();
            checkPasswords();
            Controller.getInstance().register(username, password);
            JOptionPane.showMessageDialog(frmRegistration, resourceBundle.getString("message"), resourceBundle.getString("title"), 1);
            frmRegistration.dispose();
            new FrmLogin().setVisible(true);
        } catch (BusyUsernameException ex) {
            String errorMessage = resourceBundle.getString("busyUsernameException");
            frmRegistration.getPanelInputPasswordSecondTime().getLblFieldError().setText(errorMessage);
        } catch (ShortPasswordException ex) {
            String errorMessage = resourceBundle.getString("shortPasswordException");
            frmRegistration.getPanelInputPasswordSecondTime().getLblFieldError().setText(errorMessage);
        } catch (DifferentPasswordException ex) {
            String errorMessage = resourceBundle.getString("differentPasswordException");
            frmRegistration.getPanelInputPasswordSecondTime().getLblFieldError().setText(errorMessage);
        } catch (Exception ex) {
            String errorMessage = resourceBundle.getString("error");
            frmRegistration.getPanelInputPasswordSecondTime().getLblFieldError().setText(errorMessage);
        }
    }

    private void checkPasswords() throws Exception {
        if (password.length() < 6) {
            throw new ShortPasswordException();
        }
        if (!password.equals(password2)) {
            throw new DifferentPasswordException();
        }
    }

}
