package com.sn.springboot.mapper;

import com.sn.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

//指定这是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department where id = #{id}")
    public Department getDePartmentById(@Param("id") Integer id);

    @Delete("DELETE FROM department WHERE id = #{id}")
    public int deleteById(@Param("id")Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO department(department_name)VALUES(#{departmentName})")
    public int insertDept(Department department);

    @Update("UPDATE department SET department_name = #{departmentName} WHERE id=#{id}")
    public int updateDept(Department department);


}
