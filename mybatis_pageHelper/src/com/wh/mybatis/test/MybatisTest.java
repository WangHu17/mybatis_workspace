package com.wh.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wh.mybatis.bean.Employee;
import com.wh.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-03-30 14:45
 */
public class MybatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    //    分页插件的使用
    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            Page<Object> page = PageHelper.startPage(6, 1);

            List<Employee> emps = mapper.getEmps();

//          第二个参数是连续显示多少个页码
            PageInfo<Employee> pageInfo = new PageInfo<>(emps, 5);

            for (Employee emp : emps) {
                System.out.println(emp);
            }
//            System.out.println(page.getPages());//总页数
//            System.out.println(page.getPageNum());//当前页
//            System.out.println(page.getPageSize());//每页数据的数量
//            System.out.println(page.getTotal());//总数据量

            System.out.println(pageInfo.getPages());
            System.out.println(pageInfo.getPageNum());
            System.out.println(pageInfo.getPageSize());
            System.out.println(pageInfo.getTotal());
            System.out.println("连续显示的页码：");
            int[] nums = pageInfo.getNavigatepageNums();
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
        } finally {
            openSession.close();
        }
    }

    //批量
    @Test
    public void testBatch() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            for (int i = 0; i < 1000; i++) {
                mapper.addEmp(new Employee(null, UUID.randomUUID().toString().substring(0,5),0,25));
            }
            openSession.commit();
        } finally {
            openSession.close();
        }
    }

}
