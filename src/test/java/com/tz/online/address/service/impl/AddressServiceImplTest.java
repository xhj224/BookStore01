package com.tz.online.address.service.impl;

import com.tz.online.address.service.IAddressService;
import com.tz.online.entity.Area;
import com.tz.online.entity.City;
import com.tz.online.entity.Province;
import com.tz.online.util.BeanFactory;
import org.junit.Test;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/26 16:09.
 * Project: BookStore01.
 */
public class AddressServiceImplTest {
    private IAddressService addressService = (IAddressService) BeanFactory.getBean("addressService");

    @Test
    public void findProvinceByCode() throws Exception {
        Province province = addressService.findProvinceByCode("140000");
        System.out.println(province);
    }

    @Test
    public void findCityByCode() throws Exception {
        City city = addressService.findCityByCode("130200");
        System.out.println(city);
    }

    @Test
    public void findAreaByCode() throws Exception {
        Area area = addressService.findAreaByCode("230107");
        System.out.println(area);
    }

}