package com.lisao.attendance.daoimpl;

import com.lisao.attendance.dao.StudentDao;
import com.lisao.attendance.entity.Student;
import com.lisao.attendance.mapping.StudentManager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lisao on 2016/5/10.
 */
public class StudentDaoImpl implements StudentDao {

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    @Override
    public boolean insert(Student student) {
        return false;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student findByName(long number) {
        SqlSession session = sqlSessionFactory.openSession();
        Student student = null;
        try {
            StudentManager mapper = session.getMapper(StudentManager.class);
            student = mapper.selectStudentByNumber(number);
            session.commit();
        } finally {
            session.close();
        }
        return student;
    }

    @Override
    public Student findByNumberAndPwd(long number, String password) {
        SqlSession session = sqlSessionFactory.openSession();
        Student student = null;
        try {
            StudentManager mapper = session.getMapper(StudentManager.class);
            student = mapper.selectStudentByNumberAndPwd(number, password);
            session.commit();
        } finally {
            session.close();
        }
        return student;
    }


    @Override
    public List<Student> getAllStudent(int page, int limit) {
        return null;
    }

    @Override
    public boolean updateStudentInfo(Student student) {
        return false;
    }

    @Override
    public boolean removeStudent(Student student) {
        return false;
    }
}
