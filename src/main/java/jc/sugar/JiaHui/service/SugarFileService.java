package jc.sugar.JiaHui.service;

import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.entity.dto.SugarFileDTO;
import jc.sugar.JiaHui.entity.query.FileQuery;
import jc.sugar.JiaHui.entity.vo.FileUpdateVO;
import jc.sugar.JiaHui.exception.SugarFileException;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Code 谢良基 2021/7/9
 */
public interface SugarFileService {

    SugarFileDTO upload(MultipartFile multipartFile, String name, Integer fileType, String remark, Integer uploaderId) throws SugarFileException;


    PageInfo<SugarFileDTO> query(FileQuery fileQuery) throws SugarFileException;


    Integer delete(Integer id) throws SugarFileException;


    Integer update(FileUpdateVO updateVO) throws SugarFileException;
}
