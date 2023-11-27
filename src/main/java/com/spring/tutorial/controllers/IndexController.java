package com.spring.tutorial.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.tutorial.models.Player;
import com.spring.tutorial.models.Team;

@Controller
public class IndexController {
	
	@GetMapping(value="/teams/{name}/{number}")
	public String pathParameters(@PathVariable String name, @PathVariable("number") Integer number, Model model) {
		model.addAttribute("title", "Get values from URL");
		
		// esta declaracion permite hacer una busqueda en las listas de equipos, buscara el nombre del equipo  en los arrays de Teams, retornara el equipo cuyo nombre se haya
		// recibido y lo guardara en teamOptional
		Optional<Team> teamOptional = getTeams().stream().filter(team -> name.equals(team.getName())).findFirst();
		// valido que el nombre del equipo existe
		if (teamOptional.isPresent()) {
			// si el equipo existe, busco el jugador con el numero que me dieron desde la URL
			Optional<Player> playerOptional = teamOptional.get().getSquad().stream().filter(player -> number == player.getNumber()).findFirst();
			
			// si el jugador existe, agrego el atributo player al modelo para mostrarlo en la vista
			if (playerOptional.isPresent()) {
				model.addAttribute("team", teamOptional.get());
				model.addAttribute("player", playerOptional.get());
			}
		}
		return "indexYeey";
	}
	
	private List<Team> getTeams() {
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
