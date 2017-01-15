/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.helper;

import java.io.Serializable;

/**
 *
 * @author MATET
 */
public class RequestHelper implements Serializable{
    private static final long SerialVersionUID = 1L;
    
    //Helper
    private UsersHelper userHelper;

    public UsersHelper getUserHelper() {
        return userHelper;
    }

    public void setUserHelper(UsersHelper userHelper) {
        this.userHelper = userHelper;
    }
    
    
}
