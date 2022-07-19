package com.importpc.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CADUSUARIOS")
public class UsuariosEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idcadusuario")
	private Integer id;
	
	@Column(name = "dcr_usuario")
	private String dcrUsuario;
	
	@Column(name = "dcr_login")
	private String dcrLogin;
	
	@Column(name = "dcr_senha")
	private String dcrSenha;
	
	@Column(name = "dat_cadastro")
	private Date datCadastro;
	
	@Column(name = "dat_desativacao")
	private Date datDesativacao;
	

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getDatCadastro() {
		return datCadastro;
	}

	public void setDatCadastro(Date datCadastro) {
		this.datCadastro = datCadastro;
	}

	public Date getDatDesativacao() {
		return datDesativacao;
	}

	public void setDatDesativacao(Date datDesativacao) {
		this.datDesativacao = datDesativacao;
	}
	
	
	
}
	