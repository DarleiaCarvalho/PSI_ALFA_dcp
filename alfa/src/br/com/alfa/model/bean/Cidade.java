package br.com.alfa.model.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.alfa.converter.AbstractEntity;
@Entity
public class Cidade extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 677060029592189345L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	//Metodos de GET e SET...
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
