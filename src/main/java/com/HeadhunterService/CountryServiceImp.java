package com.HeadhunterService;

import com.HeadhunterDao.CountryDao;
import com.HeadhunterModel.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImp implements CountryService{

    @Autowired
    CountryDao countryDao;

    public void createCountry(Country country) {
        countryDao.createCountry(country);
    }

    public Country getCountryById(int countryId) {
        return countryDao.getCountryById(countryId);
    }

    public List<Country> getCountryList() {
        return countryDao.getCountryList();
    }

    public void updateCountry(Country country) {
        countryDao.updateCountry(country);
    }

    public void deleteCountryById(int countryId) {
        countryDao.deleteCountryById(countryId);
    }
}
