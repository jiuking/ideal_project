package com.hjc.menu.service.menu;

import com.hjc.menu.dao.menu.MenuMapper;
import com.hjc.menu.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/16.
 */
@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuMapper menuMapper;

    public Integer add(Menu menu) {
        return menuMapper.insert(menu);
    }

    public Integer update(Menu menu) {
        return menuMapper.updateByPrimaryKey(menu);
    }
}
