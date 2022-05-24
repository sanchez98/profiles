package com.sanchez.project.profile.services;

import com.sanchez.project.profile.models.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
public class CountryServiceImpl implements CountryService {

    private Country[] countries;

    public CountryServiceImpl() {
        String url = "https://62857120f0e8f0bb7c0408ef.mockapi.io/api/v1/country";
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Country[]> response = restTemplate
                    .getForEntity(url, Country[].class);
            countries = response.getBody();
        } catch (Exception e) {
            countries = new Country[1];
            countries[0] = new Country("CO", "Colombia");
            System.out.println(e.getMessage());
        }
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
