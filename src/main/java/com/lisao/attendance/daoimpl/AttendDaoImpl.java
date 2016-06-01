package com.lisao.attendance.daoimpl;

import com.lisao.attendance.dao.AttendDao;
import com.lisao.attendance.entity.Attend;
import com.lisao.attendance.entity.MyAttend;
import com.lisao.attendance.entity.Student;
import com.lisao.attendance.mapping.AttendMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lisao on 2016/5/15.
 */
public class AttendDaoImpl implements AttendDao {
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void addAttend(Attend attend) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            AttendMapper mapper = session.getMapper(AttendMapper.class);
            mapper.addAttend(attend);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public int getAttendCount(int classRoomId) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = 0;
        try {
            AttendMapper mapper = session.getMapper(AttendMapper.class);
            count = mapper.getAttendCount(classRoomId);
            session.commit();
        } finally {
            session.close();
        }
        return count;
    }

    @Override
    public List<MyAttend> getMyAttend(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        List<MyAttend> myAttends;
        try {
            AttendMapper mapper = session.getMapper(AttendMapper.class);
            myAttends = mapper.getMyAttend(id);
            session.commit();
        } finally {
            session.close();
        }
        return myAttends;
    }

    @Override
    public List<Student> getAttendStudent(int classRoomId) {
        SqlSession session = sqlSessionFactory.openSession();
        List<Student> students;
        try {
            AttendMapper mapper = session.getMapper(AttendMapper.class);
            students = mapper.getAttendStudent(classRoomId);
            session.commit();
        } finally {
            session.close();
        }
        return students;
    }
}
