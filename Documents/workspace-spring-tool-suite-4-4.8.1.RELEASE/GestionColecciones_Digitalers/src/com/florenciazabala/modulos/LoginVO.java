package com.florenciazabala.modulos;

public class LoginVO {
	//Array, evitar dupicacion nombreusuario equals
    private int idLogin;
    private String nombreUsuario;
    private String password;
    
    
    public LoginVO() {
    	
    }
	public LoginVO(int idLogin, String nombreUsuario, String password) {
		super();
		this.idLogin = idLogin;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "LoginVO [idLogin=" + idLogin + ", nombreUsuario=" + nombreUsuario + ", password=" + password + "]";
	}
	
	
	public int getIdLogin() {
		return idLogin;
	}
	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
