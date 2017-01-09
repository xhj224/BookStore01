package com.tz.online.address.dao.impl;

import com.tz.online.address.dao.IAddressDao;
import com.tz.online.entity.*;
import com.tz.online.util.HibernateTemplates;
import com.tz.online.util.JdbcTemplate;

import java.sql.PreparedStatement;

/**
 * Description:
 * Created by xhj224.
 * Date: 2016/12/26 15:22.
 * Project: BookStore01.
 */
public class AddressDaoImpl implements IAddressDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public Province selectProvinceById(String id) {
        return (Province) jdbcTemplate.query(conn -> {
            String sql = "SELECT ID,CODE,NAME FROM PROVINCE WHERE CODE=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            return pstmt;
        }, rs -> {
            Province province = null;
            if (rs.next()) {
                province = new Province();
                int id1 = rs.getInt("id");
                String code = rs.getString("code");
                String name = rs.getString("name");
                province.setProvinceId(id1);
                province.setProvinceCode(code);
                province.setProvinceName(name);
            }
            return province;
        });
    }

    @Override
    public City selectCityById(String id) {
        return (City) jdbcTemplate.query(conn -> {
            String sql = "SELECT ID,CODE,NAME FROM CITY WHERE CODE=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            return pstmt;
        }, rs -> {
            City city = null;
            if (rs.next()) {
                city = new City();
                int id1 = rs.getInt("id");
                String code = rs.getString("code");
                String name = rs.getString("name");
                city.setCityId(id1);
                city.setCityCode(code);
                city.setCityName(name);
            }
            return city;
        });
    }

    @Override
    public Area selectAreaById(String id) {
        return (Area) jdbcTemplate.query(conn -> {
            String sql = "SELECT ID,CODE,NAME FROM AREA WHERE CODE=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            return pstmt;
        }, rs -> {
            Area area = null;
            if (rs.next()) {
                area = new Area();
                int id1 = rs.getInt("id");
                String code = rs.getString("code");
                String name = rs.getString("name");
                area.setAreaId(id1);
                area.setAreaCode(code);
                area.setAreaName(name);
            }
            return area;
        });
    }

    @Override
    public boolean updateDefaultAddressForUser(User user) {
        try {
            return (boolean) HibernateTemplates.execute(ses -> {
                String hql = "update Address set isDefault='0' where user=:user";
                ses.createQuery(hql).setParameter("user", user).executeUpdate();
                return true;
            });
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Address selectDefaultAddressByUser(User user) {
        return (Address) HibernateTemplates.execute(ses -> {
            String hql = "from Address where user=:user and isDefault='1'";
            return ses.createQuery(hql).setParameter("user", user).uniqueResult();
        });
    }
}
