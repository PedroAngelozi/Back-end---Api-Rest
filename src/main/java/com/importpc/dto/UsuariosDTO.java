package com.importpc.dto;

import java.util.Date;

import com.importpc.models.UsuariosEntity;

public class UsuariosDTO {
	
	private String dcrUsuario;
	
	private String dcrLogin;
		
	private String dcrSenha;


	public String getDcrUsuario() {
		return dcrUsuario;
	}



	public void setDcrUsuario(String dcrUsuario) {
		this.dcrUsuario = dcrUsuario;
	}



	public String getDcrLogin() {
		return dcrLogin;
	}



	public void setDcrLogin(String dcrLogin) {
		this.dcrLogin = dcrLogin;
	}



	public String getDcrSenha() {
		return dcrSenha;
	}



	public void setDcrSenha(String dcrSenha) {
		this.dcrSenha = dcrSenha;
	}




	public UsuariosEntity buildSalvar(UsuariosDTO dto) {
		
		UsuariosEntity entity = new UsuariosEntity();
		
		entity.setDcrUsuario(dto.getDcrUsuario());
		entity.setDcrLogin(dto.getDcrLogin());
		entity.setDcrSenha(dto.getDcrSenha());
		entity.setDatCadastro(new Date());
		
		return entity;
	}
	



}
