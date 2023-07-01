package com.springdatajpa.springboot.oneToMany.uni.service;

import com.springdatajpa.springboot.oneToMany.uni.entity.Registration;
import com.springdatajpa.springboot.oneToMany.uni.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    public List<Registration> allRegistrations(){
        return registrationRepository.findAll();
    }

    public Registration getRegistration(int id){
        return registrationRepository.findById(id).get();
    }

    public Registration addRegistration(Registration registration){
        registration.setId(0);
        return registrationRepository.save(registration);
    }

    public void deleteRegistration(int id) {
        registrationRepository.deleteById(id);
    }
}
