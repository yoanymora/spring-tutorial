package com.spring.tutorial.models;

public class Player {

	private String name;
	private Integer number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Player(String name, Integer number) {
		this.name = name;
		this.number = number;
	}
	
}
