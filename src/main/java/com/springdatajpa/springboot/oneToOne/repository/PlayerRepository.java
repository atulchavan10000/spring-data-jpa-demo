package com.springdatajpa.springboot.oneToOne.repository;

import com.springdatajpa.springboot.oneToOne.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
