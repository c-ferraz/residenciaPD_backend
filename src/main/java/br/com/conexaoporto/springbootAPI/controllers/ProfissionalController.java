package br.com.conexaoporto.springbootAPI.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "redirect:/login";
	}
	
	@PostMapping("login")
	public String login(@RequestParam(name= "email") String email,
			@RequestParam(name= "senha") String senha,
			Model model,
			HttpSession session) {

		Profissional usuario = profissionalRepo.findByEmail(email) != null ? profissionalRepo.findByEmail(email) : null;
		if ((usuario != null) && usuario.getSenha().contentEquals(senha)) {
			session.setAttribute("userId", usuario.getCodUsuario());
			session.setAttribute("userEmail", usuario.getEmail());
			session.setMaxInactiveInterval(60); // TODO: alterar para um numero maior quando terminar de testar
			return "redirect:/home";
		} else {
			model.addAttribute("erroDeAutenticacao", (usuario == null) ? "Esse e-mail não está cadastrado no sistema." : "Senha incorreta.");
			return "login";
		}
	}
	

	
}
