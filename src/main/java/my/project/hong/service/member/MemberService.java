package my.project.hong.service.member;

import my.project.hong.model.ResponseVO;

/**
 * Created by kiseokhong on 09/02/2020.
 */
public interface MemberService {

    ResponseVO<Object> getMemberList();

    ResponseVO<Object> getMemberDetail(long memNo);

}
