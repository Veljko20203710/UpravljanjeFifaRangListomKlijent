/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.Selection;
import exceptions.ServerException;
import java.util.List;
import org.apache.log4j.Logger;
import rmi.RMISystemOperation;

/**
 *
 * @author Veljko
 */
public class ServiceAllSelections {

    private final RMISystemOperation RMISystemOperation;
    private final Logger LOGGER = Logger.getLogger(ServiceAllSelections.class);

    public ServiceAllSelections(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public List<Selection> getAllSelections() throws Exception {
        try {
            return RMISystemOperation.getAllSelection();
        } catch (Exception ex) {
            LOGGER.error(ex);
            throw new ServerException();
        }
    }
}
