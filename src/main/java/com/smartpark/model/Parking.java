package com.smartpark.model;



public class Parking {
	String id;
	ParkingTypeEnum type;
	String address;
	int totalParkingLots;
	String details;
	Point point;
	
	
	//id get and set
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	//type get and set
	public ParkingTypeEnum getType(){
		return type;
	}
	
	public void setType(ParkingTypeEnum i) {
		this.type = i;
	}
	
	//Address get and set
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String a) {
		this.address = a;
	}
	
	
	//TotalSlots get and set
	public int getTotalParkingLots() {
		return totalParkingLots;
	}
	
	public void setTotalParkingLots(int tpl) {
		this.totalParkingLots = tpl;
	}
	
	//Details get and set
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String dt) {
		this.details = dt; 
	}
	
	//Point get and set
	public Point getPoint() {
		return point;
	}
	
	public void setPoint(Point p) {
		this.point = p;
	}
	
	@Override
	public String toString() {
		return "Parcare [type=" + type + ", address=" + address + ", TotalSlots No=" + totalParkingLots + point + "]";
	}

}



