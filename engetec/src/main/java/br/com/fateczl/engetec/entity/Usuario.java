package br.com.fateczl.engetec.entity;

import br.com.fateczl.engetec.senha.Senha;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {
	
	//para o aluno é o RA, para o avaliador é a matrícula
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String nome;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "senha_id")
	private Senha senha;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Usuario(String email, String nome) {
		this.email = email;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Senha getSenha() {
		return senha;
	}
	
	public void setSenha(Senha senha) {
		this.senha = senha;
	}
	
	

}
