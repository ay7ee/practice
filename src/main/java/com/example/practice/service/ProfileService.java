package com.example.practice.service;


import com.example.practice.model.Profile;
import com.example.practice.repository.ProfileRepository;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public void saveProfile(Profile profile){
        profileRepository.save(profile);
    }

    public Optional<Profile> getById(Long id){
        return profileRepository.findById(id);
    }

    public Optional<Profile> getByUserid(Long id){
        return profileRepository.getByUserid(id);
    }
}
