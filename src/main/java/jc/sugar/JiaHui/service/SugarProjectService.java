package jc.sugar.JiaHui.service;

import jc.sugar.JiaHui.entity.dto.SugarProjectDTO;
import jc.sugar.JiaHui.entity.vo.ProjectQueryVO;
import jc.sugar.JiaHui.entity.vo.ProjectSaveVO;
import jc.sugar.JiaHui.entity.vo.ProjectUpdateVO;
import jc.sugar.JiaHui.exception.SugarProjectException;

import java.util.List;

/**
 * @Code 谢良基 2021/6/23
 */
public interface SugarProjectService {

    SugarProjectDTO saveProject(ProjectSaveVO saveProject) throws SugarProjectException;

    List<SugarProjectDTO> queryProjects(ProjectQueryVO queryVO) throws SugarProjectException;

    Integer updateProject(ProjectUpdateVO updateProject) throws SugarProjectException;

    Integer deleteProject(Integer id) throws SugarProjectException;
}
