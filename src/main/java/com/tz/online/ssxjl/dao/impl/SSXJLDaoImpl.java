package com.tz.online.ssxjl.dao.impl;



import com.tz.online.entity.Area;
import com.tz.online.entity.City;
import com.tz.online.entity.Province;
import com.tz.online.ssxjl.dao.ISSXJLDao;
import com.tz.online.util.JdbcTemplate;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/19 12:54.
 * Project: SSXJL.
 */
public class SSXJLDaoImpl implements ISSXJLDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    @SuppressWarnings("unchecked")
    public List<Province> selectAllProvicnes() {
        return (List<Province>) jdbcTemplate.query(conn -> {
            String sql = "SELECT ID,CODE,NAME FROM PROVINCE";
            return conn.prepareStatement(sql);
        }, rs -> {
            List<Province> provinceList = new ArrayList<>();
            Province province;
            while (rs.next()) {
                province = new Province();
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String name = rs.getString("name");
                province.setProvinceId(id);
                province.setProvinceCode(code);
                province.setProvinceName(name);
                provinceList.add(province);
            }
            return provinceList;
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<City> selectCityByProvinceCode(String proviceCode) {
        return (List<City>) jdbcTemplate.query(conn -> {
            String sql = "SELECT ID,CODE,NAME FROM CITY WHERE PROVINCEID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, proviceCode);
            return pstmt;
        }, rs -> {
            List<City> cityList = new ArrayList<>();
            City city;
            while (rs.next()) {
                city = new City();
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String name = rs.getString("name");
                city.setCityId(id);
                city.setCityCode(code);
                city.setCityName(name);
                cityList.add(city);
            }
            return cityList;
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Area> selectAreaByCityCode(String cityCode) {
        return (List<Area>) jdbcTemplate.query(conn -> {
            String sql = "SELECT ID,CODE,NAME FROM AREA WHERE CITYID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cityCode);
            return pstmt;
        }, rs -> {
            List<Area> areaList = new ArrayList<>();
            Area area;
            while (rs.next()) {
                area = new Area();
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String name = rs.getString("name");
                area.setAreaId(id);
                area.setAreaCode(code);
                area.setAreaName(name);
                areaList.add(area);
            }
            return areaList;
        });
    }
}
