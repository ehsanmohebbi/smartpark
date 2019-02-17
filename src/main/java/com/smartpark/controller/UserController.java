package com.smartpark.controller;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.smartpark.model.User;
import com.smartpark.service.UserService;

@Path("/user")
public class UserController {
	
	@GET
	@Path("/")
	@Produces("application/json")
	public ArrayList<User> getAllUser(){
		ArrayList<User> allUser = UserService.getAllUser();
		return allUser;
	}

}
