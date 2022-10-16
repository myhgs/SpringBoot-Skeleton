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
@EqualsAndHashCode
public class Member {

//    public Member(long memNo, @NotEmpty String id, @NotEmpty String name, @NotEmpty String email) {
//        this.memNo = memNo;
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }

    long memNo;
    @NotEmpty String id;
    @NotEmpty String name;
    @NotEmpty String email;
    String age;
    String age2;

}

