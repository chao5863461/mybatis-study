package com.gupaoedu.study.zhangchao.model;

import lombok.Data;

import java.util.Date;

@Data
public class Member {

    private int id;

    private String name;

    private String sex;

    private String addr;

    private double salary;

    private Date createTime;
}
