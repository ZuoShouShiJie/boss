package com.maiziyun.boss.facade.common.enums;

import com.maiziyun.common.enums.MyServiceCode;
import com.solar.framework.core.base.AbstractEnum;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.enums.ServiceCode;

/**
 * Created by len.song on 2016/11/30.
 */
public class BossBizCode extends BizCode{
    //操作员返回码[001-050]
        //登录有关
    public static final BizCode Success = new BossBizCode("Success","000", MyServiceCode.Boss,"成功");
    public static final BizCode operEmpty = new BossBizCode("operEmpty","001", MyServiceCode.Boss,"操作员不存在");
    public static final BizCode operOrPassError = new BossBizCode("operOrPassError","002", MyServiceCode.Boss,"用户名或密码错误");
    public static final BizCode loginUserNameNull = new BossBizCode("loginUserNameNull","014", MyServiceCode.Boss,"登录账号名称为空");
        //实体操作
    public static final BizCode GetOperByNameNull = new BossBizCode("GetOperByNameNull","003", MyServiceCode.Boss,"根据操作员名称获取操作员对象为空");
    public static final BizCode GetOperByIdNull = new BossBizCode("GetOperByIdNull","004", MyServiceCode.Boss,"根据操作员Id获取操作员对象为空");
    public static final BizCode OperatorNameNull = new BossBizCode("OperatorNameNull","005", MyServiceCode.Boss,"操作员账号名为空");
    public static final BizCode OperatorIdNull = new BossBizCode("OperatorIdNull","006", MyServiceCode.Boss,"操作员编号为空");
    public static final BizCode GetOperPagesNull = new BossBizCode("GetOperPagesNull","007", MyServiceCode.Boss,"通过多条件查询系统用户分页为空");
    public static final BizCode OperatorPassNull = new BossBizCode("OperatorPassNull","008", MyServiceCode.Boss,"操作员密码为空");
    public static final BizCode OperatorStatusNull = new BossBizCode("OperatorStatusNull","009", MyServiceCode.Boss,"操作员状态为空");
    public static final BizCode ValidUserExist = new BossBizCode("ValidUserExist","010", MyServiceCode.Boss,"该用户名已存在");
    public static final BizCode OperatorRealNameNull = new BossBizCode("OperatorRealNameNull","011", MyServiceCode.Boss,"操作员姓名为空");
    public static final BizCode modifyPassNotSame = new BossBizCode("modifyPassNotSame","012", MyServiceCode.Boss,"两次密码输入不一致");
    public static final BizCode oldPassNotSameNewPass = new BossBizCode("oldPassNotSameNewPass","013", MyServiceCode.Boss,"老密码和新密码不一致");
    public static final BizCode RedisCache = new BossBizCode("RedisCache","015", MyServiceCode.Boss,"redis存储数据失败");
    public static final BizCode LoginFail = new BossBizCode("LoginFail","016", MyServiceCode.Boss,"登录失败");
    public static final BizCode PicFileSize = new BossBizCode("PicFileSize","017", MyServiceCode.Boss,"上传图片大于2M,不能上传");
    public static final BizCode upImgFail = new BossBizCode("upImgFail","018", MyServiceCode.Boss,"图片上传失败");
    public static final BizCode TokenLoginFail = new BossBizCode("TokenLoginFail","019", MyServiceCode.Boss,"Token失效");
    public static final BizCode LengthMore40 = new BossBizCode("lengthMore40","020", MyServiceCode.Boss,"长度超过40个汉字");//组合
    public static final BizCode LengthMore200 = new BossBizCode("LengthMore200","021", MyServiceCode.Boss,"长度超过200个汉字");//组合
    public static final BizCode LengthMore3 = new BossBizCode("LengthMore3","022", MyServiceCode.Boss,"长度超过三个标签");  //组合
    public static final BizCode LengthMore5 = new BossBizCode("LengthMore5","023", MyServiceCode.Boss,"标签超过5个汉字");//组合
    public static final BizCode LengthEqlNull = new BossBizCode("LengthEqlNull","024", MyServiceCode.Boss,"至少要配置一个基金");  //基金
    public static final BizCode LengthMore10 = new BossBizCode("LengthMore10","025", MyServiceCode.Boss,"最多可配置10款基金");//基金
    public static final BizCode LengthMoreEff3 = new BossBizCode("LengthMoreEff3","026", MyServiceCode.Boss,"只可以勾选3个有效的基金产品");//基金
    public static final BizCode LaLengthEqlNull = new BossBizCode("LaLengthEqlNull","027", MyServiceCode.Boss,"至少设置一个标签");  //基金
    public static final BizCode LaLengthMore3 = new BossBizCode("LaLengthMore3","028", MyServiceCode.Boss,"至多设置3个标签");//基金
    public static final BizCode LaLengthMore10 = new BossBizCode("LaLengthMore10","032", MyServiceCode.Boss,"长度超过10个汉字");//基金

    public static final BizCode LaLengthMore25 = new BossBizCode("LaLengthMore25","029", MyServiceCode.Boss,"每个标签至多五个汉字，至少两个汉字");//基金
    public static final BizCode FofLengthMore1 = new BossBizCode("FofLengthMore1","030", MyServiceCode.Boss,"至少勾选一个策略");//组合
    public static final BizCode NotiLengthMore300 = new BossBizCode("NotiLengthMore300","031",MyServiceCode.Boss,"长度超过300字符");//公告首页
    public static final BizCode DateError = new BossBizCode("DateError","033",MyServiceCode.Boss,"结束时间不能小于当前时间");//公告首页
    public static final BizCode showOrder = new BossBizCode("showOrder","034",MyServiceCode.Boss,"必选在1~99");//广告位
    public static final BizCode dataIsNull = new BossBizCode("dataIsNull","035",MyServiceCode.Boss,"查询数据为空");//网贷
    public static final BizCode WeighTotal = new BossBizCode("WeighTotal","036",MyServiceCode.Boss,"基金和交易所权重之和必须等于100");


    //角色返回码[051-100]
    public static final BizCode RoleIdNull = new BossBizCode("RoleIdNull","051", MyServiceCode.Boss,"角色编号为空");
    public static final BizCode GetRolePagesNull = new BossBizCode("GetRolePagesNull","052", MyServiceCode.Boss,"通过多条件查询角色分页为空");
    public static final BizCode GetRoleByOperNameNull = new BossBizCode("GetRoleByOperNameNull","053", MyServiceCode.Boss,"根据操作员名称获取角色对象为空");

    //菜单返回码[101-150]

    //用户相关返回码[151-200]
    public static final BizCode GetUserPagesNull = new BossBizCode("GetUserPagesNull","151", MyServiceCode.Boss,"用户信息列表数据为空");
    public static final BizCode GetUserTransPagesNull = new BossBizCode("GetUserTransPagesNull","152", MyServiceCode.Boss,"用户交易列表数据为空");
    public static final BizCode GetUserBalanceListsNull = new BossBizCode("GetUserBalanceListsNull","153", MyServiceCode.Boss,"财神宝余额列表为空");
    public static final BizCode GetUserHoldFundListsNull = new BossBizCode("GetUserHoldFundListsNull","154", MyServiceCode.Boss,"用户持有基金列表为空");
    public static final BizCode GetUserBindCardNull = new BossBizCode("GetUserBindCardNull","155", MyServiceCode.Boss,"用户绑卡列表为空");

    //产品相关返回码[201-250]
    public static final BizCode GetProductPagesNull = new BossBizCode("GetProductPagesNull","201", MyServiceCode.Boss,"获取产品分页列表为空");
    public static final BizCode GetProHisNavPagesNull = new BossBizCode("GetProHisNavPagesNull","202", MyServiceCode.Boss,"获取产品净值分页列表为空");
    public static final BizCode ProductIdIsNull = new BossBizCode("ProductIdIsNull","203", MyServiceCode.Boss,"产品编号为为空");
    public static final BizCode ProAttrKindNull = new BossBizCode("ProAttrKindNull","204", MyServiceCode.Boss,"产品属性类型为空");
    public static final BizCode ProAttrRelPageNull = new BossBizCode("ProAttrRelPageNull","205", MyServiceCode.Boss,"获取基金管理分页列表为空");
    public static final BizCode ProductStatusIs = new BossBizCode("ProductStatusIs","206", MyServiceCode.Boss,"数据异常，请刷新后重试~");

    //交易所
    public static final BizCode GetProductByFundIsNull = new BossBizCode("GetProductByFundIsNull","207", MyServiceCode.Boss,"通过基金code和基金简称获取产品列表为空");

    //交易相关返回码[251-300]

    public static final BizCode Unknown = new BossBizCode("Unknown","999", MyServiceCode.Boss,"未知异常");




    public BossBizCode() {
    }

    public BossBizCode(String name, String code, ServiceCode serviceCode, String desc) {
        super(name, code, serviceCode, desc);
    }

    @Override
    protected Class<? extends AbstractEnum> getEnumType() {
        return BossBizCode.class;
    }
}
