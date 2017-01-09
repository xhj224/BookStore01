package com.tz.online.address.service.impl;

import com.tz.online.address.dao.IAddressDao;
import com.tz.online.address.service.IAddressService;
import com.tz.online.entity.*;
import com.tz.online.util.BeanFactory;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/26 16:06.
 * Project: BookStore01.
 */
public class AddressServiceImpl implements IAddressService {
    private IAddressDao addressDao = (IAddressDao) BeanFactory.getBean("addressDao");

    @Override
    public Province findProvinceByCode(String code) {
        return addressDao.selectProvinceById(code);
    }

    @Override
    public City findCityByCode(String code) {
        return addressDao.selectCityById(code);
    }

    @Override
    public Area findAreaByCode(String code) {
        return addressDao.selectAreaById(code);
    }

    @Override
    public boolean clearDefaultAddressForUser(User user) {
        return addressDao.updateDefaultAddressForUser(user);
    }

    @Override
    public Address findDefaultAddressByUser(User user) {
        return addressDao.selectDefaultAddressByUser(user);
    }
}
