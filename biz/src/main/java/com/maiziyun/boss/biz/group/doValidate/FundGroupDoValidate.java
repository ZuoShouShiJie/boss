package com.maiziyun.boss.biz.group.doValidate;

import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.common.model.OperatorRequest;
import com.maiziyun.boss.facade.common.model.OperatorResponse;
import com.maiziyun.boss.facade.common.model.service.LocalOperatorService;
import com.maiziyun.boss.facade.group.model.FundGroupListQueryRequest;
import com.maiziyun.boss.facade.group.model.FundGroupUpdateRequest;
import com.maiziyun.product.facade.model.AddProductGroup4BossRequest;
import com.maiziyun.product.facade.model.QueryProductGroupByConditionRequest;
import com.maiziyun.product.facade.model.UpdateProductGroupRequest;
import com.solar.framework.core.exception.BizException;
import com.solar.framework.core.model.Money;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by admin on 2017/11/22.
 */
@Service("boss.FundGroupDoValidate")
public class FundGroupDoValidate {
    private static Logger logger = LoggerFactory.getLogger(FundGroupDoValidate.class);
    @Resource(name = "boss.OperatorService")
    private LocalOperatorService operatorService;

    //新增
    public AddProductGroup4BossRequest addGroupProduct(FundGroupUpdateRequest request) {
        AddProductGroup4BossRequest $request = new AddProductGroup4BossRequest();
        if (StringUtils.isBlank(request.getLevelId())) {
            throw new BizException(BossBizCode.ParamNull, "评级" + BossBizCode.ParamNull.desc());
        }
        if (StringUtils.isBlank(request.getJijinId())) {
            throw new BizException(BossBizCode.ParamNull, "基金产品id" + BossBizCode.ParamNull.desc());
        }
        if (StringUtils.isBlank(request.getJijinPercent())) {
            throw new BizException(BossBizCode.ParamNull, "基金产品权重" + BossBizCode.ParamNull.desc());
        }
        if (StringUtils.isBlank(request.getGushouId())) {
            throw new BizException(BossBizCode.ParamNull, "固收产品id" + BossBizCode.ParamNull.desc());
        }
        if (StringUtils.isBlank(request.getGushouPercent())) {
            throw new BizException(BossBizCode.ParamNull, "固收产品权重" + BossBizCode.ParamNull.desc());
        }
       /* if (StringUtils.isBlank(request.getQitouAmount())) {
            throw new BizException(BossBizCode.ParamNull, "起投金额" + BossBizCode.ParamNull.desc());
        }*/
        if (StringUtils.isBlank(request.getStatusId())) {
            throw new BizException(BossBizCode.ParamNull, "状态" + BossBizCode.ParamNull.desc());
        }
        if (StringUtils.isNotBlank(request.getJijinLabel())) {
            if (request.getJijinLabel().length() > 10) {
                throw new BizException(BossBizCode.LaLengthMore10, "基金产品标签" + BossBizCode.LaLengthMore10.desc());
            }
        }
        if (StringUtils.isNotBlank(request.getGushouLabel())) {
            if (request.getGushouLabel().length() > 10) {
                throw new BizException(BossBizCode.LaLengthMore10, "固收产品标签" + BossBizCode.LaLengthMore10.desc());
            }
        }
        if ((Integer.valueOf(request.getJijinPercent()) + Integer.valueOf(request.getGushouPercent())) != 100) {
            throw new BizException(BossBizCode.WeighTotal, "" + BossBizCode.WeighTotal.desc());
        }
        $request.setRiskLevel(request.getLevelId());
        $request.setFundProductId(Long.valueOf(request.getJijinId()));
        $request.setFundWeight(Integer.valueOf(request.getJijinPercent()));
        $request.setFundTag(request.getJijinLabel());
        $request.setExchangeProductId(Long.valueOf(request.getGushouId()));
        $request.setExchangeProductWeight(Integer.valueOf(request.getGushouPercent()));
        $request.setExchangeProductTag(request.getGushouLabel());
      /*  if (StringUtils.isNotBlank(request.getQitouAmount())) {
            $request.setInvestAmount(new Money(request.getQitouAmount()));
        }
        if (StringUtils.isNotBlank(request.getStepAmount())) {
            $request.setIncreaseAmount(new Money(request.getStepAmount()));
        }*/
        $request.setStatus(request.getStatusId());
        //操作人
        OperatorRequest opRequest = new OperatorRequest();
        String userId = request.getUserId();
        if (StringUtils.isNotBlank(userId)) {
            opRequest.setUserId(Integer.valueOf(userId.substring(3)));
        }
        OperatorResponse opResponse = operatorService.getByOperId(opRequest);
        if (opResponse != null && opResponse.getOperatorVo() != null) {
            $request.setOperator(opResponse.getOperatorVo().getOperatorName());
        }

        return $request;
    }

    //修改
    public UpdateProductGroupRequest updateGroupProduct(FundGroupUpdateRequest request) {
        UpdateProductGroupRequest $request = new UpdateProductGroupRequest();
        if (StringUtils.isBlank(request.getJijinId())) {
            throw new BizException(BossBizCode.ParamNull, "基金产品id" + BossBizCode.ParamNull.desc());
        }
        if (StringUtils.isBlank(request.getJijinPercent())) {
            throw new BizException(BossBizCode.ParamNull, "基金产品权重" + BossBizCode.ParamNull.desc());
        }
        if (StringUtils.isBlank(request.getGushouId())) {
            throw new BizException(BossBizCode.ParamNull, "固收产品id" + BossBizCode.ParamNull.desc());
        }
        if (StringUtils.isBlank(request.getGushouPercent())) {
            throw new BizException(BossBizCode.ParamNull, "固收产品权重" + BossBizCode.ParamNull.desc());
        }
      /*  if (StringUtils.isBlank(request.getQitouAmount())) {
            throw new BizException(BossBizCode.ParamNull, "起投金额" + BossBizCode.ParamNull.desc());
        }*/
        if (StringUtils.isBlank(request.getStatusId())) {
            throw new BizException(BossBizCode.ParamNull, "状态" + BossBizCode.ParamNull.desc());
        }
        if (StringUtils.isNotBlank(request.getJijinLabel())) {
            if (request.getJijinLabel().length() > 10) {
                throw new BizException(BossBizCode.LaLengthMore10, "基金产品标签" + BossBizCode.LaLengthMore10.desc());
            }
        }
        if (StringUtils.isNotBlank(request.getGushouLabel())) {
            if (request.getGushouLabel().length() > 10) {
                throw new BizException(BossBizCode.LaLengthMore10, "固收产品标签" + BossBizCode.LaLengthMore10.desc());
            }
        }
        if ((Integer.valueOf(request.getJijinPercent()) + Integer.valueOf(request.getGushouPercent())) != 100) {
            throw new BizException(BossBizCode.WeighTotal, "" + BossBizCode.WeighTotal.desc());
        }
        $request.setId(Long.valueOf(request.getId()));
        $request.setFundProductId(Long.valueOf(request.getJijinId()));
        $request.setFundWeight(Integer.valueOf(request.getJijinPercent()));
        $request.setFundTag(request.getJijinLabel());
        $request.setExchangeProductId(Long.valueOf(request.getGushouId()));
        $request.setExchangeProductWeight(Integer.valueOf(request.getGushouPercent()));
        $request.setExchangeProductTag(request.getGushouLabel());
       /* if (StringUtils.isNotBlank(request.getQitouAmount())) {
            $request.setInvestAmount(new Money(request.getQitouAmount()));
        }
        if (StringUtils.isNotBlank(request.getStepAmount())) {
            $request.setIncreaseAmount(new Money(request.getStepAmount()));
        }*/
        $request.setStatus(request.getStatusId());
        //操作人
        OperatorRequest opRequest = new OperatorRequest();
        String userId = request.getUserId();
        if (StringUtils.isNotBlank(userId)) {
            opRequest.setUserId(Integer.valueOf(userId.substring(3)));
        }
        OperatorResponse opResponse = operatorService.getByOperId(opRequest);
        if (opResponse != null && opResponse.getOperatorVo() != null) {
            $request.setOperator(opResponse.getOperatorVo().getOperatorName());
        }
        return $request;
    }

    public QueryProductGroupByConditionRequest queryGroupProductList(FundGroupListQueryRequest request) {
        QueryProductGroupByConditionRequest $request = new QueryProductGroupByConditionRequest();
        if (StringUtils.isBlank(request.getPageNo())) {
            throw new BizException(BossBizCode.ParamNull, "pageNo" + BossBizCode.ParamNull.desc());
        }
        if (StringUtils.isBlank(request.getPageSize())) {
            throw new BizException(BossBizCode.ParamNull, "pageSize" + BossBizCode.ParamNull.desc());
        }
        $request.setRiskLevel(request.getLevel());
        $request.setStatus(request.getStatus());
        $request.setPageNo(Integer.valueOf(request.getPageNo()));
        $request.setPageSize(Integer.valueOf(request.getPageSize()));
        return $request;

    }


}
