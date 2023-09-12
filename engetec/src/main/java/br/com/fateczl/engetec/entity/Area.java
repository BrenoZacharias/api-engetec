package br.com.fateczl.engetec.entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String nome;
	@ManyToMany(mappedBy = "areas")
	private List<Artigo> artigos = new ArrayList<Artigo>();
	@ManyToMany
	@JoinTable(
		name = "Area_Avaliador",
		joinColumns = @JoinColumn(name = "area_id"),
		inverseJoinColumns = @JoinColumn(name = "avaliador_matricula")
	)
	private List<Avaliador> avaliadores = new ArrayList<Avaliador>();
	
	@Override
	public String toString() {
		return "" +id +""+nome;
	}
}