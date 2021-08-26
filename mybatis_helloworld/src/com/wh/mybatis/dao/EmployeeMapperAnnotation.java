package com.wh.mybatis.dao;

import com.wh.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-04-01 14:10
 */
public interface EmployeeMapperAnnotation {

    @Select("select * from emp where id = #{id}")
    public Employee getEmpById(Integer id);

}
