package com.entities;

public class Character implements IEntity, IThing<Character.BodyType>{
	private String name;
	private BodyType bodyType;
	private Clothing clothing;
	private Hairstyles hairStyle;
	
	public Character(String name) {
		this.name = name;
	}
	
	public Character(String name, BodyType bodyType) {
		this.name = name;
		this.bodyType = bodyType;
	}
	
	public Character(String name, BodyType bodyType, Clothing clothing) {
		this.name = name;
		this.bodyType = bodyType;
		this.clothing = clothing;
	}
	
	public Character(String name, BodyType bodyType, Clothing clothing, Hairstyles hairStyle) {
		this.name = name;
		this.bodyType = bodyType;
		this.clothing = clothing;
		this.hairStyle = hairStyle;
	}
	
	public enum BodyType {
		A,
		B,
		C,
		D,
		E,
		F,
		G,
		H
	}
	
	public enum Clothing {
		Bandit,
		Beggar,
		LightArmour,
		HeavyArmour,
		Merchant,
		Noble,
		Naked,
		Peasant,
		Priest
	}
	
	public enum Hairstyles {
		Long,
		Spiky,
		Short
	}
	
	public BodyType getBody() {
		return this.bodyType;
	}
	
	public Clothing getClothing() {
		return this.clothing;
	}
	
	public Hairstyles gethair() {
		return this.hairStyle;
	}
	
	public String getName() {
		return this.name;
	}
	
	public BodyType getTemplate() {
		return this.bodyType;
	}

	
}
