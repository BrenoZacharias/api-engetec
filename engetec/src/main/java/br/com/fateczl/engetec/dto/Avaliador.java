package br.com.fateczl.engetec.dto;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

public class Avaliador extends Usuario{
	@Id
	private Long matricula;
	@OneToMany
	private List<Avaliacao> avaliacoes;
	@ManyToMany(mappedBy = "avaliadores")
	private List<Area> areas;
}
