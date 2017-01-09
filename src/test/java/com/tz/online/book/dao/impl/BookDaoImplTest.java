package com.tz.online.book.dao.impl;

import com.tz.online.book.dao.IBookDao;
import com.tz.online.entity.Book;
import com.tz.online.util.BeanFactory;
import org.junit.Test;

import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/23 16:54.
 * Project: BookStore01.
 */
public class BookDaoImplTest {
    private IBookDao bookDao = (IBookDao) BeanFactory.getBean("bookDao");

    @Test
    public void selectBookById() throws Exception {
        Book book = bookDao.selectBookById(1L);
        if (book != null) {
            System.out.println(book);
        }
    }

    @Test
    public void selectBookByCondition() throws Exception {
        List<Book> bookList = bookDao.selectBookByCondition(2, 2, 1000001L);
        if (bookList != null) {
            bookList.forEach(System.out::println);
        }
    }

    @Test
    public void getRowCount() throws Exception {
        long count = bookDao.getRowCount(1000001L);
        System.out.println(count);
    }
}