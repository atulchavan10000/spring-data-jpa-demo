package com.springdatajpa.springboot.oneToMany.uni.controller;

import com.springdatajpa.springboot.oneToMany.uni.entity.Registration;
import com.springdatajpa.springboot.oneToMany.uni.entity.Tournament;
import com.springdatajpa.springboot.oneToMany.uni.service.RegistrationService;
import com.springdatajpa.springboot.oneToMany.uni.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @Autowired
    RegistrationService registrationService;

    @GetMapping
    public List<Tournament> allTournaments(){
       return tournamentService.allTournaments();
    }

    @GetMapping("/{id}")
    public Tournament getTournament(@PathVariable int id){
        return tournamentService.getTournament(id);
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament){
        return tournamentService.addTournament(tournament);
    }

    @PutMapping("/{id}/registrations/{registration_id}")
    public Tournament addRegistration(@PathVariable int id, @PathVariable int registration_id){
        Registration registration = registrationService.getRegistration(registration_id);
        System.out.println(registration);
        return tournamentService.addRegistration(id, registration);
    }

    @PutMapping("/{id}/remove_registrations/{registration_id}")
    public Tournament removeRegistration(@PathVariable int id, @PathVariable int registration_id){
        Registration registration = registrationService.getRegistration(registration_id);
        System.out.println(registration);
        return tournamentService.removeRegistration(id, registration);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable int id){
        tournamentService.deleteTournament(id);
    }
}
