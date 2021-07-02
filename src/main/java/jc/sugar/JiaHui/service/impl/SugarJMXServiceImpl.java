package jc.sugar.JiaHui.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.config.SugarProperties;
import jc.sugar.JiaHui.dao.SugarJMXDao;
import jc.sugar.JiaHui.entity.SugarJMX;
import jc.sugar.JiaHui.entity.dto.SugarJMXDTO;
import jc.sugar.JiaHui.entity.query.JMXQuery;
import jc.sugar.JiaHui.entity.vo.JMXQueryVO;
import jc.sugar.JiaHui.entity.vo.JMXSaveVO;
import jc.sugar.JiaHui.entity.vo.JMXUpdateVO;
import jc.sugar.JiaHui.exception.SugarJMXException;
import jc.sugar.JiaHui.jmeter.JMeterHashTreeUtil;
import jc.sugar.JiaHui.jmeter.JMeterInitializer;
import jc.sugar.JiaHui.jmeter.exceptions.JMeterTestElementMapperException;
import jc.sugar.JiaHui.service.SugarJMXService;
import org.apache.commons.lang3.StringUtils;
import org.apache.jmeter.save.SaveService;
import org.apache.jorphan.collections.HashTree;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Code 谢良基 2021/7/1
 */
@Service
public class SugarJMXServiceImpl implements SugarJMXService {


    private final SugarJMXDao jmxDao;

    private final SugarProperties sugarProperties;

    public SugarJMXServiceImpl(SugarJMXDao jmxDao, SugarProperties sugarProperties) {
        this.jmxDao = jmxDao;
        this.sugarProperties = sugarProperties;
    }


    @Override
    public SugarJMXDTO saveJMX(JMXSaveVO saveVO) throws SugarJMXException {
        String validateResult = validateSaveVO(saveVO);
        if(!StringUtils.isEmpty(validateResult)){
            throw new SugarJMXException(validateResult);
        }

        String jmxPath = saveVO.getName() + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".jmx";
        SugarJMX sugarJMX = new SugarJMX();
        sugarJMX.setName(saveVO.getName());
        sugarJMX.setRemark(saveVO.getRemark());
        sugarJMX.setProjectId(saveVO.getProjectId());
        sugarJMX.setCreatorId(saveVO.getCreatorId());
        sugarJMX.setJmxPath(jmxPath);

        try {
            if(saveJMXContent(saveVO.getJmxContent(), jmxPath, false)){
                jmxDao.saveJmx(sugarJMX);
            }
            SugarJMXDTO jmxDto = new SugarJMXDTO();
            jmxDto.setId(sugarJMX.getId());
            jmxDto.setName(sugarJMX.getName());
            jmxDto.setRemark(sugarJMX.getRemark());
            jmxDto.setProjectId(sugarJMX.getProjectId());
            jmxDto.setCreatorId(sugarJMX.getCreatorId());
            return jmxDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarJMXException(e);
        }
    }

    @Override
    public PageInfo<SugarJMXDTO> queryJMX(JMXQueryVO queryVO) throws SugarJMXException {
        callPageHelper(queryVO.getPageNum(), queryVO.getPageSize());

        JMXQuery jmxQuery = new JMXQuery();
        jmxQuery.setName(queryVO.getName());
        jmxQuery.setProjectName(queryVO.getProjectName());
        jmxQuery.setCreatorName(queryVO.getCreatorName());
        jmxQuery.setUpdaterName(queryVO.getUpdaterName());


        Page<SugarJMXDTO> result = new Page<>();
        try {
            Page<SugarJMX> jmxPage = jmxDao.queryJmx(jmxQuery);
            for(SugarJMX jmx: jmxPage){
                SugarJMXDTO jmxDto = new SugarJMXDTO();
                jmxDto.setId(jmx.getId());
                jmxDto.setName(jmx.getName());
                jmxDto.setJmxContent(getJMXContent(jmx.getJmxPath()));
                jmxDto.setRemark(jmx.getRemark());
                jmxDto.setProjectId(jmx.getProjectId());
                jmxDto.setProjectName(jmx.getProject().getName());
                jmxDto.setCreatorId(jmx.getCreatorId());
                jmxDto.setCreatorName(jmx.getCreator().getUsername());
                if(jmx.getUpdater() != null){
                    jmxDto.setUpdaterId(jmx.getUpdaterId());
                    jmxDto.setUpdaterName(jmx.getUpdater().getUsername());
                }
                jmxDto.setCreateTime(jmx.getCreateTime());
                jmxDto.setUpdateTime(jmx.getUpdateTime());
                result.add(jmxDto);
            }
            result.setPageNum(jmxPage.getPageNum());
            result.setPageSize(jmxPage.getPageSize());
            result.setTotal(jmxPage.getTotal());
            return result.toPageInfo();
        } catch (Exception e) {
            throw new SugarJMXException(e);
        }
    }

    @Override
    public void updateJMX(JMXUpdateVO updateVO) throws SugarJMXException {
        String validateResult = validateUpdateVO(updateVO);
        if(!StringUtils.isEmpty(validateResult)){
            throw new SugarJMXException(validateResult);
        }

        try {
            SugarJMX sugarJMX = jmxDao.fetchJmxById(updateVO.getId());
            if(sugarJMX == null){
                throw new SugarJMXException("测试计划不存在");
            }
            String jmxPath = sugarJMX.getJmxPath();
            if(saveJMXContent(updateVO.getJmxContent(), jmxPath, true)){
                sugarJMX.setName(updateVO.getName());
                sugarJMX.setUpdaterId(updateVO.getUpdaterId());
                sugarJMX.setRemark(updateVO.getRemark());
                jmxDao.updateJmx(sugarJMX);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarJMXException(e);
        }
    }

    @Override
    public void deleteJMX(Integer jmxId) throws SugarJMXException {
        try {
            SugarJMX jmx = jmxDao.fetchJmxById(jmxId);
            if(jmx == null){
                return;
            }
            if(deleteJMXContent(jmx.getJmxPath())){
                jmxDao.deleteJmxById(jmxId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarJMXException(e);
        }
    }

    @Override
    public void executeJMX(Integer jmxId) throws SugarJMXException {
















    }


    private void callPageHelper(Integer pageNum, Integer pageSize){
        int minNum = 1;
        int minSize = 10;
        if(pageNum == null || pageNum < minNum){
            pageNum = minNum;
        }
        if(pageSize == null || pageSize < minSize){
            pageSize = minSize;
        }
        PageHelper.startPage(pageNum, pageSize);
    }


    private String validateSaveVO(JMXSaveVO saveVO){
        if(StringUtils.isEmpty(saveVO.getName())){
            return "测试计划名称不能为空";
        }
        if(saveVO.getJmxContent() == null){
            return "测试计划不能为空";
        }
        if(saveVO.getCreatorId() == null){
            return "测试计划创建人不能为空";
        }
        if(saveVO.getProjectId() == null){
            return "测试计划所属项目不能为空";
        }
        return "";
    }


    private String validateUpdateVO(JMXUpdateVO updateVO){
        if(updateVO.getId() == null){
            return "未指定要更新的测试计划";
        }
        if(updateVO.getUpdaterId() == null){
            return "未指定更新测试计划的更新人";
        }
        if(StringUtils.isEmpty(updateVO.getName())){
            return "测试计划名称不能为空";
        }
        return "";
    }


    private boolean saveJMXContent(List<Map<String, Object>> jmxContent, String jmxPath, boolean isUpdate) throws SugarJMXException, IOException, JMeterTestElementMapperException {
        String resourceRoot = JMeterInitializer.getResourceRoot();
        File jmxFile = Paths.get(resourceRoot, sugarProperties.getJmxRoot(), jmxPath).toFile();
        if(!isUpdate){
            if(jmxFile.exists()){
                throw new SugarJMXException("测试计划已存在, 新建测试计划失败");
            }
            jmxFile.createNewFile();
        } else {
            if(!jmxFile.exists()){
                throw new SugarJMXException("测试计划不存在或已被删除，更新测试计划失败");
            }
        }

        JMeterInitializer.initialize();
        HashTree hashTree = JMeterHashTreeUtil.toHashTree(jmxContent);
        SaveService.saveTree(hashTree, new FileOutputStream(jmxFile));
        return true;
    }


    private List<Map<String, Object>> getJMXContent(String jmxPath) throws IOException, JMeterTestElementMapperException {
        String resourceRoot = JMeterInitializer.getResourceRoot();
        File jmxFile = Paths.get(resourceRoot, sugarProperties.getJmxRoot(), jmxPath).toFile();
        JMeterInitializer.initialize();
        HashTree hashTree = SaveService.loadTree(jmxFile);
        return JMeterHashTreeUtil.fromHashTree(hashTree);
    }


    private boolean deleteJMXContent(String jmxPath){
        String resourceRoot = JMeterInitializer.getResourceRoot();
        File jmxFile = Paths.get(resourceRoot, sugarProperties.getJmxRoot(), jmxPath).toFile();
        if(jmxFile.exists()){
            jmxFile.delete();
        }
        return true;
    }

    private static class JMXExecutor implements Runnable{





        @Override
        public void run() {

        }
    }
}
