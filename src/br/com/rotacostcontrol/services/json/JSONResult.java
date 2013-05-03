package br.com.rotacostcontrol.services.json;

import java.io.Serializable;

public abstract class JSONResult implements Serializable{

	private static final long serialVersionUID = 7804350002398930786L;

	private String method;
	private String status;
	private String message;
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
