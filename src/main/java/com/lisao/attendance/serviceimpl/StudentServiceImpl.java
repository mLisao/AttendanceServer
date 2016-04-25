package com.lisao.attendance.serviceimpl;

import com.lisao.attendance.entity.Student;
import com.lisao.attendance.service.StudentService;

/**
 * Created by lisao on 2016/1/29.
 */
public class StudentServiceImpl implements StudentService {

    @Override
    public Student login(long identity, String password) {
        Student student = new Student();
        student.setNumber(identity);
        student.setPassword(password);
        return student;
    }
}
