package com.maiziyun.boss.facade.finance.service;

import com.maiziyun.boss.facade.finance.model.*;

/**
 * Created by admin on 2017/6/21.
 */
public interface CornfieldService {
    public QueryCornResponse queryAllCornfield(QueryCornRequest request);
    public QueryCornResponse queryCornById(QueryCornRequest request);
    public CreateCornResponse createCornfield(CreateCornRequest request);
    public UpdateCornResponse updateCornfield(UpdateCornRequest request);
    public UpdateCornResponse updateCornStatus(UpdateCornRequest request);
    public UpdateCornResponse deleteCornfield(UpdateCornRequest request);



}
