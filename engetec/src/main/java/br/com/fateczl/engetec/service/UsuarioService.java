package br.com.fateczl.engetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fateczl.engetec.dto.AlunoDTO;
import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.Mensagem;
import br.com.fateczl.engetec.entity.Usuario;
import br.com.fateczl.engetec.repository.SenhaRepository;
import br.com.fateczl.engetec.repository.UsuarioRepository;
import br.com.fateczl.engetec.senha.HashSenha;
import br.com.fateczl.engetec.senha.Senha;

@Service
public class UsuarioService {

	@Autowired
	private Mensagem mensagem;
	
	@Autowired
	private HashSenha hashSenha;
	
	@Autowired
	private SenhaRepository senhaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Método para cadastrar alunos 
	public Usuario cadastrar(Usuario usuario, String senha) {
		Senha objSenha = hashSenha.tratamentoSenha(senha);
		Senha senhaSalva =senhaRepository.save(objSenha);
		usuario.setSenha(senhaSalva);
		return usuarioRepository.save(usuario);
	}
	
	private Senha salvaSenha(Senha senha) {
		return senhaRepository.save(senha);
	}
	
	public int countByEmail(String email) {
		return usuarioRepository.countByEmail(email);
	}
}
