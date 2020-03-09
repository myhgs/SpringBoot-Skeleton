package my.project.hong.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

/**
 * Created by kiseokhong on 2020/03/09.
 */
public class ObjectUtil {

    public static HashMap<String, Object> objectToMap(Object data){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(data, HashMap.class);
    }

}
