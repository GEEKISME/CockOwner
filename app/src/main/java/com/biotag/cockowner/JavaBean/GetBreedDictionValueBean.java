package com.biotag.cockowner.JavaBean;

import com.google.gson.Gson;

/**
 * Created by Lxh on 2017/8/30.
 */

public class GetBreedDictionValueBean {

    /**
     * IsSuccess : true
     * Values : 1.1
     * Status : 0
     * TotalCount : 0
     */

    private boolean IsSuccess;
    private String Values;
    private int Status;
    private int TotalCount;

    public static GetBreedDictionValueBean objectFromData(String str) {

        return new Gson().fromJson(str, GetBreedDictionValueBean.class);
    }

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public String getValues() {
        return Values;
    }

    public void setValues(String Values) {
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
