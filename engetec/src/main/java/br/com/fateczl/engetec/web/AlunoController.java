package br.com.fateczl.engetec.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AlunoController {

	@GetMapping(path = "/aluno")
	public String getAluno() {
		return "ola";
	}
}
