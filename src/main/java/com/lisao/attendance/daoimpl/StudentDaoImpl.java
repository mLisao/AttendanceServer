package com.lisao.attendance.daoimpl;

import com.lisao.attendance.dao.StudentDao;
import com.lisao.attendance.entity.Student;
import com.lisao.attendance.mapping.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.addStudent(student);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    @Override
    public Student findById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        Student student = null;
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            student = mapper.selectStudentById(id);
            session.commit();
        } finally {
            session.close();
        }
        return student;
    }

    @Override
    public Student findByName(long number) {
        SqlSession session = sqlSessionFactory.openSession();
        Student student = null;
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
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
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            student = mapper.selectStudentByNumberAndPwd(number, password);
            session.commit();
        } finally {
            session.close();
        }
        return student;
    }


    @Override
    public List<Student> getAllStudent(int page, int limit) {
        SqlSession session = sqlSessionFactory.openSession();
        List<Student> students = new ArrayList<Student>();
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            students = mapper.getAllUser(page * limit, limit);
            session.commit();
        } finally {
            session.close();
        }
        return students;
    }

    @Override
    public boolean updateStudentInfo(Student student) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.updateStudentInfo(student);
            session.commit();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean removeStudent(Student student) {

        return false;
    }
}
