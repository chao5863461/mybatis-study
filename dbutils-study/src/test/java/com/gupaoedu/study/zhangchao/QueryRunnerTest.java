package com.gupaoedu.study.zhangchao;

import com.gupaoedu.study.zhangchao.dao.UserDao;
import com.gupaoedu.study.zhangchao.jdbc.HikariUtil;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class QueryRunnerTest {

    @Before
    public void before(){
        HikariUtil.init();
    }
    @Test
    public void selectOneUser() throws SQLException {
        UserDao.selectUserById(123);
    }

    @Test
    public void selectAllUser() throws SQLException {
        UserDao.queryList();
    }
}
