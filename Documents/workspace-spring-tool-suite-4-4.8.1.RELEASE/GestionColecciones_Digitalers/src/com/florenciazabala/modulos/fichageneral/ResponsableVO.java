package com.florenciazabala.modulos.fichageneral;

import java.sql.Date;

public class ResponsableVO {
     private int idResponsable;
     private Date fechaIngreso;
     private int Usuario_idUsuario;
     
     
     
     public ResponsableVO() {
    	 
     }
	public ResponsableVO(int idResponsable, Date fechaIngreso, int usuario_idUsuario) {
		this.idResponsable = idResponsable;
		this.fechaIngreso = fechaIngreso;
		this.Usuario_idUsuario = usuario_idUsuario;
	}
	
	@Override
	public String toString() {
		return "ResponsableVO [idResponsable=" + idResponsable + ", fechaIngreso=" + fechaIngreso
				+ ", Usuario_idUsuario=" + Usuario_idUsuario + "]";
	}
     
	
	public int getIdResponsable() {
		return idResponsable;
	}
	public void setIdResponsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public int getUsuario_idUsuario() {
		return Usuario_idUsuario;
	}
	public void setUsuario_idUsuario(int usuario_idUsuario) {
		Usuario_idUsuario = usuario_idUsuario;
	}
	
	
}
