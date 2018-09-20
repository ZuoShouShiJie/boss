package com.maiziyun.boss.biz.jysmng.convert;

import com.maiziyun.boss.common.utils.DateUtils;
import com.maiziyun.boss.facade.common.model.vo.StateVo;
import com.maiziyun.boss.facade.jysmng.model.vo.*;
import com.maiziyun.cif.facade.model.vo.CustomerVo;
import com.maiziyun.fund.trade.facade.model.vo.FixedProductAssetInfo;
import com.maiziyun.product.facade.enums.InterestCycle;
import com.maiziyun.product.facade.model.vo.*;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/11/6.
 */
public class JYSMngConverter {

    public static J2PGetFundFlowVo convertFund(J2PMgwGetFundFlowVo old, String name) {
        J2PGetFundFlowVo vo = new J2PGetFundFlowVo();
        vo.setUserName(name == null ? "" : name); //用户名
        vo.setOppositeName(old.getOppOutUserNo() == null ? "" : old.getOppOutUserNo()); //对手用户名
      /*  FAE_TRANS_UNFREEZE("fae_trans_unfreeze", "交易所购买-满标放款解冻", "080302"),
                FAE_TRANS("fae_trans", "交易所购买-满标放款转账", "080303"),
                FAE_BIDDER_FREEZE("fae_bidder_freeze", "交易所购买-冻结", "080301"),
                FAE_RECHARGE_CREDIT("fae_recharge_credit", "交易所充值-入账", "010301")*/
        if ("080302".equals(old.getTransCode())) { //   交易类型
            vo.setTypeName("交易所购买-满标放款解冻");
        } else if ("080303".equals(old.getTransCode())) {
            vo.setTypeName("交易所购买-满标放款转账");
        } else if ("080301".equals(old.getTransCode())) {
            vo.setTypeName("交易所购买-冻结");
        } else if ("010301".equals(old.getTransCode())) {
            vo.setTypeName("交易所充值-入账");
        } else {
            vo.setTypeName("");
        }
        //资金方向，C-收入，D-支出，F-冻结，U-解冻
        if ("C".equals(old.getDcFlag())) {
            vo.setEarnings(old.getAmount() == null ? "" : old.getAmount().toString());
            vo.setExpend("");
        } else if ("D".equals(old.getDcFlag())) {
            vo.setExpend(old.getAmount() == null ? "" : old.getAmount().toString());
            vo.setEarnings("");
        } else {
            vo.setEarnings("");
            vo.setExpend("");
        }
        vo.setComment(old.getRemark() == null ? "" : old.getRemark());//备注
        vo.setDate(old.getCreateTime() == null ? "" : old.getCreateTime());
        vo.setBalance(old.getBalance() == null ? "" : old.getBalance());
        vo.setFrozenBalance(old.getFreezeAmount() == null ? "" : old.getFreezeAmount());
        return vo;
    }

    public static List<J2PGetFundFlowVo> convertFund(List<J2PMgwGetFundFlowVo> params, String name) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<J2PGetFundFlowVo> lists = new ArrayList<J2PGetFundFlowVo>();
        for (J2PMgwGetFundFlowVo m : params) {
            J2PGetFundFlowVo u = convertFund(m, name);
            lists.add(u);
        }
        return lists;
    }

    //资金记录
    public static J2PQueryUserMsgVo convertUserQy(CustomerVo old) {
        J2PQueryUserMsgVo vo = new J2PQueryUserMsgVo();
        vo.setId(old.getUserId() == null ? "" : old.getUserId());
        vo.setUserName(old.getLoginName() == null ? "" : old.getLoginName());//用户名
        vo.setName(old.getName() == null ? "" : old.getName());//姓名
        vo.setMobile(old.getMobile() == null ? "" : old.getMobile());
        return vo;
    }

    public static List<J2PQueryUserMsgVo> convertUserQy(List<CustomerVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<J2PQueryUserMsgVo> lists = new ArrayList<J2PQueryUserMsgVo>();
        for (CustomerVo m : params) {
            J2PQueryUserMsgVo u = convertUserQy(m);
            lists.add(u);
        }
        return lists;
    }

    public static ProjectConfQueryVo convertQryProject(QueryExchangeProjectByConditionVO old) {
        ProjectConfQueryVo vo = new ProjectConfQueryVo();
        vo.setExchangeProjectId(String.valueOf(old.getProjectId() == null ? "" : old.getProjectId())); //项目编号
        vo.setExchangeId(String.valueOf(old.getExchangeId() == null ? "" : old.getExchangeId()));
        vo.setExchangeName(old.getExchangeName() == null ? "" : old.getExchangeName());  //交易所名称
        vo.setProjectName(old.getProjectName() == null ? "" : old.getProjectName());  //项目名称
        vo.setProductCycle(String.valueOf(old.getProjectCycle() == null ? "" : old.getProjectCycle()));   //产品周期
        vo.setAnnualRate(old.getAnnualRate() == null ? "" : old.getAnnualRate());  //年化收益率
        vo.setReceiveAccount(old.getPayeeAccount() == null ? "" : old.getPayeeAccount());//收款人账户
        if (StringUtils.isNotBlank(old.getRepayType())) { //还款方式RepayType
            if ("1".equals(old.getRepayType())) {
                vo.setRepayTypeId("1");
                vo.setRepayTypeName("一次性还本付息");
            } else {
                vo.setRepayTypeId("");
                vo.setRepayTypeName("");
            }
        } else {
            vo.setRepayTypeId("");
            vo.setRepayTypeName("");
        }
        vo.setReleasemanId(String.valueOf(old.getPublisherId() == null ? "" : old.getPublisherId()));  //发行人
        vo.setReleasemanName(old.getPublisherName() == null ? "" : old.getPublisherName());
        if (old.getTimeLimit() != null) { //期限ExchangeTimeLimit
            if ("0".equals(String.valueOf(old.getTimeLimit()))) {
                vo.setDeadlineTypeId("0");
                vo.setDeadlineTypeName("固定期限");
            }

        } else {
            vo.setDeadlineTypeId("");
            vo.setDeadlineTypeName("");
        }
        if (old.getInterestAccrualUnit() != null) {//计息单位
            if ("360".equals(String.valueOf(old.getInterestAccrualUnit()))) {
                vo.setInterestUnitId("360");
                vo.setInterestUnitName("360天");
            }
            if ("365".equals(String.valueOf(old.getInterestAccrualUnit()))) {
                vo.setInterestUnitId("365");
                vo.setInterestUnitName("365天");
            }
        } else {
            vo.setInterestUnitId("");
            vo.setInterestUnitName("");
        }
        vo.setProjectAmount(String.valueOf(old.getTotalAmount() == null ? "" : old.getTotalAmount()));  //项目总额度
        if (old.getCreateTime() != null) {
            vo.setCreateTime(DateUtils.formatDatetime(old.getCreateTime()));  //创建时间
        } else {
            vo.setCreateTime("");
        }
        if (old.getModifyTime() != null) {
            vo.setModifyTime(DateUtils.formatDatetime(old.getModifyTime()));//更新时间
        } else {
            vo.setModifyTime("");
        }

        vo.setStatusId(old.getStatus() == null ? "" : old.getStatus()); //状态
        vo.setOperator(old.getOperator() == null ? "" : old.getOperator()); //操作人
        //项目协议  private List<ProjectProtocolVo> protocolList; //项目协议
        List<ProjectProtocolVo> protocolList = new ArrayList<>(); //项目协议
        if (old.getContractInfos() != null && old.getContractInfos().size() > 0) {
            for (UpdateExchangeProjectContractVO contractVO : old.getContractInfos()) {
                ProjectProtocolVo protocolVo = new ProjectProtocolVo();
                protocolVo.setName(contractVO.getFileName() == null ? "" : contractVO.getFileName());
                protocolVo.setUrl(contractVO.getFileUrl() == null ? "" : contractVO.getFileUrl());
                protocolVo.setType(contractVO.getContractType() == null ? "" : contractVO.getContractType());
                protocolList.add(protocolVo);
            }
        }

        vo.setProtocolList(protocolList);

        return vo;
    }

    public static List<ProjectConfQueryVo> convertQryProject(List<QueryExchangeProjectByConditionVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<ProjectConfQueryVo> lists = new ArrayList<ProjectConfQueryVo>();
        for (QueryExchangeProjectByConditionVO m : params) {
            ProjectConfQueryVo u = convertQryProject(m);
            lists.add(u);
        }
        return lists;
    }


    public static StateVo convertQryEx(QueryAllExchangeVO old) {
        StateVo vo = new StateVo();
        if (old.getExchangeId() != null) {
            vo.setId(String.valueOf(old.getExchangeId()));
        } else {
            vo.setName("");
        }
        vo.setName(old.getExchangeName());

        return vo;
    }

    public static List<StateVo> convertQryEx(List<QueryAllExchangeVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<StateVo> lists = new ArrayList<StateVo>();
        for (QueryAllExchangeVO m : params) {
            StateVo u = convertQryEx(m);
            lists.add(u);
        }
        return lists;
    }

    public static StateVo convertQryPub(QueryExchangePublisherInfoVO old) {
        StateVo vo = new StateVo();
        if (old.getId() != null) {
            vo.setId(String.valueOf(old.getId()));
        } else {
            vo.setId("");
        }
        vo.setName(old.getPublisherName());
        return vo;
    }

    public static List<StateVo> convertQryPub(List<QueryExchangePublisherInfoVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<StateVo> lists = new ArrayList<StateVo>();
        for (QueryExchangePublisherInfoVO m : params) {
            StateVo u = convertQryPub(m);
            lists.add(u);
        }
        return lists;
    }

    public static ProductConfQueryVo convertQryProduct(QueryExchangeProductVO old) {
        ProductConfQueryVo vo = new ProductConfQueryVo();

        vo.setProductId(String.valueOf(old.getProductId() == null ? "" : old.getProductId())); //产品id
        vo.setProductName(old.getProductName() == null ? "" : old.getProductName());  //产品名称
        vo.setExchangeId(String.valueOf(old.getExchangeId() == null ? "" : old.getExchangeId())); //交易所id
        vo.setExchangeName(old.getExchangeName() == null ? "" : old.getExchangeName()); //交易所名称
        vo.setExchangeProjectId(String.valueOf(old.getExchangeProjectId() == null ? "" : old.getExchangeProjectId()));
        vo.setProjectName(old.getExchangeProjectName() == null ? "" : old.getExchangeProjectName());
        vo.setInterestUnitId(String.valueOf(old.getInterestAccrualUnit() == null ? "" : old.getInterestAccrualUnit()));
        vo.setInterestUnitName(InterestCycle.valueOf(InterestCycle.class, String.valueOf(old.getInterestAccrualUnit())).desc());

        vo.setPlanRaiseFund(String.valueOf(old.getRaiseFund() == null ? "" : old.getRaiseFund()));
        vo.setRemainRainAmount(String.valueOf(old.getResidualAmount() == null ? "" : old.getResidualAmount()));
        if (old.getReleaseTime() != null) {  //发布时间
            vo.setReleaseTime(DateUtils.formatDatetime(old.getReleaseTime()));
        } else {
            vo.setReleaseTime("");
        }
        if (old.getRaiseStartTime() != null) {   //募集开始时间
            vo.setRaiseStartTime(DateUtils.formatDatetime(old.getRaiseStartTime()));
        } else {
            vo.setRaiseStartTime("");
        }
        if (old.getRaiseEndTime() != null) {
            vo.setRaiseEndTime(DateUtils.formatDatetime(old.getRaiseEndTime()));
        } else {
            vo.setRaiseEndTime("");
        }
        vo.setInvestAmount(String.valueOf(old.getInvestAmount() == null ? "" : old.getInvestAmount()));
        vo.setIncreaseAmount(String.valueOf(old.getIncreaseAmount() == null ? "" : old.getIncreaseAmount()));
        vo.setIsLimitAmount(old.getLimitAmountType() == null ? "" : old.getLimitAmountType()); //是否限额
        vo.setLimitAmount(String.valueOf(old.getLimitAmount() == null ? "" : old.getLimitAmount()));
        if (StringUtils.isNotBlank(old.getRepayType())) { //还款方式RepayType
            if ("1".equals(old.getRepayType())) {
                vo.setRepayTypeId("1");
                vo.setRepayTypeName("一次性还本付息");
            } else {
                vo.setRepayTypeId("");
                vo.setRepayTypeName("");
            }
        } else {
            vo.setRepayTypeId("");
            vo.setRepayTypeName("");
        }
        if (old.getCreateTime() != null) {
            vo.setCreateTime(DateUtils.formatDatetime(old.getCreateTime()));  //创建时间
        } else {
            vo.setCreateTime("");
        }
        if (old.getModifyTime() != null) {
            vo.setModifyTime(DateUtils.formatDatetime(old.getModifyTime()));//更新时间
        } else {
            vo.setModifyTime("");
        }
        vo.setAnnualRate(old.getAnnualRate() == null ? "" : old.getAnnualRate());//年化率
        vo.setProductCycle(String.valueOf(old.getInterestCycle() == null ? "" : old.getInterestCycle())); //产品周期
        if (old.getIsSupportRightsTransfer() != null) { //是否支持债转
            if ("0".equals(old.getIsSupportRightsTransfer())) {
                vo.setIsSupportRightsTransferId("0"); //否
                vo.setIsSupportRightsTransferName("否");
            }
            if ("1".equals(old.getIsSupportRightsTransfer())) {
                vo.setIsSupportRightsTransferId("1"); //是
                vo.setIsSupportRightsTransferName("是");
            }
        } else {
            vo.setIsSupportRightsTransferId("");
            vo.setIsSupportRightsTransferName("");
        }
        if (old.getShowFlag() != null) {
            if ("0".equals(old.getShowFlag())) {
                vo.setIsShowId("0");  //显示
                vo.setIsShowName("是");
            }
            if ("1".equals(old.getShowFlag())) {
                vo.setIsShowId("1");  //显示
                vo.setIsShowName("否");
            }
        } else {
            vo.setIsShowId("");
            vo.setIsShowName("");
        }
        vo.setProductStatusId(old.getProductStatus() == null ? "" : old.getProductStatus()); //状态
        vo.setProductStatusName(old.getProductStatusDesc() == null ? "" : old.getProductStatusDesc());
        vo.setOpeartor(old.getOperator() == null ? "" : old.getOperator());
        vo.setContent(old.getProductDesc() == null ? "" : old.getProductDesc());
        return vo;
    }

    public static List<ProductConfQueryVo> convertQryProduct(List<QueryExchangeProductVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<ProductConfQueryVo> lists = new ArrayList<ProductConfQueryVo>();
        for (QueryExchangeProductVO m : params) {
            ProductConfQueryVo u = convertQryProduct(m);
            lists.add(u);
        }
        return lists;
    }

    public static QueryProjectAllVo convertQryProductAllBy(QueryExchangeProjectByExchangeVO old) {
        QueryProjectAllVo vo = new QueryProjectAllVo();
        if (old.getProjectId() != null) {
            vo.setExchangeProjectId(String.valueOf(old.getProjectId()));
        } else {
            vo.setExchangeProjectId("");
        }
        vo.setProjectName(old.getProjectName() == null ? "" : old.getProjectName());
        vo.setAnnualRate(old.getAnnualRate() == null ? "" : old.getAnnualRate());
        vo.setProductCycle(String.valueOf(old.getProductCycle() == null ? "" : old.getProductCycle()));//产品周期
        if (old.getInterestAccrualUnit() != null) {
            vo.setInterestUnitId(String.valueOf(old.getInterestAccrualUnit()));//计息单位
        } else {
            vo.setInterestUnitId("");
        }
        return vo;
    }

    public static List<QueryProjectAllVo> convertQryProductAllBy(List<QueryExchangeProjectByExchangeVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<QueryProjectAllVo> lists = new ArrayList<QueryProjectAllVo>();
        for (QueryExchangeProjectByExchangeVO m : params) {
            QueryProjectAllVo u = convertQryProductAllBy(m);
            lists.add(u);
        }
        return lists;
    }

    /**
     * 协议类型查询列表
     *
     * @param old
     * @return
     */
    public static StateVo convertQryPro(ProjectContractVO old) {
        StateVo vo = new StateVo();
        vo.setId(old.getKey() == null ? "" : old.getKey());
        vo.setName(old.getDictDesc() == null ? "" : old.getDictDesc());
        return vo;
    }

    public static List<StateVo> convertQryPro(List<ProjectContractVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<StateVo> lists = new ArrayList<>();
        for (ProjectContractVO m : params) {
            StateVo u = convertQryPro(m);
            lists.add(u);
        }
        return lists;
    }


    /**
     * 用户投资列表查询
     */
    public static UserInvestListVo convertUserInvestList(FixedProductAssetInfo old) {
        UserInvestListVo vo = new UserInvestListVo();
        vo.setExchangeName(old.getExchangeName() == null ? "" : old.getExchangeName());//交易所名称
        vo.setProductId(String.valueOf(old.getProductId() == null ? "" : old.getProductId()));//理财产品编号
        vo.setOrderNo(old.getOuterOrder() == null ? "" : old.getOuterOrder());//块钱订单号
        vo.setMobile(old.getMobile() == null ? "" : old.getMobile());//手机号
        vo.setUserName(old.getUserName() == null ? "" : old.getUserName());//投资人姓名
        vo.setInvestAmount(String.valueOf(old.getAmount() == null ? "" : old.getAmount()));//投资金额
        if (old.getApplyTime() != null) {
            vo.setInvestTime(DateUtils.formatDatetime(old.getApplyTime()));//投资时间
        } else {
            vo.setInvestTime("");
        }
        vo.setInvestType(old.getPayWay() == null ? "" : old.getPayWay());//投资方式
        vo.setProductName(old.getProductName() == null ? "" : old.getProductName());//投资产品名称

        vo.setRaiseStartTime(old.getRecruitmentStartTime() == null ? "" : old.getRecruitmentStartTime());//募集开始时间o

        vo.setRaiseEndTime(old.getRecruitmentEndTime() == null ? "" : old.getRecruitmentEndTime());//募集结束时间
        if (old.getProfitStartTime() != null) {
            vo.setInterestStartTime(DateUtils.formatDatetime(old.getProfitStartTime()));//计息开始时间
        } else {
            vo.setInterestStartTime("");
        }
        if (old.getProfitEndTime() != null) {
            vo.setInterestEndTime(DateUtils.formatDatetime(old.getProfitEndTime()));//计息结束时间
        } else {
            vo.setInterestEndTime("");
        }
        vo.setExpectEarnings(String.valueOf(old.getExpectedAmount() == null ? "" : old.getExpectedAmount()));//预期到账收益
        vo.setInvestStatus(old.getProductStatusName() == null ? "" : old.getProductStatusName());//投资状态
        return vo;
    }

    public static List<UserInvestListVo> convertUserInvestList(List<FixedProductAssetInfo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<UserInvestListVo> lists = new ArrayList<UserInvestListVo>();
        for (FixedProductAssetInfo m : params) {
            UserInvestListVo u = convertUserInvestList(m);
            lists.add(u);
        }
        return lists;
    }


    /**
     * 还款方式
     *
     * @return
     */
    public static List<StateVo> repayTypeList() {
        StateVo vo = new StateVo();
        List<StateVo> list = new ArrayList<>();
        vo.setId("1");
        vo.setName("一次性还本付息");
        list.add(vo);
        return list;
    }

    /**
     * 期限
     *
     * @return
     */
    public static List<StateVo> deadlineList() {
        StateVo vo = new StateVo();
        List<StateVo> list = new ArrayList<>();
        vo.setId("0");
        vo.setName("固定期限");
        list.add(vo);
        return list;
    }

    /**
     * 计息单位
     *
     * @return
     */
    public static List<StateVo> interestUnitList() {
        List<StateVo> list = new ArrayList<>();
        StateVo vo = new StateVo();
        vo.setId("360");
        vo.setName("360天");
        list.add(vo);
        vo = new StateVo();
        vo.setId("365");
        vo.setName("365天");
        list.add(vo);
        return list;
    }

    /**
     * 产品状态
     *
     * @return
     */
    public static List<StateVo> productStatusList() {
        List<StateVo> list = new ArrayList<>();
        StateVo vo = new StateVo();
        vo.setId("1");
        vo.setName("未发布");
        list.add(vo);
        vo = new StateVo();
        vo.setId("2");
        vo.setName("发布未募集");
        list.add(vo);
        vo = new StateVo();
        vo.setId("3");
        vo.setName("募集中");
        list.add(vo);
        vo = new StateVo();
        vo.setId("4");
        vo.setName("募集结束");
        list.add(vo);
        vo = new StateVo();
        vo.setId("5");
        vo.setName("计息中");
        list.add(vo);
        vo = new StateVo();
        vo.setId("6");
        vo.setName("待结算");
        list.add(vo);
        vo = new StateVo();
        vo.setId("7");
        vo.setName("结算完成");
        list.add(vo);
        vo = new StateVo();
        vo.setId("8");
        vo.setName("募集失败");
        list.add(vo);
        return list;
    }

    /**
     * 是否可见
     * ShowFlag
     *
     * @return
     */
    public static List<StateVo> isShowList() {
        List<StateVo> list = new ArrayList<>();
        StateVo vo = new StateVo();
        vo.setId("0");
        vo.setName("是");
        list.add(vo);
        vo = new StateVo();
        vo.setId("1");
        vo.setName("否");
        list.add(vo);
        return list;
    }

    /**
     * ExchangeProductControlSwitch
     *
     * @return
     */
    public static List<StateVo> isSupportList() {
        List<StateVo> list = new ArrayList<>();
        StateVo vo = new StateVo();
        vo.setId("0");
        vo.setName("否");
        list.add(vo);
        vo = new StateVo();
        vo.setId("1");
        vo.setName("是");
        list.add(vo);
        return list;
    }

    //新增时协议上传
    public static List<ExchangeProjectContractVO> convertProtoAdd(List<ProjectProtocolVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<ExchangeProjectContractVO> lists = new ArrayList<>();
        for (ProjectProtocolVo m : params) {
            ExchangeProjectContractVO vo = new ExchangeProjectContractVO();
            vo.setFileName(m.getName());
            vo.setFileUrl(m.getUrl());
            vo.setContractType(m.getType());
            lists.add(vo);
        }
        return lists;
    }

    //修改时协议上传
    public static List<UpdateExchangeProjectContractVO> convertProtoUpdate(List<ProjectProtocolVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<UpdateExchangeProjectContractVO> lists = new ArrayList<>();
        for (ProjectProtocolVo m : params) {
            UpdateExchangeProjectContractVO vo = new UpdateExchangeProjectContractVO();
            vo.setFileName(m.getName());
            vo.setFileUrl(m.getUrl());
            vo.setContractType(m.getType());
            lists.add(vo);
        }
        return lists;
    }


}
