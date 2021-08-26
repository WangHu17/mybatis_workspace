package com.wh.mybatis.dao;

import com.wh.mybatis.bean.Employee;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-04-03 13:43
 */
public interface EmployeeMapper2 {

    public List<Employee> getEmpsByDeptIdForStep(Integer id);

    public Employee getEmpAndDeptByIdForStep(Integer id);

    public Employee getEmpAndDeptById(Integer id);

    public Employee getEmpById(Integer id);

}
