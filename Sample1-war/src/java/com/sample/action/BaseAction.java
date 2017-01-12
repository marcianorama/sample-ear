/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author aditya
 *
 */
public abstract class BaseAction extends EsapiAction {

    private static final long serialVersionUID = 1L;
    private int start = 0, count = 10;
    private String previousPage, ascDesc = "asc", orderBy = "", pager = "", pagerItem = "", pager2 = "", pagerItem2 = "", search = "", subaction = "", gotoPage = "";
    private int orderId = 0;
    private boolean readOnly = false;
    private String mappedRequest;
    private String processed;
    private String pageTitle;
    private String paramObjectId;

    public BaseAction() {
    }

    public String getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(String previousPage) {
        this.previousPage = previousPage;
    }

    @SkipValidation
    public abstract String list();

    @SkipValidation
    public abstract String add();

    public abstract String save() throws Throwable;

    @SkipValidation
    public abstract String edit();

    public abstract String update();

    @SkipValidation
    public abstract String detail();

    @SkipValidation
    public abstract String delete();

    public String getActionClass() {
        return getClass().getSimpleName();
    }

    public String getDestination() {
        return getClass().getSimpleName();
    }

    public String getActionMethod() {
        return mappedRequest != null ? (mappedRequest.indexOf(".tes") > -1 ? (mappedRequest.substring(0, mappedRequest.indexOf(".tes"))) : mappedRequest) : mappedRequest;
    }

    // when invalid, the request parameter will restore command action
    public void setActionMethod(String method) {
        this.mappedRequest = method;
    }

    // this prepares command for button on initial screen write
    public void setMappedRequest(String actionMethod) {
        this.mappedRequest = getActionClass() + "_" + actionMethod + ".tes";
    }

    public void setMappedRequest(String actionMethod, String param) {
        this.mappedRequest = getActionClass() + "_" + actionMethod + ".tes" + param;
    }

    public void setMappedRequestFullPath(String actionMethod) {
        this.mappedRequest = actionMethod;
    }

    public String getMappedRequest() {
        return mappedRequest;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    public void setCount(int count) {
        this.count = count;

    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getAscDesc() {
        return ascDesc;
    }

    public void setAscDesc(String ascDesc) {
        this.ascDesc = ascDesc;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public String getPagerItem() {
        return pagerItem;
    }

    public void setPagerItem(String pagerItem) {
        this.pagerItem = pagerItem;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSubaction() {
        return subaction;
    }

    public void setSubaction(String subaction) {
        this.subaction = subaction;
    }

    public String getParamObjectId() {
        return paramObjectId;
    }

    public void setParamObjectId(String paramObjectId) {
        this.paramObjectId = paramObjectId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProcessed() {
        return processed;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }

    public String getGotoPage() {
        return gotoPage;
    }

    public void setGotoPage(String gotoPage) {
        this.gotoPage = gotoPage;
    }

    public String getPager2() {
        return pager2;
    }

    public void setPager2(String pager2) {
        this.pager2 = pager2;
    }

    public String getPagerItem2() {
        return pagerItem2;
    }

    public void setPagerItem2(String pagerItem2) {
        this.pagerItem2 = pagerItem2;
    }
}