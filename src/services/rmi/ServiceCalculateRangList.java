/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import org.apache.log4j.Logger;
import rmi.RMISystemOperation;

/**
 *
 * @author Veljko
 */
public class ServiceCalculateRangList {

    private final RMISystemOperation RMISystemOperation;
    private final Logger LOGGER = Logger.getLogger(ServiceCalculateRangList.class);

    public ServiceCalculateRangList(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public void calculateRangList() throws Exception {
        try {
            RMISystemOperation.calculateRangList();
        } catch (Exception ex) {
            LOGGER.error(ex);
            throw ex;
        }
    }

}
