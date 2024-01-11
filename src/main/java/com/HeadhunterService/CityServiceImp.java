package com.HeadhunterService;

import com.HeadhunterDao.CityDao;
import com.HeadhunterModel.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImp implements CityService{

    @Autowired
    CityDao cityDao;

    @Override
    public void createCity(City city) {
        cityDao.createCity(city);
    }

    @Override
    public City getCityById(int cityId) {
        return cityDao.getCityById(cityId);
    }

    @Override
    public List<City> getCityList() {
        return cityDao.getCityList();
    }

    @Override
    public void updateCity(City city) {
        cityDao.updateCity(city);
    }

    @Override
    public void deleteCityById(int cityId) {
        cityDao.deleteCityById(cityId);
    }
}
