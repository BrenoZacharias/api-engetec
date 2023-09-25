package br.com.fateczl.engetec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fateczl.engetec.dto.AlunoDTO;
import br.com.fateczl.engetec.dto.AvaliadorDTO;
import br.com.fateczl.engetec.entity.Aluno;
import br.com.fateczl.engetec.entity.Avaliador;
import br.com.fateczl.engetec.entity.Mensagem;
import br.com.fateczl.engetec.repository.AvaliadorRepository;
import br.com.fateczl.engetec.repository.SenhaRepository;
import br.com.fateczl.engetec.senha.HashSenha;
import br.com.fateczl.engetec.senha.Senha;

@Service
public class AvaliadorService {

	@Autowired
	private Mensagem mensagem;
	
	@Autowired
	private AvaliadorRepository avaliadorRepository;
	
	@Autowired
	private HashSenha hashSenha;
	
	@Autowired
	private SenhaRepository senhaRepository;
	
	public ResponseEntity<?> cadastrar(AvaliadorDTO avaliadorDTO) {
		Senha objSenha = hashSenha.tratamentoSenha(avaliadorDTO.getSenha());
		Avaliador avaliador = AvaliadorDtoToAvaliador(avaliadorDTO, objSenha);
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
		return null;
	}

	private Avaliador AvaliadorDtoToAvaliador(AvaliadorDTO avaliadorDTO, Senha objSenha) {
		Avaliador avaliador = new Avaliador(avaliadorDTO.getMatricula(), avaliadorDTO.getAvaliacoes(), 
				avaliadorDTO.getAreas(), avaliadorDTO.getEmail(), avaliadorDTO.getNome());
		return avaliador;
	}
	
}
