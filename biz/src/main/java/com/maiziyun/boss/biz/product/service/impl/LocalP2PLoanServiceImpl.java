package com.maiziyun.boss.biz.product.service.impl;

import com.maiziyun.boss.biz.product.convert.P2PLoanConverter;
import com.maiziyun.boss.biz.product.service.LocalP2PLoanService;
import com.maiziyun.boss.common.utils.BzStringUtils;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.product.model.*;
import com.maiziyun.boss.facade.product.model.vo.FirP2PLoanListVo;
import com.maiziyun.boss.facade.product.model.vo.P2PLoanDetailVo;
import com.maiziyun.boss.facade.product.model.vo.P2PLoanListVo;
import com.maiziyun.boss.integration.product.P2PLoanServiceClient;
import com.maiziyun.boss.integration.product.impl.P2PLoanServiceClientImpl;
import com.maiziyun.product.facade.model.*;
import com.maiziyun.product.facade.model.vo.ProductAttrInfoVo;
import com.maiziyun.product.facade.model.vo.ProductP2PInfoConfigVo;
import com.maiziyun.product.facade.model.vo.ProductP2PInfoVo;
import com.solar.framework.core.base.BaseException;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Update;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2017/8/31.
 */
@Service("boss.P2PLoanService")
public class LocalP2PLoanServiceImpl implements LocalP2PLoanService {
    @Resource(name = "boss.P2PLoanClient")
    private P2PLoanServiceClient p2PLoanServiceClient;

    private static final Logger logger = LoggerFactory.getLogger(LocalP2PLoanService.class);

    /**
     * 网贷列表管理查询
     *
     * @param request
     * @return
     */
    @Override
    public QueryP2PLoanResponse queryLoanList(QueryP2PLoanRequest request) {
        logger.info("接收请求{}", request);
        QueryP2PLoanResponse response = new QueryP2PLoanResponse();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamNull, "request" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getPageNo())) {
                throw new BizException(BizCode.ParamNull, "当前页号" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getPageSize())) {
                throw new BizException(BizCode.ParamNull, "页面大小" + BizCode.ParamNull.desc());
            }
            QueryP2PInfoByExpectPageRequest $request = new QueryP2PInfoByExpectPageRequest();
            $request.setEcpect(request.getDeadline());
            $request.setPageNo(Integer.valueOf(request.getPageNo()));
            $request.setPageSize(Integer.valueOf(request.getPageSize()));

            QueryP2PInfoByExpectPageResponse $response = p2PLoanServiceClient.queryLoanList($request);

            QueryP2PInfoConfigTypeRequest $$request = new QueryP2PInfoConfigTypeRequest();
            if ($response != null && $response.getDatas() != null && $response.getDatas().size() > 0) {
                List<ProductP2PInfoVo> productP2PInfoVoList = $response.getDatas();
                List<P2PLoanListVo> p2PLoanListVoList = P2PLoanConverter.convertQy(productP2PInfoVoList);
                response.setData(p2PLoanListVoList);
                response.setListTotal(String.valueOf($response.getTotal()));
            } else {
                response.setData(null);
                response.setListTotal(null);
            }
            //产品期限
            QueryP2PInfoConfigTypeResponse $$response = p2PLoanServiceClient.queryLoanListExpect($$request);
            if ($$response != null && $$response.getProductP2PInfoConfigVoList() != null && $$response.getProductP2PInfoConfigVoList().size() > 0) {
                List<ProductP2PInfoConfigVo> productP2PInfoConfigVoList = $$response.getProductP2PInfoConfigVoList();
                List<P2PLoanListVo> p2PLoanListVos = P2PLoanConverter.convertQyExpect(productP2PInfoConfigVoList);
                response.setDeadLineList(p2PLoanListVos);
            } else {
                response.setDeadLineList(null);
            }
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("网贷列表管理查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("网贷列表管理查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 查询详情
     *
     * @param request
     * @return
     */
    @Override
    public QueryP2PLoanDetailResponse queryLoanById(QueryP2PLoanDetailRequest request) {
        logger.info("接收请求{}", request);
        QueryP2PLoanDetailResponse response = new QueryP2PLoanDetailResponse();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamNull, "request" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getProductId())) {
                throw new BizException(BizCode.ParamNull, "productId" + BizCode.ParamNull.desc());
            }
            QueryProductP2PInfoByProductIdRequest $request = new QueryProductP2PInfoByProductIdRequest();
            $request.setProductId(Long.valueOf(request.getProductId()));
            QueryProductP2PInfoByProductIdResponse $response = p2PLoanServiceClient.queryLoanById($request);
            ProductP2PInfoVo productP2PInfoVo = $response.getProductP2PInfoVo();
            P2PLoanDetailVo vo = new P2PLoanDetailVo();
            if (productP2PInfoVo != null && productP2PInfoVo.getProductAttrInfoVos() != null && productP2PInfoVo.getProductAttrInfoVos().size() > 0) {
                vo.setStatus(productP2PInfoVo.getP2pStatus()); //上下线状态0-下线；1-上线
                List<ProductAttrInfoVo> productAttrInfoVoList = productP2PInfoVo.getProductAttrInfoVos();
                if (productAttrInfoVoList != null && productAttrInfoVoList.size() > 0) {
                    for (ProductAttrInfoVo productAttrInfoVo : productAttrInfoVoList) {
                        if ("Wheat".equals(productAttrInfoVo.getAttr())) {
                            String wheatTag = productAttrInfoVo.getTagStatus();
                            if (StringUtils.isNotBlank(wheatTag)) {
                                vo.setWheatValue(wheatTag); //赠送麦子0-关闭；1-开启
                            } else {
                                vo.setWheatValue("");
                            }
                        }
                    }
                } else {
                    vo.setWheatValue("");
                }
            } else {
//                throw new BizException(BossBizCode.dataIsNull, "data" + BossBizCode.dataIsNull.desc());
//                response.setData(null);
                logger.info("wheatValue,status"+vo);
                vo.setStatus("");
                vo.setWheatValue("");
            }
            logger.info("vo:"+vo);
            response.setData(vo);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("网贷列表管理查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("网贷列表管理查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 详情修改确定按钮
     *
     * @param request
     * @return
     */
    @Override
    public UpdateP2PLoanResponse updateP2PLoan(UpdateP2PLoanRequest request) {
        logger.info("接收请求{}", request);
        UpdateP2PLoanResponse response = new UpdateP2PLoanResponse();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamNull, "request" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getProductId())) {
                throw new BizException(BizCode.ParamNull, "产品ID" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getStatus())) {
                throw new BizException(BizCode.ParamNull, "上下线状态" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getWheatValue())) {
                throw new BizException(BizCode.ParamNull, "赠送麦子" + BizCode.ParamNull.desc());
            }
            UpdateP2PInfoByProductIdAndAttrRequest $request = new UpdateP2PInfoByProductIdAndAttrRequest();
            $request.setProductId(Long.valueOf(request.getProductId()));
            $request.setStatus(request.getStatus());  //上下线状态
            $request.setWheatKey("Wheat");  //赠送麦子
            $request.setWheatValue(request.getWheatValue()); //赠送麦子
            UpdateP2PInfoByProductIdAndAttrResponse $response = p2PLoanServiceClient.updateP2PLoan($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("网贷列表管理查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("网贷列表管理查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }
}
