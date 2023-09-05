package br.com.fateczl.engetec.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String nome;
	@ManyToMany(mappedBy = "areas")
	private List<Artigo> artigos;
	@ManyToMany
	@JoinTable(
		name = "Area_Avaliador",
		joinColumns = @JoinColumn(name = "area_id"),
		inverseJoinColumns = @JoinColumn(name = "avaliador_matricula")
	)
	private List<Avaliador> avaliadores;
}
