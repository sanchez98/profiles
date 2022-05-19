package com.sanchez.project.profile.controllers.api;

import com.sanchez.project.profile.models.City;
import com.sanchez.project.profile.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/city")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/country/{code}")
    public List<City> getCitiesByCountry(@PathVariable("code") String code) {
        return cityService.getCitiesByCountryCode(code.toUpperCase(Locale.ROOT));
    }
}
