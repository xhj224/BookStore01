package com.tz.online.book.action;

import com.tz.online.book.service.IBookService;
import com.tz.online.entity.Book;
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
 * Date: 2016/12/22 16:58.
 * Project: BookStore01.
 */
@WebServlet(
        name = "detailBook",
        urlPatterns = {"/book/detailBook"}
)
public class DetailBookAction extends HttpServlet {
    private IBookService bookService = (IBookService) BeanFactory.getBean("bookService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收ID
        String bid = req.getParameter("bookId");
        // 根据商品的标识，查询此商品信息
        Book book = bookService.queryBookById(bid);
        Pageing bookPageing = bookService.queryBookByCondition("1", "6", book.getCategory().getCateId().toString());
        req.setAttribute("bookPageing", bookPageing);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/WEB-INF/jsp/book/detail.jsp").forward(req, resp);
    }
}
