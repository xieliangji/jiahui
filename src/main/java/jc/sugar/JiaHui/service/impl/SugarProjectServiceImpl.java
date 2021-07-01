package jc.sugar.JiaHui.service.impl;

import jc.sugar.JiaHui.dao.SugarProjectDao;
import jc.sugar.JiaHui.dao.SugarProjectMemberDao;
import jc.sugar.JiaHui.entity.SugarAccount;
import jc.sugar.JiaHui.entity.SugarProject;
import jc.sugar.JiaHui.entity.SugarProjectMember;
import jc.sugar.JiaHui.entity.dto.SugarAccountDTO;
import jc.sugar.JiaHui.entity.dto.SugarProjectDTO;
import jc.sugar.JiaHui.entity.query.ProjectQuery;
import jc.sugar.JiaHui.entity.vo.ProjectQueryVO;
import jc.sugar.JiaHui.entity.vo.ProjectSaveVO;
import jc.sugar.JiaHui.entity.vo.ProjectUpdateVO;
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
    public List<SugarProjectDTO> queryProjects(ProjectQueryVO queryVO) throws SugarProjectException {
        ProjectQuery query = new ProjectQuery();
        query.setName(queryVO.getName());
        query.setCreatorName(queryVO.getCreatorName());
        query.setAccountId(queryVO.getAccountId());
        try {
            List<SugarProject> projects = projectDao.queryProject(query);
            System.out.println(projects);
            List<SugarProjectDTO> projectDtos = projects.stream().map(project -> {
                SugarProjectDTO projectDto = new SugarProjectDTO();
                projectDto.setId(project.getId());
                projectDto.setName(project.getName());
                projectDto.setRemark(project.getRemark());
                projectDto.setCreatorId(project.getCreatorId());
                projectDto.setCreateTime(project.getCreateTime());
                projectDto.setUpdateTime(project.getUpdateTime());
                projectDto.setMembers(project.getMembers().stream().map(account -> {
                    SugarAccountDTO accountDto = new SugarAccountDTO();
                    accountDto.setId(account.getId());
                    accountDto.setUsername(account.getUsername());
                    accountDto.setEmail(account.getEmail());
                    if(account.getId() == project.getCreatorId()){
                        projectDto.setCreatorName(account.getUsername());
                    }
                    return accountDto;
                }).collect(Collectors.toList()));
                return projectDto;
            }).collect(Collectors.toList());
            return projectDtos;
        } catch (Exception e) {
            throw new SugarProjectException(e);
        }
    }


    /**
     * 项目更新：项目名、备注更新、成员更新（添加、删除）
     * @param updateProject
     * @return
     * @throws SugarProjectException
     */
    @Override
    public Integer updateProject(ProjectUpdateVO updateProject) throws SugarProjectException {
        String validateResult = validateUpdateProject(updateProject);
        if(!StringUtils.isEmpty(validateResult)){
            throw new SugarProjectException(validateResult);
        }


        SugarProject project = new SugarProject();
        project.setId(updateProject.getId());
        project.setUpdaterId(updateProject.getAccountId());
        project.setName(updateProject.getName());
        project.setRemark(updateProject.getRemark());


        try {
            SugarProject oldProject = projectDao.fetchProjectById(updateProject.getId());
            List<SugarAccount> members = oldProject.getMembers();
            List<Integer> updateMemberIds = updateProject.getMemberIds();
            if(!updateMemberIds.contains(oldProject.getCreatorId())){
                throw new SugarProjectException("项目创建人不能从项目成员中被删除");
            }
            List<Integer> oldProjectMemberIds = members.stream().map(m -> m.getId()).collect(Collectors.toList());
            List<Integer> addProjectMemberIds = updateMemberIds.stream().filter(id -> !oldProjectMemberIds.contains(id)).collect(Collectors.toList());
            List<Integer> deleteProjectMemberIds = oldProjectMemberIds.stream().filter(id -> !updateMemberIds.contains(id)).collect(Collectors.toList());

            // 新增的成员
            List<SugarProjectMember> addProjectMember = addProjectMemberIds.stream().map(id -> {
                SugarProjectMember projectMember = new SugarProjectMember();
                projectMember.setProjectId(project.getId());
                projectMember.setAccountId(id);
                return projectMember;
            }).collect(Collectors.toList());
            if(addProjectMember.size() > 0){
                projectMemberDao.saveProjectMember(addProjectMember);
            }

            // 删除的成员
            List<SugarProjectMember> deleteProjectMember = deleteProjectMemberIds.stream().map(id -> {
                SugarProjectMember projectMember = new SugarProjectMember();
                projectMember.setProjectId(project.getId());
                projectMember.setAccountId(id);
                return projectMember;
            }).collect(Collectors.toList());
            if(deleteProjectMember.size() > 0){
                projectMemberDao.deleteProjectMember(deleteProjectMember);
            }

            return projectDao.updateProject(project);
        } catch (Exception e) {
            throw new SugarProjectException(e);
        }
    }

    @Override
    public Integer deleteProject(Integer id) throws SugarProjectException {
        try {
            return projectDao.deleteProjectById(id);
        } catch (Exception e) {
            throw new SugarProjectException(e);
        }
    }

    @Override
    public SugarProjectDTO saveProject(ProjectSaveVO saveProject) throws SugarProjectException {
        String validateResult = validateNewProject(saveProject);
        if(!StringUtils.isEmpty(validateResult)){
            throw new SugarProjectException(validateResult);
        }

        SugarProject project = new SugarProject();
        project.setName(saveProject.getName());
        project.setRemark(saveProject.getRemark());
        project.setCreatorId(saveProject.getCreatorId());
        try {
            Integer saveFlag = projectDao.saveProject(project);
            if(saveFlag == 1){
                Integer projectId = project.getId();
                List<Integer> memberIds = saveProject.getMemberIds();

                List<SugarProjectMember> projectMembers = memberIds.stream().map(memberId -> {
                    SugarProjectMember projectMember = new SugarProjectMember();
                    projectMember.setProjectId(projectId);
                    projectMember.setAccountId(memberId);
                    return projectMember;
                }).collect(Collectors.toList());

                projectMemberDao.saveProjectMember(projectMembers);
            }

            SugarProject savedProject = projectDao.fetchProjectById(project.getId());
            SugarProjectDTO projectDTO = new SugarProjectDTO();
            projectDTO.setId(savedProject.getId());
            projectDTO.setName(savedProject.getName());
            projectDTO.setRemark(savedProject.getRemark());
            projectDTO.setMembers(savedProject.getMembers().stream().map(m -> {
                SugarAccountDTO accountDTO = new SugarAccountDTO();
                accountDTO.setId(m.getId());
                accountDTO.setUsername(m.getUsername());
                accountDTO.setEmail(m.getEmail());
                return accountDTO;
            }).collect(Collectors.toList()));
            projectDTO.setCreatorId(savedProject.getCreatorId());
            projectDTO.setCreateTime(savedProject.getCreateTime());
            return projectDTO;
        } catch (Exception e) {
            throw new SugarProjectException(e);
        }
    }


    private String validateNewProject(ProjectSaveVO newProject){
        if(StringUtils.isEmpty(newProject.getName())){
            return "项目名称不能为空";
        }
        return "";
    }


    private String validateUpdateProject(ProjectUpdateVO updateVO){
        if(updateVO.getAccountId() == null){
            return "更新人用户ID不能为空";
        }

        if(updateVO.getId() == null){
            return "未指定更新项目ID";
        }

        if(StringUtils.isEmpty(updateVO.getName())){
            return "项目名称不能为空";
        }

        return "";
    }
}
