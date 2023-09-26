package br.com.fateczl.engetec.senha;

import br.com.fateczl.engetec.entity.Aluno;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Senha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String hashedSenha;
	@Column(nullable = false)
	private byte[] salt;
//	@OneToOne(mappedBy = "senha")
//	private Aluno aluno;
	
	public Senha(String hashedSenha, byte[] salt) {
		this.hashedSenha = hashedSenha;
		this.salt = salt;
	}
	
	public Senha() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Aluno getAluno() {
//		return aluno;
//	}
//
//	public void setAluno(Aluno aluno) {
//		this.aluno = aluno;
//	}

	public String getHashSenha() {
		return hashedSenha;
	}
	public void setHashSenha(String hashedSenha) {
		this.hashedSenha = hashedSenha;
	}
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	
	
}
