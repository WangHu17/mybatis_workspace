package com.wh.mybatis.bean;

import java.io.Serializable;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-03-30 14:38
 */
public class Employee implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private Integer sex;
    private Department dept;

    public Employee() {
    }

    public Employee(Integer id, String name, Integer age, Integer sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Employee(Integer id, String name, Integer age, Integer sex, Department dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
