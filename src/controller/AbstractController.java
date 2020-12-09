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
import java.util.List;
import java.util.Locale;
import services.common.ServiceCryptPassword;
import services.common.SystemDetails;

/**
 *
 * @author Veljko
 */
public abstract class AbstractController {

    public void writeLanguage(String language, String country) {
        SystemDetails.writeLanguage(language, country);
    }

    public void writeUsername(String username) {
        SystemDetails.writeUser(username);
    }

    public void writeUserId(String id) {
        SystemDetails.writeUserId(id);
    }

    public void writeAdministrator(boolean administator) {
        SystemDetails.writeAdministator(administator);
    }

    public boolean readAdministrator() {
        return SystemDetails.getAdministrator();
    }

    public Locale getLocale() {
        return SystemDetails.getLocale();
    }

    public int readId() {
        return SystemDetails.getUserId();
    }

    public String readUsername() {
        return SystemDetails.getUser();
    }

    public String cryptPassoword(String password) {
        return ServiceCryptPassword.cryptPassword(password);
    }

    public abstract void deactivateSelection(Selection selection) throws Exception;

    public abstract void deleteSelection(Selection selection) throws Exception;

    public abstract void deleteMatch(Match match) throws Exception;

    public abstract void saveSelection(Selection selection) throws Exception;

    public abstract List<Match> getMatchesBySelection(Selection selection) throws Exception;

    public abstract List<Selection> getRangList() throws Exception;

    public abstract void register(String username, String password) throws Exception;

    public abstract void saveMatch(Match match) throws Exception;

    public abstract List<Selection> getAllSelections() throws Exception;

    public abstract void login(String username, String password) throws Exception;

    public abstract void updateSelection(Selection selection, List<Match> matches) throws Exception;

    public abstract List<Confederation> getAllConfederations() throws Exception;

    public abstract List<MatchType> getAllMatchTypes() throws Exception;

    public abstract void calculateRangList() throws Exception;

    public abstract List<User> getAllUsers() throws Exception;

    public abstract void updateUsers(List<User> users) throws Exception;

}
