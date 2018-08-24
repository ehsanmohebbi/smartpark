package com.smartpark.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.smartpark.model.Parcare;

@Path("/parcare")
public class DataProviderService {
	
	@GET
	@Path("/getall")
	@Produces("application/json")
	
	public ArrayList<Parcare> getAllParcare() {

		ArrayList<Parcare> parcare = new ArrayList<Parcare>();
		Parcare p = new Parcare();
		p.setType("Public Parking");
		p.setAddress("Str Napoca nr 45");
		p.setLatitude(36.385913);
		p.setLongitude(-127.441406);
		p.setTotalSlots(1000);
		
		parcare.add(p);
		return parcare; 
	}

	
}
