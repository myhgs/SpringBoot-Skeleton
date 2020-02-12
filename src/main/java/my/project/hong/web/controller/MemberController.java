package my.project.hong.web.controller;

import my.project.hong.annotation.valid.PathParamValid;
import my.project.hong.model.Member;
import my.project.hong.model.ResponseVO;
import my.project.hong.model.code.CommonConst;
import my.project.hong.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by kiseokhong on 09/02/2020.
 */
@Validated
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

    @GetMapping("/{memNo}")
    public ResponseVO<Object> getMemberDetail(@PathVariable(value = "memNo") @PathParamValid long memNo){
        return memberService.getMemberDetail(memNo);
    }

    @PostMapping
    public ResponseVO<Object> createMember(@RequestBody @Valid Member member){
        return memberService.createMember(member);
    }

}
