package com.florenciazabala.modulos.pintura;

public class ExamenOrganolepticoVO {
      private int idExamenOrganoleptico;
      private String soporteSA;
      private String materialSA;
      private String tipoMaterialSA;
      private String posicionSA;
      private String dimensionesSA;
      private String observacionesSA;
      private int estadoConsevacionEstrato_idestadoConsevacionEstrato;
      private int capaImprimacion_idCapaImprimacion;
      
      
      public ExamenOrganolepticoVO() {
    	  
      }
		public ExamenOrganolepticoVO(int idExamenOrganoleptico, String soporteSA, String materialSA, String tipoMaterialSA,
			String posicionSA, String dimensionesSA, String observacionesSA,
			int estadoConsevacionEstrato_idestadoConsevacionEstrato, int capaImprimacion_idCapaImprimacion) {
		this.idExamenOrganoleptico = idExamenOrganoleptico;
		this.soporteSA = soporteSA;
		this.materialSA = materialSA;
		this.tipoMaterialSA = tipoMaterialSA;
		this.posicionSA = posicionSA;
		this.dimensionesSA = dimensionesSA;
		this.observacionesSA = observacionesSA;
		this.estadoConsevacionEstrato_idestadoConsevacionEstrato = estadoConsevacionEstrato_idestadoConsevacionEstrato;
		this.capaImprimacion_idCapaImprimacion = capaImprimacion_idCapaImprimacion;
	    }
		
		@Override
		public String toString() {
			return "ExamenOrganolepticoVO [idExamenOrganoleptico=" + idExamenOrganoleptico + ", soporteSA=" + soporteSA
					+ ", materialSA=" + materialSA + ", tipoMaterialSA=" + tipoMaterialSA + ", posicionSA=" + posicionSA
					+ ", dimensionesSA=" + dimensionesSA + ", observacionesSA=" + observacionesSA
					+ ", estadoConsevacionEstrato_idestadoConsevacionEstrato="
					+ estadoConsevacionEstrato_idestadoConsevacionEstrato + ", capaImprimacion_idCapaImprimacion="
					+ capaImprimacion_idCapaImprimacion + "]";
		}
      
      
		
		public int getIdExamenOrganoleptico() {
			return idExamenOrganoleptico;
		}
		public void setIdExamenOrganoleptico(int idExamenOrganoleptico) {
			this.idExamenOrganoleptico = idExamenOrganoleptico;
		}
		public String getSoporteSA() {
			return soporteSA;
		}
		public void setSoporteSA(String soporteSA) {
			this.soporteSA = soporteSA;
		}
		public String getMaterialSA() {
			return materialSA;
		}
		public void setMaterialSA(String materialSA) {
			this.materialSA = materialSA;
		}
		public String getTipoMaterialSA() {
			return tipoMaterialSA;
		}
		public void setTipoMaterialSA(String tipoMaterialSA) {
			this.tipoMaterialSA = tipoMaterialSA;
		}
		public String getPosicionSA() {
			return posicionSA;
		}
		public void setPosicionSA(String posicionSA) {
			this.posicionSA = posicionSA;
		}
		public String getDimensionesSA() {
			return dimensionesSA;
		}
		public void setDimensionesSA(String dimensionesSA) {
			this.dimensionesSA = dimensionesSA;
		}
		public String getObservacionesSA() {
			return observacionesSA;
		}
		public void setObservacionesSA(String observacionesSA) {
			this.observacionesSA = observacionesSA;
		}
		public int getEstadoConsevacionEstrato_idestadoConsevacionEstrato() {
			return estadoConsevacionEstrato_idestadoConsevacionEstrato;
		}
		public void setEstadoConsevacionEstrato_idestadoConsevacionEstrato(
				int estadoConsevacionEstrato_idestadoConsevacionEstrato) {
			this.estadoConsevacionEstrato_idestadoConsevacionEstrato = estadoConsevacionEstrato_idestadoConsevacionEstrato;
		}
		public int getCapaImprimacion_idCapaImprimacion() {
			return capaImprimacion_idCapaImprimacion;
		}
		public void setCapaImprimacion_idCapaImprimacion(int capaImprimacion_idCapaImprimacion) {
			this.capaImprimacion_idCapaImprimacion = capaImprimacion_idCapaImprimacion;
		}
		
}
