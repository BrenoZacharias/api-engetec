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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Artigo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
