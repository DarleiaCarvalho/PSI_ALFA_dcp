package br.com.alfa.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.alfa.model.bean.Bairro;
import br.com.alfa.model.bean.Contato;
import br.com.alfa.model.bean.Grupo;
import br.com.alfa.model.dao.DAO;

@ViewScoped
@ManagedBean
public class ContatoController  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//Atributos devem ser iniciados
	private Contato contato = new Contato();
	public List<Contato> contatos;
	
	private List<SelectItem> bairrosSelect;
	private List<SelectItem> gruposSelect;
	
	public ContatoController () {
		System.out.println("Instanciou ClienteBean!");
	}
	
	public List<SelectItem> getBairrosSelect() {
		if(this.bairrosSelect == null){
			bairrosSelect = new ArrayList<SelectItem>();
			List<Bairro> listaBairros = new DAO<Bairro>(Bairro.class).listaTodos();
			if(listaBairros != null && !listaBairros.isEmpty()){
				SelectItem item;
				for(Bairro bairroLista : listaBairros){
					item = new SelectItem(bairroLista, 	bairroLista.getNome());
					bairrosSelect.add(item);
				}
			}
		}
		
		return bairrosSelect;
	}
	
	public List<SelectItem> getGruposSelect() {
		if(this.gruposSelect == null){
			gruposSelect = new ArrayList<SelectItem>();
			List<Grupo> listaGrupos = new DAO<Grupo>(Grupo.class).listaTodos();
			if(listaGrupos != null && !listaGrupos.isEmpty()){
				SelectItem item;
				for(Grupo grupoLista : listaGrupos){
					item = new SelectItem(grupoLista, 	grupoLista.getNome());
					gruposSelect.add(item);
				}
			}
		}
		
		return gruposSelect;
	}
	
	public void salvar(){
		DAO<Contato> dao = new DAO<Contato>(Contato.class);
		if(contato.getId()!=null){
			dao.alterar(contato);
		}else{
			dao.cadastrar(contato);
		}
		this.contato = new Contato();
		this.contatos = dao.listaTodos();
	}
	
	public List<Contato> getContatos() {
		if(this.contatos == null){
			System.out.println("Carregando contatos...");
			this.contatos = new DAO<Contato>(Contato.class).listaTodos();
		}
		return this.contatos;
	}
	
	public void limpaFormulario(){
		this.contato = new Contato();
	}
	
	public void excluir(Contato contato){
		DAO<Contato> dao = new DAO<Contato>(Contato.class);
		dao.remove(contato);
		this.contatos = dao.listaTodos();
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}	

}
