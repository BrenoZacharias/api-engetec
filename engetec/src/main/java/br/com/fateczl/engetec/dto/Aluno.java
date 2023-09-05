package br.com.fateczl.engetec.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Usuario{
	@Id
	private Long ra;
	@OneToMany
	private List<Artigo> artigos;	
	@Column(unique = true)
	private String email;
	private String nome;
	private String senha;
}

