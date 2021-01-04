package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.fichageneral.EstadoConservacionVO;


public class EstadoConservacionDAO {
	//********INSERTAR********************
	public static void inserta(EstadoConservacionVO ec) {
		Connection con= null;
		PreparedStatement st = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "insert into estadoConservacion (estadoConservacion, descripcion) values (?,?)";
			st = con.prepareStatement(sql);
			st.setString(1,ec.getEstadoConservacion());
			st.setString(2, ec.getDescripcion());
			st.execute();
			if (existe(ec.getEstadoConservacion(),ec.getDescripcion()) == true) {
			       System.out.println("El estado de conservación ya se encuentra registrada");
			}else {
				System.out.println("Se registró correctamente el estado de conservación");
			}
			con.commit();//2- Transacción
		}catch(SQLException e) {
			System.out.println("No es posible insertar el estado ");
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
	public static void modifica(EstadoConservacionVO ec) {
		PreparedStatement st = null;
		Connection con = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "update estadoConservacion set idEstadoConservacion=?, estadoConservacion=?, descripcion=? where idEstadoConservacion=?";
			st = con.prepareStatement(sql);
			st.setInt(1,ec.getIdEstadoConservacion());
			st.setString(2,ec.getEstadoConservacion());
			st.setString(3, ec.getDescripcion());
			st.setInt(3,ec.getIdEstadoConservacion());
			st.execute();
			if (existe(ec.getEstadoConservacion(),ec.getDescripcion()) == false) {
			       System.out.println("El estado de conservacion que desea modificar no existe");
			}else {
				System.out.println("Se registró correctamente la tipologia ");
			}
			con.commit();//2- Transacción
		} catch(SQLException e) {
			System.out.println("No es posible modificar los datos del estado ");
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
	public static void elimina(int idEstadoConservacion){
		PreparedStatement st = null;
		Connection con = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "delete from estadoConservacion where idEstadoConservacion=?";
			st = con.prepareStatement(sql);
			st.setInt(1, idEstadoConservacion);
			if (existe(idEstadoConservacion) == false) {
			       System.out.println("El estado de conservación que intenta eliminar no existe");
			}else {
				System.out.println("Los datos se eliminaron correctamente");
			}
			st.execute();
			con.commit();//2- Transacción
		}catch(SQLException e) {
			System.out.println("No es posible eliminar los datos");
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

	//********BUSCAR POR ESTADO Y DESCRIPCION********************
	public static EstadoConservacionVO getEstadoConservacionVO (String busqueda) throws NegocioException, CafeStoreException {
		Connection con = null;
		EstadoConservacionVO ec = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				ec= new EstadoConservacionVO ();
				String sql = "select * from estadoConservacion concat(estadoConservacion, descripcion) like ?";
				st = con.prepareStatement(sql);
				st.setString(1, '%'+ busqueda + '%');
				rs = st.executeQuery();
				
			while (rs.next()) {
				int idEstadoConservacion= rs.getInt("idEstadoConservacion");
				String estadoConservacion = rs.getString("estadoConservacion");
				String descripcion = rs.getString("descripcion");
				ec.setIdEstadoConservacion(idEstadoConservacion);
				ec.setEstadoConservacion(estadoConservacion);
				ec.setDescripcion(descripcion);
				if(existe(ec.getEstadoConservacion(),ec.getDescripcion()) != false) {
					System.out.println("Los datos del estado son: ");
					System.out.println(ec.toString());
				}
				}
			if(existe(ec.getEstadoConservacion(),ec.getDescripcion()) == false) {
				System.out.println("No existe un estado que se corresponda con los datos ingresados");
			}
		
		}catch(SQLException e) {
			System.out.println("No es posible mostrar los datos del usuario ");
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
			return ec;
	}

	
	//********CORROBORAR SI EXISTE POR CODIGO o TIPOLOGIA********************
		public static boolean existe(String estadoConservacion, String descripcion) throws NegocioException, CafeStoreException {
			Connection con = null;
			EstadoConservacionVO ec = null;
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
				String sql = "select * from estadoConservacion where estadoConservacion = ? or descripcion=?";
				st = con.prepareStatement(sql);
				st.setString(1, estadoConservacion);
				st.setString(2, descripcion);
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
		//********CORROBORAR SI EXISTE POR ID********************
		public static boolean existe(int idEstadoConservacion) throws NegocioException, CafeStoreException {
			Connection con = null;
			EstadoConservacionVO ec = null;
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
				String sql = "select * from estadoConservacion where idEstadoConservacion=?";
				st = con.prepareStatement(sql);
				st.setInt(1, idEstadoConservacion);
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
