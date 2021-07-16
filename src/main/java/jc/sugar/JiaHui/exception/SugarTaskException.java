package jc.sugar.JiaHui.exception;

/**
 * @Code 谢良基 2021/7/16
 */
public class SugarTaskException extends Exception{

    public SugarTaskException(String message) {
        super(message);
    }

    public SugarTaskException(Throwable throwable) {
        super(throwable);
    }

    public SugarTaskException() {

    }

    public SugarTaskException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public SugarTaskException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
