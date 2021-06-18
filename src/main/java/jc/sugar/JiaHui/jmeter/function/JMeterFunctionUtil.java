package jc.sugar.JiaHui.jmeter.function;

import jc.sugar.JiaHui.entity.SugarJFunction;
import jc.sugar.JiaHui.entity.SugarJFunctionResult;
import jc.sugar.JiaHui.jmeter.JMeterInitializer;
import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.Function;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.reflections.Reflections;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URLEncoder;
import java.util.*;

/**
 * 2021/5/26 10:17
 * Code by 谢良基
 */
public abstract class JMeterFunctionUtil {
    private static final Logger logger = LogManager.getLogger(JMeterFunctionUtil.class);

    private static final String[] PACKAGE_PREFIXES = {"org.apache.jmeter", "kg.apc.jmeter"};

    private static Set<Class<? extends Function>> findJMeterFunctions(){
        Set<Class<? extends Function>> functionClasses = new HashSet<>();
        for(String packagePrefix: PACKAGE_PREFIXES){
            Reflections reflections = new Reflections(packagePrefix);
            Set<Class<? extends Function>> packageFunctionClasses = reflections.getSubTypesOf(Function.class);
            functionClasses.addAll(packageFunctionClasses);
        }

        return functionClasses;
    }


//    public static List<SugarJFunction> getSugarJFunctions(){
//        JMeterUtils.setLocale(Locale.SIMPLIFIED_CHINESE);
//        List<SugarJFunction> sugarJFunctions = new ArrayList<>();
//
//        Set<Class<? extends Function>> jFunctions = findJMeterFunctions();
//        for(Class<? extends Function> jFunction: jFunctions){
//            try{
//                Function function = jFunction.asSubclass(Function.class).getDeclaredConstructor().newInstance();
//                String referenceKey = function.getReferenceKey();
//                if(referenceKey.length() > 0){
//                    SugarJFunction sugarJFunction = new SugarJFunction(System.identityHashCode(function), referenceKey, function.getArgumentDesc());
//                    sugarJFunctions.add(sugarJFunction);
//                    if(sugarJFunction.getName().equals("__machineIP")){
//                        sugarJFunction.setArgumentDescriptions(new ArrayList<>());
//                        SugarJFunctionResult result = execute(sugarJFunction);
//                        logger.info(new ObjectMapper().writeValueAsString(result));
//                    }
//                }
//            } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException | JsonProcessingException e) {
//                logger.warn(e.getMessage());
//            }
//        }
//
//        if(sugarJFunctions.size() == 0){
//            SugarJFunction sugarJFunction = new SugarJFunction(0, "_$Fuck", Lists.newArrayList("没有找到任何JMeter函数"));
//            sugarJFunctions.add(sugarJFunction);
//        }
//        logger.info("JMeter 函数个数： " + sugarJFunctions.size());
//        return sugarJFunctions;
//    }


    public static List<SugarJFunction> getSugarJFunctions(){
        JMeterInitializer.initialize();

        List<SugarJFunction> sugarJFunctions = new ArrayList<>();
        String[] jFuncNames = CompoundVariable.getFunctionNames();
        Arrays.sort(jFuncNames, String::compareToIgnoreCase);

        for(String jFuncName: jFuncNames){
            try {
                Function jFunc = CompoundVariable.getFunctionClass(jFuncName).newInstance();
                List<String> argumentDescriptions = jFunc.getArgumentDesc();
                SugarJFunction sugarJFunction = new SugarJFunction(jFuncName, argumentDescriptions);
                sugarJFunctions.add(sugarJFunction);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sugarJFunctions;
    }


    public static SugarJFunctionResult execute(SugarJFunction sugarJFunction){
        String functionCall = buildFunctionCallString(sugarJFunction.getName(), sugarJFunction.getArgumentDescriptions());
        CompoundVariable function = new CompoundVariable(functionCall);

        String functionCallResult = function.execute().trim();
        JMeterContext threadContext = JMeterContextService.getContext();
        JMeterVariables jMeterVariables = new JMeterVariables();
        threadContext.setVariables(jMeterVariables);
        threadContext.setThreadNum(1);
        threadContext.getVariables().put(JMeterThread.LAST_SAMPLE_OK, "true");
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setName("Sugar-Function-Call");
        threadContext.setThreadGroup(threadGroup);
        StringBuilder sb = new StringBuilder();
        jMeterVariables.entrySet().forEach(e -> sb.append(e.getKey()).append("=").append(e.getValue()).append("\r\n"));

        return new SugarJFunctionResult(functionCallResult, sb.toString(), functionCall);
    }


    private static String escapeComma(String arg){
        char ANY_NORMAL_CHAR = ' ';
        int level = 0;
        StringBuilder sb = new StringBuilder(arg.length());
        try {
            int c;
            char lashChar = ANY_NORMAL_CHAR;
            Reader r = new StringReader(arg);
            while ((c = r.read()) != -1){
                char nextChar = (char) c;
                if(lashChar == '\\'){
                    lashChar = ANY_NORMAL_CHAR;
                } else if(lashChar == '$' && nextChar == '{'){
                    level++;
                    lashChar = ANY_NORMAL_CHAR;
                } else if (nextChar == '}'){
                    level--;
                    lashChar = ANY_NORMAL_CHAR;
                } else if (nextChar == ',' && level == 0){
                    sb.append('\\');
                    lashChar = ANY_NORMAL_CHAR;
                } else {
                    lashChar = nextChar;
                }
                sb.append(nextChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    private static String buildFunctionCallString(String funcName, List<String> args){
        StringBuilder functionCall = new StringBuilder("${");
        functionCall.append(funcName);
        if(args.size() > 0){
            functionCall.append("(");
            boolean first = true;
            for(String arg: args){
                if(!first){
                    functionCall.append(",");
                }
                functionCall.append(escapeComma(arg));
                first = false;
            }
            functionCall.append(")");
        }
        functionCall.append("}");
        return functionCall.toString();
    }
}
