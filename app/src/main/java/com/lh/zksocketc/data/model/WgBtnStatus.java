package com.lh.zksocketc.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class WgBtnStatus {

    public String Lstatus1;

    public String Lstatus2;

    public String Mstatus1;

    public String Mstatus2;

    @Generated(hash = 1483476603)
    public WgBtnStatus(String Lstatus1, String Lstatus2, String Mstatus1,
            String Mstatus2) {
        this.Lstatus1 = Lstatus1;
        this.Lstatus2 = Lstatus2;
        this.Mstatus1 = Mstatus1;
        this.Mstatus2 = Mstatus2;
    }

    @Generated(hash = 955203894)
    public WgBtnStatus() {
    }

    @Override
    public String toString() {
        return "WgBtnStatus{" +
                "Lstatus1='" + Lstatus1 + '\'' +
                ", Lstatus2='" + Lstatus2 + '\'' +
                ", Mstatus1='" + Mstatus1 + '\'' +
                ", Mstatus2='" + Mstatus2 + '\'' +
                '}';
    }

    public String getLstatus1() {
        return this.Lstatus1;
    }

    public void setLstatus1(String Lstatus1) {
        this.Lstatus1 = Lstatus1;
    }

    public String getLstatus2() {
        return this.Lstatus2;
    }

    public void setLstatus2(String Lstatus2) {
        this.Lstatus2 = Lstatus2;
    }

    public String getMstatus1() {
        return this.Mstatus1;
    }

    public void setMstatus1(String Mstatus1) {
        this.Mstatus1 = Mstatus1;
    }

    public String getMstatus2() {
        return this.Mstatus2;
    }

    public void setMstatus2(String Mstatus2) {
        this.Mstatus2 = Mstatus2;
    }
}