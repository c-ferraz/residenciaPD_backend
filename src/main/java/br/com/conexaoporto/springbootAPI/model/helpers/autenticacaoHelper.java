package br.com.conexaoporto.springbootAPI.model.helpers;

import br.com.conexaoporto.springbootAPI.model.entities.Usuario;

public class autenticacaoHelper {
	private Usuario usuario;
	private boolean estadoAutenticacao;
	
	public autenticacaoHelper() {
		super();
	}
	
	public autenticacaoHelper(Usuario usuario, boolean estadoAutenticacao) {
		super();
		this.usuario = usuario;
		this.estadoAutenticacao = estadoAutenticacao;
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
