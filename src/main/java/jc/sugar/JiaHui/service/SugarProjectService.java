package jc.sugar.JiaHui.service;

import jc.sugar.JiaHui.dto.SugarProjectDto;
import jc.sugar.JiaHui.exception.SugarProjectException;

import java.util.List;

/**
 * @Code 谢良基 2021/6/23
 */
public interface SugarProjectService {

    List<SugarProjectDto> getProjectsOfAccount(Integer accountId) throws SugarProjectException;

    SugarProjectDto saveProject(SugarProjectDto newProject) throws SugarProjectException;
}
