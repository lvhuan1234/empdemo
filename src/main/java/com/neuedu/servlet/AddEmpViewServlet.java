package com.neuedu.servlet;

import com.neuedu.entity.Dept;
import com.neuedu.service.DeptService;
import com.neuedu.service.impl.DeptServiceImpl;
import lombok.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/addempview"})
public class AddEmpViewServlet extends HttpServlet {

    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> deptList = deptService.deptList();
        req.setAttribute("deptList",deptList);
        req.getRequestDispatcher("/WEB-INF/pages/addemp.jsp").forward(req,resp);
    }
}
