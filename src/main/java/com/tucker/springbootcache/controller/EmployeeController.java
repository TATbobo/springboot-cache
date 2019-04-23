package com.tucker.springbootcache.controller;

import com.tucker.springbootcache.bean.Employee;
import com.tucker.springbootcache.service.EmployeeService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
       Employee employee= employeeService.getEmp(id);
        return employee;
    }

    @GetMapping("/demp/{id}")
    public  String delEmp(@PathVariable("id") Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }
}
