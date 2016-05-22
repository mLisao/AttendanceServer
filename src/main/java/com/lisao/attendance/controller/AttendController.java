package com.lisao.attendance.controller;

import com.lisao.attendance.dao.AttendDao;
import com.lisao.attendance.entity.Attend;
import com.lisao.attendance.entity.Student;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by lisao on 2016/5/15.
 */
@Controller
@RequestMapping("/api/attend")
public class AttendController {
    @Resource
    private AttendDao attendDao;

    public void setAttendDao(AttendDao attendDao) {
        this.attendDao = attendDao;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addAttend() {
        Attend attend = new Attend();
        attend.setAttendTime(new Date());
        attend.setScheduleId(1);
        attend.setStudentId(1);
        attendDao.addAttend(attend);
        return attend;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getStudent(@PathVariable("id") int id) {
        return attendDao.getAttendStudent(id);
    }
}
