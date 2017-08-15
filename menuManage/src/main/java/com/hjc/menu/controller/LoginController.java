package com.hjc.menu.controller;

import com.hjc.menu.model.Menu;
import com.hjc.menu.service.menu.MenuServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Bravowhale on 2017/7/18.
 */
@Controller
@RequestMapping("/*")
public class LoginController {
    @Autowired
    private MenuServiceImpl menuService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("login")
    public String login(){
//        Menu menu = new Menu();
//        menu.setCode("Menu0001");
//        menu.setMenuPath("asf");
//        menuService.add(menu);
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123");
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        return "main";
    }
    @RequestMapping("/success")
    public String success(){
        return "main";
    }
}
