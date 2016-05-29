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

    /**
     * 通过Id获取一个课表信息
     *
     * @param id
     * @return
     */
    Schedule getScheduleById(int id);
}
