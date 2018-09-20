package com.maiziyun.boss.biz.finance.convert;

import com.maiziyun.acs.facade.enums.*;
import com.maiziyun.acs.facade.model.vo.AwardTaskVO;
import com.maiziyun.acs.facade.model.vo.UnitAwardRuleVO;
import com.maiziyun.boss.biz.common.CommonUtils;
import com.maiziyun.boss.facade.finance.model.vo.CornfieldVo;
import com.maiziyun.boss.facade.finance.model.vo.HomepageNoticeVo;
import com.maiziyun.boss.facade.finance.model.vo.UnitAwardRuleVo;
import com.maiziyun.mdc.facade.vo.NoticeManagerVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/7/17.
 */
public class CornfieldConverter {
    public static List<CornfieldVo> revertListQy(List<AwardTaskVO> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<CornfieldVo> $list = new ArrayList<>();
        for (AwardTaskVO vo : params) {
            CornfieldVo no = revertVoQy(vo);
            $list.add(no);
        }
        return $list;

    }

    public static CornfieldVo revertVoQy(AwardTaskVO vo) {
        CornfieldVo corn = new CornfieldVo();
        corn.setId(String.valueOf(vo.getId()));
        corn.setName(vo.getName());
        //任务行为
        if (vo.getTaskAction() != null) {
            corn.setTaskActionId(vo.getTaskAction().name());
            corn.setTaskActionName(vo.getTaskAction().desc());
        }


        corn.setModifyTime(CommonUtils.parseDate(vo.getModifyTime()));
        //状态
        if (vo.getTaskStatus() != null) {
            corn.setStatusId(vo.getTaskStatus().name());
            corn.setStatusName(vo.getTaskStatus().desc());
        }

        corn.setSort(String.valueOf(vo.getSort()));
        //任务类型
        if (vo.getTaskType() != null) {
            corn.setTaskTypeId(vo.getTaskType().name());
            corn.setTaskTypeName(vo.getTaskType().desc());
        }


        //前端可见
        if (vo.getFrontVisible() != null) {
            corn.setFrontVisibleId(vo.getFrontVisible().name());
            corn.setFrontVisibleName(vo.getFrontVisible().desc());
        }

        //投资范围
        if (vo.getInvestScope() != null) {
            corn.setInveScopeId(vo.getInvestScope().name());
            corn.setInveScopeName(vo.getInvestScope().desc());
        }

        //投资条件
        if (vo.getInvestCondition() != null) {
            corn.setInveCondId(vo.getInvestCondition().name());
            corn.setInveCondName(vo.getInvestCondition().desc());
        }

        //投资条件
        if (vo.getAccAwardRules() != null) {
            List<UnitAwardRuleVO> list = vo.getAccAwardRules();
            List<UnitAwardRuleVo> ruleList = new ArrayList<>();
            for (UnitAwardRuleVO rule : list) {
                UnitAwardRuleVo ruleVos = new UnitAwardRuleVo();
                ruleVos.setUnitCondition(rule.getUnitCondition() == null ? "" : String.valueOf(rule.getUnitCondition()));
                ruleVos.setUnitAwardPoint(rule.getUnitAwardPoint() == null ? "" : String.valueOf(rule.getUnitAwardPoint()));
                ruleList.add(ruleVos);
            }
            corn.setAccAwardRules(ruleList);
        }
        return corn;
    }

}
