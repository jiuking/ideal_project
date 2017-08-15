package com.hjc.menu;

import com.hjc.menu.model.Menu;
import com.hjc.menu.service.menu.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by Administrator on 2017/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring-service.xml",
        "classpath:spring-dao.xml"})
public class MenuServiceTest {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MenuServiceTest.class);

    @Autowired
    private MenuService menuService;
    @Test
    public void getMenuById() throws Exception{
        Menu menu = new Menu();
        menu.setCode("sdf");
        menu.setName("随意");
        menu.setMenuPath("/root/node1/node1Left");
        menuService.add(menu);
        System.out.println(menu.getId());
    }
}
