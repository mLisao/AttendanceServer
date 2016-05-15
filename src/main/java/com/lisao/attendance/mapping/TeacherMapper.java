package com.lisao.attendance.mapping;

import com.lisao.attendance.entity.Student;
import com.lisao.attendance.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by lisao on 2016/5/15.
 */
public interface TeacherMapper {
    @Select("SELECT * FROM teacher WHERE id = #{id}")
    Teacher selectTeacherById(int id);

    @Select("SELECT * FROM teacher WHERE number = #{number}")
    Teacher selectTeacherByNumber(int number);

    @Select("SELECT * FROM teacher")
    List<Teacher> selectAll();

    @Insert("INSERT INTO teacher(name,number,password) values(#{name},#{number},#{password})")
    void addTeacher(Teacher teacher);


    @Update("UPDATE student SET " +
            "name = #{name}, " +
            "number = #{number}, " +
            "mobileNumber = #{mobileNumber}, " +
            "email = #{email}, " +
            "password = #{password} where id = #{id}")
    void updateTeacherInfo(Teacher teacher);

}
