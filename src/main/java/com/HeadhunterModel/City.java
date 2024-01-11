package com.HeadhunterModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class City {
    private int cityId;
    private String cityName;
    private int countryId;
    private String countryName;

    public City(String cityName,int countryId){
        this.cityName=cityName;
        this.countryId=countryId;
    }
}
