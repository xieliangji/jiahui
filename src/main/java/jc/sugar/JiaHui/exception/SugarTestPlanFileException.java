package jc.sugar.JiaHui.exception;

/**
 * @Code 谢良基 2021/7/19
 */
public class SugarTestPlanFileException extends Exception{

    public SugarTestPlanFileException(String message){
        super(message);
    }

    public SugarTestPlanFileException(Throwable throwable){
        super(throwable);
    }

    public SugarTestPlanFileException(){

    }

    public SugarTestPlanFileException(String message, Throwable throwable){
        super(message, throwable);
    }

    public SugarTestPlanFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
