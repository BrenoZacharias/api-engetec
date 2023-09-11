package br.com.fateczl.engetec.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
