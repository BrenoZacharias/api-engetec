package br.com.fateczl.engetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fateczl.engetec.entity.Area;
import br.com.fateczl.engetec.repository.AreaRepository;


@RestController
@RequestMapping(value = "/api")
public class AreaController {
	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping("/area")
	public ResponseEntity<Iterable<Area>> buscarAreas(){
		return ResponseEntity.ok(areaRepository.findAll());
	}
	
	@PostMapping("/area")
	@ResponseBody
	public ResponseEntity<Area> criarArea(@RequestBody Area area) {
		System.out.println(area.toString());
		return ResponseEntity.ok(areaRepository.save(area));
	}
	/*
	@PostMapping("/area")
	public void criarArea(@RequestBody String area) {
		System.out.println(area.toString());
	}*/
}
