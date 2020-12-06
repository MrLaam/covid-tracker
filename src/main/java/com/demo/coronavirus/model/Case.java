package com.demo.coronavirus.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Case {
	
	@JsonProperty("Country")
	private String country;
	@JsonProperty("CountryCode")
	private String countryCode;
	@JsonProperty("lat")
	private double latitude;
	@JsonProperty("Lon")
	private double longitude;
	@JsonProperty("Cases")
	private int cases;
	@JsonProperty("Status")
	private String status;
	@JsonProperty("Date")
	private Date date;
	
	private Date latestDate;
	private String formattedDate;
	private String formattedCases;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public int getCases() {
		return cases;
	}
	public void setCases(int cases) {
		this.cases = cases;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setLatestDate(Date latestDate) {
		this.latestDate = latestDate;
	}
	public String getFormattedDate() {
		return formattedDate;
	}
	
	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}
	public String getFormattedCases() {
		return formattedCases;
	}
	
	public void setFormattedCases(String formattedCases) {
		this.formattedCases = formattedCases;
	}
	
	@Override
	public String toString() {	
		return "Cases [country=" + country + ", countryCode=" + countryCode + ", latitude=" + latitude + ", longitude="
				+ longitude + ", cases=" + cases + ", status=" + status + ", date=" + date + "]";
	}
	
}
