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
import br.com.conexaoporto.springbootAPI.model.entities.Profissional;
import br.com.conexaoporto.springbootAPI.model.repositories.ProfissionalRepository;

@Controller
@RequestMapping
public class ProfissionalController {
	
	@Autowired
	ProfissionalRepository profissionalRepo;//contem os metodos que vão fazer o CRUD
	
	@GetMapping("/NovoProfissional")//<- anotação para tratamento de metodos GET
	public String mostrarCadastro(Profissional profissional) {//A magica do spring entende a 
		return "novo-profissional";//o retorno deve ser uma string com o nome da pagina que você quer acessar
	}
	
	//EXEMPLO CADASTRO
	@PostMapping("/CadastroProfissional")//<- anotação para tratamento de metodos POST
	private String novoProfissional(@Valid Profissional profissional, BindingResult result, Model model) { //BidingResult para validação de dados, Model é para passar dados de volta para o thymeleaf
		if (profissionalRepo.findByEmail(profissional.getEmail()) != null) {
			result.addError(new ObjectError("profissional.email", "email já cadastrado"));//TODO: descobrir como retornar esse erro para o thymeleaf e exibir na pagina
			//System.out.println(result.hasFieldErrors("profissional.email"));
		}
		
		if (result.hasErrors()) {
			return "novo-profissional";
		}
		profissionalRepo.save(profissional);//salva no banco
		return "redirect:/ListarProfissionais";
	}
	
	//EXEMPLO LISTAR DADOS (todos)
	@GetMapping("/ListarProfissionais")
	public String listaProfissionais(Model model) {
		model.addAttribute("profissionais", profissionalRepo.findAll());//o primeiro parametro de addAtribute é o nome do atributo que vai ser enviado ao thymeleaf
		return "lista-profissionais";
	}
	
	//TODO: CRIAR PAGINA HTML PARA E TRATAR DADOS PELO THYMELEAF, não ta implementado ainda
	//EXEMPLO LISTAR DADOS (especifico)
	@PostMapping("perfil/{email}")//indica que a variavel vai ser enviada pela barra de endereços
	public String exibirDadosProfissional(@PathVariable(name = "email") String email, Model model) {//@PathVariavel associa a variavel da barra de endereços ao parametro fornecido
		
		model.addAttribute("usuario", profissionalRepo.findByEmail(email));
		
		return "perfil-profissional";
	}
	
	
	
}
