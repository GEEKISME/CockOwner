package com.biotag.cockowner.JavaBean;

/**
 * Created by Lxh on 2017/8/24.
 */

public class InputCockGameResultBean {

    /**
     * id : 4
     * cock_chip1 : 943000100000005
     * cock_chip2 : 943000100000004
     * org_id : 0
     * createUser : 0
     * createAt : 2017-08-24T09:44:43.78
     * win_cock :
     * result_time : null
     * OrgName :
     * creator_name :
     */

    private int id;
    private String cock_chip1;
    private String cock_chip2;
    private int org_id;
    private int createUser;
    private String createAt;
    private String win_cock;
    private Object result_time;
    private String OrgName;
    private String creator_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getWin_cock() {
        return win_cock;
    }

    public void setWin_cock(String win_cock) {
        this.win_cock = win_cock;
    }

    public Object getResult_time() {
        return result_time;
    }

    public void setResult_time(Object result_time) {
        this.result_time = result_time;
    }

    public String getOrgName() {
        return OrgName;
    }

    public void setOrgName(String OrgName) {
        this.OrgName = OrgName;
    }

    public String getCreator_name() {
        return creator_name;
    }

    public void setCreator_name(String creator_name) {
        this.creator_name = creator_name;
    }
}
