package com.maiziyun.boss.biz.finance.service.impl;

import com.maiziyun.acs.facade.model.*;
import com.maiziyun.acs.facade.model.vo.AwardTaskVO;
import com.maiziyun.acs.facade.model.vo.UnitAwardRuleVO;
import com.maiziyun.boss.biz.finance.convert.CornfieldConverter;
import com.maiziyun.boss.biz.finance.service.LocalCornService;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.finance.model.*;
import com.maiziyun.boss.facade.finance.model.vo.CornfieldVo;
import com.maiziyun.boss.facade.finance.model.vo.UnitAwardRuleVo;
import com.maiziyun.boss.integration.finance.CornfieldClient;
import com.solar.framework.core.base.BaseException;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/6/21.
 */
@Service("boss.cornfieldService")
public class LocalCornServiceImpl implements LocalCornService {
    private static final Logger logger = LoggerFactory.getLogger(LocalCornServiceImpl.class);

    @Resource(name = "boss.cornClient")
    private CornfieldClient cornClient;

    /**
     * 麦田查询
     *
     * @param request
     * @return
     */
    @Override
    public QueryCornResponse queryAllCornfield(QueryCornRequest request) {
        QueryCornResponse response = new QueryCornResponse();
        logger.info("接收请求service{}", request);
        try {
            QueryAwardTaskListRequest $request = preRequestQy(request);
            QueryAwardTaskListResponse $response = cornClient.queryAllCornfield($request);
            if ($response != null && $response.getAwardTasks() != null && $response.getAwardTasks().size() > 0) {
                List<AwardTaskVO> list = $response.getAwardTasks();
                List<CornfieldVo> $list = CornfieldConverter.revertListQy(list);
                response.setDatas($list);
                response.setTotal($response.getTotal());
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            } else {
                response.setDatas(null);
                response.setTotal(null);
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            }

        } catch (BaseException e) {
            logger.error("麦子管理查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("麦子管理查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;


    }

    public QueryAwardTaskListRequest preRequestQy(QueryCornRequest request) {
        QueryAwardTaskListRequest $request = new QueryAwardTaskListRequest();
        if (StringUtils.isNotBlank(request.getPageNo())) {
            $request.setPageNo(Integer.valueOf(request.getPageNo()));
        } else {
            throw new BizException(BizCode.ParamNull, "pageNo" + BizCode.ParamNull.desc());
        }
        if (StringUtils.isNotBlank(request.getPageSize())) {
            $request.setPageSize(Integer.valueOf(request.getPageSize()));
        } else {
            throw new BizException(BizCode.ParamNull, "pageSize" + BizCode.ParamNull.desc());
        }
        $request.setName(request.getName());
        if ("all".equals(request.getStatusId()) || StringUtils.isBlank(request.getStatusId())) {
            $request.setTaskStatus(null);
        } else {
            $request.setTaskStatus(request.getStatusId());
        }
        if ("all".equals(request.getTaskTypeId()) || StringUtils.isBlank(request.getTaskTypeId())) {
            $request.setTaskType(null);
        } else {
            $request.setTaskType(request.getTaskTypeId());
        }
        if ("all".equals(request.getTaskActionId()) || StringUtils.isBlank(request.getTaskActionId())) {
            $request.setTaskAction(null);
        } else {
            $request.setTaskAction(request.getTaskActionId());
        }
        return $request;
    }


    /**
     * 通过id查询
     *
     * @param request
     * @return
     */
    @Override
    public QueryCornResponse queryCornById(QueryCornRequest request) {
        QueryCornResponse response = new QueryCornResponse();
        logger.info("接收请求service{}", request);
        try {
            if (StringUtils.isBlank(request.getId())) {
                throw new BizException(BizCode.ParamNull, "id" + BizCode.ParamNull.desc());
            }
            QueryAwardTaskByIdRequest $request = new QueryAwardTaskByIdRequest();
            $request.setId(Long.valueOf(request.getId()));
            QueryAwardTaskResponse $response = cornClient.queryCornById($request);
            if ($response != null && $response.getAwardTask() != null) {
                CornfieldVo vo = CornfieldConverter.revertVoQy($response.getAwardTask());
                response.setCornfieldVo(vo);
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            } else {
                response.setCornfieldVo(null);
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            }

        } catch (BaseException e) {
            logger.error("麦子管理详情查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("麦子管理详情查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;

    }

    /**
     * 新增保存
     *
     * @param createCorn
     * @return
     */
    @Override
    public CreateCornResponse createCornfield(CreateCornRequest createCorn) {
        logger.info("接收请求service{}", createCorn);
        CreateCornResponse response = new CreateCornResponse();
        try {
            CreateTaskRequest $request = preRequestCt(createCorn);
            CreateTaskResponse $response = cornClient.createCornfield($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("麦田管理新增异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("麦田管理新增异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    public CreateTaskRequest preRequestCt(CreateCornRequest createCorn) {
        CreateTaskRequest $request = new CreateTaskRequest();
        $request.setName(createCorn.getName());
        $request.setTaskType(createCorn.getTaskTypeId());
        $request.setTaskAction(createCorn.getTaskActionId());
        if ("all".equals(createCorn.getInveScopeId()) || StringUtils.isBlank(createCorn.getInveScopeId())) {
            $request.setInvestScope(null);
        } else {
            $request.setInvestScope(createCorn.getInveScopeId());
        }
        $request.setInvestCondition(createCorn.getInveCondId());
        $request.setTaskStatus(createCorn.getStatusId());
        $request.setFrontVisible(createCorn.getFrontVisibleId());
        if (StringUtils.isNotBlank(createCorn.getSort())) {
            $request.setSort(Integer.valueOf(createCorn.getSort()));
        }

        if (StringUtils.isNotBlank(createCorn.getUnitCondition())) {
            $request.setUnitCondition(new BigDecimal(createCorn.getUnitCondition()));
        }
        if (StringUtils.isNotBlank(createCorn.getUnitAwardPoint())) {
            $request.setUnitAwardPoint(new BigDecimal(createCorn.getUnitAwardPoint()));
        }

        if (createCorn.getAccAwardRules() != null) {
            List<UnitAwardRuleVo> VoList = createCorn.getAccAwardRules();
            List<UnitAwardRuleVO> VOList = new ArrayList<>();
            for (UnitAwardRuleVo vo : VoList) {
                UnitAwardRuleVO rule = new UnitAwardRuleVO();
                if (StringUtils.isNotBlank(vo.getUnitCondition())) {
                    rule.setUnitCondition(new BigDecimal(vo.getUnitCondition()));
                }
                if (StringUtils.isNotBlank(vo.getUnitAwardPoint())) {
                    rule.setUnitAwardPoint(new BigDecimal(vo.getUnitAwardPoint()));
                }
                VOList.add(rule);
            }

            $request.setAccAwardRules(VOList);

        }

        return $request;
    }


    /**
     * 麦田管理修改
     *
     * @param updateCorn
     * @return
     */
    @Override
    public UpdateCornResponse updateCornfield(UpdateCornRequest updateCorn) {
        logger.info("接收请求service{}", updateCorn);
        UpdateCornResponse response = new UpdateCornResponse();
        try {

            UpdateTaskRequest $request = preRequestUp(updateCorn);
            UpdateTaskResponse $response = cornClient.updateCornfield($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("麦田管理修改异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("麦田管理修改异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    public UpdateTaskRequest preRequestUp(UpdateCornRequest updateCorn) {
        if (StringUtils.isBlank(updateCorn.getId())) {
            throw new BizException(BizCode.ParamNull, "id" + BizCode.ParamNull.desc());
        }
        UpdateTaskRequest $request = new UpdateTaskRequest();
        $request.setId(Long.valueOf(updateCorn.getId()));
        $request.setName(updateCorn.getName());
        $request.setTaskType(updateCorn.getTaskTypeId());
        $request.setTaskAction(updateCorn.getTaskActionId());
        if ("all".equals(updateCorn.getInveScopeId()) || StringUtils.isBlank(updateCorn.getInveScopeId())) {
            $request.setInvestScope(null);
        } else {
            $request.setInvestScope(updateCorn.getInveScopeId());
        }
        $request.setInvestCondition(updateCorn.getInveCondId());
        $request.setTaskStatus(updateCorn.getStatusId());
        $request.setFrontVisible(updateCorn.getFrontVisibleId());
        if (StringUtils.isNotBlank(updateCorn.getSort())) {
            $request.setSort(Integer.valueOf(updateCorn.getSort()));
        }

        if (StringUtils.isNotBlank(updateCorn.getUnitCondition())) {
            $request.setUnitCondition(new BigDecimal(updateCorn.getUnitCondition()));
        }
        if (StringUtils.isNotBlank(updateCorn.getUnitAwardPoint())) {
            $request.setUnitAwardPoint(new BigDecimal(updateCorn.getUnitAwardPoint()));
        }

        if (updateCorn.getAccAwardRules() != null) {
            List<UnitAwardRuleVo> VoList = updateCorn.getAccAwardRules();
            List<UnitAwardRuleVO> VOList = new ArrayList<>();
            for (UnitAwardRuleVo vo : VoList) {
                UnitAwardRuleVO rule = new UnitAwardRuleVO();
                if (StringUtils.isNotBlank(vo.getUnitCondition())) {
                    rule.setUnitCondition(new BigDecimal(vo.getUnitCondition()));
                }
                if (StringUtils.isNotBlank(vo.getUnitAwardPoint())) {
                    rule.setUnitAwardPoint(new BigDecimal(vo.getUnitAwardPoint()));
                }
                VOList.add(rule);
            }
            $request.setAccAwardRules(VOList);
        }

        return $request;
    }

    /**
     * 上下线状态修改
     *
     * @param request
     * @return
     */
    @Override
    public UpdateCornResponse updateCornStatus(UpdateCornRequest request) {
        logger.info("接收请求service{}", request);
        UpdateCornResponse response = new UpdateCornResponse();
        try {

            if (StringUtils.isBlank(request.getId())) {
                throw new BizException(BizCode.ParamNull, "id" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getStatusId())) {
                throw new BizException(BizCode.ParamNull, "状态" + BizCode.ParamNull.desc());
            }
            UpdateTaskStatusRequest $request = new UpdateTaskStatusRequest();
            $request.setTaskId(Long.valueOf(request.getId()));
            $request.setTaskStatus(request.getStatusId());
            UpdateTaskStatusResponse $response = cornClient.updateCornStatus($request);

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("麦田管理状态上下线修改异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("麦田管理状态上下线修改异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 麦子管理删除
     *
     * @param request
     * @return
     */
    @Override
    public UpdateCornResponse deleteCornfield(UpdateCornRequest request) {
        logger.info("接收请求service{}", request);
        UpdateCornResponse response = new UpdateCornResponse();
        try {

            DeleteTaskRequest $request = new DeleteTaskRequest();
            if (StringUtils.isBlank(request.getId())) {
                throw new BizException(BizCode.ParamNull, "id" + BizCode.ParamNull.desc());
            }
            $request.setId(Long.valueOf(request.getId()));
            DeleteTaskResponse $response = cornClient.deleteCornfield($request);

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("麦田管理删除异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("麦田管理删除异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }
}
