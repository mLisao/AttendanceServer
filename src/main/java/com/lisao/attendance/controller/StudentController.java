package com.lisao.attendance.controller;

import com.lisao.attendance.dao.StudentDao;
import com.lisao.attendance.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lisao on 2016/5/15.
 */
@RequestMapping("/api/student")
@Controller
public class StudentController {

    @Resource
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllStudent(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int limit) {
        List<Student> students = studentDao.getAllStudent(page, limit);
        return students;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getStudent(@PathVariable("id") int id) {
        Student student = studentDao.findById(id);
        return student;
    }
}
