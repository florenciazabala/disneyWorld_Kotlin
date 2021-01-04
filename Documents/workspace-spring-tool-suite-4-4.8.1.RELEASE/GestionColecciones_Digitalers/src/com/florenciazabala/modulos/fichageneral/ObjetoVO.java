package com.florenciazabala.modulos.fichageneral;

import java.sql.Date;

public class ObjetoVO {
       
	   private int numeroInventario;
	   private String codigoMuseo;
	   private Date fechaIngreso;
	   private String ubicacion;
	   private String procedencia;
	   private String propietario;
	   private String estado;
	   private int museo_idmuseo;            //FK
	   private int coleccion_idcoleccion1;   //FK
	   private int sala_numeroSala;          //FK
	   private int documentacionFotografica_idDocumentacionFotografica; //FK
	   private int estudio_idEstudio;  //FK
	   private int restauracion_idRestauracion; //FK
	   private int responsable_idResponsable;   //FK
	   private int tipologia_idTipologia;      //FK
	   private int estadoConservacion_idEstadoConservacion;  //FK
	   
	   
	   
	   
	   public ObjetoVO() {
		   
	   }
		public ObjetoVO(int numeroInventario,String codigoMuseo, Date fechaIngreso, String ubicacion, String procedencia, String propietario,
			String estado, int museo_idmuseo, int coleccion_idcoleccion1, int sala_numeroSala,
			int documentacionFotografica_idDocumentacionFotografica, int estudio_idEstudio,
			int restauracion_idRestauracion, int responsable_idResponsable, int tipologia_idTipologia,
			int estadoConservacion_idEstadoConservacion) {
		
		this.numeroInventario = numeroInventario;
		this.codigoMuseo = codigoMuseo;
		this.fechaIngreso = fechaIngreso;
		this.ubicacion = ubicacion;
		this.procedencia = procedencia;
		this.propietario = propietario;
		this.estado = estado;
		this.museo_idmuseo = museo_idmuseo;
		this.coleccion_idcoleccion1 = coleccion_idcoleccion1;
		this.sala_numeroSala = sala_numeroSala;
		this.documentacionFotografica_idDocumentacionFotografica = documentacionFotografica_idDocumentacionFotografica;
		this.estudio_idEstudio = estudio_idEstudio;
		this.restauracion_idRestauracion = restauracion_idRestauracion;
		this.responsable_idResponsable = responsable_idResponsable;
		this.tipologia_idTipologia = tipologia_idTipologia;
		this.estadoConservacion_idEstadoConservacion = estadoConservacion_idEstadoConservacion;
	    }
		
		
		@Override
		public String toString() {
			return "ObjetoVO [numeroInventario=" + numeroInventario +", codigoMuseo="+ codigoMuseo+ ", fechaIngreso=" + fechaIngreso + ", ubicacion="
					+ ubicacion + ", procedencia=" + procedencia + ", propietario=" + propietario + ", estado=" + estado
					+ ", museo_idmuseo=" + museo_idmuseo + ", coleccion_idcoleccion1=" + coleccion_idcoleccion1
					+ ", sala_numeroSala=" + sala_numeroSala + ", documentacionFotografica_idDocumentacionFotografica="
					+ documentacionFotografica_idDocumentacionFotografica + ", estudio_idEstudio=" + estudio_idEstudio
					+ ", restauracion_idRestauracion=" + restauracion_idRestauracion + ", responsable_idResponsable="
					+ responsable_idResponsable + ", tipologia_idTipologia=" + tipologia_idTipologia
					+ ", estadoConservacion_idEstadoConservacion=" + estadoConservacion_idEstadoConservacion + "]";
		}
		  
		
		
		
		public int getNumeroInventario() {
			return numeroInventario;
		}
		public void setNumeroInventario(int numeroInventario) {
			this.numeroInventario = numeroInventario;
		}
		public Date getFechaIngreso() {
			return fechaIngreso;
		}
		public void setFechaIngreso(Date fechaIngreso) {
			this.fechaIngreso = fechaIngreso;
		}
		public String getUbicacion() {
			return ubicacion;
		}
		public void setUbicacion(String ubicacion) {
			this.ubicacion = ubicacion;
		}
		public String getProcedencia() {
			return procedencia;
		}
		public void setProcedencia(String procedencia) {
			this.procedencia = procedencia;
		}
		public String getPropietario() {
			return propietario;
		}
		public void setPropietario(String propietario) {
			this.propietario = propietario;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public int getMuseo_idmuseo() {
			return museo_idmuseo;
		}
		public void setMuseo_idmuseo(int museo_idmuseo) {
			this.museo_idmuseo = museo_idmuseo;
		}
		public int getColeccion_idcoleccion1() {
			return coleccion_idcoleccion1;
		}
		public void setColeccion_idcoleccion1(int coleccion_idcoleccion1) {
			this.coleccion_idcoleccion1 = coleccion_idcoleccion1;
		}
		public int getSala_numeroSala() {
			return sala_numeroSala;
		}
		public void setSala_numeroSala(int sala_numeroSala) {
			this.sala_numeroSala = sala_numeroSala;
		}
		public int getDocumentacionFotografica_idDocumentacionFotografica() {
			return documentacionFotografica_idDocumentacionFotografica;
		}
		public void setDocumentacionFotografica_idDocumentacionFotografica(
				int documentacionFotografica_idDocumentacionFotografica) {
			this.documentacionFotografica_idDocumentacionFotografica = documentacionFotografica_idDocumentacionFotografica;
		}
		public int getEstudio_idEstudio() {
			return estudio_idEstudio;
		}
		public void setEstudio_idEstudio(int estudio_idEstudio) {
			this.estudio_idEstudio = estudio_idEstudio;
		}
		public int getRestauracion_idRestauracion() {
			return restauracion_idRestauracion;
		}
		public void setRestauracion_idRestauracion(int restauracion_idRestauracion) {
			this.restauracion_idRestauracion = restauracion_idRestauracion;
		}
		public int getResponsable_idResponsable() {
			return responsable_idResponsable;
		}
		public void setResponsable_idResponsable(int responsable_idResponsable) {
			this.responsable_idResponsable = responsable_idResponsable;
		}
		public int getTipologia_idTipologia() {
			return tipologia_idTipologia;
		}
		public void setTipologia_idTipologia(int tipologia_idTipologia) {
			this.tipologia_idTipologia = tipologia_idTipologia;
		}
		public int getEstadoConservacion_idEstadoConservacion() {
			return estadoConservacion_idEstadoConservacion;
		}
		public void setEstadoConservacion_idEstadoConservacion(int estadoConservacion_idEstadoConservacion) {
			this.estadoConservacion_idEstadoConservacion = estadoConservacion_idEstadoConservacion;
		}
		public String getCodigoMuseo() {
			return codigoMuseo;
		}
		public void setCodigoMuseo(String codigoMuseo) {
			this.codigoMuseo = codigoMuseo;
		} 
	   
}
