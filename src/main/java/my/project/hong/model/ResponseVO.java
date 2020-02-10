package my.project.hong.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO<T> {

    private int resCode;
    private String resMsg;

    private T data;

}
