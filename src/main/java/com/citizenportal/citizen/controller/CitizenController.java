package com.citizenportal.citizen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citizenportal.citizen.model.CitizenModel;
import com.citizenportal.citizen.service.CitizenService;

import ch.qos.logback.core.joran.conditional.ElseAction;

@RestController
@RequestMapping("/citizen/v1/")
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody CitizenModel citizen) {
        if (citizen.getName().equals("")) {
            return new ResponseEntity<String>("Name cannot be blank", HttpStatus.BAD_REQUEST);
        } else if (citizen.getAddress().equals("")) {
            return new ResponseEntity<String>("Address cannot be blank", HttpStatus.BAD_REQUEST);
        } else {
            citizenService.CreateCitizen(citizen);
            return new ResponseEntity<String>("Created Citizen ID: " + citizen.getId(), HttpStatus.OK);
        }
    }
}
