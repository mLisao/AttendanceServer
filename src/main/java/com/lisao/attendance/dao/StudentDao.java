package com.lisao.attendance.dao;

import com.lisao.attendance.entity.Student;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lisao on 2016/5/10.
 */
public interface StudentDao {

    /**
     * 在数据库中插入一个学生
     *
     * @param student
     */
    boolean insert(Student student);

    /**
     * 通过Id查找一个学生
     *
     * @param id
     * @return
     */
    Student findById(int id);

    /**
     * 通过学号一个学生
     *
     * @param number
     * @return
     */
    Student findByName(long number);

    /**
     * 通过学号和密码查询学生
     *
     * @param number
     * @param password
     * @return
     */
    Student findByNumberAndPwd(long number, String password);

    /**
     * 获取所有的学生
     *
     * @return
     */
    List<Student> getAllStudent(int page, int limit);

    /**
     * 更新一个学生的信息
     *
     * @param student
     * @return
     */
    boolean updateStudentInfo(Student student);

    /**
     * 移除一个学生
     *
     * @param student
     * @return
     */
    boolean removeStudent(Student student);

}
