package com.maiziyun.boss.biz.group.service.impl;

import com.maiziyun.boss.biz.group.convert.FundGroupConverter;
import com.maiziyun.boss.biz.group.doValidate.FundGroupDoValidate;
import com.maiziyun.boss.biz.group.service.LocalFundGroupService;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.common.model.ResponseNewData;
import com.maiziyun.boss.facade.group.model.FundGroupListQueryRequest;
import com.maiziyun.boss.facade.group.model.FundGroupUpdateRequest;
import com.maiziyun.boss.facade.group.model.vo.FundGroupListVo;
import com.maiziyun.boss.facade.group.model.vo.QueryFundProductVo;
import com.maiziyun.boss.facade.group.model.vo.QuerySolidProductVo;
import com.maiziyun.boss.facade.jysmng.model.vo.UserInvestListVo;
import com.maiziyun.boss.integration.group.FundGroupServiceClient;
import com.maiziyun.product.facade.model.*;
import com.maiziyun.product.facade.model.vo.QueryExchangeProductByNameVO;
import com.maiziyun.product.facade.model.vo.QueryLiveProductByNameVO;
import com.maiziyun.product.facade.model.vo.QueryProductGroupByConditionVO;
import com.solar.framework.core.base.BaseException;
import com.solar.framework.core.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by admin on 2017/11/21.
 */
@Service("boss.FundGroupService")
public class LocalFundGroupServiceImpl implements LocalFundGroupService {
    private static Logger logger = LoggerFactory.getLogger(LocalFundGroupServiceImpl.class);
    @Resource(name = "boss.FundGroupClient")
    private FundGroupServiceClient fundGroupServiceClient;
    @Resource(name = "boss.FundGroupDoValidate")
    FundGroupDoValidate fundGroupDoValidate;

    /**
     * 组合产品查询列表
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData queryGroupProductList(FundGroupListQueryRequest request) {
        ResponseNewData data = new ResponseNewData();
        List<FundGroupListVo> responseData = null;
        try {
            QueryProductGroupByConditionRequest $request = fundGroupDoValidate.queryGroupProductList(request);
            QueryProductGroupByConditionResponse $response = fundGroupServiceClient.queryProductGroupBycondition($request);
            if ($response != null && $response.getDatas() != null && $response.getDatas().size() > 0) {
                List<QueryProductGroupByConditionVO> list = $response.getDatas();
                responseData = FundGroupConverter.convertFundGroupQy(list);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("list", responseData == null ? "" : responseData);
            map.put("listTotal", String.valueOf($response.getTotal() == null ? "" : $response.getTotal()));
            map.put("levelList", FundGroupConverter.getLevelList());//评级
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            logger.error("组合产品查询列表异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("组合产品查询列表异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 查询组合产品详情
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData queryGroupProductById(FundGroupListQueryRequest request) {
        ResponseNewData data = new ResponseNewData();
        FundGroupListVo fundGroupListVo = null;
        try {
            QueryProductGroupByIdRequest $request = new QueryProductGroupByIdRequest();
            if (StringUtils.isBlank(request.getId())) {
                throw new BizException(BossBizCode.ParamNull, "组合产品id" + BossBizCode.ParamNull.desc());
            }
            $request.setGroupConfigId(Long.valueOf(request.getId()));
            QueryProductGroupByIdResponse $response = fundGroupServiceClient.queryGroupProductById($request);
            if ($response != null) {
                fundGroupListVo = FundGroupConverter.convertFundGroupQyById($response);
            }
            data.setData(fundGroupListVo == null ? "" : fundGroupListVo);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            logger.error("查询组合产品详情异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("查询组合产品详情异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 新增/修改组合配置
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData updateGroupProduct(FundGroupUpdateRequest request) {
        ResponseNewData data = new ResponseNewData();
        List<UserInvestListVo> responseData = null;

        logger.info("参数id:"+request.getId());
        try {
            //修改
            if (StringUtils.isNotBlank(request.getId())){
                UpdateProductGroupRequest $request = fundGroupDoValidate.updateGroupProduct(request);
                UpdateProductGroupResponse $response = fundGroupServiceClient.updateProductGroup($request);
                data.setCode($response.getCode().code());
                data.setMsg($response.getMessage());
                //新增
            }else {
                AddProductGroup4BossRequest $request = fundGroupDoValidate.addGroupProduct(request);
                AddProductGroup4BossResponse $response = fundGroupServiceClient.addGroupProduct($request);
                data.setCode($response.getCode().code());
                data.setMsg($response.getMessage());
            }

        } catch (BaseException e) {
            logger.error("新增/修改组合配置异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("新增/修改组合配置异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }


    /**
     * 查询基金产品(模糊查询)
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData queryFundProduct(FundGroupListQueryRequest request) {
        ResponseNewData data = new ResponseNewData();
        List<QueryFundProductVo> responseData = null;
        try {
            QueryLiveProductByNameRequest $request = new QueryLiveProductByNameRequest();
            $request.setProductName(request.getName());
            QueryLiveProductByNameResponse $response = fundGroupServiceClient.queryFundProduct($request);
            if ($response != null && $response.getDatas() != null && $response.getDatas().size() > 0) {
                List<QueryLiveProductByNameVO> queryLiveProductByNameVOList = $response.getDatas();
                responseData = FundGroupConverter.convertFundProductQy(queryLiveProductByNameVOList);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("list", responseData == null ? "" : responseData);
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            logger.error("查询基金产品(模糊查询)异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("查询基金产品(模糊查询)异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 查询固收产品(模糊查询)
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData querySolidProduct(FundGroupListQueryRequest request) {
        ResponseNewData data = new ResponseNewData();
        List<QuerySolidProductVo> responseData = null;
        try {
            QueryExchangeProductByNameRequest $request = new QueryExchangeProductByNameRequest();
            $request.setProductName(request.getName());
            QueryExchangeProductByNameResponse $response = fundGroupServiceClient.querySolidProduct($request);
            if ($response != null && $response.getDatas() != null && $response.getDatas().size() > 0) {
                List<QueryExchangeProductByNameVO> queryExchangeProductByNameVOList = $response.getDatas();


                responseData = FundGroupConverter.convertSolidProductQy(queryExchangeProductByNameVOList);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("list", responseData == null ? "" : responseData);
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            logger.error("查询固收产品(模糊查询)异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("查询固收产品(模糊查询)异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }
}
