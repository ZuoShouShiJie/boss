package com.maiziyun.boss.test.product;

import com.maiziyun.boss.biz.product.service.impl.LocalFundServiceImpl;
import com.maiziyun.boss.facade.product.model.HotFundModifyResponse;
import com.maiziyun.boss.facade.product.model.HotFundQueryRequest;
import com.maiziyun.boss.facade.product.service.FundService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by admin on 2017/7/3.
 */
public class FundListTest {
    private static final Logger loger = LoggerFactory.getLogger(FundListTest.class);
    @Autowired
    @Resource(name="boss.FundService")
    private FundService fundService;

    /**
     * 新增一个概念
     */
    @Test
    public  void testAddHotItem(){
       /* FundService impl = new LocalFundServiceImpl();
        HotFundModifyResponse $response = new HotFundModifyResponse();
        HotFundQueryRequest $request = new HotFundQueryRequest();
        $request.setFundName("dxx");
        $response = impl.addHotItem($request);
        loger.info("返回结果",$response);*/
    }
}
