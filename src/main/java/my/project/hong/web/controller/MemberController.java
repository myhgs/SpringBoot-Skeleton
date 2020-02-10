package my.project.hong.web.controller;

import my.project.hong.model.ResponseVO;
import my.project.hong.model.code.CommonConst;
import my.project.hong.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseVO<Object> getMember(){
        return memberService.getMemberList();
    }

    @PostMapping
    public ResponseVO<Object> createMember(){
        return null;
    }

}
