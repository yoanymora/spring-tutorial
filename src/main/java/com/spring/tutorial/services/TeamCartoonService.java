package com.spring.tutorial.services;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spring.tutorial.models.Player;
import com.spring.tutorial.models.Team;

@Service
// este decorador indica que, en el controlador, este servicio sera implmenetado si no se especifica el servicio a implementar
@Primary
public class TeamCartoonService implements InterfaceTeamServices {

	@Override
	public List<Team> getTeams() {
		Team avatar = new Team();
		avatar.setName("Avatar");
		avatar.addPlayer(new Player("Aang", 1));
		avatar.addPlayer(new Player("Katara", 2));
		avatar.addPlayer(new Player("Soka", 3));
		
		Team edededdy = new Team();
		edededdy.setName("EdEd&Eddy");
		edededdy.addPlayer(new Player("Ed", 1));
		edededdy.addPlayer(new Player("Ed", 2));
		edededdy.addPlayer(new Player("Eddy", 3));
		
		return List.of(avatar, edededdy);
	}

}
