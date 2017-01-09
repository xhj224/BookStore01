package com.tz.online.category.action;

import com.tz.online.category.service.ICategoryService;
import com.tz.online.entity.Pageing;
import com.tz.online.util.BeanFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/27 19:56.
 * Project: BookStore01.
 */
@WebServlet(
        name = "showCategory",
        urlPatterns = {"/category/showCategory"}
)
public class ShowCategoryAction extends HttpServlet {
    private ICategoryService categoryService = (ICategoryService) BeanFactory.getBean("categoryService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收分页条件
        String pageNow = req.getParameter("pageNow");
        String pageSize = req.getParameter("pageSize");
        // 如果没有接收到，给予默认
        pageNow = pageNow == null ? "1" : pageNow;
        pageSize = pageSize == null ? "12" : pageSize;
        Pageing bookPageing = categoryService.findBooksByPage(pageNow, pageSize);
        req.setAttribute("bookPageing", bookPageing);
        req.getRequestDispatcher("/WEB-INF/jsp/book/category.jsp").forward(req, resp);
    }
}
