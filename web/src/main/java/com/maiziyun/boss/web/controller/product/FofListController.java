package com.maiziyun.boss.web.controller.product;

import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.product.model.*;
import com.maiziyun.boss.facade.product.service.FofListService;
import com.maiziyun.boss.web.common.utils.CommonUtils;
import com.maiziyun.boss.web.controller.common.BaseController;
import com.maiziyun.boss.web.interceptor.annotation.TokenLogin;
import com.maiziyun.boss.web.vo.ResponseData;
import com.solar.framework.core.base.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/7/22.
 */
@Controller
@RequestMapping("/fofList")
public class FofListController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(FofListController.class);

    @Resource(name = "boss.fofListService")
    private FofListService fofListService;

    /**
     *
     * @api {post} /fofList/queryFofList.do 组合列表页查询
     * @apiName queryFofList
     * @apiGroup Boss
     * @apiVersion 0.1.0
     * @apiDescription 组合列表页查询
     *
     * @apiPermission none
     *
     * @apiParam {String} sortFlag  排序标签
     * @apiParam {String} poCode  组合ID
     * @apiParam {String} productName  组合名称
     * @apiParam {String} pageNo  当前页
     * @apiParam {String} pageSize  页面大小
     *
     * @apiParamExample {json} Request-Example:
     * {
     *   "poCode": "1",
     *   "productName": "组合",
     *   "pageNo": "1",
     *   "pageSize": "10",
     *
     * }
     *
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} msg resultMsg
     * @apiSuccess (Success 0) {String} id  id
     * @apiSuccess (Success 0) {String} productName 组合名称
     * @apiSuccess (Success 0) {String} poCode 组合id
     * @apiSuccess (Success 0) {String} merchantId 盈米Id
     * @apiSuccess (Success 0) {String} risk 风险等级
     * @apiSuccess (Success 0) {String} buyStatus 状态
     *
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:0,
     *   msg:'success',
     *   data:{
     *      list: [{
     *          id:1,
     *     productName: dafd,
     *     poCode:dfdfdf,
     *     merchantId:fdfffffdf,
     *     risk:低风险,
     *     buyStatus:可购买
     *      }],
     *      listTotal: {
     *          10
     *      },
     *      effectFlagList:[{
     *          {id:1,
     *          name:上线
     *          },
     *          {
     *            id:0,
     *            name:下线
     *          }
     *      }]
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
     * 组合列表页查询
     *
     * @param request
     * @return
     */
    @TokenLogin
    @RequestMapping("/queryFofList.do")
    @ResponseBody
    public Object queryFofList(@RequestBody QueryFofListRequest request) {
        QueryFofListResponse $response = new QueryFofListResponse();
        ResponseData data = new ResponseData();
        try {
            Map<String, Object> map = new HashMap<>();
            if ("1".equals(request.getSortFlag())) { //可购买
                $response = fofListService.queryFofListCanbuy(request);
                map.put("list", $response.getList() == null ? "" : $response.getList());
                map.put("effectFlagList", CommonUtils.getEffectFlag());// 是否上下架
            } else if ("0".equals(request.getSortFlag())) { //不可购买
                $response = fofListService.queryFofList(request);
                map.put("list", $response.getList() == null ? "" : $response.getList());
                map.put("listTotal", $response.getPageCount() == null ? "" : $response.getPageCount());
                map.put("effectFlagList", CommonUtils.getEffectFlag());// 是否上下架
            }
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("组合列表管理查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("组合列表管理查询异常", e);
        }
        return data;

    }

    /**
     *
     * @api {post} /fofList/queryFofDetail.do 组合列表详情查询
     * @apiName queryFofDetail
     * @apiGroup Boss
     * @apiVersion 0.1.0
     * @apiDescription 组合列表详情查询
     *
     * @apiPermission none
     *
     * @apiParam {String} poCode  组合ID
     *
     * @apiParamExample {json} Request-Example:
     * {
     *   "poCode": "1"
     *
     * }
     *
     *
     * @apiSuccess (Success 0) {String} code resultCode
     * @apiSuccess (Success 0) {String} id  id
     * @apiSuccess (Success 0) {String} poCode  组合ID
     * @apiSuccess (Success 0) {String} lowestBugAmmount 起购金额
     * @apiSuccess (Success 0) {String} risk 风险等级
     * @apiSuccess (Success 0) {String} buyStatus 是否可购买
     * @apiSuccess (Success 0) {String} merchantId 盈米组合ID
     * @apiSuccess (Success 0) {String[]}  labels 组合标签
     * @apiSuccess (Success 0) {String} poDesc 组合简介
     * @apiSuccess (Success 0) {String} poRichDesc 组合明细说明
     * @apiSuccess (Success 0) {String} effectFlagId 上线架状态
     * @apiSuccess (Success 0) {String} effectFlagName 上下架名字
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:0,
     *   msg:'success',
     *   data:{
     *      id : 1,
     *      poCode : 1,
     *      lowestBugAmmount : 1,
     *      risk : 1,
     *      buyStatus : 1,
     *      merchantId : 1,
     *      labels : 1,
     *      poDesc : 组合简介,
     *      poRichDesc : 组合明细说明,
     *      effectFlagId : 1,
     *      effectFlagName : 上架
     *
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
     * 组合列表详情查询
     *
     * @param request
     * @return
     */
    @TokenLogin
    @RequestMapping("/queryFofDetail.do")
    @ResponseBody
    public Object queryFofDetail(@RequestBody QueryFofDetailRequest request) {
        QueryFofDetailResponse $response = new QueryFofDetailResponse();
        ResponseData data = new ResponseData();
        try {
            $response = fofListService.queryFofDetail(request);
            data.setData($response.getFofVo() == null ? "" : $response.getFofVo());
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("组合列表详情查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("组合列表详情查询异常", e);
        }
        return data;

    }

    /**
     *
     * @api {post} /fofList/updateFofList.do 组合列表修改
     * @apiName updateFofList
     * @apiGroup Boss
     * @apiVersion 0.1.0
     * @apiDescription 组合列表修改
     *
     * @apiPermission none
     *
     * @apiParam {String} id  组合ID
     * @apiParam {String} poCode  组合明细
     * @apiParam {String} labels  组合标签
     * @apiParam {String} poRichDesc  组合明细说明
     * @apiParam {String} effectFlagId  上下架状态
     *
     *
     * @apiParamExample {json} Request-Example:
     * {
     *   "poCode": "1"
     *
     * }
     *
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:0,
     *   msg:'success',
     *   data:{
     *
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
     * 组合列表修改
     *
     * @param request
     * @return
     */
    @TokenLogin
    @RequestMapping("/updateFofList.do")
    @ResponseBody
    public Object updateFofList(@RequestBody UpdateFofListRequest request) {
        UpdateFofListResponse $response = new UpdateFofListResponse();
        ResponseData data = new ResponseData();
        try {
            $response = fofListService.updateFofList(request);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("组合列表修改异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("组合列表修改异常", e);
        }
        return data;
    }

    /**
     *
     * @api {post} /fofList/updateFofSort.do 组合列表排序修改
     * @apiName updateFofSort
     * @apiGroup Boss
     * @apiVersion 0.1.0
     * @apiDescription 组合列表排序修改
     *
     * @apiPermission none
     *
     * @apiParam {List} sortList  id集合
     *
     * @apiParamExample {json} Request-Example:
     * {
     *   "sortList": "["1","2"]"
     *
     * }
     *
     *
     * @apiSuccessExample Success-Response:
     *  HTTP/1.1 200 OK
     * {
     *   code:0,
     *   msg:'success',
     *   data:{
     *
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
     * 组合列表排序修改
     */
    @TokenLogin
    @RequestMapping("/updateFofSort.do")
    @ResponseBody
    public Object updateFofSort(@RequestBody UpdateFofSortRequest request) {
        UpdateFofSortResponse $response = new UpdateFofSortResponse();
        ResponseData data = new ResponseData();
        try {
            $response = fofListService.updateFofSort(request);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("组合列表排序修改异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("组合列表排序修改异常", e);
        }
        return data;
    }


    /**查询位置管理
     *
     * @return
     */
/*    public Object queryFofSite(@RequestBody QueryFofSiteRequest request) {
        QueryFofSiteResponse $response = new QueryFofSiteResponse();
        ResponseData data = new ResponseData();
        try {
            $response = fofListService.queryFofSite(request);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("listTotal", $response.getTotal());
            map.put("list", $response.getDatas());

            data.setData($response);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("组合列表修改异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("组合列表修改异常", e);
        }
        return data;
    }*/

    /**
     *显示状态修改
     */
   /* public Object updateFofListShowSts(@RequestBody UpdateFofListShowStsRequest request){
        UpdateFofListShowStsResponse $response = new UpdateFofListShowStsResponse();
        ResponseData data = new ResponseData();
        try {
            $response = fofListService.updateFofListShowSts(request);
            data.setData($response);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("组合位置管理修改状态异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("组合位置管理修改状态异常", e);
        }

        return data;
    }*/

}
