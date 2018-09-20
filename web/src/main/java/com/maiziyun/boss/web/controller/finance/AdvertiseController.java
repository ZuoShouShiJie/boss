
package com.maiziyun.boss.web.controller.finance;

import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.finance.model.QueryAdvertisementRequest;
import com.maiziyun.boss.facade.finance.model.QueryAdvertisementResponse;
import com.maiziyun.boss.facade.finance.model.UpdateAdverRequest;
import com.maiziyun.boss.facade.finance.model.UpdateAdverResponse;
import com.maiziyun.boss.facade.finance.service.AdvertisementService;
import com.maiziyun.boss.web.common.utils.CommonUtils;
import com.maiziyun.boss.web.controller.ResponseUtil;
import com.maiziyun.boss.web.controller.ViewResponseModel;
import com.maiziyun.boss.web.controller.common.BaseController;
import com.maiziyun.boss.web.interceptor.annotation.TokenLogin;
import com.maiziyun.boss.web.vo.AdverQueryRequest;
import com.maiziyun.boss.web.vo.ResponseData;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * 广告位管理 cms
 * Created by admin on 2017/6/14.
 */
@Controller
@RequestMapping("/finance")
public class AdvertiseController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(AdvertiseController.class);

    @Resource(name = "boss.adverService")
    private AdvertisementService adverService;

    @Value("${boss.adverPrefixImage}")
    private String adverPrefixImage;

    @Value("${boss.adverImagePath}")
    private String adverImagePath;

    /**
     * 查询广告位,查询全部
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping("/queryAdvertisement.do")
    public void queryAdvertisement(@RequestBody AdverQueryRequest adver, HttpServletRequest request, HttpServletResponse response) {
        logger.info("查询广告位,查询全部controller:queryAdvertisement()");
        QueryAdvertisementResponse $response = new QueryAdvertisementResponse();
        try {
            String state = adver.getStateId();
            String position = adver.getPositionId();
            String title = adver.getTitle();
            String pageNo = adver.getPageNo();
            String pageSize = adver.getPageSize();
            if (StringUtils.isBlank(pageNo)) {
                throw new BizException(BizCode.ParamEmpty, "pageNo" + BizCode.ParamEmpty.desc());
            }
            if (StringUtils.isBlank(pageSize)) {
                throw new BizException(BizCode.ParamEmpty, "pageSize" + BizCode.ParamEmpty.desc());
            }

            QueryAdvertisementRequest $request = new QueryAdvertisementRequest();
            $request.setState(state);
            $request.setPosition(position);
            $request.setTitle(title);
            $request.setPageNo(Integer.valueOf(pageNo));
            $request.setPageSize(Integer.valueOf(pageSize));

            $response = adverService.queryAdvertisement($request);
            Map<String, Object> map = new HashMap<>();
            map.put("listTotal", $response.getTotal() == null ? "" : $response.getTotal());
            map.put("list", $response.getDatas() == null ? "" : $response.getDatas());
            map.put("stateList", CommonUtils.getStateList());
            map.put("qudaoList", CommonUtils.getChanListCms());
            map.put("positionList", $response.getStateList());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, map));
        } catch (BaseException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("广告位查询异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("广告位查询异常", e);
        }

    }


    /**
     * 编辑查询页面,（通过id查询）
     */
    @TokenLogin
    @RequestMapping("/queryAdverById.do")
    @ResponseBody
    public Object queryAdverById(@RequestBody AdverQueryRequest adver, HttpServletRequest request, HttpServletResponse response) {
        ResponseData data = new ResponseData();
        logger.info("编辑查询页面,（通过id查询）controller:queryAdverById()");
        QueryAdvertisementResponse $response = new QueryAdvertisementResponse();
        try {
            String id = adver.getId();
            if (StringUtils.isBlank(id)) {
                throw new BizException(BizCode.ParamEmpty, "id" + BizCode.ParamEmpty.desc());
            }

            QueryAdvertisementRequest $request = new QueryAdvertisementRequest();
            $request.setId(id);
            $response = adverService.queryAdverById($request);
            data.setData($response.getAdverVo() == null ? "" : $response.getAdverVo());
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
//            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, $response.getAdverVo()));

        } catch (BizException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("异常", e);
        }
        return data;
    }


    /**
     * 广告位新增
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping("/createAdvertisement.do")
    public void createAdvertisement(HttpServletRequest request, HttpServletResponse response) {
        logger.info("广告位新增controller:createAdvertisement()");
        UpdateAdverResponse $response = new UpdateAdverResponse();
        try {
            UpdateAdverRequest $request = new UpdateAdverRequest();
            $request.setTitle(request.getParameter("title"));
            $request.setTargetUrl(request.getParameter("targetUrl"));
            $request.setPosition(request.getParameter("positionId"));
            $request.setOrder(request.getParameter("order"));

            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            MultipartFile coverImgFile = multiRequest.getFile("coverImg");
            if (coverImgFile != null) {
                String path1 = adverPrefixImage + adverImagePath;
//                String path1="D:/";
                String filename = CommonUtils.genRand("adver");
                String suffix = CommonUtils.getSuffxi(coverImgFile);
                String file = CommonUtils.uploadFile(path1, filename, suffix, coverImgFile);
                $request.setPrefixImage(adverPrefixImage);
                $request.setImagePath(adverImagePath + filename + suffix);
                logger.info("imagePath:" + adverImagePath + filename + suffix);
            }

            $request.setQudao(request.getParameter("qudaoId"));
            $request.setState(request.getParameter("stateId"));
            $request.setBeginTime(request.getParameter("startTime"));
            $request.setEndTime(request.getParameter("endTime"));
            $response = adverService.createAdver($request);
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));

        } catch (IOException e) {
            $response.setCode(BossBizCode.upImgFail);
            $response.setMessage("图片上传失败");
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("异常", e);
        } catch (BizException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("异常", e);
        }
    }


    /**
     * 广告位修改(保存按钮)
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping("/updateAdvertisement.do")
    public void updateAdvertisement(HttpServletRequest request, HttpServletResponse response) {
        logger.info("广告位修改(保存按钮)controller:updateAdvertisement()");
        UpdateAdverResponse $response = new UpdateAdverResponse();
        try {
            UpdateAdverRequest $request = new UpdateAdverRequest();
            if (StringUtils.isBlank(request.getParameter("id"))) {
                throw new BizException(BizCode.ParamEmpty, BizCode.ParamEmpty.desc());
            }
            $request.setId(request.getParameter("id"));
            $request.setTitle(request.getParameter("title"));
            $request.setTargetUrl(request.getParameter("targetUrl"));
            $request.setPosition(request.getParameter("positionId"));
            $request.setOrder(request.getParameter("order"));

            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            MultipartFile coverImgFile = multiRequest.getFile("coverImg");
            if (coverImgFile != null) {
                String path1 = adverPrefixImage + adverImagePath;
//                String path1="D:/";
                String filename = CommonUtils.genRand("adver");
                String suffix = CommonUtils.getSuffxi(coverImgFile);
                String file = CommonUtils.uploadFile(path1, filename, suffix, coverImgFile);
                $request.setPrefixImage(adverPrefixImage);
                $request.setImagePath(adverImagePath + filename + suffix);
                logger.info("imagePath:" + adverImagePath + filename + suffix);
            }
            $request.setQudao(request.getParameter("qudaoId"));
            $request.setState(request.getParameter("stateId"));
            $request.setBeginTime(request.getParameter("startTime"));
            $request.setEndTime(request.getParameter("endTime"));
            $response = adverService.updateAdver($request);

            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));

        } catch (IOException e) {
            $response.setCode(BossBizCode.upImgFail);
            $response.setMessage("图片上传失败");
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("异常", e);
        } catch (BaseException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("广告位修改异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("广告位修改异常", e);
        }


    }

    /**
     * 上线，下线按钮
     */
    @TokenLogin
    @RequestMapping("/updateAdverStatus.do")
    public void updateAdverStatus(@RequestBody AdverQueryRequest adver, HttpServletRequest request, HttpServletResponse response) {
        logger.info("上线，下线按钮controller:updateAdverStatus()");
        UpdateAdverResponse $response = new UpdateAdverResponse();
        try {
            String id = adver.getId();
            String state = adver.getStateId();
            if (StringUtils.isBlank(id)) {
                throw new BizException(BizCode.ParamEmpty, BizCode.ParamEmpty.desc());
            }
            if (StringUtils.isBlank(state)) {
                throw new BizException(BizCode.ParamEmpty, BizCode.ParamEmpty.desc());
            }

            UpdateAdverRequest $request = new UpdateAdverRequest();
            $request.setId(id);
            $request.setState(state);
            $response = adverService.updateAdverStatus($request);
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));

        } catch (BizException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("状态修改异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("状态修改异常", e);
        }


    }

    /**
     * 广告位删除
     */
    @TokenLogin
    @RequestMapping("/deleteAdver.do")
    public void deleteAdver(@RequestBody AdverQueryRequest adver, HttpServletRequest request, HttpServletResponse response) {
        logger.info("广告位删除controller:deleteAdver()");
        UpdateAdverResponse $response = new UpdateAdverResponse();
        try {
            String id = adver.getId();
            if (StringUtils.isBlank(id)) {
                throw new BizException(BizCode.ParamEmpty, "id" + BizCode.ParamEmpty.desc());
            }
            UpdateAdverRequest $request = new UpdateAdverRequest();
            $request.setId(id);
            $response = adverService.deleteAdver($request);
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
        } catch (BizException e) {
            $response.setCode(e.getCode());
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("广告位删除异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.Unknown);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("广告位删除异常", e);
        }

    }


}
