package com.maiziyun.boss.test.jys;

import com.maiziyun.boss.facade.common.model.ResponseNewData;
import com.maiziyun.boss.facade.jysmng.model.FundsRecordQueryRequest;
import com.maiziyun.boss.facade.jysmng.service.JYSMngService;
import com.solar.framework.core.base.BaseException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

/**
 * Created by admin on 2017/11/17.
 */
@ContextConfiguration(locations = {"classpath:spring/boss-test.xml"})
public class JysMngTest extends AbstractJUnit4SpringContextTests {
    private static Logger logger = LoggerFactory.getLogger(JysMngTest.class);
    @Resource(name = "boss.JYSMngService")
    private JYSMngService jysMngService;

    /**
     * 资金记录 第一步:查用户信息
     */
    @Test
    public void userInvestListQuery() {
        FundsRecordQueryRequest request = new FundsRecordQueryRequest();
        request.setMobile("15102108563");

        logger.info("接收请求{ }", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.queryUserMsg(request);
        } catch (BaseException e) {
            logger.error("查用户信息异常", e);
        } catch (Exception e) {
            logger.error("查用户信息异常", e);
        }
        System.out.print(data);


    }

    /**
     * 资金记录 第二步：查资金记录
     */
    @Test
    public void fundsRecordQuery() {
        ResponseNewData data = null;
        try {
            FundsRecordQueryRequest request = new FundsRecordQueryRequest();
            data = jysMngService.fundsRecordQuery(request);
        } catch (BaseException e) {
            logger.error("资金记录查询异常", e);
        } catch (Exception e) {
            logger.error("资金记录查询异常", e);
        }
        System.out.println(data);

    }

}
