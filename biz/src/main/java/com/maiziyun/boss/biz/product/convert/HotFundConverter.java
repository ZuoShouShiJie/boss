package com.maiziyun.boss.biz.product.convert;

import com.maiziyun.boss.facade.product.model.vo.FundItemVo;
import com.maiziyun.boss.facade.product.model.vo.HotFundVo;
import com.maiziyun.product.facade.model.vo.FundNavInfoVo;
import com.maiziyun.product.facade.model.vo.ProductAttrInfoVo;
import com.maiziyun.product.facade.model.vo.ProductAttrKindInfoVo;
import com.maiziyun.product.facade.model.vo.ProductAttrRelVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/6/2.
 */
public class HotFundConverter {

    public static HotFundVo reConvertNo(ProductAttrRelVo old) {
        FundNavInfoVo fundNavInfoVo = old.getFundNavInfoVo();
        List<ProductAttrInfoVo> productAttrInfoVoList = old.getProductAttrInfoVos();
        HotFundVo vo = new HotFundVo();
        if (fundNavInfoVo != null) {
            vo.setId(fundNavInfoVo.getProductId() == null ? "" : old.getProductId().toString());
            vo.setName(fundNavInfoVo.getProductName());
            vo.setCode(fundNavInfoVo.getFundCode());
            if ("0".equals(fundNavInfoVo.getFundType())) {
                vo.setType("其他类型");
            } else if ("1".equals(fundNavInfoVo.getFundType())) {
                vo.setType("股票型");
            } else if ("2".equals(fundNavInfoVo.getFundType())) {
                vo.setType("债券型");
            } else if ("3".equals(fundNavInfoVo.getFundType())) {
                vo.setType("混合型");
            } else if ("4".equals(fundNavInfoVo.getFundType())) {
                vo.setType("货币型");
            } else if ("5".equals(fundNavInfoVo.getFundType())) {
                vo.setType("保本型");
            } else if ("6".equals(fundNavInfoVo.getFundType())) {
                vo.setType("指数型");
            } else if ("7".equals(fundNavInfoVo.getFundType())) {
                vo.setType("QDII");
            } else if ("8".equals(fundNavInfoVo.getFundType())) {
                vo.setType("商品型");
            } else if ("9".equals(fundNavInfoVo.getFundType())) {
                vo.setType("短期理财");
            }
            vo.setGrowYear(fundNavInfoVo.getOneYearReturn());
            vo.setGrowMonth3(fundNavInfoVo.getQuarterReturn());
            vo.setGrowMonth1(fundNavInfoVo.getOneMonthReturn());
            vo.setGrowWeek(fundNavInfoVo.getOneWeekReturn());
            String labels = "";
            if (productAttrInfoVoList != null && productAttrInfoVoList.size() > 0) {
                for (ProductAttrInfoVo productAttrInfoVo : productAttrInfoVoList) {
                    if ("SecondLevelTag".equals(productAttrInfoVo.getAttr())) {
                        labels = productAttrInfoVo.getValue();
                    }
                }
                if (StringUtils.isNotBlank(labels)) {
                    String label = labels.replace("|", ",");
                    vo.setLabels(label.split(","));
                } else {
                    vo.setLabels(new String[]{"", "", ""});
                }
            } else {
                vo.setLabels(new String[]{"", "", ""});
            }
            vo.setSort(old.getSort()); //排序用
        }
        return vo;
    }

    public static HotFundVo reConvert0(FundNavInfoVo old) {
        HotFundVo vo = new HotFundVo();
        vo.setId(old.getProductId() == null ? "" : old.getProductId().toString());
        vo.setName(old.getProductName());
        vo.setCode(old.getFundCode());
        if ("0".equals(old.getFundType())) {
            vo.setType("其他类型");
        } else if ("1".equals(old.getFundType())) {
            vo.setType("股票型");
        } else if ("2".equals(old.getFundType())) {
            vo.setType("债券型");
        } else if ("3".equals(old.getFundType())) {
            vo.setType("混合型");
        } else if ("4".equals(old.getFundType())) {
            vo.setType("货币型");
        } else if ("5".equals(old.getFundType())) {
            vo.setType("保本型");
        } else if ("6".equals(old.getFundType())) {
            vo.setType("指数型");
        } else if ("7".equals(old.getFundType())) {
            vo.setType("QDII");
        } else if ("8".equals(old.getFundType())) {
            vo.setType("商品型");
        } else if ("9".equals(old.getFundType())) {
            vo.setType("短期理财");
        }
        vo.setGrowYear(old.getOneYearReturn());
        vo.setGrowMonth3(old.getQuarterReturn());
        vo.setGrowMonth1(old.getOneMonthReturn());
        vo.setGrowWeek(old.getOneWeekReturn());
        String labels = "";
        String desc = "";
        boolean flag = true;
        if (old.getProductAttrRelVos() != null && old.getProductAttrRelVos().size() > 0 && old.getProductAttrRelVos().get(0) != null &&
                old.getProductAttrRelVos().get(0).getProductAttrInfoVos() != null && old.getProductAttrRelVos().get(0).getProductAttrInfoVos().size() > 0 &&
                old.getProductAttrRelVos().get(0).getProductAttrInfoVos().get(0) != null) {
            for (ProductAttrInfoVo productAttrInfoVo : old.getProductAttrRelVos().get(0).getProductAttrInfoVos()) {
                if ("SecondLevelTag".equals(productAttrInfoVo.getAttr())) {
                    labels = productAttrInfoVo.getValue();
                }
                if ("TopLevelTag".equals(productAttrInfoVo.getAttr())) {
                    desc = productAttrInfoVo.getValue();
                    if (desc == null) {
                        vo.setDesc("");
                    } else {
                        vo.setDesc(desc);
                    }
                    flag = false;
                }
            }
//            labels = old.getProductAttrRelVos().get(0).getProductAttrInfoVos().get(0).getValue();
//            vo.setDesc(old.getProductAttrRelVos().get(0).getProductAttrInfoVos().get(0).getDescValue());
            if (StringUtils.isNotBlank(labels)) {
                String label = labels.replace("|", ",");
                vo.setLabels(label.split(","));
            } else {
                vo.setLabels(new String[]{"", "", ""});
            }
        } else {
            vo.setLabels(new String[]{"", "", ""});
            vo.setDesc("");
            flag = false;
        }
        if (flag) {
            vo.setDesc("");
        }
        return vo;
    }

    public static List<HotFundVo> reConvertNo(List<ProductAttrRelVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
     /*   List<ProductAttrRelVo> lists = new ArrayList<ProductAttrRelVo>();
        for (ProductAttrRelVo m : params) {
            if (m.getProductAttrInfoVos() != null && m.getProductAttrInfoVos().size() > 0) {
                lists.add(m);
            }

        }*/

        List<HotFundVo> lists1 = new ArrayList<HotFundVo>();
        for (ProductAttrRelVo m : params) {

            HotFundVo u = reConvertNo(m);
            lists1.add(u);

        }
        return lists1;
    }

    public static HotFundVo reConvertCong(FundNavInfoVo old) {
        HotFundVo vo = new HotFundVo();
        vo.setId(old.getId() == null ? "" : old.getId().toString());
        vo.setProductId(old.getProductId() == null ? "" : old.getProductId().toString());
        vo.setName(old.getProductName());
        vo.setCode(old.getFundCode());
        if ("0".equals(old.getFundType())) {
            vo.setType("其他类型");
        } else if ("1".equals(old.getFundType())) {
            vo.setType("股票型");
        } else if ("2".equals(old.getFundType())) {
            vo.setType("债券型");
        } else if ("3".equals(old.getFundType())) {
            vo.setType("混合型");
        } else if ("4".equals(old.getFundType())) {
            vo.setType("货币型");
        } else if ("5".equals(old.getFundType())) {
            vo.setType("保本型");
        } else if ("6".equals(old.getFundType())) {
            vo.setType("指数型");
        } else if ("7".equals(old.getFundType())) {
            vo.setType("QDII");
        } else if ("8".equals(old.getFundType())) {
            vo.setType("商品型");
        } else if ("9".equals(old.getFundType())) {
            vo.setType("短期理财");
        }
        vo.setGrowYear(old.getOneYearReturn());
        vo.setGrowMonth3(old.getQuarterReturn());
        vo.setGrowMonth1(old.getOneMonthReturn());
        vo.setGrowWeek(old.getOneWeekReturn());
        vo.setVisibility(old.getStatus() == null ? "2" : "1"); //前台不勾选/勾选
       /* String labels = "";
        if (old.getProductAttrRelVos() != null && old.getProductAttrRelVos().get(0) != null &&
                old.getProductAttrRelVos().get(0).getProductAttrInfoVos() != null &&
                old.getProductAttrRelVos().get(0).getProductAttrInfoVos().get(0) != null) {
            labels = old.getProductAttrRelVos().get(0).getProductAttrInfoVos().get(0).getValue();
        }
        if (StringUtils.isNotBlank(labels)) {
            String label = labels.replace("|", ",");
            vo.setLabels(label.split(","));
        } else {
            vo.setLabels(new String[]{"","",""});
        }*/

        return vo;
    }

    public static List<HotFundVo> reConvertConf(List<FundNavInfoVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
       /* List<FundNavInfoVo> lists = new ArrayList<FundNavInfoVo>();
        for (FundNavInfoVo m : params) {
            if (m.getProductAttrRelVos() != null && m.getProductAttrRelVos().size() > 0) {
                lists.add(m);
            }

        }*/

        List<HotFundVo> lists1 = new ArrayList<HotFundVo>();
        for (FundNavInfoVo m : params) {

            HotFundVo u = reConvertCong(m);
            lists1.add(u);

        }
        return lists1;
    }

    public static List<HotFundVo> reConvert0(List<FundNavInfoVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<HotFundVo> lists = new ArrayList<HotFundVo>();
        for (FundNavInfoVo m : params) {
            HotFundVo u = reConvert0(m);
            lists.add(u);
        }
        return lists;
    }


    public static List<HotFundVo> reConvertFirst(List<ProductAttrRelVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<HotFundVo> lists = new ArrayList<HotFundVo>();
        for (ProductAttrRelVo m : params) {
            HotFundVo u = reConvertFirst(m);
            lists.add(u);
        }
        return lists;
    }

    public static HotFundVo reConvertFirst(ProductAttrRelVo old) {
        FundNavInfoVo fundNavInfoVo = old.getFundNavInfoVo();
        List<ProductAttrInfoVo> productAttrInfoVoList = old.getProductAttrInfoVos();
        HotFundVo vo = new HotFundVo();
        if (fundNavInfoVo != null) {
            vo.setId(fundNavInfoVo.getProductId() == null ? "" : old.getProductId().toString());
            vo.setName(fundNavInfoVo.getProductName());
            vo.setCode(fundNavInfoVo.getFundCode());
            if ("0".equals(fundNavInfoVo.getFundType())) {
                vo.setType("其他类型");
            } else if ("1".equals(fundNavInfoVo.getFundType())) {
                vo.setType("股票型");
            } else if ("2".equals(fundNavInfoVo.getFundType())) {
                vo.setType("债券型");
            } else if ("3".equals(fundNavInfoVo.getFundType())) {
                vo.setType("混合型");
            } else if ("4".equals(fundNavInfoVo.getFundType())) {
                vo.setType("货币型");
            } else if ("5".equals(fundNavInfoVo.getFundType())) {
                vo.setType("保本型");
            } else if ("6".equals(fundNavInfoVo.getFundType())) {
                vo.setType("指数型");
            } else if ("7".equals(fundNavInfoVo.getFundType())) {
                vo.setType("QDII");
            } else if ("8".equals(fundNavInfoVo.getFundType())) {
                vo.setType("商品型");
            } else if ("9".equals(fundNavInfoVo.getFundType())) {
                vo.setType("短期理财");
            }
            vo.setGrowYear(fundNavInfoVo.getOneYearReturn());
            vo.setGrowMonth3(fundNavInfoVo.getQuarterReturn());
            vo.setGrowMonth1(fundNavInfoVo.getOneMonthReturn());
            vo.setGrowWeek(fundNavInfoVo.getOneWeekReturn());
            String labels = "";
            String desc = "";
            boolean flag = true;
            if (productAttrInfoVoList != null && productAttrInfoVoList.size() > 0) {
                for (ProductAttrInfoVo productAttrInfoVo : productAttrInfoVoList) {
                    if ("SecondLevelTag".equals(productAttrInfoVo.getAttr())) {
                        labels = productAttrInfoVo.getValue();
                    }
                    if ("TopLevelTag".equals(productAttrInfoVo.getAttr())) {
                        desc = productAttrInfoVo.getValue();
                        if (desc == null) {
                            vo.setDesc("");
                        } else {
                            vo.setDesc(desc);
                        }
                        flag = false;
                    }
                }
                if (StringUtils.isNotBlank(labels)) {
                    String label = labels.replace("|", ",");
                    vo.setLabels(label.split(","));
                } else {
                    vo.setLabels(new String[]{"", "", ""});
                }
            } else {
                vo.setLabels(new String[]{"", "", ""});
                vo.setDesc("");
                flag = false;
            }
            vo.setSort(old.getSort()); //排序用
            if (flag) {
                vo.setDesc("");
            }
        }

        return vo;
    }
}
