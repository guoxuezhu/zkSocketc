package com.lh.zksocketc.data.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class IcCardNumer {

    @SerializedName("card_no")
    public String cardNum;

    @Generated(hash = 1779761528)
    public IcCardNumer(String cardNum) {
        this.cardNum = cardNum;
    }

    @Generated(hash = 223116768)
    public IcCardNumer() {
    }

    @Override
    public String toString() {
        return "IcCardNumer{" +
                "cardNum='" + cardNum + '\'' +
                '}';
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}