package com.florenciazabala.modulos;

public class MuseoVO {
	
 //Atributos
  private static int idMuseo;
  private static String nombre;
  private String direccion;         //Crear clase dirección? clase contacto para usuarios y museo??
  private int telefono;
  private String email;
  
     //Constructor
   public MuseoVO() {
		
	}

	public MuseoVO(int idMuseo, String nombre, String direccion, int telefono, String email) {
		super();
		this.idMuseo = idMuseo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	
	
	
	@Override
	public String toString() {
		return "MuseoVO [idMuseo=" + idMuseo + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", email=" + email + "]";
	}
	  
  
	//Getters & Setters
	public static int getIdMuseo() {
			return idMuseo;
		}
	
	public void setIdMuseo(int idMuseo) {
		this.idMuseo = idMuseo;
	}
	public static String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

  
}
