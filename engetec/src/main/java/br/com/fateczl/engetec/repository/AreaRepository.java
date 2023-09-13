package br.com.fateczl.engetec.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fateczl.engetec.entity.Area;

@Repository
public interface AreaRepository extends CrudRepository<Area, Long>{

}
