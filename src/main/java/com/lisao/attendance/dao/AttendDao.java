package com.lisao.attendance.dao;

import com.lisao.attendance.entity.Attend;
import com.lisao.attendance.entity.MyAttend;
import com.lisao.attendance.entity.Student;

import java.util.List;

/**
 * Created by lisao on 2016/5/15.
 * 签到记录表
 */
public interface AttendDao {
    /**
     * 添加一条签到记录
     *
     * @param attend
     */
    void addAttend(Attend attend);

    /**
     * 获取签到的个数
     *
     * @param classRoomId
     */
    int getAttendCount(int classRoomId);

    /**
     * 通过学生ID 查找签到
     *
     * @param id
     * @return
     */
    List<MyAttend> getMyAttend(int id);

    /**
     * 获取签到的学生
     *
     * @param classRoomId
     * @return
     */
    List<Student> getAttendStudent(int classRoomId);
}
