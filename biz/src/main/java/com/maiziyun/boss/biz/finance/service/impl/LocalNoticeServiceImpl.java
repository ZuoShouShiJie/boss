package com.maiziyun.boss.biz.finance.service.impl;

import com.maiziyun.boss.biz.common.CommonUtils;
import com.maiziyun.boss.biz.finance.convert.NoticeQueryConverter;
import com.maiziyun.boss.biz.finance.service.LocalNoticeService;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.finance.model.*;
import com.maiziyun.boss.facade.finance.model.QueryNoticeRequest;
import com.maiziyun.boss.facade.finance.model.QueryNoticeResponse;
import com.maiziyun.boss.facade.finance.model.vo.HomepageNoticeVo;
import com.maiziyun.boss.facade.finance.model.vo.NoticeManagerVo;
import com.maiziyun.boss.integration.finance.NoticeClient;
import com.maiziyun.mdc.facade.emuns.MdcNoticeCode;
import com.maiziyun.mdc.facade.model.*;
import com.maiziyun.mdc.facade.vo.NoticeManagerVO;
import com.solar.framework.core.base.BaseException;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/6/26.
 */
@Service("boss.noticeService")
public class LocalNoticeServiceImpl implements LocalNoticeService {
    Logger logger = LoggerFactory.getLogger(LocalNoticeServiceImpl.class);

    @Resource(name = "boss.noticeClient")
    private NoticeClient noticeClient;

    /**
     * 查询全部
     *
     * @param request
     * @return
     */
    @Override
    public QueryNoticeResponse queryAllNotice(QueryNoticeRequest request) {
        logger.info("接收请求{}", request);
        QueryNoticeResponse response = new QueryNoticeResponse();

        try {
            QueryNoticeManagerRequest $request = new QueryNoticeManagerRequest();
            if ("all".equals(request.getStateId())) {
                $request.setOnline(null);
            } else {
                $request.setOnline(Integer.valueOf(request.getStateId()));
            }
            if ("all".equals(request.getType())) {
                $request.setType(null);
            } else {
                $request.setType(Integer.valueOf(request.getType()));
            }
            $request.setTitle(request.getTitle());
            $request.setCurrPage(request.getPageNo());
            $request.setPageSize(request.getPageSize());

            QueryNoticeManagerResponse $response = noticeClient.queryAllNotice($request);

            if ($response != null && $response.getData() != null && $response.getData().size() > 0) {
                List<NoticeManagerVO> list = $response.getData();
                List<NoticeManagerVo> $list = NoticeQueryConverter.revertListQy(list);
                response.setDatas($list);
                response.setTotal(Integer.valueOf($response.getTotalRecord() + ""));
            } else {
                response.setDatas(null);
                response.setTotal(null);
            }

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("公告管理查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("公告管理查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }


    /**
     * 点击编辑按钮（通过id查询详情）
     *
     * @param request
     * @return
     */
    @Override
    public QueryNoticeResponse queryNoticeById(QueryNoticeRequest request) {
        logger.info("接收请求{}", request);
        QueryNoticeResponse response = new QueryNoticeResponse();

        try {
            QueryNoticeManagerRequest $request = new QueryNoticeManagerRequest();
            $request.setId(Integer.valueOf(request.getId()));

            QueryNoticeManagerResponse $response = noticeClient.queryNoticeById($request);

            if ($response != null && $response.getData() != null && $response.getData().size() > 0) {

                List<NoticeManagerVO> list = $response.getData();
                NoticeManagerVo vo = NoticeQueryConverter.revertVoQy(list.get(0));
                response.setVo(vo);

            } else {
                response.setVo(null);
            }

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("公告管理查询详情异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("公告管理查询详情异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 添加保存按钮
     *
     * @param request
     * @return
     */
    @Override
    public UpdateNoticeResponse createNotice(UpdateNoticeRequest request) {
        UpdateNoticeResponse response = new UpdateNoticeResponse();

        try {
            CreateNoticeManagerRequest $request = new CreateNoticeManagerRequest();
            $request.setTitle(request.getTitle());
            $request.setType(Integer.valueOf(request.getTypeId()));
            $request.setContent(request.getContent());
            $request.setShowChannel(request.getQudaoId());
            $request.setOnline(Integer.valueOf(request.getStateId()));
            if (StringUtils.isNotBlank(request.getStartTime())) {
                $request.setStartTime(CommonUtils.parseToDate(request.getStartTime()));
            }
            if (StringUtils.isNotBlank(request.getEndTime())) {

                $request.setEndTime(CommonUtils.parseToDate(request.getEndTime()));
            }

            $request.setNoticeObjType(MdcNoticeCode.Notice_Obj_Type_All.code());
            CreateNoticeManagerResponse $response = noticeClient.createNotice($request);

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("公告管理添加异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("公告管理添加异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;

    }

    /**
     * 编辑保存按钮
     *
     * @param request
     * @return
     */
    @Override
    public UpdateNoticeResponse updateNotice(UpdateNoticeRequest request) {
        UpdateNoticeResponse response = new UpdateNoticeResponse();
        try {

            UpdateNoticeManagerRequest $request = new UpdateNoticeManagerRequest();
            $request.setId(Integer.valueOf(request.getAnnouncementId()));
            $request.setTitle(request.getTitle());
            $request.setType(Integer.valueOf(request.getTypeId()));
            $request.setContent(request.getContent());
            $request.setShowChannel(request.getQudaoId());
            $request.setOnline(Integer.valueOf(request.getStateId()));
            $request.setStartTime(CommonUtils.parseToDate(request.getStartTime()));
            $request.setEndTime(CommonUtils.parseToDate(request.getEndTime()));
            UpdateNoticeManagerResponse $response = noticeClient.updateNotice($request);

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("公告管理修改异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("公告管理修改异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 修改上线，下线状态
     *
     * @param request
     * @return
     */
    @Override
    public UpdateNoticeResponse updateState(UpdateNoticeRequest request) {
        UpdateNoticeResponse response = new UpdateNoticeResponse();
        try {

            UpdateNoticeManagerRequest $request = new UpdateNoticeManagerRequest();
            $request.setId(Integer.valueOf(request.getAnnouncementId()));
            $request.setOnline(Integer.valueOf(request.getStateId()));
            UpdateNoticeManagerResponse $response = noticeClient.updateState($request);

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("公告管理上线下线更改异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("公告管理上线下线更改异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 删除按钮
     *
     * @param request
     * @return
     */
    @Override
    public UpdateNoticeResponse deleteNotice(UpdateNoticeRequest request) {
        UpdateNoticeResponse response = new UpdateNoticeResponse();
        try {
            DeleteNoticeRequest $request = new DeleteNoticeRequest();
            $request.setNoticeId(Integer.valueOf(request.getAnnouncementId()));
            DeleteNoticeResponse $response = noticeClient.deleteNotice($request);

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("公告管理删除异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("公告管理删除异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    public List<String> uploadFiles(List<MultipartFile> files, String PreImgUrl, String sufImgUrl, String httpUrl) throws IOException {
        List<String> list = new ArrayList<>();
        for (MultipartFile img : files) {
            String path1 = PreImgUrl + sufImgUrl;
//                String path1="D:\\fileUpload\\img";
            String filename = CommonUtils.genRand("notice");
            String suffix = CommonUtils.getSuffxi(img);

            CommonUtils.uploadFile(path1, filename, suffix, img);
            String file = httpUrl + sufImgUrl + filename + suffix;
//            String file = "http://192.168.0.222:8888/img/"+filename + suffix;
            list.add(file);
        }
        return list;
    }


    /**
     * 首页公告管理查询
     *
     * @param request
     * @return
     */
    @Override
    public QueryHomepageResponse queryHomepageNotice(QueryHomepageRequest request) {
        QueryHomepageResponse response = new QueryHomepageResponse();
        try {
            QueryNoticeManagerRequest $request = new QueryNoticeManagerRequest();
            $request.setType(4);
            $request.setTitle("boss");
            QueryNoticeManagerResponse $response = noticeClient.queryHomepageNotice($request);
            List<NoticeManagerVO> list = $response.getData();
            HomepageNoticeVo noticeVo = new HomepageNoticeVo();
            if (list != null && list.size() > 0) {
                NoticeManagerVO vo = list.get(0);
                noticeVo = NoticeQueryConverter.homepageNotice(vo);
            } else {
                noticeVo = NoticeQueryConverter.homepageNoticeNull();
            }
            response.setNoticeVo(noticeVo);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("首页公告管理查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("首页公告管理查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 首页公告管理新增或修改
     *
     * @param request
     * @return
     */
    @Override
    public UpdateHomepageResponse updateHomepageNotice(UpdateHomepageRequest request) {
        UpdateHomepageResponse response = new UpdateHomepageResponse();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamNull,"request"+BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getContent())) {
                throw new BizException(BizCode.ParamNull,"request"+BizCode.ParamNull.desc());
            } else if (request.getContent().length() > 300) {
                throw new BizException(BossBizCode.NotiLengthMore300,"内容"+BossBizCode.NotiLengthMore300.desc());
            }
            if (StringUtils.isBlank(request.getQudaoId())) {
                throw new BizException(BizCode.ParamNull,"展示渠道"+BizCode.ParamNull.desc());
            }
            if (StringUtils.isBlank(request.getStateId())) {
                throw new BizException(BizCode.ParamNull,"状态"+BizCode.ParamNull.desc());
            }
            //结束时间不能小于当前时间
            String endTime = request.getEndTime();
            if (StringUtils.isNotBlank(endTime)){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
                Date endDate = sdf.parse(endTime);
                Date date = new Date();
                if (endDate.getTime() <date.getTime()) {
                    throw new BizException(BossBizCode.DateError,"endTime"+BossBizCode.DateError.desc());
                }
            }

            //修改
            if ("4".equals(request.getType())) {
                UpdateNoticeManagerRequest $request = new UpdateNoticeManagerRequest();
                $request.setId(Integer.valueOf(request.getId()));
                $request.setContent(request.getContent());
                $request.setShowChannel(request.getQudaoId());
                if (StringUtils.isNotBlank(request.getStateId())) {
                    $request.setOnline(Integer.valueOf(request.getStateId()));
                }
                if (StringUtils.isNotBlank(request.getStartTime())) {
                    $request.setStartTime(CommonUtils.parseToDate(request.getStartTime()));
                }
                if (StringUtils.isNotBlank(request.getEndTime())) {
                    $request.setEndTime(CommonUtils.parseToDate(request.getEndTime()));
                }
                UpdateNoticeManagerResponse $response = noticeClient.updateHomepageNotice($request);
                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
                //新增
            } else {
                CreateNoticeManagerRequest $request = new CreateNoticeManagerRequest();
                $request.setType(4);
                $request.setTitle("boss");
                $request.setContent(request.getContent());
                $request.setShowChannel(request.getQudaoId());
                if (StringUtils.isNotBlank(request.getStateId())) {
                    $request.setOnline(Integer.valueOf(request.getStateId()));
                }
                if (StringUtils.isNotBlank(request.getStartTime())) {
                    $request.setStartTime(CommonUtils.parseToDate(request.getStartTime()));
                }
                if (StringUtils.isNotBlank(request.getEndTime())) {
                    $request.setEndTime(CommonUtils.parseToDate(request.getEndTime()));
                }
                CreateNoticeManagerResponse $response = noticeClient.createHomepageNotice($request);

                response.setCode($response.getCode());
                response.setMessage($response.getMessage());
            }

        } catch (BaseException e) {
            logger.error("首页公告管理新增或修改异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("首页公告管理新增或修改异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }
}
