/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.MatchType;
import java.util.List;
import org.apache.log4j.Logger;
import rmi.RMISystemOperation;

/**
 *
 * @author Veljko
 */
public class ServiceGetAllMatchTypes {

    private final RMISystemOperation RMISystemOperation;
    private final Logger LOGGER =  Logger.getLogger(ServiceGetAllConfederations.class);

    public ServiceGetAllMatchTypes(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public  List<MatchType> getAll() throws Exception {
        try {
            return RMISystemOperation.getAllMatchTypes();
        } catch (Exception ex) {
            LOGGER.error(ex);
            throw ex;
        }
    }
}
