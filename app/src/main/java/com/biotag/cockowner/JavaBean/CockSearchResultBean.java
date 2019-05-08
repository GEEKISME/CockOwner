package com.biotag.cockowner.JavaBean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Lxh on 2017/8/22.
 */

public class CockSearchResultBean {

    /**
     * IsSuccess : true
     * Values : [{"ID":41,"chipCode":"943000100000005","cockNo":"123456    ",
     * "breedID":1,"memo":"my dock  ","birth":"2017-08-21T00:00:00","Birth":"08-21-2017","orgID":0,
     * "cStatus":1,"farmID":0,"creatorid":10003,"createAt":"2017-08-21T13:49:16.267","lastOwnerID":0,
     * "regDate1":null,"regDate2":null,"regDate3":null,"isImport":false,"importerID":0,"mFarmName":"",
     * "OrgName":"","ownerName":"","breedName":"Vietnamese FightCock","dictName":"","importerName":null},
     * {"ID":40,"chipCode":"943000100000005","cockNo":"123       ","breedID":1,"memo":"my cock",
     * "birth":"2017-08-21T00:00:00","Birth":"08-21-2017","orgID":0,"cStatus":1,"farmID":1,
     * "creatorid":10003,"createAt":"2017-08-21T13:14:35.95","lastOwnerID":0,"regDate1":null,
     * "regDate2":null,"regDate3":null,"isImport":false,"importerID":0,"mFarmName":"zhuhai","OrgName":"",
     * "ownerName":"","breedName":"Vietnamese FightCock","dictName":"Calirana","importerName":null},
     * {"ID":39,"chipCode":"943000100000005","cockNo":"123       ","breedID":1,"memo":"my cock",
     * "birth":"2017-08-21T00:00:00","Birth":"08-21-2017","orgID":0,"cStatus":1,"farmID":1,
     * "creatorid":10003,"createAt":"2017-08-21T13:14:35.45","lastOwnerID":0,"regDate1":null,
     * "regDate2":null,"regDate3":null,"isImport":false,"importerID":0,"mFarmName":"zhuhai","OrgName":"",
     * "ownerName":"","breedName":"Vietnamese FightCock","dictName":"Calirana","importerName":null},
     * {"ID":38,"chipCode":"943000100000005","cockNo":"123       ","breedID":1,"memo":"my cock",
     * "birth":"2017-08-21T00:00:00","Birth":"08-21-2017","orgID":0,"cStatus":1,"farmID":1,
     * "creatorid":10003,"createAt":"2017-08-21T13:14:35.423","lastOwnerID":0,"regDate1":null,
     * "regDate2":null,"regDate3":null,"isImport":false,"importerID":0,"mFarmName":"zhuhai","OrgName":"",
     * "ownerName":"","breedName":"Vietnamese FightCock","dictName":"Calirana","importerName":null},
     * {"ID":37,"chipCode":"943000100000005","cockNo":"123       ","breedID":1,"memo":"my cock","birth":
     * "2017-08-21T00:00:00","Birth":"08-21-2017","orgID":0,"cStatus":1,"farmID":1,"creatorid":10003,"cre
     * ateAt":"2017-08-21T13:14:35.403","lastOwnerID":0,"regDate1":null,"regDate2":null,"regDate3":null,"i
     * sImport":false,"importerID":0,"mFarmName":"zhuhai","OrgName":"","ownerName":"","breedName":"Vietna
     * mese FightCock","dictName":"Calirana","importerName":null},{"ID":36,"chipCode":"943000100000005","
     * cockNo":"123       ","breedID":1,"memo":"my cock","birth":"2017-08-21T00:00:00","Birth":"08-21-201
     * 7","orgID":0,"cStatus":1,"farmID":1,"creatorid":10003,"createAt":"2017-08-21T11:18:26.82","lastOwn
     * erID":0,"regDate1":null,"regDate2":null,"regDate3":null,"isImport":false,"importerID":0,"mFarmName
     * ":"zhuhai","OrgName":"","ownerName":"","breedName":"Vietnamese FightCock","dictName":"Calirana","i
     * mporterName":null},{"ID":35,"chipCode":"943000100000005","cockNo":"123       ","breedID":1,"memo":"
     * my cock","birth":"2017-08-21T00:00:00","Birth":"08-21-2017","orgID":0,"cStatus":1,"farmID":1,"creat
     * orid":10003,"createAt":"2017-08-21T11:18:06.28","lastOwnerID":0,"regDate1":null,"regDate2":null,"re
     * gDate3":null,"isImport":false,"importerID":0,"mFarmName":"zhuhai","OrgName":"","ownerName":"","bree
     * dName":"Vietnamese FightCock","dictName":"Calirana","importerName":null},{"ID":34,"chipCode":"9430
     * 00100000005","cockNo":"123456    ","breedID":1,"memo":"my cock","birth":"2017-08-21T00:00:00","Bir
     * th":"08-21-2017","orgID":0,"cStatus":1,"farmID":1,"creatorid":10003,"createAt":"2017-08-21T10:46:
     * 26.523","lastOwnerID":0,"regDate1":null,"regDate2":null,"regDate3":null,"isImport":false,"importe
     * rID":0,"mFarmName":"zhuhai","OrgName":"","ownerName":"","breedName":"Vietnamese FightCock","dictNa
     * me":"Calirana","importerName":null},{"ID":26,"chipCode":"943000100000004","cockNo":"0000000004",
     * "breedID":1,"memo":"break","birth":"2017-08-01T00:00:00","Birth":"08-01-2017","orgID":3,"cStatus"
     * :1,"farmID":1,"creatorid":3,"createAt":"2017-08-18T12:58:59.833","lastOwnerID":10005,"regDate1":null
     * ,"regDate2":null,"regDate3":null,"isImport":true,"importerID":1,"mFarmName":"zhuhai","OrgName":
     * "ASSOCIATION OF GAMEFOWL BREEDERS OF CAGAYAN","ownerName":"jon","breedName":"Vietnamese FightCock",
     * "dictName":"Calirana","importerName":null},{"ID":25,"chipCode":"943000100000003","cockNo":"00000000
     * 03","breedID":1,"memo":"break","birth":"2017-08-01T00:00:00","Birth":"08-01-2017","orgID":3,
     * "cStatus":1,"farmID":1,"creatorid":3,"createAt":"2017-08-18T12:57:34.34","lastOwnerID":10007,
     * "regDate1":null,"regDate2":null,"regDate3":null,"isImport":true,"importerID":1,"mFarmName":"zhuhai",
     * "OrgName":"ASSOCIATION OF GAMEFOWL BREEDERS OF CAGAYAN","ownerName":"cheng","breedName":"Vietnamese
     * FightCock","dictName":"Calirana","importerName":null}]
     * Status : 0
     * TotalCount : 11
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

    public static class ValuesBean implements Parcelable {
        /**
         * ID : 41
         * chipCode : 943000100000005
         * cockNo : 123456
         * breedID : 1
         * memo : my dock
         * birth : 2017-08-21T00:00:00
         * Birth : 08-21-2017
         * orgID : 0
         * cStatus : 1
         * farmID : 0
         * creatorid : 10003
         * createAt : 2017-08-21T13:49:16.267
         * lastOwnerID : 0
         * regDate1 : null
         * regDate2 : null
         * regDate3 : null
         * isImport : false
         * importerID : 0
         * mFarmName :
         * OrgName :
         * ownerName :
         * breedName : Vietnamese FightCock
         * dictName :
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

        protected ValuesBean(Parcel in) {
            ID = in.readInt();
            chipCode = in.readString();
            cockNo = in.readString();
            breedID = in.readInt();
            memo = in.readString();
            birth = in.readString();
            Birth = in.readString();
            orgID = in.readInt();
            cStatus = in.readInt();
            farmID = in.readInt();
            creatorid = in.readInt();
            createAt = in.readString();
            lastOwnerID = in.readInt();
            isImport = in.readByte() != 0;
            importerID = in.readInt();
            mFarmName = in.readString();
            OrgName = in.readString();
            ownerName = in.readString();
            breedName = in.readString();
            dictName = in.readString();
        }

        public static final Creator<ValuesBean> CREATOR = new Creator<ValuesBean>() {
            @Override
            public ValuesBean createFromParcel(Parcel in) {
                return new ValuesBean(in);
            }

            @Override
            public ValuesBean[] newArray(int size) {
                return new ValuesBean[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

            dest.writeInt(ID);
            dest.writeString(chipCode);
            dest.writeString(cockNo);
            dest.writeInt(breedID);
            dest.writeString(memo);
            dest.writeString(birth);
            dest.writeString(Birth);
            dest.writeInt(orgID);
            dest.writeInt(cStatus);
            dest.writeInt(farmID);
            dest.writeInt(creatorid);
            dest.writeString(createAt);
            dest.writeInt(lastOwnerID);
            dest.writeByte((byte) (isImport ? 1 : 0));
            dest.writeInt(importerID);
            dest.writeString(mFarmName);
            dest.writeString(OrgName);
            dest.writeString(ownerName);
            dest.writeString(breedName);
            dest.writeString(dictName);
        }
    }
}
