package com.gupaoedu.study.zhangchao.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gupaoedu.study.zhangchao.build.MemberBuilder;
import com.gupaoedu.study.zhangchao.mapper.MemberMapper;
import com.gupaoedu.study.zhangchao.mapper.MemberMapperExt;
import com.gupaoedu.study.zhangchao.mapper.UserMapper;
import com.gupaoedu.study.zhangchao.model.Member;
import com.gupaoedu.study.zhangchao.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MybatisMemberTest {

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
    public void testQueryAll() {
        PageHelper.startPage(0, 10);
        List<Member> members = mapper.queryAll();
        PageInfo page = new PageInfo(members,10);
        System.out.println(page);
    }

    @Test
    public void testGetById() {
        System.out.println( mapper.getById(2));
    }

    @Test
    public void testQueryByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);
        System.out.println( mapper.queryByIds(ids));
    }
    @Test
    public void testGetByParams() throws IOException {
        Member member = new Member();
        member.setName("%chao%");
        System.out.println( mapper.getByParams(member));
    }

    @Test
    public void testUpdate() throws IOException {

        Member member = new Member();
        member.setId(2);
        member.setName("超爷");
        member.setSex("男");
        member.setUpdateTime(new Date());
        mapper.updateByPrimaryKey(member);
        sqlSession.commit();
    }

    @Test
    public void testInsert() throws IOException {
        long beginTime = System.currentTimeMillis();

        MemberBuilder builder = new MemberBuilder(new Member());
        Member member = builder.addName("张菊")
                        .addAddr("HUNAN CHENZHOU").addSex("女")
                        .addSalary(36000.0).addUpdateTime(new Date())
                        .addUserId(123).toModel();

        for(int i=0;i<10000;i++){
            mapper.insertMember(member);
        }
        sqlSession.commit();
        System.out.println("执行批量插入10000条数据耗时:"+(System.currentTimeMillis()-beginTime));

    }

    @Test
    public void testBatchUpdate() throws IOException {
        List<Member> members = new ArrayList<>();
        for (int i=0;i<2;i++){
            MemberBuilder builder = new MemberBuilder(new Member());
            Member member = builder.addId(150+i).addName("张菊")
                    .addAddr("HUNAN").addSex("女")
                    .addSalary(0.0).addUpdateTime(new Date())
                    .addUserId(123).toModel();
            members.add(member);
        }

        long beginTime = System.currentTimeMillis();
        mapper.batchUpdate(members);
        sqlSession.commit();

        System.out.println("执行批量更新10000条数据耗时:"+(System.currentTimeMillis()-beginTime));

    }

    @Test
    public void testBatchInsert() throws IOException {
        List<Member> members = new ArrayList<>();
        MemberBuilder builder = new MemberBuilder(new Member());
        long beginTime = System.currentTimeMillis();
        for (int i=0;i<10000;i++){

            Member member = builder.addName("张菊"+i)
                    .addAddr("HUNAN CHENZHOU").addSex("女")
                    .addSalary(36000.0).addUpdateTime(new Date())
                    .addUserId(123).toModel();
            members.add(member);
        }

        mapper.batchInsert(members);
        sqlSession.commit();

        System.out.println("执行批量插入10000条数据耗时:"+(System.currentTimeMillis()-beginTime));

    }


    @Test
    public void testGetMemberAndUser() throws IOException {

        mapper.getMemberAndUser(2);

    }

    @Test
    public void testGetMemberAndUserQuery() throws IOException {

        mapper.getMemberWithUserQuery(2);

    }
}
