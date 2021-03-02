package com.gupaoedu.study.zhangchao.dao;

import com.gupaoedu.study.zhangchao.jdbc.HikariUtil;
import com.gupaoedu.study.zhangchao.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

    private static QueryRunner queryRunner ;

    static {
        queryRunner = HikariUtil.getQueryRunner();
    }

    public static User selectUserById(Integer id) throws SQLException {
        String sql = "select * from t_user where id=?";
        Object[] params = new Object[]{id};
        User result = queryRunner.query(sql,new BeanHandler<>(User.class),params);
        System.out.println(result);
        return result;

    }

    public static List<User> queryList() throws SQLException {
        String sql = "select * from t_user";
        List<User> results = queryRunner.query(sql,new BeanListHandler<>(User.class));
        System.out.println(results);

        return results;

    }
}
