package br.com.fateczl.engetec.entity;

import java.util.List;

import br.com.fateczl.engetec.senha.Senha;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Aluno {

	@Id
	private Long ra;
	@OneToMany(mappedBy = "aluno")
	private List<Artigo> artigos;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String nome;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "senha_id")
	private Senha senha;

	public Aluno(Long ra, List<Artigo> artigos, String email, String nome, Senha senha) {
		super();
		this.ra = ra;
		this.artigos = artigos;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}
	
	@Deprecated
	public Aluno() {} //sendo usado pelo hibernate

	public Long getRa() {
		return ra;
	}

	public void setRa(Long ra) {
		this.ra = ra;
	}

	public List<Artigo> getArtigos() {
		return artigos;
	}

	public void setArtigos(List<Artigo> artigos) {
		this.artigos = artigos;
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
