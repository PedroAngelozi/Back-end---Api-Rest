package com.importpc.dto;

import java.util.ArrayList;
import java.util.List;


public class UsuarioResponse {

	private Boolean success;
	private List<String> message;

	public UsuarioResponse() {
		this.success = false;
		this.message = new ArrayList<>();
	}

	public UsuarioResponse(Boolean success) {
		super();
		this.success = success;
		this.message = new ArrayList<>();
	}

	public UsuarioResponse(Boolean success, String message) {
		super();
		this.success = success;
		this.message = new ArrayList<>();
		this.message.add(message);
	}

	public UsuarioResponse(Boolean success, List<String> message) {
		super();
		this.success = success;
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<String> getMessage() {
		return message;
	}

	public void clearMessages() {
		this.message.clear();
	}

	public void setMessage(String message) {
		this.message.add(message);
	}

	public void setMessage(List<String> messages) {
		this.message.addAll(message);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String mess : message) {
			sb.append(mess + ", ");
		}

		return "UsuarioResponse [success=" + success + ", message=" + sb.toString() + "]";
	}


}


