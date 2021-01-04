package com.florenciazabala.modulos;

import java.sql.Date;

public class UsuarioVO {
   private int idUsuario;
   private String nombreUsuario;
   private String apellido;
   private int dni;
   private Date fechaNacimiento;
   private String cargo;
   private String mailUsuario;
   private String direccionUsuario;
   private int telefonoUsuario;
   private int museo_idmuseo;
   private int login_idLogin;
   private int imagenUsuario_idImagenUsuario;
   
   
   public UsuarioVO() {
	   
   }
   
	public UsuarioVO(int idUsuario, String nombreUsuario, String apellido, int dni, Date fechaNacimiento, String cargo,
		String mailUsuario, String direccionUsuario, int telefonoUsuario, int museo_idmuseo, int login_idLogin,
		int imagenUsuario_idImagenUsuario) {
	
	this.idUsuario = idUsuario;
	this.nombreUsuario = nombreUsuario;
	this.apellido = apellido;
	this.dni = dni;
	this.fechaNacimiento = fechaNacimiento;
	this.cargo = cargo;
	this.mailUsuario = mailUsuario;
	this.direccionUsuario = direccionUsuario;
	this.telefonoUsuario = telefonoUsuario;
	this.museo_idmuseo = museo_idmuseo;
	this.login_idLogin = login_idLogin;
	this.imagenUsuario_idImagenUsuario = imagenUsuario_idImagenUsuario;
    }
	
	
	@Override
	public String toString() {
		return "UsuarioVO [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", apellido=" + apellido
				+ ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", cargo=" + cargo + ", mailUsuario="
				+ mailUsuario + ", direccionUsuario=" + direccionUsuario + ", telefonoUsuario=" + telefonoUsuario
				+ ", museo_idmuseo=" + museo_idmuseo + ", login_idLogin=" + login_idLogin
				+ ", imagenUsuario_idImagenUsuario=" + imagenUsuario_idImagenUsuario + "]";
	}
   
   
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getMailUsuario() {
		return mailUsuario;
	}
	public void setMailUsuario(String mailUsuario) {
		this.mailUsuario = mailUsuario;
	}
	public String getDireccionUsuario() {
		return direccionUsuario;
	}
	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}
	public int getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(int telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public int getMuseo_idmuseo() {
		return museo_idmuseo;
	}
	public void setMuseo_idmuseo(int museo_idmuseo) {
		this.museo_idmuseo = museo_idmuseo;
	}
	public int getLogin_idLogin() {
		return login_idLogin;
	}
	public void setLogin_idLogin(int login_idLogin) {
		this.login_idLogin = login_idLogin;
	}
	public int getImagenUsuario_idImagenUsuario() {
		return imagenUsuario_idImagenUsuario;
	}
	public void setImagenUsuario_idImagenUsuario(int imagenUsuario_idImagenUsuario) {
		this.imagenUsuario_idImagenUsuario = imagenUsuario_idImagenUsuario;
	}

   
}
