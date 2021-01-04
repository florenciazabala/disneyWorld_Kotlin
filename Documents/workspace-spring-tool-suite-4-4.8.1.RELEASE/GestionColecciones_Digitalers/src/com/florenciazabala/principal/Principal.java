package com.florenciazabala.principal;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.dao.ColeccionDAO;
import com.florenciazabala.dao.DocumentacionFotograficaDAO;
import com.florenciazabala.dao.MuseoDAO;
import com.florenciazabala.dao.SalaDAO;
import com.florenciazabala.dao.TipoDocDAO;
import com.florenciazabala.dao.inners.Inner;
import com.florenciazabala.dao.inners.Inner2;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.ColeccionVO;
import com.florenciazabala.modulos.MuseoVO;
import com.florenciazabala.modulos.SalaVO;
import com.florenciazabala.modulos.fichageneral.DocumentacionFotograficaVO;
import com.florenciazabala.modulos.fichageneral.EstudioVO;
import com.florenciazabala.modulos.fichageneral.TipoDocVO;
import com.florenciazabala.dao.MuseoDAO;
import com.florenciazabala.*;

public class Principal {

	
	public static void main(String[] args) throws NegocioException, CafeStoreException, IOException {
		
        //Conexion conn = new Conexion(); //-->Prueba conexión a la base
	    
		//******INSERTAR*********
//		MuseoVO m = new MuseoVO (0,"Museo Benito Quinquela Martín","Av. Don Pedro de Mendoza 1835",43011080,"museoquinquelamartin@buenosaires.gob.ar");
//		MuseoDAO mm= new MuseoDAO();
//		mm.inserta(m);
//		
		//******MODIFICAR*********
//		MuseoVO m = new MuseoVO (0,"Museo Bellas Artes","Av. del Libertador",4257744,"museobellasartes@gmail.com");
//		m.setIdMuseo(2);
//		MuseoDAO mm= new MuseoDAO();
//		mm.modifica(m);
		
		//******ELIMINAR*********
//		MuseoDAO mm= new MuseoDAO();
//		mm.elimina(10);
		
		//******BUSCAR*********
//		MuseoVO m = new MuseoVO ();
//		MuseoDAO mm= new MuseoDAO();
//		m= MuseoDAO.getMuseoVO(4);
		
		
//		if(m.getNombre() != null) {
//			System.out.println("Datos del registro solicitado: ");
//			System.out.println(m.toString());
//			} else {
//				System.out.println("Museo no encontrado");
//			}
		
		//o
		
		
		
//		MuseoVO m = new MuseoVO ();
//     	MuseoDAO mm= new MuseoDAO();
//    	m= MuseoDAO.getMuseoVO("kjdff");
		
//		
//		SalaVO s = new SalaVO (4,"Sala numismática",1,3);
//		s.setNumeroSala(22);
//		s.setMuseo_idmuseo(2);
//		SalaDAO ss= new SalaDAO();
//		ss.inserta(s);
//		SalaDAO.modifica(s);
//		ss.unir();
		
//		java.sql.Date date = new java.sql.Date(2020, 7, 20);
//		ColeccionVO c = new ColeccionVO(0, "MDLP0004", "Coleccion Juan Manuel de Rosas", date, "Coleccion de obras del período rosista");
//		ColeccionDAO.modifica(c);
		
//		DocumentacionFotograficaDAO df = new DocumentacionFotograficaDAO ();
//		df.modifica("C:\\Users\\test\\Pictures\\berni2.jpg", 1, 1);
		
//		EstudioVO e =new EstudioVO(1, null, null, 0);
		
		
		
//		LOGEO!!!!!
//		Inner i = new Inner ();
//	    i.existeUsuario("roo", "1234");
//		i.mostrarUsuario();
		
		Inner2 i2 = new Inner2 ();
		Inner2.existeUsuario("roo", "1111");
		Inner2.mostrarUsuario();
		Inner2.mostrarMuseo();
	}

}
