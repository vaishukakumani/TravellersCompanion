package com.travellerApp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="itineraries")
public class Itinerary {
	@Id
	@Column(name="itinerary_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int itineraryId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@NotNull
	private User user;
	
	
	@Column(name="itinerary_name",unique=true)
	@NotNull
	private String itineraryName;
	
	@Column(name="departure_airport")
	private String departureAirport;
	
	@Column(name="language")
	private String language;
	
	@Column(name="departure_date")
	private Date departureDate;
	
	@Column(name="number_people")
	private int numberPeople;
	
	public String getItineraryName() {
		return itineraryName;
	}
	public void setItineraryName(String itineraryName) {
		this.itineraryName = itineraryName;
	}
	
	public int getItineraryId() {
		return itineraryId;
	}
	public void setItineraryId(int itineraryId) {
		this.itineraryId = itineraryId;
	}
	
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public int getNumberPeople() {
		return numberPeople;
	}
	public void setNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
