package com.biotag.cockowner.JavaBean;

import com.google.gson.Gson;

/**
 * Created by Lxh on 2017/8/31.
 */

public class ChipCodeVerificationResultBean {

    /**
     * IsSuccess : true
     * Values : null
     * Status : 0
     * TotalCount : 0
     */

    private boolean IsSuccess;
    private Object Values;
    private int Status;
    private int TotalCount;

    public static ChipCodeVerificationResultBean objectFromData(String str) {

        return new Gson().fromJson(str, ChipCodeVerificationResultBean.class);
    }

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public Object getValues() {
        return Values;
    }

    public void setValues(Object Values) {
        this.Values = Values;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }
}
