package br.com.fateczl.engetec.dto;

import java.util.List;

import br.com.fateczl.engetec.entity.Artigo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AlunoDTO {
		@NotNull(message = "Informe um RA válido")
		@Positive(message = "Informe um RA válido")
		private String ra;
		@NotBlank(message = "Informe um e-mail válido")
		@Email(message = "Informe um e-mail válido")
		private String email;
		@NotBlank(message = "Informe um nome válido")
		private String nome;
		@NotBlank(message = "Informe uma senha válida")
		private String senha;

		public String getRa() {
			return ra;
		}

		public void setRa(String ra) {
			this.ra = ra;
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
			return "Aluno [ra=" + ra + ", email=" + email + ", nome=" + nome + ", senha=" + senha
					+ "]";
		}

	}

	
