package br.com.fateczl.engetec.dto;

import java.util.List;

import br.com.fateczl.engetec.entity.Area;
import br.com.fateczl.engetec.entity.Avaliacao;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AvaliadorDTO {

	@NotNull(message = "Informe um número de matrícula válido")
	@Positive(message = "Informe um número de matrícula válido")
	private Long matricula;
	private List<Avaliacao> avaliacoes;
	private List<Area> areas;
	@NotBlank(message = "Informe um e-mail válido")
	@Email(message = "Informe um e-mail válido")
	private String email;
	@NotBlank(message = "Informe um nome válido")
	private String nome;
	@NotBlank(message = "Informe uma senha válida")
	private String senha;
	
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
