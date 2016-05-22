package com.lisao.attendance.dao;

import com.lisao.attendance.entity.Schedule;

import java.util.List;

/**
 * Created by lisao on 2016/5/10.
 */
public interface ScheduleDao {
    /**
     * 添加
     *
     * @param schedule
     */
    void addSchedule(Schedule schedule);

    /**
     * 获取所有的课表
     *
     * @return
     */
    List<Schedule> getAllSchedule();
}
