package com.HeadhunterMapper;

import com.HeadhunterModel.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country> {
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Country(rs.getInt("country_id"),rs.getString("country_name"));
    }
}
