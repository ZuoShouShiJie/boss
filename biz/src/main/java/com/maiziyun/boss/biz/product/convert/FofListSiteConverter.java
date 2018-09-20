package com.maiziyun.boss.biz.product.convert;

import com.maiziyun.boss.facade.product.model.vo.FundItemVo;
import com.maiziyun.boss.facade.product.model.vo.QueryFofSiteListVo;
import com.maiziyun.product.facade.model.vo.ProductAttrKindInfoVo;
import com.maiziyun.product.facade.model.vo.ProductFOFInfoVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/6/2.
 */
public class FofListSiteConverter {
    public static QueryFofSiteListVo reConvert(ProductFOFInfoVo old) {
        QueryFofSiteListVo vo = new QueryFofSiteListVo();

        return vo;
    }



    public static List<QueryFofSiteListVo> reConvert(List<ProductFOFInfoVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<QueryFofSiteListVo> lists = new ArrayList<QueryFofSiteListVo>();
        for (ProductFOFInfoVo m : params) {
            QueryFofSiteListVo u = reConvert(m);
            lists.add(u);
        }
        return lists;
    }


}
