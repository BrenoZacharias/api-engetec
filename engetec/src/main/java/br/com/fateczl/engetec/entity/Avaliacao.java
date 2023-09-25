package br.com.fateczl.engetec.entity;

import br.com.fateczl.engetec.entity.chaveCompostaAvaliacao.ChaveCompostaAvaliacao;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Avaliacao {
	@EmbeddedId
	private ChaveCompostaAvaliacao chaveCompostaAvaliacao;
	@OneToOne
	private Artigo artigo;
	@ManyToOne
	@JoinColumn(name = "avaliador_matricula", nullable = false)
	private Avaliador avaliador;
	@Column(nullable = false)
	private int nota; 
	@Column(nullable = false)
	private String razao;
	@Column(nullable = false)
	private Aceite aceite;
	
	@Deprecated
	public Avaliacao() {} //sendo usada pelo hibernate

	public Avaliacao(ChaveCompostaAvaliacao chaveCompostaAvaliacao, Artigo artigo, Avaliador avaliador, int nota,
			String razao, Aceite aceite) {
		super();
		this.chaveCompostaAvaliacao = chaveCompostaAvaliacao;
		this.artigo = artigo;
		this.avaliador = avaliador;
		this.nota = nota;
		this.razao = razao;
		this.aceite = aceite;
	}

	public ChaveCompostaAvaliacao getChaveCompostaAvaliacao() {
		return chaveCompostaAvaliacao;
	}

	public void setChaveCompostaAvaliacao(ChaveCompostaAvaliacao chaveCompostaAvaliacao) {
		this.chaveCompostaAvaliacao = chaveCompostaAvaliacao;
	}

	public Artigo getArtigo() {
		return artigo;
	}

	public void setArtigo(Artigo artigo) {
		this.artigo = artigo;
	}

	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public Aceite getAceite() {
		return aceite;
	}

	public void setAceite(Aceite aceite) {
		this.aceite = aceite;
	}
	
	
	
}
