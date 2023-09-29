package br.com.fateczl.engetec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fateczl.engetec.entity.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long>{

	List<Aluno> findAll();
	
	Aluno findByRa(Long ra);
	
//	List<Aluno> findByOrderByNomeAsc();
//	
//	List<Aluno> findByOrderByNomeDesc();
//	
//	List<Aluno> findByNome(String nome);
//	
//	List<Aluno> findByNomeOrderByRaDesc(String nome);
//	
//	List<Aluno> findByNomeContaining(String termo);
//	
//	List<Aluno> findByNomeStartsWith(String termo);
//	
//	List<Aluno> findByNomeEndsWith(String termo);
	
	int countByRa(Long ra);
	
}