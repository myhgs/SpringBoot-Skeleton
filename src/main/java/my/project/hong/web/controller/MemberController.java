package my.project.hong.web.controller;

import my.project.hong.model.Member;
import my.project.hong.model.ResponseVO;
import my.project.hong.model.code.CommonConst;
import my.project.hong.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kiseokhong on 09/02/2020.
 */
@RestController
@RequestMapping(CommonConst.URL_ROOT+"/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("")
    public ResponseVO<Member> getMember(){
        return memberService.getMemberList();
    }

    @PostMapping
    public ResponseVO<Member> createMember(){
        return null;
    }

}
