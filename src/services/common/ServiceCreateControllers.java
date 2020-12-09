/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.common;

import controller.AbstractController;
import controller.RMIController;
import controller.SocketController;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import org.apache.log4j.Logger;

/**
 *
 * @author Veljko
 */
public class ServiceCreateControllers {
    
    private final static Logger LOOGER = Logger.getLogger(ServiceCreateControllers.class);
    private static AbstractController instance;

    public static AbstractController createSocketFirst() throws Exception {
        try {
            instance = new SocketController();
        } catch (IOException ex) {
            LOOGER.info(ex);
            instance = new RMIController();
        }
        return instance;
    }
    
    public static AbstractController createRMIFirst() throws Exception {
        try {
            instance = new RMIController();
        } catch (NotBoundException | RemoteException ex) {
            LOOGER.info(ex);
            instance = new SocketController();
        }
        return instance;
    }
}
