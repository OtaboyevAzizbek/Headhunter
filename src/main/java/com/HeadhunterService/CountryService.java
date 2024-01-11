package com.HeadhunterService;

import com.HeadhunterModel.Country;

import java.util.List;

public interface CountryService {
    void createCountry(Country country);
    Country getCountryById(int countryId);
    List<Country> getCountryList();
    void updateCountry(Country country);
    void deleteCountryById(int countryId);
}
