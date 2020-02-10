package my.project.hong.service.member;

import my.project.hong.model.Member;
import my.project.hong.model.ResponseVO;

import java.util.List;

/**
 * Created by kiseokhong on 09/02/2020.
 */
public interface MemberService {

    ResponseVO<Object> getMemberList();

}
