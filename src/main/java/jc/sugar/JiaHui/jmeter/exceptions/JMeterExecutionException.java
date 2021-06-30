package jc.sugar.JiaHui.jmeter.exceptions;

/**
 * @Code 谢良基 2021/6/28
 */
public class JMeterExecutionException extends Exception{

    public JMeterExecutionException(String message){
        super(message);
    }


    public JMeterExecutionException(Throwable cause){
        super(cause);
    }


    public JMeterExecutionException(){

    }


    public JMeterExecutionException(String message, Throwable cause){
        super(message, cause);
    }


    public JMeterExecutionException(String message, Throwable cause,
                                            boolean enableSuppression,
                                            boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
