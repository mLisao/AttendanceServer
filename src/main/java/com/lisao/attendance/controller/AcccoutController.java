package com.lisao.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lisao on 2016/4/25.
 * 用户管理类
 */
@Controller
@RequestMapping("/account")
public class AcccoutController {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void studentLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void studentRegister() {
    }
}
