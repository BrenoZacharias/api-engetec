package br.com.fateczl.engetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.Mensagem;
import br.com.fateczl.engetec.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private Mensagem mensagem;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	//Método para cadastrar pessoas 
	public ResponseEntity<?> cadastrar(Aluno aluno) {
		
		if(aluno.getRa()==null){
			mensagem.setMensagem("RA inválido");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else if((aluno.getEmail()==null) ||(aluno.getEmail().isBlank())){
			mensagem.setMensagem("email inválido");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(alunoRepository.save(aluno), HttpStatus.CREATED);
		}
	}
	
	//Método para selecionar pessoas
	public ResponseEntity<?> selecionar(){
		return new ResponseEntity<>(alunoRepository.findAll(), HttpStatus.OK);
	}
	
	//Método para selecionar pessoas através do código
	public ResponseEntity<?> selecionarPeloRa(Long ra) {
		if(alunoRepository.countByRa(ra)==0) {
			mensagem.setMensagem("Não foi econtrada nenhuma pessoa");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		}
	}
}
