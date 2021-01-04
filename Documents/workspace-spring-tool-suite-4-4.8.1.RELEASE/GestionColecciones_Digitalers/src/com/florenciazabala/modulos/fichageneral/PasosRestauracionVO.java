package com.florenciazabala.modulos.fichageneral;

public class PasosRestauracionVO {
	
	private int idPasosRestauracion;
	private int paso;
	private String tratamiento;
	private String producto;
	private int restauracion_idRestauracion;
	
	
	public PasosRestauracionVO() {
		
	}
	
	public PasosRestauracionVO(int idPasosRestauracion, int paso, String tratamiento, String producto,
			int restauracion_idRestauracion) {
		super();
		this.idPasosRestauracion = idPasosRestauracion;
		this.paso = paso;
		this.tratamiento = tratamiento;
		this.producto = producto;
		this.restauracion_idRestauracion = restauracion_idRestauracion;
	}


	@Override
	public String toString() {
		return "PasosRestauracionVO [idPasosRestauracion=" + idPasosRestauracion + ", paso=" + paso + ", tratamiento="
				+ tratamiento + ", producto=" + producto + ", restauracion_idRestauracion="
				+ restauracion_idRestauracion + "]";
	}
	


	public int getIdPasosRestauracion() {
		return idPasosRestauracion;
	}


	public void setIdPasosRestauracion(int idPasosRestauracion) {
		this.idPasosRestauracion = idPasosRestauracion;
	}


	public int getPaso() {
		return paso;
	}


	public void setPaso(int paso) {
		this.paso = paso;
	}


	public String getTratamiento() {
		return tratamiento;
	}


	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	public int getRestauracion_idRestauracion() {
		return restauracion_idRestauracion;
	}


	public void setRestauracion_idRestauracion(int restauracion_idRestauracion) {
		this.restauracion_idRestauracion = restauracion_idRestauracion;
	}

}
