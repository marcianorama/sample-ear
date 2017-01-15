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
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author MATET
 */
public class LoginAction extends EsapiAction implements Preparable, ValidationAware {
    private RequestHelper requestHelper = null;
    private String mappedRequest = "";
    private final static Logger log = Logger.getLogger(LoginAction.class.getName());
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
            Users users = queryExecutorLocal.getUsersExist(requestHelper.getUserHelper().getEmail().trim());
            if(requestHelper.getUserHelper().getEmail()!=null && !requestHelper.getUserHelper().getEmail().trim().equals("")){
                if(users.getEmail().equals(requestHelper.getUserHelper().getEmail().trim()) && users.getPassword().equals(DigestUtils.md5Hex(requestHelper.getUserHelper().getPassword().trim()))){
                    log.info(". : : LOGIN SUCCESS : : .");
                }else{
                    log.info(". : : LOGIN FAILED : : .");
                }
            }
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String submitRegister() {
        String result = "";
        try {       
            Users users = queryExecutorLocal.getUsersExist(requestHelper.getUserHelper().getEmail().trim());
            if (users != null) {
                log.info(">>> Users Exist!!!");
            } else {
                queryExecutorLocal.createUser(requestHelper);
                log.info(">>>> Create User Success");
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
