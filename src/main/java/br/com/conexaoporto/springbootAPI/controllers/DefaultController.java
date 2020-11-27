package br.com.conexaoporto.springbootAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping
public class DefaultController {
	
	@GetMapping("/")
	private RedirectView indexRedirect() {
		
		return new RedirectView("/index.html");//um objeto RedirectView redireciona para a pagina especificado no construtor
	}
}
