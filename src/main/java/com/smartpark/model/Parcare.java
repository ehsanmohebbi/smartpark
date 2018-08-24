package com.smartpark.model;

public class Parcare {
	String type;
	String address;
	double latitude;
	double longitude;
	int totalSlots;
	
	//type get and set
	public String getType(){
		return type;
	}
	
	public void setType(String t) {
		this.type = t;
	}
	
	//Address get and set
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String a) {
		this.address = a;
	}
	
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
	
	//TotalSlots get and set
	public int getTotalSlots() {
		return totalSlots;
	}
	
	public void setTotalSlots(int ts) {
		this.totalSlots = ts;
	}
	
	@Override
	public String toString() {
		return "Parcare [type=" + type + ", address=" + address + ", latitude =" + latitude + ", longitude=" + longitude + ", TotalSlots No=" + totalSlots +"]";
	}

}



