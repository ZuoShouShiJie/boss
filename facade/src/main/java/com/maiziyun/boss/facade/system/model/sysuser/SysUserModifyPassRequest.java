package com.maiziyun.boss.facade.system.model.sysuser;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by len.song on 2017/1/3.
 */
public class SysUserModifyPassRequest extends AbstractRequest {
    private String userName;
    private String newPass;
    private String newPass1;
    private String oldPass;

    public String getUserName() {
        return userName;
    }

    public SysUserModifyPassRequest setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getNewPass() {
        return newPass;
    }

    public SysUserModifyPassRequest setNewPass(String newPass) {
        this.newPass = newPass;
        return this;
    }

    public String getOldPass() {
        return oldPass;
    }

    public SysUserModifyPassRequest setOldPass(String oldPass) {
        this.oldPass = oldPass;
        return this;
    }

    public String getNewPass1() {
        return newPass1;
    }

    public SysUserModifyPassRequest setNewPass1(String newPass1) {
        this.newPass1 = newPass1;
        return this;
    }
}
