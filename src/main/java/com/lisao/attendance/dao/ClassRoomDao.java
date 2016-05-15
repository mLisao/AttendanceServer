package com.lisao.attendance.dao;

import com.lisao.attendance.entity.ClassRoom;
import com.lisao.attendance.entity.Teacher;

import java.util.List;

/**
 * Created by lisao on 2016/5/10.
 */
public interface ClassRoomDao {
    /**
     * 添加
     * @param classRoom
     */
    void addClassRoom(ClassRoom classRoom);
}
