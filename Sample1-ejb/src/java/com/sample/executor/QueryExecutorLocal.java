/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.executor;

import com.sample.dto.Users;
import com.sample.helper.RequestHelper;
import javax.ejb.Local;

/**
 *
 * @author MATET
 */
@Local
public interface QueryExecutorLocal {
    public Users getUsersExist(String email);
    public Users createUser(RequestHelper requestHelper);
}
