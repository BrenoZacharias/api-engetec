package br.com.fateczl.engetec.dto;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.web.servlet.support.BindStatus;


public class Artigo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Aluno aluno;
	@Column(unique = true, nullable = false)
	private String titulo;
	@Column(unique = true, nullable = false)
	private String linkArtigoAluno;
	@Column(unique = true)
	private String linkArtigoComite;
	@ManyToMany
	@JoinTable(
		name = "Artigo_Area",
		joinColumns = @JoinColumn(name = "artigo_id"),
		inverseJoinColumns = @JoinColumn(name = "area_id")
	)
	private List<Area> areas;
	@Column(nullable = false)
	private String palavrasChave;
	@Column(nullable = false)
	private Status status;
	@Column(nullable = false)
	private String integrantes;
	@OneToMany
	private List<Avaliacao> avaliacoes;
}
