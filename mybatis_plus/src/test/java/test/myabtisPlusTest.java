package test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wh.mp.bean.Employee;
import com.wh.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * @author wanghu
 * @discrption：测试通用CRUD和条件构造器QueryWrapper
 * @create 2021-04-12 22:54
 */
public class myabtisPlusTest {

    private ApplicationContext iocContext = new
            ClassPathXmlApplicationContext("conf/applicationContext.xml");

    private EmployeeMapper employeeMapper = iocContext.getBean("employeeMapper", EmployeeMapper.class);

    @Test
    public void testQueryWrapperDelete(){
        int delete = employeeMapper.delete(
                new QueryWrapper<Employee>()
                        .eq("name", "test")
        );
        System.out.println(delete);
    }

    @Test
    public void testQueryWrapperUpdate(){
        int update = employeeMapper.update(
                new Employee(null, "伟哥", "msw@qq.com", 1, 22),
                new QueryWrapper<Employee>()
                        .eq("name", "test")
                        .eq("gender", 1)
        );
        System.out.println(update);
    }

    @Test
    public void testQueryWrapperSelectList(){
        List<Employee> employees = employeeMapper.selectList(
                new QueryWrapper<Employee>()
                        .eq("gender", 0)
                        .like("name", "%i%")
                        .or()
                        .eq("age", 22)
        );
        System.out.println(employees);
    }

    //使用selectPage必须在配置文件中配置分页拦截器相关配置
    @Test
    public void testQueryWrapeprSelectPage() {
        Page<Employee> employeePage = employeeMapper.selectPage(new Page<>(2, 2),
                new QueryWrapper<Employee>()
                        .between("age", 22, 30)
        );
        System.out.println(employeePage.getRecords());
        System.out.println(employeePage.getTotal());
        System.out.println(employeePage.getCurrent());
        System.out.println(employeePage.getSize());
        System.out.println(employeePage.getPages());
    }

    @Test
    public void testMPDeleteBatchIds() {
        int i = employeeMapper.deleteBatchIds(Arrays.asList(9, 10));
        System.out.println(i);
    }

    //map不能使用模糊查询
    @Test
    public void testMPDeleteByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","BLACKPINK");
        int i = employeeMapper.deleteByMap(map);
        System.out.println(i);
    }

    @Test
    public void testMPDeleteById() {
        int i = employeeMapper.deleteById(8);
        System.out.println(i);
    }

    //必须保证查询的数据只有一条
    @Test
    public void testMPSelectOne() {
        Employee employee = employeeMapper.selectOne(
                new QueryWrapper<Employee>()
                        .eq("gender", 1)
        );
        System.out.println(employee);
    }

    //使用selectPage必须在配置文件中配置分页拦截器相关配置，第二个参数传null即查询所有数据
    @Test
    public void testMPSelectPage(){
        Page<Employee> employeePage = employeeMapper.selectPage(new Page<>(2, 3), null);
        System.out.println(employeePage.getRecords());
    }

    @Test
    public void testMPSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "lisa");
        map.put("gender", 0);
        List<Employee> employees = employeeMapper.selectByMap(map);
        System.out.println(employees);
    }

    @Test
    public void testMPSelectBatchIds() {
        List<Employee> employees = employeeMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(employees);
    }

    @Test
    public void testMPSelectById() {
        Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);
    }

    //传入null值的属性数据库将不会修改
    @Test
    public void testMPUpdateById() {
        int i = employeeMapper.updateById(new Employee(7, null, "BLACKPINK@qq.com", null, 6));
        System.out.println(i);
    }

    @Test
    public void testMPInsert() {
        Employee employee = new Employee(null, "BLACKPINK", "BP@qq.com", 0, 25);
        int i = employeeMapper.insert(employee);
        System.out.println(i);
        Integer id = employee.getId();
        System.out.println(id);
    }

    @Test
    public void testEnvironment() throws Exception {
        DataSource ds = iocContext.getBean("dataSource", DataSource.class);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }

}
