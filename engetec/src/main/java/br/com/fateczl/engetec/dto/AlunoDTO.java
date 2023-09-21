package br.com.fateczl.engetec.dto;

import java.util.List;

import br.com.fateczl.engetec.entity.Artigo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AlunoDTO {
		@NotNull(message = "Informe um RA válido")
		private Long ra;
		private List<Artigo> artigos;
		@Email(message = "Informe um e-mail válido")
		private String email;
		@NotBlank(message = "Informe um nome válido")
		private String nome;
		@NotBlank(message = "Informe uma senha válida")
		private String senha;

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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		@Override
		public String toString() {
			return "Aluno [ra=" + ra + ", artigos=" + artigos + ", email=" + email + ", nome=" + nome + ", senha=" + senha
					+ "]";
		}

	}

	
