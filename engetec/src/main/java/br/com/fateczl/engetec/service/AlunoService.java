package br.com.fateczl.engetec.service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

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
	
	//Método para cadastrar alunos 
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
	
	//Método para selecionar alunos
	public ResponseEntity<?> selecionar(){
		return new ResponseEntity<>(alunoRepository.findAll(), HttpStatus.OK);
	}
	
	//Método para selecionar alunos através do RA
	public ResponseEntity<?> selecionarPeloRa(Long ra) {
		//procurando no banco de dados se existe algum aluno com o Ra do parâmetro
		if(alunoRepository.countByRa(ra)==0) {
			mensagem.setMensagem("Não foi econtrada nenhum aluno com o RA informado");
			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(alunoRepository.findByRa(ra), HttpStatus.OK);
		}
	}
	
	// Método para editar dados
	public ResponseEntity<?> editar(Aluno aluno){
		
		if(alunoRepository.countByRa(aluno.getRa()) == 0) {
			mensagem.setMensagem("O RA informado não existe.");
			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
		}/*else if(!validaEmail(aluno.getEmail())) {
			mensagem.setMensagem("Email inválido");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		}*/else {
			return new ResponseEntity<>(alunoRepository.save(aluno), HttpStatus.OK);
		}
		
	}
	
	private boolean validaEmail(String email) {
		boolean result = false;
		if(email.contains("@") && (email.contains("."))) {
			result = true;
		}
		return result;
	}
}
