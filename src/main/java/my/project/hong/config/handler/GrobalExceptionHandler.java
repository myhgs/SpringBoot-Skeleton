package my.project.hong.config.handler;

import my.project.hong.config.exception.ServiceException;
import my.project.hong.model.ResponseVO;
import my.project.hong.model.code.ResCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GrobalExceptionHandler {

    private static Logger LOG = LoggerFactory.getLogger(GrobalExceptionHandler.class);

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ResponseVO handlerMissingServletRequestParameterException(MissingServletRequestParameterException e){
        LOG.error("MissingServletRequestParameterException !! :: === "+e.getMessage());
        return ResponseVO.builder().resCode(ResCode.ERROR_1000.getResCode()).resMsg(ResCode.ERROR_1000.getResMsg()).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ResponseVO handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        LOG.error("MethodArgumentNotValidException !! :: === "+e.getMessage());
        return ResponseVO.builder().resCode(ResCode.ERROR_1000.getResCode()).resMsg(ResCode.ERROR_1000.getResMsg()).build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ResponseVO handlerConstraintViolationException(ConstraintViolationException e){
        LOG.error("ConstraintViolationException !! :: === "+e.getMessage());
        return ResponseVO.builder().resCode(ResCode.ERROR_1001.getResCode()).resMsg(e.getMessage()).build();
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ResponseVO handlerAbstractErrorCodeException(ServiceException e){
        LOG.error("AbstractErrorCodeException !! :: === "+e.getResMsg());
        return ResponseVO.builder().resCode(e.getResCode()).resMsg(e.getResMsg()).build();
    }



}
