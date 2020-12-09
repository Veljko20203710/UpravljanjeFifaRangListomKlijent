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
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import org.apache.log4j.Logger;
import rmi.RMISystemOperation;
import services.rmi.ServiceAllSelections;
import services.rmi.ServiceCalculateRangList;
import services.rmi.ServiceDeactiveSelection;
import services.rmi.ServiceDeleteMatch;
import services.rmi.ServiceDeleteSelection;
import services.rmi.ServiceGetAllConfederations;
import services.rmi.ServiceGetAllMatchTypes;
import services.rmi.ServiceGetAllMatches;
import services.rmi.ServiceGetAllUsers;
import services.rmi.ServiceLogin;
import services.rmi.ServiceRangLista;
import services.rmi.ServiceRegister;
import services.rmi.ServiceSaveMatch;
import services.rmi.ServiceSaveSelection;
import services.rmi.ServiceUpdateSelection;
import services.rmi.ServiceUpdateUsers;

/**
 *
 * @author Veljko
 */
public class RMIController extends AbstractController {

    private static Registry registry;
    private static RMISystemOperation rmi;
    private final static Logger LOGGER = Logger.getLogger(RMIController.class);

    public RMIController() throws RemoteException, NotBoundException, NotBoundException {
        registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        rmi = (RMISystemOperation) registry.lookup("Server");
    }

    @Override
    public void deactivateSelection(Selection selection) throws Exception{
         new ServiceDeactiveSelection(rmi).deactiveSelection(selection);
    }

    @Override
    public void deleteSelection(Selection selection) throws Exception{
         new ServiceDeleteSelection(rmi).deleteSelection(selection);
    }

    @Override
    public void deleteMatch(Match match) throws Exception {
         new ServiceDeleteMatch(rmi).deleteMatch(match);
    }

    @Override
    public void saveSelection(Selection selection) throws Exception{
         new ServiceSaveSelection(rmi).saveSelection(selection);
    }

    @Override
    public List<Match> getMatchesBySelection(Selection selection) throws Exception {
        return new ServiceGetAllMatches(rmi).getAllMatches(selection);
    }

    @Override
    public List<Selection> getRangList() throws Exception {
        return new ServiceRangLista(rmi).getRangList();
    }

    @Override
    public void register(String username, String password) throws Exception {
        new ServiceRegister(rmi).Register(username, password);
    }

    @Override
    public void saveMatch(Match match) throws Exception{
        new ServiceSaveMatch(rmi).saveMatch(match);
    }

    @Override
    public List<Selection> getAllSelections() throws Exception {
            return new ServiceAllSelections(rmi).getAllSelections();
    }

    @Override
    public void login(String username, String password) throws Exception {
        new ServiceLogin(rmi).login(username, password);
    }

    @Override
    public void updateSelection(Selection selection, List<Match> matches) throws Exception{
         new ServiceUpdateSelection(rmi).updateSelection(selection, matches);
    }

    @Override
    public List<Confederation> getAllConfederations() throws Exception {
        return new ServiceGetAllConfederations(rmi).getAll();
    }

    @Override
    public List<MatchType> getAllMatchTypes() throws Exception {
        return new ServiceGetAllMatchTypes(rmi).getAll();
    }

    @Override
    public void calculateRangList() throws Exception{
        new ServiceCalculateRangList(rmi).calculateRangList();
    }

    @Override
    public List<User> getAllUsers() throws Exception{
            return new ServiceGetAllUsers(rmi).getAll();
    }

    @Override
    public void updateUsers(List<User> users) throws Exception{
        new ServiceUpdateUsers(rmi).updateUsers(users);
    }

}
