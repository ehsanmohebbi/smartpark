package com.smartpark.model;

public class Point {
	double latitude;
	double longitude;
	
	//Latitude get and set
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double lat) {
		this.latitude = lat;
	}
	
	//Longitude get and set
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double lon) {
		this.longitude = lon;
	}
	
	@Override
	public String toString() {
		return " latitude = " + latitude + " longitude = " + longitude;
	}
}
