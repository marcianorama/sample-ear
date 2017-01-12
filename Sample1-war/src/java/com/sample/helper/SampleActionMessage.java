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
public class SampleActionMessage implements Serializable {
    private String key;
    private String type = NOTIFICATION;
    private String message;

    public static final String SESSION_KEY = "SAMPLE_ACTION_MESSAGE_K";
    public static final String SUCCESS = "SAMPLE_ACTION_MESSAGE_SUCCESS";
    public static final String ERROR = "SAMPLE_ACTION_MESSAGE_ERROR";
    public static final String NOTIFICATION = "SAMPLE_ACTION_MESSAGE_NOTIFICATION";
    public static final String WARNING = "SAMPLE_ACTION_MESSAGE_WARNING";

    public SampleActionMessage() {
    }

    public SampleActionMessage(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public SampleActionMessage(String key, String type, String message) {
        this.key = key;
        this.type = type;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
