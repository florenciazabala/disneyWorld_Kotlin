package com.florenciazabala.modulos.fichageneral;

public class EstadoConservacionVO {
	
	private int idEstadoConservacion;
	private String estadoConservacion;
	private String descripcion;
	
	
	public EstadoConservacionVO() {
		
	}
	public EstadoConservacionVO(int idEstadoConservacion, String estadoConservacion, String descripcion) {
		this.idEstadoConservacion = idEstadoConservacion;
		this.estadoConservacion = estadoConservacion;
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "EstadoconservacionVO [idEstadoConservacion=" + idEstadoConservacion + ", estadoConservacion="
				+ estadoConservacion + ", descripcion=" + descripcion + "]";
	}
	
	
	public int getIdEstadoConservacion() {
		return idEstadoConservacion;
	}
	public void setIdEstadoConservacion(int idEstadoConservacion) {
		this.idEstadoConservacion = idEstadoConservacion;
	}
	public String getEstadoConservacion() {
		return estadoConservacion;
	}
	public void setEstadoConservacion(String estadoConservacion) {
		this.estadoConservacion = estadoConservacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
