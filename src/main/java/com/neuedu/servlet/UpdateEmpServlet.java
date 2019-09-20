package com.neuedu.servlet;

import com.neuedu.entity.Emp;
import com.neuedu.service.EmpService;
import com.neuedu.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = {"/updateemp"})
public class UpdateEmpServlet extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println(req.getParameter("empId"));
        Integer empId = Integer.parseInt(req.getParameter("empId"));
        String name  = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        BigDecimal salary = new BigDecimal(req.getParameter("salary"));
        Integer deptId = Integer.parseInt(req.getParameter("deptId"));

        Emp emp = new Emp();
        emp.setEmpId(empId);
        emp.setName(name);
        emp.setAge(age);
        emp.setSex(sex);
        emp.setSalary(salary);
        emp.setDeptId(deptId);

        empService.updateEmpById(emp);

        resp.sendRedirect("emplist");

    }
}
