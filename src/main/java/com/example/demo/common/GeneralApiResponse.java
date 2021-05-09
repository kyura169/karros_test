package com.example.demo.common;

import java.io.Serializable;

public class GeneralApiResponse<T> implements Serializable {
    private Integer status;
    private String statusCode;
    private T result;
    private String message;

    public GeneralApiResponse() {
    }

    public GeneralApiResponse(Integer status, String statusCode) {
        this.status = status;
        this.statusCode = statusCode;
    }

    public GeneralApiResponse(Integer status, String statusCode, T result) {
        this.status = status;
        this.statusCode = statusCode;
        this.result = result;
    }

    public GeneralApiResponse(Integer status, String statusCode, T result, String message) {
        this.status = status;
        this.statusCode = statusCode;
        this.result = result;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
