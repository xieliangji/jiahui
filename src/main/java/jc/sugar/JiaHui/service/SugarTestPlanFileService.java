package jc.sugar.JiaHui.service;

import jc.sugar.JiaHui.exception.SugarTestPlanFileException;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Code 谢良基 2021/7/19
 */
public interface SugarTestPlanFileService {

    String uploadTestPlanFile(MultipartFile multipartFile, Integer uploaderId) throws SugarTestPlanFileException;
}
