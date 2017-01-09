package com.tz.online.category.dao.impl;

import com.tz.online.category.dao.ICategoryDao;
import com.tz.online.entity.Book;
import com.tz.online.util.BeanFactory;
import org.junit.Test;

import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/27 20:14.
 * Project: BookStore01.
 */
public class CategoryDaoImplTest {
    private ICategoryDao categoryDao = (ICategoryDao) BeanFactory.getBean("categoryDao");

    @Test
    public void selectBooksForPage() throws Exception {
        List<Book> bookPageing = categoryDao.selectBooksForPage(1, 12);
        bookPageing.forEach(System.out::println);
    }
}