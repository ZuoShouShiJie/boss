package com.maiziyun.boss.biz.product.service.impl;

import com.maiziyun.boss.biz.product.convert.FofListSiteConverter;
import com.maiziyun.boss.biz.product.service.LocalFofListService;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.product.model.*;
import com.maiziyun.boss.facade.product.model.vo.QueryFofDetailVo;
import com.maiziyun.boss.facade.product.model.vo.QueryFofListVo;
import com.maiziyun.boss.facade.product.model.vo.QueryFofSiteListVo;
import com.maiziyun.boss.integration.product.FofListServiceClient;
import com.maiziyun.product.facade.model.*;
import com.maiziyun.product.facade.model.vo.ProductAttrInfoVo;
import com.maiziyun.product.facade.model.vo.ProductFOFInfoVo;
import com.maiziyun.product.facade.model.vo.ProductPackageAndItemVo;
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

import static com.maiziyun.boss.biz.product.convert.FofListSiteConverter.reConvert;

/**
 * Created by admin on 2017/7/22.
 */
@Service("boss.fofListService")
public class LocalFofListServiceImpl implements LocalFofListService {
    private static final Logger logger = LoggerFactory.getLogger(LocalFofListServiceImpl.class);
    @Resource(name = "boss.fofListClient")
    private FofListServiceClient fofListServiceClient;

    /**
     * 组合列表可购买列表
     *
     * @param request
     * @return
     */
    @Override
    public QueryFofListResponse queryFofListCanbuy(QueryFofListRequest request) {
        logger.info("接收请求{}", request);
        QueryFofListResponse response = new QueryFofListResponse();
        try {
            QueryFOFInfoBuyRequest $request = new QueryFOFInfoBuyRequest();
            List<QueryFofListVo> fofList = new ArrayList<>();
            QueryFOFInfoBuyResponse $response = fofListServiceClient.queryFofListCanbuy($request);
            if ($response != null && $response.getProductFOFInfoVoList() != null) {
                List<ProductFOFInfoVo> productFOFInfoVoList = $response.getProductFOFInfoVoList();
                if (productFOFInfoVoList != null && productFOFInfoVoList.size() > 0) {
                    for (int i = 0; i < productFOFInfoVoList.size(); i++) {
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
                       if (StringUtils.isNotBlank(productFOFInfoVoList.get(i).getSort())){
                            vo.setSort(productFOFInfoVoList.get(i).getSort()); //
                        }else {
                           vo.setSort("");
                       }
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
            logger.error("组合列表查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("组合列表查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 组合列表查询
     *
     * @param request
     * @return
     */
    @Override
    public QueryFofListResponse queryFofList(QueryFofListRequest request) {
        logger.info("接收请求{}", request);
        QueryFofListResponse response = new QueryFofListResponse();
        try {
            if (StringUtils.isBlank(request.getPageNo())) {
                throw new BizException(BizCode.ParamNull, "pageNo" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getPageSize())) {
                throw new BizException(BizCode.ParamNull, "pageSize" + BizCode.ParamNull.desc());
            }
            QueryFOFAndFOFNavInfoAllPageRequest $request = new QueryFOFAndFOFNavInfoAllPageRequest();
            $request.setPoCode(request.getPoCode());
            $request.setProductName(request.getProductName());
            $request.setPageNo(Integer.valueOf(request.getPageNo()));
            $request.setPageSize(Integer.valueOf(request.getPageSize()));

            List<QueryFofListVo> fofList = new ArrayList<>();
            QueryFOFAndFOFNavInfoAllPageResponse $response = fofListServiceClient.queryFofList($request);
            if ($response != null && $response.getDatas() != null) {
                List<ProductFOFInfoVo> productFOFInfoVoList = $response.getDatas();
                if (productFOFInfoVoList != null && productFOFInfoVoList.size() > 0) {
                    for (int i = 0; i < productFOFInfoVoList.size(); i++) {
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
            logger.error("组合列表查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("组合列表查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 组合列表详情查询
     *
     * @param request
     * @return
     */
    @Override
    public QueryFofDetailResponse queryFofDetail(QueryFofDetailRequest request) {
        logger.info("接收请求{}", request);
        QueryFofDetailResponse response = new QueryFofDetailResponse();
        try {
            if (StringUtils.isBlank(request.getPoCode())) {
                throw new BizException(BizCode.ParamNull, "组合ID" + BizCode.ParamNull.desc());
            }
            QueryFOFAndFOFNavInfoAllByProductIdRequest $request = new QueryFOFAndFOFNavInfoAllByProductIdRequest();
            $request.setPoCode(request.getPoCode());
            QueryFOFAndFOFNavInfoAllByProductIdResponse $response = fofListServiceClient.queryFofDetail($request);
            if ($response != null) {
                QueryFofDetailVo vo = new QueryFofDetailVo();
                ProductPackageAndItemVo packageAndItemVo = $response.getPackageAndItemVo();
                ProductAttrInfoVo productAttrInfoVo = $response.getProductAttrInfoVo();
                ProductFOFInfoVo productFOFInfoVo = $response.getProductFOFInfoVo();
                if (packageAndItemVo != null) {
                    vo.setId(String.valueOf(packageAndItemVo.getProductId()));
                    vo.setPoCode(packageAndItemVo.getPoCode() == null ? "" : packageAndItemVo.getPoCode()); //组合ID
                    if (productFOFInfoVo != null) {
                        if ("1".equals(productFOFInfoVo.getRiskLevel())) {  //风险等级
                            logger.info("低风险");
                            vo.setRisk("低风险");
                        } else if ("2".equals(productFOFInfoVo.getRiskLevel())) {
                            logger.info("中风险");
                            vo.setRisk("中风险");
                        } else if ("3".equals(productFOFInfoVo.getRiskLevel())) {
                            logger.info("高风险");
                            vo.setRisk("高风险");
                        }
                    } else {
                        vo.setRisk("");
                    }
                    if (productAttrInfoVo != null) {
                        String oldLabel = productAttrInfoVo.getValue();
                        if (StringUtils.isNotBlank(oldLabel)) {  //组合标签
                            String newLable = oldLabel.replace("|", ",");
                            vo.setLabels(newLable.split(","));
                        } else {
                            vo.setLabels(new String[]{"", "", ""});
                        }
                    }

                    vo.setMerchantId(packageAndItemVo.getMerchantId() == null ? "" : packageAndItemVo.getMerchantId());  //盈米ID
                }
                if (productFOFInfoVo != null) {
                    vo.setLowestBugAmmount(productFOFInfoVo.getPersonalLowestBugAmmount() == null ? "" :
                            productFOFInfoVo.getPersonalLowestBugAmmount().toString()); //起购金额
                    vo.setPoDesc(productFOFInfoVo.getPoDesc() == null ? "" : productFOFInfoVo.getPoDesc());             //组合简介
                    vo.setPoRichDesc(productFOFInfoVo.getPoRichDesc() == null ? "" : productFOFInfoVo.getPoRichDesc());     //组合明细说明
                }
                if (productFOFInfoVo != null) {
                    //是否可购买
                    if ("1".equals(productFOFInfoVo.getCanBuy())) {
                        vo.setBuyStatus("可购买");
                    } else if ("0".equals(productFOFInfoVo.getCanBuy())) {
                        vo.setBuyStatus("不可购买");
                    } else {
                        vo.setBuyStatus("");
                    }
                    if ("1".equals(productFOFInfoVo.getStatus())) { //1-上架
                        vo.setEffectFlagId(productFOFInfoVo.getStatus()); //上下架状态
                        vo.setEffectFlagName("上架");
                    } else if ("0".equals(productFOFInfoVo.getStatus())) {
                        vo.setEffectFlagId(productFOFInfoVo.getStatus()); //上下架状态
                        vo.setEffectFlagName("下架");
                    } else {
                        vo.setEffectFlagId(""); //上下架状态
                        vo.setEffectFlagName("");
                    }
                }
                vo.setBuyIncrease("-"); //认购递增
                vo.setPoType("-"); //组合类型
                response.setFofVo(vo);
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            } else {
                response.setFofVo(null);
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            }
        } catch (BaseException e) {
            logger.error("组合列表详情查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("组合列表详情查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 组合列表修改
     *
     * @param request
     * @return
     */
    @Override
    public UpdateFofListResponse updateFofList(UpdateFofListRequest request) {
        logger.info("接收请求{}", request);
        UpdateFofListResponse response = new UpdateFofListResponse();
        try {
            UpdateFOFAndFOFNavInfoAllByProductIdRequest $request = preRequestUp(request);
            UpdateFOFAndFOFNavInfoAllByProductIdResponse $response = fofListServiceClient.updateFofList($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("组合列表详情查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("组合列表详情查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    public UpdateFOFAndFOFNavInfoAllByProductIdRequest preRequestUp(UpdateFofListRequest request) {
        UpdateFOFAndFOFNavInfoAllByProductIdRequest $request = new UpdateFOFAndFOFNavInfoAllByProductIdRequest();
        if (StringUtils.isBlank(request.getId())) {
            throw new BizException(BizCode.ParamNull, "产品id" + BizCode.ParamNull.desc());
        }
        List<String> labels = request.getLabels();
        if (labels != null && labels.size() > 0) {
            if (labels.size() > 3) {
                throw new BizException(BossBizCode.LengthMore3, "组合标签" + BossBizCode.LengthMore3.desc());
            }
            for (int i = 0; i < labels.size(); i++) {
                if (labels.get(i).length() > 5) {
                    throw new BizException(BossBizCode.LengthMore5, "组合标签" + BossBizCode.LengthMore5.desc());
                }
            }
            StringBuilder result = new StringBuilder();
            boolean first = true;
            //第一个前面不拼接","
            for (String string : labels) {
                if (first) {
                    first = false;
                } else {
                    result.append(",");
                }
                result.append(string);
            }
            String label = result.toString();
//            String oldLables = String.valueOf(labels);
//            String lables = oldLables.substring(1,oldLables.length()-1);
            String a = label.replace(",", "|");
            $request.setAttrValue(a);                     //组合标签
        } else {
            throw new BizException(BizCode.ParamNull, "组合标签" + BizCode.ParamNull.desc());
        }
        if (StringUtils.isBlank(request.getPoDesc())) {
            throw new BizException(BizCode.ParamNull, "组合简介" + BizCode.ParamNull.desc());
        } else if (request.getPoDesc().length() > 40) {
            throw new BizException(BossBizCode.LengthMore40, "组合简介" + BossBizCode.LengthMore40.desc());
        }
        if (StringUtils.isBlank(request.getPoRichDesc())) {
            throw new BizException(BizCode.ParamNull, "组合明细说明" + BizCode.ParamNull.desc());
        } else if (request.getPoRichDesc().length() > 200) {
            throw new BizException(BossBizCode.LengthMore200, "组合明细说明" + BossBizCode.LengthMore200.desc());
        }
        $request.setProductId(Long.valueOf(request.getId()));
        $request.setPoDesc(request.getPoDesc());              //组合简介
        $request.setPoRichDesc(request.getPoRichDesc());       //组合明细说明
        $request.setEffectFlag(request.getEffectFlagId());      //上下线状态
        return $request;
    }

    /**
     * 组合列表顺序修改
     *
     * @param request
     * @return
     */
    @Override
    public UpdateFofSortResponse updateFofSort(UpdateFofSortRequest request) {
        logger.info("接收请求{}", request);
        UpdateFofSortResponse response = new UpdateFofSortResponse();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamNull, "request" + BizCode.ParamNull.desc());
            }
            if (request.getSortList() == null || request.getSortList().size() == 0) {
                throw new BizException(BossBizCode.FofLengthMore1, BossBizCode.FofLengthMore1.desc());
            }
            UpdateFOFInfoSortRequest $request = new UpdateFOFInfoSortRequest();
            $request.setProductIdList(request.getSortList());
            UpdateFOFInfoSortResponse $response = fofListServiceClient.updateFofSort($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("组合列表顺序修改异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("组合列表顺序修改异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 查询组合列表位置
     *
     * @param request
     * @return
     */
    @Override
    public QueryFofSiteResponse queryFofSite(QueryFofSiteRequest request) {
        logger.info("接收请求{}", request);
        QueryFofSiteResponse response = new QueryFofSiteResponse();
        try {
            QueryBuyFOFInfoPageRequest $request = new QueryBuyFOFInfoPageRequest();
            QueryBuyFOFInfoPageResponse $response = fofListServiceClient.queryFofSite($request);
            if ($response != null && $response.getDatas() != null && $response.getDatas().size() > 0) {
                List<ProductFOFInfoVo> productFOFInfoVoList = $response.getDatas();
                List<QueryFofSiteListVo> list = FofListSiteConverter.reConvert(productFOFInfoVoList);
                response.setList(list);
                response.setListTotal(String.valueOf($response.getTotal()));
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            } else {
                response.setList(null);
                response.setListTotal(null);
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            }

        } catch (BaseException e) {
            logger.error("组合列表位置管理查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("组合列表位置管理查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 位置管理显示状态修改
     *
     * @param request
     * @return
     */
    @Override
    public UpdateFofListShowStsResponse updateFofListShowSts(UpdateFofListShowStsRequest request) {
        logger.info("接收请求{}", request);
        UpdateFofListShowStsResponse response = new UpdateFofListShowStsResponse();
        try {
            if (StringUtils.isBlank(request.getId())) {
                throw new BizException(BizCode.ParamNull, "productId" + BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getEffectFlagId())) {
                throw new BizException(BizCode.ParamNull, "effectFlag" + BizCode.ParamNull.desc());
            }
            UpdateFOFInfoEffectByProductIdRequest $request = new UpdateFOFInfoEffectByProductIdRequest();
            $request.setProductId(Long.valueOf(request.getId()));
            $request.setEffectFlag(request.getEffectFlagId());
            UpdateFOFInfoEffectByProductIdResponse $response = fofListServiceClient.updateFofListShowSts($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("组合位置管理修改状态异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("组合位置管理修改状态异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }
}
