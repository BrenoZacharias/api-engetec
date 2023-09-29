package br.com.fateczl.engetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fateczl.engetec.dto.AlunoDTO;
import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.Mensagem;
import br.com.fateczl.engetec.entity.Usuario;
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
	private HashSenha hashSenha;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
//	public ResponseEntity<?> logar(AlunoLogin alunoLogin){
//		if(alunoRepository.countByRa(alunoLogin.getRa())==0) {
//			mensagem.setMensagem("email não existe");
//			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
//		} else {
//			Aluno aluno = alunoRepository.findByRa(alunoLogin.getRa());
//			if(!HashSenha.verifyPassword(alunoLogin.getSenha(), aluno.getSenha().getHashSenha(), 
//					aluno.getSenha().getSalt())){
//				mensagem.setMensagem("senha incorreta");
//				return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
//			} else {
//				mensagem.setMensagem("logado");
//				return new ResponseEntity<>(mensagem, HttpStatus.OK);
//			}
//		}
//	}
	
	//Método para cadastrar alunos 
	public ResponseEntity<?> cadastrar(AlunoDTO alunoDTO) {
		if(usuarioService.countByEmail(alunoDTO.getEmail())!=0){
			mensagem.setMensagem("email já existe");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else if(alunoRepository.countByRa(alunoDTO.getRa())!=0){
			mensagem.setMensagem("RA já existe");
			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
		} else {
			Usuario usuario = alunoDtoToUsuario(alunoDTO);
			Usuario usuarioSalvo = usuarioService.cadastrar(usuario, alunoDTO.getSenha());
			Aluno aluno = alunoDtoToAluno(alunoDTO);
			aluno.setUsuario(usuarioSalvo);
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
	
//	// Método para editar dados
//	public ResponseEntity<?> editar(AlunoDTO alunoDTO){
//		if(alunoRepository.countByRa(alunoDTO.getRa()) == 0) {
//			mensagem.setMensagem("O RA informado não existe.");
//			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
//		} else {
//			Aluno alunoNew = alunoDtoToAluno(alunoDTO);
//			Usuario usuarioNew = alunoDtoToUsuario(alunoDTO);
//			alunoNew.setUsuario(usuarioNew);
//			
//			Aluno alunoOld = findByRa(alunoDTO.getRa());
//			
//			if(usuarioService.countByEmail(alunoDTO.getEmail())!=0){
//			mensagem.setMensagem("email já existe");
//			return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
//			return new ResponseEntity<>(alunoRepository.save(aluno), HttpStatus.OK);
//			}
//		}
//		
//	}
	
	
	
	// Método para remover registros
	public ResponseEntity<?> remover(Long ra){
		
		if(alunoRepository.countByRa(ra) == 0) {
			mensagem.setMensagem("O RA informado não existe.");
			return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
		}else {
			Aluno aluno = findByRa(ra);
			alunoRepository.delete(aluno);
			
			mensagem.setMensagem("Pessoa removida com sucesso");
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}
		
	}

	public Aluno findByRa(Long ra) {
		return alunoRepository.findByRa(ra);
	}
	
	// para o post
	private Aluno alunoDtoToAluno(AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno(alunoDTO.getRa());
		return aluno;
	}
		
	private Usuario alunoDtoToUsuario(AlunoDTO alunoDTO) {
		Usuario usuario = new Usuario(alunoDTO.getEmail(), alunoDTO.getNome());
		return usuario;
	}
	// para o put
//	private Aluno alunoDtoToAluno(AlunoDTO alunoDTO) {
//		Aluno aluno = new Aluno(Long.parseLong(alunoDTO.getRa()), alunoDTO.getEmail(), 
//				alunoDTO.getNome());
//		return aluno;
//	}
			
}
