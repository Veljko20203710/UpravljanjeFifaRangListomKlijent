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
import util.Operation;
import util.ResponseStatus;

/**
 *
 * @author Veljko
 */
public class ServiceSaveSelection {
    
    private final Logger LOGGER = Logger.getLogger(ServiceSaveSelection.class);
    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    
    public ServiceSaveSelection(ObjectOutputStream out, ObjectInputStream in) throws Exception {
        this.out = out;
        this.in = in;
    }
    
    public void saveSelection(Selection selection) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setData(selection);
        requestObject.setOperation(Operation.OPERATION_SAVE_SELECTION);
        try {
            out.writeObject(requestObject);
            ResponseObject responseObject = (ResponseObject) in.readObject();
            if (responseObject.getStatus() == ResponseStatus.ERROR) {
                throw (Exception) responseObject.getData();
            }
        } catch (IOException | ClassNotFoundException ex) {
            LOGGER.error(ex);
            throw new ServerException();
        }
    }
}
