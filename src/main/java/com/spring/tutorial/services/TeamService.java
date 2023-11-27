package com.spring.tutorial.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.tutorial.models.Player;
import com.spring.tutorial.models.Team;

@Service
public class TeamService implements InterfaceTeamServices {
	/* Este servicio contiene la logica de negocios, en lugar de crear la clase en el controlador la creo en un paquete Servicio */
	public List<Team> getTeams(){
		Team naruto = new Team();
		naruto.setName("Naruto");
		naruto.addPlayer(new Player("Naruto", 1));
		naruto.addPlayer(new Player("Sakura", 2));
		naruto.addPlayer(new Player("Sasuke", 3));
		
		Team jujutsu = new Team();
		jujutsu.setName("Jujutsu");
		jujutsu.addPlayer(new Player("Itadori", 1));
		jujutsu.addPlayer(new Player("Fukoshima", 2));
		jujutsu.addPlayer(new Player("Goyu", 3));
		
		return List.of(naruto, jujutsu);
	}
}
