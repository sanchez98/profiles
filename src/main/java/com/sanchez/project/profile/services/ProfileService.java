package com.sanchez.project.profile.services;

import com.sanchez.project.profile.models.Profile;

public interface ProfileService {

    Profile storeProfile(Profile profile);

    Profile[] getProfiles();

    Profile getProfileById(Integer idProfile);
}
