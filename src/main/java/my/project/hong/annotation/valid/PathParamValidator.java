package my.project.hong.annotation.valid;

import my.project.hong.model.Member;
import my.project.hong.service.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class PathParamValidator implements ConstraintValidator<PathParamValid, Long> {

    private final MemberMapper memberMapper;

    @Autowired
    public PathParamValidator(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public void initialize(PathParamValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Long> memNo = Optional.ofNullable(value);
        if(!memNo.isPresent()) return false;

        Optional<Member> memberDetail = Optional.ofNullable(memberMapper.selectMemberDetail(memNo.get()));
        if(!memberDetail.isPresent()) return false;
        return true;
    }
}
