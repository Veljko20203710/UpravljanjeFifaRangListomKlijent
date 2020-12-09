/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.validator;

import exceptions.IllegalDateException;
import java.util.Date;

/**
 *
 * @author Veljko
 */
public class DateValidator implements Validator {

   
    @Override
    public void validate(Object value) throws Exception {
            Date date = (Date) value;
            if (date.after(new Date())) {
                throw new IllegalDateException();
        }
    }
    
}
