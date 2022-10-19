package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO) 	
	private long id;
	private String nome;
	private String cidade;
	private String uf;

	public Pessoa() {}	
	public Pessoa(int id, String nome, String cidade, String uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.uf = uf;
	}

    // getters e setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
