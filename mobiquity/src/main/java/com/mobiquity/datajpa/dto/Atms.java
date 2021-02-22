package com.mobiquity.datajpa.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Atms{
    public Address address;
    public int distance;
    public List<OpeningHour> openingHours;
    
    
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public void setOpeningHours(List<OpeningHour> openingHours) {
		this.openingHours = openingHours;
	}
	public Address getAddress() {
		return address;
	}
	public int getDistance() {
		return distance;
	}
	public List<OpeningHour> getOpeningHours() {
		return openingHours;
	}
    
    
}
