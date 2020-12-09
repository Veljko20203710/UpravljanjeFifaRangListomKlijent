/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.socket;

import domain.Match;
import domain.Selection;
import exceptions.ServerException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import static util.Operation.OPERATION_CHANGE_SELECTION;
import util.ResponseStatus;

/**
 *
 * @author Veljko
 */
public class ServiceUpdateSelection {

    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private static final Logger LOGGER = Logger.getLogger(ServiceDeleteSelection.class);

    public ServiceUpdateSelection(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream) {
        this.out = objectOutputStream;
        this.in = objectInputStream;
    }

    public boolean updateSelection(Selection selection,List<Match> matches) {
        try {
            RequestObject requestObject = new RequestObject();
            HashMap<String,Object> data = new HashMap();
            data.put("selection", cloneSelection(selection));
            data.put("matches", matches);
            requestObject.setData(data);
            requestObject.setOperation(OPERATION_CHANGE_SELECTION);
            out.writeObject(requestObject);
            ResponseObject responseObject = (ResponseObject) in.readObject();
           if (responseObject.getStatus() == ResponseStatus.ERROR) throw new ServerException();
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
        return true;
    }
    
    private Selection cloneSelection(Selection selection) throws Exception {
        Selection selectionCloned = new Selection();
        selectionCloned.setId(selection.getId());
        selectionCloned.setName(selection.getName());
        selectionCloned.setConfederation(selection.getConfederation());
        selectionCloned.setPoints(selection.getPoints());
        selectionCloned.setRang(selection.getRang());
        selectionCloned.setActive(selection.isActive());
        selectionCloned.setUser(selection.getUser());
        return selectionCloned;       
    }

}
