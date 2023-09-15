package br.com.fateczl.engetec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.repository.AlunoRepository;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping(path = "")
	public List<Aluno> buscarAlunos() {
		return alunoRepository.findAll();
	}
	
	@GetMapping(path = "/{ra}")
	public Aluno selecionarPeloRa(@PathVariable Long ra) {
		return alunoRepository.findByRa(ra);
	}
	
	@GetMapping("/count")
	public Long countAlunos() {
		return alunoRepository.count();
	}
	
	@GetMapping("/ordenarNomesAsc")
	public List<Aluno> ordenarNomesAsc() {
		return alunoRepository.findByOrderByNomeAsc();
	}
	
	@GetMapping("/ordenarNomesDesc")
	public List<Aluno> ordenarNomesDesc() {
		return alunoRepository.findByOrderByNomeDesc();
	}
	
	@GetMapping("/filtrarNomes/{nome}")
	public List<Aluno> filtrarNomes(@PathVariable String nome) {
		return alunoRepository.findByNome(nome);
	}
	
	@GetMapping("/filtrarNomesOrdenarRaDesc/{nome}")
	public List<Aluno> filtrarNomesOrdenarPorRaDesc(@PathVariable String nome) {
		return alunoRepository.findByNomeOrderByRaDesc(nome);
	}
	
	@GetMapping("/nomeContem/{termo}")
	public List<Aluno> nomeContem(@PathVariable String termo) {
		return alunoRepository.findByNomeContaining(termo);
	}
	
	@GetMapping("/nomeComecaCom/{termo}")
	public List<Aluno> nomeComecaCom(@PathVariable String termo) {
		return alunoRepository.findByNomeStartsWith(termo);
	}
	
	@GetMapping("/nomeTerminaCom/{termo}")
	public List<Aluno> nomeTerminaCom(@PathVariable String termo) {
		return alunoRepository.findByNomeEndsWith(termo);
	}
	
	@PostMapping(path = "")
	public Aluno criar(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@PutMapping(path = "")
	public Aluno editar(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@DeleteMapping(path = "/{ra}")
	public void remover(@PathVariable Long ra) {
		Aluno aluno = selecionarPeloRa(ra);
		alunoRepository.delete(aluno);
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
