package com.spring.tutorial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class IndexController {
	
	@GetMapping(value = "/") // la ruta a la que tiene que ir mi navegador, esta ruta solo soporta el verbo GET
	public String index(Model model) {
		// de esta manera se pueden pasar valores desde el controlador a la vista
		model.addAttribute("title", "Hola mundo con spring");
		model.addAttribute("body", "El contenido de Hola mundo con spring");
		
		model.addAttribute("show", true);
		return "indexYeey"; // este es el nombre del archivo HTML que retorna este metodo 
	}
	
	/*es buena practica usar el PostMapping o el decorador que tenga el verbo que queremos utilizar pero este es un ejemplo para saber que RequestMApping existe*/
	@RequestMapping(value="/index-request-mapping", method=RequestMethod.GET) // similar al GetMapping, pero aca se especifica que verbo se utilizara para hacer la peticion http 
	public String indexRequestMapping() {
		return "index";
	}
	
}
