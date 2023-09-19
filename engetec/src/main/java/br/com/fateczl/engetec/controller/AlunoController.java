package br.com.fateczl.engetec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
import br.com.fateczl.engetec.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping(path = "")
	public ResponseEntity<?> selecionar() {
		return alunoService.selecionar();
	}
	
	@GetMapping(path = "/{ra}")
	public ResponseEntity<?> selecionarPeloRa(@PathVariable Long ra) {
		return alunoService.selecionarPeloRa(ra);
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
	public ResponseEntity<?> cadastrar(@Valid @RequestBody Aluno aluno) {
		return alunoService.cadastrar(aluno);
	}
	
	@PutMapping(path = "")
	public ResponseEntity<?> editar(@Valid @RequestBody Aluno aluno) {
		return alunoService.editar(aluno);
	}
	
	@DeleteMapping(path = "/{ra}")
	public ResponseEntity<?> remover(@PathVariable Long ra) {
		return alunoService.remover(ra);
	}

	@GetMapping("/status")
	public ResponseEntity<?> status() {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
