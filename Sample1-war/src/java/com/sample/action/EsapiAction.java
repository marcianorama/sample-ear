/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import com.sample.helper.SampleActionMessage;
import java.util.ArrayList;
/**
 *
 * @author jaya
 */
public class EsapiAction extends ActionSupport implements SessionAware, ServletContextAware,
        ServletResponseAware, ServletRequestAware, ParameterNameAware {

    private Map<String, Object> session;
    private ServletContext servletContext;
    HttpServletResponse response;
    private HttpServletRequest request;
    private List<SampleActionMessage> boActionMessages;

    public EsapiAction() {
        boActionMessages = new ArrayList<SampleActionMessage>();
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public boolean acceptableParameterName(String paramName) {
        return !paramName.matches("^session\\..*");
    }
    
    public boolean hasBoActionMessages() {
        List<SampleActionMessage> listMessage = (List<SampleActionMessage>) getSession().get(SampleActionMessage.SESSION_KEY);
        if (listMessage != null && listMessage.size() > 0) {
            System.out.println(" :: Has BO Action Message which list size is "+listMessage.size());
            return true;
        }
        System.out.println(" :: BO Action Message is empty");
        return false;
    }

    public List<SampleActionMessage> getBoActionMessages() {
        boActionMessages = (List<SampleActionMessage>) getSession().get(SampleActionMessage.SESSION_KEY);
        getSession().remove(SampleActionMessage.SESSION_KEY);
//        log.sInfo(" :: Get BO Action Message which list size is %s", boActionMessages.size());
        return boActionMessages;
    }

    public void setBoActionMessages(List<SampleActionMessage> boActionMessages) {
        this.boActionMessages = boActionMessages;
//        log.sInfo(" :: Set BO Action Message which list size is %s", this.boActionMessages.size());
        getSession().put(SampleActionMessage.SESSION_KEY, this.boActionMessages);
    }

    public void addBoActionMessages(SampleActionMessage message) {
        this.boActionMessages.add(message);
//        log.sInfo(" :: Add BO Action Message which list size is %s", boActionMessages.size());
        getSession().put(SampleActionMessage.SESSION_KEY, this.boActionMessages);
    }

    public void addBoActionMessages(String type, String message) {
        this.boActionMessages.add(new SampleActionMessage(type, message));
//        log.sInfo(" :: Add BO Action Message which list size is %s", boActionMessages.size());
        getSession().put(SampleActionMessage.SESSION_KEY, this.boActionMessages);
    }
}