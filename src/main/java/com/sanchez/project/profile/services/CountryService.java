package com.sanchez.project.profile.services;

import com.sanchez.project.profile.models.Country;

import java.util.List;

public interface CountryService {
    Country[] getCountries();

    String getNameCountry(String codeCountry);
}
