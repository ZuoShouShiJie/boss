package com.maiziyun.boss.integration.finance.impl;

import com.maiziyun.acs.facade.TaskConfigService;
import com.maiziyun.acs.facade.model.*;
import com.maiziyun.boss.integration.finance.CornfieldClient;
import com.maiziyun.common.enums.MyServiceCode;
import com.solar.framework.core.enums.SourceCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/7/17.
 */
public class CornfieldClientImpl implements CornfieldClient {
    private static final Logger logger = LoggerFactory.getLogger(CornfieldClientImpl.class);

    private TaskConfigService taskConfigService;

    public void setTaskConfigService(TaskConfigService taskConfigService) {
        this.taskConfigService = taskConfigService;
    }

    @Override
    public QueryAwardTaskListResponse queryAllCornfield(QueryAwardTaskListRequest request){
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向acs发送请求：{}", request);
        QueryAwardTaskListResponse response = taskConfigService.queryList(request);
        logger.info("acs返回数据：{}", response);
        return response;

    }

    @Override
    public QueryAwardTaskResponse queryCornById(QueryAwardTaskByIdRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向acs发送请求：{}", request);
        QueryAwardTaskResponse response = taskConfigService.queryTaskById(request);
        logger.info("acs返回数据：{}", response);
        return response;
    }

    @Override
    public CreateTaskResponse createCornfield(CreateTaskRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向acs发送请求：{}", request);
        CreateTaskResponse response = taskConfigService.createTask(request);
        logger.info("acs返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateTaskResponse updateCornfield(UpdateTaskRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向acs发送请求：{}", request);
        UpdateTaskResponse response = taskConfigService.updateTaskById(request);
        logger.info("acs返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateTaskStatusResponse updateCornStatus(UpdateTaskStatusRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向acs发送请求：{}", request);
        UpdateTaskStatusResponse response = taskConfigService.updateTaskStatus(request);
        logger.info("acs返回数据：{}", response);
        return response;
    }

    @Override
    public DeleteTaskResponse deleteCornfield(DeleteTaskRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向acs发送请求：{}", request);
        DeleteTaskResponse response = taskConfigService.deleteTask(request);
        logger.info("acs返回数据：{}", response);
        return response;
    }
}
