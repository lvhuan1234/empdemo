package com.neuedu.servlet;

import com.neuedu.service.EmpService;
import com.neuedu.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/deleteemp"})
public class DeleteEmpServlet extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer empId = Integer.parseInt(req.getParameter("id"));
        empService.deleteEmpById(empId);
        //回到列表页
        resp.sendRedirect("emplist");

    }
}
