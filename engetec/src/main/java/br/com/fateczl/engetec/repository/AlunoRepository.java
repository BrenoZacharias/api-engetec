package br.com.fateczl.engetec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fateczl.engetec.entity.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long>{

	List<Aluno> findAll();
	
	Aluno findByRa(Long ra);
	
}