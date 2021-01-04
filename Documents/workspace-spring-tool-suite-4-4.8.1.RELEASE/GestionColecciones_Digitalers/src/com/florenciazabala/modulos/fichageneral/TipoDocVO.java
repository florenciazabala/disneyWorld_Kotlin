package com.florenciazabala.modulos.fichageneral;

public class TipoDocVO {
   private int idTipoDoc;
   private String tipoDoc;

   
   public TipoDocVO() {
	   
   }
	public TipoDocVO(int idTipoDoc, String tipoDoc) {
	super();
	this.idTipoDoc = idTipoDoc;
	this.tipoDoc = tipoDoc;
    }
	
	@Override
	public String toString() {
		return "TipoDocVO [idTipoDoc=" + idTipoDoc + ", tipoDoc=" + tipoDoc + "]";
	}
   
	
	public int getIdTipoDoc() {
		return idTipoDoc;
	}
	public void setIdTipoDoc(int idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	
   
}
