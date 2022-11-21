package com.qimu.mapper;

import com.qimu.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 查询是否有该账号
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
     * 获取用户存在
     *
     * @param empName
     * @param password
     * @return
     */
    Emp getUserIsExist(@Param("empName") String empName, @Param("password") String password);

    /**
     * 按名称查找用户
     *
     * @param empName
     * @return
     */
    Emp findUserByName(@Param("empName") String empName);

    Integer updateById(Emp emp);

    Integer deleteById(@Param("empId") Integer[] empIds);
}
