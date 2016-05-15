package com.lisao.attendance.dao;

import com.lisao.attendance.entity.Teacher;

import java.util.List;

/**
 * Created by lisao on 2016/5/10.
 */
public interface TeacherDao {
    /**
     * 添加一个老师
     *
     * @param teacher
     * @return
     */
    boolean addTeacher(Teacher teacher);

    /**
     * 通过Id查找一个老师
     *
     * @param id
     * @return
     */
    Teacher findById(int id);

    /**
     * 通过工号查找一个老师
     *
     * @param number
     * @return
     */
    Teacher findByNumber(long number);

    /**
     * 通过工号和密码查找一个老师
     *
     * @param number
     * @return
     */
    Teacher findByNumberAndPassword(long number, String password);

    /**
     * 获取所有老师的信息
     *
     * @param page
     * @param limit
     * @return
     */
    List<Teacher> getAllTeacher(int page, int limit);

    /**
     * 更新老师的信息
     *
     * @param teacher
     * @return
     */
    boolean updateTeacherInfo(Teacher teacher);


    /**
     * 移除一个老师
     *
     * @param teacher
     */
    void removeTeacher(Teacher teacher);


}
