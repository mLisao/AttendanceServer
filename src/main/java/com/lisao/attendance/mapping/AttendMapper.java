package com.lisao.attendance.mapping;

import com.lisao.attendance.entity.Attend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lisao on 2016/5/15.
 */
public interface AttendMapper {
    @Select("SELECT COUNT(*) FORM attend WHERE classRoomId =  #{classRoomId}")
    int getAttendCount(int classRoomId);

    @Insert("INSERT INTO attend(studentId,attendTime,classRoomId) values(#{studentId},#{attendTime},#{classRoomId})")
    void addAttend(Attend attend);
}
