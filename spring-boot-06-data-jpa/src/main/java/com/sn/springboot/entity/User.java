package com.sn.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;

//使用jpa注解配置映射关系
@Entity//告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "tbl_user")//@Table来指定和哪个数据表对应；如果省略，默认表名就是user
public class User implements Serializable{
    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.AUTO)//;自增主键
    private Integer id;

    @Column(name = "last_name",length = 50)//这是和数据表对应的一个列
    private String lastName;
//    省略默认列名就是属性名
    private String email;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
