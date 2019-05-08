package com.biotag.cockowner.JavaBean;

import java.util.List;

/**
 * Created by Lxh on 2017/8/28.
 */

public class GetDictionInfoResultBean {

    /**
     * IsSuccess : true
     * Values : [{"id":1,"dictName":"Calirana","areaId":1,"areaName":"LUZON"},{"id":2,"dictName":"Cagayan","areaId":1,"areaName":"LUZON"}]
     * Status : 0
     * TotalCount : 2
     */

    private boolean IsSuccess;
    private int Status;
    private int TotalCount;
    private List<ValuesBean> Values;

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
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

    public List<ValuesBean> getValues() {
        return Values;
    }

    public void setValues(List<ValuesBean> Values) {
        this.Values = Values;
    }

    public static class ValuesBean {
        /**
         * id : 1
         * dictName : Calirana
         * areaId : 1
         * areaName : LUZON
         */

        private int id;
        private String dictName;
        private int areaId;
        private String areaName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDictName() {
            return dictName;
        }

        public void setDictName(String dictName) {
            this.dictName = dictName;
        }

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }
    }
}
