package com.HeadhunterDao;

import com.HeadhunterMapper.CityMapper;
import com.HeadhunterModel.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityDaoImp implements CityDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createCity(City city) {
        jdbcTemplate.update("INSERT INTO city(city_name, country_id) VALUES(?,?);",new Object[]{city.getCityName(),city.getCountryId()});
    }

    @Override
    public City getCityById(int cityId) {
        return jdbcTemplate.queryForObject("SELECT c.city_id,c.city_name,c.country_id,c2.country_name FROM city c LEFT JOIN country c2 on c.country_id = c2.country_id WHERE c.city_id=?;",new Object[]{cityId},new CityMapper());
    }

    @Override
    public List<City> getCityList() {
        return jdbcTemplate.query("SELECT c.city_id,c.city_name,c.country_id,c2.country_name FROM city c LEFT JOIN country c2 on c.country_id = c2.country_id;",new CityMapper());
    }

    @Override
    public void updateCity(City city) {
        jdbcTemplate.update("UPDATE city SET city_name=?,country_id=? WHERE city_id=?;",new Object[]{city.getCityName(),city.getCountryId(),city.getCityId()});
    }

    @Override
    public void deleteCityById(int cityId) {
        jdbcTemplate.update("DELETE FROM city WHERE city_id=?;",new Object[]{cityId});
    }
}
