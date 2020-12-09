/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.Match;
import domain.Selection;
import java.util.List;
import org.apache.log4j.Logger;
import rmi.RMISystemOperation;

/**
 *
 * @author Veljko
 */
public class ServiceUpdateSelection {

    private final RMISystemOperation RMISystemOperation;
    private final Logger Logger = org.apache.log4j.Logger.getLogger(ServiceUpdateSelection.class);

    public ServiceUpdateSelection(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public void updateSelection(Selection selection, List<Match> matches) throws Exception {
        try {
            RMISystemOperation.updateSelection(selection, matches);
        } catch (Exception ex) {
            Logger.error(ex);
            throw ex;
        }
    }
}
