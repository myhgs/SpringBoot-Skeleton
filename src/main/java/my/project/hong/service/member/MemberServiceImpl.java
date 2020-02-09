package my.project.hong.service.member;

import my.project.hong.model.Member;
import my.project.hong.service.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kiseokhong on 09/02/2020.
 */
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<Member> getMemberList() {
        return memberMapper.selectMemberList();
    }
}
