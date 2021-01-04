package com.florenciazabala.modulos.fichageneral;

import java.awt.Image;

public class DocumentacionFotograficaVO {
   private int idDocumentacionFotografica;
   private Image ImagenDocF;
   private int tipoDoc_idTipoDoc;
   private int objeto_numeroInventario;
   
    public DocumentacionFotograficaVO() {
	   
   }
   
	public DocumentacionFotograficaVO(int idDocumentacionFotografica, Image imagenDocF, int tipoDoc_idTipoDoc, int objeto_numeroInventario) {
	this.idDocumentacionFotografica = idDocumentacionFotografica;
	ImagenDocF = imagenDocF;
	this.tipoDoc_idTipoDoc = tipoDoc_idTipoDoc;
	this.objeto_numeroInventario = objeto_numeroInventario;
    }
	

	@Override
	public String toString() {
		return "DocumentacionFotograficaVO [idDocumentacionFotografica=" + idDocumentacionFotografica + ", ImagenDocF="
				+ ImagenDocF + ", tipoDoc_idTipoDoc=" + tipoDoc_idTipoDoc+", objeto_numeroInventario="+objeto_numeroInventario + "]";
	}
	
	public int getIdDocumentacionFotografica() {
		return idDocumentacionFotografica;
	}
	public void setIdDocumentacionFotografica(int idDocumentacionFotografica) {
		this.idDocumentacionFotografica = idDocumentacionFotografica;
	}
	public Image getImagenDocF() {
		return ImagenDocF;
	}
	public void setImagenDocF(Image imagenDocF) {
		ImagenDocF = imagenDocF;
	}
	public int getTipoDoc_idTipoDoc() {
		return tipoDoc_idTipoDoc;
	}
	public void setTipoDoc_idTipoDoc(int tipoDoc_idTipoDoc) {
		this.tipoDoc_idTipoDoc = tipoDoc_idTipoDoc;
    }

	public int getObjeto_numeroInventario() {
		return objeto_numeroInventario;
	}

	public void setObjeto_numeroInventario(int objeto_numeroInventario) {
		this.objeto_numeroInventario = objeto_numeroInventario;
	}

   
}
