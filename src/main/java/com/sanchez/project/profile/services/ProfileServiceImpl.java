package com.sanchez.project.profile.services;

import com.sanchez.project.profile.models.Profile;
import com.sanchez.project.profile.utils.MockAPI;
import com.sanchez.project.profile.utils.MockAPIImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

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

        MockAPI<Profile> mockAPI = new MockAPIImpl<>();
        Profile response = mockAPI.post(url, body, Profile.class);
        if (response != null) {
            return response;
        }

        return profile;
    }

    @Override
    public Profile[] getProfiles() {
        MockAPI<Profile[]> mockAPI = new MockAPIImpl<>();
        return mockAPI.get(url, Profile[].class);
    }

    @Override
    public Profile getProfileById(Integer idProfile) {
        String url = this.url + "/" + idProfile;
        MockAPI<Profile> mockAPI = new MockAPIImpl<>();
        return mockAPI.get(url, Profile.class);
    }


}
