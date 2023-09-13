package br.com.fateczl.engetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.AlunoModel;
import br.com.fateczl.engetec.repository.AlunoRepository;

@RestController
@RequestMapping("/api")
public class AlunoController {
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping(path = "/aluno/{nome}")
	public String getAluno(@PathVariable String nome) {
		return "ola " + nome;
	}
	
	@PostMapping(path = "/aluno")
	public Aluno criarAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
//	@PostMapping(path = "/aluno")
//	public ResponseEntity<AlunoModel> criarAluno(@RequestBody AlunoModel alunoModel) {
//		System.out.println(alunoModel.getEmail());
//		return ResponseEntity.ok(alunoModel);
//	}
//	
//	@PostMapping(path = "/aluno")
//	public AlunoModel criarAluno(@RequestBody AlunoModel alunoModel) {
//		return alunoModel;
//	}
}
