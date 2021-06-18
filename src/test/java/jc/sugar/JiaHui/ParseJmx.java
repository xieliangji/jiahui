package jc.sugar.JiaHui;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseJmx {

    public static void main(String[] args) {
        String jmxFile = "C:\\Users\\Administrator\\Desktop\\配置元素.jmx";
        parse(jmxFile);
    }


    public static void parse(String jmxFile){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(jmxFile)))){
            String line;
            while ((line = reader.readLine()) != null){
                regexMatch(line.trim(), "JC.Sampler");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void regexMatch(String text, String category){
        Pattern namePattern = Pattern.compile("^<([A-Z][A-Za-z].*) gui");
        Matcher nameMatcher = namePattern.matcher(text);

        Pattern guiPattern = Pattern.compile("guiclass=\"(.+?)\"");
        Matcher guiMatcher = guiPattern.matcher(text);

        Pattern classPattern = Pattern.compile("testclass=\"(.+?)\"");
        Matcher classMatcher = classPattern.matcher(text);

        Pattern titlePattern = Pattern.compile("testname=\"(.+?)\"");
        Matcher titleMatcher = titlePattern.matcher(text);

        if(nameMatcher.find() && guiMatcher.find() && classMatcher.find() && titleMatcher.find()){
            String type = nameMatcher.group(1);
            String label = titleMatcher.group(1);
            String guiclass = guiMatcher.group(1);
            String testclass = classMatcher.group(1);

            String typeName;

            if(!testclass.equalsIgnoreCase("HTTPSamplerProxy")){
                typeName = type;
            } else {
                if(guiclass.toLowerCase().contains("gui")){
                    typeName = guiclass.substring(0, guiclass.toLowerCase().indexOf("gui"));
                } else {
                    typeName = guiclass;
                }
            }
//            System.out.println(typeName + ": \"" + label + "\",");
//            System.out.println(typeName + ": \"" + typeName + "\",");
//            System.out.println(typeName + ": {category: " + category + ", type: JT." + typeName + ", guiclass: \"" + guiclass + "\", testclass: \"" + testclass + "\", label: JL." + typeName + "},");

            System.out.println("/** " + label + "*/\nexport function " + typeName + "(){\n\t\n}\n\n");
        }
    }
}
