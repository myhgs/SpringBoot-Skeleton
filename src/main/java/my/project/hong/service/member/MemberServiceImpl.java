package my.project.hong.service.member;

import my.project.hong.config.exception.ServiceException;
import my.project.hong.model.Member;
import my.project.hong.model.ResponseVO;
import my.project.hong.model.code.ResCode;
import my.project.hong.service.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public ResponseVO<Object> getMemberList() {
        return ResponseVO.builder()
                .data(memberMapper.selectMemberList())
                .resCode(ResCode.SUCCESS.getResCode())
                .resMsg(ResCode.SUCCESS.getResMsg())
                .build();
    }

    @Cacheable(value = "member")
    @Override
    public ResponseVO<Object> getMemberDetail(long memNo) {
        Optional<Member> getMember = Optional.ofNullable(memberMapper.selectMemberNoDetail(memNo));
        getMember.orElseThrow(() -> new ServiceException(ResCode.ERROR_2000));

        return ResponseVO.builder()
                .data(getMember.get())
                .resCode(ResCode.SUCCESS.getResCode())
                .resMsg(ResCode.SUCCESS.getResMsg())
                .build();
    }

    @Override
    public ResponseVO<Object> createMember(Member member) {
        //아이디가 존재하는지 중복 체크
        Optional<Member> getMember = Optional.ofNullable(memberMapper.selectMemberIdDetail(member.getId()));
        if(getMember.isPresent()) throw new ServiceException(ResCode.ERROR_2001);

        //등록 실패시
        if(0 == memberMapper.insertMember(member)) throw new ServiceException(ResCode.ERROR_9999);

        return ResponseVO.builder()
                .data(member)
                .resCode(ResCode.SUCCESS.getResCode())
                .resMsg(ResCode.SUCCESS.getResMsg())
                .build();
    }
}
