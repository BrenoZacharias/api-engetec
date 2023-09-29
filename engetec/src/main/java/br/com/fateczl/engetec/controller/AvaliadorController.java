package br.com.fateczl.engetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fateczl.engetec.dto.AvaliadorDTO;
import br.com.fateczl.engetec.service.AvaliadorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/avaliador")
public class AvaliadorController {
	
	@Autowired
	private AvaliadorService avaliadorService;
	
//	@PostMapping(path="")
//	public ResponseEntity<?> cadastrar(@Valid @RequestBody AvaliadorDTO avaliadorDTO){
//		return avaliadorService.cadastrar(avaliadorDTO);
//	}
}
