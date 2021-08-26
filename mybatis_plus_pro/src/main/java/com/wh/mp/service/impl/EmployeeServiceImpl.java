package com.wh.mp.service.impl;

import com.wh.mp.bean.Employee;
import com.wh.mp.mapper.EmployeeMapper;
import com.wh.mp.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王虎
 * @since 2021-04-23
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
