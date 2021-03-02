package com.gupaoedu.study.zhangchao.mapper;

import com.gupaoedu.study.zhangchao.model.Member;

import java.util.List;

public interface MemberMapperExt extends MemberMapper{

    public void batchUpdate(List<Member> members);

    public void batchInsert(List<Member> members);

    public Member getMemberAndUser(Integer id);

    public Member getMemberWithUserQuery(Integer id);



}
