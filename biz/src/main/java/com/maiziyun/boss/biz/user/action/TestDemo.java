package com.maiziyun.boss.biz.user.action;

import com.solar.framework.core.base.AbstractEnum;
import com.solar.framework.template.ActionContext;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by songliang on 2016/11/11.
 */
public class TestDemo extends AbstractAction{
    @Override
    public void actionPerformed(ActionEvent e) {
        ActionContext context = ActionContext.getContext();

    }

    Class<? extends Object> c  = TestDemo.class;
    Class<? extends AbstractEnum> enumType = null;

    public void test(Class<? extends AbstractEnum> enumType){

    }
}
