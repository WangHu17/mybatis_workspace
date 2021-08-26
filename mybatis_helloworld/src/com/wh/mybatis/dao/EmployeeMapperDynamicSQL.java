package com.wh.mybatis.dao;

import com.wh.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-04-05 11:16
 */
public interface EmployeeMapperDynamicSQL {

    public List<Employee> getEmpsByDynamicSQLForWhere(Employee employee);

    public List<Employee> getEmpsByDynamicSQLForTrim(Employee employee);

    public List<Employee> getEmpsByDynamicSQLForChoose(Employee employee);

    public void updateEmpByDynamicSQLForSet(Employee employee);

    public List<Employee> getEmpsByDynamicSQLForForeach(List<Integer> list);

    public void addEmpsByDynamicSQLForeach(@Param("emps") List<Employee> emps);
}
