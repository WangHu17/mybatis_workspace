package com.wh.mybatis.dao;

import com.wh.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-03-30 17:21
 */
@Component
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public List<Employee> getEmps();

}
