package com.maiziyun.boss.biz.finance.convert;

import com.maiziyun.boss.facade.finance.model.vo.HomepageNoticeVo;
import com.maiziyun.boss.facade.finance.model.vo.NoticeManagerVo;
import com.maiziyun.cms.facade.emuns.CmsChannelCode;
import com.maiziyun.mdc.facade.emuns.MdcOnLineCode;
import com.maiziyun.mdc.facade.emuns.MdcSourceCode;
import com.maiziyun.mdc.facade.emuns.MdcTypeCode;
import com.maiziyun.mdc.facade.vo.NoticeManagerVO;
import com.maiziyun.mdc.facade.vo.NoticeVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/6/26.
 */
public class NoticeQueryConverter {
    public static List<NoticeManagerVo> revertListQy(List<NoticeManagerVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<NoticeManagerVo> $list = new ArrayList<>();
        for (NoticeManagerVO vo : params) {
            NoticeManagerVo no = revertVoQy(vo);
            $list.add(no);
        }

        return $list;

    }

    public static NoticeManagerVo revertVoQy(NoticeManagerVO vo) {
        NoticeManagerVo no = new NoticeManagerVo();
        no.setAnnouncementId(vo.getId() == null ? "" : String.valueOf(vo.getId()));
        no.setTitle(vo.getTitle());
        if (vo.getType() == 1) {
            no.setTypeId(MdcTypeCode.News_Notice.code());
            no.setTypeName(MdcTypeCode.News_Notice.name());
        } else if (vo.getType() == 2) {
            no.setTypeId(MdcTypeCode.Weal_Notice.code());
            no.setTypeName(MdcTypeCode.Weal_Notice.name());
        }

        no.setContent(vo.getContent());

        if (vo.getLastUpdate() != null) {
            no.setUpdateTime(parseDate(vo.getLastUpdate()));
        }

        if (MdcSourceCode.MDC_Channel_All.code().equals(vo.getShowChannel())) {
            no.setQudaoId(MdcSourceCode.MDC_Channel_All.code());
            no.setQudaoName(MdcSourceCode.MDC_Channel_All.desc());
        } else if (MdcSourceCode.IOS.code().equals(vo.getShowChannel())) {
            no.setQudaoId(MdcSourceCode.IOS.code());
            no.setQudaoName(MdcSourceCode.IOS.desc());
        } else if (MdcSourceCode.Android.code().equals(vo.getShowChannel())) {
            no.setQudaoId(MdcSourceCode.Android.code());
            no.setQudaoName(MdcSourceCode.Android.desc());
        }

        if ("1".equals(vo.getOnLine())) {
            no.setStateId(MdcOnLineCode.ON_LINE_CODE.code());
            no.setStateName(MdcOnLineCode.ON_LINE_CODE.name());

        } else if ("2".equals(vo.getOnLine())) {
            no.setStateId(MdcOnLineCode.Off_Line_Code.code());
            no.setStateName(MdcOnLineCode.Off_Line_Code.name());
        }

        if (vo.getStartTime() != null) {
            no.setStartTime(parseDate(vo.getStartTime()));
        } else {
            no.setStartTime("无");
        }
        if (vo.getEndTime() != null) {
            no.setEndTime(parseDate(vo.getEndTime()));
        } else {
            no.setEndTime("无");
        }

        return no;
    }

    public static String parseDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static HomepageNoticeVo homepageNotice(NoticeManagerVO vo) {
        HomepageNoticeVo noticeVo = new HomepageNoticeVo();
        noticeVo.setId(vo.getId() == null ? "" : String.valueOf(vo.getId()));
        noticeVo.setType(vo.getType() == null?"":String.valueOf(vo.getType())); //公告类型
        noticeVo.setContent(vo.getContent() == null ? "" : vo.getContent());  //公告内容
        noticeVo.setQudaoId(vo.getShowChannel() == null ? "" : vo.getShowChannel()); //展示渠道
        noticeVo.setStateId(vo.getOnLine()== null?"": vo.getOnLine());//状态：上线-1,下线-2
        noticeVo.setStartTime(vo.getStartTime() == null ? "" : parseDate(vo.getStartTime())); //起始时间
        noticeVo.setEndTime(vo.getEndTime() == null ? "" : parseDate(vo.getEndTime()));//结束时间
        return noticeVo;
    }

    public static HomepageNoticeVo homepageNoticeNull() {
        HomepageNoticeVo noticeVo = new HomepageNoticeVo();
        noticeVo.setId("");
        noticeVo.setType("");
        noticeVo.setContent("");
        noticeVo.setQudaoId("");
        noticeVo.setStateId("");
        noticeVo.setStartTime("");
        noticeVo.setEndTime("");
        return noticeVo;
    }

}
