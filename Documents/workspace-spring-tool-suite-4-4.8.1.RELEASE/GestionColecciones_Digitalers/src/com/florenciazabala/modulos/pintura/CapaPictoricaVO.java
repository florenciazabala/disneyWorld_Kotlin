package com.florenciazabala.modulos.pintura;

public class CapaPictoricaVO {
    private int idCapaPictorica;
    private String tecnicaCP;
    private String aglutinanteCP;
    private String cargaCP;
    private String espesorCP;
    private String texturaCP;
    private String colorCP;
    private String observacionesCP;
    private int tegumento_idTegumento;
    private int estadoConsevacionEstrato_idestadoConsevacionEstrato;
    private int deterioroEstratos_idDeterioroEstratos;
    
    
    
    public CapaPictoricaVO() {
    	
    }
	public CapaPictoricaVO(int idCapaPictorica, String tecnicaCP, String aglutinanteCP, String cargaCP,
			String espesorCP, String texturaCP, String colorCP, String observacionesCP, int tegumento_idTegumento,
			int estadoConsevacionEstrato_idestadoConsevacionEstrato, int deterioroEstratos_idDeterioroEstratos) {
		this.idCapaPictorica = idCapaPictorica;
		this.tecnicaCP = tecnicaCP;
		this.aglutinanteCP = aglutinanteCP;
		this.cargaCP = cargaCP;
		this.espesorCP = espesorCP;
		this.texturaCP = texturaCP;
		this.colorCP = colorCP;
		this.observacionesCP = observacionesCP;
		this.tegumento_idTegumento = tegumento_idTegumento;
		this.estadoConsevacionEstrato_idestadoConsevacionEstrato = estadoConsevacionEstrato_idestadoConsevacionEstrato;
		this.deterioroEstratos_idDeterioroEstratos = deterioroEstratos_idDeterioroEstratos;
	}
	
	
	@Override
	public String toString() {
		return "CapaPictoricaVO [idCapaPictorica=" + idCapaPictorica + ", tecnicaCP=" + tecnicaCP + ", aglutinanteCP="
				+ aglutinanteCP + ", cargaCP=" + cargaCP + ", espesorCP=" + espesorCP + ", texturaCP=" + texturaCP
				+ ", colorCP=" + colorCP + ", observacionesCP=" + observacionesCP + ", tegumento_idTegumento="
				+ tegumento_idTegumento + ", estadoConsevacionEstrato_idestadoConsevacionEstrato="
				+ estadoConsevacionEstrato_idestadoConsevacionEstrato + ", deterioroEstratos_idDeterioroEstratos="
				+ deterioroEstratos_idDeterioroEstratos + "]";
	}
    
	
	
	public int getIdCapaPictorica() {
		return idCapaPictorica;
	}
	public void setIdCapaPictorica(int idCapaPictorica) {
		this.idCapaPictorica = idCapaPictorica;
	}
	public String getTecnicaCP() {
		return tecnicaCP;
	}
	public void setTecnicaCP(String tecnicaCP) {
		this.tecnicaCP = tecnicaCP;
	}
	public String getAglutinanteCP() {
		return aglutinanteCP;
	}
	public void setAglutinanteCP(String aglutinanteCP) {
		this.aglutinanteCP = aglutinanteCP;
	}
	public String getCargaCP() {
		return cargaCP;
	}
	public void setCargaCP(String cargaCP) {
		this.cargaCP = cargaCP;
	}
	public String getEspesorCP() {
		return espesorCP;
	}
	public void setEspesorCP(String espesorCP) {
		this.espesorCP = espesorCP;
	}
	public String getTexturaCP() {
		return texturaCP;
	}
	public void setTexturaCP(String texturaCP) {
		this.texturaCP = texturaCP;
	}
	public String getColorCP() {
		return colorCP;
	}
	public void setColorCP(String colorCP) {
		this.colorCP = colorCP;
	}
	public String getObservacionesCP() {
		return observacionesCP;
	}
	public void setObservacionesCP(String observacionesCP) {
		this.observacionesCP = observacionesCP;
	}
	public int getTegumento_idTegumento() {
		return tegumento_idTegumento;
	}
	public void setTegumento_idTegumento(int tegumento_idTegumento) {
		this.tegumento_idTegumento = tegumento_idTegumento;
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
