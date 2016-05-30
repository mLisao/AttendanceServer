package com.lisao.attendance.controller;

import com.alibaba.fastjson.JSON;
import com.lisao.attendance.dao.StudentDao;
import com.lisao.attendance.dao.TeacherDao;
import com.lisao.attendance.daoimpl.StudentDaoImpl;
import com.lisao.attendance.entity.ErrorCode;
import com.lisao.attendance.entity.Student;
import com.lisao.attendance.entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by lisao on 2016/4/25.
 * 用户管理类
 */
@Controller
@RequestMapping("/api/account")
public class AccountController {

    @Resource
    private StudentDao studentDao;

    @Resource
    private TeacherDao teacherDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    /**
     * 用户登录
     *
     * @param number
     * @param password
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object studentLogin(@RequestParam("password") String password, @RequestParam("number") long number) {
        Student student = studentDao.findByNumberAndPwd(number, password);
        if (student == null) {
            return new ErrorCode(ErrorCode.FAILURE, "学号或密码错误");
        }
        return student;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object studentRegister(@RequestBody Student student) {
        System.out.println(JSON.toJSONString(student));
        if (studentDao.findByName(student.getNumber()) != null) {//通过学号查询
            return new ErrorCode(ErrorCode.FAILURE, "账号已经被注册");
        } else {
            studentDao.insert(student);
        }
        return student;
    }

    /**
     * 教师的注册
     *
     * @param name
     * @param password
     * @param number
     * @return
     */
    @RequestMapping(value = "/teacher/register", method = RequestMethod.POST)
    @ResponseBody
    public Object teacherRegister(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("number") long number) {
        Teacher teacher = teacherDao.findByNumber(number);
        if (teacher != null) {
            return new ErrorCode(ErrorCode.FAILURE, "账号已经被注册");
        } else {
            teacher = new Teacher();
            teacher.setName(name);
            teacher.setNumber(number);
            teacher.setPassword(password);
            teacherDao.addTeacher(teacher);
        }
        return teacher;
    }

    @RequestMapping(value = "/teacher/login", method = RequestMethod.POST)
    @ResponseBody
    public Object teacherLogin(@RequestParam("password") String password, @RequestParam("number") long number) {
        Teacher teacher = teacherDao.findByNumberAndPassword(number, password);
        if (teacher == null) {
            return new ErrorCode(ErrorCode.FAILURE, "工号或密码错误");
        }
        return teacher;
    }
}
