package br.com.fateczl.engetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.repository.AlunoRepository;

@RestController
@RequestMapping("/api")
public class AlunoController {
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping(path = "/aluno")
	public String getAluno() {
		return "ola";
	}
	
	@PostMapping
	public Aluno criarAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
}
