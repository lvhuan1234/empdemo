package com.neuedu.servlet;

import com.neuedu.VO.LoginVO;
import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
       String username = req.getParameter("username");
       String password = req.getParameter("password");
        //通过用户名获取数据
        User user = userService.getUserByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                //登录成功后将数据存储到session中
                session.setAttribute("user",user);
                //将数据存储到cookie中
                Cookie cookie = new Cookie("username",user.getUsername());
                cookie.setMaxAge(60 * 60 *24);
                resp.addCookie(cookie);
//                resp.sendRedirect("emplist");
                LoginVO loginVO = LoginVO.success();
                //响应给前台

            }else {
                //密码错误
                LoginVO loginVO = LoginVO.error(1,"密码错误");
            }
        }else {
            //用户名不存在
//            resp.sendRedirect("loginview");
            LoginVO loginVO = LoginVO.error(2,"用户名不存在");
        }
    }
}
