package com.titansupport;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tickets") // Set the database table to be named "Tickets"
public class Ticket {

	@Id
	@GeneratedValue
	@Column(name = "ID") // Generate an ID for every Ticket
	public Integer id;

	@Column(name = "Name") // Store the user's name
	public String name;

	@Column(name = "Date") // Store the Date of the ticket, normally going to be LocalDate.now()
	public LocalDate date;

	@Column(name = "Problem")
	public String problemString; // The Ticket Description

	public Ticket() {
	} // Empty object creator

	public Ticket(String name, LocalDate date, String problemString) { // Loaded object creator
		this.name = name;
		this.date = date;
		this.problemString = problemString;
	}

	public Integer getID() { // Return the Ticket ID
		return id;
	}

	public String getDesc() { // Return the Ticket description
		return problemString;
	}

	public void setProblemString(String problemString) { // Set the Ticket description
		this.problemString = problemString;
	}

	public LocalDate getDate() { // Return the date of the Ticket
		return date;
	}

	public void setDate(LocalDate date) { // Set the date of the Ticket
		this.date = date;
	}

	public String getName() { // Return the Name of the user
		return name;
	}

	public void setName(String name) { // Set the Name of the user
		this.name = name;
	}
}
