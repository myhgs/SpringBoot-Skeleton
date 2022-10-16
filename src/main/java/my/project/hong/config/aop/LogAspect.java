package my.project.hong.config.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import my.project.hong.config.exception.ServiceException;
import my.project.hong.model.Member;
import my.project.hong.model.ResponseVO;
import my.project.hong.service.member.MemberService;
import my.project.hong.web.interceptor.AccessInterceptor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by kiseokhong on 18/02/2020.
 */
@Aspect
@Component
@AllArgsConstructor
public class LogAspect {

    private static final Logger LOG = LoggerFactory.getLogger(AccessInterceptor.class);

    private final MemberService memberService;

    @Around("execution(* my.project.hong.service.member.MemberService.*(..))")
    public Object logging(ProceedingJoinPoint joinPoint) {
        try {
            LOG.info("START :: == "+joinPoint.getSignature().getDeclaringTypeName()+" / "+joinPoint.getSignature().getName());
            Object result = joinPoint.proceed();
            Optional<String> paramString = Optional.ofNullable(objectString(joinPoint.getArgs()));
            paramString.ifPresent(data -> LOG.debug("PARAMETER :: "+data));
            LOG.info("END :: == "+joinPoint.getSignature().getDeclaringTypeName()+" / "+joinPoint.getSignature().getName());
            return result;
        } catch (ServiceException e){
            String test = memberService.testSend();
            System.out.println(test);
            throw new ServiceException(e);
        } catch (Throwable e) {
            throw new ServiceException((ServiceException) e);
        }

    }

    public String objectString(Object[] args) throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        String result = obj.writeValueAsString(args);
        return result;
    }
}
