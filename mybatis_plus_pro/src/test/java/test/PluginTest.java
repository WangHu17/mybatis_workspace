package test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wh.mp.bean.Employee;
import com.wh.mp.bean.User;
import com.wh.mp.mapper.EmployeeMapper;
import com.wh.mp.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-04-23 15:24
 */
public class PluginTest {

    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("conf/applicationContext.xml");

    private EmployeeMapper employeeMapper = iocContext.getBean(EmployeeMapper.class);
    
    private UserMapper userMapper = iocContext.getBean(UserMapper.class);
    
    //测试分页插件
    @Test
    public void testPage(){
        Page<Employee> employeePage = employeeMapper.selectPage(new Page<>(2, 3), null);
        System.out.println(employeePage.getRecords());
    }

    //测试防止全表更新与删除插件
    @Test
    public void testDeleteAll(){
        employeeMapper.delete(null);
    }

    //测试逻辑删除
    @Test
    public void testLogicDel(){
//        userMapper.deleteById(1);
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
