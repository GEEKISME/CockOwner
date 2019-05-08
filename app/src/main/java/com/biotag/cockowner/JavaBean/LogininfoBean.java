package com.biotag.cockowner.JavaBean;

import com.google.gson.Gson;

/**
 * Created by Lxh on 2017/8/17.
 */

public class LogininfoBean {


    /**
     * IsSuccess : true
     * Values : {"id":10012,"ownerName":"kokie","oTitle":2,"otitle":null,"oAddress":"123456","oTel":"12345678965",
     * "oIDNo":"","MasterID":0,"OrgID":0,"ownDate":"2017-08-29T00:00:00","areaName":null,"dictName":"Negros
     * Oriental","oDictionID":3,"areaId":2,"isPersonal":false,"farmid":21,"mFarmName":"Farmhangzhou",
     * "isDeleted":false,"farm_isDeleted":true,"username":"kokie","password":"123123"}
     * Status : 1
     * TotalCount : 0
     */

    private boolean IsSuccess;
    private ValuesBean Values;
    private int Status;
    private int TotalCount;

    public static LogininfoBean objectFromData(String str) {

        return new Gson().fromJson(str, LogininfoBean.class);
    }

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public ValuesBean getValues() {
        return Values;
    }

    public void setValues(ValuesBean Values) {
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

    public static class ValuesBean {
        /**
         * id : 10012
         * ownerName : kokie
         * oTitle : 2
         * otitle : null
         * oAddress : 123456
         * oTel : 12345678965
         * oIDNo :
         * MasterID : 0
         * OrgID : 0
         * ownDate : 2017-08-29T00:00:00
         * areaName : null
         * dictName : Negros Oriental
         * oDictionID : 3
         * areaId : 2
         * isPersonal : false
         * farmid : 21
         * mFarmName : Farmhangzhou
         * isDeleted : false
         * farm_isDeleted : true
         * username : kokie
         * password : 123123
         */

        private int id;
        private String ownerName;
        private int oTitle;
        private Object otitle;
        private String oAddress;
        private String oTel;
        private String oIDNo;
        private int MasterID;
        private int OrgID;
        private String ownDate;
        private Object areaName;
        private String dictName;
        private int oDictionID;
        private int areaId;
        private boolean isPersonal;
        private int farmid;
        private String mFarmName;
        private boolean isDeleted;
        private boolean farm_isDeleted;
        private String username;
        private String password;

        public static ValuesBean objectFromData(String str) {

            return new Gson().fromJson(str, ValuesBean.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public int getOTitle() {
            return oTitle;
        }

        public void setOTitle(int oTitle) {
            this.oTitle = oTitle;
        }

        public Object getOtitle() {
            return otitle;
        }

        public void setOtitle(Object otitle) {
            this.otitle = otitle;
        }

        public String getOAddress() {
            return oAddress;
        }

        public void setOAddress(String oAddress) {
            this.oAddress = oAddress;
        }

        public String getOTel() {
            return oTel;
        }

        public void setOTel(String oTel) {
            this.oTel = oTel;
        }

        public String getOIDNo() {
            return oIDNo;
        }

        public void setOIDNo(String oIDNo) {
            this.oIDNo = oIDNo;
        }

        public int getMasterID() {
            return MasterID;
        }

        public void setMasterID(int MasterID) {
            this.MasterID = MasterID;
        }

        public int getOrgID() {
            return OrgID;
        }

        public void setOrgID(int OrgID) {
            this.OrgID = OrgID;
        }

        public String getOwnDate() {
            return ownDate;
        }

        public void setOwnDate(String ownDate) {
            this.ownDate = ownDate;
        }

        public Object getAreaName() {
            return areaName;
        }

        public void setAreaName(Object areaName) {
            this.areaName = areaName;
        }

        public String getDictName() {
            return dictName;
        }

        public void setDictName(String dictName) {
            this.dictName = dictName;
        }

        public int getODictionID() {
            return oDictionID;
        }

        public void setODictionID(int oDictionID) {
            this.oDictionID = oDictionID;
        }

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public boolean isIsPersonal() {
            return isPersonal;
        }

        public void setIsPersonal(boolean isPersonal) {
            this.isPersonal = isPersonal;
        }

        public int getFarmid() {
            return farmid;
        }

        public void setFarmid(int farmid) {
            this.farmid = farmid;
        }

        public String getMFarmName() {
            return mFarmName;
        }

        public void setMFarmName(String mFarmName) {
            this.mFarmName = mFarmName;
        }

        public boolean isIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

        public boolean isFarm_isDeleted() {
            return farm_isDeleted;
        }

        public void setFarm_isDeleted(boolean farm_isDeleted) {
            this.farm_isDeleted = farm_isDeleted;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
