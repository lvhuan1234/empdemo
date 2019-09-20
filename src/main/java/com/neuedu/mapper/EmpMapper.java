package com.neuedu.mapper;

import com.neuedu.entity.Emp;

import java.util.List;

public interface EmpMapper {

    List<Emp> listEmp();

     List<Emp> listEmpDept();

    int insertEmp(Emp emp);

    int deleteEmpById(Integer empId);

    Emp getEmpById(Integer empId);

    int updateEmpById(Emp emp);

}
