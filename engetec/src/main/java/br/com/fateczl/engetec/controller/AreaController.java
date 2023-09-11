package br.com.fateczl.engetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/area")
	public Area criarArea(@RequestBody Area area) {
		return areaRepository.save(area);
	}
}
