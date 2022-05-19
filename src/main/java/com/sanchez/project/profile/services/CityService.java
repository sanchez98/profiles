package com.sanchez.project.profile.services;

import com.sanchez.project.profile.models.City;

import java.util.List;

public interface CityService {
    List<City> getCitiesByCountryCode(String countryCode);
}
