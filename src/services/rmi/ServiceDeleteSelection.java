/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.Selection;
import org.apache.log4j.Logger;
import rmi.RMISystemOperation;

/**
 *
 * @author Veljko
 */
public class ServiceDeleteSelection {

    private final RMISystemOperation RMISystemOperation;
    private final Logger LOGGER = org.apache.log4j.Logger.getLogger(ServiceDeleteSelection.class);

    public ServiceDeleteSelection(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public void deleteSelection(Selection selection) throws Exception {
        try {
            RMISystemOperation.deleteSelection(selection);
        } catch (Exception ex) {
            LOGGER.error(ex);
            throw ex;
        }
    }
}
