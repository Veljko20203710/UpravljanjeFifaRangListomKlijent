/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.User;
import exceptions.ServerException;
import java.util.List;
import org.apache.log4j.Logger;
import rmi.RMISystemOperation;

/**
 *
 * @author Veljko
 */
public class ServiceGetAllUsers {

    private final RMISystemOperation RMISystemOperation;
    private final Logger Logger = org.apache.log4j.Logger.getLogger(ServiceGetAllUsers.class);

    public ServiceGetAllUsers(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public List<User> getAll() throws Exception {
        try {
            return RMISystemOperation.getAllUsers();
        } catch (Exception ex) {
            Logger.error(ex);
            throw ex;
        }
    }
}


