package my.project.hong.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by kiseokhong on 09/02/2020.
 */
@Getter
@Setter
@Builder
public class Member {

    long no;
    String id;
    String name;
    String age;

}
