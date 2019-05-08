package com.biotag.cockowner.JavaBean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Lxh on 2017/9/7.
 */

public class ContestBean {


    /**
     * IsSuccess : true
     * Values : [{"ID":1,"derby":"BULLANG BULLANG","isdeleted":false},{"ID":2,"derby":"President's Cup",
     * "isdeleted":false},{"ID":6,"derby":"derby test 1","isdeleted":false},{"ID":7,"derby":"derby test 2",
     * "isdeleted":false},{"ID":8,"derby":"derby test 3","isdeleted":false},{"ID":9,"derby":"derby test 4",
     * "isdeleted":false},{"ID":10,"derby":"derby test 5","isdeleted":false},{"ID":11,"derby":"derby test 6",
     * "isdeleted":false},{"ID":12,"derby":"derby test 7","isdeleted":false},{"ID":13,"derby":"derby test 8",
     * "isdeleted":false},{"ID":14,"derby":"derby test 9","isdeleted":false},{"ID":15,"derby":"derby test 10",
     * "isdeleted":false},{"ID":16,"derby":"derby test 11","isdeleted":false},{"ID":17,"derby":"derby test 12",
     * "isdeleted":false},{"ID":18,"derby":"derby test 13","isdeleted":false},{"ID":19,"derby":"derby test 14",
     * "isdeleted":false},{"ID":21,"derby":"derby test 15","isdeleted":false},{"ID":22,"derby":"derby test 16",
     * "isdeleted":false},{"ID":23,"derby":"derby test 17","isdeleted":false}]
     * Status : 0
     * TotalCount : 0
     */

    private boolean IsSuccess;
    private int Status;
    private int TotalCount;
    private List<ValuesBean> Values;

    public static ContestBean objectFromData(String str) {

        return new Gson().fromJson(str, ContestBean.class);
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
         * ID : 1
         * derby : BULLANG BULLANG
         * isdeleted : false
         */

        private int ID;
        private String derby;
        private boolean isdeleted;

        public static ValuesBean objectFromData(String str) {

            return new Gson().fromJson(str, ValuesBean.class);
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getDerby() {
            return derby;
        }

        public void setDerby(String derby) {
            this.derby = derby;
        }

        public boolean isIsdeleted() {
            return isdeleted;
        }

        public void setIsdeleted(boolean isdeleted) {
            this.isdeleted = isdeleted;
        }
    }
}
