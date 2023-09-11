package br.com.fateczl.engetec.entity.chaveCompostaAvaliacao;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ChaveCompostaAvaliacao implements Serializable{
	private Long idArtigo;
	private Long matriculaAvaliador;
}
