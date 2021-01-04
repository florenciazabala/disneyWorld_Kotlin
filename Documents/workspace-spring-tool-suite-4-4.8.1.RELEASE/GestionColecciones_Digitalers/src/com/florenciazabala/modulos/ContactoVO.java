package com.florenciazabala.modulos;

public class ContactoVO {
       
	   private int idContacto;
	   private String sede;
	   private String mailSede;
	   private String direccionSede;
	   private int telefonoSede;
	   private int museo_idMuseo;
	   
	   
	   
	   public ContactoVO() {
		   
	   }
		public ContactoVO(int idContacto, String sede, String mailSede, String direccionSede, int telefonoSede,
			int museo_idMuseo) {
		this.idContacto = idContacto;
		this.sede = sede;
		this.mailSede = mailSede;
		this.direccionSede = direccionSede;
		this.telefonoSede = telefonoSede;
		this.museo_idMuseo = museo_idMuseo;
	    }
		
		@Override
		public String toString() {
			return "ContactoVO [idContacto=" + idContacto + ", sede=" + sede + ", mailSede=" + mailSede
					+ ", direccionSede=" + direccionSede + ", telefonoSede=" + telefonoSede + ", museo_idMuseo="
					+ museo_idMuseo + "]";
		}
		   
		
		public int getIdContacto() {
			return idContacto;
		}
		public void setIdContacto(int idContacto) {
			this.idContacto = idContacto;
		}
		public String getSede() {
			return sede;
		}
		public void setSede(String sede) {
			this.sede = sede;
		}
		public String getMailSede() {
			return mailSede;
		}
		public void setMailSede(String mailSede) {
			this.mailSede = mailSede;
		}
		public String getDireccionSede() {
			return direccionSede;
		}
		public void setDireccionSede(String direccionSede) {
			this.direccionSede = direccionSede;
		}
		public int getTelefonoSede() {
			return telefonoSede;
		}
		public void setTelefonoSede(int telefonoSede) {
			this.telefonoSede = telefonoSede;
		}
		public int getMuseo_idMuseo() {
			return museo_idMuseo;
		}
		public void setMuseo_idMuseo(int museo_idMuseo) {
			this.museo_idMuseo = museo_idMuseo;
		}
	   
}
