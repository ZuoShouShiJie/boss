package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;
import com.maiziyun.boss.facade.product.model.vo.SelectFundVo;

import java.util.List;

/**
 * Created by admin on 2017/9/4.
 */
public class UpdateSelectFundRequest extends BaseRequest {
    private List<SelectFundVo> selectFundList;

    public List<SelectFundVo> getSelectFundList() {
        return selectFundList;
    }

    public void setSelectFundList(List<SelectFundVo> selectFundList) {
        this.selectFundList = selectFundList;
    }
}
