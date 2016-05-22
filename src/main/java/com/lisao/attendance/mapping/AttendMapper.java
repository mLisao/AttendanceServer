package com.lisao.attendance.mapping;

import com.lisao.attendance.entity.Attend;
import com.lisao.attendance.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lisao on 2016/5/15.
 */
public interface AttendMapper {
    @Select("SELECT COUNT(*) FROM attend WHERE scheduleId =  #{scheduleId}")
    int getAttendCount(int scheduleId);

    @Insert("INSERT INTO attend(studentId,attendTime,scheduleId) values(#{studentId},#{attendTime},#{scheduleId})")
    void addAttend(Attend attend);

    @Select("SELECT * FROM student WHERE  id in (SElECT studentId FROM attend WHERE scheduleId = #{scheduleId})")
    List<Student> getAttendStudent(int scheduleId);
}
