package com.qimu.controller;

import com.qimu.pojo.Emp;
import com.qimu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/empList", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllUser(Emp emp,Model model) {
        Emp emp1 = new Emp();
        emp1.setEmpName(emp.getEmpName());
        List<Emp> emps = empService.getUser(emp1);
        model.addAttribute("list", emps);
        return "emp_list";
    }

    @RequestMapping(value = "userAdd")
    public String addUser() {
        return "userUpdateAndAdd";
    }

    @RequestMapping(value = "/doUserAddAndUpdate")
    public String doUserAdd(Emp emp, Model model) {
        if (emp != null && emp.getEmpId() != null) {
            empService.updateById(emp);
        } else {
            Emp userByName = empService.findUserByName(emp.getEmpName());
            if (userByName == null) {
                empService.saveUser(emp);
            } else {
                model.addAttribute("errorAdd", "账号已存在");
                return "userUpdateAndAdd";
            }
        }
        return "redirect:/empList";
    }

    @RequestMapping(value = "/userUpdate")
    public String update(Emp emp, Model model) {
        System.out.println(emp);
        Emp emp1 = new Emp();
        emp1.setEmpId(emp.getEmpId());
        List<Emp> user = empService.getUser(emp1);
        if (!user.isEmpty()) {
            model.addAttribute("user", user.get(0));
        }
        return "userUpdateAndAdd";
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer[] empId) {
        empService.deleteById(empId);
        return "redirect:/empList";
    }

}
