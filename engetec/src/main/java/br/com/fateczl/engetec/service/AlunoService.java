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
	private AvaliadorService avaliadorService;
	
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
		Senha objSenha = hashSenha.tratamentoSenha(alunoDTO.getSenha());
		Aluno aluno = alunoDtoToAluno(alunoDTO, objSenha);
		if((alunoRepository.countByEmail(aluno.getEmail())!=0)||(avaliadorService.countByEmail(aluno.getEmail())!=0)){
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
	public ResponseEntity<?> editar(AlunoDTO alunoDTO){
		Aluno aluno = alunoDtoToAluno(alunoDTO);
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

	public int countByEmail(String email) {
		return alunoRepository.countByEmail(email);
	}
	
	// para o post
	private Aluno alunoDtoToAluno(AlunoDTO alunoDTO, Senha objSenha) {
		Aluno aluno = new Aluno(Long.parseLong(alunoDTO.getRa()), alunoDTO.getEmail(), 
				alunoDTO.getNome(), objSenha);
		return aluno;
	}
		
	// para o put
	private Aluno alunoDtoToAluno(AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno(Long.parseLong(alunoDTO.getRa()), alunoDTO.getEmail(), 
				alunoDTO.getNome());
		return aluno;
	}
			
}
