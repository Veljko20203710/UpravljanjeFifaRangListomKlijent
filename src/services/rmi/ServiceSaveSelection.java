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
public class ServiceSaveSelection {

    private final RMISystemOperation RMISystemOperation;
    private final Logger Logger = org.apache.log4j.Logger.getLogger(ServiceSaveSelection.class);

    public ServiceSaveSelection(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public void saveSelection(Selection selection) throws Exception {
        try {
            RMISystemOperation.saveSelection(selection);
        } catch (Exception ex) {
            Logger.error(ex);
            throw ex;
        }
    }
}
