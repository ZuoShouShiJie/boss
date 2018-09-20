package com.maiziyun.boss.biz.product.convert;

import com.maiziyun.boss.biz.common.CommonUtils;
import com.maiziyun.boss.facade.product.model.vo.FirP2PLoanListVo;
import com.maiziyun.boss.facade.product.model.vo.P2PLoanListVo;
import com.maiziyun.product.facade.enums.ProductP2PStatus;
import com.maiziyun.product.facade.model.vo.ProductP2PInfoConfigVo;
import com.maiziyun.product.facade.model.vo.ProductP2PInfoSortVo;
import com.maiziyun.product.facade.model.vo.ProductP2PInfoVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/9/1.
 */
public class P2PLoanConverter {
    public static List<P2PLoanListVo> convertQy(List<ProductP2PInfoVo> productP2PInfoVoList) {
        List<P2PLoanListVo> p2PLoanListVoList = new ArrayList<>();
        for (ProductP2PInfoVo vo : productP2PInfoVoList) {
            P2PLoanListVo p2PLoanListVo = converQy(vo);
            p2PLoanListVoList.add(p2PLoanListVo);
        }

        return p2PLoanListVoList;
    }

    public static P2PLoanListVo converQy(ProductP2PInfoVo vo) {
        P2PLoanListVo p2PLoanListVo = new P2PLoanListVo();
        p2PLoanListVo.setProductName(vo.getProductP2pName() == null ? "" : vo.getProductP2pName());
        p2PLoanListVo.setProductId(vo.getProductP2pId() == null ? "" : String.valueOf(vo.getProductP2pId()));
        if ("1".equals(vo.getExpectUnit())) {//产品期限
            p2PLoanListVo.setDeadline(vo.getExpect() + "天");
        } else if ("0".equals(vo.getExpectUnit())) {
            p2PLoanListVo.setDeadline(vo.getExpect() + "个月");
        } else {
            p2PLoanListVo.setDeadline("");
        }
        p2PLoanListVo.setLowestBugAmmount(vo.getPriceMin() == null ? "" : vo.getPriceMin().toString());
        p2PLoanListVo.setBalance(vo.getBalance() == null ? "" : vo.getBalance());
        p2PLoanListVo.setCreateTime(vo.getCreateTime() == null ? "" : CommonUtils.parseDateDay(vo.getCreateTime())); //成立日
        if ("0".equals(vo.getStatus())) {    //状态 ProductP2PStatus
            p2PLoanListVo.setStatus("待发布");
        } else if ("1".equals(vo.getStatus())) {
            p2PLoanListVo.setStatus("已发布");
        } else if ("2".equals(vo.getStatus())) {
            p2PLoanListVo.setStatus("已取消");
        } else if ("3".equals(vo.getStatus())) {
            p2PLoanListVo.setStatus("招标中");
        } else if ("99".equals(vo.getStatus())) {
            p2PLoanListVo.setStatus("售罄");
            p2PLoanListVo.setStatusId("99");
        } else {
            p2PLoanListVo.setStatus("");
        }
        return p2PLoanListVo;
    }


    public static List<FirP2PLoanListVo> convertQyFir(List<ProductP2PInfoSortVo> productP2PInfoVoList) {
        List<FirP2PLoanListVo> p2PLoanListVoList = new ArrayList<>();
        for (ProductP2PInfoSortVo vo : productP2PInfoVoList) {
            FirP2PLoanListVo p2PLoanListVo = converQyFir(vo);
            p2PLoanListVoList.add(p2PLoanListVo);
        }
        return p2PLoanListVoList;
    }

    public static FirP2PLoanListVo converQyFir(ProductP2PInfoSortVo vo) {
        FirP2PLoanListVo p2PLoanListVo = new FirP2PLoanListVo();
        p2PLoanListVo.setProductName(vo.getProductP2pName() == null ? "" : vo.getProductP2pName());
        p2PLoanListVo.setProductId(String.valueOf(vo.getProductP2pId()));
        if ("1".equals(vo.getExpectUnit())) {
            p2PLoanListVo.setDeadline(vo.getExpect() + "天");
        } else if ("0".equals(vo.getExpectUnit())) {
            p2PLoanListVo.setDeadline(vo.getExpect() + "个月");
        } else {
            p2PLoanListVo.setDeadline("");
        }
        p2PLoanListVo.setLowestBugAmmount(vo.getPriceMin() == null ? "" : vo.getPriceMin().toString()); //起购金额
        p2PLoanListVo.setBalance(vo.getBalance() == null ? "" : vo.getBalance());//剩余额度
        p2PLoanListVo.setCreateTime("--");
        //少成立日
        return p2PLoanListVo;
    }

    public static List<P2PLoanListVo> convertQyExpect(List<ProductP2PInfoConfigVo> productP2PInfoVoList) {
        List<P2PLoanListVo> p2PLoanListVoList = new ArrayList<>();
        for (ProductP2PInfoConfigVo vo : productP2PInfoVoList) {
            P2PLoanListVo p2PLoanListVo = converQyExpect(vo);
            p2PLoanListVoList.add(p2PLoanListVo);
        }
        return p2PLoanListVoList;
    }

    public static P2PLoanListVo converQyExpect(ProductP2PInfoConfigVo vo) {
        P2PLoanListVo p2PLoanListVo = new P2PLoanListVo();
        p2PLoanListVo.setDeadLineId(vo.getExpect());
        if ("1".equals(vo.getExpectUnit())) {
            p2PLoanListVo.setDeadLineName(vo.getExpect() + "天");
        } else if ("0".equals(vo.getExpectUnit())) {
            p2PLoanListVo.setDeadLineName(vo.getExpect() + "个月");
        } else {
            p2PLoanListVo.setDeadLineName("");
        }
        return p2PLoanListVo;
    }

    public static List<P2PLoanListVo> convertQyResp(List<ProductP2PInfoConfigVo> productP2PInfoVoList) {
        List<P2PLoanListVo> p2PLoanListVoList = new ArrayList<>();
        for (ProductP2PInfoConfigVo vo : productP2PInfoVoList) {
            P2PLoanListVo p2PLoanListVo = converQyResp(vo);
            p2PLoanListVoList.add(p2PLoanListVo);
        }
        return p2PLoanListVoList;
    }

    public static P2PLoanListVo converQyResp(ProductP2PInfoConfigVo vo) {
        P2PLoanListVo p2PLoanListVo = new P2PLoanListVo();
        p2PLoanListVo.setDeadLineId(vo.getExpect());
        if ("1".equals(vo.getExpectUnit())) {
            p2PLoanListVo.setDeadLineName(vo.getExpect() + "天期产品");
        } else if ("0".equals(vo.getExpectUnit())) {
            p2PLoanListVo.setDeadLineName(vo.getExpect() + "个月期产品");
        } else {
            p2PLoanListVo.setDeadLineName("");
        }
        return p2PLoanListVo;
    }

}
