package com.biotag.cockowner.JavaBean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Lxh on 2017/8/28.
 */

public class GetBreedInfoResultBean {


    /**
     * IsSuccess : true
     * Values : [{"id":1,"breedName":"Vietnamese FightCock","isDeleted":false},{"id":2,"breedName":"abb","isDeleted":true},{"id":3,"breedName":"abb","isDeleted":true},{"id":4,"breedName":"bcc","isDeleted":true},{"id":5,"breedName":"acc","isDeleted":true},{"id":6,"breedName":"dee","isDeleted":true},{"id":7,"breedName":"acc","isDeleted":false},{"id":8,"breedName":"bcc","isDeleted":true},{"id":9,"breedName":"bcc","isDeleted":true},{"id":10,"breedName":"bcc","isDeleted":true}]
     * Status : 0
     * TotalCount : 10
     */

    private boolean IsSuccess;
    private int Status;
    private int TotalCount;
    private List<ValuesBean> Values;

    public static GetBreedInfoResultBean objectFromData(String str) {

        return new Gson().fromJson(str, GetBreedInfoResultBean.class);
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
         * breedName : Vietnamese FightCock
         * isDeleted : false
         */

        private int id;
        private String breedName;
        private boolean isDeleted;

        public static ValuesBean objectFromData(String str) {

            return new Gson().fromJson(str, ValuesBean.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBreedName() {
            return breedName;
        }

        public void setBreedName(String breedName) {
            this.breedName = breedName;
        }

        public boolean isIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
        }
    }
}
