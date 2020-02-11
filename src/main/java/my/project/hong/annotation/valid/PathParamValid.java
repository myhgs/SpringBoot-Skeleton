package my.project.hong.annotation.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PathParamValidator.class)
public @interface PathParamValid {

    String message() default "유효하지 않은 MEM_NO 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
