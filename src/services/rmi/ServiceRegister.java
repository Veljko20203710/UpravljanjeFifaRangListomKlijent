/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import org.apache.log4j.Logger;
import rmi.RMISystemOperation;
import services.common.ServiceCryptPassword;

/**
 *
 * @author Veljko
 */
public class ServiceRegister {

    private final RMISystemOperation RMISystemOperation;
    private final Logger Logger = org.apache.log4j.Logger.getLogger(ServiceRegister.class);

    public ServiceRegister(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public void Register(String username, String password) throws Exception {
        try {
            RMISystemOperation.register(username, ServiceCryptPassword.cryptPassword(password));
        } catch (Exception ex) {
            Logger.error(ex);
            throw ex;
        }
    }
}
