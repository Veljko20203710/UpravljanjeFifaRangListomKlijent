/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.Match;
import domain.Selection;
import exceptions.ServerException;
import java.util.List;
import org.apache.log4j.Logger;
import rmi.RMISystemOperation;

/**
 *
 * @author Veljko
 */
public class ServiceGetAllMatches {
    
    private final RMISystemOperation RMISystemOperation;
    private final Logger Logger = org.apache.log4j.Logger.getLogger(ServiceGetAllMatches.class);

    public ServiceGetAllMatches(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public List<Match> getAllMatches(Selection selection) throws Exception {
        try {
            return RMISystemOperation.getMatchesBySelection(selection);
        } catch (Exception ex) {
            Logger.error(ex);
            throw ex;
        }
    }
}
