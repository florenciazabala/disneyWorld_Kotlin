package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.fichageneral.TipoDocVO;


public class TipoDocDAO {
	//********INSERTAR********************
	public static void inserta(TipoDocVO td) {
		Connection con= null;
		PreparedStatement st = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "insert into tipoDoc (tipoDoc) values (?)";
			st = con.prepareStatement(sql);
			st.setString(1, td.getTipoDoc());
			st.execute();
			if (existe(td.getTipoDoc()) == true) {
			       System.out.println("El tipo de documento ya se encuentra registrado");
			}else {
				System.out.println("Se registró correctamente el tipo de documentacion");
			}
			con.commit();//2- Transacción
		}catch(SQLException e) {
			System.out.println("No es posible insertar al tipo de docuemnto "+td.getTipoDoc() );
			System.out.println(e.getMessage());
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
		}catch (Exception e) {
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
			
		} finally {
		System.out.println("Cerrando conexion");
		try {
			if(st!=null) {
				st.close();
			}
			
			if(con!=null) {
				con.close();
			}
		}catch (SQLException e) {
			System.out.println("Algo sucedió"+e.getMessage());
		}

		}
	}
	//********MODIFICAR********************
	public static void modifica(TipoDocVO td) {
		PreparedStatement st = null;
		Connection con = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "update tipoDoc set idCodigo= ?, tipoDoc=? where idTipoDoc=?";
			st = con.prepareStatement(sql);
			st.setInt(1, td.getIdTipoDoc());
			st.setString(2, td.getTipoDoc());
			st.setInt(4, td.getIdTipoDoc());
			st.execute();
			if (existe(td.getIdTipoDoc()) == false) {
			       System.out.println("La tpo de documento que intenta modificar no existe");
			}else {
				System.out.println("Se actualizaron correctamente los datos del documento "+td.getTipoDoc());
			}
			con.commit();//2- Transacción
		} catch(SQLException e) {
			System.out.println("No es posible modificar los datos del tipo de docuemnto "+td.getTipoDoc());
			System.out.println(e.getMessage());
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
		}catch (Exception e) {
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
			
		} finally {
			System.out.println("Cerrando conexion");
			try {
				if(st!=null) {
					st.close();
				}
				
				if(con!=null) {
					con.close();
				}
			}catch (SQLException e) {
				System.out.println("Algo sucedió"+e.getMessage());
			}

			}
	}
	
	//********ELIMINAR POR ID********************
	public static void elimina(int i){
		PreparedStatement st = null;
		Connection con = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "delete from tipoDoc where idTipoDoc=?";
			st = con.prepareStatement(sql);
			st.setInt(1, i);
			if (existe(i) == false) {
			       System.out.println("El tipo de documento que desea eliminar no existe");
			}else {
				System.out.println("Los datos se eliminaron correctamente");
			}
			st.execute();
			con.commit();//2- Transacción
		}catch(SQLException e) {
			System.out.println("No es posible modificar los datos");
			System.out.println(e.getMessage());
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
		}catch (Exception e) {
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
			
		} finally {
			System.out.println("Cerrando conexion");
			try {
				if(st!=null) {
					st.close();
				}
				
				if(con!=null) {
					con.close();
				}
			}catch (SQLException e) {
				System.out.println("Algo sucedió"+e.getMessage());
			}

			}
	}

	//********BUSCAR POR ID********************
	public static TipoDocVO getTipoDocVO (int idTipoDoc) throws NegocioException, CafeStoreException {
		Connection con = null;
		TipoDocVO td = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		boolean existe = false;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				td= new TipoDocVO ();
				String sql = "select * from tipoDoc where idTipoDoc like  ? ";
				st = con.prepareStatement(sql);
				st.setInt(1, '%'+ idTipoDoc + '%');
				rs = st.executeQuery();
				
			while (rs.next()) {
				existe=true;
				int id = rs.getInt("idTipoDoc");
				String tipoDoc = rs.getString("tipoDoc");
				td.setIdTipoDoc(id);
				td.setTipoDoc(tipoDoc);
				if(existe(td.getIdTipoDoc()) != false) {
					System.out.println("Los datos del tipo de documento son: ");
					System.out.println(td.toString());
				}
				}
			if(existe(td.getIdTipoDoc()) == false) {
				System.out.println("No existe un tipo de documento que se corresponda con los datos ingresados");
			}
		
		}catch(SQLException e) {
			System.out.println("No es posible mostrar los datos del tipo de documento ");
			System.out.println(e.getMessage());
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
		}catch (Exception e) {
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
			
		} finally {
			System.out.println("Cerrando conexion");
			try {
				if(st!=null) {
					st.close();
				}
				if(rs!=null) {
					rs.close();
				}
				
				if(con!=null) {
					con.close();
				}
			}catch (SQLException e) {
				System.out.println("Algo sucedió"+e.getMessage());
			}

			}
			return td;
	}

	//********BUSCAR POR TIPO DOC********************
	public static TipoDocVO getTipoDocVO (String tipoDoc) throws NegocioException, CafeStoreException {
		Connection con = null;
		TipoDocVO td = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		boolean existe = false;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				td= new TipoDocVO ();
				String sql = "select * from tipoDoc where tipoDoc like  ? ";
				st = con.prepareStatement(sql);
				st.setString(1, '%'+ tipoDoc + '%');
				rs = st.executeQuery();
				
			while (rs.next()) {
				existe=true;
				int id = rs.getInt("idTipoDoc");
				String tipo = rs.getString("tipoDoc");
				td.setIdTipoDoc(id);
				td.setTipoDoc(tipo);
				if(existe(td.getIdTipoDoc()) != false) {
					System.out.println("Los datos del tipo de documento son: ");
					System.out.println(td.toString());
				}
				}
			if(existe(td.getIdTipoDoc()) == false) {
				System.out.println("No existe un tipo de documento que se corresponda con los datos ingresados");
			}
		
		}catch(SQLException e) {
			System.out.println("No es posible mostrar los datos del tipo de documento ");
			System.out.println(e.getMessage());
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
		}catch (Exception e) {
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
			
		} finally {
			System.out.println("Cerrando conexion");
			try {
				if(st!=null) {
					st.close();
				}
				if(rs!=null) {
					rs.close();
				}
				
				if(con!=null) {
					con.close();
				}
			}catch (SQLException e) {
				System.out.println("Algo sucedió"+e.getMessage());
			}

			}
			return td;
	}
	
	
	
	
	//********CORROBORAR SI EXISTE POR ID********************
	public static boolean existe(int codigo) throws NegocioException, CafeStoreException {
		Connection con = null;
		TipoDocVO td = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		boolean respuesta = false;
		try {
			try {
				con =  Conexion.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
				throw new CafeStoreException();
			}
			String sql = "select * from tipoDoc where idTipoDoc  = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, codigo);
			rs = st.executeQuery();
			if (rs.next()) {
				respuesta = true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
		return respuesta;
	}
	
	//********CORROBORAR SI EXISTE POR tipodoc********************
		public static boolean existe(String tipoDoc) throws NegocioException, CafeStoreException {
			Connection con = null;
			TipoDocVO td = null;
			ResultSet rs = null;
			PreparedStatement st = null;
			boolean respuesta = false;
			try {
				try {
					con =  Conexion.getConnection();
				} catch (Exception e) {
					e.printStackTrace();
					throw new CafeStoreException();
				}
				String sql = "select * from tipoDoc where tipoDoc  = ?";
				st = con.prepareStatement(sql);
				st.setString(1, tipoDoc);
				rs = st.executeQuery();
				if (rs.next()) {
					respuesta = true;
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					st.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}

			}
			return respuesta;
		}
		
}
