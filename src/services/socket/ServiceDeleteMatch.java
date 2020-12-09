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
import util.ResponseStatus;
import static util.Operation.*;

/**
 *
 * @author Veljko
 */
public class ServiceDeleteMatch {

    private static final Logger LOGGER = Logger.getLogger(ServiceDeleteMatch.class);
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public ServiceDeleteMatch(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public void deleteMatch(Match match) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setData(match);
        requestObject.setOperation(OPERATION_DELETE_MATCH);
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
