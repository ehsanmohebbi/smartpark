package com.smartpark.service;

import com.smartpark.model.UserTypeEnum;
import com.mongodb.client.FindIterable;
import com.smartpark.dao.DatabaseController;
import com.smartpark.model.User;
import java.util.ArrayList;

import org.bson.Document;

public class UserService {
	
	public static UserTypeEnum typeVerifier(int v) {
		UserTypeEnum t = UserTypeEnum.ADMIN;
		
		switch(v) {
		case 1: 
			return t = UserTypeEnum.ADMIN;
		case 2:
			return t = UserTypeEnum.DRIVER;
		}
		
		return t;
	}
	
	public static ArrayList<User> getAllUser(){
		ArrayList<User> allUser = new ArrayList<>();
		DatabaseController dbController;
	   	FindIterable<Document> it;
	   	User u;
	   	UserTypeEnum t;
	   	dbController = new DatabaseController();
	   	
	   	it = dbController.getAllUser();
	   	for(Document doc: it) {
	   		u = new User();
	   		u.setId(doc.getObjectId("_id").toString());
	   		t = typeVerifier((int)(double)doc.getDouble("type"));
	   		u.setType(t);
	   		u.setUsername(doc.getString("username"));
	   		u.setPasswd(doc.getString("passwd"));
	   		u.setFirstname(doc.getString("firstname"));
	   		u.setLastname(doc.getString("lastname"));
	   		u.setPhone(doc.getString("phone"));
	   		u.setEmail(doc.getString("email"));
	   		
	   		allUser.add(u);
	   	}
		return allUser;
	}
}
