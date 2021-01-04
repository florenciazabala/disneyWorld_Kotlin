package com.florenciazabala.modulos.pintura;

public class SoportePrincipalTVO {
    private int idSoportePrincipalT;
    private String tipoTextil;
    private String ligamento;
    private int densidadT;
    private int densidadU;
    private String montaje;
    private String posicionUrdimbre;
    private String torsionTrama;
    private String torsionUrdimbre;
    
    
    
    public SoportePrincipalTVO() {
    	
    }
	public SoportePrincipalTVO(int idSoportePrincipalT, String tipoTextil, String ligamento, int densidadT,
			int densidadU, String montaje, String posicionUrdimbre, String torsionTrama, String torsionUrdimbre) {
		this.idSoportePrincipalT = idSoportePrincipalT;
		this.tipoTextil = tipoTextil;
		this.ligamento = ligamento;
		this.densidadT = densidadT;
		this.densidadU = densidadU;
		this.montaje = montaje;
		this.posicionUrdimbre = posicionUrdimbre;
		this.torsionTrama = torsionTrama;
		this.torsionUrdimbre = torsionUrdimbre;
	}
	
	
	@Override
	public String toString() {
		return "SoportePrincipalTVO [idSoportePrincipalT=" + idSoportePrincipalT + ", tipoTextil=" + tipoTextil
				+ ", ligamento=" + ligamento + ", densidadT=" + densidadT + ", densidadU=" + densidadU + ", montaje="
				+ montaje + ", posicionUrdimbre=" + posicionUrdimbre + ", torsionTrama=" + torsionTrama
				+ ", torsionUrdimbre=" + torsionUrdimbre + "]";
	}
    
    
	
	public int getIdSoportePrincipalT() {
		return idSoportePrincipalT;
	}
	public void setIdSoportePrincipalT(int idSoportePrincipalT) {
		this.idSoportePrincipalT = idSoportePrincipalT;
	}
	public String getTipoTextil() {
		return tipoTextil;
	}
	public void setTipoTextil(String tipoTextil) {
		this.tipoTextil = tipoTextil;
	}
	public String getLigamento() {
		return ligamento;
	}
	public void setLigamento(String ligamento) {
		this.ligamento = ligamento;
	}
	public int getDensidadT() {
		return densidadT;
	}
	public void setDensidadT(int densidadT) {
		this.densidadT = densidadT;
	}
	public int getDensidadU() {
		return densidadU;
	}
	public void setDensidadU(int densidadU) {
		this.densidadU = densidadU;
	}
	public String getMontaje() {
		return montaje;
	}
	public void setMontaje(String montaje) {
		this.montaje = montaje;
	}
	public String getPosicionUrdimbre() {
		return posicionUrdimbre;
	}
	public void setPosicionUrdimbre(String posicionUrdimbre) {
		this.posicionUrdimbre = posicionUrdimbre;
	}
	public String getTorsionTrama() {
		return torsionTrama;
	}
	public void setTorsionTrama(String torsionTrama) {
		this.torsionTrama = torsionTrama;
	}
	public String getTorsionUrdimbre() {
		return torsionUrdimbre;
	}
	public void setTorsionUrdimbre(String torsionUrdimbre) {
		this.torsionUrdimbre = torsionUrdimbre;
	}
	
}
