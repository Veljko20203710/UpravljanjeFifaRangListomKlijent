/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.validator;

import exceptions.IllegalGoalsException;

/**
 *
 * @author Veljko
 */
public class GoalValidator implements Validator {

    
    
    @Override
    public void validate(Object value) throws Exception {
        try {
            int broj = Integer.parseInt(value.toString());
            if (broj < 0) {
                throw new IllegalGoalsException();
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalGoalsException();
        }
    }
}   
