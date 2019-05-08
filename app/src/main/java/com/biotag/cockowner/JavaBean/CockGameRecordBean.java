package com.biotag.cockowner.JavaBean;

/**
 * Created by Lxh on 2017/8/23.
 */

public class CockGameRecordBean {
    private String cock_chip1;
    private String cock_chip2;
    private int org_id ;
    private int createUser;
    private String win_cock;
    private String result_time;
    private String createAt;


    public String getCock_chip1() {
        return cock_chip1;
    }

    public void setCock_chip1(String cock_chip1) {
        this.cock_chip1 = cock_chip1;
    }

    public String getCock_chip2() {
        return cock_chip2;
    }

    public void setCock_chip2(String cock_chip2) {
        this.cock_chip2 = cock_chip2;
    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public int getCreateUser() {
        return createUser;
    }

    public void setCreateUser(int createUser) {
        this.createUser = createUser;
    }

    public String getWin_cock() {
        return win_cock;
    }

    public void setWin_cock(String win_cock) {
        this.win_cock = win_cock;
    }

    public String getResult_time() {
        return result_time;
    }

    public void setResult_time(String result_time) {
        this.result_time = result_time;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
