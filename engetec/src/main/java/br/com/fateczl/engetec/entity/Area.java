package br.com.fateczl.engetec.entity;

import java.util.ArrayList;
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
	private List<Artigo> artigos = new ArrayList<Artigo>();
	@ManyToMany
	@JoinTable(
		name = "Area_Avaliador",
		joinColumns = @JoinColumn(name = "area_id"),
		inverseJoinColumns = @JoinColumn(name = "avaliador_matricula")
	)
	private List<Avaliador> avaliadores = new ArrayList<Avaliador>();
	
	@Deprecated
	public Area() {} //sendo usado pelo hibernate

	public Area(Long id, String nome, List<Artigo> artigos, List<Avaliador> avaliadores) {
		super();
		this.id = id;
		this.nome = nome;
		this.artigos = artigos;
		this.avaliadores = avaliadores;
	}

	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Artigo> getArtigos() {
		return artigos;
	}

	public void setArtigos(List<Artigo> artigos) {
		this.artigos = artigos;
	}

	public List<Avaliador> getAvaliadores() {
		return avaliadores;
	}

	public void setAvaliadores(List<Avaliador> avaliadores) {
		this.avaliadores = avaliadores;
	}

	@Override
	public String toString() {
		return "" +id +""+nome;
	}
}
