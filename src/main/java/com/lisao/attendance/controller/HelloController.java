package com.lisao.attendance.controller;

import com.lisao.attendance.entity.Student;
import com.lisao.attendance.mapping.StudentManager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentManager mapper = session.getMapper(StudentManager.class);
            Student student = new Student();
            student.setName("张三");
            student.setNumber(System.currentTimeMillis()/10000);
            student.setPassword("12313");
            mapper.addStudent(student);
            session.commit();
            // do work
        } finally {
            session.close();
        }
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
    public List<Student> getJson() {
        SqlSession session = sqlSessionFactory.openSession();
        List<Student> students = null;
        try {
            StudentManager mapper = session.getMapper(StudentManager.class);
            students = mapper.getAllUser();
            session.commit();
        } finally {
            session.close();
        }
        return students;
    }
}