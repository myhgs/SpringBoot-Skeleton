package my.project.hong.config.exception;

import my.project.hong.model.code.ResCode;

public class ServiceException extends RuntimeException {
    private ResCode resCode;
    public ServiceException(ResCode resCode){
        super();
        this.resCode = resCode;
    }
    public ServiceException(ServiceException e){
        super();
        this.resCode = ResCode.valueOf(e.getResCode());
    }
    public String getResCode() {
        return resCode.getResCode();
    }

    public String getResMsg() {
        return resCode.getResMsg();
    }
}
