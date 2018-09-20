package com.maiziyun.boss.biz;

import com.maiziyun.boss.common.constants.ContextConstant;
import com.maiziyun.boss.dal.dataobject.OperatorDO;
import com.solar.framework.template.ActionContext;

/**
 * ActionContext 工具类 @lensong
 */
public class ContextUtils {

    /**
     * put boss operator to context
     *
     * @param context
     * @param operator
     */
    public static void putOperator(ActionContext context,OperatorDO operator){
        context.put(ContextConstant._BS_OPERATOR,operator);
    }


    /**
     * get boss operator from context
     * @param context
     * @return
     */
    public static OperatorDO getOperator(ActionContext context){
       return  (OperatorDO) context.get(ContextConstant._BS_OPERATOR);
    }



}

