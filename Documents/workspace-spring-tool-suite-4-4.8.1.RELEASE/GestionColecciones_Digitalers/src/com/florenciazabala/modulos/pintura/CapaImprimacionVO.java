package com.florenciazabala.modulos.pintura;

public class CapaImprimacionVO {
	
	private int idCapaImprimacion;
	private String acabadoCI;
	private String tipoCI;
	private String manufacturaCI;
	private String cargaCI;
	private String aglutinanteCI;
	private String colorCI;
	private String aparienciaCI;
	private int capaPictorica_idCapaPictorica;
	private int estadoConsevacionEstrato_idestadoConsevacionEstrato;
	
	
	
	public CapaImprimacionVO() {
		
	}
	public CapaImprimacionVO(int idCapaImprimacion, String acabadoCI, String tipoCI, String manufacturaCI,
			String cargaCI, String aglutinanteCI, String colorCI, String aparienciaCI,
			int capaPictorica_idCapaPictorica, int estadoConsevacionEstrato_idestadoConsevacionEstrato) {
		this.idCapaImprimacion = idCapaImprimacion;
		this.acabadoCI = acabadoCI;
		this.tipoCI = tipoCI;
		this.manufacturaCI = manufacturaCI;
		this.cargaCI = cargaCI;
		this.aglutinanteCI = aglutinanteCI;
		this.colorCI = colorCI;
		this.aparienciaCI = aparienciaCI;
		this.capaPictorica_idCapaPictorica = capaPictorica_idCapaPictorica;
		this.estadoConsevacionEstrato_idestadoConsevacionEstrato = estadoConsevacionEstrato_idestadoConsevacionEstrato;
	}
	
	@Override
	public String toString() {
		return "CapaImprimacionVO [idCapaImprimacion=" + idCapaImprimacion + ", acabadoCI=" + acabadoCI + ", tipoCI="
				+ tipoCI + ", manufacturaCI=" + manufacturaCI + ", cargaCI=" + cargaCI + ", aglutinanteCI="
				+ aglutinanteCI + ", colorCI=" + colorCI + ", aparienciaCI=" + aparienciaCI
				+ ", capaPictorica_idCapaPictorica=" + capaPictorica_idCapaPictorica
				+ ", estadoConsevacionEstrato_idestadoConsevacionEstrato="
				+ estadoConsevacionEstrato_idestadoConsevacionEstrato + "]";
	}
	
	
	
	public int getIdCapaImprimacion() {
		return idCapaImprimacion;
	}
	public void setIdCapaImprimacion(int idCapaImprimacion) {
		this.idCapaImprimacion = idCapaImprimacion;
	}
	public String getAcabadoCI() {
		return acabadoCI;
	}
	public void setAcabadoCI(String acabadoCI) {
		this.acabadoCI = acabadoCI;
	}
	public String getTipoCI() {
		return tipoCI;
	}
	public void setTipoCI(String tipoCI) {
		this.tipoCI = tipoCI;
	}
	public String getManufacturaCI() {
		return manufacturaCI;
	}
	public void setManufacturaCI(String manufacturaCI) {
		this.manufacturaCI = manufacturaCI;
	}
	public String getCargaCI() {
		return cargaCI;
	}
	public void setCargaCI(String cargaCI) {
		this.cargaCI = cargaCI;
	}
	public String getAglutinanteCI() {
		return aglutinanteCI;
	}
	public void setAglutinanteCI(String aglutinanteCI) {
		this.aglutinanteCI = aglutinanteCI;
	}
	public String getColorCI() {
		return colorCI;
	}
	public void setColorCI(String colorCI) {
		this.colorCI = colorCI;
	}
	public String getAparienciaCI() {
		return aparienciaCI;
	}
	public void setAparienciaCI(String aparienciaCI) {
		this.aparienciaCI = aparienciaCI;
	}
	public int getCapaPictorica_idCapaPictorica() {
		return capaPictorica_idCapaPictorica;
	}
	public void setCapaPictorica_idCapaPictorica(int capaPictorica_idCapaPictorica) {
		this.capaPictorica_idCapaPictorica = capaPictorica_idCapaPictorica;
	}
	public int getEstadoConsevacionEstrato_idestadoConsevacionEstrato() {
		return estadoConsevacionEstrato_idestadoConsevacionEstrato;
	}
	public void setEstadoConsevacionEstrato_idestadoConsevacionEstrato(
			int estadoConsevacionEstrato_idestadoConsevacionEstrato) {
		this.estadoConsevacionEstrato_idestadoConsevacionEstrato = estadoConsevacionEstrato_idestadoConsevacionEstrato;
	}
  
}
