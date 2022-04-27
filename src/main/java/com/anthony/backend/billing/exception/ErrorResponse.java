/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthony.backend.billing.exception;

import java.util.Date;

/**
 *
 * @author anthony
 */
public class ErrorResponse {

    private long status;
    private String message;
    private Date timestamp;

    public ErrorResponse() {
    }

    public ErrorResponse(long status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
