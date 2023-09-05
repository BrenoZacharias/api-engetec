package br.com.fateczl.engetec.dto;

import javax.persistence.Column;
import javax.persistence.OneToOne;

public class Avaliacao {
	@OneToOne
	private Artigo artigo;
	@OneToOne
	private Avaliador avaliador;
	@Column(nullable = false)
	private int nota; 
	@Column(nullable = false)
	private String razao;
	@Column(nullable = false)
	private Aceite aceite;
}
