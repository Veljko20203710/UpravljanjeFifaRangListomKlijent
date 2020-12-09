/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.User;
import java.util.List;
import org.apache.log4j.Logger;
import rmi.RMISystemOperation;

/**
 *
 * @author Veljko
 */
public class ServiceUpdateUsers {
    
     private final RMISystemOperation RMISystemOperation;
    private final Logger Logger = org.apache.log4j.Logger.getLogger(ServiceUpdateUsers.class);

    public ServiceUpdateUsers(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public void updateUsers(List<User> users) throws Exception {
        try {
            RMISystemOperation.updateUsers(users);
        } catch (Exception ex) {
            Logger.error(ex);
            throw ex;
        }
    }
    
}
