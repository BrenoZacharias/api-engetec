package br.com.fateczl.engetec.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Aluno {
	@Id
	private Long ra;
	@OneToMany
	private List<Artigo> artigos;
	@Email(message = "Informe um e-mail válido")
	@Column(unique = true, nullable = false)
	private String email;
	@NotBlank(message = "Informe um nome válido")
	@Column(nullable = false)
	private String nome;
	@NotBlank(message = "Informe uma senha válida")
	@Column(nullable = false)
	private String senha;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", artigos=" + artigos + ", email=" + email + ", nome=" + nome + ", senha=" + senha
				+ "]";
	}

}
