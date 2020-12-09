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
public class ServiceRangLista {

    private final RMISystemOperation RMISystemOperation;
    private final Logger Logger = org.apache.log4j.Logger.getLogger(ServiceRangLista.class);

    public ServiceRangLista(RMISystemOperation RMISystemOperation) {
        this.RMISystemOperation = RMISystemOperation;
    }

    public List<Selection> getRangList() throws Exception {
        try {
            return RMISystemOperation.getRangList();
        } catch (Exception ex) {
            Logger.error(ex);
            throw ex;
        }
    }
}
