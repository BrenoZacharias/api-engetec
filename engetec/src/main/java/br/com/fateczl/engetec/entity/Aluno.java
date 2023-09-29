package br.com.fateczl.engetec.entity;

import java.util.List;

import br.com.fateczl.engetec.senha.Senha;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Aluno {

	@Id
	private Long ra;
	@OneToMany(mappedBy = "aluno")
	private List<Artigo> artigos;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public Aluno(Long ra) {
		this.ra = ra;
	}
	
	public Aluno(Long ra, Usuario usuario) {
		this.ra = ra;
		this.usuario = usuario;
	}
	
	@Deprecated
	public Aluno() {} //sendo usado pelo hibernate

	public Long getRa() {
		return ra;
	}

	public void setRa(Long ra) {
		this.ra = ra;
	}

	public List<Artigo> getArtigos() {
		return artigos;
	}

	public void setArtigos(List<Artigo> artigos) {
		this.artigos = artigos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
