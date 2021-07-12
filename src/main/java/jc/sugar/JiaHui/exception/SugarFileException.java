package jc.sugar.JiaHui.exception;

/**
 * @Code 谢良基 2021/7/9
 */
public class SugarFileException extends Exception {


    public SugarFileException(String message) {
        super(message);
    }

    public SugarFileException(Throwable throwable) {
        super(throwable);
    }

    public SugarFileException() {

    }

    public SugarFileException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public SugarFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}