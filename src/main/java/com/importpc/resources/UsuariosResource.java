 package com.importpc.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.importpc.dto.UsuariosDTO;
import com.importpc.models.UsuariosEntity;
import com.importpc.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value="API REST Usuarios")
@RestController
@RequestMapping(value="/api")
public class UsuariosResource {
	
	
	@Autowired
	private UserService service;
	
	@ApiOperation(value="Retorna usuarios")
	@GetMapping("/recuperar/todos/usuarios")
	public List<UsuariosEntity> listaUsuarios(){
		return service.getAll();
	}
	
	@ApiOperation(value="Criar usuario")
	@PostMapping("/criar/usuario")
	public void salvaUsuarios(@RequestBody  UsuariosDTO dto) {
	
		service.create(dto.buildSalvar(dto));
	}
	
	@ApiOperation(value="Recuperar unico usuario")
	@GetMapping("/recuperar/unico/usuario/{idcadusuario}")
	public Optional<UsuariosEntity> listaParcelaUnica(@PathVariable(value="idcadusuario") Integer idcadusuario){
		return service.getUserById(idcadusuario);
	}
	
	@ApiOperation(value="Atualizar usuario")
	@PutMapping("/atualizar/usuario/{id}")
	public void atualizaUsuarios(@RequestBody  UsuariosDTO dto, @PathVariable(value="id") Integer id) {
		 service.update(dto, id);
	}
	
	@ApiOperation(value="Deleta usuario")
	@DeleteMapping("/deletar/usuario/{id}")
	public void deletaUsuarios(@PathVariable(value="id") Integer id){
		service.delete(id);
	}
	
	


	

}