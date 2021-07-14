package jc.sugar.JiaHui.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jc.sugar.JiaHui.entity.SugarJFunction;

import java.util.ArrayList;

/**
 * 2021/5/25 11:11
 * Code by 谢良基
 */
public class SugarObjectUtil {

    public static String toJsonString(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return obj.toString();
    }


}
