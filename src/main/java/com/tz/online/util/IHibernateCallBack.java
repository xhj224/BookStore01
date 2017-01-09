package com.tz.online.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**回调接口**/
public interface IHibernateCallBack {
	public Object execute(Session ses) throws HibernateException;
}
