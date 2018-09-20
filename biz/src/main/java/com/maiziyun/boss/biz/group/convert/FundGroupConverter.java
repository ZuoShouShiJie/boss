package com.maiziyun.boss.biz.group.convert;

import com.maiziyun.boss.common.utils.DateUtils;
import com.maiziyun.boss.facade.common.model.vo.StateVo;
import com.maiziyun.boss.facade.group.model.vo.FundGroupListVo;
import com.maiziyun.boss.facade.group.model.vo.QueryFundProductVo;
import com.maiziyun.boss.facade.group.model.vo.QuerySolidProductVo;
import com.maiziyun.boss.facade.jysmng.model.vo.J2PQueryUserMsgVo;
import com.maiziyun.cif.facade.model.vo.CustomerVo;
import com.maiziyun.common.enums.RiskLevel;
import com.maiziyun.product.facade.model.QueryProductGroupByIdResponse;
import com.maiziyun.product.facade.model.vo.QueryExchangeProductByNameVO;
import com.maiziyun.product.facade.model.vo.QueryLiveProductByNameVO;
import com.maiziyun.product.facade.model.vo.QueryProductGroupByConditionVO;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 2017/11/22.
 */
public class FundGroupConverter {

    public static FundGroupListVo convertFundGroupQy(QueryProductGroupByConditionVO old) {
        FundGroupListVo vo = new FundGroupListVo();
        vo.setId(String.valueOf(old.getId() == null ? "" : old.getId()));
        if (StringUtils.isNotBlank(old.getRiskLevel())) {
            vo.setLevelId(old.getRiskLevel() == null ? "" : old.getRiskLevel()); //评级id
            vo.setLevelName(RiskLevel.valueOf(RiskLevel.class, old.getRiskLevel()).desc());//评级name
        } else {
            vo.setLevelId(""); //评级id
            vo.setLevelName("");//评级name
        }
        vo.setJijinId(String.valueOf(old.getFundProductId() == null ? "" : old.getFundProductId()));
        vo.setJijinName(old.getFundProductName() == null ? "" : old.getFundProductName());
        vo.setJijinPercent(String.valueOf(old.getFundWeight() == null ? "" : old.getFundWeight()));
        vo.setGushouId(String.valueOf(old.getExchangeProductId() == null ? "" : old.getExchangeProductId()));
        vo.setGushouName(old.getExchangeProductName() == null ? "" : old.getExchangeProductName());
        vo.setGushouPercent(String.valueOf(old.getExchangeProductWeight() == null ? "" : old.getExchangeProductWeight()));
        vo.setQitouAmount(String.valueOf(old.getInvestAmount() == null ? "" : old.getInvestAmount()));
        vo.setStepAmount(String.valueOf(old.getIncreaseAmount() == null ? "" : old.getIncreaseAmount()));
        vo.setStatusId(old.getStatus() == null ? "" : old.getStatus());
        if (old.getCreateTime() != null) {  //
            vo.setCreateTime(DateUtils.formatDatetime(old.getCreateTime()));
        } else {
            vo.setCreateTime("");
        }
        if (old.getModifyTime() != null) {  //
            vo.setUpdateTime(DateUtils.formatDatetime(old.getModifyTime()));
        } else {
            vo.setUpdateTime("");
        }
        vo.setCreaterName(old.getOperator() == null ? "" : old.getOperator());
        return vo;
    }

    public static List<FundGroupListVo> convertFundGroupQy(List<QueryProductGroupByConditionVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<FundGroupListVo> lists = new ArrayList<FundGroupListVo>();
        for (QueryProductGroupByConditionVO m : params) {
            FundGroupListVo u = convertFundGroupQy(m);
            lists.add(u);
        }
        return lists;
    }


    public static FundGroupListVo convertFundGroupQyById(QueryProductGroupByIdResponse old) {
        FundGroupListVo vo = new FundGroupListVo();
        vo.setId(String.valueOf(old.getId() == null ? "" : old.getId()));
        if (StringUtils.isNotBlank(old.getRiskLevel())) {
            vo.setLevelId(old.getRiskLevel() == null ? "" : old.getRiskLevel()); //评级id
            vo.setLevelName(RiskLevel.valueOf(RiskLevel.class, old.getRiskLevel()).desc());//评级name
        } else {
            vo.setLevelId(""); //评级id
            vo.setLevelName("");//评级name
        }
        vo.setJijinId(String.valueOf(old.getFundProductId() == null ? "" : old.getFundProductId()));
        vo.setJijinName(old.getFundProductName() == null ? "" : old.getFundProductName());
        vo.setJijinPercent(String.valueOf(old.getFundWeight() == null ? "" : old.getFundWeight()));
        vo.setJijinLabel(old.getFundTag()==null?"":old.getFundTag());
        vo.setGushouId(String.valueOf(old.getExchangeProductId() == null ? "" : old.getExchangeProductId()));
        vo.setGushouName(old.getExchangeProductName() == null ? "" : old.getExchangeProductName());
        vo.setGushouPercent(String.valueOf(old.getExchangeProductWeight() == null ? "" : old.getExchangeProductWeight()));
        vo.setGushouLabel(old.getExchangeProductTag()==null?"":old.getExchangeProductTag());
        vo.setQitouAmount(String.valueOf(old.getInvestAmount() == null ? "" : old.getInvestAmount()));
        vo.setStepAmount(String.valueOf(old.getIncreaseAmount() == null ? "" : old.getIncreaseAmount()));
        vo.setStatusId(old.getStatus() == null ? "" : old.getStatus());
        return vo;
    }


    //基金模糊查询
    public static QueryFundProductVo convertFundProductQy(QueryLiveProductByNameVO old) {
        QueryFundProductVo vo = new QueryFundProductVo();
        vo.setId(String.valueOf(old.getProductId() == null ? "" : old.getProductId()));
        vo.setName(old.getProductName() == null ? "" : old.getProductName());
        return vo;
    }

    public static List<QueryFundProductVo> convertFundProductQy(List<QueryLiveProductByNameVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<QueryFundProductVo> lists = new ArrayList<QueryFundProductVo>();
        for (QueryLiveProductByNameVO m : params) {
            QueryFundProductVo u = convertFundProductQy(m);
            lists.add(u);
        }
        return lists;
    }


    //固收模糊查询
    public static QuerySolidProductVo convertSolidProductQy(QueryExchangeProductByNameVO old) {
        QuerySolidProductVo vo = new QuerySolidProductVo();
        vo.setId(String.valueOf(old.getExchangeProductId() == null ? "" : old.getExchangeProductId()));
        vo.setName(old.getExchangeProductName() == null ? "" : old.getExchangeProductName());
        vo.setQitouAmount(String.valueOf(old.getInvestAmount()==null?"":old.getInvestAmount()));
        vo.setStepAmount(String.valueOf(old.getIncreaseAmount()==null?"":old.getIncreaseAmount()));
        return vo;
    }

    public static List<QuerySolidProductVo> convertSolidProductQy(List<QueryExchangeProductByNameVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<QuerySolidProductVo> lists = new ArrayList<QuerySolidProductVo>();
        for (QueryExchangeProductByNameVO m : params) {
            QuerySolidProductVo u = convertSolidProductQy(m);
            lists.add(u);
        }
        return lists;
    }

    /*

        public static final RiskLevel None = new RiskLevel("0", "未评估");
        public static final RiskLevel Low = new RiskLevel("1", "保守型");
        public static final RiskLevel MidLow = new RiskLevel("2", "稳健型");
        public static final RiskLevel Middle = new RiskLevel("3", "平衡型");
        public static final RiskLevel MidHign = new RiskLevel("4", "成长型");
        public static final RiskLevel Hign = new RiskLevel("5", "进取型");
        评级
    */
    public static List<StateVo> getLevelList() {
        List<StateVo> list = new ArrayList<>();
        StateVo vo = new StateVo();
        vo.setId("1");
        vo.setName("保守型");
        list.add(vo);
        vo = new StateVo();
        vo.setId("2");
        vo.setName("稳健型");
        list.add(vo);
        vo = new StateVo();
        vo.setId("3");
        vo.setName("平衡型");
        list.add(vo);
        vo = new StateVo();
        vo.setId("4");
        vo.setName("成长型");
        list.add(vo);
        vo = new StateVo();
        vo.setId("5");
        vo.setName("进取型");
        list.add(vo);
        return list;
    }
}
