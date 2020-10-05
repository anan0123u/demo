package com.example.demo.model;

public class ResBase {

    private int retCode;

    private String retMsg;

    public ResBase(int retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
