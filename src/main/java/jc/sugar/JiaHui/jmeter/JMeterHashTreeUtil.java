package jc.sugar.JiaHui.jmeter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jc.sugar.JiaHui.jmeter.exceptions.JMeterTestElementMapperException;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.ListedHashTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Code 谢良基 2021/6/22
 */
public class JMeterHashTreeUtil {
    public static final String WEB_CHILDREN = "children";

    public static HashTree toHashTree(List<Map<String, Object>> elementAttributesList) throws JMeterTestElementMapperException {
        HashTree hashTree = new ListedHashTree();
        for(Map<String, Object> elementAttributes: elementAttributesList){
            TestElement element = JMeterMapperUtil.buildJMeterElement(elementAttributes);
            List<Map<String, Object>> children = (List<Map<String, Object>>) elementAttributes.get(WEB_CHILDREN);
            if(children != null){
                hashTree.add(element, toHashTree(children));
            } else {
                hashTree.add(element);
            }
        }
        return hashTree;
    }


    public static List<Map<String, Object>> fromHashTree(HashTree hashTree) throws JMeterTestElementMapperException {
        List<Map<String, Object>> result = new ArrayList<>();
        if(hashTree != null){
            Object[] elements = hashTree.getArray();
            for(Object element: elements){
                Map<String, Object> attributes = JMeterMapperUtil.buildJMeterElementAttributes((TestElement) element);
                attributes.put(WEB_CHILDREN, fromHashTree(hashTree.getTree(element)));
            }
        }
        return result;
    }


    public void saveHashTreeAsJMX(String jmxDirectory, String jmxFileName, HashTree hashTree) throws IOException {
        File jmxDirectoryFile = new File(jmxDirectory);
        if(!jmxDirectoryFile.exists()){
            jmxDirectoryFile.mkdir();
            File jmxFile = new File(jmxDirectoryFile.getAbsolutePath() + '/' + jmxFileName);
            jmxFile.createNewFile();
        }
        if(jmxDirectoryFile.isFile()){
            throw new IOException(jmxDirectory + " is a File, Please provide jmx directory");
        }

        File jmxFile = Paths.get(jmxDirectory, jmxFileName).toFile();
        if(!jmxFile.exists()){
            jmxFile.createNewFile();
        }

        JMeterInitializer.initialize();
        SaveService.saveTree(hashTree, new FileOutputStream(jmxFile));
    }
}
