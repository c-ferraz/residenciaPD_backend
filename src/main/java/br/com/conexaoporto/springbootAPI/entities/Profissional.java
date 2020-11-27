package br.com.conexaoporto.springbootAPI.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "cod_profissional")
public class Profissional extends Usuario {
	
	
	@Column(name="area_de_atuacao")
	private String areaDeAtuacao;
	
	@Column(name="ocupacao")
	private String ocupacao;
	
	@ManyToMany
	private Set<Curso> cursos;
	
	public Profissional(String nome, String email, String senha) {
		super(nome, email, senha);
		// TODO Auto-generated constructor stub
	}

	public Profissional(String nome, String email, String senha, String areaDeAtuacao, String ocupacao) {
		super(nome, email, senha);
		this.areaDeAtuacao = areaDeAtuacao;
		this.ocupacao = ocupacao;
	}



	public String getAreaDeAtuacao() {
		return areaDeAtuacao;
	}

	public void setAreaDeAtuacao(String areaDeAtuacao) {
		this.areaDeAtuacao = areaDeAtuacao;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}
	
	
}
