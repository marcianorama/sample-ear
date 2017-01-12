/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.action;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ValidationAware;
import com.sample.dto.Users;
import com.sample.executor.QueryExecutorLocal;
import com.sample.helper.RequestHelper;
import com.sample.helper.UsersHelper;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 *
 * @author MATET
 */
public class LoginAction extends EsapiAction implements Preparable, ValidationAware {
    private RequestHelper requestHelper = null;
    private String mappedRequest = "";
    @EJB
    private QueryExecutorLocal queryExecutorLocal;

    @Override
    public void prepare() throws Exception {
        setRequestHelper(new RequestHelper());
        getRequestHelper().setUserHelper(new UsersHelper());
    }

    public String login() {
        String result = "";
        try {
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String submitRegister() {
        String result = "";
        try {
            System.out.println("email -> "+requestHelper.getUserHelper().getEmail().trim());
                    
            Users users = queryExecutorLocal.getUsersExist(requestHelper.getUserHelper().getEmail().trim());
            if (users != null) {
                System.out.println("Users found");
            } else {
                System.out.println("Users Not Found");
            }
            setMappedRequest("LoginAction_login.tes");
            result = "redirect";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public RequestHelper getRequestHelper() {
        return requestHelper;
    }

    public void setRequestHelper(RequestHelper requestHelper) {
        this.requestHelper = requestHelper;
    }

    public String getMappedRequest() {
        return mappedRequest;
    }

    public void setMappedRequest(String mappedRequest) {
        this.mappedRequest = mappedRequest;
    }
    
}
