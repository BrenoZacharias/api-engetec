package br.com.fateczl.engetec.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fateczl.engetec.senha.Senha;

@Repository
public interface SenhaRepository extends CrudRepository<Senha, Long>{

}
