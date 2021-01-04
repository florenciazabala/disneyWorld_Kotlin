package com.florenciazabala.modulos.pintura;

public class TegumentoVO {
   private int idTegumento;
   private String materialT;
   private String aplicacionT;
   private String espesorT;
   private String colorT;
   private String observacionT;
   private int estadoConsevacionEstrato_idestadoConsevacionEstrato;
   private int deterioroEstratos_idDeterioroEstratos;
   
   
   
   public TegumentoVO() {
	   
   }
	public TegumentoVO(int idTegumento, String materialT, String aplicacionT, String espesorT, String colorT,
		String observacionT, int estadoConsevacionEstrato_idestadoConsevacionEstrato,
		int deterioroEstratos_idDeterioroEstratos) {
	this.idTegumento = idTegumento;
	this.materialT = materialT;
	this.aplicacionT = aplicacionT;
	this.espesorT = espesorT;
	this.colorT = colorT;
	this.observacionT = observacionT;
	this.estadoConsevacionEstrato_idestadoConsevacionEstrato = estadoConsevacionEstrato_idestadoConsevacionEstrato;
	this.deterioroEstratos_idDeterioroEstratos = deterioroEstratos_idDeterioroEstratos;
    }
	
	@Override
	public String toString() {
		return "TegumentoVO [idTegumento=" + idTegumento + ", materialT=" + materialT + ", aplicacionT=" + aplicacionT
				+ ", espesorT=" + espesorT + ", colorT=" + colorT + ", observacionT=" + observacionT
				+ ", estadoConsevacionEstrato_idestadoConsevacionEstrato="
				+ estadoConsevacionEstrato_idestadoConsevacionEstrato + ", deterioroEstratos_idDeterioroEstratos="
				+ deterioroEstratos_idDeterioroEstratos + "]";
	}
	
	
	public int getIdTegumento() {
		return idTegumento;
	}
	public void setIdTegumento(int idTegumento) {
		this.idTegumento = idTegumento;
	}
	public String getMaterialT() {
		return materialT;
	}
	public void setMaterialT(String materialT) {
		this.materialT = materialT;
	}
	public String getAplicacionT() {
		return aplicacionT;
	}
	public void setAplicacionT(String aplicacionT) {
		this.aplicacionT = aplicacionT;
	}
	public String getEspesorT() {
		return espesorT;
	}
	public void setEspesorT(String espesorT) {
		this.espesorT = espesorT;
	}
	public String getColorT() {
		return colorT;
	}
	public void setColorT(String colorT) {
		this.colorT = colorT;
	}
	public String getObservacionT() {
		return observacionT;
	}
	public void setObservacionT(String observacionT) {
		this.observacionT = observacionT;
	}
	public int getEstadoConsevacionEstrato_idestadoConsevacionEstrato() {
		return estadoConsevacionEstrato_idestadoConsevacionEstrato;
	}
	public void setEstadoConsevacionEstrato_idestadoConsevacionEstrato(
			int estadoConsevacionEstrato_idestadoConsevacionEstrato) {
		this.estadoConsevacionEstrato_idestadoConsevacionEstrato = estadoConsevacionEstrato_idestadoConsevacionEstrato;
	}
	public int getDeterioroEstratos_idDeterioroEstratos() {
		return deterioroEstratos_idDeterioroEstratos;
	}
	public void setDeterioroEstratos_idDeterioroEstratos(int deterioroEstratos_idDeterioroEstratos) {
		this.deterioroEstratos_idDeterioroEstratos = deterioroEstratos_idDeterioroEstratos;
	}
   
   
}
