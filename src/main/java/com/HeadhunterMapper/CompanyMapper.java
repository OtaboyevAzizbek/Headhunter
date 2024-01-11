package com.HeadhunterMapper;

import com.HeadhunterModel.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMapper implements RowMapper<Company> {
    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Company(rs.getInt("company_id"),rs.getString("company_name"),rs.getString("company_tel"),rs.getString("company_email"),rs.getInt("city_id"),rs.getString("city_name"),rs.getString("country_name"),rs.getString("description"));
    }
}
