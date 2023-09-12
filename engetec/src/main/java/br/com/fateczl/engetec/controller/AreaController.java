package br.com.fateczl.engetec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fateczl.engetec.entity.Area;
import br.com.fateczl.engetec.repository.AreaRepository;


@RestController
@RequestMapping("/api")
public class AreaController {
	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping("/area")
	public List<Area> buscarAreas(){
		return areaRepository.findAll();
	}
	
	@PostMapping("/area")
	public ResponseEntity<Area> criarArea(@RequestBody Area area) {
		System.out.println(area.toString());
		return ResponseEntity.ok(areaRepository.save(area));
	}
}
