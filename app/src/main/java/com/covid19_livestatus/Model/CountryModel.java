package com.uibsoft.covid_info.Model;

public class CountryModel {


    private String countryName;
    private String countryCase;

    public CountryModel(String countryName, String countryCase) {
        this.countryName = countryName;
        this.countryCase = countryCase;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCase() {
        return countryCase;
    }

    public void setCountryCase(String countryCase) {
        this.countryCase = countryCase;
    }
}
