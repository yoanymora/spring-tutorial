package com.spring.tutorial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	@GetMapping("/params")
	// this is the way to use parameters from a URL
	public String params(@RequestParam(defaultValue = "") String param1, @RequestParam(defaultValue = "", name="second_param") String param2, Model model) {
		model.addAttribute("title", "Get values from URL params");
		// el primer valor se llama param1, en la URL se manda como param1=""
		model.addAttribute("param1", param1);
		// el segundo valor se llama param2, en la URL se manda como second_param=""
		model.addAttribute("param2", param2);
		
		return "indexYeey";
	}
}
