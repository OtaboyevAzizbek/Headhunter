package com.HeadhunterDao;

import com.HeadhunterModel.Country;

import java.util.List;

public interface CountryDao {
    void createCountry(Country country);
    Country getCountryById(int countryId);
    List<Country> getCountryList();
    void updateCountry(Country country);
    void deleteCountryById(int countryId);
}
