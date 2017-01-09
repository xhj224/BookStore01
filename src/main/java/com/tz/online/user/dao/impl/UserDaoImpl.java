package com.tz.online.user.dao.impl;

import com.tz.online.entity.User;
import com.tz.online.user.dao.IUserDao;
import com.tz.online.util.HibernateTemplates;
import com.tz.online.util.IHibernateCallBack;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:34.
 * Project: BookStore01.
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public User selectUserByName(String name) {
        return (User) HibernateTemplates.execute(ses -> {
            String hql = "from User where username=:name";
            return ses.createQuery(hql).setParameter("name", name).uniqueResult();
        });
    }

    @Override
    public boolean insertUser(User user) {
        try {
            return (boolean) HibernateTemplates.execute(ses -> {
                if (user != null) {
                    ses.save(user);
                    return true;
                } else {
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User selectUserByNameAndPassword(String name, String password) {
        return (User) HibernateTemplates.execute(ses -> {
            String hql = "from User where username=:name and password=:password";
            return ses.createQuery(hql).setParameter("name", name).setParameter("password", password).uniqueResult();
        });
    }
}
