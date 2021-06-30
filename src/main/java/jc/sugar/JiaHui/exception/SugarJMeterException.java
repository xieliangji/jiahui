package jc.sugar.JiaHui.exception;

/**
 * @Code 谢良基 2021/6/29
 */
public class SugarJMeterException extends Exception{
    public SugarJMeterException(String message){
        super(message);
    }

    public SugarJMeterException(Throwable throwable){
        super(throwable);
    }

    public SugarJMeterException(){

    }

    public SugarJMeterException(String message, Throwable throwable){
        super(message, throwable);
    }

    public SugarJMeterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
