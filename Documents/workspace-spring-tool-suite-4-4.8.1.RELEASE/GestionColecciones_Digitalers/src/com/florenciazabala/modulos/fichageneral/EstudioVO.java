package com.florenciazabala.modulos.fichageneral;

public class EstudioVO {
    private int idEstudio;
    private String tipoEstudio;
    private String descripcionEstudio;
    private int objeto_numeroInventario;
    
    
    
    public EstudioVO() {
    	
    }
    
	public EstudioVO(int idEstudio, String tipoEstudio, String descripcionEstudio, int 	objeto_numeroInventario) {
		this.idEstudio = idEstudio;
		this.tipoEstudio = tipoEstudio;
		this.descripcionEstudio = descripcionEstudio;
		this.	objeto_numeroInventario = 	objeto_numeroInventario;
	}
	
	@Override
	public String toString() {
		return "EstudioVO [idEstudio=" + idEstudio + ", tipoEstudio=" + tipoEstudio + ", descripcionEstudio="
				+ descripcionEstudio + ", objeto_numeroInventario=" + objeto_numeroInventario + "]";
	}
	
	public int getIdEstudio() {
		return idEstudio;
	}
	public void setIdEstudio(int idEstudio) {
		this.idEstudio = idEstudio;
	}
	public String getTipoEstudio() {
		return tipoEstudio;
	}
	public void setTipoEstudio(String tipoEstudio) {
		this.tipoEstudio = tipoEstudio;
	}
	public String getDescripcionEstudio() {
		return descripcionEstudio;
	}
	public void setDescripcionEstudio(String descripcionEstudio) {
		this.descripcionEstudio = descripcionEstudio;
	}
	public int getObjeto_numeroInventario() {
		return 	objeto_numeroInventario;
	}
	public void setObjeto_numeroInventario(int 	objeto_numeroInventario) {
		this.objeto_numeroInventario = 	objeto_numeroInventario;
	}

	
    
    
}
