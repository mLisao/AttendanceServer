package com.lisao.attendance.entity;

import java.sql.Timestamp;

/**
 * Created by lisao on 2016/6/1.
 */
public class MyAttend {
    private Timestamp attendTime;
    private String name;

    public Timestamp getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(Timestamp attendTime) {
        this.attendTime = attendTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
