package br.com.fateczl.engetec.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Avaliador extends Usuario{
	@Id
	private Long matricula;
	@OneToMany
	private List<Avaliacao> avaliacoes;
	@ManyToMany(mappedBy = "avaliadores")
	private List<Area> areas;
}
