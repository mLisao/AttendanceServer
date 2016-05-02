package com.lisao.attendance.mapping;

import com.lisao.attendance.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lisao on 2016/5/2.
 */
public interface StudentManager {
    @Select("SELECT * FROM student WHERE id = #{id}")
    Student selectStudentById(int id);

    @Insert("INSERT INTO student value()")
    void addStudent(Student student);
}
