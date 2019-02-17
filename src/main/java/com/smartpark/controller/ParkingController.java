package com.smartpark.controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.smartpark.model.Parking;
import com.smartpark.service.ParkingService;



@Path("/parcare")
public class ParkingController  {

	@GET
	@Path("/")
	@Produces("application/json")
	public ArrayList<Parking> getAllParkings() {
		ArrayList<Parking> allParkingLots = ParkingService.getAllParkings();
		return allParkingLots; 
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Parking getById(@PathParam("id") String id) {
		Parking p = ParkingService.getById(id);
		return p;
	}
	
}