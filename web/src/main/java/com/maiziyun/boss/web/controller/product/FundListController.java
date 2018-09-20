package com.maiziyun.boss.web.controller.product;

import com.alibaba.fastjson.JSONObject;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.product.model.*;
import com.maiziyun.boss.facade.product.service.FundService;
import com.maiziyun.boss.web.common.utils.CommonUtils;
import com.maiziyun.boss.web.controller.ResponseUtil;
import com.maiziyun.boss.web.controller.ViewResponseModel;
import com.maiziyun.boss.web.controller.common.BaseController;
import com.maiziyun.boss.web.interceptor.annotation.TokenLogin;
import com.maiziyun.boss.web.vo.*;
import com.solar.framework.core.base.BaseException;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static com.maiziyun.boss.facade.common.enums.BossBizCode.LaLengthMore10;

/**
 * Created by admin on 2017/6/1.
 */
@Controller
@RequestMapping("/fund")
public class FundListController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(FundListController.class);

    @Resource(name = "boss.FundService")
    private FundService fundService;

    @Value("${boss.ImgUrl}")
    private String imgUrl;

    @Value("${boss.coverImgUrl}")
    private String coverImgUrl;

    @Value("${boss.topicImgUrl}")
    private String topicImgUrl;

    /**
     *
     * @api {post} /fund/queryHotSubject.do 热门专题全部查询（选中）
     * @apiName queryHotSubject
     * @apiGroup Boss
     * @apiVersion 0.1.0
     * @apiDescription 热门专题全部查询（选中）
     *
     * @apiPermission none
     *
     *
     * @apiParamExample {json} Request-Example:
     * {
     * }
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} id 唯一标识
     * @apiSuccess (Success 0) {String} name 专题名称
     * @apiSuccess (Success 0) {String} label 标题
     * @apiSuccess (Success 0) {String} info 详细描述
     * @apiSuccess (Success 0) {String} attrKind 专题类型
     * @apiSuccess (Success 0) {String} flag  改专题下是否有产品
     * @apiSuccess (Success 0) {String} visibility 是否显示
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:0,
     *   msg:'success',
     *   data:{
     *      id: "1",
     *      name: "专题名称",
     *      label: "标题",
     *      info: "详细描述",
     *      attrKind: "attr",
     *      flag:  "1",
     *      visibility: "1"
     *    }
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 热门专题全部查询（选中）
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping("/queryHotSubject.do")
    public void queryHotSubject(@RequestBody UpdateHotSubRequest hotList, HttpServletRequest request, HttpServletResponse response) {
        logger.info("热门专题查询(选中)controller:queryHotSubject()");
        FundItemQueryResponse $response = new FundItemQueryResponse();
        try {
            FundItemQueryRequest $request = new FundItemQueryRequest();
            $response = fundService.getItemList($request);
            JSONObject json = new JSONObject();
            json.put("list", $response.getDatas() == null ? "" : $response.getDatas());

            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, json));
        } catch (BaseException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("查询热门专题异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("查询热门专题异常", e);
        }
    }


    /**
     *
     * @api {post} /fund/queryAllHotSubject.do 热门专题全部查询（未选中）
     * @apiName queryFofDetail
     * @apiGroup Boss
     * @apiVersion 0.1.0
     * @apiDescription 热门专题全部查询（未选中）
     *
     * @apiPermission none
     *
     *
     * @apiParamExample {json} Request-Example:
     * {
     * }
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} id 唯一标识
     * @apiSuccess (Success 0) {String} name 专题名称
     * @apiSuccess (Success 0) {String} label 标题
     * @apiSuccess (Success 0) {String} info 详细描述
     * @apiSuccess (Success 0) {String} attrKind 专题类型
     * @apiSuccess (Success 0) {String} flag  改专题下是否有产品
     * @apiSuccess (Success 0) {String} visibility 是否显示
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:0,
     *   msg:'success',
     *   data:{
     *      id: "1",
     *      name: "专题名称",
     *      label: "标题",
     *      info: "详细描述",
     *      attrKind: "attr",
     *      flag:  "1",
     *      visibility: "1"
     *    }
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 热门专题全部查询（未选中）
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping("/queryAllHotSubject.do")
    public void queryAllHotSubject(@RequestBody UpdateHotSubRequest hotList, HttpServletRequest request, HttpServletResponse response) {
        logger.info("热门专题全部查询（未选中）controller:queryAllHotSubject()");
        FundItemQueryResponse $response = new FundItemQueryResponse();
        try {
            FundItemQueryRequest $request = new FundItemQueryRequest();
            $response = fundService.getAllItemList($request);
            JSONObject json = new JSONObject();
            json.put("list", $response.getDatas() == null ? "" : $response.getDatas());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, json));
        } catch (BaseException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门专题全部查询异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门专题全部查询异常", e);
        }
    }


    /**
     *
     * @api {post} /fund/updateSubject.do热门专题更改(确认按钮)
     * @apiName updateSubject
     * @apiGroup User
     * @apiVersion 0.1.0
     * @apiDescription 热门专题更改(确认按钮)
     *
     * @apiPermission none
     *
     * @apiParam {String} hotList 专题列表
     * @apiParamExample {json} Request-Example:
     * {
     * "hotList":[{
     *   "id": "1",
     *    "label": "主题标签",
     *    "info": "主题标签",
     *    "visibility":"1"
     * }]
     * }
     *
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} msg resultMsg
     *
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:0,
     *   msg:'success',
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 热门专题更改(确认按钮)
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping("/updateSubject.do")
    public void updateSubject1(@RequestBody UpdateHotSubRequest hotList, HttpServletRequest request, HttpServletResponse response) {
        logger.info("热门专题全部查询（未选中）controller:updateSubject1()");
        FundItemModifyResponse $response = new FundItemModifyResponse();
        try {
            if (hotList != null) {
                List<HotSubRequest> lists = hotList.getHotList();
                List<FundItemQueryRequest> list = new ArrayList<FundItemQueryRequest>();
                for (int i = 0; i < lists.size(); i++) {
                    HotSubRequest hot = lists.get(i);
                    FundItemQueryRequest vo = new FundItemQueryRequest();
                    vo.setId(hot.getId());
                    vo.setLabel(hot.getLabel());
                    vo.setInfo(hot.getInfo());
                    list.add(vo);
                }
                $response = fundService.fundItemModify(list);
                ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            }
        } catch (BaseException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门专题更改异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门专题更改异常", e);
        }
    }


    /**
     *
     * @api {post} /fund/querySubDetail.do 热门专题详情查询
     * @apiName passiveScanPay
     * @apiGroup User
     * @apiVersion 0.1.0
     * @apiDescription 热门专题详情查询
     *
     * @apiPermission none
     *
     * @apiParam {String} id 专题id
     * @apiParamExample {json} Request-Example:
     * {
     *   "id": 1
     * }
     *
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} msg resultMsg
     * @apiSuccess (Success 0) {String} id 专题id
     * @apiSuccess (Success 0) {String} label 主题标签
     * @apiSuccess (Success 0) {String} info 主题简介
     * @apiSuccess (Success 0) {String} detail 主题详情
     * @apiSuccess (Success 0) {String} coverImgUrl 列表图片
     * @apiSuccess (Success 0) {String} topicImgUrl 详情图片
     *
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:0,
     *   msg:'success',
     *   data:{
     *     id:1,
     *     label: dafd,
     *     info:dfdfdf,
     *     detail:fdfffffdf,
     *     coverImgUrl:http://product/attrKind/image/,
     *     topicImgUrl://product/attrKind/image/
     *
     *     qrCode:http://www.1.jpg
     *    }
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 热门专题详情查询
     */
    @TokenLogin
    @RequestMapping("/querySubDetail.do")
    public void querySubDetail(@RequestBody SubDetaiRequest subDetail, HttpServletRequest request, HttpServletResponse response) {
        logger.info("热门专题详情查询controller:querySubDetail()");
        FundItemQueryResponse $response = new FundItemQueryResponse();
        try {
            String id = subDetail.getId();
            FundItemQueryRequest $request = new FundItemQueryRequest();
            $request.setId(id);
            $response = fundService.querySubDetail($request);
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, $response.getData()));
        } catch (BaseException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门专题详情异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门专题详情异常", e);
        }
    }

    /**
     *
     * @api {post} /fund/updateSubDetail.do 热门专题详情(确认按钮)
     * @apiName passiveScanPay
     * @apiGroup User
     * @apiVersion 0.1.0
     * @apiDescription 热门专题详情(确认按钮)
     *
     * @apiPermission none
     *
     * @apiParam {String} id 专题id
     * @apiParam {String} label 主题标签
     * @apiParam {String} info 主题简介
     * @apiParam {String} detail 主题详情
     * @apiParam {String} coverImgUrl 列表图片
     * @apiParam {String} topicImgUrl 详情图片
     * @apiParamExample {json} Request-Example:
     * {
     *   "id": 1,
     *"label": "主题标签",
     * "info": "主题标签",
     * "detail": "主题标签",
     * "coverImgUrl": "file",
     * "topicImgUrl": "file"
     * }
     *
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} msg resultMsg
     *
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:0,
     *   msg:'success',
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 热门专题详情(确认按钮)
     */
    @TokenLogin
    @RequestMapping("/updateSubDetail.do")
    public void updateSubDetail(HttpServletRequest request, HttpServletResponse response) {
        logger.info("热门专题修改确认controller:updateSubDetail()");
        FundItemModifyResponse $response = new FundItemModifyResponse();
        try {
            FundItemQueryRequest $request = new FundItemQueryRequest();
            $request.setId(request.getParameter("id"));
            $request.setName(request.getParameter("name"));
            $request.setLabel(request.getParameter("label"));
            $request.setInfo(request.getParameter("info"));
            $request.setDetail(request.getParameter("detail"));

            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            MultipartFile coverImg = multiRequest.getFile("coverImg");
            MultipartFile topicImg = multiRequest.getFile("topicImg");
            if (coverImg != null) {
                String path1 = imgUrl + coverImgUrl;
                String filename = CommonUtils.genRand("list");
                String suffix = CommonUtils.getSuffxi(coverImg);
                String file = CommonUtils.uploadFileHot(path1, filename, suffix, coverImg);
                $request.setCoverImgPath(coverImgUrl + filename + suffix);
                logger.info("coverImgPath:" + coverImgUrl + filename + suffix);
                logger.info("coverImgPath上传图片完整路径为" + path1 + filename + suffix);
            }
            if (topicImg != null) {
                String path2 = imgUrl + topicImgUrl;
                String filename = CommonUtils.genRand("topic");
                String suffix = CommonUtils.getSuffxi(topicImg);
                String file = CommonUtils.uploadFile(path2, filename, suffix, topicImg);
                $request.setThemeImgPath(topicImgUrl + filename + suffix);
                logger.info("themeImgPath:" + topicImgUrl + filename + suffix);
                logger.info("themeImgPath上传图片完整路径为" + path2 + filename + suffix);
            }
            $response = fundService.updateSubDetail($request);
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
        } catch (IOException e) {
            $response.setCode(BossBizCode.upImgFail);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("图片上传失败", e);
        } catch (BaseException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门专题详情更改异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门专题详情更改异常", e);
        }
    }

    /**
     *
     * @api {post} /fund/queryHotFund.do 热门基金查询（选中）/新手专区/定投专区
     * @apiName queryHotFund
     * @apiGroup User
     * @apiVersion 0.1.0
     * @apiDescription 热门基金查询（选中）/新手专区/定投专区)
     *
     * @apiPermission none
     *
     * @apiParam {String} type 标题类型
     * @apiParamExample {json} Request-Example:
     * {
     *   "type": 1
     * }
     *
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} msg resultMsg
     * @apiSuccess (Success 0) {String} id       id
     * @apiSuccess (Success 0) {String} name   基金名称
     * @apiSuccess (Success 0) {String} code   基金代码
     * @apiSuccess (Success 0) {String} type   基金类型
     * @apiSuccess (Success 0) {String} visibility  是否显示
     * @apiSuccess (Success 0) {String} growYear    近一年涨幅
     * @apiSuccess (Success 0) {String} growMonth3  近3月涨幅
     * @apiSuccess (Success 0) {String} growMonth1  近1月涨幅
     * @apiSuccess (Success 0) {String} growWeek    近1周涨幅
     * @apiSuccess (Success 0) {String[]} labels      标签
     * @apiSuccess (Success 0) {String} productId   产品id
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:000000,
     *   msg:'success',
     *   data:{
     *      id : "1",
     *      name: "长城量化先锋组合",
     *      code :"4327",
     *      type :"混合型",
     *      visibility:“1”,
     *      growYear:“23%”,
     *      growMonth3:“23%”,
     *      growMonth1:“23%”,
     *      growWeek:“23%”,
     *      labels:"标签,标签",
     *      productId: "1"

     *
     *
     *   }
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 热门基金查询（选中）/新手专区/定投专区
     */
    @TokenLogin
    @RequestMapping("/queryHotFund.do")
    public void queryHotFund(@RequestBody HotFundRequest hotFund, HttpServletRequest request, HttpServletResponse response) {
        logger.info("热门专题全部查询（选中）controller:queryHotFund()");
        HotFundQueryResponse $response = new HotFundQueryResponse();
        try {
            String fundType = hotFund.getType();
            HotFundQueryRequest $request = new HotFundQueryRequest();
            $request.setFundType(fundType);
            $response = fundService.queryHotFund($request);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", $response.getDatas() == null ? "" : $response.getDatas());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, map));
        } catch (BaseException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门基金选中查询异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门基金选中查询异常", e);
        }
    }

    /**
     *
     * @api {post} /fund/queryAllHotFund.do 热门基金查询（未选中）/新手专区/定投专区
     * @apiName queryAllHotFund
     * @apiGroup User
     * @apiVersion 0.1.0
     * @apiDescription 热门基金查询（未选中）/新手专区/定投专区
     *
     * @apiPermission none
     *
     * @apiParam {String} name 基金名称
     * @apiParam {String} code 基金代码
     * @apiParam {String} type 基金类型
     * @apiParam {String} fundType 标题类型
     * @apiParam {String} pageNo 当前页
     * @apiParam {String} pageSize 页面大小
     *
     * @apiParamExample {json} Request-Example:
     * {
     *  "pageNo":"1",
     *  "pageSize":"10",
     *  "name":"长城量化先锋组合",
     *  "code":"4327",
     *  "type":"1",
     *  "fundType":"attr"
     * }
     *
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} msg resultMsg
     * @apiSuccess (Success 0) {String} id       id
     * @apiSuccess (Success 0) {String} name   基金名称
     * @apiSuccess (Success 0) {String} code   基金代码
     * @apiSuccess (Success 0) {String} type   基金类型
     * @apiSuccess (Success 0) {String} visibility  是否显示
     * @apiSuccess (Success 0) {String} growYear    近一年涨幅
     * @apiSuccess (Success 0) {String} growMonth3  近3月涨幅
     * @apiSuccess (Success 0) {String} growMonth1  近1月涨幅
     * @apiSuccess (Success 0) {String} growWeek    近1周涨幅
     * @apiSuccess (Success 0) {String[]} labels      标签
     * @apiSuccess (Success 0) {String} productId   产品id
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:000000,
     *   msg:'success',
     *   data:{
     *      id : "1",
     *      name: "长城量化先锋组合",
     *      code :"4327",
     *      type :"混合型",
     *      visibility:“1”,
     *      growYear:“23%”,
     *      growMonth3:“23%”,
     *      growMonth1:“23%”,
     *      growWeek:“23%”,
     *      labels:"标签,标签",
     *      productId: "1"
     *
     *   }
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 热门基金查询（未选中）/新手专区/定投专区
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping("/queryAllHotFund.do")
    public void queryAllHotFund(@RequestBody HotFundQuRequest fund, HttpServletRequest request, HttpServletResponse response) {
        logger.info("热门专题全部查询（未选中）controller:queryAllHotFund()");
        HotFundQueryResponse $response = new HotFundQueryResponse();
        try {
            HotFundQueryRequest $request = new HotFundQueryRequest();
            String pageNo = fund.getPageNo();
            String pageSize = fund.getPageSize();
            String fundName = fund.getName();
            String fundCode = fund.getCode();
            String fundType = fund.getFundType();
            String type = fund.getType();
            if ("all".equals(type)) {
                $request.setFundType("");//基金类型
            } else {
                $request.setFundType(type);
            }
            $request.setType(fundType);// 标题类型
            $request.setPageNo(Integer.valueOf(pageNo));
            $request.setPageSize(Integer.valueOf(pageSize));
            $request.setFundName(fundName);
            $request.setFundCode(fundCode);
            $response = fundService.queryAllHotFund($request);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("listTotal", $response.getTotal() == null ? "" : $response.getTotal());
            map.put("list", $response.getDatas() == null ? "" : $response.getDatas());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, map));
        } catch (BaseException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门基金未选中查询异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门基金未选中异常", e);
        }

    }

    /**
     *
     * @api {post} /fund/updateHotFund.do  热门基金修改/新手专区/定投专区
     * @apiName updateHotFund
     * @apiGroup User
     * @apiVersion 0.1.0
     * @apiDescription 热门基金修改/新手专区/定投专区
     *
     * @apiPermission none
     *
     * @apiParam {String} hotList 列表
     * @apiParam {String} type 标题类型
     *
     * @apiParamExample {json} Request-Example:
     * {
     *  "hotList":[{
     *      "id": "1",
     *      "labels":["1","2"],
     *      "type":"attr"
     *  }],
     *  "type":"10",
     * }
     *
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} msg resultMsg
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:000000,
     *   msg:'success',
     *   data:{
     *   }
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 热门基金修改/新手专区/定投专区
     */
    @TokenLogin
    @RequestMapping("/updateHotFund.do")
    public void updateHotFund(@RequestBody UpdateHotFundRequest hotList, HttpServletRequest request, HttpServletResponse response) {
        logger.info("热门基金修改 controller:updateHotFund()");
        HotFundModifyResponse $response = new HotFundModifyResponse();
        try {
            List<HotFundRequestVo> listHot = hotList.getHotList();
            String type = hotList.getType();
            if (listHot != null && listHot.size() > 0) {
                for (int i = 0; i < listHot.size(); i++) {
                    if (listHot.get(i).getLabels() == null || listHot.get(i).getLabels().size() == 0) {
                        throw new BizException(BossBizCode.LaLengthEqlNull, BossBizCode.LaLengthEqlNull.desc()); //至少设置一个标签
                    }
                    for (int j = 0; j < listHot.get(i).getLabels().size(); j++) {
                        String lable1 = listHot.get(i).getLabels().get(j);
                        if (StringUtils.isNotBlank(lable1) && (lable1.length() < 2 || lable1.length() > 5)) {
                            throw new BizException(BossBizCode.LaLengthMore25, BossBizCode.LaLengthMore25.desc()); //每个标签至多五个汉字，至少两个汉字
                        }
                    }
                }
            }
            List<HotFundModifyRequest> list = CommonUtils.getLabel(listHot, type);
            $response = fundService.HotFundModify(list);
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));

        } catch (BaseException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门基金更改异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("热门基金更改异常", e);
        }
    }

    /**
     *
     * @api {post} /fund/addHotItem.do  新增一个概念
     * @apiName addHotItem
     * @apiGroup User
     * @apiVersion 0.1.0
     * @apiDescription 新增一个概念
     *
     * @apiPermission none
     *
     * @apiParam {String} name 专题名称
     *
     * @apiParamExample {json} Request-Example:
     * {
     *  "name":"专题名称"
     * }
     *
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} msg resultMsg
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:000000,
     *   msg:'success',
     *   data:{
     *   }
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 新增一个概念
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping("/addHotItem.do")
    public void addHotItem(@RequestBody HotFundQuRequest hot, HttpServletRequest request, HttpServletResponse response) {
        logger.info("新增一个概念controller:addHotItem()", request);
        HotFundModifyResponse $response = new HotFundModifyResponse();
        try {
            String name = hot.getName();
            if (StringUtils.isBlank(name)) {
                throw new BizException(BizCode.ParamEmpty, "name" + BizCode.ParamEmpty.desc());
            }
            if (name.length() > 10) {
                throw new BizException(BossBizCode.LaLengthMore10, "name" + BossBizCode.LaLengthMore10.desc());
            }
            HotFundQueryRequest $request = new HotFundQueryRequest();
            $request.setFundName(name);
            $response = fundService.addHotItem($request);
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
        } catch (BizException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("新增概念异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("新增概念异常", e);
        }

    }

    /**
     *
     * @api {post} /fund/deleteHotItem.do  删除一个概念
     * @apiName deleteHotItem
     * @apiGroup User
     * @apiVersion 0.1.0
     * @apiDescription 删除一个概念
     *
     * @apiPermission none
     *
     * @apiParam {String} attrKind 专题标识
     *
     * @apiParamExample {json} Request-Example:
     * {
     *  "attrKind":"专题标识"
     * }
     *
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} msg resultMsg
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:000000,
     *   msg:'success',
     *   data:{
     *   }
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 删除一个概念
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping("/deleteHotItem.do")
    public void deleteHotItem(@RequestBody DeleteHotItemVo vo, HttpServletRequest request, HttpServletResponse response) {
        logger.info("删除一个概念controller:deleteHotItem()", request);
        HotFundModifyResponse $response = new HotFundModifyResponse();
        try {
            String attrKind = vo.getAttrKind();
            if (StringUtils.isBlank(attrKind)) {
                throw new BizException(BizCode.ParamEmpty, "attrKind" + BizCode.ParamEmpty.desc());
            }
            HotFundQueryRequest $request = new HotFundQueryRequest();
            $request.setFundType(attrKind);
            $response = fundService.deleteHotItem($request);
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
        } catch (BizException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("删除概念异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("删除概念异常", e);
        }
    }


    /**
     *
     * @api {post} /fund/queryFundConf.do 查询基金配置（未分页）
     * @apiName queryFundConf
     * @apiGroup User
     * @apiVersion 0.1.0
     * @apiDescription 查询基金配置（未分页）
     *
     * @apiPermission none
     *
     * @apiParam {String} attrKind 专题标识
     * @apiParamExample {json} Request-Example:
     * {
     *   "attrKind": 1
     * }
     *
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} msg resultMsg
     * @apiSuccess (Success 0) {String} id       id
     * @apiSuccess (Success 0) {String} name   基金名称
     * @apiSuccess (Success 0) {String} code   基金代码
     * @apiSuccess (Success 0) {String} type   基金类型
     * @apiSuccess (Success 0) {String} visibility  是否显示
     * @apiSuccess (Success 0) {String} growYear    近一年涨幅
     * @apiSuccess (Success 0) {String} growMonth3  近3月涨幅
     * @apiSuccess (Success 0) {String} growMonth1  近1月涨幅
     * @apiSuccess (Success 0) {String} growWeek    近1周涨幅
     * @apiSuccess (Success 0) {String[]} labels      标签
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:000000,
     *   msg:'success',
     *   data:{
     *      id : "1",
     *      name: "长城量化先锋组合",
     *      code :"4327",
     *      type :"混合型",
     *      visibility:“1”,
     *      growYear:“23%”,
     *      growMonth3:“23%”,
     *      growMonth1:“23%”,
     *      growWeek:“23%”,
     *      labels:"标签,标签",
     *
     *   }
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 查询基金配置（未分页）
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping("/queryFundConf.do")
    public void queryFundConf(@RequestBody QueryFundConfVo vo, HttpServletRequest request, HttpServletResponse response) {
        logger.info("查询基金配置(未分页)controller:queryFundConf()", request);
        HotFundQueryResponse $response = new HotFundQueryResponse();
        try {
            String attrKind = vo.getAttrKind();
            if (StringUtils.isBlank(attrKind)) {
                throw new BizException(BizCode.ParamEmpty, "attrKind" + BizCode.ParamEmpty.desc());
            }
            QueryFundConfRequest $request = new QueryFundConfRequest();
            $request.setAttrKind(attrKind);
            $response = fundService.queryFundConf($request);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", $response.getDatas() == null ? "" : $response.getDatas());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, map));
        } catch (BizException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("查询基金配置(未分页)异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("查询基金配置(未分页)异常", e);
        }


    }

    /**
     *
     * @api {post} /fund/queryAllFundConf.do 查询基金配置(分页)
     * @apiName queryAllFundConf
     * @apiGroup User
     * @apiVersion 0.1.0
     * @apiDescription 查询基金配置(分页)
     *
     * @apiPermission none
     *
     * @apiParam {String} name 基金名称
     * @apiParam {String} code 基金代码
     * @apiParam {String} type 基金类型
     * @apiParam {String} fundType 标题类型
     * @apiParam {String} pageNo 当前页
     * @apiParam {String} pageSize 页面大小
     *
     * @apiParamExample {json} Request-Example:
     * {
     *  "pageNo":"1",
     *  "pageSize":"10",
     *  "name":"长城量化先锋组合",
     *  "code":"4327",
     *  "type":"1",
     *  "fundType":"attr"
     * }
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} msg resultMsg
     * @apiSuccess (Success 0) {String} id       id
     * @apiSuccess (Success 0) {String} name   基金名称
     * @apiSuccess (Success 0) {String} code   基金代码
     * @apiSuccess (Success 0) {String} type   基金类型
     * @apiSuccess (Success 0) {String} visibility  是否显示
     * @apiSuccess (Success 0) {String} growYear    近一年涨幅
     * @apiSuccess (Success 0) {String} growMonth3  近3月涨幅
     * @apiSuccess (Success 0) {String} growMonth1  近1月涨幅
     * @apiSuccess (Success 0) {String} growWeek    近1周涨幅
     * @apiSuccess (Success 0) {String[]} labels      标签
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:000000,
     *   msg:'success',
     *   data:{
     *      id : "1",
     *      name: "长城量化先锋组合",
     *      code :"4327",
     *      type :"混合型",
     *      visibility:“1”,
     *      growYear:“23%”,
     *      growMonth3:“23%”,
     *      growMonth1:“23%”,
     *      growWeek:“23%”,
     *      labels:"标签,标签",
     *
     *   }
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 查询基金配置(分页)
     */
    @TokenLogin
    @RequestMapping("/queryAllFundConf.do")
    public void queryAllFundConf(@RequestBody QueryFundConfVo vo, HttpServletRequest request, HttpServletResponse response) {
        logger.info("查询基金配置(分页)controller:queryAllFundConf()", request);
        HotFundQueryResponse $response = new HotFundQueryResponse();
        try {

            String attrKind = vo.getAttrKind();
            String productName = vo.getName();
            String fundCode = vo.getCode();
            String fundType = vo.getType();
            String pageNo = vo.getPageNo();
            String pageSize = vo.getPageSize();

            if (StringUtils.isBlank(attrKind)) {
                throw new BizException(BizCode.ParamEmpty, "attrKind" + BizCode.ParamEmpty.desc());
            }
            if (StringUtils.isBlank(pageNo)) {
                throw new BizException(BizCode.ParamEmpty, "pageNo" + BizCode.ParamEmpty.desc());
            }
            if (StringUtils.isBlank(pageSize)) {
                throw new BizException(BizCode.ParamEmpty, "pageSize" + BizCode.ParamEmpty.desc());
            }
            QueryFundConfRequest $request = new QueryFundConfRequest();
            $request.setAttrKind(attrKind);
            $request.setProductName(productName);
            $request.setFundCode(fundCode);
            if ("all".equals(fundType)) {
                $request.setFundType("");//基金类型
            } else {
                $request.setFundType(fundType);
            }
            $request.setPageNo(Integer.valueOf(pageNo));
            $request.setPageSize(Integer.valueOf(pageSize));
            $response = fundService.queryAllFundConf($request);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("listTotal", $response.getTotal() == null ? "" : $response.getTotal());
            map.put("list", $response.getDatas() == null ? "" : $response.getDatas());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, map));
        } catch (BizException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("查询基金配置(分页)异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("查询基金配置(分页)异常", e);
        }

    }


    /**
     *
     * @api {post} /fund/updateFundConf.do  修改基金配置
     * @apiName updateFundConf
     * @apiGroup User
     * @apiVersion 0.1.0
     * @apiDescription 修改基金配置
     *
     * @apiPermission none
     *
     * @apiParam {String} attrKind 专题标识
     * @apiParam {String} productId 产品id列表
     *
     * @apiParamExample {json} Request-Example:
     * {
     *  "attrKind":"attr",
     *  "productId":"["1","2"]"
     * }
     *
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} msg resultMsg
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:000000,
     *   msg:'success',
     *   data:{
     *   }
     *  }
     *
     *  @apiError (Fail 100) 404 无效请求
     *  @apiErrorExample {json} Error-Response 404:
     *  HTTP/1.1 404 Not Found
     *  {
     *   code:404,
     *   msg:'api not found'
     *   }
     *
     *
     * @param param
     * @return
     * @throws Exception
     */
    /**
     * 修改基金配置
     */
    @TokenLogin
    @RequestMapping("/updateFundConf.do")
    public void updateFundConf(@RequestBody UpdateFundConfVo vo, HttpServletRequest request, HttpServletResponse response) {
        logger.info("修改基金配置controller:updateFundConf()", request);
        HotFundModifyResponse $response = new HotFundModifyResponse();
        try {
            String attrKind = vo.getAttrKind();
            List<String> list = vo.getProductId();
            if (StringUtils.isBlank(attrKind)) {
                throw new BizException(BizCode.ParamEmpty, "attrKind" + BizCode.ParamEmpty.desc());
            }
            if (list == null) {
                throw new BizException(BossBizCode.LengthEqlNull, "一个专题" + BossBizCode.LengthEqlNull.desc());
            }
            if (list.size() > 10) {
                throw new BizException(BossBizCode.LengthMore10, "一个专题" + BossBizCode.LengthMore10.desc());
            }
            List<Long> proList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                String productId = list.get(i);
                proList.add(Long.valueOf(productId));
            }
            UpdateFundConfRequest $request = new UpdateFundConfRequest();
            $request.setAttrKind(attrKind);
            $request.setList(proList);

            $response = fundService.updateFundConf($request);
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
        } catch (BizException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("修改基金配置异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("修改基金配置异常", e);
        }

    }

}
