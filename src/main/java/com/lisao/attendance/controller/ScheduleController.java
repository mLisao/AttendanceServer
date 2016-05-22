package com.lisao.attendance.controller;

import com.lisao.attendance.dao.ScheduleDao;
import com.lisao.attendance.entity.Schedule;
import com.lisao.attendance.entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by lisao on 2016/5/22.
 */
@Controller
@RequestMapping(value = "/api/schedule")
public class ScheduleController {

    @Resource
    private ScheduleDao scheduleDao;

    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllSchedule() {
        return scheduleDao.getAllSchedule();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addAllSchedule() {
        Schedule schedule = new Schedule();
        schedule.setName("财务报表分析");
        schedule.setAddress("三教");
        schedule.setStartTime(new Date());
        schedule.setEndTime(new Date());
        schedule.setEndAttendTime(new Date());
        schedule.setEndWeek(13);
        schedule.setStartWeek(1);
        schedule.setWeek(1);
        schedule.setTeacherId(1);
        scheduleDao.addSchedule(schedule);
        return schedule;
    }
}
