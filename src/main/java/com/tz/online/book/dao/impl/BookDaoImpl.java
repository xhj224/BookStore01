package com.tz.online.book.dao.impl;

import com.tz.online.book.dao.IBookDao;
import com.tz.online.entity.Book;
import com.tz.online.util.HibernateTemplates;

import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:30.
 * Project: BookStore01.
 */
public class BookDaoImpl implements IBookDao {
    @Override
    @SuppressWarnings("unchecked")
    public List<Book> selectBookByCondition(int now, int size, Long cateId) {
        return (List<Book>) HibernateTemplates.execute(ses -> {
            String hql = "from Book where category.cateId=:cateId";
            return ses.createQuery(hql).setParameter("cateId", cateId).setFirstResult((now - 1) * size).setMaxResults(size).list();
        });
    }

    @Override
    public Book selectBookById(Long id) {
        return (Book) HibernateTemplates.execute(ses -> ses.get(Book.class, id));
    }

    @Override
    public long getRowCount(Long cateId) {
        return (long) HibernateTemplates.execute(ses -> {
            String hql = "select count(*) from Book b where b.category.cateId=:cateId";
            return ses.createQuery(hql).setParameter("cateId", cateId).uniqueResult();
        });
    }
}
