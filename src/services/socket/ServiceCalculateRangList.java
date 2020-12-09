/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.socket;

import exceptions.ServerException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.log4j.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import static util.Operation.OPERATION_CALCULATE_RANGLIST;
import util.ResponseStatus;

/**
 *
 * @author Veljko
 */
public class ServiceCalculateRangList {

    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private final Logger LOGGER = Logger.getLogger(ServiceDeactivateSelection.class);

    public ServiceCalculateRangList(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public void calculateRangList() throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(OPERATION_CALCULATE_RANGLIST);
        try {
            out.writeObject(requestObject);
            ResponseObject responseObject = (ResponseObject) in.readObject();
            if(responseObject.getStatus() == ResponseStatus.ERROR) throw new ServerException();
        } catch (IOException | ClassNotFoundException ex) {
            LOGGER.error(ex.getMessage());
            throw ex;
        }
    }
}
