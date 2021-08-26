package com.wh.mybatis.dao;

import com.wh.mybatis.bean.Department;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-04-03 15:53
 */
public interface DepartmentMapper {

    public Department getDeptByIdPlusForStep(Integer id);

    public Department getDeptByIdPlus(Integer id);

    public Department getDeptById(Integer id);

}
