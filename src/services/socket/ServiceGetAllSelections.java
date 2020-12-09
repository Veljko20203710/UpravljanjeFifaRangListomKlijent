/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.socket;

import domain.Selection;
import exceptions.ServerException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import org.apache.log4j.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;

/**
 *
 * @author Veljko
 */
public class ServiceGetAllSelections {

    private final Logger LOGGER = Logger.getLogger(ServiceGetAllSelections.class);
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public ServiceGetAllSelections(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public List<Selection> getAllSelections() throws ServerException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_ALL_SELECTIONS);
        List<Selection> selections;

        try {
            out.writeObject(requestObject);
            ResponseObject responseObject = (ResponseObject) in.readObject();
            selections = (List<Selection>) responseObject.getData();
            return selections;
        } catch (IOException | ClassNotFoundException ex) {
            LOGGER.error(ex.getMessage());
            throw new ServerException();
        }
    }
}
