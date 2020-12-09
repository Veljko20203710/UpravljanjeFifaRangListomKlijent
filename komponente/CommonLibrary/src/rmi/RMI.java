/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import domain.Confederation;
import domain.Match;
import domain.MatchType;
import domain.Selection;
import domain.User;
import java.rmi.Remote;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author Veljko
 */
public interface RMI extends Remote {

    public boolean deactiveSelection(Selection selection) throws Exception;

    public boolean deleteMatch(Match match) throws Exception;

    public boolean DeleteSelection(Selection selection) throws Exception;

    public List<Selection> getAllSelection() throws Exception;

    public List<Match> getMatches(Selection selection) throws Exception;

    public User login(String username, String password) throws Exception;

    public List<Selection> getRangList() throws Exception;

    public boolean register(String username, String password) throws Exception;

    public boolean saveMatch(Match match) throws Exception;

    public boolean saveSelection(Selection selection) throws Exception;

    public List<Confederation> getAllConfederations() throws Exception;

    public List<MatchType> getAllMatchTypes() throws Exception;

    public void calculateRangList() throws Exception;
    
    public abstract List<User> getAllUsers() throws Exception;
    
    public abstract boolean updateSelection(Selection selection, List<Match> matches) throws Exception;

    public boolean updateUsers(List<User> users) throws Exception;
    
    public PDDocument getReportRangList() throws Exception;
}
