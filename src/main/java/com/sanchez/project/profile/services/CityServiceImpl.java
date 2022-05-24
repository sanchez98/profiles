package com.sanchez.project.profile.services;

import com.sanchez.project.profile.models.City;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private City[] cities;

    public CityServiceImpl() {
        String url = "https://62857120f0e8f0bb7c0408ef.mockapi.io/api/v1/city";
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<City[]> response = restTemplate
                    .getForEntity(url, City[].class);
            cities = response.getBody();
        } catch (Exception e) {
            cities = new City[2];
            cities[0] = new City(1, "CO", "Medellin");
            cities[1] = new City(2, "CO", "Popayán");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<City> getCitiesByCountryCode(String countryCode) {
        List<City> citiesByCountry = new LinkedList<>();

        for (City city : cities) {
            if (city.getCountry().equals(countryCode)) {
                citiesByCountry.add(city);
            }
        }

        return citiesByCountry;
    }
}
