/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Confederation;
import domain.Match;
import domain.MatchType;
import domain.Selection;
import domain.User;
import exceptions.ServerException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import org.apache.log4j.Logger;
import services.socket.ServiceSaveSelection;
import services.socket.ServiceCalculateRangList;
import services.socket.ServiceDeactivateSelection;
import services.socket.ServiceLogin;
import services.socket.ServiceRegistration;
import services.socket.ServiceDeleteMatch;
import services.socket.ServiceDeleteSelection;
import services.socket.ServiceGetAllConfederation;
import services.socket.ServiceGetAllMatchTypes;
import services.socket.ServiceGetAllSelections;
import services.socket.ServiceGetAllUsers;
import services.socket.ServiceGetMatchesBySelection;
import services.socket.ServiceSaveMatch;
import services.socket.ServiceRangList;
import services.socket.ServiceUpdateSelection;
import services.socket.ServiceUpdateUsers;

/**
 *
 * @author veljko
 */
public class SocketController extends AbstractController {

    private final Socket socket;
    private final ObjectOutputStream objectOutputStream;
    private final ObjectInputStream objectInputStream;
    private final static Logger LOGGER = Logger.getLogger(SocketController.class);

    public SocketController() throws IOException {
        socket = new Socket("localhost", 9000);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void login(String username, String password) throws Exception {
        new ServiceLogin(objectOutputStream, objectInputStream).
                loginUser(username, cryptPassoword(password));
    }

    @Override
    public List<Selection> getAllSelections() throws ServerException {
        return new ServiceGetAllSelections(objectOutputStream, objectInputStream).getAllSelections();
    }

    @Override
    public void saveMatch(Match match) throws Exception {
        new ServiceSaveMatch(objectOutputStream, objectInputStream).saveMatch(match);
    }

    @Override
    public void register(String username, String password) throws ServerException, Exception {
        new ServiceRegistration(objectOutputStream, objectInputStream).
                register(username, cryptPassoword(password));
    }

    @Override
    public List<Selection> getRangList() throws Exception {
        return new ServiceRangList(objectOutputStream, objectInputStream).getRangList();
    }

    @Override
    public List<Match> getMatchesBySelection(Selection selection) throws Exception {
        return new ServiceGetMatchesBySelection(objectOutputStream, objectInputStream).getAll(selection);
    }

    @Override
    public void saveSelection(Selection selection) throws Exception {
        new ServiceSaveSelection(objectOutputStream, objectInputStream).saveSelection(selection);
    }

    @Override
    public void deleteMatch(Match match) throws Exception {
        new ServiceDeleteMatch(objectOutputStream, objectInputStream).deleteMatch(match);
    }

    @Override
    public void deleteSelection(Selection selection) throws Exception {
        new ServiceDeleteSelection(objectOutputStream, objectInputStream).deleteSelection(selection);
    }

    @Override
    public void deactivateSelection(Selection selection) throws Exception {
        new ServiceDeactivateSelection(objectOutputStream, objectInputStream).deactivateSelection(selection);
    }

    @Override
    public void updateSelection(Selection selection, List<Match> matches) throws Exception {
        new ServiceUpdateSelection(objectOutputStream, objectInputStream).updateSelection(selection, matches);
    }

    @Override
    public List<Confederation> getAllConfederations() throws Exception {
        return new ServiceGetAllConfederation(objectOutputStream, objectInputStream).getAll();
    }

    @Override
    public List<MatchType> getAllMatchTypes() throws Exception {
        return new ServiceGetAllMatchTypes(objectOutputStream, objectInputStream).getAll();

    }

    @Override
    public void calculateRangList() throws Exception {
        new ServiceCalculateRangList(objectOutputStream, objectInputStream).calculateRangList();
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return new ServiceGetAllUsers(objectOutputStream, objectInputStream).getAll();
    }

    @Override
    public void updateUsers(List<User> users) throws Exception {
        new ServiceUpdateUsers(objectOutputStream, objectInputStream).updateUsers(users);
    }

}
