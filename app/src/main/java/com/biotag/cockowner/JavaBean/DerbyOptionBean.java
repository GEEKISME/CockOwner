package com.biotag.cockowner.JavaBean;

/**
 * Created by Lxh on 2017/11/27.
 */

public class DerbyOptionBean {
    boolean isChecked;
    String  Derbyoption;

    public DerbyOptionBean(boolean isChecked, String derbyoption) {
        this.isChecked = isChecked;
        Derbyoption = derbyoption;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getDerbyoption() {
        return Derbyoption;
    }

    public void setDerbyoption(String derbyoption) {
        Derbyoption = derbyoption;
    }
}
