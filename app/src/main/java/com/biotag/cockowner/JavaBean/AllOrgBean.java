package com.biotag.cockowner.JavaBean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Lxh on 2017/9/7.
 */

public class AllOrgBean {
    /**
     * IsSuccess : true
     * Values : [{"id":1,"OrgName":"Philippine Federation of Gamefowl Breeders, Inc.","gAddress":"","gTel":"","gContactor":"","gTitle":2,"gCode":"PFGB","parentID":0},{"id":2,"OrgName":"International Federation of Gamefowl Breeders Associations","gAddress":"","gTel":"","gContactor":"","gTitle":1,"gCode":"FIGBA","parentID":0},{"id":3,"OrgName":"ASSOCIATION OF GAMEFOWL BREEDERS OF CAGAYAN","gAddress":"","gTel":"09159472072","gContactor":"EXPEDITO TAGUIBAO","gTitle":1,"gCode":"AGBC","parentID":1},{"id":4,"OrgName":"GAMEFOWL BREEDERS ASSOCIATION OF REGION 2","gAddress":"","gTel":"09175546288","gContactor":"Oscar Serquiña","gTitle":1,"gCode":"GFBAR2","parentID":1},{"id":5,"OrgName":"BREEDERS ASSOCIATION OF GAMEFOWL IN ILOCOS","gAddress":"","gTel":"09272893970","gContactor":"Martel Quitoriano","gTitle":1,"gCode":"BAGIS","parentID":1},{"id":6,"OrgName":"ILOCOS SUR ABRA GAMEFOWL BREEDERS ASSOCIATION","gAddress":"","gTel":"09177981229","gContactor":"Nolan Gapusan","gTitle":1,"gCode":"ISAGBA","parentID":1},{"id":7,"OrgName":"BREEDERS ASSOCIATION OF GAMEFOWL OF UNITED ILOCANO","gAddress":"","gTel":"09178603360","gContactor":"Michael Marron","gTitle":1,"gCode":"BAGUI","parentID":1},{"id":8,"OrgName":"PANGASINAN GAMECOCK BREEDERS ASSOCIATION","gAddress":"","gTel":"09266080688","gContactor":"Ricardo D. Balderas","gTitle":1,"gCode":"PGBA","parentID":1},{"id":9,"OrgName":"UNITED NUEVA ECIJA GAMEFOWL BREEDERS ASSICIATION","gAddress":"","gTel":"09061597943","gContactor":"Romeo capinpin","gTitle":1,"gCode":"UNEGBA","parentID":1},{"id":10,"OrgName":"PAMPANGA GAMEFOWL BREEDERS ASSOCIATION","gAddress":"","gTel":"09174826046","gContactor":"Bong Pecson","gTitle":1,"gCode":"PAMPGBA","parentID":1},{"id":11,"OrgName":"MANILA COCKERS AND RIZAL BREEDERS CLUB","gAddress":"","gTel":"09176232747","gContactor":"Engr. Crisanto L. Llanes","gTitle":1,"gCode":"MCRBC","parentID":1},{"id":13,"OrgName":"PILIPINAS GAMEFOWL BREEDERS AND DERBY ASSOCIATION","gAddress":"","gTel":"09175212577","gContactor":"Dr. Antonino Mabanta","gTitle":1,"gCode":"PGBDA","parentID":1},{"id":16,"OrgName":"test","gAddress":"123123","gTel":"123123","gContactor":"1231231","gTitle":1,"gCode":"123123","parentID":2}]
     * Status : 0
     * TotalCount : 0
     */

    private boolean IsSuccess;
    private int Status;
    private int TotalCount;
    private List<ValuesBean> Values;

    public static AllOrgBean objectFromData(String str) {

        return new Gson().fromJson(str, AllOrgBean.class);
    }

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
         * OrgName : Philippine Federation of Gamefowl Breeders, Inc.
         * gAddress :
         * gTel :
         * gContactor :
         * gTitle : 2
         * gCode : PFGB
         * parentID : 0
         */

        private int id;
        private String OrgName;
        private String gAddress;
        private String gTel;
        private String gContactor;
        private int gTitle;
        private String gCode;
        private int parentID;

        public static ValuesBean objectFromData(String str) {

            return new Gson().fromJson(str, ValuesBean.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrgName() {
            return OrgName;
        }

        public void setOrgName(String OrgName) {
            this.OrgName = OrgName;
        }

        public String getGAddress() {
            return gAddress;
        }

        public void setGAddress(String gAddress) {
            this.gAddress = gAddress;
        }

        public String getGTel() {
            return gTel;
        }

        public void setGTel(String gTel) {
            this.gTel = gTel;
        }

        public String getGContactor() {
            return gContactor;
        }

        public void setGContactor(String gContactor) {
            this.gContactor = gContactor;
        }

        public int getGTitle() {
            return gTitle;
        }

        public void setGTitle(int gTitle) {
            this.gTitle = gTitle;
        }

        public String getGCode() {
            return gCode;
        }

        public void setGCode(String gCode) {
            this.gCode = gCode;
        }

        public int getParentID() {
            return parentID;
        }

        public void setParentID(int parentID) {
            this.parentID = parentID;
        }
    }
}
