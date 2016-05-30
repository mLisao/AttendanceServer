package com.lisao.attendance.mapping;

import com.lisao.attendance.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by lisao on 2016/5/2.
 */
public interface StudentMapper {
    @Select("SELECT * FROM student WHERE id = #{id}")
    Student selectStudentById(int id);

    @Select("SELECT * FROM student WHERE number = #{number}")
    Student selectStudentByNumber(long number);

    @Select("SELECT * FROM student WHERE number = #{0} AND password = #{1}")
    Student selectStudentByNumberAndPwd(long number, String password);

    @Insert("INSERT INTO student(name,number,password,sex,qq,mobileNumber,avatar,college,major,grade) " +
            "values(#{name},#{number},#{password},#{sex},#{qq},#{mobileNumber},#{avatar},#{college},#{major},#{grade})")
    void addStudent(Student student);

    @Select("SELECT * FROM student LIMIT #{0}, #{1}")
    List<Student> getAllUser(int page, int limit);

    @Update("UPDATE student SET " +
            "name = #{name}, " +
            "sex = #{sex}, " +
            "number = #{number}, " +
            "qq = #{qq}, " +
            "mobileNumber = #{mobileNumber}, " +
            "college = #{college}, " +
            "major = #{major}, " +
            "grade = #{grade}, " +
            "password = #{password} where id = #{id}")
    void updateStudentInfo(Student student);


}
