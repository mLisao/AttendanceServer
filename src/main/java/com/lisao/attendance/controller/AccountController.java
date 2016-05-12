package com.lisao.attendance.controller;

import com.alibaba.fastjson.JSON;
import com.lisao.attendance.dao.StudentDao;
import com.lisao.attendance.daoimpl.StudentDaoImpl;
import com.lisao.attendance.entity.ErrorCode;
import com.lisao.attendance.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
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

    /**
     * 用户注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void studentRegister() {
    }
}
