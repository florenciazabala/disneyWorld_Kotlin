package com.florenciazabala.modulos;

import java.awt.Image;

public class ImagenUsuarioVO {
    private int idImagenUsuario;
    private Image imagenUsuario;
    
    
    public ImagenUsuarioVO() {
    	
    }
	public ImagenUsuarioVO(int idImagenUsuario, Image imagenUsuario) {
		this.idImagenUsuario = idImagenUsuario;
		this.imagenUsuario = imagenUsuario;
	}
	
	@Override
	public String toString() {
		return "ImagenUsuarioVO [idImagenUsuario=" + idImagenUsuario + ", imagenUsuario=" + imagenUsuario + "]";
	}
	
	public int getIdImagenUsuario() {
		return idImagenUsuario;
	}
	public void setIdImagenUsuario(int idImagenUsuario) {
		this.idImagenUsuario = idImagenUsuario;
	}
	public Image getImagenUsuario() {
		return imagenUsuario;
	}
	public void setImagenUsuario(Image imagenUsuario) {
		this.imagenUsuario = imagenUsuario;
	}
	
    
}
