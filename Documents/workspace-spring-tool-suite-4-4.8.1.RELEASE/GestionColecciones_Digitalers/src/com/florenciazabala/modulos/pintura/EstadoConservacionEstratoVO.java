package com.florenciazabala.modulos.pintura;

public class EstadoConservacionEstratoVO {
	
       private int idestadoConsevacionEstrato;
       private String estadoEstrato;
       
       
       
       public EstadoConservacionEstratoVO() {
    	   
       }
		public EstadoConservacionEstratoVO(int idestadoConsevacionEstrato, String estadoEstrato) {
		this.idestadoConsevacionEstrato = idestadoConsevacionEstrato;
		this.estadoEstrato = estadoEstrato;
	    }
		
		@Override
		public String toString() {
			return "EstadoConservacionEstratoVO [idestadoConsevacionEstrato=" + idestadoConsevacionEstrato
					+ ", estadoEstrato=" + estadoEstrato + "]";
		}
       
		
		public int getIdestadoConsevacionEstrato() {
			return idestadoConsevacionEstrato;
		}
		public void setIdestadoConsevacionEstrato(int idestadoConsevacionEstrato) {
			this.idestadoConsevacionEstrato = idestadoConsevacionEstrato;
		}
		public String getEstadoEstrato() {
			return estadoEstrato;
		}
		public void setEstadoEstrato(String estadoEstrato) {
			this.estadoEstrato = estadoEstrato;
		}
       
}
