package com.spring.tutorial.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.tutorial.models.Player;
import com.spring.tutorial.models.Team;
import com.spring.tutorial.services.InterfaceTeamServices;

@Controller
public class IndexController {
	
	private InterfaceTeamServices teamService;
	
	// Si quiero implementar la interfaz en lugar de un servicio especifico
	public IndexController(InterfaceTeamServices teamService) {		
		this.teamService = teamService;
	}
	
	@GetMapping(value="/teams/{name}/{number}")
	public String pathParameters(@PathVariable String name, @PathVariable("number") Integer number, Model model) {
		model.addAttribute("title", "Get values from URL");
		
		// esta declaracion permite hacer una busqueda en las listas de equipos, buscara el nombre del equipo  en los arrays de Teams, retornara el equipo cuyo nombre se haya
		// recibido y lo guardara en teamOptional
		Optional<Team> teamOptional = teamService.getTeams().stream().filter(team -> name.equals(team.getName())).findFirst();
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
		return "index";
	}
}
