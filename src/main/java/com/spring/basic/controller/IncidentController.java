package com.spring.basic.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.basic.entity.Incident;
import com.spring.basic.repositories.IncidentRepository;
import com.spring.basic.service.IncidentService;

@RestController
@RequestMapping("/incident")
public class IncidentController {

	private final IncidentService incidentService;

	public IncidentController(IncidentService incidentService) {
		this.incidentService = incidentService;
	}

	@Autowired
	private IncidentRepository incidentRepository;

	@GetMapping("/allIncident")
	public List<Incident> getAllIncidents() {
		return incidentService.getAllIncident();

	}

	@GetMapping("/id/{id}")
	public Incident getIncidentById(@PathVariable int id) {
		return incidentService.getIncidentById(id);

	}

	@GetMapping("/sort/priority")
	public List<Incident> sortByPriority(@RequestParam(defaultValue = "desc", required = false) String order) {
		return incidentService.sortByPriority(order);

	}

	@GetMapping("/sort/incident-type")
	public List<Incident> sortByIncidentType(@RequestParam(defaultValue = "asc", required = false) String order) {
		return incidentService.sortByIncidentType(order);

	}

	// ***********************************Using DB Repo
	// ******************************************

	@PostMapping("/add/newIncident")
	public Incident createIncident(@RequestBody Incident incident) {
		return incidentRepository.save(incident);

	}

	@GetMapping("/retrieve/allIncident")
	public List<Incident> retieveAll() {
		return incidentRepository.findAll();

	}

	@GetMapping("/retrieve/incidentById/{id}")
	public Optional<Incident> retieveIncidentById(@PathVariable int id) {
		return incidentRepository.findById(id);

	}

	@GetMapping("/retieve/incidentByPriority")
	public List<Incident> sortByPriority1(@RequestParam(defaultValue = "desc") String order) {

		List<Incident> incidents = incidentRepository.findAll();

		Comparator<Incident> comparator = Comparator.comparingInt(i -> i.getPriority().getRank());

		if ("desc".equalsIgnoreCase(order)) {
			comparator = comparator.reversed();
		}

		List<Incident> sorted = incidents.stream().sorted(comparator).toList();
		sorted.forEach(i -> System.out
				.println(i.getApplicationName() + " - " + i.getPriority() + " (" + i.getPriority().getRank() + ")"));

		return incidents.stream().sorted(comparator).toList();
	}
	
	@GetMapping("/retrieve/incidentByIncidentType")	
	public List<Incident> sortByIncidentType1(@RequestParam(defaultValue = "asc") String order){
		
		List<Incident> incidents=incidentRepository.findAll();
		Comparator<Incident> comparator= Comparator.comparingInt(i->i.getIncidentType().getIncRank());
		if(order.equalsIgnoreCase("desc")) {
			comparator=comparator.reversed();
		}
		return incidents.stream().sorted(comparator).toList();
		
	}

}
