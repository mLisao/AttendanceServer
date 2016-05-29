package com.lisao.attendance.controller;

import com.lisao.attendance.dao.ScheduleDao;
import com.lisao.attendance.entity.Schedule;
import com.lisao.attendance.entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Object addSchedule(Schedule schedule) {
        scheduleDao.addSchedule(schedule);
        return schedule;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllScheduleById(@PathVariable("id") int id) {
        return scheduleDao.getScheduleById(id);

    }
}
