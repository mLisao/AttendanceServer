package com.lisao.attendance.daoimpl;

import com.lisao.attendance.dao.ClassRoomDao;
import com.lisao.attendance.entity.ClassRoom;
import com.lisao.attendance.mapping.ClassRoomMapper;
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
    public void addClassRoom(ClassRoom classRoom) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ClassRoomMapper mapper = session.getMapper(ClassRoomMapper.class);
            mapper.addClassRoom(classRoom);
            session.commit();
        } finally {
            session.close();
        }
    }
}
