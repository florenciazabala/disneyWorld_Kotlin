package com.florenciazabala.modulos.pintura;

public class SoportePrincipalMVO {
    private int idSoportePrincipalSPM;
    public String tipoMaedraSPM;
    public String corteSPM;
    public int cantidadPanelesSPM;
    public String unionSPM;
    
    
    public SoportePrincipalMVO() {
    	
    }
	public SoportePrincipalMVO(int idSoportePrincipalSPM, String tipoMaedraSPM, String corteSPM, int cantidadPanelesSPM,
			String unionSPM) {
		this.idSoportePrincipalSPM = idSoportePrincipalSPM;
		this.tipoMaedraSPM = tipoMaedraSPM;
		this.corteSPM = corteSPM;
		this.cantidadPanelesSPM = cantidadPanelesSPM;
		this.unionSPM = unionSPM;
	}
	
	
	@Override
	public String toString() {
		return "SoportePrincipalMVO [idSoportePrincipalSPM=" + idSoportePrincipalSPM + ", tipoMaedraSPM="
				+ tipoMaedraSPM + ", corteSPM=" + corteSPM + ", cantidadPanelesSPM=" + cantidadPanelesSPM
				+ ", unionSPM=" + unionSPM + "]";
	}
    
    
	
	public int getIdSoportePrincipalSPM() {
		return idSoportePrincipalSPM;
	}
	public void setIdSoportePrincipalSPM(int idSoportePrincipalSPM) {
		this.idSoportePrincipalSPM = idSoportePrincipalSPM;
	}
	public String getTipoMaedraSPM() {
		return tipoMaedraSPM;
	}
	public void setTipoMaedraSPM(String tipoMaedraSPM) {
		this.tipoMaedraSPM = tipoMaedraSPM;
	}
	public String getCorteSPM() {
		return corteSPM;
	}
	public void setCorteSPM(String corteSPM) {
		this.corteSPM = corteSPM;
	}
	public int getCantidadPanelesSPM() {
		return cantidadPanelesSPM;
	}
	public void setCantidadPanelesSPM(int cantidadPanelesSPM) {
		this.cantidadPanelesSPM = cantidadPanelesSPM;
	}
	public String getUnionSPM() {
		return unionSPM;
	}
	public void setUnionSPM(String unionSPM) {
		this.unionSPM = unionSPM;
	}
	
    
}
