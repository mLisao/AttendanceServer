package com.lisao.attendance.mapping;

import com.lisao.attendance.entity.Schedule;
import com.lisao.attendance.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lisao on 2016/5/15.
 */
public interface ScheduleMapper {
    @Select("SELECT * FROM schedule WHERE id = #{id}")
    Schedule selectClassRoomById(int id);

    @Select("SELECT * FROM schedule WHERE teacherId = #{teacherId}")
    Teacher selectClassRoomByNumber(int teacherId);

    @Select("SELECT * FROM schedule")
    List<Teacher> selectAll();

    @Insert("INSERT INTO classroom(startTime,endTime,endAttendTime,address,teacherId) " +
            "values(#{startTime},#{endTime},#{endAttendTime},#{address},#{teacherId})")
    void addClassRoom(Schedule schedule);
}
