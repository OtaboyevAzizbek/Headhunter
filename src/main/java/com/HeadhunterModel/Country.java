package com.HeadhunterModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Country {
    private int countryId;
    private String countryName;

    public Country(String countryName){
        this.countryName=countryName;
    }
}
