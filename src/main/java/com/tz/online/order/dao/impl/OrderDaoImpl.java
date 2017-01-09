package com.tz.online.order.dao.impl;

import com.tz.online.entity.Address;
import com.tz.online.entity.Order;
import com.tz.online.entity.OrderItem;
import com.tz.online.entity.User;
import com.tz.online.order.dao.IOrderDao;
import com.tz.online.util.HibernateTemplates;
import com.tz.online.util.IHibernateCallBack;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/22 16:34.
 * Project: BookStore01.
 */
public class OrderDaoImpl implements IOrderDao {

    @Override
    public boolean insertAddress(Address a) {
        try {
            return (boolean) HibernateTemplates.execute(ses -> {
                if (a != null) {
                    ses.save(a);
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
    public boolean insertOrder(Order o) {
        try {
            return (boolean) HibernateTemplates.execute(ses -> {
                if (o != null) {
                    ses.save(o);
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
    @SuppressWarnings("unchecked")
    public List<Address> selectAddressByPage(User user, int now, int size) {
        return (List<Address>) HibernateTemplates.execute(ses -> {
            String hql = "from Address where user=:user and isDefault='0'";
            return ses.createQuery(hql).setParameter("user", user).setFirstResult((now - 1) * size).setMaxResults(size).list();
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> selectOrderByPage(User user, int now, int size) {
        return (List<Order>) HibernateTemplates.execute(ses -> {
            String hql = "from Order where user=:user order by createDate desc ";
            return ses.createQuery(hql).setParameter("user", user).setFirstResult((now - 1) * size).setMaxResults(size).list();
        });
    }

    @Override
    public long getRowCountForAddress(User user) {
        return (long) HibernateTemplates.execute(ses -> {
            String hql = "select count(*) from Address where user=:user";
            return ses.createQuery(hql).setParameter("user", user).uniqueResult();
        });
    }

    @Override
    public long getRowCountForOrder(User user) {
        return (long) HibernateTemplates.execute(ses -> {
            String hql = "select count(*) from Order where user=:user";
            return ses.createQuery(hql).setParameter("user", user).uniqueResult();
        });
    }

    @Override
    public Address selectAddressById(Long id) {
        return (Address) HibernateTemplates.execute(ses -> ses.get(Address.class, id));
    }

    @Override
    public Order selectOrderByOrderNum(String orderNum) {
        return (Order) HibernateTemplates.execute(ses -> {
            String hql = "from Order where orderNum=:orderNum";
            return ses.createQuery(hql).setParameter("orderNum", orderNum).uniqueResult();
        });
    }

    @Override
    public boolean insertItem(OrderItem item) {
        try {
            return (boolean) HibernateTemplates.execute(new IHibernateCallBack() {
                @Override
                public Object execute(Session ses) throws HibernateException {
                    ses.save(item);
                    return true;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }
}
