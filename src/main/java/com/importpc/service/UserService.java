package com.importpc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.importpc.dto.UsuarioResponse;
import com.importpc.dto.UsuariosDTO;
import com.importpc.models.UsuariosEntity;
import com.importpc.repository.UsuariosRepository;

@Service
public class UserService {

	@Autowired
	private UsuariosRepository repository;

	public static final String PATTERN = "(?=.[}{,.^?~=+\\-_\\/\\-+.\\|])(?=.[a-zA-Z])(?=.[0-9]).{8,}";
	
	public List<UsuariosEntity> getAll() {
		return repository.findAtivos();

    }
	
	public  Optional<UsuariosEntity> getUserById(Integer userId) {
		return repository.findById(userId);

	}
	
public ResponseEntity<?> create(UsuariosEntity user) {
		
		UsuarioResponse response = new UsuarioResponse();
		
		if(!user.getDcrSenha().matches(PATTERN)) {
			 response.setMessage("A senha deve conter no minimo 8 caracteres, 1 numero e 1 caracter especial!");
			 response.setSuccess(false);
			 return new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
		}
		
		List<UsuariosEntity> entityRetorno = repository.findUser(user.getDcrLogin());
		
		if(entityRetorno.size() > 0) {
			
			response.setMessage("USUARIO JA EXISTENTE");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
		}
		
		repository.save(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public void update(UsuariosDTO dto, Integer id) {
		UsuariosEntity entity = repository.findById(id).get();
		entity = dto.buildSalvar(dto);
		entity.setId(id);
		repository.saveAndFlush(entity);
	}
	
	public ResponseEntity<?> delete(Integer userId) {
        
		UsuariosEntity entity = repository.findById(userId).get();
		entity.setDatDesativacao(new Date()); 
		repository.saveAndFlush(entity);
        return ResponseEntity.ok().build();
    }
}