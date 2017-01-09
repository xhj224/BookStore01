package com.tz.online.user.action;

import com.tz.online.entity.User;
import com.tz.online.user.service.IUserService;
import com.tz.online.util.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/24 14:04.
 * Project: BookStore01.
 */
@WebServlet(
        name = "validateName",
        urlPatterns = {"/user/validateName"}
)
public class ValidateNameAction extends HttpServlet {
    private IUserService userService = (IUserService) BeanFactory.getBean("userService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("username");
        name = URLDecoder.decode(name, "UTF-8");
        if (name.trim().length() != 0) {
            User user = userService.loginUser(name);
            if (user == null) {
                out.print("0");
            } else {
                out.print("1");
            }
        } else {
            out.print("2");
        }
        out.flush();
        out.close();
    }
}
