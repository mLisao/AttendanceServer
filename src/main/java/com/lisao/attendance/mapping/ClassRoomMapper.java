package com.lisao.attendance.mapping;

import com.lisao.attendance.entity.ClassRoom;
import com.lisao.attendance.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by lisao on 2016/5/15.
 */
public interface ClassRoomMapper {
    @Select("SELECT * FROM classroom WHERE id = #{id}")
    ClassRoom selectClassRoomById(int id);

    @Select("SELECT * FROM classroom WHERE teacherId = #{teacherId}")
    Teacher selectClassRoomByNumber(int teacherId);

    @Select("SELECT * FROM classroom")
    List<Teacher> selectAll();

    @Insert("INSERT INTO classroom(startTime,endTime,endAttendTime,address,teacherId) " +
            "values(#{startTime},#{endTime},#{endAttendTime},#{address},#{teacherId})")
    void addClassRoom(ClassRoom classRoom);
}
