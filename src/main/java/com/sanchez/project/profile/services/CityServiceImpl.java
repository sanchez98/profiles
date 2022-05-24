package com.sanchez.project.profile.services;

import com.sanchez.project.profile.models.City;
import com.sanchez.project.profile.utils.MockAPI;
import com.sanchez.project.profile.utils.MockAPIImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private City[] cities;

    public CityServiceImpl() {
        this.loadCities();
    }

    private void loadCities() {
        MockAPI<City[]> mockAPI = new MockAPIImpl<>();
        String url = "https://62857120f0e8f0bb7c0408ef.mockapi.io/api/v1/city";
        cities = mockAPI.get(url, City[].class);
        if (cities == null) {
            this.loadDefaultCities();
        }
    }

    private void loadDefaultCities() {
        cities = new City[5];
        cities[0] = new City(1, "CO", "Medellín");
        cities[1] = new City(2, "CO", "Popayán");
        cities[2] = new City(2, "CO", "Cali");
        cities[3] = new City(2, "EC", "Quito");
        cities[4] = new City(2, "EC", "Guayaquil");
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
