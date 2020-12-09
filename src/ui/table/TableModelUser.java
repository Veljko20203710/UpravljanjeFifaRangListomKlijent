/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.table;

import controller.Controller;
import domain.User;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author veljko
 */
public class TableModelUser extends AbstractTableModel {

    private List<User> users;
    private String[] columnNames;
    private final static Logger LOGGER = Logger.getLogger(TableModelUser.class);

    public TableModelUser(List<User> users) {
        this.users = users;
        setColumnNames();
    }
    

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case (0):
                return users.get(rowIndex).getId();
            case (1):
                return users.get(rowIndex).getUsername();
            case (2):
                return users.get(rowIndex).isActive();
            default:
                return "n/a";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       return columnIndex==2 ? Boolean.class : String.class;
    }
    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex==2;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        users.get(rowIndex).setActive((Boolean)aValue);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    private void setColumnNames() {
        try{
        Locale locale = Controller.getLocale();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resourceBundles.ResourceBundle_FrmAllUsers_" + locale);
        
        columnNames = new String[] {resourceBundle.getString("ID"),resourceBundle.getString("username"),resourceBundle.getString("active")};
        }
        catch(Exception e) {
            LOGGER.error(e);
        }
    }
    
    
   
}
