package com.tz.online.category.dao.impl;

import com.tz.online.category.dao.ICategoryDao;
import com.tz.online.entity.Book;
import com.tz.online.util.HibernateTemplates;

import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/27 19:47.
 * Project: BookStore01.
 */
public class CategoryDaoImpl implements ICategoryDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> selectBooksForPage(int now, int size) {
        return (List<Book>) HibernateTemplates.execute(ses -> {
            String hql = "from Book";
            return ses.createQuery(hql).setFirstResult((now - 1) * size).setMaxResults(size).list();
        });
    }

    @Override
    public long getRowCount() {
        return (long) HibernateTemplates.execute(ses -> {
            String hql = "select count(*) from Book";
            return ses.createQuery(hql).uniqueResult();
        });
    }
}
