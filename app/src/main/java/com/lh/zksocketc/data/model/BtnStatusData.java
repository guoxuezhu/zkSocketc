package com.lh.zksocketc.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class BtnStatusData {

    public String btnName;

    @Id
    public long btnId;

    public String btnStatus;

    @Generated(hash = 1291116764)
    public BtnStatusData(String btnName, long btnId, String btnStatus) {
        this.btnName = btnName;
        this.btnId = btnId;
        this.btnStatus = btnStatus;
    }

    @Generated(hash = 402401864)
    public BtnStatusData() {
    }

    @Override
    public String toString() {
        return "BtnStatusData{" +
                "btnName='" + btnName + '\'' +
                ", btnId=" + btnId +
                ", btnStatus='" + btnStatus + '\'' +
                '}';
    }

    public String getBtnName() {
        return this.btnName;
    }

    public void setBtnName(String btnName) {
        this.btnName = btnName;
    }

    public long getBtnId() {
        return this.btnId;
    }

    public void setBtnId(long btnId) {
        this.btnId = btnId;
    }

    public String getBtnStatus() {
        return this.btnStatus;
    }

    public void setBtnStatus(String btnStatus) {
        this.btnStatus = btnStatus;
    }
}