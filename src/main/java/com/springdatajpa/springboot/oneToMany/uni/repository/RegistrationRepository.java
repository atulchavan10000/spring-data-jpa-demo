package com.springdatajpa.springboot.oneToMany.uni.repository;

import com.springdatajpa.springboot.oneToMany.uni.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
}
