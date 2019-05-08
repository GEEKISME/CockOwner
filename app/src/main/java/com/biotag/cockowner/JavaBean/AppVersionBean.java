package com.biotag.cockowner.JavaBean;

import com.google.gson.Gson;

/**
 * Created by Lxh on 2017/9/27.
 */

public class AppVersionBean {

    /**
     * IsSuccess : true
     * Values : {"owner_version":{"no":"1.0.1","url":"http://211.152.45.196:8122/app_setup/CockOwner.apk"}}
     * Status : 0
     * TotalCount : 0
     */

    private boolean IsSuccess;
    private String Values;
    private int Status;
    private int TotalCount;

    public static AppVersionBean objectFromData(String str) {

        return new Gson().fromJson(str, AppVersionBean.class);
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
