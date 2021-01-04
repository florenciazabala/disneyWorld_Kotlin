package com.florenciazabala.modulos.fichageneral;

public class TipologiaVO {
      private int idTipologia;
      private String codigoTipologia;
      private String tipologia;
      
      
      public TipologiaVO() {
    	  
      } 
      
	public TipologiaVO(int idTipologia, String codigoTipologia, String tipologia) {
		this.idTipologia = idTipologia;
		this.codigoTipologia = codigoTipologia;
		this.tipologia = tipologia;
	}
	
	@Override
	public String toString() {
		return "TipologiaVO [idTipologia=" + idTipologia + ", codigoTipologia=" + codigoTipologia + ", tipologia="
				+ tipologia + "]";
	}
      
      
	
	public int getIdTipologia() {
		return idTipologia;
	}
	public void setIdTipologia(int idTipologia) {
		this.idTipologia = idTipologia;
	}
	public String getCodigoTipologia() {
		return codigoTipologia;
	}
	public void setCodigoTipologia(String codigoTipologia) {
		this.codigoTipologia = codigoTipologia;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

}
