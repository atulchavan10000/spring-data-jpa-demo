package com.springdatajpa.springboot.oneToMany.uni.service;

import com.springdatajpa.springboot.oneToMany.uni.entity.Registration;
import com.springdatajpa.springboot.oneToMany.uni.entity.Tournament;
import com.springdatajpa.springboot.oneToMany.uni.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    @Autowired
    TournamentRepository repo;

    public List<Tournament> allTournaments(){
        return repo.findAll();
    }

    public Tournament getTournament(int id){
        return repo.findById(id).get();
    }

    public Tournament addTournament(Tournament tournament){
        tournament.setId(0);
        return repo.save(tournament);
    }

    public void deleteTournament(int id){
        repo.deleteById(id);
    }

    public Tournament addRegistration(int id, Registration registration){
        Tournament tournament = repo.findById(id).get();
        tournament.addRegistration(registration);
        return repo.save(tournament);
    }


    public Tournament removeRegistration(int id, Registration registration){
        Tournament tournament = repo.findById(id).get();
        tournament.removeRegistration(registration);
        return repo.save(tournament);
    }
}
