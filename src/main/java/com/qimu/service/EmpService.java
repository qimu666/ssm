package com.qimu.service;

import com.qimu.pojo.Emp;

import java.util.List;

public interface EmpService {
    /**
     * 查询用户信息
     *
     * @return
     */
    List<Emp> getUser(Emp emp);

    /**
     * 添加用户
     *
     * @param emp
     * @return
     */
    Integer saveUser(Emp emp);

    /**
     * 获取用户是否存在
     *
     * @param
     * @return
     */
    Emp getUserIsExist(String empName, String password);

    Emp findUserByName(String empName);

    Integer updateById(Emp emp);

    Integer deleteById(Integer[] ids);
}
