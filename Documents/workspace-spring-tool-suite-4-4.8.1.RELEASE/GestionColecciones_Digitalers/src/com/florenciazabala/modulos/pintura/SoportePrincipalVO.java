package com.florenciazabala.modulos.pintura;

public class SoportePrincipalVO {
       private int idsoportePrincipal;
       private String materialSP;
       private String dimensionesSP;
       private String descripcionSP;
       private int tegumento_idTegumento;
       private int estadoConsevacionEstrato_idestadoConsevacionEstrato;
       private int deterioroEstrato_idDeterioroEstratos;
       private int soportePrincipalM_idSoportePrincipalSPM;
       private int soportePrincipalT_idSoportePrincipalT;
       
       
       public SoportePrincipalVO() {
    	   
       }
		public SoportePrincipalVO(int idsoportePrincipal, String materialSP, String dimensionesSP, String descripcionSP,
			int tegumento_idTegumento, int estadoConsevacionEstrato_idestadoConsevacionEstrato,
			int deterioroEstrato_idDeterioroEstratos, int soportePrincipalM_idSoportePrincipalSPM,
			int soportePrincipalT_idSoportePrincipalT) {
		this.idsoportePrincipal = idsoportePrincipal;
		this.materialSP = materialSP;
		this.dimensionesSP = dimensionesSP;
		this.descripcionSP = descripcionSP;
		this.tegumento_idTegumento = tegumento_idTegumento;
		this.estadoConsevacionEstrato_idestadoConsevacionEstrato = estadoConsevacionEstrato_idestadoConsevacionEstrato;
		this.deterioroEstrato_idDeterioroEstratos = deterioroEstrato_idDeterioroEstratos;
		this.soportePrincipalM_idSoportePrincipalSPM = soportePrincipalM_idSoportePrincipalSPM;
		this.soportePrincipalT_idSoportePrincipalT = soportePrincipalT_idSoportePrincipalT;
	    }
		
		
		@Override
		public String toString() {
			return "SoportePrincipalVO [idsoportePrincipal=" + idsoportePrincipal + ", materialSP=" + materialSP
					+ ", dimensionesSP=" + dimensionesSP + ", descripcionSP=" + descripcionSP
					+ ", tegumento_idTegumento=" + tegumento_idTegumento
					+ ", estadoConsevacionEstrato_idestadoConsevacionEstrato="
					+ estadoConsevacionEstrato_idestadoConsevacionEstrato + ", deterioroEstrato_idDeterioroEstratos="
					+ deterioroEstrato_idDeterioroEstratos + ", soportePrincipalM_idSoportePrincipalSPM="
					+ soportePrincipalM_idSoportePrincipalSPM + ", soportePrincipalT_idSoportePrincipalT="
					+ soportePrincipalT_idSoportePrincipalT + "]";
		}
       
		
		public int getIdsoportePrincipal() {
			return idsoportePrincipal;
		}
		public void setIdsoportePrincipal(int idsoportePrincipal) {
			this.idsoportePrincipal = idsoportePrincipal;
		}
		public String getMaterialSP() {
			return materialSP;
		}
		public void setMaterialSP(String materialSP) {
			this.materialSP = materialSP;
		}
		public String getDimensionesSP() {
			return dimensionesSP;
		}
		public void setDimensionesSP(String dimensionesSP) {
			this.dimensionesSP = dimensionesSP;
		}
		public String getDescripcionSP() {
			return descripcionSP;
		}
		public void setDescripcionSP(String descripcionSP) {
			this.descripcionSP = descripcionSP;
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
		public int getDeterioroEstrato_idDeterioroEstratos() {
			return deterioroEstrato_idDeterioroEstratos;
		}
		public void setDeterioroEstrato_idDeterioroEstratos(int deterioroEstrato_idDeterioroEstratos) {
			this.deterioroEstrato_idDeterioroEstratos = deterioroEstrato_idDeterioroEstratos;
		}
		public int getSoportePrincipalM_idSoportePrincipalSPM() {
			return soportePrincipalM_idSoportePrincipalSPM;
		}
		public void setSoportePrincipalM_idSoportePrincipalSPM(int soportePrincipalM_idSoportePrincipalSPM) {
			this.soportePrincipalM_idSoportePrincipalSPM = soportePrincipalM_idSoportePrincipalSPM;
		}
		public int getSoportePrincipalT_idSoportePrincipalT() {
			return soportePrincipalT_idSoportePrincipalT;
		}
		public void setSoportePrincipalT_idSoportePrincipalT(int soportePrincipalT_idSoportePrincipalT) {
			this.soportePrincipalT_idSoportePrincipalT = soportePrincipalT_idSoportePrincipalT;
		}
		
       
}
