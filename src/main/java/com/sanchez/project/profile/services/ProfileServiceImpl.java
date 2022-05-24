package com.sanchez.project.profile.services;

import com.sanchez.project.profile.models.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ProfileServiceImpl implements ProfileService {

    private String url = "https://62857120f0e8f0bb7c0408ef.mockapi.io/api/v1/profiles";

    @Override
    public Profile storeProfile(Profile profile) {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("nombre", profile.getNombre());
        body.add("apellidos", profile.getApellidos());
        body.add("email", profile.getEmail());
        body.add("telefono", profile.getTelefono());
        body.add("ciudad", profile.getCiudad());
        body.add("pais", profile.getPais());

        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Profile> response = restTemplate
                    .postForEntity(url, body, Profile.class);
            return response.getBody();
        } catch (Exception e) {
            System.out.println(e);
        }

        return profile;
    }

    @Override
    public Profile[] getProfiles() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Profile[]> response = restTemplate
                    .getForEntity(url, Profile[].class);
            return response.getBody();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Profile getProfileById(Integer idProfile) {
        String url = this.url + "/" + idProfile;
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Profile> response = restTemplate
                    .getForEntity(url, Profile.class);
            return response.getBody();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


}
