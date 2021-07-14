package jc.sugar.JiaHui.service;

import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.entity.dto.SugarProjectDTO;
import jc.sugar.JiaHui.entity.vo.ProjectQueryVO;
import jc.sugar.JiaHui.entity.vo.ProjectSaveVO;
import jc.sugar.JiaHui.entity.vo.ProjectUpdateVO;
import jc.sugar.JiaHui.exception.SugarProjectException;

/**
 * @Code 谢良基 2021/6/23
 */
public interface SugarProjectService {

    SugarProjectDTO saveProject(ProjectSaveVO saveProject) throws SugarProjectException;

    PageInfo<SugarProjectDTO> queryProjects(ProjectQueryVO queryVO) throws SugarProjectException;

    Integer updateProject(ProjectUpdateVO updateProject) throws SugarProjectException;

    Integer deleteProject(Integer id) throws SugarProjectException;

    SugarProjectDTO fetchProject(Integer id) throws SugarProjectException;
}
