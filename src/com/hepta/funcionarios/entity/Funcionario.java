package com.hepta.funcionarios.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	private String nome;

	@ManyToOne
	@JoinColumn
	private Setor setor;


	private Double salario;

	
	private String email;

	private Integer idade;

	public Integer getId() {
		return id;
	}
	
	public Funcionario() {
//		this.id = 1;
//		this.nome = "João";
//		this.setor = new Setor(1, "Desenvolvimento");
//		this.salario = 1500.00;
//		this.email = "joao@gmail.com";
//		this.idade = 23;
	}
	public Funcionario(Integer id, String nome, Setor setor, Double salario, String email, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.setor = setor;
		this.salario = salario;
		this.email = email;
		this.idade = idade;
	}
	
	public Funcionario(String nome, Setor setor, Double salario, String email, Integer idade) {
		
		this.nome = nome;
		this.setor = setor;
		this.salario = salario;
		this.email = email;
		this.idade = idade;
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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", setor=" + setor + ", salario=" + salario + ", email="
				+ email + ", idade=" + idade + "]";
	}

	
}
