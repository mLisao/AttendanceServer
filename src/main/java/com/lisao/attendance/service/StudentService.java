package com.lisao.attendance.service;

import com.lisao.attendance.entity.Student;

/**
 * Created by lisao on 2016/1/9.
 */
public interface StudentService {
    Student login(long identity, String password);
}
