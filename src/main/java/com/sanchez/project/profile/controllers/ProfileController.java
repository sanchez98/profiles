package com.sanchez.project.profile.controllers;

import com.sanchez.project.profile.models.Profile;
import com.sanchez.project.profile.services.CountryService;
import com.sanchez.project.profile.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProfileController {

    private ProfileService profileService;
    private CountryService countryService;

    @Autowired
    public ProfileController(
            ProfileService profileService,
            CountryService countryService
    ) {
        this.profileService = profileService;
        this.countryService = countryService;
    }

    @GetMapping()
    public String createProfile(Model model) {
        model.addAttribute("countries", countryService.getCountries());
        return "profile/create";
    }

    @PostMapping("profile/save")
    public String storeProfile(@RequestParam MultiValueMap paramMap, Model model) {

        Profile profile = new Profile();
        profile.setNombre(paramMap.getFirst("nombre").toString());
        profile.setApellidos(paramMap.getFirst("apellidos").toString());
        profile.setEmail(paramMap.getFirst("email").toString());
        profile.setTelefono(paramMap.getFirst("telefono").toString());
        profile.setCiudad(paramMap.getFirst("ciudad").toString());
        String codeCountry = paramMap.getFirst("pais").toString();
        profile.setPais(countryService.getNameCountry(codeCountry));

        profile = profileService.storeProfile(profile);

        model.addAttribute("profile", profile);
        return "profile/detail";
    }

    @GetMapping("/profile/list")
    public String showListProfiles(Model model) {
        Profile[] profiles = profileService.getProfiles();

        model.addAttribute("profiles", profiles);
        return "profile/list";
    }

    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable("id") Integer idProfile, Model model) {
        Profile profile = profileService.getProfileById(idProfile);
        model.addAttribute("profile", profile);
        return "profile/detail";
    }

}
