package jc.sugar.JiaHui.entity;

/**
 * 2021/5/25 11:23
 * Code by 谢良基
 */
public class SugarResponse<T> {


    private Integer code;


    private T payload;


    private String message;


    public SugarResponse(){}


    public SugarResponse(Integer code, T payload, String message){
        this.code = code;
        this.payload = payload;
        this.message = message;
    }


    public static <T> SugarResponse<T> success(T payload, String message){
        return new SugarResponse<>(SugarResponseCode.OK, payload, message);
    }


    public static SugarResponse<Void> fail(String message){
        return new SugarResponse<>(SugarResponseCode.SYSTEM_ERROR, null, message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    interface SugarResponseCode{


        Integer OK = 0;


        Integer SYSTEM_ERROR = -1;

    }
}

