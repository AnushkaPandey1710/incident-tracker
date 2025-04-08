package com.spring.basic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.basic.entity.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Integer> {

}
