package com.lisao.attendance.daoimpl;

import com.lisao.attendance.dao.TeacherDao;
import com.lisao.attendance.entity.Teacher;
import com.lisao.attendance.mapping.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lisao on 2016/5/15.
 */
public class TeacherDaoImpl implements TeacherDao {

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public boolean addTeacher(Teacher teacher) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            mapper.addTeacher(teacher);
            session.commit();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public Teacher findById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        Teacher teacher = null;
        try {
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            teacher = mapper.selectTeacherById(id);
            session.commit();
        } finally {
            session.close();
        }
        return teacher;
    }

    @Override
    public Teacher findByNumber(long number) {
        SqlSession session = sqlSessionFactory.openSession();
        Teacher teacher = null;
        try {
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            teacher = mapper.selectTeacherByNumber(number);
            session.commit();
        } finally {
            session.close();
        }
        return teacher;
    }

    @Override
    public Teacher findByNumberAndPassword(long number, String password) {
        SqlSession session = sqlSessionFactory.openSession();
        Teacher teacher = null;
        try {
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            teacher = mapper.selectTeacherByNumberAndPassword(number, password);
            session.commit();
        } finally {
            session.close();
        }
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeacher(int page, int limit) {
        SqlSession session = sqlSessionFactory.openSession();
        List<Teacher> teachers = null;
        try {
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            teachers = mapper.selectAll();
            session.commit();
        } finally {
            session.close();
        }
        return teachers;
    }

    @Override
    public boolean updateTeacherInfo(Teacher teacher) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            mapper.updateTeacherInfo(teacher);
            session.commit();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public void removeTeacher(Teacher teacher) {
    }
}
