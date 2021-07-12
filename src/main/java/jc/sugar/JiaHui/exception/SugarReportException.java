package jc.sugar.JiaHui.exception;

/**
 * @Code 谢良基 2021/7/6
 */
public class SugarReportException extends Exception{
    public SugarReportException(String message){
        super(message);
    }

    public SugarReportException(Throwable throwable){
        super(throwable);
    }

    public SugarReportException(){

    }

    public SugarReportException(String message, Throwable throwable){
        super(message, throwable);
    }

    public SugarReportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
