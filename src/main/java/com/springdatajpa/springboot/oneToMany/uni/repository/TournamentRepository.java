package com.springdatajpa.springboot.oneToMany.uni.repository;

import com.springdatajpa.springboot.oneToMany.uni.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
}
