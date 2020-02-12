package my.project.hong.model.code;

public enum  ResCode {

    SUCCESS("200", "정상"),

    ERROR_1000("ERROR_1000", "필수 요청 값이 없습니다. 다시 시도해주세요."),
    ERROR_1001("ERROR_1001", "유효하지 않은 PathParam 값입니다."),

    ERROR_2000("ERROR_2000", "해당 멤버 정보가 존재하지 않습니다."),
    ERROR_2001("ERROR_2001", "해당 아이디가 이미 존재합니다."),

    ERROR_9999("ERROR_9999", "데이터 베이스 처리에 실패 했습니다. 다시 시도해주세요.")
    ;

    private String resCode;
    private String resMsg;

    ResCode(String resCode, String resMsg){
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public String getResCode() {
        return resCode;
    }

    public String getResMsg() {
        return resMsg;
    }
}
