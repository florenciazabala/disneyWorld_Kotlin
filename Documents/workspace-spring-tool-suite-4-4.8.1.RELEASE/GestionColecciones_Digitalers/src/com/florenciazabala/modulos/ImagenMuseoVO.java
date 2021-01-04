package com.florenciazabala.modulos;

import java.awt.Image;

public class ImagenMuseoVO {
	
       private int idimagenMuseo;
       private Image imagenMuseo;
       private int museo_idMuseo;
       
       
       public ImagenMuseoVO() {
    	   
       }
		public ImagenMuseoVO(int idimagenMuseo, Image imagenMuseo, int museo_idMuseo) {
		this.idimagenMuseo = idimagenMuseo;
		this.imagenMuseo = imagenMuseo;
		this.museo_idMuseo = museo_idMuseo;
	    }
		
		@Override
		public String toString() {
			return "ImagenMuseoVO [idimagenMuseo=" + idimagenMuseo + ", imagenMuseo=" + imagenMuseo + ", museo_idMuseo="
					+ museo_idMuseo + "]";
		}
       
		
		public int getIdimagenMuseo() {
			return idimagenMuseo;
		}
		public void setIdimagenMuseo(int idimagenMuseo) {
			this.idimagenMuseo = idimagenMuseo;
		}
		public Image getImagenMuseo() {
			return imagenMuseo;
		}
		public void setImagenMuseo(Image imagenMuseo) {
			this.imagenMuseo = imagenMuseo;
		}
		public int getMuseo_idMuseo() {
			return museo_idMuseo;
		}
		public void setMuseo_idMuseo(int museo_idMuseo) {
			this.museo_idMuseo = museo_idMuseo;
		}
		
}
