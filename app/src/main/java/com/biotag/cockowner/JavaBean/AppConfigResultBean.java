package com.biotag.cockowner.JavaBean;

/**
 * Created by Lxh on 2017/8/28.
 */

public class AppConfigResultBean {

    /**
     * IsSuccess : true
     * Values : 2
     * Status : 0
     * TotalCount : 0
     */

    private boolean IsSuccess;
    private int Values;
    private int Status;
    private int TotalCount;

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public int getValues() {
        return Values;
    }

    public void setValues(int Values) {
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
