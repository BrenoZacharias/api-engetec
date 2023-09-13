package br.com.fateczl.engetec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fateczl.engetec.entity.HelloDTO;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping(path = "/hello")
    public HelloDTO hello() {
        return new HelloDTO("Hello World!");
    }
    
    @PostMapping(path = "/hello")
    public HelloDTO criarHello(@RequestBody HelloDTO helloDTO) {
    	return helloDTO;
    }
}
