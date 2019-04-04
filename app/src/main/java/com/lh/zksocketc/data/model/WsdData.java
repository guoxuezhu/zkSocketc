package com.lh.zksocketc.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class WsdData {

    public String wendu;

    public String shidu;

    public String pm25;




    @Generated(hash = 1121964496)
    public WsdData(String wendu, String shidu, String pm25) {
        this.wendu = wendu;
        this.shidu = shidu;
        this.pm25 = pm25;
    }




    @Generated(hash = 1774652197)
    public WsdData() {
    }




    @Override
    public String toString() {
        return "WsdData{" +
                "wendu='" + wendu + '\'' +
                ", shidu='" + shidu + '\'' +
                ", pm25='" + pm25 + '\'' +
                '}';
    }




    public String getWendu() {
        return this.wendu;
    }




    public void setWendu(String wendu) {
        this.wendu = wendu;
    }




    public String getShidu() {
        return this.shidu;
    }




    public void setShidu(String shidu) {
        this.shidu = shidu;
    }




    public String getPm25() {
        return this.pm25;
    }




    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }
}