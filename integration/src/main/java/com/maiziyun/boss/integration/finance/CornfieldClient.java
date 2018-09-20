package com.maiziyun.boss.integration.finance;

import com.maiziyun.acs.facade.model.*;

/**
 * Created by admin on 2017/7/17.
 */
public interface CornfieldClient {
    public QueryAwardTaskListResponse queryAllCornfield(QueryAwardTaskListRequest request);
    public QueryAwardTaskResponse queryCornById(QueryAwardTaskByIdRequest request);
    public CreateTaskResponse createCornfield(CreateTaskRequest request);
    public UpdateTaskResponse updateCornfield(UpdateTaskRequest request);
    public UpdateTaskStatusResponse updateCornStatus(UpdateTaskStatusRequest request);
    public DeleteTaskResponse deleteCornfield(DeleteTaskRequest request);




}
