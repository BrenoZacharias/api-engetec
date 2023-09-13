package br.com.fateczl.engetec.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class AlunoModel {
	@Id
	private Long ra;
//	private List<Artigo> artigos;	
	private String email;
	private String nome;
	private String senha;
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
