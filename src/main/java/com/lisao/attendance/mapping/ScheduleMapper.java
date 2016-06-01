package com.lisao.attendance.mapping;

import com.lisao.attendance.entity.Schedule;
import com.lisao.attendance.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by lisao on 2016/5/15.
 */
public interface ScheduleMapper {
    @Select("SELECT * FROM schedule WHERE id = #{id}")
    Schedule selectScheduleById(int id);

    @Select("SELECT * FROM schedule WHERE teacherId = #{teacherId}")
    Schedule selectScheduleByNumber(int teacherId);

    @Select("SELECT * FROM schedule")
    List<Schedule> selectAll();

    @Insert("INSERT INTO schedule(startTime,endTime,endAttendTime,address,teacherId,week,startWeek,endWeek) " +
            "values(#{startTime},#{endTime},#{endAttendTime},#{address},#{teacher.id},#{week},#{startWeek},#{endWeek})")
    void addSchedule(Schedule schedule);
}
