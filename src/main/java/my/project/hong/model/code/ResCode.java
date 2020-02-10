package my.project.hong.model.code;

public enum  ResCode {

    SUCCESS(200, "정상")
    ;

    private int resCode;
    private String resMsg;

    ResCode(int resCode, String resMsg){
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public int getResCode() {
        return resCode;
    }

    public String getResMsg() {
        return resMsg;
    }
}
