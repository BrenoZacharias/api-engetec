package br.com.fateczl.engetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fateczl.engetec.dto.AlunoDTO;
import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.Mensagem;
import br.com.fateczl.engetec.login.AlunoLogin;
import br.com.fateczl.engetec.repository.AlunoRepository;
import br.com.fateczl.engetec.repository.SenhaRepository;
import br.com.fateczl.engetec.senha.HashSenha;
import br.com.fateczl.engetec.senha.Senha;

@Service
public class AlunoService {

	@Autowired
	private Mensagem mensagem;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private HashSenha hashSenha;
	
	@Autowired
	private SenhaRepository senhaRepository;
	
	public ResponseEntity<?> logar(AlunoLogin alunoLogin){
		if(alunoRepository.countByRa(alunoLogin.getRa())==0) {
			mensagem.setMensagem("email não existe");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else {
			Aluno aluno = alunoRepository.findByRa(alunoLogin.getRa());
			if(!HashSenha.verifyPassword(alunoLogin.getSenha(), aluno.getSenha().getHashSenha(), 
					aluno.getSenha().getSalt())){
				mensagem.setMensagem("senha incorreta");
				return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
			} else {
				mensagem.setMensagem("logado");
				return new ResponseEntity<>(mensagem, HttpStatus.OK);
			}
		}
	}
	
	//Método para cadastrar alunos 
	public ResponseEntity<?> cadastrar(AlunoDTO alunoDTO) {
		Senha objSenha = new Senha();
		try {
			objSenha = hashSenha.tratamentoSenha(alunoDTO.getSenha());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Aluno aluno = AlunoDtoToAluno(alunoDTO, objSenha);
		if(aluno.getRa()==null){
			mensagem.setMensagem("RA inválido");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else if((aluno.getEmail()==null) || (aluno.getEmail().isBlank())){
			mensagem.setMensagem("email inválido");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else if(alunoRepository.countByEmail(aluno.getEmail())!=0){
			mensagem.setMensagem("email já existe");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else {
			senhaRepository.save(aluno.getSenha());
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
		}else {
			return new ResponseEntity<>(alunoRepository.save(aluno), HttpStatus.OK);
		}
		
	}
	
	// Método para remover registros
	public ResponseEntity<?> remover(Long ra){
		
		if(alunoRepository.countByRa(ra) == 0) {
			mensagem.setMensagem("O RA informado não existe.");
			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
		}else {
			Aluno aluno = alunoRepository.findByRa(ra);
			alunoRepository.delete(aluno);
			
			mensagem.setMensagem("Pessoa removida com sucesso");
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}
		
	}

	private Aluno AlunoDtoToAluno(AlunoDTO alunoDTO, Senha objSenha) {
		Aluno aluno = new Aluno(alunoDTO.getRa(), alunoDTO.getArtigos(), alunoDTO.getEmail(), 
				alunoDTO.getNome(), objSenha);
		return aluno;
	}
		
}
