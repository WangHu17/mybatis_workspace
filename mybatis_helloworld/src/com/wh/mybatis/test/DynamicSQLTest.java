package com.wh.mybatis.test;

import com.wh.mybatis.bean.Department;
import com.wh.mybatis.bean.Employee;
import com.wh.mybatis.dao.EmployeeMapperDynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-04-05 11:18
 */
public class DynamicSQLTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        InputStream resource = Resources.getResourceAsStream("conf/mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(resource);
    }

//    动态sql查询
    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(null, null, null, null);
            List<Employee> emps = mapper.getEmpsByDynamicSQLForChoose(employee);
            for(Employee emp:emps){
                System.out.println(emp);
            }
        }finally {
            sqlSession.close();
        }
    }

//    动态sql更新
    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(2, "jisoo", 22, null);
            mapper.updateEmpByDynamicSQLForSet(employee);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

//    动态sql查询多条数据
    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> emps = mapper.getEmpsByDynamicSQLForForeach(Arrays.asList(2, 3, 4, 5));
            for(Employee emp:emps){
                System.out.println(emp);
            }
        }finally {
            sqlSession.close();
        }
    }

//    动态sql插入多条数据
    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> emps = new ArrayList<>();
            emps.add(new Employee(null,"steve",36,1,new Department(1)));
            emps.add(new Employee(null,"avens",38,1,new Department(2)));
            mapper.addEmpsByDynamicSQLForeach(emps);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }
}
