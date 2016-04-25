package com.lisao.attendance.controller;

import com.lisao.attendance.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    /**
     * 路径参数
     *
     * @param model
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/result/{name}/{age}", method = RequestMethod.GET)
    public String result(ModelMap model, @PathVariable("name") String name, @PathVariable("age") String age) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "result";
    }

    /**
     * 传统传递参数的方式
     *
     * @param model
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String params(ModelMap model, @RequestParam String name, @RequestParam String age) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "result";
    }

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(HttpServletResponse response, @RequestParam(defaultValue = "111") String id) throws IOException {
        Student student = new Student();
        student.setId(Long.parseLong(id));
        return student;
    }

    @RequestMapping(value = "/json")
    @ResponseBody
    public Student getJson() {
        Student student = new Student();
        student.setNumber(333);
        return student;
    }
}