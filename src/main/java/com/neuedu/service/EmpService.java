package com.neuedu.service;

import com.neuedu.entity.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> listEmp();

    List<Emp> listEmpDept();

    int insertEmp(Emp emp);

    int deleteEmpById(Integer empId);

    Emp getEmpById(Integer empId);

    int updateEmpById(Emp emp);


}
