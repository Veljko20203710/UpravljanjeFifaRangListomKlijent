/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.validator;

import exceptions.EmptyUsernameException;

/**
 *
 * @author veljko
 */
public class UsernameValidator implements Validator {

    @Override
    public void validate(Object value) throws Exception {
        String username = value.toString();
        if (username.isEmpty()) {
            throw new EmptyUsernameException();
        }
    }

}
