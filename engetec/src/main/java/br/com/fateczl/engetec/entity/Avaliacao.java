package br.com.fateczl.engetec.entity;

import br.com.fateczl.engetec.entity.chaveCompostaAvaliacao.ChaveCompostaAvaliacao;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
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
}
