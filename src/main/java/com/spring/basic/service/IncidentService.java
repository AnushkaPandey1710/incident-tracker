package com.spring.basic.service;

import java.util.List;

import com.spring.basic.entity.Incident;

public interface IncidentService {

	List<Incident> getAllIncident();

	Incident getIncidentById(int id);

	List<Incident> sortByPriority(String order);

	List<Incident> sortByIncidentType(String order);


}
