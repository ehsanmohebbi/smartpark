package com.smartpark.model;

public enum ParkingTypeEnum {

	PUBLIC_INDOOR_INTELLIGENT_P(1),
	PUBLIC_INDOOR_NON_INTELLIGENT_P(2),
	PUBLIC_OUTDOOR_INTELLIGENT_P(3),
	PUBLIC_OUTDOOR_NON_INTELLIGENT_P(4),
	PRIVATE_INDOOR_P(5),
	PRIVATE_OUTDOOR_P(6);
	
	int value;
	
	ParkingTypeEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
	
