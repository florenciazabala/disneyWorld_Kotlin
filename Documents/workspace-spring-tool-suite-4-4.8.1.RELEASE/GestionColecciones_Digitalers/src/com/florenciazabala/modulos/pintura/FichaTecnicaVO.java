package com.florenciazabala.modulos.pintura;

public class FichaTecnicaVO {
	
	private int idFichaTecnica;
	private String objetoFT;
	private String tituloFT;
	private String autorFT;
	private String añoPeriodoFT;
	private String tecnicaFT;
	private String soporteFT;
	private String dimensionesFT;
	private String generoFT;
	private String formatoFT;
	private String firmaFT;
	private String inscripcionesFT;
	private String descripcionFT;
	
	
	
	
	public FichaTecnicaVO() {
		
	}
	public FichaTecnicaVO(int idFichaTecnica, String objetoFT, String tituloFT, String autorFT, String añoPeriodoFT,
			String tecnicaFT, String soporteFT, String dimensionesFT, String generoFT, String formatoFT, String firmaFT,
			String inscripcionesFT, String descripcionFT) {
		this.idFichaTecnica = idFichaTecnica;
		this.objetoFT = objetoFT;
		this.tituloFT = tituloFT;
		this.autorFT = autorFT;
		this.añoPeriodoFT = añoPeriodoFT;
		this.tecnicaFT = tecnicaFT;
		this.soporteFT = soporteFT;
		this.dimensionesFT = dimensionesFT;
		this.generoFT = generoFT;
		this.formatoFT = formatoFT;
		this.firmaFT = firmaFT;
		this.inscripcionesFT = inscripcionesFT;
		this.descripcionFT = descripcionFT;
	}
	
	
	@Override
	public String toString() {
		return "FichaTecnicaVO [idFichaTecnica=" + idFichaTecnica + ", objetoFT=" + objetoFT + ", tituloFT=" + tituloFT
				+ ", autorFT=" + autorFT + ", añoPeriodoFT=" + añoPeriodoFT + ", tecnicaFT=" + tecnicaFT
				+ ", soporteFT=" + soporteFT + ", dimensionesFT=" + dimensionesFT + ", generoFT=" + generoFT
				+ ", formatoFT=" + formatoFT + ", firmaFT=" + firmaFT + ", inscripcionesFT=" + inscripcionesFT
				+ ", descripcionFT=" + descripcionFT + "]";
	}
	
	
	
	
	
	public int getIdFichaTecnica() {
		return idFichaTecnica;
	}
	public void setIdFichaTecnica(int idFichaTecnica) {
		this.idFichaTecnica = idFichaTecnica;
	}
	public String getObjetoFT() {
		return objetoFT;
	}
	public void setObjetoFT(String objetoFT) {
		this.objetoFT = objetoFT;
	}
	public String getTituloFT() {
		return tituloFT;
	}
	public void setTituloFT(String tituloFT) {
		this.tituloFT = tituloFT;
	}
	public String getAutorFT() {
		return autorFT;
	}
	public void setAutorFT(String autorFT) {
		this.autorFT = autorFT;
	}
	public String getAñoPeriodoFT() {
		return añoPeriodoFT;
	}
	public void setAñoPeriodoFT(String añoPeriodoFT) {
		this.añoPeriodoFT = añoPeriodoFT;
	}
	public String getTecnicaFT() {
		return tecnicaFT;
	}
	public void setTecnicaFT(String tecnicaFT) {
		this.tecnicaFT = tecnicaFT;
	}
	public String getSoporteFT() {
		return soporteFT;
	}
	public void setSoporteFT(String soporteFT) {
		this.soporteFT = soporteFT;
	}
	public String getDimensionesFT() {
		return dimensionesFT;
	}
	public void setDimensionesFT(String dimensionesFT) {
		this.dimensionesFT = dimensionesFT;
	}
	public String getGeneroFT() {
		return generoFT;
	}
	public void setGeneroFT(String generoFT) {
		this.generoFT = generoFT;
	}
	public String getFormatoFT() {
		return formatoFT;
	}
	public void setFormatoFT(String formatoFT) {
		this.formatoFT = formatoFT;
	}
	public String getFirmaFT() {
		return firmaFT;
	}
	public void setFirmaFT(String firmaFT) {
		this.firmaFT = firmaFT;
	}
	public String getInscripcionesFT() {
		return inscripcionesFT;
	}
	public void setInscripcionesFT(String inscripcionesFT) {
		this.inscripcionesFT = inscripcionesFT;
	}
	public String getDescripcionFT() {
		return descripcionFT;
	}
	public void setDescripcionFT(String descripcionFT) {
		this.descripcionFT = descripcionFT;
	}
	

}
