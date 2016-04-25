package com.lisao.attendance.entity;


import com.lisao.attendance.entity.base.BaseEntity;

/**
 * Created by lisao on 2016/1/8.
 */
public class Teacher extends BaseEntity {

    private String name;//姓名
    private long mobileNumber;//手机号码
    private String email;//邮箱

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
