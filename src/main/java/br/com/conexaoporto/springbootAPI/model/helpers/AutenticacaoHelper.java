package br.com.conexaoporto.springbootAPI.model.helpers;

import br.com.conexaoporto.springbootAPI.model.entities.Usuario;

public class AutenticacaoHelper {
	private Usuario usuario;
	private boolean estadoAutenticacao;
	
	public AutenticacaoHelper() {
		super();
	}
	
	public AutenticacaoHelper(Usuario usuario) {
		super();
		this.usuario = usuario;
		this.estadoAutenticacao = false;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public boolean isEstadoAutenticacao() {
		return estadoAutenticacao;
	}
	public void setEstadoAutenticacao(boolean estadoAutenticacao) {
		this.estadoAutenticacao = estadoAutenticacao;
	}
	
	
}
