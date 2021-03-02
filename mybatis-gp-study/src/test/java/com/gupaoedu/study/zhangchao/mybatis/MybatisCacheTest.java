package com.gupaoedu.study.zhangchao.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gupaoedu.study.zhangchao.mapper.MemberMapper;
import com.gupaoedu.study.zhangchao.mapper.MemberMapperExt;
import com.gupaoedu.study.zhangchao.model.Member;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisCacheTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    private MemberMapperExt mapper ;


    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(MemberMapperExt.class);
    }

    @Test
    public void testFirstCache() {
        List<Member> members = mapper.queryAll();
        System.out.println(members);
        System.out.println("=============第二次查询是否使用一级缓存?=============================");
        System.out.println(mapper.queryAll());


//        sqlSession = sqlSessionFactory.openSession();
//        MemberMapperExt  mapper2= sqlSession.getMapper(MemberMapperExt.class);
//
//        Member member = new Member();
//        member.setId(2);
//        member.setName("超爷");
//        member.setSex("男");
//        member.setUserId(111);
//        member.setUpdateTime(new Date());
//        mapper2.updateByPrimaryKey(member);
//        sqlSession.commit();

        System.out.println(mapper.getById(2));
    }


    @Test
    public void testSecondCache() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        MemberMapper mapper = sqlSession1.getMapper(MemberMapper.class);
        Member member1 = mapper.getById(2);
        sqlSession1.commit();
        System.out.println(member1);

        //System.out.println("=============第二次查询是否使用二级缓存?=============================");
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        MemberMapper mapper2 = sqlSession2.getMapper(MemberMapper.class);

        System.out.println(mapper2.getById(2));
        sqlSession2.commit();

    }
}
