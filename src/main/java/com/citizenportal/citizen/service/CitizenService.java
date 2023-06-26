package com.citizenportal.citizen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citizenportal.citizen.model.CitizenModel;
import com.citizenportal.citizen.repository.CitizenRepository;

@Service
public class CitizenService {

    @Autowired
    CitizenRepository citizenRepository;

    public CitizenModel CreateCitizen(CitizenModel citizenModel) {
        return citizenRepository.save(citizenModel);
    }

}
