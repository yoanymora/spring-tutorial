package com.spring.tutorial.models;

import java.util.ArrayList;
import java.util.List;

public class Team {
	
	public Team() {
		squad = new ArrayList();
	}

	private String name;
	private List<Player> squad;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getSquad() {
		return squad;
	}

	public void setSquad(List<Player> squad) {
		this.squad = squad;
	}

	public Team(String name, List<Player> squad) {
		this.name = name;
		this.squad = squad;
	}

	public void addPlayer(Player player) {
		squad.add(player);
	}
}
