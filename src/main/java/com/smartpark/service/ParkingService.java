package com.smartpark.service;

import java.util.ArrayList;
import java.util.Collection;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.smartpark.dao.DatabaseController;
import com.smartpark.model.Parking;
import com.smartpark.model.ParkingTypeEnum;
import com.smartpark.model.Point;


public class ParkingService {
	
	
	public static ParkingTypeEnum typeVerifier(int v) {
		ParkingTypeEnum t = ParkingTypeEnum.PUBLIC_INDOOR_INTELLIGENT_P;
		
		switch(v) {
		case 1: 
			return t = ParkingTypeEnum.PUBLIC_INDOOR_INTELLIGENT_P;
		case 2:
			return t = ParkingTypeEnum.PUBLIC_INDOOR_NON_INTELLIGENT_P;
		case 3:
			return t = ParkingTypeEnum.PUBLIC_OUTDOOR_INTELLIGENT_P;
		case 4:
			return t = ParkingTypeEnum.PUBLIC_OUTDOOR_NON_INTELLIGENT_P;
		case 5:
			return t = ParkingTypeEnum.PRIVATE_INDOOR_P;
		case 6:
			return t = ParkingTypeEnum.PRIVATE_OUTDOOR_P;
		}
		
		return t;
	}
	
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Parking> getAllParkings() {

		ArrayList<Parking> parcare = new ArrayList<Parking>();
		DatabaseController dbController;
	   	FindIterable<Document> it;
	   	Parking p;
	   	ParkingTypeEnum t;
	   	ArrayList<Double> coordinates = new ArrayList<>();
	   	Point point = new Point();
	   	dbController = new DatabaseController();
	   	
	   	
	   	it = dbController.getAllParking();
	  	for (Document doc : it) {
	  		p = new Parking();
	  		p.setId(doc.getObjectId("_id").toString());
	  		t = typeVerifier((int)((double)doc.getDouble("type")));
	  		p.setType(t);
	  		p.setAddress(doc.getString("address"));
	  		
	  		Document subdoc = (Document) doc.get("location");
	  		coordinates.addAll(0,(Collection<? extends Double>) subdoc.get("coordinates"));
	  		point.setLatitude(coordinates.get(0));
	  		point.setLongitude(coordinates.get(1));
	  		coordinates.clear();
	  		p.setPoint(point);
	  		p.setTotalParkingLots((int)((double)doc.getDouble("totalParkingLots")));
	  		p.setDetails(doc.getString("details"));
	  		parcare.add(0,p);
	  	}
		return parcare; 
	}
	
	public static Parking getById(String id) {
		Parking p = new Parking();
		DatabaseController dbController;
	   	FindIterable<Document> it;
	   	ParkingTypeEnum t;
	   	ArrayList<Double> coordinates = new ArrayList<>();
	   	Point point = new Point();
	   	dbController = new DatabaseController();
	   	System.out.println("ID Service  "+id);
	   	
	   	it = dbController.getById(id);
	  	for (Document doc : it) {
	  		p = new Parking();
	  		p.setId(doc.getObjectId("_id").toString());
	  		t = typeVerifier((int)((double)doc.getDouble("type")));
	  		p.setType(t);
	  		p.setAddress(doc.getString("address"));
	  		
	  		Document subdoc = (Document) doc.get("location");
	  		coordinates.addAll(0,(Collection<? extends Double>) subdoc.get("coordinates"));
	  		point.setLatitude(coordinates.get(0));
	  		point.setLongitude(coordinates.get(1));
	  		coordinates.clear();
	  		p.setPoint(point);
	  		p.setTotalParkingLots((int)((double)doc.getDouble("totalParkingLots")));
	  		p.setDetails(doc.getString("details"));
	  	}
		return p; 
	}

	
}
