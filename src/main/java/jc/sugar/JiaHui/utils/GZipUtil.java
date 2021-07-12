package jc.sugar.JiaHui.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @Code 谢良基 2021/7/5
 */
public class GZipUtil {

    public static String compress(String originalString){
        if(StringUtils.isEmpty(originalString)){
            return "";
        }
        try (ByteArrayOutputStream bo = new ByteArrayOutputStream();
             GZIPOutputStream go = new GZIPOutputStream(bo)){
            go.write(originalString.getBytes(StandardCharsets.UTF_8));
            go.close();
            return bo.toString("iso-8859-1");
        } catch (IOException e) {
            e.printStackTrace();
            return originalString;
        }
    }


    public static String uncompress(String compressedString){
        if(StringUtils.isEmpty(compressedString)){
            return "";
        }

        try (ByteArrayOutputStream bo = new ByteArrayOutputStream();
             ByteArrayInputStream bi = new ByteArrayInputStream(compressedString.getBytes("iso-8859-1"));
             GZIPInputStream gi = new GZIPInputStream(bi)){

            byte[] buffer = new byte[1024];
            int byteCount;
            while((byteCount = gi.read(buffer)) >= 0){
                bo.write(buffer, 0, byteCount);
            }
            return bo.toString("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return compressedString;
        }

    }
}
