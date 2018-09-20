package com.maiziyun.boss.biz.product.convert;

import com.maiziyun.boss.biz.common.CommonUtils;
import com.maiziyun.boss.facade.product.model.vo.FundItemVo;
import com.maiziyun.boss.facade.product.model.vo.QueryProdListVo;
import com.maiziyun.common.enums.FeeType;
import com.maiziyun.common.enums.RiskLevel;
import com.maiziyun.product.facade.enums.FundType;
import com.maiziyun.product.facade.enums.ProductType;
import com.maiziyun.product.facade.enums.SaleFlag;
import com.maiziyun.product.facade.model.vo.ProductAttrKindInfoVo;
import com.maiziyun.product.facade.model.vo.ProductManagerVo;
import com.maiziyun.product.facade.model.vo.ProductSpecialTopicRelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/6/2.
 */
public class FundItemConverter {
    public static FundItemVo reConvert1(ProductAttrKindInfoVo old) {
        FundItemVo vo = new FundItemVo();
        vo.setId(old.getId() == null ? "" : old.getId().toString());
        vo.setName(old.getName() == null ? "" : old.getName());  //名字
        vo.setLabel(old.getTags() == null ? "" : old.getTags()); //主题标签
        vo.setInfo(old.getDesc() == null ? "" : old.getDesc());  //主题简介
        vo.setAttrKind(old.getAttrKind() == null ? "" : old.getAttrKind());  //标题类型
        vo.setFlag(old.getFlage() == null ? "" : old.getFlage());  //专题下是否有产品：1-有，0-没有
        vo.setSort(old.getProductSpecialTopicRelVo().getSort());
//        vo.setVisibility("1");
        return vo;
    }

    public static FundItemVo reConvert0(ProductAttrKindInfoVo old) {
        FundItemVo vo = new FundItemVo();
        vo.setId(old.getId() == null ? "" : old.getId().toString());
        vo.setName(old.getName() == null ? "" : old.getName());
        vo.setLabel(old.getTags() == null ? "" : old.getTags());
        vo.setInfo(old.getDesc() == null ? "" : old.getDesc());
        vo.setAttrKind(old.getAttrKind() == null ? "" : old.getAttrKind());
//        vo.setVisibility(old.getImagePath() == null ? "" : old.getImagePath());
        vo.setFlag(old.getFlage() == null ? "" : old.getFlage());
        return vo;
    }

    public static FundItemVo reConvertVo(ProductAttrKindInfoVo old) {
        FundItemVo vo = new FundItemVo();
        vo.setId(old.getId() == null ? "" : old.getId().toString());
        vo.setName(old.getName() == null ? "" : old.getName());
        vo.setLabel(old.getTags() == null ? "" : old.getTags());
        vo.setInfo(old.getDesc() == null ? "" : old.getDesc());
        vo.setDetail(old.getAttrKindDetail() == null ? "" : old.getAttrKindDetail());
//        String coverImgUrl = CommonUtils.GetImageStr(old.getImagePath());
//        String themeImgUrl =  CommonUtils.GetImageStr(old.getDetailsImagePath());
        vo.setCoverImgUrl(old.getImagePath() == null ? "" : old.getImagePath());
        vo.setTopicImgUrl(old.getDetailsImagePath() == null ? "" : old.getDetailsImagePath());
        return vo;
    }


    public static List<FundItemVo> reConvert1(List<ProductAttrKindInfoVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<FundItemVo> lists = new ArrayList<FundItemVo>();
        for (ProductAttrKindInfoVo m : params) {
            FundItemVo u = reConvert1(m);
            lists.add(u);
        }
        return lists;
    }

    public static List<FundItemVo> reConvertNo(List<ProductAttrKindInfoVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<FundItemVo> lists = new ArrayList<FundItemVo>();
        for (ProductAttrKindInfoVo m : params) {
            FundItemVo u = reConvert0(m);
            lists.add(u);
        }
        return lists;
    }

}
