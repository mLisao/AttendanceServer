package com.lisao.attendance.daoimpl;

import com.lisao.attendance.dao.ScheduleDao;
import com.lisao.attendance.entity.Schedule;
import com.lisao.attendance.mapping.ScheduleMapper;
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
    public void addClassRoom(Schedule schedule) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ScheduleMapper mapper = session.getMapper(ScheduleMapper.class);
            mapper.addClassRoom(schedule);
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
            ScheduleMapper mapper = session.getMapper(ScheduleMapper.class);
            mapper.selectAll();
            session.commit();
        } finally {
            session.close();
        }
        return schedules;
    }
}
