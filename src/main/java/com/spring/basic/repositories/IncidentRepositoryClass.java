package com.spring.basic.repositories;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.spring.basic.entity.Incident;
import com.spring.basic.entity.Incident.IncidentType;
import com.spring.basic.entity.Incident.Priority;

@Repository
public class IncidentRepositoryClass {

	static List<Incident> INCIDENT_RECORDS = Arrays.asList(new Incident(1, "B2B", Priority.HIGH, IncidentType.P1),
			new Incident(2, "B2B", Priority.LOW, IncidentType.P2),
			new Incident(3, "B2B", Priority.MEDIUM, IncidentType.P3),
			new Incident(4, "B2B", Priority.HIGH, IncidentType.P1),
			new Incident(5, "B2B", Priority.MEDIUM, IncidentType.P4),
			new Incident(6, "B2C", Priority.LOW, IncidentType.P4));

	public List<Incident> fetchAllIncidents() {
		// TODO Auto-generated method stub
		return INCIDENT_RECORDS;
	}

	public Incident fetchById(int id) {
		// TODO Auto-generated method stub
		return INCIDENT_RECORDS.stream().filter(incident -> incident.getId() == id).findFirst()
				.orElseThrow(() -> new NoSuchElementException("No record found"));

	}

	public List<Incident> sortByPriority(String order) {
		// TODO Auto-generated method stub

		System.out.println("order is "+ order);
		Map<Priority, Integer> priorityOrder = Map.of(Priority.HIGH, 1, Priority.MEDIUM, 2, Priority.LOW, 3);

		if ("asc".equalsIgnoreCase(order)) {
			INCIDENT_RECORDS.sort(Comparator.comparing(task -> priorityOrder.get(task.getPriority()))); // LOW → HIGH
			System.out.println("Inside low to high sorting");
		} else {
			{
			INCIDENT_RECORDS.sort(
					Comparator.comparing(task -> priorityOrder.get(task.getPriority()), Comparator.reverseOrder())); // HIGH
			System.out.println("Inside high to low sorting"); // →
			// LOW
			}
		}

		return INCIDENT_RECORDS;
	}

	public List<Incident> sortByIncidentType(String order) {
		// TODO Auto-generated method stub
		Map<IncidentType, Integer> incidentTypeOrder = Map.of(IncidentType.P1, 1, IncidentType.P2, 2, IncidentType.P3,
				3, IncidentType.P4, 4);
		if ("asc".equalsIgnoreCase(order)) {
			INCIDENT_RECORDS.sort(Comparator.comparing(task -> incidentTypeOrder.get(task.getIncidentType())));
			System.out.println("Inside P1 to P4 sorting");
		}
		else
		{
			INCIDENT_RECORDS.sort(Comparator.comparing(task -> incidentTypeOrder.get(task.getIncidentType()), Comparator.reverseOrder()));
			System.out.println("Inside P4 to P1 sorting");
		}
		return INCIDENT_RECORDS;
	}

	public String addNewIncident(Incident incident) {
		// TODO Auto-generated method stub
		
		INCIDENT_RECORDS.add(incident);
		return "Incident saved";
	}

}
