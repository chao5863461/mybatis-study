package com.gupaoedu.study.zhangchao.mybatis;

import com.gupaoedu.study.zhangchao.mapper.UserMapper;
import com.gupaoedu.study.zhangchao.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class MybatisUserTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();

    }

    @Test
    public void testQueryAll() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println( mapper.queryAll());
    }

    @Test
    public void testGetById() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println( mapper.getById(123));
    }

    @Test
    public void testgetByParams() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setName("%124Name%");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println( mapper.getByParams(user));
    }

    @Test
    public void testUpdate() throws IOException {

        User user = new User();
        user.setUserId(125);
        user.setName("124Name");
        user.setUpdateTime(new Date());
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateByPrimaryKey(user);
        sqlSession.commit();
    }

    @Test
    public void testInsert() throws IOException {
        User user = new User();
        user.setUserId(133);
        user.setName("124Name");
        user.setUpdateTime(new Date());
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(user);
       // sqlSession.commit();
    }
}
