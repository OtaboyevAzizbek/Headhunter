package com.HeadhunterController;

import com.HeadhunterModel.City;
import com.HeadhunterModel.Company;
import com.HeadhunterModel.Country;
import com.HeadhunterService.CityService;
import com.HeadhunterService.CompanyService;
import com.HeadhunterService.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/headhunter")
public class MainPageController {

    @Autowired
    CountryService countryService;

    @Autowired
    CityService cityService;

    @Autowired
    CompanyService companyService;

    @GetMapping("/view_countries")
    public ModelAndView viewCountries(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("countryList",countryService.getCountryList());
        modelAndView.setViewName("country");
        return modelAndView;
    }
    @PostMapping("/create_country")
    public ModelAndView createCountry(@RequestParam("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        countryService.createCountry(new Country(name));
        modelAndView.setViewName("redirect:/headhunter/view_countries");
        return modelAndView;
    }

    @GetMapping("/view_cities")
    public ModelAndView viewCities(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cityList",cityService.getCityList());
        modelAndView.addObject("countryList",countryService.getCountryList());
        modelAndView.setViewName("city");
        return modelAndView;
    }

    @PostMapping("/create_city")
    public ModelAndView createCity(@RequestParam("name") String name,@RequestParam("countryId") int countryId){
        ModelAndView modelAndView = new ModelAndView();
        cityService.createCity(new City(name,countryId));
        modelAndView.setViewName("redirect:/headhunter/view_cities");
        return modelAndView;
    }

    @GetMapping("/view_companies")
    public ModelAndView viewCompanies(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("companyList",companyService.getCompanyList());
        modelAndView.addObject("cityList",cityService.getCityList());
        modelAndView.setViewName("company");
        return modelAndView;
    }

    @PostMapping("/create_company")
    public ModelAndView createCompany(@RequestParam("companyName") String companyName, @RequestParam("companyTel") String companyTel, @RequestParam("companyEmail") String companyEmail, @RequestParam("description") String description, @RequestParam("cityId") int cityId){
        ModelAndView modelAndView = new ModelAndView();
        companyService.createCompany(new Company(companyName,companyTel,companyEmail,cityId,description));
        modelAndView.setViewName("redirect:/headhunter/view_companies");
        return modelAndView;
    }
}
