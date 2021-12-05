package com.hepta.funcionarios.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="setor")
public class Setor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	
	@OneToMany(mappedBy = "setor")
	private List<Funcionario> funcionarios =  new ArrayList<>();
	
	public Setor() {}
	
	public Setor(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Setor(Integer id, String nome, List<Funcionario> funcionarios) {
		this.id = id;
		this.nome = nome;
		this.funcionarios = funcionarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Setor [id=" + id + ", nome=" + nome + "]";
	}
	

}
