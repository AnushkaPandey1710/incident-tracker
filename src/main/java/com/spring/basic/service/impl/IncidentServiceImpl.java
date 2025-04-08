package com.spring.basic.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.basic.entity.Incident;
import com.spring.basic.repositories.IncidentRepository;
import com.spring.basic.repositories.IncidentRepositoryClass;
import com.spring.basic.service.IncidentService;

@Service
public class IncidentServiceImpl implements IncidentService{
	
	private final IncidentRepositoryClass incidentRepository;
	public IncidentServiceImpl(IncidentRepositoryClass incidentRepository) {
		this.incidentRepository= incidentRepository;
	}

	@Override
	public List<Incident> getAllIncident() {
		// TODO Auto-generated method stub
		return incidentRepository.fetchAllIncidents();
	}

	@Override
	public Incident getIncidentById(int id) {
		// TODO Auto-generated method stub
		return incidentRepository.fetchById(id);
	}

	@Override
	public List<Incident> sortByPriority(String order) {
		// TODO Auto-generated method stub
		return incidentRepository.sortByPriority(order);
	}

	@Override
	public List<Incident> sortByIncidentType(String order) {
		// TODO Auto-generated method stub
		return incidentRepository.sortByIncidentType(order);
	}

	

}
