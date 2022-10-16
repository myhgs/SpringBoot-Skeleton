package my.project.hong.service.member;

import lombok.extern.slf4j.Slf4j;
import my.project.hong.config.exception.ServiceException;
import my.project.hong.model.Member;
import my.project.hong.model.ResponseVO;
import my.project.hong.model.code.ResCode;
import my.project.hong.service.member.mapper.MemberMapper;
import my.project.hong.util.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by kiseokhong on 09/02/2020.
 */
@Service
@Slf4j
public class MemberServiceImpl implements MemberService{

    private static final Logger LOG = LoggerFactory.getLogger(MemberServiceImpl.class);

    private final MemberMapper memberMapper;
    private final EmailSender emailSender;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper, EmailSender emailSender) {
        this.memberMapper = memberMapper;
        this.emailSender = emailSender;
    }

    @Override
    public String testSend() {
        return "AAAAAA";
    }

    @Override
    public ResponseVO<Object> getMemberList() {

        LOG.debug("MemberServiceImpl.getMemberList()");
//        if(true){
//            throw new ServiceException(ResCode.ERROR_1000);
//        }
        return ResponseVO.builder()
                .data(memberMapper.selectMemberList())
                .resCode(ResCode.SUCCESS.getResCode())
                .resMsg(ResCode.SUCCESS.getResMsg())
                .build();
    }

    @Cacheable(value = "member")
    @Override
    public ResponseVO<Object> getMemberDetail(long memNo) {


//        Member member = new Member(1, "ss", "vb", "dqwd", null);
        Member test = Member.builder()
                .memNo(0)
                .id("aa")
                .name("aa")
                .email("aa")
                .build();
        LOG.debug("MemberServiceImpl.getMemberDetail");

        Optional<Member> getMember = Optional.ofNullable(memberMapper.selectMemberNoDetail(memNo));
        getMember.orElseThrow(() -> new ServiceException(ResCode.ERROR_2000));

        try{
            Member m = memberMapper.selectMemberNoDetail(memNo);
        }catch (ServiceException e){
            throw new ServiceException(ResCode.ERROR_1000);
        }


        return ResponseVO.builder()
                .data(getMember.get())
                .resCode(ResCode.SUCCESS.getResCode())
                .resMsg(ResCode.SUCCESS.getResMsg())
                .build();
    }

    public int test(Member member){
        member.setId("1");
        return 1;
    }

    @Override
    public ResponseVO<Object> createMember(Member member) {

        LOG.debug("MemberServiceImpl.createMember");

        //아이디가 존재하는지 중복 체크
        Optional<Member> getMember = Optional.ofNullable(memberMapper.selectMemberIdDetail(member.getId()));
        if(getMember.isPresent()) throw new ServiceException(ResCode.ERROR_2001);

        //등록 실패시
        if(0 == memberMapper.insertMember(member)) throw new ServiceException(ResCode.ERROR_9999);

        //Send Email
        emailSender.sendSimpleMail(member.getEmail(), "Welcome!", "Welcome!");

        return ResponseVO.builder()
                .data(member)
                .resCode(ResCode.SUCCESS.getResCode())
                .resMsg(ResCode.SUCCESS.getResMsg())
                .build();
    }
}
