package com.maiziyun.boss.facade.user.model;

import com.maiziyun.boss.facade.user.model.vo.HoldingFundVo;
import com.solar.framework.core.base.AbstractPagedResponse;

/**
 * Created by len.song on 2016/11/24.
 */
public class UserHoldQueryResponse extends AbstractPagedResponse<HoldingFundVo> {

    private String totalAsset; //总资产
    private String totalIncome;//累计收益
    private String yesIncome;//昨日收益

    public String getTotalAsset() {
        return totalAsset;
    }

    public UserHoldQueryResponse setTotalAsset(String totalAsset) {
        this.totalAsset = totalAsset;
        return this;
    }

    public String getTotalIncome() {
        return totalIncome;
    }

    public UserHoldQueryResponse setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
        return this;
    }

    public String getYesIncome() {
        return yesIncome;
    }

    public UserHoldQueryResponse setYesIncome(String yesIncome) {
        this.yesIncome = yesIncome;
        return this;
    }
}
