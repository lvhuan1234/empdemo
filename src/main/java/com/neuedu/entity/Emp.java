package com.neuedu.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Emp {

    private int empId;
    private String name;
    private int age;
    private String sex;
    private BigDecimal salary;
    private int deptId;

    private Dept dept;
}
