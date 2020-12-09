/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listeners;

import controller.Controller;
import domain.Match;
import domain.MatchType;
import domain.Selection;
import domain.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.ResourceBundle;
;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import ui.form.FrmNewMatch;

/**
 *
 * @author Veljko
 */


public class ListernInputNewMatch implements ActionListener {

    private final FrmNewMatch frmNewMatch;
    private Selection host;
    private Selection away;
    private int hostGoals;
    private int awayGoals;
    private Date date;
    private MatchType matchType;
    private final ResourceBundle resourceBundle;
    private final Logger LOGGER = Logger.getLogger(ListernInputNewMatch.class);

    public ListernInputNewMatch(FrmNewMatch frmNewMatch) {
        this.frmNewMatch = frmNewMatch;
        resourceBundle = frmNewMatch.getResourceBundle();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            readMatchProperties();
            if (host.equals(away)) {
                JOptionPane.showMessageDialog(frmNewMatch, resourceBundle.getString("SameSelections"), resourceBundle.getString("Title"), 1);
                return;
            }
             if (matchType.getName().equalsIgnoreCase("Confederation cup")&& !host.getConfederation().equals(away.getConfederation())) {
                JOptionPane.showMessageDialog(frmNewMatch, resourceBundle.getString("ConfederationCup"), resourceBundle.getString("Title"), 1);
                return;
            }
            Match match = setMatchProperties();
            Controller.getInstance().saveMatch(match);
            JOptionPane.showMessageDialog(frmNewMatch, resourceBundle.getString("Sucessfull"), resourceBundle.getString("Title"), 1);
            frmNewMatch.dispose();
        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
            JOptionPane.showMessageDialog(frmNewMatch, resourceBundle.getString("Unsucesfull"), resourceBundle.getString("Title"), 1);
        }
    }

    private Match setMatchProperties() throws Exception {
        Match match = new Match();
        match.setHost(host);
        match.setAway(away);
        match.setHostGoals(hostGoals);
        match.setAwayGoals(awayGoals);
        match.setMatchType(matchType);
        match.setDate(date);
        match.setUser(new User(Controller.getInstance().readId(), Controller.getInstance().readUsername()));
        return match;
    }

    private void readMatchProperties() throws Exception {
        boolean succesfullyAwayGoals = readAwayGoals();
        boolean succesfullyHostGoals = readHostGoals();
        boolean succesfullyDate = readDate();
        if(!succesfullyAwayGoals || !succesfullyHostGoals || !succesfullyDate) throw new Exception();
        readHostAndAway();
        readMatchType();
    }

    public boolean readAwayGoals() {
        try {
            String inputGoals = (String) frmNewMatch.getPanelInputAwayGoals().getValue();
            awayGoals = Integer.parseInt(inputGoals);
            return true;
        } catch (Exception ex) {
            frmNewMatch.getPanelInputAwayGoals().getLblError().setText(resourceBundle.getString("IllegalGoalsException"));
            return false;
        }
    }

    public boolean readHostGoals() {
        try {
            String inputGoals = (String) frmNewMatch.getPanelInputHostGoals().getValue();
            hostGoals = Integer.parseInt(inputGoals);
            return true;
        } catch (Exception ex) {
            frmNewMatch.getPanelInputHostGoals().getLblError().setText(resourceBundle.getString("IllegalGoalsException"));
            return false;
        }
    }

    private boolean readDate() {
        try {
            date = (Date) frmNewMatch.getPanelInputDate().getValue();
            return true;
        } catch (Exception ex) {
            frmNewMatch.getPanelInputDate().getLblError().setText(resourceBundle.getString("IllegalDateException"));
            return false;
        }
    }

    private void readHostAndAway() {
        host = (Selection) frmNewMatch.getPanelInputHost().getValue();
        away = (Selection) frmNewMatch.getPanelInputAway().getValue();
    }

    private void readMatchType() {
        matchType = ((MatchType) frmNewMatch.getPanelInputMatchType().getValue());
    }
}
