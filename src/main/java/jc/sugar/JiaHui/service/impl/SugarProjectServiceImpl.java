package jc.sugar.JiaHui.service.impl;

import jc.sugar.JiaHui.dao.SugarProjectDao;
import jc.sugar.JiaHui.dao.SugarProjectMemberDao;
import jc.sugar.JiaHui.dto.SugarAccountDto;
import jc.sugar.JiaHui.dto.SugarProjectDto;
import jc.sugar.JiaHui.entity.SugarProject;
import jc.sugar.JiaHui.entity.SugarProjectMember;
import jc.sugar.JiaHui.exception.SugarProjectException;
import jc.sugar.JiaHui.service.SugarProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Code 谢良基 2021/6/23
 */
@Service
public class SugarProjectServiceImpl implements SugarProjectService {

    private final SugarProjectDao projectDao;

    private final SugarProjectMemberDao projectMemberDao;


    public SugarProjectServiceImpl(SugarProjectDao projectDao, SugarProjectMemberDao projectMemberDao){
        this.projectDao = projectDao;
        this.projectMemberDao = projectMemberDao;
    }

    @Override
    public List<SugarProjectDto> getProjectsOfAccount(Integer accountId) throws SugarProjectException {
        try {
            List<SugarProject> projects = projectDao.findProjectByMember(accountId);
            List<SugarProjectDto> projectDtos = projects.stream().map(project -> {
                SugarProjectDto projectDto = new SugarProjectDto();
                projectDto.setId(project.getId());
                projectDto.setName(project.getName());
                projectDto.setRemark(project.getRemark());
                projectDto.setCreatorId(project.getCreatorId());
                projectDto.setCreateTime(project.getCreateTime());
                projectDto.setUpdateTime(project.getUpdateTime());
                projectDto.setMembers(project.getMembers().stream().map(account -> {
                    SugarAccountDto accountDto = new SugarAccountDto();
                    accountDto.setId(account.getId());
                    accountDto.setUsername(account.getUsername());
                    accountDto.setEmail(account.getEmail());
                    return accountDto;
                }).collect(Collectors.toList()));
                return projectDto;
            }).collect(Collectors.toList());
            return projectDtos;
        } catch (Exception e) {
            throw new SugarProjectException(e);
        }
    }

    @Override
    public SugarProjectDto saveProject(SugarProjectDto newProject) throws SugarProjectException {
        String validateResult = validateNewProject(newProject);
        if(!StringUtils.isEmpty(validateResult)){
            throw new SugarProjectException(validateResult);
        }

        SugarProject project = new SugarProject();
        project.setName(newProject.getName());
        project.setRemark(newProject.getRemark());
        project.setCreatorId(newProject.getCreatorId());
        try {
            projectDao.saveProject(project);
        } catch (Exception e) {
            throw new SugarProjectException(e);
        }

        Integer projectId = project.getId();
        List<Integer> memberIds = newProject.getMemberIds();
        List<SugarProjectMember> members = memberIds.stream().map( memberId -> {
            SugarProjectMember projectMember = new SugarProjectMember();
            projectMember.setProjectId(projectId);
            projectMember.setAccountId(memberId);
            return projectMember;
        }).collect(Collectors.toList());

        try {
            projectMemberDao.saveProjectMember(members);
        } catch (Exception e) {
            throw new SugarProjectException(e);
        }

        newProject.setId(projectId);
        return newProject;
    }

    private String validateNewProject(SugarProjectDto newProject){
        if(StringUtils.isEmpty(newProject.getName())){
            return "项目名称不能为空";
        }
        return "";
    }
}
