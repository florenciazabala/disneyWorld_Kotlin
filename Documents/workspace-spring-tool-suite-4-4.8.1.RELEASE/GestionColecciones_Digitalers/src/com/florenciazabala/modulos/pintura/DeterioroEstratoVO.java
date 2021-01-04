package com.florenciazabala.modulos.pintura;

public class DeterioroEstratoVO {
	
	private int idDeterioroEstratos;
	private String deterioro;
	private String descripcion;
	private int examenOrganoleptico_idExamenOrganoleptico;
	
	
	
	public DeterioroEstratoVO() {
		
	}
	public DeterioroEstratoVO(int idDeterioroEstratos, String deterioro, String descripcion,
			int examenOrganoleptico_idExamenOrganoleptico) {
		this.idDeterioroEstratos = idDeterioroEstratos;
		this.deterioro = deterioro;
		this.descripcion = descripcion;
		this.examenOrganoleptico_idExamenOrganoleptico = examenOrganoleptico_idExamenOrganoleptico;
	}
	
	@Override
	public String toString() {
		return "DeterioroEstratoVO [idDeterioroEstratos=" + idDeterioroEstratos + ", deterioro=" + deterioro
				+ ", descripcion=" + descripcion + ", examenOrganoleptico_idExamenOrganoleptico="
				+ examenOrganoleptico_idExamenOrganoleptico + "]";
	}
	
    
	
	public int getIdDeterioroEstratos() {
		return idDeterioroEstratos;
	}
	public void setIdDeterioroEstratos(int idDeterioroEstratos) {
		this.idDeterioroEstratos = idDeterioroEstratos;
	}
	public String getDeterioro() {
		return deterioro;
	}
	public void setDeterioro(String deterioro) {
		this.deterioro = deterioro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getExamenOrganoleptico_idExamenOrganoleptico() {
		return examenOrganoleptico_idExamenOrganoleptico;
	}
	public void setExamenOrganoleptico_idExamenOrganoleptico(int examenOrganoleptico_idExamenOrganoleptico) {
		this.examenOrganoleptico_idExamenOrganoleptico = examenOrganoleptico_idExamenOrganoleptico;
	}
	
}
