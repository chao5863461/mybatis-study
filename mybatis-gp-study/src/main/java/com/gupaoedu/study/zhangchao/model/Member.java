package com.gupaoedu.study.zhangchao.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Member implements Serializable {

    private Integer id;

    private String name;

    private String sex;

    private String addr;

    private Double salary;

    private Date updateTime;

    private Integer userId;

    private User user;
}
