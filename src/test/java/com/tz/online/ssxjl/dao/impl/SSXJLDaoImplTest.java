package com.tz.online.ssxjl.dao.impl;

import com.tz.online.entity.Province;
import com.tz.online.ssxjl.dao.ISSXJLDao;
import com.tz.online.util.BeanFactory;
import org.junit.Test;

import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/26 10:22.
 * Project: BookStore01.
 */
public class SSXJLDaoImplTest {
    private ISSXJLDao ssxjlDao = (ISSXJLDao) BeanFactory.getBean("ssxjlDao");

    @Test
    public void selectAllProvicnes() throws Exception {
        List<Province> provinceList = ssxjlDao.selectAllProvicnes();
        provinceList.forEach(System.out::println);
    }

    @Test
    public void selectCityByProvinceCode() throws Exception {

    }

    @Test
    public void selectAreaByCityCode() throws Exception {

    }

}