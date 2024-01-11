package com.HeadhunterDao;

import com.HeadhunterModel.City;

import java.util.List;

public interface CityDao {
    void createCity(City city);
    City getCityById(int cityId);
    List<City> getCityList();
    void updateCity(City city);
    void deleteCityById(int cityId);
}
