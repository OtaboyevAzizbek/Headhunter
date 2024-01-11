package com.HeadhunterDao;

import com.HeadhunterMapper.CountryMapper;
import com.HeadhunterModel.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryDaoImp implements CountryDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createCountry(Country country) {
        jdbcTemplate.update("INSERT INTO country(country_name) VALUES(?);",new Object[]{country.getCountryName()});
    }

    public Country getCountryById(int countryId) {
        return jdbcTemplate.queryForObject("SELECT * FROM country WHERE country_id=?;",new Object[]{countryId},new CountryMapper());
    }

    public List<Country> getCountryList() {
        return jdbcTemplate.query("SELECT * FROM country;",new CountryMapper());
    }

    public void updateCountry(Country country) {
        jdbcTemplate.update("UPDATE country SET country_name=? WHERE country_id=?;",new Object[]{country.getCountryName(),country.getCountryId()});
    }

    public void deleteCountryById(int countryId) {
        jdbcTemplate.update("DELETE FROM country WHERE country_id=?;",new Object[]{countryId});
    }
}
