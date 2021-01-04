package com.florenciazabala.modulos.fichageneral;

public class RestauracionVO {
   private int idRestauracion;
   private String propuestaTratamiento;
   
    public RestauracionVO() {
	   
   }

	public RestauracionVO(int idRestauracion, String propuestaTratamiento) {
	this.idRestauracion = idRestauracion;
	this.propuestaTratamiento = propuestaTratamiento;
    }
    

	@Override
	public String toString() {
		return "RestauracionVO [idRestauracion=" + idRestauracion +", propuestaTratamiento="+propuestaTratamiento+ "]";
	}
   
	public int getIdRestauracion() {
		return idRestauracion;
	}
	
	public void setIdRestauracion(int idRestauracion) {
		this.idRestauracion = idRestauracion;
	}

	public String getPropuestaTratamiento() {
		return propuestaTratamiento;
	}

	public void setPropuestaTratamiento(String propuestaTratamiento) {
		this.propuestaTratamiento = propuestaTratamiento;
	}

   
}
