package org.smart4j.chapter2.controller;

import org.smart4j.chapter2.annotation.Action;
import org.smart4j.chapter2.annotation.Inject;
import org.smart4j.chapter2.bean.Data;
import org.smart4j.chapter2.bean.Param;
import org.smart4j.chapter2.bean.View;
import org.smart4j.chapter2.service.CustomerService;

/**
 * Created by Bravowhale on 2017/7/7.
 */
//@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Action("get:/customer")
    public View index(Param param){
        return null;
    }

    @Action("get:/customer")
    public Data index1(Param param){
        return null;
    }
}
