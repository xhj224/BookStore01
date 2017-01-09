/**
 * 此代码归 xxx 版本所有，未经同意，严禁复制和转发
 */
package com.tz.online.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description 数据库连接的配置类，用来读取config/db.properties文件
 * @author teacher
 * @version 1.0
 * @createDate 2016年11月15日 下午3:12:29
 * @since jdk6.0
 * @project JDBC_Teacher
 *
 */
public class DBConfig {
	//用来存放读到的文件内容
	private static Properties props;

	static {
		props = new Properties();
		//定义流
		InputStream in = null;
		//
		try {
			in = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("db.properties");
			//加载
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/****
	 * 通过key来获取value
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		return props.getProperty(key);
	}
}
