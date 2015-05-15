package br.com.alfa.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.alfa.model.bean.Usuario;
import br.com.alfa.model.dao.UsuarioDAO;

@ManagedBean 
@SessionScoped
public class LoginController {

	private Usuario usuario = new Usuario();

	public String efetuaLogout(){
		this.usuario = new Usuario();
		return "login?faces-redirect=true";
	}
	
	//action com outcome
	public String efetuaLogin(){
		UsuarioDAO dao = new UsuarioDAO();
		boolean loginValido = dao.existe(this.usuario);
		System.out.println("1");
		if(loginValido){
			System.out.println("2");
			return "principal?faces-redirect=true";
		}else{
			System.out.println("3");
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public boolean isLogado(){
		return this.usuario.getLogin() != null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

}
