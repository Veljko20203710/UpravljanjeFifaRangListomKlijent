/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.socket;

import domain.User;
import exceptions.DeletedUserException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import services.common.SystemDetails;
import transfer.RequestObject;
import transfer.ResponseObject;
import static util.Operation.OPERATION_LOGIN;
import util.ResponseStatus;

/**
 *
 * @author Veljko
 */
public class ServiceLogin {

    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private final Logger LOGGER = Logger.getLogger(ServiceLogin.class);

    public ServiceLogin(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public void loginUser(String username, String password) throws Exception {
        RequestObject requestObject = new RequestObject();
        Map<String, String> userMap = new HashMap<>();
        User user;

        userMap.put("username", username);
        userMap.put("password", password);

        requestObject.setData(userMap);
        requestObject.setOperation(OPERATION_LOGIN);
        out.writeObject(requestObject);

        ResponseObject responseObject = (ResponseObject) in.readObject();

        if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
            user = (User) responseObject.getData();
            if (!user.isActive()) {
                LOGGER.info("Deleted user " + username + " trying to login.");
                throw new DeletedUserException();
            }
            writeUserInLogger(user);
        }

        if (responseObject.getStatus() == ResponseStatus.ERROR) {
            Exception exception = (Exception) responseObject.getData();
            throw exception;
        }
    }

    private void writeUserInLogger(User user) throws Exception {
        LOGGER.info("Succesfull login by " + user.getUsername());
        SystemDetails.writeUser(user.getUsername());
        SystemDetails.writeUserId(user.getId() + "");
        SystemDetails.writeAdministator(user.isAdministator());
    }
}
