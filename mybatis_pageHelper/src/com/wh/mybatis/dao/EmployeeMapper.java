package com.wh.mybatis.dao;

import com.wh.mybatis.bean.Employee;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-03-30 17:21
 */
public interface EmployeeMapper {

    public List<Employee> getEmps();

    public void addEmp(Employee employee);

}
