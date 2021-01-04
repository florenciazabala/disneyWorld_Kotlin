package com.florenciazabala.modulos.fichageneral;

import java.awt.Image;

public class ImagenEstudioVO {
   private int idImagenEstudio;
   private Image imagenEstudio;
   private String nombreImagenE;
   private int 	estudio_idEstudio;
   
    public ImagenEstudioVO() {
	   
    }
    
	public ImagenEstudioVO(int idImagenEstudio, Image imagenEstudio, String nombreImagenE, int 	estudio_idEstudio) {
	this.idImagenEstudio = idImagenEstudio;
	this.imagenEstudio = imagenEstudio;
	this.nombreImagenE = nombreImagenE;
	this.estudio_idEstudio = estudio_idEstudio;
    }
	
	@Override
	public String toString() {
		return "ImagenEstudioVO [idImagenEstudio=" + idImagenEstudio + ", imagenEstudio=" + imagenEstudio
				+ ", nombreImagenE=" + nombreImagenE +", estudio_idEstudio="+estudio_idEstudio+ "]";
	}
   
	
	public int getIdImagenEstudio() {
		return idImagenEstudio;
	}
	public void setIdImagenEstudios(int idImagenEstudio) {
		this.idImagenEstudio = idImagenEstudio;
	}
	public Image getImagenEstudio() {
		return imagenEstudio;
	}
	public void setImagenEstudios(Image imagenEstudios) {
		this.imagenEstudio = imagenEstudio;
	}
	public String getNombreImagenE() {
		return nombreImagenE;
	}
	public void setNombreImagenE(String nombreImagenE) {
		this.nombreImagenE = nombreImagenE;
	}

	public int getEstudio_idEstudio() {
		return estudio_idEstudio;
	}

	public void setEstudio_idEstudio(int estudio_idEstudio) {
		this.estudio_idEstudio = estudio_idEstudio;
	}

   
}
