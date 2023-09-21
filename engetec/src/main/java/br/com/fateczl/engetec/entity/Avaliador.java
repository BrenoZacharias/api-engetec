package br.com.fateczl.engetec.entity;

import java.util.List;

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
	private String senha;
}
