package com.maiziyun.boss.web.controller.finance;

import com.maiziyun.boss.biz.redis.IBaseRedisService;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.finance.model.*;
import com.maiziyun.boss.facade.finance.service.NoticeService;
import com.maiziyun.boss.facade.product.model.QueryFofDetailResponse;
import com.maiziyun.boss.web.common.utils.CommonUtils;
import com.maiziyun.boss.web.controller.ResponseUtil;
import com.maiziyun.boss.web.controller.ViewResponseModel;
import com.maiziyun.boss.web.controller.common.BaseController;
import com.maiziyun.boss.web.interceptor.annotation.TokenLogin;
import com.maiziyun.boss.web.vo.NoticeQueryRequest;
import com.maiziyun.boss.web.vo.ResponseData;
import com.maiziyun.boss.web.vo.UpdateNoticeRequestVo;
import com.maiziyun.boss.web.vo.UploadImgsForm;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 公告管理 mdc   (图片上传还未实现)
 * Created by admin on 2017/6/26.
 */
@Controller
@RequestMapping("/notice")
public class NoticeController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(NoticeController.class);

    @Resource(name = "boss.noticeService")
    private NoticeService noticeService;

    @Value("${boss.notice.preImgUrl}")
    private String preImgUrl;

    @Value("${boss.notice.sufImgUrl}")
    private String sufImgUrl;

    @Value("${boss.notice.httpUrl}")
    private String httpUrl;

    /**
     * 查询公告
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping("/queryAllNotice.do")
    @ResponseBody
    public Object queryAllNotice(@RequestBody NoticeQueryRequest req, HttpServletRequest request, HttpServletResponse response) {
        logger.info("查询公告controller:queryAllNotice()");
        QueryNoticeResponse $response = new QueryNoticeResponse();
        ResponseData data = new ResponseData();
        try {
            String stateId = req.getStateId();
            String type = req.getTypeId();
            String title = req.getTitle();
            String pageNo = req.getPageNo();
            String pageSize = req.getPageSize();

            if (StringUtils.isBlank(stateId)) {
                throw new BizException(BizCode.ParamEmpty, "stateId" + BizCode.ParamEmpty.desc());
            }
            if (StringUtils.isBlank(type)) {
                throw new BizException(BizCode.ParamEmpty, "type" + BizCode.ParamEmpty.desc());
            }

            if (StringUtils.isBlank(pageNo)) {
                throw new BizException(BizCode.ParamEmpty, "pageNo" + BizCode.ParamEmpty.desc());
            }
            if (StringUtils.isBlank(pageSize)) {
                throw new BizException(BizCode.ParamEmpty, "pageSize" + BizCode.ParamEmpty.desc());
            }

            QueryNoticeRequest $request = new QueryNoticeRequest();
            $request.setStateId(stateId);
            $request.setType(type);
            $request.setTitle(title);
            $request.setPageNo(Integer.valueOf(pageNo));
            $request.setPageSize(Integer.valueOf(pageSize));
            $response = noticeService.queryAllNotice($request);
            Map<String, Object> map = new HashMap<>();
            map.put("listTotal", $response.getTotal() == null ? "" : $response.getTotal());
            map.put("stateList", CommonUtils.getStateList()); //上下线状态
            map.put("typeList", CommonUtils.getTypeList());
            map.put("qudaoList", CommonUtils.getChanList());  //渠道
            map.put("list", $response.getDatas() == null ? "" : $response.getDatas());

            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());

        } catch (BaseException e) {
            data.setCode(e.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("公告管理查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("公告管理查询异常", e);
        }
        return data;
    }

    /**
     * 点击编辑按钮（通过id查询公告管理）
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @ResponseBody
    @RequestMapping("/queryNoticeById.do")
    public Object queryNoticeById(@RequestBody NoticeQueryRequest req, HttpServletRequest request, HttpServletResponse response) {
        logger.info("公告点击编辑按钮（通过id查询公告管理）controller:queryNoticeById()");
        QueryNoticeResponse $response = new QueryNoticeResponse();
        ResponseData data = new ResponseData();
        try {
            String id = req.getAnnouncementId();
            if (StringUtils.isBlank(id)) {
                throw new BizException(BizCode.ParamEmpty, "id" + BizCode.ParamEmpty.desc());
            }
            QueryNoticeRequest $request = new QueryNoticeRequest();
            $request.setId(id);
            $response = noticeService.queryNoticeById($request);
            data.setData($response.getVo());
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("公告管理查询详情异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("公告管理查询详情异常", e);
        }
        return data;

    }

    /**
     * 添加保存按钮
     */
    @TokenLogin
    @ResponseBody
    @RequestMapping("/createNotice.do")
    public Object createNotice(@RequestBody UpdateNoticeRequestVo req, HttpServletRequest request, HttpServletResponse response) {
        logger.info("公告添加保存按钮controller:createNotice()");
        UpdateNoticeResponse $response = new UpdateNoticeResponse();
        ResponseData data = new ResponseData();
        try {
            String title = req.getTitle();
            String typeId = req.getTypeId();
            String content = req.getContent();
            String qudao = req.getQudaoId();
            String state = req.getStateId();
            String startTime = req.getStartTime();
            String endTime = req.getEndTime();
            if (StringUtils.isBlank(typeId)) {
                throw new BizException(BizCode.ParamEmpty, "typeId" + BizCode.ParamEmpty.desc());
            }
            if (StringUtils.isBlank(qudao)) {
                throw new BizException(BizCode.ParamEmpty, "qudao" + BizCode.ParamEmpty.desc());
            }
            if (StringUtils.isBlank(state)) {
                throw new BizException(BizCode.ParamEmpty, "state" + BizCode.ParamEmpty.desc());
            }
            UpdateNoticeRequest $request = new UpdateNoticeRequest();
            $request.setTitle(title);
            $request.setTypeId(typeId);
            $request.setContent(content);
            $request.setQudaoId(qudao);
            $request.setStateId(state);
            $request.setStartTime(startTime);
            $request.setEndTime(endTime);
            $response = noticeService.createNotice($request);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("公告管理添加异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("公告管理添加异常", e);
        }
        return data;

    }

    /**
     * 编辑保存按钮
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @ResponseBody
    @RequestMapping("/updateNotice.do")
    public Object updateNotice(@RequestBody UpdateNoticeRequestVo req, HttpServletRequest request, HttpServletResponse response) {
        logger.info("公告编辑保存按钮controller:updateNotice()");
        UpdateNoticeResponse $response = new UpdateNoticeResponse();
        ResponseData data = new ResponseData();
        try {
            String id = req.getAnnouncementId();
            String title = req.getTitle();
            String typeId = req.getTypeId();
            String content = req.getContent();
            String qudao = req.getQudaoId();
            String state = req.getStateId();
            String startTime = req.getStartTime();
            String endTime = req.getEndTime();

            if (StringUtils.isBlank(id)) {
                throw new BizException(BizCode.ParamEmpty, "id" + BizCode.ParamEmpty.desc());
            }
            if (StringUtils.isBlank(typeId)) {
                throw new BizException(BizCode.ParamEmpty, "typeId" + BizCode.ParamEmpty.desc());
            }
            if (StringUtils.isBlank(qudao)) {
                throw new BizException(BizCode.ParamEmpty, "qudao" + BizCode.ParamEmpty.desc());
            }
            if (StringUtils.isBlank(state)) {
                throw new BizException(BizCode.ParamEmpty, "state" + BizCode.ParamEmpty.desc());
            }
            //结束时间不能小于当前时间
            if (StringUtils.isNotBlank(endTime)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
                Date endDate = sdf.parse(endTime);
                Date date = new Date();
                if (endDate.getTime() < date.getTime()) {
                    throw new BizException(BossBizCode.DateError, "endTime" + BossBizCode.DateError.desc());
                }
            }

            UpdateNoticeRequest $request = new UpdateNoticeRequest();
            $request.setAnnouncementId(id);
            $request.setTitle(title);
            $request.setTypeId(typeId);
            $request.setContent(content);
            $request.setQudaoId(qudao);
            $request.setStateId(state);
            $request.setStartTime(startTime);
            $request.setEndTime(endTime);
            $response = noticeService.updateNotice($request);
            data.setCode($response.getCode().code());
        } catch (BaseException e) {
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("公告管理修改异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("公告管理修改异常", e);
        }
        return data;
    }

    /**
     * 修改上线，下线状态
     */
    @TokenLogin
    @ResponseBody
    @RequestMapping("/updateState.do")
    public Object updateState(@RequestBody NoticeQueryRequest req, HttpServletRequest request, HttpServletResponse response) {
        logger.info("公告修改上线，下线状态controller:updateState()");
        UpdateNoticeResponse $response = new UpdateNoticeResponse();
        ResponseData data = new ResponseData();
        try {
            String id = req.getAnnouncementId();
            String state = req.getStateId();
            if (StringUtils.isBlank(id)) {
                throw new BizException(BizCode.ParamEmpty, "id" + BizCode.ParamEmpty.desc());
            }
            if (StringUtils.isBlank(state)) {
                throw new BizException(BizCode.ParamEmpty, "state" + BizCode.ParamEmpty.desc());
            }

            UpdateNoticeRequest $request = new UpdateNoticeRequest();
            $request.setAnnouncementId(id);
            $request.setStateId(state);
            $response = noticeService.updateState($request);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("公告管理上线下线更改异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setCode(e.getMessage());
            e.printStackTrace();
            logger.error("公告管理上线下线更改异常", e);
        }
        return data;
    }

    /**
     * 删除按钮
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping("/delelteNotice.do")
    @ResponseBody
    public Object deleteNotice(@RequestBody NoticeQueryRequest req, HttpServletRequest request, HttpServletResponse response) {
        logger.info("删除公告controller:deleteNotice()");
        UpdateNoticeResponse $response = new UpdateNoticeResponse();
        ResponseData data = new ResponseData();
        try {
            String id = req.getAnnouncementId();
            if (StringUtils.isBlank(id)) {
                throw new BizException(BizCode.ParamEmpty, "id" + BizCode.ParamEmpty.desc());
            }
            UpdateNoticeRequest $request = new UpdateNoticeRequest();
            $request.setAnnouncementId(id);
            $response = noticeService.deleteNotice($request);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("公告管理删除异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("公告管理删除异常", e);
        }

        return data;
    }

    /**
     * 图片上传,测试
     *
     * @param request
     * @param response
     */
    @TokenLogin
    @RequestMapping(value = "/uploadImgs1.do", method = {RequestMethod.GET, RequestMethod.POST})
    public void uploadImgs1(HttpServletRequest request, HttpServletResponse response) {
        logger.info("图片上传controller:uploadImgs1()");
        UpdateNoticeResponse $response = new UpdateNoticeResponse();
        try {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> files = multiRequest.getFiles("wangEditorField");
            List<String> list = noticeService.uploadFiles(files, preImgUrl, sufImgUrl, httpUrl);
            Map<String, Object> map = new HashMap<>();
            map.put("list", list);
            $response.setCode(BossBizCode.Success);
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, map));

        } catch (IOException e) {
            $response.setCode(BossBizCode.upImgFail);
            $response.setMessage("图片上传失败");
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.upImgFail);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("图片上传失败", e);
        }
    }

    /**
     * 图片上传
     *
     * @param form
     */
    @TokenLogin
    @RequestMapping(value = "/uploadImgs.do", method = {RequestMethod.GET, RequestMethod.POST})
    public void uploadImg(HttpServletRequest request, HttpServletResponse response, UploadImgsForm form) {
        logger.info("图片上传controller:uploadImg()");
        UpdateNoticeResponse $response = new UpdateNoticeResponse();
        try {
            List<MultipartFile> fileList = CommonUtils.convertRequest(form);
            List<String> list = noticeService.uploadFiles(fileList, preImgUrl, sufImgUrl, httpUrl);
            Map<String, Object> map = new HashMap<>();
            map.put("list", list);
            $response.setCode(BossBizCode.Success);
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, list));
        } catch (IOException e) {
            $response.setCode(BossBizCode.upImgFail);
            $response.setMessage("图片上传失败");
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("异常", e);
        } catch (Exception e) {
            $response.setCode(BossBizCode.upImgFail);
            $response.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, null));
            e.printStackTrace();
            logger.error("图片上传失败", e);
        }
    }

    /**
     * 首页公告管理查询
     */
    @TokenLogin
    @RequestMapping("/queryHomepageNotice.do")
    @ResponseBody
    public Object queryHomepageNotice(@RequestBody QueryHomepageRequest request) {
        QueryHomepageResponse $response = new QueryHomepageResponse();
        ResponseData data = new ResponseData();
        try {
            $response = noticeService.queryHomepageNotice(request);
            data.setData($response.getNoticeVo() == null ? "" : $response.getNoticeVo());
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("首页公告管理查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("首页公告管理查询异常", e);
        }
        return data;

    }

    /**
     * 首页公告管理新增或修改
     */
    @TokenLogin
    @RequestMapping("/updateHomepageNotice.do")
    @ResponseBody
    public Object updateHomepageNotice(@RequestBody UpdateHomepageRequest request) {
        logger.info("前端传入数据:" + request);
        logger.info("前端传入id:" + request.getId());
        UpdateHomepageResponse $response = new UpdateHomepageResponse();
        ResponseData data = new ResponseData();
        try {
            $response = noticeService.updateHomepageNotice(request);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("首页公告管理查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("首页公告管理查询异常", e);
        }
        return data;

    }

}
