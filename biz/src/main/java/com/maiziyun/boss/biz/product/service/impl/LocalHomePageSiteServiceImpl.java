package com.maiziyun.boss.biz.product.service.impl;

import com.maiziyun.boss.biz.product.convert.HotFundConverter;
import com.maiziyun.boss.biz.product.convert.P2PLoanConverter;
import com.maiziyun.boss.biz.product.service.LocalHomePageSiteService;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.product.model.*;
import com.maiziyun.boss.facade.product.model.vo.*;
import com.maiziyun.boss.integration.product.FofListServiceClient;
import com.maiziyun.boss.integration.product.HomePageSiteClient;
import com.maiziyun.boss.integration.product.P2PLoanServiceClient;
import com.maiziyun.product.facade.model.*;
import com.maiziyun.product.facade.model.vo.*;
import com.solar.framework.core.base.BaseException;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by admin on 2017/8/29.
 */
@Service("boss.HomePageSiteService")
public class LocalHomePageSiteServiceImpl implements LocalHomePageSiteService {
    Logger logger = LoggerFactory.getLogger(LocalHomePageSiteServiceImpl.class);
    @Resource(name = "boss.HomePageSiteClient")
    private HomePageSiteClient homePageSiteClient;
    @Resource(name = "boss.fofListClient")
    private FofListServiceClient fofListServiceClient;

    @Resource(name = "boss.P2PLoanClient")
    private P2PLoanServiceClient p2PLoanServiceClient;
    //------------------------------------精选策略组合-------------------------------

    /**
     * 首页精选策略组合区域查询（可购买）
     *
     * @param request
     * @return
     */
    @Override
    public QuerySelectFofListResponse querySelectFofListCanbuy(QuerySelectFofListRequest request) {
        logger.info("接收请求{}", request);
        QuerySelectFofListResponse response = new QuerySelectFofListResponse();
        try {
            List<QueryFofListVo> fofList = new ArrayList<>();
            QueryFOFInfoEffectRequest $request = new QueryFOFInfoEffectRequest();
            $request.setAttrKind("FOFSelectionStrategy");
            QueryFOFInfoEffectResponse $response = fofListServiceClient.querySelectFofListCanbuy($request);
            if ($response != null && $response.getProductAttrRelVoList() != null) {
                List<ProductAttrRelVo> productFOFInfoVoList = $response.getProductAttrRelVoList();
                for (int i = 0; i < productFOFInfoVoList.size(); i++) {
                    if (productFOFInfoVoList.get(i) != null && productFOFInfoVoList.get(i).getProductFOFInfoVo() != null) {
                        QueryFofListVo vo = new QueryFofListVo();
                        vo.setId(String.valueOf(productFOFInfoVoList.get(i).getProductId()));//id
                        vo.setProductName(productFOFInfoVoList.get(i).getProductFOFInfoVo().getProductName());//组合名称
                        vo.setPoCode(productFOFInfoVoList.get(i).getProductFOFInfoVo().getPoCode());//组合ID
                        vo.setMerchantId(productFOFInfoVoList.get(i).getProductFOFInfoVo().getMerchantId());//盈米ID
                        //购买状态
                        if ("0".equals(productFOFInfoVoList.get(i).getStatus())) {
                            vo.setBuyStatus("下架");
                        } else {
                            if ("1".equals(productFOFInfoVoList.get(i).getProductFOFInfoVo().getCanBuy())) {
                                vo.setBuyStatus("可购买");
                            } else if ("0".equals(productFOFInfoVoList.get(i).getProductFOFInfoVo().getCanBuy())) {
                                vo.setBuyStatus("不可购买");
                            } else {
                                vo.setBuyStatus("");
                            }
                        }
                        if ("1".equals(productFOFInfoVoList.get(i).getProductFOFInfoVo().getRiskLevel())) {
                            vo.setRisk("低风险");
                        } else if ("2".equals(productFOFInfoVoList.get(i).getProductFOFInfoVo().getRiskLevel())) {
                            vo.setRisk("中风险");
                        } else if ("3".equals(productFOFInfoVoList.get(i).getProductFOFInfoVo().getRiskLevel())) {
                            vo.setRisk("高风险");
                        }
                        vo.setSort(productFOFInfoVoList.get(i).getSort()==null?"":String.valueOf(productFOFInfoVoList.get(i).getSort()));
                        fofList.add(vo);
                    }
                }
                //对fofList排序
                Collections.sort(fofList, new Comparator<QueryFofListVo>() {
                    @Override
                    public int compare(QueryFofListVo o1, QueryFofListVo o2) {
                        if (StringUtils.isBlank(o1.getSort())) {
                            return -1;
                        } else if (StringUtils.isBlank(o2.getSort())) {
                            return 1;
                        } else {
                            return Integer.valueOf(o1.getSort()) > Integer.valueOf(o2.getSort()) ? 1 : -1;
                        }
                    }
                });
                response.setList(fofList);
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            } else {
                response.setList(null);
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            }
        } catch (BaseException e) {
            logger.error(" 首页精选策略组合区域查询（可购买）异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error(" 首页精选策略组合区域查询（可购买）异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 首页精选策略组合区域查询（不可购买）
     *
     * @param request
     * @return
     */
    @Override
    public QuerySelectFofListResponse querySelectFofList(QuerySelectFofListRequest request) {
        logger.info("接收请求{}", request);
        QuerySelectFofListResponse response = new QuerySelectFofListResponse();
        try {
            if (StringUtils.isBlank(request.getPageNo())) {
                throw new BizException(BizCode.ParamNull, "pageNo" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getPageSize())) {
                throw new BizException(BizCode.ParamNull, "pageSize" + BizCode.ParamNull.desc());
            }
            QueryBuyFOFInfoPageRequest $request = new QueryBuyFOFInfoPageRequest();
            $request.setPageNo(Integer.valueOf(request.getPageNo()));
            $request.setPageSize(Integer.valueOf(request.getPageSize()));
            List<QueryFofListVo> fofList = new ArrayList<>();
            QueryBuyFOFInfoPageResponse $response = fofListServiceClient.querySelectFofList($request);
            if ($response != null && $response.getDatas() != null) {
                List<ProductFOFInfoVo> productFOFInfoVoList = $response.getDatas();
                for (int i = 0; i < productFOFInfoVoList.size(); i++) {
                    if (productFOFInfoVoList.get(i) != null) {
                        QueryFofListVo vo = new QueryFofListVo();
                        vo.setId(String.valueOf(productFOFInfoVoList.get(i).getProductId()));//id
                        vo.setProductName(productFOFInfoVoList.get(i).getProductName() == null ? "" : productFOFInfoVoList.get(i).getProductName());//组合名称
                        vo.setPoCode(productFOFInfoVoList.get(i).getPoCode() == null ? "" : productFOFInfoVoList.get(i).getPoCode());//组合ID
                        vo.setMerchantId(productFOFInfoVoList.get(i).getMerchantId() == null ? "" : productFOFInfoVoList.get(i).getMerchantId());//盈米ID
                        //购买状态
                        if ("0".equals(productFOFInfoVoList.get(i).getStatus())) {
                            vo.setBuyStatus("下架");
                        } else {
                            if ("1".equals(productFOFInfoVoList.get(i).getCanBuy())) {
                                vo.setBuyStatus("可购买");
                            } else if ("0".equals(productFOFInfoVoList.get(i).getCanBuy())) {
                                vo.setBuyStatus("不可购买");
                            } else {
                                vo.setBuyStatus("");
                            }
                        }
                        if ("1".equals(productFOFInfoVoList.get(i).getRiskLevel())) {
                            vo.setRisk("低风险");
                        } else if ("2".equals(productFOFInfoVoList.get(i).getRiskLevel())) {
                            vo.setRisk("中风险");
                        } else if ("3".equals(productFOFInfoVoList.get(i).getRiskLevel())) {
                            vo.setRisk("高风险");
                        }
                        fofList.add(vo);
                    }
                }
                response.setList(fofList);
                response.setPageCount(String.valueOf($response.getTotal()));
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            } else {
                response.setList(null);
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            }

        } catch (BaseException e) {
            logger.error("首页精选策略组合区域查询（不可购买）", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("首页精选策略组合区域查询（不可购买）", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 首页精选策略组合区域修改
     *
     * @param request
     * @return
     */
    @Override
    public UpdateSelectFofListResponse updateSelectFofList(UpdateSelectFofListRequest request) {
        logger.info("接收请求{}", request);
        UpdateSelectFofListResponse response = new UpdateSelectFofListResponse();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamNull, "request" + BizCode.ParamNull.desc());
            }
            UpdateFOFInfoEffectRequest $request = new UpdateFOFInfoEffectRequest();
            $request.setAttrKind("FOFSelectionStrategy");
            $request.setProductList(request.getSortList());
            UpdateFOFInfoEffectResponse $response = fofListServiceClient.updateSelectFofList($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());

        } catch (BaseException e) {
            logger.error("首页精选策略组合区域修改异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("首页精选策略组合区域修改异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }
//---------------------------------------优选网贷--------------------------------------

    /**
     * 优选网贷查询
     *
     * @param request
     * @return
     */
    @Override
    public QueryFirP2PLoanResponse queryLoanList(QueryP2PLoanRequest request) {
        logger.info("接收请求{}", request);
        QueryFirP2PLoanResponse response = new QueryFirP2PLoanResponse();
        try {
            QueryBuyP2PInfoSortRequest $request = new QueryBuyP2PInfoSortRequest();

            QueryBuyP2PInfoSortResponse $response = p2PLoanServiceClient.queryLoanList($request);
            if ($response != null && $response.getProductP2PInfoSortVos() != null && $response.getProductP2PInfoSortVos().size() > 0) {
                List<ProductP2PInfoSortVo> productP2PInfoSortVoList = $response.getProductP2PInfoSortVos();
                List<FirP2PLoanListVo> firP2PLoanListVoList = P2PLoanConverter.convertQyFir(productP2PInfoSortVoList);
                response.setData(firP2PLoanListVoList);
            } else {
                response.setData(null);
            }
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("首页优选网贷查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("首页优选网贷查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 查询位置
     */
    @Override
    public QueryLoanSiteResponse queryLoanSite(QueryLoanSiteRequest request) {
        logger.info("接收请求{}", request);
        QueryLoanSiteResponse response = new QueryLoanSiteResponse();
        try {

            QueryP2PInfoConfigRequest $request = new QueryP2PInfoConfigRequest();
            QueryP2PInfoConfigResponse $response = p2PLoanServiceClient.queryLoanSite($request);
            boolean f = $response != null;
            if ($response != null && $response.getProductP2PInfoConfigVos() != null && $response.getProductP2PInfoConfigVos().size() > 0) {
                List<ProductP2PInfoConfigVo> productP2PInfoConfigVoList = $response.getProductP2PInfoConfigVos();

                List<P2PLoanListVo> p2PLoanListVoList = P2PLoanConverter.convertQyResp(productP2PInfoConfigVoList);
                response.setDeadLineList(p2PLoanListVoList);
            } else {
                response.setDeadLineList(null);
            }
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());

        } catch (BaseException e) {
            logger.error("首页网贷位置查询异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("首页网贷位置查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }


    /**
     * 修改位置调整
     *
     * @param request
     * @return
     */
    @Override
    public UpdateLoanSiteResponse updateLoanSite(UpdateLoanSiteRequest request) {
        logger.info("接收请求{}", request);
        UpdateLoanSiteResponse response = new UpdateLoanSiteResponse();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamNull, "request" + BizCode.ParamNull.desc());
            }
            UpdateBuyP2PInfoSortRequest $request = new UpdateBuyP2PInfoSortRequest();
            $request.setExpectList(request.getExpectList());
            UpdateBuyP2PInfoSortResponse $response = p2PLoanServiceClient.updateLoanSite($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("首页网贷位置修改异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("首页网贷位置修改异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }


//----------------------------------精选基金--------------------------------------------------

    /**
     * 首页精选基金未分页查询
     *
     * @param request
     * @return
     */
    @Override
    public SelectFundListResponse querySelectFund(SelectFundListRequest request) {
        logger.info("接收请求{}", request);
        SelectFundListResponse response = new SelectFundListResponse();
        try {
            QueryWellChosenFundNavInfoAttrValRequest $request = new QueryWellChosenFundNavInfoAttrValRequest();
            $request.setAttrKind("Recommend"); //标题类型
            QueryWellChosenFundNavInfoAttrValResponse $response = homePageSiteClient.querySelectFund($request);
            if ($response != null && $response.getProductAttrRelVoList() != null && $response.getProductAttrRelVoList().size() != 0) {
                List<ProductAttrRelVo> productAttrRelVoList = $response.getProductAttrRelVoList();
                List<HotFundVo> list = HotFundConverter.reConvertFirst(productAttrRelVoList);
                //排序
                Collections.sort(list, new Comparator<HotFundVo>() {
                    @Override
                    public int compare(HotFundVo o1, HotFundVo o2) {
                        if (o1.getSort() == null) {
                            return -1;
                        } else if (o2.getSort() == null) {
                            return 1;
                        } else {
                            return o1.getSort() > o2.getSort() ? 1 : -1;
                        }
                    }
                });
                response.setDatas(list);
            } else {
                response.setDatas(null);
            }
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("首页精选基金未分页查询异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("首页精选基金未分页查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 首页精选基金分页查询
     *
     * @param request
     * @return
     */
    @Override
    public SelectFundListResponse querySelectFundAll(SelectFundListRequest request) {
        logger.info("接收请求{}", request);
        SelectFundListResponse response = new SelectFundListResponse();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamNull, "request" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getPageNo())) {
                throw new BizException(BizCode.ParamNull, "pageNo" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getPageSize())) {
                throw new BizException(BizCode.ParamNull, "pageSize" + BizCode.ParamNull.desc());
            }
        /*    if (StringUtils.isBlank(request.getType())) {
                throw new BizException(BizCode.ParamNull, "type" + BizCode.ParamNull.desc());
            }*/
            QueryWellChosenFundNavInfoPageRequest $request = new QueryWellChosenFundNavInfoPageRequest();
            $request.setPageNo(Integer.valueOf(request.getPageNo()));
            $request.setPageSize(Integer.valueOf(request.getPageSize()));
            $request.setAttrKind("Recommend"); //标题类型
            $request.setFundType(request.getFundType()); //基金类型
            $request.setFundCode(request.getCode());//基金代码
            $request.setProductName(request.getName()); //基金名称
            QueryWellChosenFundNavInfoPageResponse $response = homePageSiteClient.querySelectFundAll($request);
            if ($response != null && $response.getDatas() != null && $response.getDatas().size() != 0) {
                List<HotFundVo> list = HotFundConverter.reConvert0($response.getDatas());
                response.setDatas(list);
                response.setTotal($response.getTotal());
            } else {
                response.setDatas(null);
                response.setTotal(null);
            }
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("首页精选基金分页查询异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("首页精选基金分页查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 首页精选基金修改
     *
     * @param request
     * @return
     */
    @Override
    public UpdateSelectFundResponse updateSelectFund(UpdateSelectFundRequest request) {
        logger.info("接收请求{}", request);
        UpdateSelectFundResponse response = new UpdateSelectFundResponse();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamNull, "request" + BizCode.ParamNull.desc());
            }
            List<SelectFundVo> selectFundList = request.getSelectFundList();
            if (selectFundList != null && selectFundList.size() > 0) {
                for (int i = 0; i < selectFundList.size(); i++) {
                    if (selectFundList.get(i).getLabels() == null || selectFundList.get(i).getLabels().size() == 0) {
                        throw new BizException(BossBizCode.LaLengthEqlNull, BossBizCode.LaLengthEqlNull.desc()); //至少设置一个标签
                    }
                    if (selectFundList.get(i).getLabels().size() > 3) {
                        throw new BizException(BossBizCode.LaLengthMore3, BossBizCode.LaLengthMore3.desc());//至多设置3个标签
                    }
                    for (int j = 0; j < selectFundList.get(i).getLabels().size(); j++) {
                        String lable1 = selectFundList.get(i).getLabels().get(j);
                        if (StringUtils.isNotBlank(lable1) && (lable1.length() < 2 || lable1.length() > 5)) {
                            throw new BizException(BossBizCode.LaLengthMore25, BossBizCode.LaLengthMore25.desc()); //每个标签至多五个汉字，至少两个汉字
                        }
                    }
                }
            } else {
                throw new BizException(BizCode.ParamNull, "request" + BizCode.ParamNull.desc());
            }

            UpdateWellChosenAttrKindRelRequest $request = new UpdateWellChosenAttrKindRelRequest();
            List<ProductAttrInfoVo> productAttrInfoVoList = new ArrayList<>();
            for (SelectFundVo selectFundVo : selectFundList) {
                ProductAttrInfoVo vo = new ProductAttrInfoVo();
                vo.setProductId(Long.valueOf(selectFundVo.getId()));
                vo.setDescValue(selectFundVo.getDesc());
                List<String> list = selectFundVo.getLabels();
                StringBuffer stringBuffer = new StringBuffer();
                boolean flag = false;
                for (int i = 0; i < list.size(); i++) {
                    if (StringUtils.isNotBlank(list.get(i))) {
                        if (flag) {
                            stringBuffer.append("|");
                        }
                        stringBuffer.append(list.get(i));
                        flag = true;
                    }
                }
                vo.setValue(stringBuffer.toString());
                productAttrInfoVoList.add(vo);
            }
            $request.setProductAttrInfoVoList(productAttrInfoVoList);
            $request.setAttrKind("Recommend");

            UpdateWellChosenAttrKindRelResponse $response = homePageSiteClient.updateSelectFund($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("首页精选基金修改异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("首页精选基金修改异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }
}
