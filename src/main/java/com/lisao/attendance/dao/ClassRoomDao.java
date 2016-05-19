package com.lisao.attendance.dao;

import com.lisao.attendance.entity.Schedule;

/**
 * Created by lisao on 2016/5/10.
 */
public interface ClassRoomDao {
    /**
     * 添加
     * @param schedule
     */
    void addClassRoom(Schedule schedule);
}
