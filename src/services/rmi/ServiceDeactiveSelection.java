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
public class ServiceDeactiveSelection {
    private final RMISystemOperation RMISystemOperation;
    private final Logger LOGGER = Logger.getLogger(ServiceDeactiveSelection.class);

    public ServiceDeactiveSelection(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public void deactiveSelection(Selection selection) throws Exception {
        try {
            RMISystemOperation.deactiveSelection(selection);
        } catch (Exception ex) {
            LOGGER.error(ex);
            throw ex;
        }
    }
}
