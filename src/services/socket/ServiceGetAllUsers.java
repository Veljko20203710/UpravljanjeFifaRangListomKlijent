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
import static util.Operation.OPERATION_GET_ALL_USERS;

/**
 *
 * @author Veljko
 */
public class ServiceGetAllUsers {

    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private final Logger LOGGER = Logger.getLogger(ServiceGetAllMatches.class);

    public ServiceGetAllUsers(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public List<User> getAll() throws Exception {
        List<User> users;
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(OPERATION_GET_ALL_USERS);
        try {
            out.writeObject(requestObject);
            users = (List<User>) ((ResponseObject) in.readObject()).getData();
            return users;
        } catch (IOException | ClassNotFoundException ex) {
            LOGGER.error(ex.getMessage());
            throw new ServerException();
        }
    }
}
