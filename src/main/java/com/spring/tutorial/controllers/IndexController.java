package com.spring.tutorial.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@GetMapping(value = "/index-mv")
	public ModelAndView indexMV(ModelAndView mv) {
		mv.addObject("title", "Hola mundo con modelAndView");
		mv.addObject("body", "El contenido de Hola mundo con ModelAndview");
		
		mv.addObject("show", true);
		List<String> ramdomShit = List.of("1", "Casa", "false", "Mikasa", "666");
		mv.addObject("ramdomShit", ramdomShit);
		mv.setViewName("indexYeey");
		return mv;
	}
	
}
