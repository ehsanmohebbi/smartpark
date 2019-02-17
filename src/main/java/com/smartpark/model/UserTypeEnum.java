package com.smartpark.model;

public enum UserTypeEnum {
	ADMIN(1),
	DRIVER(2);
	
	int i;

	UserTypeEnum(int i){
		this.i = i;
	}
	
	public int getValue() {
		return i;
	}

}
