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

    /**
     * 用户操作界面
     * 目前功能：添加用户、删除用户、更改用户信息、根据用户输入进行模糊查询、批量删除
     *
     * @param emp
     * @param model
     * @return emp_list 用户界面
     */
    @RequestMapping(value = "/empList", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllUser(Emp emp, Model model) {
        Emp emp1 = new Emp();
        emp1.setEmpName(emp.getEmpName());
        List<Emp> emps = empService.getUser(emp1);
        model.addAttribute("list", emps);
        return "emp_list";
    }

    /**
     * 接收添加用户按钮的请求
     *
     * @return userUpdateAndAdd添加和修改页面是同一个
     */
    @RequestMapping(value = "userAdd")
    public String addUser() {
        return "userUpdateAndAdd";
    }

    /**
     * 接收添加和修改界面（userUpdateAndAdd）填完数据提交数据的请求
     *
     * @param emp
     * @param model
     * @return
     */
    @RequestMapping(value = "/doUserAddAndUpdate")
    public String doUserAddAndUpdate(Emp emp, Model model) {
        Integer integer = 0;// 定义变量用于接收添加或修改的状态,便于代码的复用性
        /*
           emp.getEmpId 是隐藏输入框的值,用户看不到,这个是表单执行添加或修改的关键.
           添加功能是添加用户按钮a标签链接跳转过来的,并没有获取表单数据,在链接拼接上可以明显的看到,
           所以此时的表单的各个组件value为空,emp.getEmpId也必然为null,emp.getEmpId为空时执行添加操作.
           ->>>>>>>
           修改功能也是a标签链接跳转过来的,但是拼接了empId信息,当emp.getEmpId不为空时执行修改操作.
         */
        if (emp != null && emp.getEmpId() != null) {
            integer = empService.updateById(emp);
        } else {
            // 限制用户输入的用户名,不能与数据库中的相同
            Emp userByName = empService.findUserByName(emp.getEmpName());
            if (userByName != null) {
                model.addAttribute("errorAdd", "账号已存在");
                return "userUpdateAndAdd";
            }
            integer = empService.saveUser(emp);
        }
        //接收服务层的校验状态,为0时添加或修改失败
        if (integer == 0) {
            model.addAttribute("errorAdd", "输入有误,请重新输入");
            return "userUpdateAndAdd";
        }
        return "redirect:/empList";
    }

    /**
     * 修改功能
     * 获取此时的用户id,根据id查询用户信息,进行数据的回填
     *
     * @param emp
     * @param model
     * @return
     */
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

    /**
     * 接收删除请求,执行删除操作,根据多选框可以实现批量删除的功能
     *
     * @param empId
     * @return
     */
    @RequestMapping(value = "/delete")
    public String delete(Integer[] empId) {
        empService.deleteById(empId);
        return "redirect:/empList";
    }
}
