package br.com.alfa.model.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.alfa.converter.AbstractEntity;
@Entity
public class Bairro extends AbstractEntity {
    private static final long serialVersionUID = -634596699520431454L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@ManyToOne
	private Cidade cidade;
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
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
