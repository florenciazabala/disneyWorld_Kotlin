package com.florenciazabala.excepciones;

public class NegocioException extends Exception {
	private String mensaje;
	
	public NegocioException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String getMessage() {
		return mensaje;
	}

}



