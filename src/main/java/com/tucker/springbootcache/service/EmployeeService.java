package com.tucker.springbootcache.service;

import com.tucker.springbootcache.bean.Employee;
import com.tucker.springbootcache.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

/*key = "#root.getMethod()+'['+#id+']'",condition = "#a0>1",unless = "#a0==2"*/
    @Cacheable(cacheNames = "emp" )
    public Employee getEmp(Integer id){
        System.out.println("====================查询"+id+"员工====================");
       Employee employee= employeeMapper.getEmpById(id);
       return employee;
    }

    @CacheEvict(value = "emp",/*allEntries = true*/ beforeInvocation = true)
    public void deleteEmp(Integer id){
        System.out.println("==================删除缓存");
    }
}
