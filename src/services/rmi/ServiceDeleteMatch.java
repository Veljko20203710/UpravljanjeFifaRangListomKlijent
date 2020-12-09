/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.Match;
import org.apache.log4j.Logger;
import rmi.RMISystemOperation;

/**
 *
 * @author Veljko
 */
public class ServiceDeleteMatch {

    private final RMISystemOperation RMISystemOperation;
    private final Logger Logger = org.apache.log4j.Logger.getLogger(ServiceDeleteMatch.class);

    public ServiceDeleteMatch(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public void deleteMatch(Match match) throws Exception {
        try {
            RMISystemOperation.deleteMatch(match);
        } catch (Exception ex) {
            Logger.error(ex);
            throw ex;
        }
    }
}
