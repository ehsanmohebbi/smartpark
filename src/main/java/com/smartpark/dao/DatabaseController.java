package com.smartpark.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import com.smartpark.model.Parking;
import com.smartpark.model.ParkingTypeEnum;

public class DatabaseController {
	
	MongoClient mongo;
	MongoDatabase db;
	
	public DatabaseController() {
		// Creating a Mongo client 
		mongo = new MongoClient( "localhost" , 27017 ); 
		
		// Accessing the database 
		db = mongo.getDatabase("smartpark");
	}
	
	public FindIterable<Document> getAllParking() {
		MongoCollection<Document> parking;
		
		// retrieve the parking collection from database
		parking = db.getCollection("parking");
		
		// apply no filter, i.e. return all documents from collection
		return parking.find();
	}
	
	//NEAR
	public FindIterable<Document> getNearParking(Double minDistance, Double maxDistance) {
		MongoCollection<Document> parking;
		FindIterable<Document> it;
		
		// retrieve the parking collection from database
		parking = db.getCollection("parcare");
		
		// filter the documents from collection by $near geospatial feature
		it = parking.find(com.mongodb.client.model.Filters.near(
				"location", // field name care reprezinta locatia
				new Point(new Position(26.056126, 44.445275)), // locatia camin P22
				new Double(1700), // max distance
				new Double(400))); // min distance
		
		return it;
	}
	
	public FindIterable<Document> getAllUser(){
		MongoCollection<Document> user;
		user = db.getCollection("user");
		return user.find();
	}
	
	public FindIterable<Document>getById(String strid) {
		System.out.println(strid);
		ObjectId id = new ObjectId(strid);
		MongoCollection<Document> collection = db.getCollection("parking");
		FindIterable<Document> doc = collection.find(new BasicDBObject("_id",id));
		return doc;
	}
	
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
	
	
	public static void main( String[] args ) {
		DatabaseController dbController;
	   	FindIterable<Document> it;
	   	Parking p = new Parking();
	   	ParkingTypeEnum t;
	   	ArrayList<Double> coordinates = new ArrayList<>();
	    	
	   	dbController = new DatabaseController();
	    	
	   System.out.println("All:");
	  	it = dbController.getAllParking();
	  	for (Document doc : it) {
	  		System.out.println(doc);
	  		p.setId(doc.getObjectId("_id").toString());
	  		//System.out.println("here1");
	  		t = typeVerifier((int)((double)doc.getDouble("type")));
	  		System.out.println(t);
	  		p.setType(t);
	  		p.setAddress(doc.getString("address"));
	  		
	  		Document subdoc = (Document) doc.get("location");
	  		coordinates.addAll(0,(Collection<? extends Double>) subdoc.get("coordinates"));
	  		System.out.println(coordinates+" size of array " +coordinates.size());
	  		coordinates.clear();
	  		
	  		//System.out.println("here is subdoc "+subdoc);
	  		//p.setLatitude(doc.getDouble("coordinates"));
	  		//p.setLongitude(doc.getDouble("coordinates"));
	  		p.setTotalParkingLots((int)((double)doc.getDouble("totalParkingLots")));
	  		p.setDetails(doc.getString("details"));

	  		//System.out.println(p.toString());
	  	}
	        
	  	/*System.out.println("Near:");
	  	it = dbController.getNearParking(0., 1000.);
	  	for (Document doc : it) {
	  		System.out.println(doc);
	  	}*/
	}
	
}
