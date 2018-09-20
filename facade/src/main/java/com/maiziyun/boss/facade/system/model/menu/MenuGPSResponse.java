package com.maiziyun.boss.facade.system.model.menu;
import com.maiziyun.boss.facade.system.model.vo.MenuVo;
import com.solar.framework.core.base.AbstractResponse;

import java.util.List;

/**
 * Created by len.song on 2016/11/21.
 */
public class MenuGPSResponse extends AbstractResponse {
    private List<MenuVo> menuVos;

    public List<MenuVo> getMenuVos() {
        return menuVos;
    }

    public void setMenuVos(List<MenuVo> menuVos) {
        this.menuVos = menuVos;
    }
}
