package jc.sugar.JiaHui.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.dao.SugarFileDao;
import jc.sugar.JiaHui.entity.SugarFile;
import jc.sugar.JiaHui.entity.dto.SugarFileDTO;
import jc.sugar.JiaHui.entity.query.FileQuery;
import jc.sugar.JiaHui.entity.vo.FileUpdateVO;
import jc.sugar.JiaHui.exception.SugarFileException;
import jc.sugar.JiaHui.jmeter.SugarJMeterContext;
import jc.sugar.JiaHui.service.SugarFileService;
import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Code 谢良基 2021/7/9
 */
@Service
public class SugarFileServiceImpl implements SugarFileService {

    private final SugarFileDao fileDao;


    public SugarFileServiceImpl(SugarFileDao fileDao){
        this.fileDao = fileDao;
    }

    @Override
    public SugarFileDTO upload(MultipartFile multipartFile, String name, Integer fileType, String remark, Integer uploaderId) throws SugarFileException {
        SugarFile sugarFile = new SugarFile();
        sugarFile.setName(name);
        String fileSuffix;
        if(fileType == 1){
            fileSuffix = ".jar";
        } else if(fileType == 2){
            fileSuffix = ".zip";
        } else if(fileType == 3){
            fileSuffix = ".js";
        } else {
            fileSuffix = ".py";
        }
        sugarFile.setFileType(fileType);
        sugarFile.setFileName("文件" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + fileSuffix);
        sugarFile.setRemark(remark);
        sugarFile.setUploaderId(uploaderId);

        try {
            writeFile(multipartFile.getInputStream(), SugarJMeterContext.getUploadRoot() + "/" + sugarFile.getFileName());
            fileDao.saveFile(sugarFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarFileException(e);
        }

        SugarFileDTO fileDTO = new SugarFileDTO();
        fileDTO.setId(sugarFile.getId());
        fileDTO.setName(sugarFile.getName());
        fileDTO.setFileName(sugarFile.getFileName());
        fileDTO.setRemark(sugarFile.getRemark());
        fileDTO.setUploaderId(sugarFile.getUploaderId());
        fileDTO.setFileType(sugarFile.getFileType());

        try {
            SugarJMeterContext.destroyJMeterLoader();
            SugarJMeterContext.resetSugarJMeterContextClassLoader();
        } catch (IOException e) {
            e.printStackTrace();
            throw new SugarFileException(e);
        }

        return fileDTO;
    }

    @Override
    public PageInfo<SugarFileDTO> query(FileQuery fileQuery) throws SugarFileException {
        if(fileQuery.getPageNum() == null || fileQuery.getPageSize() == null){
            PageHelper.startPage(1, 10);
        } else {
            PageHelper.startPage(fileQuery.getPageNum(), fileQuery.getPageSize());
        }

        try {
            Page<SugarFile> files = fileDao.fetchFiles(fileQuery);
            Page<SugarFileDTO> fileDTOS = new Page<>();
            fileDTOS.setTotal(files.getTotal());
            fileDTOS.setPageSize(files.getPageSize());
            fileDTOS.setPageNum(files.getPageNum());

            for(SugarFile file: files){
                SugarFileDTO fileDTO = new SugarFileDTO();
                fileDTO.setId(file.getId());
                fileDTO.setName(file.getName());
                fileDTO.setFileType(file.getFileType());
                fileDTO.setRemark(file.getRemark());
                fileDTO.setUploaderId(file.getUploaderId());
                fileDTO.setUploaderName(file.getUploader().getUsername());
                fileDTO.setUploadTime(file.getUploadTime());
                if(file.getUpdater() != null){
                    fileDTO.setUpdaterId(file.getUpdaterId());
                    fileDTO.setUpdaterName(file.getUpdater().getUsername());
                    fileDTO.setUpdateTime(file.getUpdateTime());
                }
                fileDTOS.add(fileDTO);
            }
            return fileDTOS.toPageInfo();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarFileException(e);
        }
    }

    @Override
    public Integer delete(Integer id) throws SugarFileException {
        if(id == null){
            throw new SugarFileException("未指定要删除的文件");
        }

        try {
            SugarFile sugarFile = fileDao.fetchFileById(id);
            File toDelete = new File(SugarJMeterContext.getUploadRoot() + "/" + sugarFile.getFileName());
            SugarJMeterContext.destroyJMeterLoader();
            if(!toDelete.exists() || !FileDeleteStrategy.FORCE.deleteQuietly(toDelete)){
                throw new SugarFileException("删除文件失败");
            }
            fileDao.deleteFileById(id);
            SugarJMeterContext.resetSugarJMeterContextClassLoader();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarFileException(e);
        }
    }

    @Override
    public Integer update(FileUpdateVO updateVO) throws SugarFileException {
        if(updateVO.getId() == null){
            throw new SugarFileException("未指定更新的文件名称");
        }
        if(StringUtils.isEmpty(updateVO.getName())){
            throw new SugarFileException("文件名称不能为空");
        }
        SugarFile sugarFile = new SugarFile();
        sugarFile.setId(updateVO.getId());
        sugarFile.setName(updateVO.getName());
        sugarFile.setRemark(updateVO.getRemark());
        sugarFile.setUpdaterId(updateVO.getUpdaterId());

        try {
            return fileDao.updateFileById(sugarFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarFileException(e);
        }
    }


    private void writeFile(InputStream fileStream, String outputFileName) throws IOException {
        File saveFile = new File(outputFileName);
        if(saveFile.exists()){
            throw new IOException("文件已存在");
        }

        try (FileOutputStream outputStream = new FileOutputStream(outputFileName)){
            byte[] buf = new byte[1024];
            int bufSize;
            while ((bufSize = fileStream.read(buf)) != -1){
                outputStream.write(buf, 0, bufSize);
            }
        } catch (IOException e){
            throw e;
        }
    }
}
