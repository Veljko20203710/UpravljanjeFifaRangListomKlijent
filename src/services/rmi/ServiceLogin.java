/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.User;
import exceptions.DeletedUserException;
import exceptions.NoSuchUserException;
import org.apache.log4j.Logger;
import rmi.RMISystemOperation;
import services.common.ServiceCryptPassword;
import services.common.SystemDetails;

/**
 *
 * @author Veljko
 */
public class ServiceLogin {

    private final RMISystemOperation RMISystemOperation;
    private final Logger Logger = org.apache.log4j.Logger.getLogger(ServiceLogin.class);

    public ServiceLogin(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public void login(String username, String password) throws Exception {
        User user = RMISystemOperation.login(username, ServiceCryptPassword.cryptPassword(password));
        if (user == null) {
            Logger.info("Login with wrong username or password");
            throw new NoSuchUserException();
        } else if (!user.isActive()) {
            Logger.info("Deleted user " + username + " trying to login.");
            throw new DeletedUserException();
        }
        writeSystemDetails(user);
        
    }

    private void writeSystemDetails(User user) throws Exception {
        Logger.info("Succesfull login by " + user.getUsername());
        SystemDetails.writeUser(user.getUsername());
        SystemDetails.writeUserId(user.getId() + "");
        SystemDetails.writeAdministator(user.isAdministator());
    }
}
