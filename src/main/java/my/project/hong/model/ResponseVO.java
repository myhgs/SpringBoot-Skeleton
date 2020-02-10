package my.project.hong.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO<T> {

    private T data;
    private int resCode;
    private String resMsg;

}
