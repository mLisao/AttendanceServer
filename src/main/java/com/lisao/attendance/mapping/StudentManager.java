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

    @Insert("INSERT INTO student(name,number,password) values(#{name},#{number},#{password})")
    void addStudent(Student student);
}
