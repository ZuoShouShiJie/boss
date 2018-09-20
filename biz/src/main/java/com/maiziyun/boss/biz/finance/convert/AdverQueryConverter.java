package com.maiziyun.boss.biz.finance.convert;

import com.maiziyun.boss.facade.finance.model.vo.AdverVo;
import com.maiziyun.boss.facade.finance.model.vo.StateListVo;
import com.maiziyun.boss.facade.product.model.vo.HotFundVo;
import com.maiziyun.cms.facade.emuns.CmsChannelCode;
import com.maiziyun.cms.facade.emuns.CmsStatus;
import com.maiziyun.cms.facade.vo.AdvertisementVO;
import com.maiziyun.cms.facade.vo.PositionVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/6/19.
 */
public class AdverQueryConverter {

    public static AdverVo reConvert(AdvertisementVO m) {
        AdverVo vo = new AdverVo();
        if (m.getId() != null) {
            vo.setId(String.valueOf(m.getId()));
        }else {
            vo.setId("");
        }

        vo.setTitle(m.getTitle()==null?"":m.getTitle()); //广告标题
        if (m.getPosition() == 1) {
            vo.setPositionId("1");
            vo.setPositionName("APP首页上部栏位");
        } else if (m.getPosition() == 2) {
            vo.setPositionId("2");
            vo.setPositionName("APP投资页基金");
        } else if (m.getPosition() == 3) {
            vo.setPositionId("3");
            vo.setPositionName("APP投资页组合TAB位");
        } else if (m.getPosition() == 4) {
            vo.setPositionId("4");
            vo.setPositionName("APP投资页理财TAB位");
        } else if (m.getPosition() == 5) {
            vo.setPositionId("5");
            vo.setPositionName("APP投资页网贷TAB位");
        }

        if (m.getSort() != null) {
            vo.setOrder(m.getSort().toString());
        } else {
            vo.setOrder("");
        }

        if (m.getModifyTime() != null) {
            vo.setUpdateTime(parseDate(m.getModifyTime()));
        } else {
            vo.setUpdateTime("");
        }

        if (m.getOnline() == 1) {
            vo.setStateId(CmsStatus.ONLINE_STATUS.name());
            vo.setStateName(CmsStatus.ONLINE_STATUS.desc());
        } else if (m.getOnline() == 2) {
            vo.setStateId(CmsStatus.OFFLINE_STATUS.name());
            vo.setStateName(CmsStatus.OFFLINE_STATUS.desc());
        }

        if (m.getStartTime() != null) {
            vo.setStartTime(parseDate(m.getStartTime()));
        } else {
            vo.setStartTime("无");
        }

        if (m.getEndTime() != null) {
            vo.setEndTime(parseDate(m.getEndTime()));
        } else {
            vo.setEndTime("无");
        }

        return vo;

    }

    public static List<AdverVo> reConvert(List<AdvertisementVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<AdverVo> lists = new ArrayList<AdverVo>();
        for (AdvertisementVO m : params) {
            AdverVo u = reConvert(m);
            lists.add(u);
        }
        return lists;
    }


    public static AdverVo reConvert1(AdvertisementVO m) {
        AdverVo vo = new AdverVo();
        if (m.getId() != null) {
            vo.setId(String.valueOf(m.getId()));
        }else {
            vo.setId("");
        }

        vo.setTitle(m.getTitle()==null?"":m.getTitle()); //广告标题
        vo.setTargetUrl(m.getEvent()==null?"":m.getEvent());//广告位链接,
        if (m.getPosition() == 1) {
            vo.setPositionId("1");
            vo.setPositionName("APP首页上部栏位");
        } else if (m.getPosition() == 2) {
            vo.setPositionId("2");
            vo.setPositionName("APP投资页基金");
        } else if (m.getPosition() == 3) {
            vo.setPositionId("3");
            vo.setPositionName("APP投资页组合TAB位");
        } else if (m.getPosition() == 4) {
            vo.setPositionId("4");
            vo.setPositionName("APP投资页理财TAB位");
        } else if (m.getPosition() == 5) {
            vo.setPositionId("5");
            vo.setPositionName("APP投资页网贷TAB位");
        } else {
            vo.setPositionId("");
            vo.setPositionName("");
        }

        if (m.getSort() != null) {
            vo.setOrder(m.getSort().toString());
        } else {
            vo.setOrder("");
        }

        vo.setCoverImgUrl(m.getImageUrl()==null?"":m.getImageUrl());//广告位图片

        if ("07".equals(m.getShowChannel())) {
            vo.setQudaoId("07");
            vo.setQudaoName(CmsChannelCode.All.desc());
        } else if (CmsChannelCode.IOS.code().equals(m.getShowChannel())) {
            vo.setQudaoId(CmsChannelCode.IOS.code());
            vo.setQudaoName(CmsChannelCode.IOS.desc());
        } else if (CmsChannelCode.Android.code().equals(m.getShowChannel())) {
            vo.setQudaoId(CmsChannelCode.Android.code());
            vo.setQudaoName(CmsChannelCode.Android.desc());
        } else {
            vo.setQudaoId("");
            vo.setQudaoName("");
        }

        if (m.getOnline() == 1) {
            vo.setStateId(CmsStatus.ONLINE_STATUS.name());
            vo.setStateName(CmsStatus.ONLINE_STATUS.desc());
        } else if (m.getOnline() == 2) {
            vo.setStateId(CmsStatus.OFFLINE_STATUS.name());
            vo.setStateName(CmsStatus.OFFLINE_STATUS.desc());
        } else {
            vo.setStateId("");
            vo.setStateName("");
        }
        if (m.getStartTime() != null) {
            vo.setStartTime(parseDate(m.getStartTime()));
        } else {
            vo.setStartTime("");
        }
        if (m.getEndTime() != null) {
            vo.setEndTime(parseDate(m.getEndTime()));
        } else {
            vo.setEndTime("");
        }

        return vo;

    }

    public static String parseDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }


    public static List<StateListVo> reConvertSta(List<PositionVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<StateListVo> lists = new ArrayList<StateListVo>();
        StateListVo vo = new StateListVo();
        vo.setId("all");
        vo.setName("全部");
        lists.add(vo);
        for (PositionVO m : params) {
            StateListVo u = reConvertSta(m);
            lists.add(u);
        }

        return lists;
    }


    public static StateListVo reConvertSta(PositionVO m) {
        StateListVo vo = new StateListVo();
        vo.setId(m.getPositionId().toString());
        vo.setName(m.getPositionName());
        return vo;

    }


}
