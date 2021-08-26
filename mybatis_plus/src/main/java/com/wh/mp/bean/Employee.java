package com.wh.mp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-04-12 22:09
 */
//@TableName(value = "tbl_employee")已在全局配置中配置
public class Employee extends Model<Employee> {//继承Model类开启AR模式

//    @TableId(type = IdType.AUTO)已在全局配置中配置
    private Integer id;
    private String name;
    private String email;
    private Integer gender;
    private Integer age;

    @TableField(exist = false)//表明数据库不存在这一列值，插入时就不会有这个属性
    private Double salary;
    public Employee() {
    }

    public Employee(Integer id, String name, String email, Integer gender, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
