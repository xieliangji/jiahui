package jc.sugar.JiaHui.dao;

import com.github.pagehelper.Page;
import jc.sugar.JiaHui.entity.SugarFile;
import jc.sugar.JiaHui.entity.query.FileQuery;
import org.apache.ibatis.annotations.Mapper;

/**
 * 2021/5/25 11:48
 * Code by 谢良基
 */
@Mapper
public interface SugarFileDao {

    Integer saveFile(SugarFile sugarFile) throws Exception;


    Page<SugarFile> fetchFiles(FileQuery fileQuery) throws Exception;


    Integer deleteFileById(Integer id) throws Exception;


    Integer updateFileById(SugarFile file) throws Exception;


    SugarFile fetchFileById(Integer id) throws Exception;
}
