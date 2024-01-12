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
        ModelAndView modelAndView = new ModelAndView("country");
        modelAndView.addObject("countryList",countryService.getCountryList());
        return modelAndView;
    }
    @PostMapping("/create_country")
    public ModelAndView createCountry(@RequestParam("name") String name){
        ModelAndView modelAndView = new ModelAndView("redirect:/headhunter/view_countries");
        countryService.createCountry(new Country(name));
        return modelAndView;
    }
    @PostMapping("/edit_country")
    public ModelAndView editCountry(@RequestParam("countryId") int countryId,@RequestParam("name") String name){
        ModelAndView modelAndView = new ModelAndView("redirect:/headhunter/view_countries");
        countryService.updateCountry(new Country(countryId,name));
        return modelAndView;
    }
    @GetMapping("/delete_country/{countryId}")
    public ModelAndView deleteCountry(@PathVariable("countryId") int countryId){
        ModelAndView modelAndView = new ModelAndView("redirect:/headhunter/view_countries");
        countryService.deleteCountryById(countryId);
        return modelAndView;
    }
    @GetMapping("/view_cities")
    public ModelAndView viewCities(){
        ModelAndView modelAndView = new ModelAndView("city");
        modelAndView.addObject("cityList",cityService.getCityList());
        modelAndView.addObject("countryList",countryService.getCountryList());
        return modelAndView;
    }
    @PostMapping("/create_city")
    public ModelAndView createCity(@RequestParam("name") String name,@RequestParam("countryId") int countryId){
        ModelAndView modelAndView = new ModelAndView("redirect:/headhunter/view_cities");
        cityService.createCity(new City(name,countryId));
        return modelAndView;
    }
    @PostMapping("/edit_city")
    public ModelAndView editCity(@RequestParam("countryId") int countryId,@RequestParam("name") String name,@RequestParam("cityId") int cityId){
        ModelAndView modelAndView = new ModelAndView("redirect:/headhunter/view_cities");
        cityService.updateCity(new City(name,countryId,cityId));
        return modelAndView;
    }
    @GetMapping("/delete_city/{cityId}")
    public ModelAndView deleteCity(@PathVariable("cityId") int cityId){
        ModelAndView modelAndView = new ModelAndView("redirect:/headhunter/view_cities");
        cityService.deleteCityById(cityId);
        return modelAndView;
    }
    @GetMapping("/view_companies")
    public ModelAndView viewCompanies(){
        ModelAndView modelAndView = new ModelAndView("company");
        modelAndView.addObject("companyList",companyService.getCompanyList());
        modelAndView.addObject("cityList",cityService.getCityList());
        return modelAndView;
    }
    @PostMapping("/create_company")
    public ModelAndView createCompany(@RequestParam("companyName") String companyName, @RequestParam("companyTel") String companyTel, @RequestParam("companyEmail") String companyEmail, @RequestParam("description") String description, @RequestParam("cityId") int cityId){
        ModelAndView modelAndView = new ModelAndView("redirect:/headhunter/view_companies");
        companyService.createCompany(new Company(companyName,companyTel,companyEmail,cityId,description));
        return modelAndView;
    }
    @PostMapping("/edit_company")
    public ModelAndView editCompany(@RequestParam("companyName") String companyName, @RequestParam("companyTel") String companyTel, @RequestParam("companyEmail") String companyEmail, @RequestParam("description") String description, @RequestParam("cityId") int cityId,@RequestParam("companyId") int companyId){
        ModelAndView modelAndView = new ModelAndView("redirect:/headhunter/view_companies");
        companyService.updateCompany(new Company(companyName,companyTel,companyEmail,cityId,description,companyId));
        return modelAndView;
    }
    @GetMapping("/delete_company/{companyId}")
    public ModelAndView deleteCompany(@PathVariable("companyId") int companyId){
        ModelAndView modelAndView = new ModelAndView("redirect:/headhunter/view_companies");
        companyService.deleteCompanyById(companyId);
        return modelAndView;
    }
}
