package com.sn.springboot.controller;

import com.sn.springboot.dao.DepartmentDao;
import com.sn.springboot.dao.EmployeeDao;
import com.sn.springboot.entities.Department;
import com.sn.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

//    @InitBinder
//    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }


//    查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();
//        放在请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    //    查询所有员工返回列表页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "emp/add";
    }
    //    查询所有员工返回列表页面
    //sprigmvc自动将请求参数和入参对象的属性进行一一绑定
    @PostMapping("/emp")
    public String AddEmp(Employee employee){
        System.out.println("保存员工为"+employee);
        employeeDao.save(employee);
//        redirect:表示重定向到一个地址  /代表当前项目路径
//        forward:表示转发到一个地址，
        return "redirect:/emps";
    }

//  来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据为"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
//    员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
