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
import org.apache.log4j.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import static util.Operation.*;
import util.ResponseStatus;

/**
 *
 * @author Veljko
 */
public class ServiceDeleteSelection {

    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private static final Logger LOGGER = Logger.getLogger(ServiceDeleteSelection.class);

    public ServiceDeleteSelection(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream) {
        this.out = objectOutputStream;
        this.in = objectInputStream;
    }

    public void deleteSelection(Selection selection) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(OPERATION_DELETE_SELECTION);
        requestObject.setData(selection);
        try {
            out.writeObject(requestObject);
            ResponseObject responseObject = (ResponseObject) in.readObject();
            if (responseObject.getStatus() == ResponseStatus.ERROR) {
                throw new ServerException();
            }
        } catch (IOException | ClassNotFoundException ex) {
            LOGGER.error(ex.getMessage());
            throw ex;
        }

    }

}
