package com.lisao.attendance.daoimpl;

import com.lisao.attendance.dao.ClassRoomDao;
import com.lisao.attendance.entity.Schedule;
import com.lisao.attendance.mapping.ScheduleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by lisao on 2016/5/15.
 */
public class ClassRoomDaoImpl implements ClassRoomDao {
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
}
