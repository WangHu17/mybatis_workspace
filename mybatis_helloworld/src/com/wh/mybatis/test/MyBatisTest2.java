package com.wh.mybatis.test;

import com.wh.mybatis.bean.Department;
import com.wh.mybatis.bean.Employee;
import com.wh.mybatis.dao.DepartmentMapper;
import com.wh.mybatis.dao.EmployeeMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-04-03 14:08
 */
public class MyBatisTest2 {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        InputStream resource = Resources.getResourceAsStream("conf/mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(resource);
    }

    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper2 mapper = sqlSession.getMapper(EmployeeMapper2.class);
            Employee emp = mapper.getEmpById(2);
            System.out.println(emp);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper2 mapper = sqlSession.getMapper(EmployeeMapper2.class);
            Employee emp = mapper.getEmpAndDeptByIdForStep(6);
            System.out.println(emp);
            System.out.println(emp.getDept());
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
//            Department dept = mapper.getDeptByIdPlus(1);
            Department dept = mapper.getDeptByIdPlusForStep(1);
            System.out.println(dept);
            System.out.println(dept.getEmps());
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

}
