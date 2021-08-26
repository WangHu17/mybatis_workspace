package test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wh.mp.bean.Employee;
import com.wh.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author wanghu
 * @discrption：AR模式测试
 * @create 2021-04-22 21:10
 */
public class ARTest {

    private ApplicationContext iocContext = new
            ClassPathXmlApplicationContext("conf/applicationContext.xml");

    private EmployeeMapper employeeMapper = iocContext.getBean("employeeMapper", EmployeeMapper.class);

    @Test
    public void testAR(){
//        Employee employee = new Employee(null, "肖兄", "xx@qq.com", 1, 23);
        Employee employee = new Employee();
//        List<Employee> employees = employee.selectAll();
//        List<Employee> employees = employee.selectList(new QueryWrapper<Employee>().like("name", "i"));
//        Integer count = employee.selectCount(null);
        Page<Employee> employeePage = employee.selectPage(new Page<>(1, 2),
                new QueryWrapper<Employee>().like("name", "i"));
        List<Employee> employees = employeePage.getRecords();
        System.out.println(employees);
    }

}
