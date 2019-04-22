package com.tucker.springbootcache.service;

import com.tucker.springbootcache.bean.Employee;
import com.tucker.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    final
    EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Cacheable(cacheNames = "emp" /* key = "#root.getMethod()+'['+#id+']'"*/ /*condition = "#a0>1",unless = "#a0==2"*/)
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"员工");
       Employee employee= employeeMapper.getEmpById(id);
       return employee;
    }
}
