package com.entities;

class Furniture implements IEntity {
	private String name;
	
	Furniture(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}
}
