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
import exceptions.ServerException;
import java.util.List;
import java.util.Locale;
import services.common.ServiceCreateControllers;

/**
 *
 * @author Veljko
 */
public class Controller {

    protected static AbstractController instance;

    public static AbstractController getInstance() throws Exception {
        if (instance == null) {
            instance = ServiceCreateControllers.createSocketFirst();
        }
        return instance;
    }
    
     public void writeLanguage(String language, String country) {
        instance.writeLanguage(language, country);
    }

    public void writeUsername(String username) {
        instance.writeUsername(username);
    }

    public void writeUserId(String id) {
        instance.writeUserId(id);
    }

    public List<MatchType> getAllMatchTypes() throws Exception {
        return instance.getAllMatchTypes();
    }

    public List<Confederation> getAllConfederation() throws Exception {
        return instance.getAllConfederations();
    }

    public String cryptPassoword(String password) {
        return instance.cryptPassoword(password);
    }

    public void writeAdministrator(boolean administator) {
        instance.writeAdministrator(administator);
    }

    public boolean readAdministrator() {
        return instance.readAdministrator();
    }

    public static Locale getLocale() {
        return instance.getLocale();
    }

    public int readId() {
        return instance.readId();
    }

    public void deactivateSelection(Selection selection) throws Exception {
        instance.deactivateSelection(selection);
    }

    public void deleteSelection(Selection selection) throws Exception{
        instance.deleteSelection(selection);
    }

    public void deleteMatch(Match match) throws Exception{
        instance.deleteMatch(match);
    }

    public void saveSelection(Selection selection) throws Exception {
        instance.saveSelection(selection);
    }

    public List<Match> getMatchesBySelection(Selection selection) throws Exception{
        return instance.getMatchesBySelection(selection);
    }

    public List<Selection> getRangList() throws Exception{
        return instance.getRangList();
    }

    public void register(String username, String password) throws ServerException, Exception {
        instance.register(username, password);
    }

    public  void saveMatch(Match match) throws Exception{
        instance.saveMatch(match);
    }

    public List<Selection> getAllSelections() throws Exception{
        return instance.getAllSelections();
    }

    public void login(String username, String password) throws Exception {
        instance.login(username, password);
    }
    
    public String readUsername() {
        return instance.readUsername();
    }

}
