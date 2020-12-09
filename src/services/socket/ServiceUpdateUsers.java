/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.socket;

import domain.User;
import exceptions.ServerException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import org.apache.log4j.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import static util.Operation.OPERATION_UPDATE_USERS;
import util.ResponseStatus;

/**
 *
 * @author Veljko
 */
public class ServiceUpdateUsers {

    private final Logger LOGGER = Logger.getLogger(ServiceUpdateUsers.class);
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public ServiceUpdateUsers(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public void updateUsers(List<User> users) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(OPERATION_UPDATE_USERS);
        requestObject.setData(users);
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
