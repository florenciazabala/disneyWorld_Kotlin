package com.florenciazabala.modulos;

public class SalaVO extends MuseoVO{
     private int numeroSala; //PK
     private String nombreSala;
     private int piso;
     private int museo_idmuseo; //FK
     
     public SalaVO() {
 		
 	}
     
	public SalaVO(int numeroSala, String nombreSala, int piso) {
		this.numeroSala= numeroSala;
		this.nombreSala = nombreSala;
		this.piso = piso;
	}

	public SalaVO(int numeroSala, String nombreSala, int piso, int museo_idmuseo) {
		super();
		this.numeroSala = numeroSala;
		this.nombreSala = nombreSala;
		this.piso = piso;
		this.museo_idmuseo = museo_idmuseo;
	}
	
	public SalaVO(int idMuseo, String nombre, String direccion, int telefono, String email, int numeroSala, String nombreSala, int piso, int museo_idmuseo) {
		super(idMuseo, nombre, direccion, telefono, email);
		this.numeroSala = numeroSala;
		this.nombreSala = nombreSala;
		this.piso = piso;
		this.museo_idmuseo = museo_idmuseo;
	}
	
	@Override
	public String toString() {
		return "SalaVO [numeroSala=" + numeroSala + ", nombreSala=" + nombreSala + ", piso=" + piso + ", museo_idmuseo="
				+ museo_idmuseo + "]";
	}

	
	public int getNumeroSala() {
		return numeroSala;
	}
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	public String getNombreSala() {
		return nombreSala;
	}
	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getMuseo_idmuseo() {
		return museo_idmuseo;
	}
	public void setMuseo_idmuseo(int museo_idmuseo) {
		this.museo_idmuseo = museo_idmuseo;
	}

	

     
     
}
