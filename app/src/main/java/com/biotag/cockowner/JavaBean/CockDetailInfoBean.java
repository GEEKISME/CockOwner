package com.biotag.cockowner.JavaBean;

/**
 * Created by Lxh on 2017/8/9.
 */

public class CockDetailInfoBean {


    /**
     * IsSuccess : true
     * Values : {"ID":21,"chipCode":"943000100000001","cockNo":"0000000001","breedID":1,"memo":"brmark","birth":"2017-05-04T00:00:00","Birth":"05-04-2017","orgID":5,"cStatus":3,"farmID":1,"creatorid":1,"createAt":"2017-08-16T13:13:09.74","lastOwnerID":10009,"regDate1":null,"regDate2":null,"regDate3":null,"isImport":true,"importerID":1,"mFarmName":"zhuhai","OrgName":"BREEDERS ASSOCIATION OF GAMEFOWL IN ILOCOS","ownerName":"nick","breedName":"Vietnamese FightCock","dictName":"Calirana","importerName":null}
     * Status : 1
     * TotalCount : 0
     */

    private boolean IsSuccess;
    private ValuesBean Values;
    private int Status;
    private int TotalCount;

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
         * ID : 21
         * chipCode : 943000100000001
         * cockNo : 0000000001
         * breedID : 1
         * memo : brmark
         * birth : 2017-05-04T00:00:00
         * Birth : 05-04-2017
         * orgID : 5
         * cStatus : 3
         * farmID : 1
         * creatorid : 1
         * createAt : 2017-08-16T13:13:09.74
         * lastOwnerID : 10009
         * regDate1 : null
         * regDate2 : null
         * regDate3 : null
         * isImport : true
         * importerID : 1
         * mFarmName : zhuhai
         * OrgName : BREEDERS ASSOCIATION OF GAMEFOWL IN ILOCOS
         * ownerName : nick
         * breedName : Vietnamese FightCock
         * dictName : Calirana
         * importerName : null
         */

        private int ID;
        private String chipCode;
        private String cockNo;
        private int breedID;
        private String memo;
        private String birth;
        private String Birth;
        private int orgID;
        private int cStatus;
        private int farmID;
        private int creatorid;
        private String createAt;
        private int lastOwnerID;
        private Object regDate1;
        private Object regDate2;
        private Object regDate3;
        private boolean isImport;
        private int importerID;
        private String mFarmName;
        private String OrgName;
        private String ownerName;
        private String breedName;
        private String dictName;
        private Object importerName;

        public String getDerby() {
            return derby;
        }

        public void setDerby(String derby) {
            this.derby = derby;
        }

        private String derby;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getChipCode() {
            return chipCode;
        }

        public void setChipCode(String chipCode) {
            this.chipCode = chipCode;
        }


        public String getCockNo() {
            return cockNo;
        }

        public void setCockNo(String cockNo) {
            this.cockNo = cockNo;
        }

        public int getBreedID() {
            return breedID;
        }

        public void setBreedID(int breedID) {
            this.breedID = breedID;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getbirth() {
            return birth;
        }

        public void setbirth(String birth) {
            this.birth = birth;
        }

        public String getBirth() {
            return Birth;
        }

        public void setBirth(String Birth) {
            this.Birth = Birth;
        }

        public int getOrgID() {
            return orgID;
        }

        public void setOrgID(int orgID) {
            this.orgID = orgID;
        }

        public int getCStatus() {
            return cStatus;
        }

        public void setCStatus(int cStatus) {
            this.cStatus = cStatus;
        }

        public int getFarmID() {
            return farmID;
        }

        public void setFarmID(int farmID) {
            this.farmID = farmID;
        }

        public int getCreatorid() {
            return creatorid;
        }

        public void setCreatorid(int creatorid) {
            this.creatorid = creatorid;
        }

        public String getCreateAt() {
            return createAt;
        }

        public void setCreateAt(String createAt) {
            this.createAt = createAt;
        }

        public int getLastOwnerID() {
            return lastOwnerID;
        }

        public void setLastOwnerID(int lastOwnerID) {
            this.lastOwnerID = lastOwnerID;
        }

        public Object getRegDate1() {
            return regDate1;
        }

        public void setRegDate1(Object regDate1) {
            this.regDate1 = regDate1;
        }

        public Object getRegDate2() {
            return regDate2;
        }

        public void setRegDate2(Object regDate2) {
            this.regDate2 = regDate2;
        }

        public Object getRegDate3() {
            return regDate3;
        }

        public void setRegDate3(Object regDate3) {
            this.regDate3 = regDate3;
        }

        public boolean isIsImport() {
            return isImport;
        }

        public void setIsImport(boolean isImport) {
            this.isImport = isImport;
        }

        public int getImporterID() {
            return importerID;
        }

        public void setImporterID(int importerID) {
            this.importerID = importerID;
        }

        public String getMFarmName() {
            return mFarmName;
        }

        public void setMFarmName(String mFarmName) {
            this.mFarmName = mFarmName;
        }

        public String getOrgName() {
            return OrgName;
        }

        public void setOrgName(String OrgName) {
            this.OrgName = OrgName;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getBreedName() {
            return breedName;
        }

        public void setBreedName(String breedName) {
            this.breedName = breedName;
        }

        public String getDictName() {
            return dictName;
        }

        public void setDictName(String dictName) {
            this.dictName = dictName;
        }

        public Object getImporterName() {
            return importerName;
        }

        public void setImporterName(Object importerName) {
            this.importerName = importerName;
        }
    }
}
