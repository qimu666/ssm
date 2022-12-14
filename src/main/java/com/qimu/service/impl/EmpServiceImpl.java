package com.qimu.service.impl;

import com.qimu.mapper.EmpMapper;
import com.qimu.pojo.Emp;
import com.qimu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> getUser(Emp emp) {
        return empMapper.getUser(emp);
    }

    @Override
    public Integer saveUser(Emp emp) {
        if (check(emp)) {
            return empMapper.saveUser(emp);
        }
        return 0;
    }

    @Override
    public Emp getUserIsExist(String empName, String password) {
        return empMapper.getUserIsExist(empName, password);
    }

    public Emp findUserByName(String empName) {
        return empMapper.findUserByName(empName);
    }

    @Override
    public Integer updateById(Emp emp) {
        if (check(emp)) {
            return empMapper.updateById(emp);
        }
        return 0;
    }

    @Override
    public Integer deleteById(Integer[] ids) {
        //限制删除要传入的id不为空
        if (ids != null && ids.length != 0) {
            return empMapper.deleteById(ids);
        }
        return 0;
    }

    /**
     * 数据校验
     *
     * @param emp
     * @return
     */
    public boolean check(Emp emp) {
        if ("男".equals(emp.getGender()) || "女".equals(emp.getGender())) {
            return true;
        }
        return false;
    }
}
