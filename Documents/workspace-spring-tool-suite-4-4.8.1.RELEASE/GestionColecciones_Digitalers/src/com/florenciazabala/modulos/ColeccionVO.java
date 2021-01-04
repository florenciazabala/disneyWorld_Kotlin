package com.florenciazabala.modulos;

import java.sql.Date;

public class ColeccionVO {
   private int idColeccion; //PK
   private String codigo;
   private String nombreColeccion;
   private Date fechaCreacion;
   private String descripcion;
   

   public ColeccionVO() {
		
	}
   
	public ColeccionVO(int idColeccion, String codigo, String nombreColeccion, java.sql.Date fechaCreacion, String descripcion) {
	this.idColeccion = idColeccion;
	this.codigo = codigo;
	this.nombreColeccion = nombreColeccion;
	this.fechaCreacion = fechaCreacion;
	this.descripcion= descripcion;
    }
	//java.sql.Date fechaCreacion = new java.sql.Date(d.getTime());
	
	@Override
	public String toString() {
		return "ColeccionVO [idColeccion=" + idColeccion + ", codigo=" + codigo + ", nombreColeccion=" + nombreColeccion
				+ ", fechaCreacion=" + fechaCreacion + ", descripcion="+descripcion+"]";
	}

   
	
	public int getIdColeccion() {
		return idColeccion;
	}
	public void setIdColeccion(int idColeccion) {
		this.idColeccion = idColeccion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombreColeccion() {
		return nombreColeccion;
	}
	public void setNombreColeccion(String nombreColeccion) {
		this.nombreColeccion = nombreColeccion;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

   
}
