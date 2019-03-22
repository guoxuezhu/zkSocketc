package com.lh.zksocketc.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class MLsLists {

    @Id
    public Long id;

    public String name;

    public String mlStrs;

    @Generated(hash = 1677207339)
    public MLsLists(Long id, String name, String mlStrs) {
        this.id = id;
        this.name = name;
        this.mlStrs = mlStrs;
    }

    @Generated(hash = 525193264)
    public MLsLists() {
    }

    @Override
    public String toString() {
        return "MLsLists{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mlStrs='" + mlStrs + '\'' +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMlStrs() {
        return this.mlStrs;
    }

    public void setMlStrs(String mlStrs) {
        this.mlStrs = mlStrs;
    }
}