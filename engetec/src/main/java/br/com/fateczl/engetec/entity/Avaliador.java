package br.com.fateczl.engetec.entity;

import java.util.List;

import br.com.fateczl.engetec.senha.Senha;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Avaliador {
	@Id
	private Long matricula;
	@OneToMany(mappedBy = "avaliador")
	private List<Avaliacao> avaliacoes;
	@ManyToMany(mappedBy = "avaliadores")
	private List<Area> areas;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Senha senha;
	
	public Avaliador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Avaliador(Long matricula, List<Avaliacao> avaliacoes, List<Area> areas, String email, String nome,
			Senha senha) {
		super();
		this.matricula = matricula;
		this.avaliacoes = avaliacoes;
		this.areas = areas;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	public Long getMatricula() {
		return matricula;
	}
	
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	public List<Area> getAreas() {
		return areas;
	}
	
	public void setAreas(List<Area> areas) {
		this.areas = areas;
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
}
