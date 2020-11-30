package br.com.conexaoporto.springbootAPI.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class DefaultController {
	
	@GetMapping(value= {"/", "/index", "/index.html"})//redireciona todos o requests GET do diretorio padrão (/) e (/index)
	public String indexRedirect(){
		return "home";
	}
	
	@GetMapping(value= "/login.html")
	public String loginRedirect() {
		return "login";
	}
	
	@GetMapping(value= "/cadastro.html")
	public String cadastroRedirect() {
		return "cadastro";
	}
	
	@GetMapping(value= "/test")
	public String testRedirect() {
		return "/test/home";
	}
}
