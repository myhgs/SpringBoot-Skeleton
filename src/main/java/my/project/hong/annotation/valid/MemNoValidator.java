package my.project.hong.annotation.valid;

import my.project.hong.model.Member;
import my.project.hong.service.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class MemNoValidator implements ConstraintValidator<MemNoValid, Long> {

    private final MemberMapper memberMapper;

    @Autowired
    public MemNoValidator(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public void initialize(MemNoValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Long> memNo = Optional.ofNullable(value);
        if(!memNo.isPresent()) return false;

        Optional<Member> memberDetail = Optional.ofNullable(memberMapper.selectMemberNoDetail(memNo.get()));
        if(!memberDetail.isPresent()) return false;
        return true;
    }
}
