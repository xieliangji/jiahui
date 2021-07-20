package jc.sugar.JiaHui.service.impl;

import jc.sugar.JiaHui.dao.SugarTestPlanFileDao;
import jc.sugar.JiaHui.entity.SugarTestPlanFile;
import jc.sugar.JiaHui.exception.SugarTestPlanFileException;
import jc.sugar.JiaHui.jmeter.SugarJMeterContext;
import jc.sugar.JiaHui.service.SugarTestPlanFileService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @Code 谢良基 2021/7/19
 */
@Service
public class SugarTestPlanFileServiceImpl implements SugarTestPlanFileService {

    private final SugarTestPlanFileDao fileDao;


    public SugarTestPlanFileServiceImpl(SugarTestPlanFileDao fileDao){
        this.fileDao = fileDao;
    }

    @Override
    public String uploadTestPlanFile(MultipartFile multipartFile, Integer uploaderId) throws SugarTestPlanFileException {
        String fileName = multipartFile.getOriginalFilename();
        String filePath = SugarJMeterContext.getTestUploadRoot() + "/" + Base64.encodeBase64String((fileName + System.nanoTime()).getBytes(StandardCharsets.UTF_8));

        try {
            FileUtils.copyToFile(multipartFile.getInputStream(), new File(filePath));

            SugarTestPlanFile file = new SugarTestPlanFile();
            file.setFileName(fileName);
            file.setFilePath(filePath);
            file.setUploaderId(uploaderId);

            fileDao.saveFile(file);

            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarTestPlanFileException(e);
        }
    }
}
