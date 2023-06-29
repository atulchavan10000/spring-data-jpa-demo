package com.springdatajpa.springboot.oneToOne.repository;

import com.springdatajpa.springboot.oneToOne.entity.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, Integer> {
}
