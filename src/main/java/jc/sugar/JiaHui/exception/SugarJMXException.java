package jc.sugar.JiaHui.exception;

/**
 * @Code 谢良基 2021/7/1
 */
public class SugarJMXException extends Exception{
    public SugarJMXException(String message){
        super(message);
    }

    public SugarJMXException(Throwable throwable){
        super(throwable);
    }

    public SugarJMXException(){

    }

    public SugarJMXException(String message, Throwable throwable){
        super(message, throwable);
    }

    public SugarJMXException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
