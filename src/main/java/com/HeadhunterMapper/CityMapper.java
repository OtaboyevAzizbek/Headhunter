package com.HeadhunterMapper;

import com.HeadhunterModel.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new City(rs.getInt("city_id"),rs.getString("city_name"),rs.getInt("country_id"),rs.getString("country_name"));
    }
}
