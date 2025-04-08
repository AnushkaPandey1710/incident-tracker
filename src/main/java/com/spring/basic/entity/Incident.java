package com.spring.basic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Incident {

	private String applicationName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public enum Priority {
		LOW(1), MEDIUM(2), HIGH(3);

		private final int rank;

		Priority(int rank) {
			// TODO Auto-generated constructor stub

			this.rank = rank;
		}

		public int getRank() {
			return rank;
		}

	}

	@Enumerated(EnumType.STRING)
	private Priority priority;

	public enum IncidentType {
		P1(1), P2(2), P3(3), P4(4);

		private int getIncRank;

		IncidentType(int getIncRank) {
			// TODO Auto-generated constructor stub
			this.getIncRank = getIncRank;
		}

		public int getIncRank() {
			return getIncRank;
		}
	}

	@Enumerated(EnumType.STRING)
	private IncidentType incidentType;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public IncidentType getIncidentType() {
		return incidentType;
	}

	public void setIncidentType(IncidentType incidentType) {
		this.incidentType = incidentType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Incident(int id, String applicationName, Priority priority, IncidentType incidentType) {
		super();
		this.id = id;
		this.applicationName = applicationName;
		this.priority = priority;
		this.incidentType = incidentType;
	}

	public Incident() {
		super();
		// TODO Auto-generated constructor stub
	}

}
