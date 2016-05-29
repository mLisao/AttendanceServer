package com.lisao.attendance.daoimpl;

import com.lisao.attendance.dao.ScheduleDao;
import com.lisao.attendance.entity.Schedule;
import com.lisao.attendance.entity.Teacher;
import com.lisao.attendance.mapping.ScheduleMapper;
import com.lisao.attendance.mapping.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lisao on 2016/5/15.
 */
public class ScheduleImpl implements ScheduleDao {
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void addSchedule(Schedule schedule) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ScheduleMapper mapper = session.getMapper(ScheduleMapper.class);
            mapper.addSchedule(schedule);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Schedule> getAllSchedule() {
        SqlSession session = sqlSessionFactory.openSession();
        List<Schedule> schedules = null;
        try {
            ScheduleMapper scheduleMapper = session.getMapper(ScheduleMapper.class);
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
            schedules = scheduleMapper.selectAll();
            session.commit();
        } finally {
            session.close();
        }
        return schedules;
    }

    @Override
    public Schedule getScheduleById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        Schedule schedule = null;
        try {
            ScheduleMapper scheduleMapper = session.getMapper(ScheduleMapper.class);
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
            schedule = scheduleMapper.selectScheduleById(id);
            session.commit();
        } finally {
            session.close();
        }
        return schedule;
    }
}
