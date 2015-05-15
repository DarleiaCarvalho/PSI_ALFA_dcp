package br.com.alfa.controller;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.alfa.model.bean.Grupo;
import br.com.alfa.model.dao.DAO;


@ViewScoped
@ManagedBean
public class GrupoController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos devem ser iniciados
	private Grupo grupo = new Grupo();
	public List<Grupo> grupos;
	
	public GrupoController() {
		System.out.println("Instanciou TuristicoBean!");
	}
	
	public void salvar(){
		DAO<Grupo> dao = new DAO<Grupo>(Grupo.class);
		if(grupo.getId()!=null){
			dao.alterar(grupo);
		}else{
			dao.cadastrar(grupo);
		}
		grupo  = new Grupo();
		this.grupos = dao.listaTodos();
	}
	
	@PostConstruct
	public List<Grupo> getGrupos() {
		if(this.grupos == null){
			System.out.println("Carregando pontos grupos...");
			this.grupos= new DAO<Grupo>(Grupo.class).listaTodos();
		}
		return this.grupos;
	}
	
	public void limpaFormulario(){
		this.grupo = new Grupo();
	}
	
	public void excluir(Grupo grupo){
		DAO<Grupo> dao = new DAO<Grupo>(Grupo.class);
		dao.remove(grupo);
		this.grupos = dao.listaTodos();
	}
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	
}
