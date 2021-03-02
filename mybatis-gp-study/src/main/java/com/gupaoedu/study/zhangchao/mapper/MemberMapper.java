package com.gupaoedu.study.zhangchao.mapper;

import com.gupaoedu.study.zhangchao.model.Member;
import com.gupaoedu.study.zhangchao.model.User;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MemberMapper {

    public List<Member> queryAll();

    public Member getById(int id);

    public List<Member> queryByIds(List<Integer> ids);

    public List<Member> getByParams(Member member);

    public void updateByPrimaryKey(Member member);

    public void insertMember(Member member);


}
