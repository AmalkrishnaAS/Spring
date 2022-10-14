package com.example.api.sitevalidator.model;



public class ResultSchema {
    private String url;
    private String status;
    private String message;
    private int responseCode;
    //getters and setters generated
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getResponseCode() {
        return responseCode;
    }
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
    //toString generated
    @Override
    public String toString() {
        return "ResultSchema [message=" + message + ", responseCode=" + responseCode + ", status=" + status + ", url="
                + url + "]";
    }
    //constructor generated
    public ResultSchema(String url, String status, String message, int responseCode) {
        this.url = url;
        this.status = status;
        this.message = message;
        this.responseCode = responseCode;
    }
    
}
