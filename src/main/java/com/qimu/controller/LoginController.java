package com.qimu.controller;

import com.qimu.pojo.Emp;
import com.qimu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private EmpService empService;

    /**
     * 接收index页面的重定向,跳转到登录页面
     *
     * @return
     */
    @RequestMapping("index")
    public String getIndex() {
        return "login";
    }

    /**
     * 校验用户是否存在，存在跳转到用户界面,不存在就重新登录
     *
     * @param emp
     * @param session
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String isLogin(Emp emp, HttpSession session) {
        Emp emps = empService.getUserIsExist(emp.getEmpName(), emp.getPassword());
        if (emps != null) {
            session.setAttribute("error", "");
            return "redirect:/empList";
        }
        session.setAttribute("error", "用户名不存在或密码错误");
        return "login";
    }
}
