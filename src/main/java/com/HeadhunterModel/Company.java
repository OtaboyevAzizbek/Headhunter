package com.HeadhunterModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Company {
    private int companyId;
    private String companyName;
    private String companyTel;
    private String companyEmail;
    private int cityId;
    private String cityName;
    private String countryName;
    private String description;
    public Company(String companyName,String companyTel,String companyEmail,int cityId,String description){
        this.companyName=companyName;
        this.companyTel=companyTel;
        this.companyEmail=companyEmail;
        this.cityId=cityId;
        this.description=description;
    }
    public Company(String companyName,String companyTel,String companyEmail,int cityId,String description,int companyId){
        this.companyName=companyName;
        this.companyTel=companyTel;
        this.companyEmail=companyEmail;
        this.cityId=cityId;
        this.description=description;
        this.companyId=companyId;
    }
}
