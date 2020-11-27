package br.com.conexaoporto.springbootAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.conexaoporto.springbootAPI.entities.Profissional;
import br.com.conexaoporto.springbootAPI.repositories.ProfissionalRepository;

@RestController
@RequestMapping
public class ProfissionalController {
	
	@Autowired
	ProfissionalRepository profissionalRepo;
	
	@PostMapping("/CadastroProfissional")//EXEMPLO CADASTRO
	private Profissional novoProfissional(
			@RequestParam(name= "nome") String nome,
			@RequestParam(name= "email") String email,
			@RequestParam(name= "senha") String senha) {
		Profissional profissional = new Profissional(nome, email, senha);
		profissionalRepo.save(profissional);
		return profissional;
	}
	
	@PostMapping("/PesquisaProfissional")//TODO: PESQUISA POR EMAIL
	private Profissional getProfissional(@RequestParam(name="Id") long id) {
		Profissional profissional = profissionalRepo.findById(id); //TODO: SE ESSE CAMPO ESTIVER EM BRANCO ELE DA ERRO
		//se não encontrar nenhum retornar null
		if (profissional == null) {
			return null;
		}
		return profissional;
	}
	
	@PostMapping("/AtualizarProfissional")
	private Profissional atualizarProfissional(
			@RequestParam(name= "id") long id,
			@RequestParam(name= "nome") String nome,			
			@RequestParam(name= "telefone") String telefone,
			@RequestParam(name= "senha") String senha,
			@RequestParam(name= "descricao") String descricao,
			@RequestParam(name= "areaDeInteresse") String areaDeInteresse,
			@RequestParam(name= "ocupacao") String ocupacao,
			@RequestParam(name= "nivelDeEscolaridade") String nivelDeEscolaridade) {
		Profissional profissional = getProfissional(id); //encontra os dados do ususario usando o ID
		//Atualiza os valores do objeto com os mais recente, se o valor informado estiver em branco ele mandem o valor anterior
		profissional.setNome(!nome.isEmpty() ? nome : profissional.getNome());
		profissional.setSenha(!senha.isEmpty() ? senha : profissional.getSenha());
		profissional.setTelefone(!telefone.isEmpty() ? telefone : profissional.getTelefone());
		profissional.setDescricao(!descricao.isEmpty() ? descricao : profissional.getDescricao());
		profissional.setAreaDeInteresse(!areaDeInteresse.isEmpty() ? areaDeInteresse : profissional.getAreaDeInteresse());
		profissional.setOcupacao(!ocupacao.isEmpty() ? ocupacao : profissional.getOcupacao());		
		profissional.setNivelDeEscolaridade(!nivelDeEscolaridade.isEmpty() ? nivelDeEscolaridade : profissional.getNivelDeEscolaridade());
		
		//atualiza (salva) os valores no banco
		profissionalRepo.save(profissional);
		return profissional;
	}
}
