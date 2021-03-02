package com.gupaoedu.study.zhangchao.build;

import com.gupaoedu.study.zhangchao.model.Member;

import java.util.Date;

public class MemberBuilder  {

    private Member member;

    public MemberBuilder(Member member) {
        this.member = member;
    }

    public MemberBuilder addAddr(String addr) {
        member.setAddr(addr);
        return this;
    }

    public MemberBuilder addId(Integer id) {
        member.setId(id);
        return this;
    }

    public MemberBuilder addName(String name) {
        member.setName(name);
        return this;
    }

    public MemberBuilder addSalary(Double salary) {
        member.setSalary(salary);
        return this;
    }

    public MemberBuilder addSex(String sex) {
        member.setSex(sex);
        return this;
    }

    public MemberBuilder addUpdateTime(Date updateTime) {
        member.setUpdateTime(updateTime);
        return this;
    }

    public MemberBuilder addUserId(Integer userId) {
        member.setUserId(userId);
        return this;
    }

    public Member toModel() {
        return member;
    }
}
