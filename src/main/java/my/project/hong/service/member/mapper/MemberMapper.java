package my.project.hong.service.member.mapper;

import my.project.hong.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by kiseokhong on 09/02/2020.
 */
@Mapper
public interface MemberMapper {

    List<Member> selectMemberList();

}
