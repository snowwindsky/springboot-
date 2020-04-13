package com.sn.springboot.mapper;

import com.sn.springboot.bean.Employee;

//使用@Mapper或者@MapperScan将接口扫描到容器中
public interface EmployeeMapper {
    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);
}
