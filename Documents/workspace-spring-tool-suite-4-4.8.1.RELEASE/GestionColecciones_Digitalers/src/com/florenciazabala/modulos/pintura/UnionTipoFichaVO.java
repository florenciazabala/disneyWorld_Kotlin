package com.florenciazabala.modulos.pintura;

public class UnionTipoFichaVO {
	private int tipologia_idTipologia;
	private int examenOrganoleptico_idExamenOrganoleptico;
	private int fichaTecnica_idFichaTecnica;
	
	
	public UnionTipoFichaVO() {
		
	}
	public UnionTipoFichaVO(int tipologia_idTipologia, int examenOrganoleptico_idExamenOrganoleptico,
			int fichaTecnica_idFichaTecnica) {
		this.tipologia_idTipologia = tipologia_idTipologia;
		this.examenOrganoleptico_idExamenOrganoleptico = examenOrganoleptico_idExamenOrganoleptico;
		this.fichaTecnica_idFichaTecnica = fichaTecnica_idFichaTecnica;
	}
	
	@Override
	public String toString() {
		return "UnionTipoFichaVO [tipologia_idTipologia=" + tipologia_idTipologia
				+ ", examenOrganoleptico_idExamenOrganoleptico=" + examenOrganoleptico_idExamenOrganoleptico
				+ ", fichaTecnica_idFichaTecnica=" + fichaTecnica_idFichaTecnica + "]";
	}
	
	
	
	public int getTipologia_idTipologia() {
		return tipologia_idTipologia;
	}
	public void setTipologia_idTipologia(int tipologia_idTipologia) {
		this.tipologia_idTipologia = tipologia_idTipologia;
	}
	public int getExamenOrganoleptico_idExamenOrganoleptico() {
		return examenOrganoleptico_idExamenOrganoleptico;
	}
	public void setExamenOrganoleptico_idExamenOrganoleptico(int examenOrganoleptico_idExamenOrganoleptico) {
		this.examenOrganoleptico_idExamenOrganoleptico = examenOrganoleptico_idExamenOrganoleptico;
	}
	public int getFichaTecnica_idFichaTecnica() {
		return fichaTecnica_idFichaTecnica;
	}
	public void setFichaTecnica_idFichaTecnica(int fichaTecnica_idFichaTecnica) {
		this.fichaTecnica_idFichaTecnica = fichaTecnica_idFichaTecnica;
	}

}
