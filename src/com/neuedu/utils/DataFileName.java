package com.neuedu.utils;

public enum DataFileName {
	ORDER("order"),
	USER("user"),
	PRODUCT("product"),
	PRODUCTMSG("productmsg"),
	EQUIPMENTTYPE("equipmenttype"),
	EQUIPMENTMANAGER("equipmentmanager");
	
	
	public String getName() {
		return name;
	}

	private String name;

	private DataFileName(String name) {
		this.name = name;
	}
	

}
