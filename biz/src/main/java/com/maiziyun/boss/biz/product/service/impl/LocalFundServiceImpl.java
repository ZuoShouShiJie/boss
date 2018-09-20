package com.maiziyun.boss.biz.product.service.impl;

import com.maiziyun.boss.biz.product.convert.FundItemConverter;
import com.maiziyun.boss.biz.product.convert.HotFundConverter;
import com.maiziyun.boss.biz.product.service.LocalFundService;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.product.model.*;
import com.maiziyun.boss.facade.product.model.vo.FundItemVo;
import com.maiziyun.boss.facade.product.model.vo.HotFundVo;
import com.maiziyun.boss.integration.product.FundServiceClient;
import com.maiziyun.mdc.facade.model.DeleteNoticeResponse;
import com.maiziyun.product.facade.model.*;
import com.maiziyun.product.facade.model.vo.FundNavInfoVo;
import com.maiziyun.product.facade.model.vo.ProductAttrInfoVo;
import com.maiziyun.product.facade.model.vo.ProductAttrKindInfoVo;
import com.maiziyun.product.facade.model.vo.ProductAttrRelVo;
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
 * Created by admin on 2017/6/2.
 */
@Service("boss.FundService")
public class LocalFundServiceImpl implements LocalFundService {
    @Resource(name = "boss.FundServiceClient")
    private FundServiceClient fundServiceClient;

    private static final Logger logger = LoggerFactory.getLogger(LocalFundServiceImpl.class);

    /**
     * 热门专题查询（选中）
     *
     * @param request
     * @return
     */
    @Override
    public FundItemQueryResponse getItemList(FundItemQueryRequest request) {
        logger.info("接收请求{}", request);
        FundItemQueryResponse response = new FundItemQueryResponse();
        try {
            QueryProductAttrKindByProductTypeRequest $request = new QueryProductAttrKindByProductTypeRequest();
            QueryProductAttrKindByProductTypeResponse $response = fundServiceClient.getFundItemList($request);
            if ($response != null && $response.getProductAttrKindInfoVoList() != null && $response.getProductAttrKindInfoVoList().size() != 0) {
                List<ProductAttrKindInfoVo> productAttrKindInfoVoList = $response.getProductAttrKindInfoVoList();
                List<FundItemVo> results = FundItemConverter.reConvert1(productAttrKindInfoVoList);
                //排序
                Collections.sort(results, new Comparator<FundItemVo>() {
                    @Override
                    public int compare(FundItemVo o1, FundItemVo o2) {
                        if (o1.getSort() == null) {
                            return -1;
                        } else if (o2.getSort() == null) {
                            return 1;
                        } else {
                            return o1.getSort() > o2.getSort() ? 1 : -1;
                        }

                    }
                });
                response.setDatas(results);
            } else {
                response.setDatas(null);
            }

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("查询热门专题异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("查询热门专题异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 热门专题全部查询（未选中）
     *
     * @param request
     * @return
     */
    @Override
    public FundItemQueryResponse getAllItemList(FundItemQueryRequest request) {
        logger.info("接收请求{}", request);
        FundItemQueryResponse response = new FundItemQueryResponse();
        try {
            QueryProductAttrKindByProductTypeRequest $request = new QueryProductAttrKindByProductTypeRequest();
            QueryProductAttrKindByProductTypeResponse $response = fundServiceClient.getAllFundItemList($request);
            if ($response != null && $response.getProductSpecialTopicRelVos() != null && $response.getProductSpecialTopicRelVos().size() != 0) {
                List<ProductAttrKindInfoVo> list = new ArrayList<ProductAttrKindInfoVo>();
                for (int i = 0; i < $response.getProductSpecialTopicRelVos().size(); i++) {
                    ProductAttrKindInfoVo vo = $response.getProductSpecialTopicRelVos().get(i).getProductAttrKindInfoVoList().get(0);
                    String status = $response.getProductSpecialTopicRelVos().get(i).getStatus();
                    vo.setImagePath(status);
                    list.add(vo);
                }

                List<FundItemVo> results = FundItemConverter.reConvertNo(list);
                response.setDatas(results);
            } else {
                response.setDatas(null);
            }

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("查询热门专题异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("查询热门专题异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 热门专题修改
     *
     * @param request
     * @return
     */
    @Override
    public FundItemModifyResponse fundItemModify(List<FundItemQueryRequest> request) {
        logger.info("接收请求{}", request);
        FundItemModifyResponse response = new FundItemModifyResponse();
        try {
            List<ProductAttrKindInfoVo> list = new ArrayList<ProductAttrKindInfoVo>();
            for (FundItemQueryRequest old : request) {
                ProductAttrKindInfoVo vo = new ProductAttrKindInfoVo();
                vo.setId(Long.parseLong(old.getId()));
                vo.setTags(old.getLabel());
                vo.setDesc(old.getInfo());
                list.add(vo);
            }
            UpdateProductAttrKindByIdsRequest $request = new UpdateProductAttrKindByIdsRequest();
            $request.setProductAttrKindInfoVoList(list);
            UpdateProductAttrKindByIdsResponse $response = fundServiceClient.fundItemModify($request);

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("热门专题修改异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("热门专题修改异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 热门专题详情查询
     *
     * @param request
     * @return
     */
    @Override
    public FundItemQueryResponse querySubDetail(FundItemQueryRequest request) {
        logger.info("接收请求{}", request);
        FundItemQueryResponse response = new FundItemQueryResponse();
        try {
            QueryProductAttrKindByIdRequest $request = new QueryProductAttrKindByIdRequest();
            $request.setId(Long.parseLong(request.getId()));
            QueryProductAttrKindByIdResponse $response = fundServiceClient.querySubDetail($request);

            if ($response != null && $response.getProductAttrKindInfoVo() != null) {
                FundItemVo results = FundItemConverter.reConvertVo($response.getProductAttrKindInfoVo());
                if (results != null) {
                    logger.info("返回coverImgUrl路径：" + results.getCoverImgUrl());
                    logger.info("返回topicImgUrl路径：" + results.getTopicImgUrl());
                }
                response.setData(results);
            } else {
                response.setData(null);
            }
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("查询主题详情异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("查询主题详情异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 热门专题详情修改
     *
     * @param request
     * @return
     */
    @Override
    public FundItemModifyResponse updateSubDetail(FundItemQueryRequest request) {
        logger.info("接收请求{}", request);
        FundItemModifyResponse response = new FundItemModifyResponse();
        try {
            UpdateProductAttrKindRequest $request = new UpdateProductAttrKindRequest();
            ProductAttrKindInfoVo vo = new ProductAttrKindInfoVo();
            String id = request.getId();
            vo.setId(Long.valueOf(request.getId()));
            vo.setName(request.getName());
            vo.setTags(request.getLabel());
            vo.setDesc(request.getInfo());
            vo.setAttrKindDetail(request.getDetail());
            vo.setImagePath(request.getCoverImgPath());
            vo.setDetailsImagePath(request.getThemeImgPath());
            $request.setProductAttrKindInfoVo(vo);

            UpdateProductAttrKindResponse $response = fundServiceClient.updateSubDetail($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("修改主题详情异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("修改主题详情异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }


    /**
     * 热门基金查询（选中）
     *
     * @param request
     * @return
     */
    @Override
    public HotFundQueryResponse queryHotFund(HotFundQueryRequest request) {
        logger.info("接收请求{}", request);
        HotFundQueryResponse response = new HotFundQueryResponse();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamError, BizCode.ParamError.desc());
            }
            QueryFundNavInfoAndTagRequest $request = new QueryFundNavInfoAndTagRequest();
            $request.setAttrKind(request.getFundType());
            QueryFundNavInfoAndTagResponse $response = fundServiceClient.queryHotFund($request);

            if ($response != null && $response.getProductAttrRelVoList() != null && $response.getProductAttrRelVoList().size() != 0) {
                List<ProductAttrRelVo> productAttrRelVoList = $response.getProductAttrRelVoList();
                List<HotFundVo> list = HotFundConverter.reConvertNo(productAttrRelVoList);
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
            logger.error("热门基金查询异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("热门基金查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }


    /**
     * 热门基金查询(未选中)
     *
     * @param request
     * @return
     */
    @Override
    public HotFundQueryResponse queryAllHotFund(HotFundQueryRequest request) {
        logger.info("接收请求{}", request);
        HotFundQueryResponse response = new HotFundQueryResponse();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamEmpty, BizCode.ParamEmpty.desc());
            }
            QueryFundNavInfoPageRequest $request = new QueryFundNavInfoPageRequest();
            $request.setProductName(request.getFundName());
            $request.setFundCode(request.getFundCode());
            $request.setFundType(request.getFundType());
            $request.setAttrKind(request.getType());
            $request.setPageNo(request.getPageNo());
            $request.setPageSize(request.getPageSize());

            QueryFundNavInfoPageResponse $response = fundServiceClient.queryAllHotFund($request);

            if ($response != null && $response.getDatas() != null && $response.getDatas().size() != 0) {
                List<HotFundVo> list = HotFundConverter.reConvert0($response.getDatas());
                response.setDatas(list);
                response.setTotal($response.getTotal());
            } else {
                response.setDatas(null);
                response.setTotal(0);
            }

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("热门基金查询异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("热门基金查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;

    }

    @Override
    public HotFundModifyResponse HotFundModify(List<HotFundModifyRequest> requests) {
        logger.info("接收请求{}", requests);
        HotFundModifyResponse response = new HotFundModifyResponse();
        try {
            if (requests == null || requests.size() == 0) {
                throw new BizException(BossBizCode.LengthEqlNull, BossBizCode.LengthEqlNull.desc());//至少勾选1个有效的基金产品
            }
            if (requests != null && requests.size() > 10) {
                throw new BizException(BossBizCode.LengthMore10, BossBizCode.LengthMore10.desc());//最多10个有效的基金产品

            }
            UpdateAttrKindRelByEffectFlagAndTagRequest $request = new UpdateAttrKindRelByEffectFlagAndTagRequest();
            List<ProductAttrInfoVo> list = new ArrayList<ProductAttrInfoVo>();
            for (HotFundModifyRequest request : requests) {
                ProductAttrInfoVo vo = new ProductAttrInfoVo();
                String id = request.getId();
                String label = request.getLabel();
                if (!StringUtils.isBlank(label)) {
                    String[] oldLables = label.split(",");
//                    if (oldLables.length == 0) {
//                        throw new BizException(BossBizCode.LaLengthEqlNull, BossBizCode.LaLengthEqlNull.desc()); //至少设置一个标签
//                    }
                    if (oldLables.length > 3) {
                        throw new BizException(BossBizCode.LaLengthMore3, BossBizCode.LaLengthMore3.desc()); //至多设置3个标签
                    }
                   /* for (int i=0;i<oldLables.length;i++) {
                        if (oldLables[i].length() > 5 || oldLables[i].length() < 2) {
                            throw new BizException(BossBizCode.LaLengthMore25, BossBizCode.LaLengthMore25.desc()); //每个标签至多五个汉字，至少两个汉字
                        }
                    }*/
                    String labels = label.replace(",", "|");
                    vo.setValue(labels);
                } else {
                    throw new BizException(BossBizCode.LaLengthEqlNull, BossBizCode.LaLengthEqlNull.desc()); //至少设置一个标签
                }
                vo.setProductId(Long.valueOf(id));
                list.add(vo);
            }
            $request.setAttrKind(requests.get(0).getType());
            $request.setProductAttrInfoVoList(list);
            UpdateAttrKindRelByEffectFlagAndTagResponse $response = fundServiceClient.HotFundModify($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("热门基金修改异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("热门基金修改修改异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    @Override
    public HotFundModifyResponse addHotItem(HotFundQueryRequest request) {
        HotFundModifyResponse response = new HotFundModifyResponse();
        try {
            AddProductAttrKindRequest $request = new AddProductAttrKindRequest();

            ProductAttrKindInfoVo productAttrKindInfoVo = new ProductAttrKindInfoVo();
            productAttrKindInfoVo.setName(request.getFundName());
            $request.setProductAttrKindInfoVo(productAttrKindInfoVo);
            AddProductAttrKindResponse $response = fundServiceClient.addHotItem($request);

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());

        } catch (BaseException e) {
            logger.error("新增概念异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("新增概念异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;

    }

    @Override
    public HotFundModifyResponse deleteHotItem(HotFundQueryRequest request) {
        HotFundModifyResponse response = new HotFundModifyResponse();
        try {
            DeleteProductAttrKindRequest $request = new DeleteProductAttrKindRequest();

            $request.setAttrKind(request.getFundType());
            DeleteProductAttrKindResponse $response = fundServiceClient.deleteHotItem($request);

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());

        } catch (BaseException e) {
            logger.error("删除概念异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("删除概念异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    @Override
    public HotFundQueryResponse queryFundConf(QueryFundConfRequest request) {
        HotFundQueryResponse response = new HotFundQueryResponse();
        try {
            QueryFundAllocationRequest $request = new QueryFundAllocationRequest();

            $request.setAttrKind(request.getAttrKind());
            QueryFundAllocationResponse $response = fundServiceClient.queryFundConf($request);

            if ($response != null && $response.getFundNavInfoVoList() != null && $response.getFundNavInfoVoList().size() != 0) {
                List<HotFundVo> list = HotFundConverter.reConvertConf($response.getFundNavInfoVoList());


                response.setDatas(list);
            } else {
                response.setDatas(null);
            }

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());

        } catch (BaseException e) {
            logger.error("查询基金配置(未分页)异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("查询基金配置(未分页)异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;

    }

    @Override
    public HotFundQueryResponse queryAllFundConf(QueryFundConfRequest request) {
        HotFundQueryResponse response = new HotFundQueryResponse();
        try {
            QueryFundNavInfoPageRequest $request = new QueryFundNavInfoPageRequest();
            $request.setAttrKind(request.getAttrKind());
            $request.setProductName(request.getProductName());
            $request.setFundCode(request.getFundCode());
            $request.setFundType(request.getFundType());
            $request.setPageNo(request.getPageNo());
            $request.setPageSize(request.getPageSize());

            QueryFundNavInfoPageResponse $response = fundServiceClient.queryAllFundConf($request);

            if ($response != null && $response.getDatas() != null && $response.getDatas().size() != 0) {
                List<HotFundVo> list = HotFundConverter.reConvertConf($response.getDatas());
                response.setDatas(list);
                response.setTotal($response.getTotal());
            } else {
                response.setDatas(null);
                response.setTotal(0);
            }

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());

        } catch (BaseException e) {
            logger.error("查询基金配置(分页)异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("查询基金配置(分页)异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    @Override
    public HotFundModifyResponse updateFundConf(UpdateFundConfRequest request) {
        HotFundModifyResponse response = new HotFundModifyResponse();
        try {
            FundAllocationRequest $request = new FundAllocationRequest();
            $request.setAttrKind(request.getAttrKind());
            $request.setProductId(request.getList());
            FundAllocationResponse $response = fundServiceClient.updateFundConf($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("修改基金配置异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("修改基金配置异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }
}
