package com.biotag.cockowner.JavaBean;

/**
 * Created by Lxh on 2017/8/22.
 */

public class CockSearchBean {

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    private int ownerID ;
    private String chipCode;
    private String cockNo;
    private int breedID;
    private int orgID;
    private Byte cStatus;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int level;
    private int farmID;


    public String getIsImport() {
        return isImport;
    }

    public void setIsImport(String isImport) {
        this.isImport = isImport;
    }

    private String isImport;
    private int PageSize;
    private int CurrIndex;


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

    public int getOrgID() {
        return orgID;
    }

    public void setOrgID(int orgID) {
        this.orgID = orgID;
    }

    public Byte getcStatus() {
        return cStatus;
    }

    public void setcStatus(Byte cStatus) {
        this.cStatus = cStatus;
    }

    public int getFarmID() {
        return farmID;
    }

    public void setFarmID(int farmID) {
        this.farmID = farmID;
    }


    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getCurrIndex() {
        return CurrIndex;
    }

    public void setCurrIndex(int currIndex) {
        CurrIndex = currIndex;
    }
}
