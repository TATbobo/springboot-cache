package com.tucker.springbootcache;

import com.tucker.springbootcache.bean.Employee;
import com.tucker.springbootcache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void contextLoads() {

        Employee employee=employeeMapper.getEmpById(1);
        int test=employeeMapper.getId(1);
        System.out.println(test);
        System.out.println(employee+"================");
        System.out.println(employee.getEmail()+"================");
    }

}
