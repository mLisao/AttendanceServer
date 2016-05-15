package com.lisao.attendance.entity.base;


import java.io.Serializable;

/**
 * Created by lisao on 2016/1/7.
 * 基础的实体类
 */
public class BaseEntity implements Serializable {
    protected int id;

    public BaseEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
