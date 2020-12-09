/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.socket;

import domain.Match;
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
 * @author veljko
 */
public class ServiceSaveMatch {

    private final Logger LOGGER = Logger.getLogger(ServiceSaveMatch.class);
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public ServiceSaveMatch(ObjectOutputStream out, ObjectInputStream in)throws Exception {
        this.out = out;
        this.in = in;
    }

    public void saveMatch(Match match) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(OPERATION_SAVE_MATCH);
        requestObject.setData(match);      
        try {
            out.writeObject(requestObject);
            ResponseObject responseObject = (ResponseObject) in.readObject();
            if (responseObject.getStatus() == ResponseStatus.ERROR) throw new ServerException();
        } catch (IOException | ClassNotFoundException ex) {
            LOGGER.error(ex.getMessage());
            throw ex;
        }
    }
}
