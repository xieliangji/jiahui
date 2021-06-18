package jc.sugar.JiaHui.jmeter.exceptions;

/**
 * 2021/5/24 15:30
 * Code by 谢良基
 */
public class JMeterTestElementMapperException extends Exception{

    public JMeterTestElementMapperException(String message){
        super(message);
    }


    public JMeterTestElementMapperException(Throwable cause){
        super(cause);
    }


    public JMeterTestElementMapperException(){

    }


    public JMeterTestElementMapperException(String message, Throwable cause){
        super(message, cause);
    }


    public JMeterTestElementMapperException(String message, Throwable cause,
                                            boolean enableSuppression,
                                            boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
