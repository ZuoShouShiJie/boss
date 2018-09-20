package com.maiziyun.boss.common.utils;

/**
 * Created by len.song on 2016/11/30.
 */
public abstract class DoServiceTemplate {
   /* private Logger logger = LoggerFactory.getLogger(DoServiceTemplate.class);
    public  AbstractResponse doServiceMessage(AbstractRequest request){
        if(request==null){
            throw new BizException(BizCode.ParamError,BizCode.ParamError.desc());
        }
        RoleModifyResponse response = new RoleModifyResponse();
        try {
            this.doService(request);
            response.setCode(BizCode.Success);
            response.setMessage("修改成功");
        }catch (BaseException e){
            logger.error("修改角色异常",e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        }catch (Exception e){
            logger.error("修改角色异常",e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public abstract Object doService(AbstractRequest request);*/

}
