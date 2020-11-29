package br.com.conexaoporto.springbootAPI.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class DefaultController {
	
	@GetMapping(value= {"/", "/index"})//redireciona todos o requests GET do diretorio padrão (/) e (/index)
	public String indexRedirect(){
		return "home";
	}
	
}
