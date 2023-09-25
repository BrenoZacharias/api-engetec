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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Artigo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "aluno_ra", nullable = false)
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
	
	
	@Deprecated
	public Artigo() {} //sendo usado pelo hibernate

	
	
	public Artigo(Long id, Aluno aluno, String titulo, String linkArtigoAluno, String linkArtigoComite,
			List<Area> areas, String palavrasChave, Status status, String integrantes, List<Avaliacao> avaliacoes) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.titulo = titulo;
		this.linkArtigoAluno = linkArtigoAluno;
		this.linkArtigoComite = linkArtigoComite;
		this.areas = areas;
		this.palavrasChave = palavrasChave;
		this.status = status;
		this.integrantes = integrantes;
		this.avaliacoes = avaliacoes;
	}

	public Long getId() {
		return id;
	}

	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getLinkArtigoAluno() {
		return linkArtigoAluno;
	}
	
	public void setLinkArtigoAluno(String linkArtigoAluno) {
		this.linkArtigoAluno = linkArtigoAluno;
	}
	
	public String getLinkArtigoComite() {
		return linkArtigoComite;
	}
	
	public void setLinkArtigoComite(String linkArtigoComite) {
		this.linkArtigoComite = linkArtigoComite;
	}
	
	public List<Area> getAreas() {
		return areas;
	}
	
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
	
	public String getPalavrasChave() {
		return palavrasChave;
	}
	
	public void setPalavrasChave(String palavrasChave) {
		this.palavrasChave = palavrasChave;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getIntegrantes() {
		return integrantes;
	}
	
	public void setIntegrantes(String integrantes) {
		this.integrantes = integrantes;
	}
	
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	
	
}
