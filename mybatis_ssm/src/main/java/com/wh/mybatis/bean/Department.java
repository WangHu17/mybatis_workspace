package com.wh.mybatis.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-04-03 13:31
 */
public class Department implements Serializable {

    private Integer id;
    private String deptName;
    private List<Employee> emps;

    public Department() {
    }

    public Department(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
