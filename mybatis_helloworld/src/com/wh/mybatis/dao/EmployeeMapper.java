package com.wh.mybatis.dao;

import com.wh.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-03-30 17:21
 */
public interface EmployeeMapper {

    @MapKey("id")
    public Map<String,Object> getEmpsForMap(String name);

    public Map<String,Object> getEmpForMap(Integer id);

    public List<Employee> getEmpsForList(String name);

    public Employee getEmpById(Integer id);

    public void addEmp(Employee employee);

    public boolean updateEmp(Employee employee);

    public void deleteEmp(Integer id);

}
