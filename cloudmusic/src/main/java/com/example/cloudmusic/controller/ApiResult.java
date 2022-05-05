package com.example.cloudmusic.controller;

public class ApiResult {
    private String code;
    private String message;
    private Object result;

    public ApiResult(String code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ApiResult success(){
        return  new ApiResult(this.code,this.message,this.result);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
