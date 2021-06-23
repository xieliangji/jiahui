package jc.sugar.JiaHui.exception;

/**
 * @Code 谢良基 2021/6/23
 */
public class SugarAccountException extends Exception{
    public SugarAccountException(String message){
        super(message);
    }

    public SugarAccountException(Throwable throwable){
        super(throwable);
    }

    public SugarAccountException(){

    }

    public SugarAccountException(String message, Throwable throwable){
        super(message, throwable);
    }

    public SugarAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
