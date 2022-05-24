package com.sanchez.project.profile.services;

import com.sanchez.project.profile.models.Country;
import com.sanchez.project.profile.utils.MockAPI;
import com.sanchez.project.profile.utils.MockAPIImpl;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CountryServiceImpl implements CountryService {

    private Country[] countries;

    public CountryServiceImpl() {
        this.loadCountries();
    }

    private void loadCountries() {
        MockAPI<Country[]> mockAPI = new MockAPIImpl<>();
        String url = "https://62857120f0e8f0bb7c0408ef.mockapi.io/api/v1/country";
        countries = mockAPI.get(url, Country[].class);
        if (countries == null) {
            this.loadDefaultCountries();
        }
    }

    private void loadDefaultCountries() {
        countries = new Country[2];
        countries[0] = new Country("CO", "Colombia");
        countries[1] = new Country("EC", "Ecuador");
    }

    @Override
    public Country[] getCountries() {
        return countries;
    }

    @Override
    public String getNameCountry(String codeCountry) {
        for (Country country : countries) {
            if (codeCountry.toUpperCase(Locale.ROOT).equals(country.getCode())) {
                return country.getName();
            }
        }
        return null;
    }
}
