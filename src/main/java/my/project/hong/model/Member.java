package my.project.hong.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by kiseokhong on 09/02/2020.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    long no;
    @NotEmpty String id;
    @NotEmpty String name;
    String age;

}
