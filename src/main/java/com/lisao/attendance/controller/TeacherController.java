package com.lisao.attendance.controller;

import com.lisao.attendance.dao.TeacherDao;
import com.lisao.attendance.entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lisao on 2016/5/29.
 */
@Controller
@RequestMapping("/api/teacher")
public class TeacherController {

    @Resource
    private TeacherDao teacherDao;

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Object getTeacher(@PathVariable("id") int id) {
        return teacherDao.findById(id);
    }
}
