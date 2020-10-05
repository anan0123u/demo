package com.example.demo.comm;

import java.util.Map;

public class ResData {

    private int retCode;

    private String retMsg;

    private Map retData;

    public ResData() {
    }

    public ResData(int retCode, String retMsg, Map retData) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.retData = retData;
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

    public Map getRetData() {
        return retData;
    }

    public void setRetData(Map retData) {
        this.retData = retData;
    }
}
