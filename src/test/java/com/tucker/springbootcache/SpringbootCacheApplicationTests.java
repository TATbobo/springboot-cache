package com.tucker.springbootcache;

import com.tucker.springbootcache.bean.Employee;
import com.tucker.springbootcache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisTemplate<Object,Employee> empRedisTemplate;

    @Test
    public void test01(){
        /*String s=stringRedisTemplate.opsForValue().get("mesg");
        System.out.println(s);
        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");*/

        Employee employee=employeeMapper.getEmpById(1);
        empRedisTemplate.opsForValue().set("emp",employee);
    }
   @Test
    public void contextLoads() {

        Employee employee=employeeMapper.getEmpById(1);
        int test=employeeMapper.getId(1);
        System.out.println(test);
        System.out.println(employee+"================");
        System.out.println(employee.getEmail()+"================");
    }

}
