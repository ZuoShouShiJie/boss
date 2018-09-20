package com.maiziyun.boss.biz.jysmng.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.maiziyun.boss.biz.common.CommonUtils;
import com.maiziyun.boss.biz.jysmng.convert.JYSMngConverter;
import com.maiziyun.boss.biz.jysmng.service.LocalJYSMngService;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.common.model.OperatorRequest;
import com.maiziyun.boss.facade.common.model.OperatorResponse;
import com.maiziyun.boss.facade.common.model.ResponseNewData;
import com.maiziyun.boss.facade.common.model.service.LocalOperatorService;
import com.maiziyun.boss.facade.common.model.vo.StateVo;
import com.maiziyun.boss.facade.jysmng.model.*;
import com.maiziyun.boss.facade.jysmng.model.vo.*;
import com.maiziyun.boss.integration.jysmng.JYSMngServiceClient;
import com.maiziyun.cif.facade.model.QueryCustomRequest;
import com.maiziyun.cif.facade.model.QueryCustomResponse;
import com.maiziyun.cif.facade.model.QueryUserListRequest;
import com.maiziyun.cif.facade.model.QueryUserListResponse;
import com.maiziyun.cif.facade.model.vo.CustomerVo;
import com.maiziyun.cif.facade.model.vo.UserInfoVo;
import com.maiziyun.fmgw.facade.j2p.acct.J2PGetFundFlowRequest;
import com.maiziyun.fmgw.facade.j2p.acct.J2PGetFundFlowResponse;
import com.maiziyun.fmgw.facade.j2p.acct.vo.PageInfo;
import com.maiziyun.fund.trade.facade.model.fixed.QueryFixedProductInvestmentRecordListRequest;
import com.maiziyun.fund.trade.facade.model.fixed.QueryFixedProductInvestmentRecordListResponse;
import com.maiziyun.fund.trade.facade.model.vo.FixedProductAssetInfo;
import com.maiziyun.mgw.facade.model.MgwResult;
import com.maiziyun.product.facade.ExchangeSelectedService;
import com.maiziyun.product.facade.model.*;
import com.maiziyun.product.facade.model.vo.QueryExchangeProductVO;
import com.maiziyun.product.facade.model.vo.QueryExchangeProjectByConditionVO;
import com.maiziyun.product.facade.model.vo.QueryExchangeProjectByExchangeVO;
import com.solar.framework.core.base.BaseException;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.exception.BizException;
import com.solar.framework.core.model.Money;
import com.solar.framework.core.utils.UUIDGenerator;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by admin on 2017/11/4.
 */
@Service("boss.JYSMngService")
public class LocalJYSMngServiceImpl implements LocalJYSMngService {
    private static Logger logger = LoggerFactory.getLogger(LocalJYSMngServiceImpl.class);
    @Resource(name = "boss.JYSMngClient")
    private JYSMngServiceClient jysMngServiceClient;
    @Resource(name = "boss.OperatorService")
    private LocalOperatorService operatorService;

    /**
     * 用户投资列表查询
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData userInvestListQuery(UserInvestListQueryRequest request) {
        ResponseNewData data = new ResponseNewData();
        List<UserInvestListVo> responseData = null;
        try {
            QueryFixedProductInvestmentRecordListRequest $request = new QueryFixedProductInvestmentRecordListRequest();
            if (StringUtils.isNotBlank(request.getPageNo())) {
                $request.setPageNo(Integer.valueOf(request.getPageNo()));
            }
            if (StringUtils.isNotBlank(request.getPageSize())) {
                $request.setPageSize(Integer.valueOf(request.getPageSize()));
            }
            if (StringUtils.isNotBlank(request.getUserName())) {
                $request.setUserName(request.getUserName());
            }
            if (StringUtils.isNotBlank(request.getMobile())) {
                $request.setMobile(request.getMobile());
            }
            if (StringUtils.isNotBlank(request.getInvestStartTime())) {
                $request.setStartDate(request.getInvestStartTime());
            }
            if (StringUtils.isNotBlank(request.getInvestEndTime())) {
                $request.setEndDate(request.getInvestEndTime());
            }
            QueryFixedProductInvestmentRecordListResponse $response = jysMngServiceClient.userInvestListQuery($request);
            if ($response != null && $response.getDatas() != null && $response.getDatas().size() > 0) {
                List<FixedProductAssetInfo> fixedProductAssetInfoList = $response.getDatas();
                responseData = JYSMngConverter.convertUserInvestList(fixedProductAssetInfoList);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("list", responseData == null ? "" : responseData);
            map.put("listTotal", $response.getTotal() == null ? "" : $response.getTotal());
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            logger.error("用户投资列表查询异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("用户投资列表查询异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 第一步：查用户信息
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData queryUserMsg(FundsRecordQueryRequest request) {
        ResponseNewData data = new ResponseNewData();
        List<J2PQueryUserMsgVo> responseData = null;
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamNull, "request" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getName()) && StringUtils.isBlank(request.getMobile())) {
                throw new BizException(BizCode.ParamNull, "姓名手机号" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getPageNo())) {
                throw new BizException(BizCode.ParamNull, "pageNo" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getPageSize())) {
                throw new BizException(BizCode.ParamNull, "pageSize" + BizCode.ParamNull.desc());
            }
            QueryCustomRequest $request = new QueryCustomRequest();
            if (StringUtils.isNotBlank(request.getPageNo())) {
                $request.setPageNo(Integer.valueOf(request.getPageNo()));
            }
            if (StringUtils.isNotBlank(request.getPageSize())) {
                $request.setPageSize(Integer.valueOf(request.getPageSize()));
            }
            $request.setUserName(request.getName());
            $request.setMobile(request.getMobile());
            QueryCustomResponse $response = jysMngServiceClient.queryUserMsg($request);
            if ($response != null && $response.getDatas() != null) {
                List<CustomerVo> customerVoList = $response.getDatas();
                responseData = JYSMngConverter.convertUserQy(customerVoList);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("list", responseData == null ? "" : responseData);
            map.put("listTotal", $response.getTotal() == null ? "" : String.valueOf($response.getTotal()));
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            logger.error("交易所查用户信息查询异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("交易所查用户信息查询异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 资金记录 第二步：查资金记录
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData fundsRecordQuery(FundsRecordQueryRequest request) {
        ResponseNewData data = new ResponseNewData();
        List<J2PGetFundFlowVo> j2PGetFundFlowVoList = null;
        J2PGetFundFlowResponse response = new J2PGetFundFlowResponse();
        try {
            if (StringUtils.isBlank(request.getId())) {
                throw new BizException(BizCode.ParamNull, "用户id" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getName())) {
                throw new BizException(BizCode.ParamNull, "用户名" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getPageNo())) {
                throw new BizException(BizCode.ParamNull, "pageNo" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getPageSize())) {
                throw new BizException(BizCode.ParamNull, "pageSize" + BizCode.ParamNull.desc());
            }
            J2PGetFundFlowRequest $request = new J2PGetFundFlowRequest();
            $request.setChannelSystemId("JIAOYISUO8400");
            $request.setExchangeTypeId("7107");
            $request.setOrderNo(UUIDGenerator.nextValue());
//            request.setOutUserNo("00120170822162319000000000002588");
            $request.setOutUserNo(request.getId());
            PageInfo vo = new PageInfo();
            vo.setCurrPageNo(Integer.valueOf(request.getPageNo()));
            vo.setPageSize(Integer.valueOf(request.getPageSize()));
            $request.setPageInfo(vo);
            MgwResult mgwResult = jysMngServiceClient.getFundFlow($request);
            if (mgwResult != null) {
                response = (J2PGetFundFlowResponse) mgwResult.getResult();
                if (response != null && response.getAccFundFlowResult() != null) {
                    List<J2PMgwGetFundFlowVo> list = JSONArray.parseArray(response.getAccFundFlowResult(), J2PMgwGetFundFlowVo.class);
                    if (list != null && list.size() > 0) {
                        j2PGetFundFlowVoList = JYSMngConverter.convertFund(list, request.getName());
                        Set<String> set = new HashSet<>();
                        for (J2PGetFundFlowVo j2PGetFundFlowVo : j2PGetFundFlowVoList) {
                            if (StringUtils.isNotBlank(j2PGetFundFlowVo.getOppositeName())) {
                                set.add(j2PGetFundFlowVo.getOppositeName());
                            }
                        }
                        if (set != null && set.size() > 0) {
                            List<String> list1 = new ArrayList<>(set);
                            QueryUserListRequest $request1 = new QueryUserListRequest();
                            $request1.setIds(list1);
                            QueryUserListResponse $response = jysMngServiceClient.fundsRecordQuery($request1);
                            if ($response != null && $response.getUserList() != null) {
                                List<UserInfoVo> userInfoVoList = $response.getUserList();
                                for (UserInfoVo vo1 : userInfoVoList) {
                                    String a = vo1.getUserId();
                                    for (J2PGetFundFlowVo vo2 : j2PGetFundFlowVoList) {
                                        if (a.equals(vo2.getOppositeName())) {
                                            vo2.setOppositeName(vo1.getUserName() == null ? vo1.getLoginName() : vo1.getUserName());
                                            if (vo2.getOppositeName() == null) {
                                                vo2.setOppositeName("");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Map<String, Object> map = new HashMap<>();
            map.put("list", j2PGetFundFlowVoList == null ? "" : j2PGetFundFlowVoList);
            map.put("listTotal", response.getRecordCount());
            data.setData(map);
            if ("0000000".equals(response.getBankResultCode())) {
                data.setCode(BizCode.Success.code());
                data.setMsg(BizCode.Success.desc());
            } else {
                data.setCode(response.getBankResultCode());
                data.setMsg(response.getBankResultDesc());
            }
        } catch (BaseException e) {
            logger.error("资金记录异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("资金记录异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 交易所项目配置查询，查询产品详情
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData projectConfQuery(ProjectConfQueryRequest request) {
        ResponseNewData data = new ResponseNewData();
        List<ProjectConfQueryVo> responseData = new ArrayList<>();
        List<StateVo> stateVos = new ArrayList<>();
        List<StateVo> stateVosPub = new ArrayList<>();
        List<StateVo> stateVosPro = new ArrayList<>(); //协议类型查询列表
        try {
            //查询全部
            QueryExchangeProjectByConditionRequest $request = new QueryExchangeProjectByConditionRequest();
            if (StringUtils.isNotBlank(request.getProjectId())) {
                $request.setProjectId(Long.valueOf(request.getProjectId()));
            }
            $request.setExchangeName(request.getName());
            $request.setStatus(request.getStatus());
            if (StringUtils.isNotBlank(request.getPageNo())) {
                $request.setPageNo(Integer.valueOf(request.getPageNo()));
            }
            if (StringUtils.isNotBlank(request.getPageSize())) {
                $request.setPageSize(Integer.valueOf(request.getPageSize()));
            }
            QueryExchangeProjectByConditionResponse $response = jysMngServiceClient.projectConfQuery($request);
            if ($response != null && $response.getDatas() != null && $response.getDatas().size() > 0) {
                List<QueryExchangeProjectByConditionVO> $responseData = $response.getDatas();
                responseData = JYSMngConverter.convertQryProject($responseData);
            }

            //全部交易所
            QueryAllExchangeRequest $requestEx = new QueryAllExchangeRequest();
            QueryAllExchangeResponse $responseEx = jysMngServiceClient.queryAllExchange($requestEx);
            if ($responseEx != null && $responseEx.getDatas() != null && $responseEx.getDatas().size() > 0) {
                stateVos = JYSMngConverter.convertQryEx($responseEx.getDatas());
            }
            //全部发行人
            QueryExchangePublisherInfoRequest $requestPub = new QueryExchangePublisherInfoRequest();
            QueryExchangePublisherInfoResponse $responsePub = jysMngServiceClient.queryAllExchangePublisher($requestPub);
            if ($responsePub != null && $responsePub.getDatas() != null && $responsePub.getDatas().size() > 0) {
                stateVosPub = JYSMngConverter.convertQryPub($responsePub.getDatas());
            }

            //协议类型查询列表
            QueryProjectContractTypeRequest $requestProto = new QueryProjectContractTypeRequest();
            QueryProjectContractTypeResponse $responseProto = jysMngServiceClient.queryProjectProtocolList($requestProto);
            if ($responseProto != null && $responseProto.getDatas() != null && $responseProto.getDatas().size() > 0) {
                stateVosPro = JYSMngConverter.convertQryPro($responseProto.getDatas());
            }

            Map<String, Object> map = new HashMap<>();
            map.put("list", responseData == null ? "" : responseData);
            map.put("exchangeList", stateVos == null ? "" : stateVos); //交易所名称list
            map.put("repayTypeList", JYSMngConverter.repayTypeList()); //还款方式list
            map.put("releasemanList", stateVosPub == null ? "" : stateVosPub); //发行人list
            map.put("deadlineList", JYSMngConverter.deadlineList());//期限list
            map.put("interestUnitList", JYSMngConverter.interestUnitList()); //计息单位list
            map.put("protocolList", stateVosPro == null ? "" : stateVosPro);//协议类型查询列表
            map.put("listTotal", $response.getTotal()==null?"":$response.getTotal());

            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());

        } catch (BaseException e) {
            logger.error("交易所项目配置查询异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("交易所项目配置查询异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 交易所项目配置新增/修改
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData projectConfUpdate(ProjectConfUpdateRequest request) {
        ResponseNewData data = new ResponseNewData();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamNull, "request" + BizCode.ParamNull.desc());
            }
           /* if (StringUtils.isBlank(request.getExchangeId())) {
                throw new BizException(BizCode.ParamNull, "交易所id" + BizCode.ParamNull.desc());
            }*/
            if (StringUtils.isBlank(request.getProjectName())) {
                throw new BizException(BizCode.ParamNull, "项目名称" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getProductCycle())) {
                throw new BizException(BizCode.ParamNull, "产品周期" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getRepayTypeId())) {
                throw new BizException(BizCode.ParamNull, "还款方式" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getReleasemanId())) {
                throw new BizException(BizCode.ParamNull, "发行人" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getDeadlineTypeId())) {
                throw new BizException(BizCode.ParamNull, "期限" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getInterestUnitId())) {
                throw new BizException(BizCode.ParamNull, "计息单位" + BizCode.ParamNull.desc());
            }
          /*  if (StringUtils.isBlank(request.getReceiveAccount())) {
                throw new BizException(BizCode.ParamNull, "关联收款账户" + BizCode.ParamNull.desc());
            }*/
            if (StringUtils.isBlank(request.getStatusId())) {
                throw new BizException(BizCode.ParamNull, "状态" + BizCode.ParamNull.desc());
            }

            //新增
            if (StringUtils.isBlank(request.getExchangeProjectId())) {
                logger.info("项目新增接收请求{}", request);
                AddExchangeProjectRequest $request = new AddExchangeProjectRequest();
                if (StringUtils.isNotBlank(request.getExchangeId())) {
                    $request.setExchangeCode(Long.valueOf(request.getExchangeId())); //交易所名称
                }
                $request.setProjectName(request.getProjectName());// 项目名称
                $request.setProductCycle(Integer.valueOf(request.getProductCycle()));
                $request.setAnnualRate(request.getAnnualRate());
                $request.setRepayType(Integer.valueOf(request.getRepayTypeId()));
                $request.setPublisherId(Long.valueOf(request.getReleasemanId()));
                $request.setTimeLimit(Integer.valueOf(request.getDeadlineTypeId()));
                $request.setInterestAccrualUnit(String.valueOf(request.getInterestUnitId()));
                $request.setPayeeAccount(request.getReceiveAccount()); //收款账户
                if (StringUtils.isNotBlank(request.getProjectAmount())) {
                    $request.setTotalAmount(new Money(request.getProjectAmount()));
                }
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
                //项目协议
                //$request.setProjectContracts(JYSMngConverter.convertProtoAdd(request.getProtocolList()));
                AddExchangeProjectResponse $response = jysMngServiceClient.addExchangeProject($request);
                data.setCode($response.getCode().code());
                data.setMsg($response.getMessage());
                //修改
            } else {
                logger.info("项目修改接收请求{}", request);
                UpdateExchangeProjectRequest $request = new UpdateExchangeProjectRequest();
                if (StringUtils.isBlank(request.getExchangeProjectId())) {   //项目id
                    throw new BizException(BizCode.ParamNull, "项目id" + BizCode.ParamNull.desc());
                }
                $request.setProjectId(Long.valueOf(request.getExchangeProjectId()));
                if (StringUtils.isNotBlank(request.getExchangeId())) {
                    $request.setExchangeCode(Long.valueOf(request.getExchangeId())); //交易所名称
                }
                $request.setProjectName(request.getProjectName());// 项目名称
                $request.setProductCycle(Integer.valueOf(request.getProductCycle()));
                $request.setAnnualRate(request.getAnnualRate());
                $request.setRepayType(Integer.valueOf(request.getRepayTypeId()));
                $request.setPublisherId(Long.valueOf(request.getReleasemanId()));
                $request.setTimeLimit(Integer.valueOf(request.getDeadlineTypeId()));
                $request.setInterestAccrualUnit(String.valueOf(request.getInterestUnitId()));
                $request.setPayeeAccount(request.getReceiveAccount()); //收款账户
                if (StringUtils.isNotBlank(request.getProjectAmount())) {
                    $request.setTotalAmount(new Money(request.getProjectAmount()));
                }
                $request.setStatus(request.getStatusId());
                //项目协议
                //$request.setProjectContracts(JYSMngConverter.convertProtoUpdate(request.getProtocolList()));
                UpdateExchangeProjectResponse $response = jysMngServiceClient.updateExchangeProject($request);
                data.setCode($response.getCode().code());
                data.setMsg($response.getMessage());
            }
        } catch (BaseException e) {
            logger.error("交易所项目配置新增修改异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("交易所项目配置新增修改异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 理财产品配置查询,查询产品详情
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData productConfQuery(ProductConfQueryRequest request) {
        ResponseNewData data = new ResponseNewData();
        List<ProductConfQueryVo> productConfQueryVoList = new ArrayList<>();
        List<StateVo> stateVos = new ArrayList<>();
        try {
            QueryExchangeProductByConditionRequest $request = new QueryExchangeProductByConditionRequest();
            if (StringUtils.isNotBlank(request.getProductId())) {
                $request.setProductId(Long.valueOf(request.getProductId()));
            }
            $request.setExchangeProductStatus(request.getProductStatus());
            if (StringUtils.isNotBlank(request.getPageNo())) {
                $request.setPageNo(Integer.valueOf(request.getPageNo()));
            }
            if (StringUtils.isNotBlank(request.getPageSize())) {
                $request.setPageSize(Integer.valueOf(request.getPageSize()));
            }
            QueryExchangeProductByConditionResponse $response = jysMngServiceClient.productConfQuery($request);
            if ($response != null && $response.getDatas() != null && $response.getDatas().size() > 0) {
                List<QueryExchangeProductVO> queryExchangeProductVOList = $response.getDatas();
                productConfQueryVoList = JYSMngConverter.convertQryProduct(queryExchangeProductVOList);
            }
            //全部交易所
            QueryAllExchangeRequest $requestEx = new QueryAllExchangeRequest();
            QueryAllExchangeResponse $responseEx = jysMngServiceClient.queryAllExchange($requestEx);
            if ($responseEx != null && $responseEx.getDatas() != null && $responseEx.getDatas().size() > 0) {
                stateVos = JYSMngConverter.convertQryEx($responseEx.getDatas());
            }
            Map<String, Object> map = new HashMap<>();
            map.put("list", productConfQueryVoList == null ? "" : productConfQueryVoList);
            map.put("exchangeList", stateVos == null ? "" : stateVos); //交易所名称list
            map.put("repayTypeList", JYSMngConverter.repayTypeList()); //还款方式list
            map.put("isShowList", JYSMngConverter.isShowList());// 是否显示
            map.put("isSupportList", JYSMngConverter.isSupportList());//是否支持债转
            map.put("statusList", JYSMngConverter.productStatusList()); //产品状态list
            map.put("listTotal", $response.getTotal() == null ? "" : $response.getTotal());
//            public static final LimitAmountType NO_QUOTA = new LimitAmountType("1", "无限额");
//            public static final LimitAmountType EXIST_QUOTA = new LimitAmountType("2", "有限额");
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());


        } catch (BaseException e) {
            logger.error(" 理财产品配置查询异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error(" 理财产品配置查询异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 通过交易所查询项目
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData queryProjectByExchange(QueryProjectAllRequest request) {

        ResponseNewData data = new ResponseNewData();
        List<QueryProjectAllVo> queryProjectAllVoList = null;
        try {
            QueryExchangeProjectByExchangeRequest $request = new QueryExchangeProjectByExchangeRequest();
            if (StringUtils.isNotBlank(request.getExchangeId())) {
                $request.setExchangeId(Long.valueOf(request.getExchangeId()));
            } else {

            }
            QueryExchangeProjectByExchangeResponse $response = jysMngServiceClient.queryExchangeProjectByExchange($request);
            if ($response != null && $response.getProjects() != null && $response.getProjects().size() > 0) {
                List<QueryExchangeProjectByExchangeVO> queryExchangeProjectByExchangeVOList = $response.getProjects();
                queryProjectAllVoList = JYSMngConverter.convertQryProductAllBy(queryExchangeProjectByExchangeVOList);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("projectList", queryProjectAllVoList == null ? "" : queryProjectAllVoList);
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());


        } catch (BaseException e) {
            logger.error(" 理财产品配置查询异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error(" 理财产品配置查询异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 理财产品配置新增/修改
     * productConfUpdate
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData productConfUpdate(ProductConfUpdateRequest request) {
        ResponseNewData data = new ResponseNewData();
        UpdateExchangeProductResponse $updateResponse = new UpdateExchangeProductResponse();
        String status = "";
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamNull, "request" + BizCode.ParamNull.desc());
            }

            //新增
            if (StringUtils.isBlank(request.getProductId())) {
                if (StringUtils.isBlank(request.getExchangeId())) {
                    throw new BizException(BizCode.ParamNull, "交易所名称" + BizCode.ParamNull.desc());
                }
                if (StringUtils.isBlank(request.getExchangeProjectId())) {
                    throw new BizException(BizCode.ParamNull, "项目id" + BizCode.ParamNull.desc());
                }
                if (StringUtils.isBlank(request.getProductName())) {
                    throw new BizException(BizCode.ParamNull, "产品名称" + BizCode.ParamNull.desc());
                }
                if (StringUtils.isBlank(request.getPlanRaiseFund())) {
                    throw new BizException(BizCode.ParamNull, "计划募集资金" + BizCode.ParamNull.desc());
                }
                if (StringUtils.isBlank(request.getInvestAmount())) {
                    throw new BizException(BizCode.ParamNull, "起投金额" + BizCode.ParamNull.desc());
                }
                if (StringUtils.isBlank(request.getIncreaseAmount())) {
                    throw new BizException(BizCode.ParamNull, "递增金额" + BizCode.ParamNull.desc());
                }
                if (StringUtils.isBlank(request.getReleaseTime())) {
                    throw new BizException(BizCode.ParamNull, "发布时间" + BizCode.ParamNull.desc());
                }
                if (StringUtils.isBlank(request.getRaiseStartTime())) {
                    throw new BizException(BizCode.ParamNull, "募集开始时间" + BizCode.ParamNull.desc());
                }
                if (StringUtils.isBlank(request.getRaiseEndTime())) {
                    throw new BizException(BizCode.ParamNull, "募集结束时间" + BizCode.ParamNull.desc());
                }
                if (StringUtils.isBlank(request.getIsShow())) {
                    throw new BizException(BizCode.ParamNull, "是否可见" + BizCode.ParamNull.desc());
                }
                if (StringUtils.isBlank(request.getContent())) {
                    throw new BizException(BizCode.ParamNull, "产品说明文案" + BizCode.ParamNull.desc());
                }
                AddExchangeProductRequest $request = new AddExchangeProductRequest();
                $request.setExchangeCode(Long.valueOf(request.getExchangeId())); //交易所id
                $request.setProjectCode(Long.valueOf(request.getExchangeProjectId()));  //项目id
                $request.setProductName(request.getProductName());
                $request.setRaiseFund(new Money(request.getPlanRaiseFund()));
                $request.setInvestAmount(new Money(request.getInvestAmount()));
                $request.setInvreaseAmount(new Money(request.getIncreaseAmount()));
                $request.setReleaseTime(CommonUtils.parseToDate(request.getReleaseTime()));//发布时间
                $request.setRaiseStartTime(CommonUtils.parseToDate(request.getRaiseStartTime())); //募集开始时间
                $request.setRaiseEndTime(CommonUtils.parseToDate(request.getRaiseEndTime())); //募集结束时间
                $request.setIsLimitAmount(request.getIsLimitAmount());
                if (StringUtils.isNotBlank(request.getLimitAmount())) {
                    $request.setLimitAmount(new Money(request.getLimitAmount()));
                }
                $request.setRepayTypeCode(request.getRepayTypeId());  //还款方式
                $request.setShowFlag(request.getIsShow()); //显示
                $request.setIsSupportRightsTransfer(request.getIsSupportRightsTransfer());
                $request.setProductDesc(request.getContent());
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

                AddExchangeProductResponse $addResponse = jysMngServiceClient.addExchangeProduct($request);
                data.setCode($addResponse.getCode().code());
                data.setMsg($addResponse.getMessage());

                //修改
            } else {
                if (StringUtils.isBlank(request.getProductId())) {
                    throw new BizException(BizCode.ParamNull, "产品ID" + BizCode.ParamNull.desc());
                }
                QueryExchangeProductByConditionRequest $request1 = new QueryExchangeProductByConditionRequest();
                $request1.setProductId(Long.valueOf(request.getProductId()));
                $request1.setPageNo(1);
                $request1.setPageSize(10);
                QueryExchangeProductByConditionResponse $response = jysMngServiceClient.productConfQuery($request1);
                if ($response != null && $response.getDatas() != null && $response.getDatas().size() > 0) {
                    List<QueryExchangeProductVO> queryExchangeProductVOList = $response.getDatas();
                    QueryExchangeProductVO vo = queryExchangeProductVOList.get(0);
                    status = vo.getProductStatus();
                }
                if ("1".equals(request.getProductStatusId()) && !"1".equals(status)) {
                    throw new BizException(BossBizCode.ProductStatusIs, "" + BossBizCode.ProductStatusIs.desc());
                }

                //未发布
                if ("1".equals(status)) {
                   /* if (StringUtils.isBlank(request.getExchangeId())) {
                        throw new BizException(BizCode.ParamNull, "交易所名称" + BizCode.ParamNull.desc());
                    }
                    if (StringUtils.isBlank(request.getExchangeProjectId())) {
                        throw new BizException(BizCode.ParamNull, "项目id" + BizCode.ParamNull.desc());
                    }*/
                    if (StringUtils.isBlank(request.getProductName())) {
                        throw new BizException(BizCode.ParamNull, "产品名称" + BizCode.ParamNull.desc());
                    }
                    if (StringUtils.isBlank(request.getPlanRaiseFund())) {
                        throw new BizException(BizCode.ParamNull, "计划募集资金" + BizCode.ParamNull.desc());
                    }
                    if (StringUtils.isBlank(request.getInvestAmount())) {
                        throw new BizException(BizCode.ParamNull, "起投金额" + BizCode.ParamNull.desc());
                    }
                    if (StringUtils.isBlank(request.getIncreaseAmount())) {
                        throw new BizException(BizCode.ParamNull, "递增金额" + BizCode.ParamNull.desc());
                    }
                    if (StringUtils.isBlank(request.getReleaseTime())) {
                        throw new BizException(BizCode.ParamNull, "发布时间" + BizCode.ParamNull.desc());
                    }
                    if (StringUtils.isBlank(request.getRaiseStartTime())) {
                        throw new BizException(BizCode.ParamNull, "募集开始时间" + BizCode.ParamNull.desc());
                    }
                    if (StringUtils.isBlank(request.getRaiseEndTime())) {
                        throw new BizException(BizCode.ParamNull, "募集结束时间" + BizCode.ParamNull.desc());
                    }
                    if (StringUtils.isBlank(request.getIsShow())) {
                        throw new BizException(BizCode.ParamNull, "是否可见" + BizCode.ParamNull.desc());
                    }
                    if (StringUtils.isBlank(request.getContent())) {
                        throw new BizException(BizCode.ParamNull, "产品说明文案" + BizCode.ParamNull.desc());
                    }
                    if (StringUtils.isBlank(request.getProductStatusId())) {
                        throw new BizException(BizCode.ParamNull, "产品状态" + BizCode.ParamNull.desc());
                    }
                    UpdateExchangeProductRequest $request = new UpdateExchangeProductRequest();
                    $request.putExtField("status", request.getProductStatusId());
                    $request.setPruductId(Long.valueOf(request.getProductId()));
                    if (StringUtils.isNotBlank(request.getExchangeId())) {
                        $request.setExchangeCode(Long.valueOf(request.getExchangeId())); //交易所id
                    }
                    if (StringUtils.isNotBlank(request.getExchangeProjectId())) {
                        $request.setProjectCode(Long.valueOf(request.getExchangeProjectId()));  //项目id
                    }
                    $request.setProductName(request.getProductName());
                    $request.setRaiseFund(new Money(request.getPlanRaiseFund()));
                    $request.setInvestAmount(new Money(request.getInvestAmount()));
                    $request.setInvreaseAmount(new Money(request.getIncreaseAmount()));
                    //发布时间
                    $request.setReleaseTime(CommonUtils.parseToDate(request.getReleaseTime()));
                    //募集开始时间
                    $request.setRaiseStartTime(CommonUtils.parseToDate(request.getRaiseStartTime()));
                    $request.setRaiseEndTime(CommonUtils.parseToDate(request.getRaiseEndTime()));
                    $request.setIsLimitAmount(request.getIsLimitAmount());
                    if (StringUtils.isNotBlank(request.getLimitAmount())) {
                        $request.setLimitAmount(new Money(request.getLimitAmount()));
                    }
                    $request.setRepayTypeCode(request.getRepayTypeId());  //还款方式
                    $request.setShowFlag(request.getIsShow()); //显示
                    $request.setIsSupportRightsTransfer(request.getIsSupportRightsTransfer());
                    $request.setProductDesc(request.getContent());

                    $updateResponse = jysMngServiceClient.updateExchangeProduct($request);

                    //已发布
                } else {
                    if (StringUtils.isBlank(request.getIsShow())) {
                        throw new BizException(BizCode.ParamNull, "是否可见" + BizCode.ParamNull.desc());
                    }
                    UpdateExchangeProductRequest $request2 = new UpdateExchangeProductRequest();
                    $request2.setPruductId(Long.valueOf(request.getProductId()));
                    $request2.setShowFlag(request.getIsShow()); //显示
                    $request2.putExtField("status", request.getProductStatusId());//产品状态
                    $updateResponse = jysMngServiceClient.updateExchangeProduct($request2);
                }
                data.setCode($updateResponse.getCode().code());
                data.setMsg($updateResponse.getMessage());
            }

        } catch (BaseException e) {
            logger.error("理财产品配置新增/修改异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("理财产品配置新增/修改异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 已发布状态修改显示状态
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData productUpdateStatus(ProductConfUpdateRequest request) {
        ResponseNewData data = new ResponseNewData();
        UpdateExchangeProductResponse $updateResponse = new UpdateExchangeProductResponse();
        try {
            if (StringUtils.isBlank(request.getIsShow())) {
                throw new BizException(BizCode.ParamNull, "是否可见" + BizCode.ParamNull.desc());
            }
            UpdateExchangeProductRequest $request = new UpdateExchangeProductRequest();
            $request.setPruductId(Long.valueOf(request.getProductId()));
            $request.setShowFlag(request.getIsShow()); //显示
            $updateResponse = jysMngServiceClient.updateExchangeProduct($request);

        } catch (BaseException e) {
            logger.error(" 理财产品修改状态异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error(" 理财产品修改状态异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 发布
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData releaseProd(ReleaseProdRequest request) {
        ResponseNewData data = new ResponseNewData();
        try {
            UpdateExchangeProductByIdRequest $request = new UpdateExchangeProductByIdRequest();
            if (StringUtils.isBlank(request.getProductId())) {
                throw new BizException(BizCode.ParamNull, "产品ID" + BizCode.ParamNull.desc());
            }
            $request.setProductId(Long.valueOf(request.getProductId()));
            $request.setStatus(request.getProductStatus());

            UpdateExchangeProductByIdResponse $updateResponse = jysMngServiceClient.releaseProd($request);
            data.setCode($updateResponse.getCode().code());
            data.setMsg($updateResponse.getMessage());
        } catch (BaseException e) {
            logger.error("理财产品发布异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("理财产品发布异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 理财产品配置删除
     *
     * @param request
     * @return
     */
    @Override
    public ResponseNewData productConfDele(ProductConfDeleRequest request) {
        ResponseNewData data = new ResponseNewData();
        try {
            DeleteExchangeProductRequest $request = new DeleteExchangeProductRequest();
            $request.setProductId(request.getProductId());
            DeleteExchangeProductResponse $response = jysMngServiceClient.deleteExchangeProduct($request);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            logger.error("理财产品配置删除异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("理财产品配置删除异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    //------------------------------------------------------------------------------------------
    /**
     * 产品还款列表查询
     * @param request
     * @return
     */
    @Override
    public ResponseNewData productRepayQueryList(ProductRepayQueryRequest request) {
        ResponseNewData data = new ResponseNewData();
        List<QueryProjectAllVo> queryProjectAllVoList = null;
        List<StateVo> stateVos = new ArrayList<>();
        try {
            QueryExchangeProjectByExchangeRequest $request = new QueryExchangeProjectByExchangeRequest();

            QueryExchangeProjectByExchangeResponse $response = jysMngServiceClient.queryExchangeProjectByExchange($request);
            if ($response != null && $response.getProjects() != null && $response.getProjects().size() > 0) {
                List<QueryExchangeProjectByExchangeVO> queryExchangeProjectByExchangeVOList = $response.getProjects();
                queryProjectAllVoList = JYSMngConverter.convertQryProductAllBy(queryExchangeProjectByExchangeVOList);
            }
            //全部交易所
            QueryAllExchangeRequest $requestEx = new QueryAllExchangeRequest();
            QueryAllExchangeResponse $responseEx = jysMngServiceClient.queryAllExchange($requestEx);
            if ($responseEx != null && $responseEx.getDatas() != null && $responseEx.getDatas().size() > 0) {
                stateVos = JYSMngConverter.convertQryEx($responseEx.getDatas());
            }

            Map<String, Object> map = new HashMap<>();
            map.put("projectList", queryProjectAllVoList == null ? "" : queryProjectAllVoList);
            map.put("exchangeList",stateVos);
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());


        } catch (BaseException e) {
            logger.error("产品还款列表查询异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("产品还款列表查询异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 查询还款详情
     * @param request
     * @return
     */
    @Override
    public ResponseNewData productRepayQueryById(ProductRepayQueryRequest request) {
        ResponseNewData data = new ResponseNewData();
        List<QueryProjectAllVo> queryProjectAllVoList = null;
        List<StateVo> stateVos = new ArrayList<>();
        try {
            QueryExchangeProjectByExchangeRequest $request = new QueryExchangeProjectByExchangeRequest();

            QueryExchangeProjectByExchangeResponse $response = jysMngServiceClient.queryExchangeProjectByExchange($request);
            if ($response != null && $response.getProjects() != null && $response.getProjects().size() > 0) {
                List<QueryExchangeProjectByExchangeVO> queryExchangeProjectByExchangeVOList = $response.getProjects();
                queryProjectAllVoList = JYSMngConverter.convertQryProductAllBy(queryExchangeProjectByExchangeVOList);
            }

            Map<String, Object> map = new HashMap<>();
            map.put("projectList", queryProjectAllVoList == null ? "" : queryProjectAllVoList);
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());

        } catch (BaseException e) {
            logger.error("查询还款详情异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("查询还款详情异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    /**
     * 点击还款进行还款
     * @param request
     * @return
     */
    @Override
    public ResponseNewData productRepay(ProductRepayQueryRequest request) {
        ResponseNewData data = new ResponseNewData();
        List<QueryProjectAllVo> queryProjectAllVoList = null;
        List<StateVo> stateVos = new ArrayList<>();
        try {
            QueryExchangeProjectByExchangeRequest $request = new QueryExchangeProjectByExchangeRequest();

            QueryExchangeProjectByExchangeResponse $response = jysMngServiceClient.queryExchangeProjectByExchange($request);
            if ($response != null && $response.getProjects() != null && $response.getProjects().size() > 0) {
                List<QueryExchangeProjectByExchangeVO> queryExchangeProjectByExchangeVOList = $response.getProjects();
                queryProjectAllVoList = JYSMngConverter.convertQryProductAllBy(queryExchangeProjectByExchangeVOList);
            }

            Map<String, Object> map = new HashMap<>();
            map.put("projectList", queryProjectAllVoList == null ? "" : queryProjectAllVoList);
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());

        } catch (BaseException e) {
            logger.error("查询还款详情异常 ", e);
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
        } catch (Exception e) {
            logger.error("查询还款详情异常", e);
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
        }
        logger.info("返回结果{}", data);
        return data;
    }

    @Override
    public ResponseNewData productRepayLoad(ProductRepayQueryRequest request) {
        return null;
    }

    @Override
    public ResponseNewData productRepayUserList(ProductRepayQueryRequest request) {
        return null;
    }
}
