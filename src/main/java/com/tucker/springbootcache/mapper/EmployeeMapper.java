package com.tucker.springbootcache.mapper;

import com.tucker.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository(value = "employeeMapper")
public interface EmployeeMapper {
    @Select("SELECT * FROM employee WHERE id=#{id}")
    public Employee getEmpById(Integer id);

    @Select("SELECT * FROM test WHERE id=#{id}")
    public int getId(Integer id);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} WHERE id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    public  void deleteEmp(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{d_id})")
    public void insertEmp(Employee employee);
}
