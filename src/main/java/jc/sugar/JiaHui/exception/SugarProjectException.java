package jc.sugar.JiaHui.exception;

/**
 * @Code 谢良基 2021/6/23
 */
public class SugarProjectException extends Exception{
    public SugarProjectException(String message){
        super(message);
    }

    public SugarProjectException(Throwable throwable){
        super(throwable);
    }

    public SugarProjectException(){

    }

    public SugarProjectException(String message, Throwable throwable){
        super(message, throwable);
    }

    public SugarProjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
