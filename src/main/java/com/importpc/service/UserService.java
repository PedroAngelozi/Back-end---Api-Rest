package com.importpc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.importpc.dto.UsuariosDTO;
import com.importpc.models.UsuariosEntity;
import com.importpc.repository.UsuariosRepository;

@Service
public class UserService {

	@Autowired
	private UsuariosRepository repository;

	public List<UsuariosEntity> getAll() {
		return repository.findAtivos();

    }
	
	public  Optional<UsuariosEntity> getUserById(Integer userId) {
		return repository.findById(userId);

	}
	
	public ResponseEntity<?>  create(UsuariosEntity user) {
		List<UsuariosEntity> entityRetorno = repository.findUser(user.getDcrLogin());

		
		if(user.getDcrSenha().matches("^(?=.*[A-Za-z])(?=.*d)(?=.*[@$!%*#?&])[A-Za-zd@$!%*#?&]{8,}$")) {
			System.out.println("Exemplo que passa");
			
			if(entityRetorno.size() > 0) {
				return ResponseEntity.ok().build();
			}
			
			
		} else if(user.getDcrSenha().matches("(?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])(?=.*[a-zA-Z])(?=.*[0-9]).{8,}")) {
			System.out.println("exemplo que nao passa (falta caractere especial)");
			
		} else if(user.getDcrSenha().matches("(?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])(?=.*[a-zA-Z])(?=.*[0-9]).{8,}")) {
			System.out.println("exemplo que nao passa (falta numero)");
			
		} else if(user.getDcrSenha().matches("(?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])(?=.*[a-zA-Z])(?=.*[0-9]).{8,}")) {
			System.out.println("exemplo que nao passa (falta letra)");
			
		} else if(user.getDcrSenha().matches("(?=.*[}{,.^?~=+\\-_\\/*\\-+.\\|])(?=.*[a-zA-Z])(?=.*[0-9]).{8,}")) {
			System.out.println("exemplo que nao passa (nao tem minimo de 8 caracteres)");
			
		}
		
		repository.save(user);
	    return ResponseEntity.ok().build();
		
		
		 
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