package br.com.conexaoporto.springbootAPI.model.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name= "cod_oficina")
public class Oficina extends Evento {
	
	@Column(name= "data_inicio")
	private Date dataInicio;
	
	@Column(name= "data_termino")
	private Date dataTermino;
	
	@Column(name= "carga_horaria")
	private int cargaHoraria;

	@OneToMany
	@JoinColumn(name= "cod_oficina")
	private Set<Modulo> modulos;
	
	public Oficina() {
		super();
	}

	public Oficina(byte[] fotoDeCapa, String plataforma, String linkDeAcesso, int pontuacao, String descricao,
			Date dataInicio, Date dataTermino, int cargaHoraria) {
		super(fotoDeCapa, plataforma, linkDeAcesso, pontuacao, descricao);
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.cargaHoraria = cargaHoraria;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	
}
