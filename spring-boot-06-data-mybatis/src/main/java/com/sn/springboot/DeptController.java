package com.sn.springboot;

import com.sn.springboot.bean.Department;
import com.sn.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("dept/{id}")
    public Department getDepartment(@PathVariable("id")Integer id){
        return departmentMapper.getDePartmentById(id);
    }

    @GetMapping("dept")
    public Department insertDepartment(Department department){
        departmentMapper.insertDept(department);
        return department;
    }
}
