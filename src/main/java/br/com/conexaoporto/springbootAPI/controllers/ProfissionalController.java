package br.com.conexaoporto.springbootAPI.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.conexaoporto.springbootAPI.model.entities.Profissional;
import br.com.conexaoporto.springbootAPI.model.repositories.ProfissionalRepository;

@Controller
@RequestMapping
public class ProfissionalController {
	
	@Autowired
	ProfissionalRepository profissionalRepo;
	
	@PostMapping("/CadastrarProfissional")
	public String cadastro (@RequestParam(name= "nome") String nome,
			@RequestParam(name="senha") String senha,
			@RequestParam(name="email") @Valid String email,
			Model model)
			 {
		if (profissionalRepo.findByEmail(email) != null) {
			model.addAttribute("emailError", "O email informado já esta cadastrado.");
			return "cadastro";
		}
		
		profissionalRepo.save(new Profissional(nome, email, senha));
		//return "redirect:/testListarProfissionais";
		return "home";
	}
	
	@PostMapping("login")
	public boolean login(@RequestParam(name= "email") String email,
			@RequestParam(name= "senha") String senha,
			Model model) {

		Profissional usuario = profissionalRepo.findByEmail(email);
		if (usuario.getSenha() == senha) {
			return true;
		}
		
		return false;
	}
	
}
