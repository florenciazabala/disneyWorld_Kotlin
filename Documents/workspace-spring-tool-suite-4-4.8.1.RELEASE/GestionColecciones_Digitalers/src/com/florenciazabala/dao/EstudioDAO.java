package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.ColeccionVO;
import com.florenciazabala.modulos.fichageneral.EstudioVO;

public class EstudioDAO {
	//********INSERTAR********************
	public static void inserta(EstudioVO e) {
		Connection con= null;
		PreparedStatement st = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "insert into estudio (tipoEstudio, descripcionEstudio, objeto_numeroInventario) values (?,?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, e.getTipoEstudio() );
			st.setString(2, e.getDescripcionEstudio() );
			st.setInt(3, e.getObjeto_numeroInventario());
			st.execute();
			if (existe(e.getIdEstudio()) == true) {
			       System.out.println("El estudio ya se encuentra registrado");
			}else {
				System.out.println("Se registró correctamente el estudio "+e.getTipoEstudio());
			}
			con.commit();//2- Transacción
		}catch(SQLException ex) {
			System.out.println("No es posible insertar al estudio" );
			System.out.println(ex.getMessage());
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
		}catch (Exception ex) {
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
		}catch (SQLException ex) {
			System.out.println("Algo sucedió"+ex.getMessage());
		}

		}
	}
	//********MODIFICAR********************
	public static void modifica(EstudioVO e) {
		PreparedStatement st = null;
		Connection con = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "update estudio set idEstudio=?, tipoEstudio=?, descripcionEstudio =?  where idEstudio=?";
			st = con.prepareStatement(sql);
			st.setString(1, e.getTipoEstudio() );
			st.setString(2, e.getDescripcionEstudio() );
			st.setInt(3, e.getObjeto_numeroInventario());
			st.execute();
			if (existe(e.getIdEstudio()) == false) {
			       System.out.println("El estudio que intenta modificar no existe");
			}else {
				System.out.println("Se actualizaron correctamente los datos del estudio "+e.getTipoEstudio());
			}
			con.commit();//2- Transacción
		} catch(SQLException ex) {
			System.out.println("No es posible modificar los datos del estudio "+e.getTipoEstudio());
			System.out.println(ex.getMessage());
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
		}catch (Exception ex) {
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
			}catch (SQLException ex) {
				System.out.println("Algo sucedió"+ex.getMessage());
			}

			}
	}
	
	//********ELIMINAR POR ID********************
	public static void elimina(int codigo){
		PreparedStatement st = null;
		Connection con = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "delete from estudio where idEstudio=?";
			st = con.prepareStatement(sql);
			st.setInt(1, codigo);
			if (existe(codigo) == false) {
			       System.out.println("El estudio no existe");
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

	//********BUSCAR POR tipoEstudio********************
	public static EstudioVO getEstudioVO (String tipoEstudio) throws NegocioException, CafeStoreException {
		Connection con = null;
		EstudioVO e = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				e= new EstudioVO ();
				String sql = "select * from estudio where tipoEstudio like  ? ";
				st = con.prepareStatement(sql);
				st.setString(1, '%'+ tipoEstudio + '%');
				rs = st.executeQuery();
				
			while (rs.next()) {
				int idEstudio = rs.getInt("idEstudio");
				String tipoE = rs.getString("tipoEstudio");
				String descripcionEstudio = rs.getString("descripcionEstudio");
				int objeto_numeroInventario = rs.getInt("objeto_numeroInventario ");
				e.setIdEstudio(idEstudio);
				e.setTipoEstudio(tipoE);
				e.setDescripcionEstudio(descripcionEstudio);
				e.setObjeto_numeroInventario(objeto_numeroInventario);
				if(existe(e.getIdEstudio()) == true) {
					System.out.println("Los datos del estudio son: ");
					System.out.println(e.toString());
				}
				}
			if(existe(e.getIdEstudio()) == false) {
				System.out.println("No existe un estudio que se corresponda con los datos ingresados");
			}
		
		}catch(SQLException ex) {
			System.out.println("No es posible mostrar los datos del estudio "+ e.getTipoEstudio());
			System.out.println(ex.getMessage());
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
		}catch (Exception ex) {
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
			}catch (SQLException ex) {
				System.out.println("Algo sucedió"+ex.getMessage());
			}

			}
			return e;
	}

	//********BUSCAR POR CODIGO********************
	public static EstudioVO getEstudioVO (int idEstudio) throws NegocioException, CafeStoreException {
		Connection con = null;
		EstudioVO e = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				e= new EstudioVO ();
				String sql = "select * from estudio where idEstudio like  ? ";
				st = con.prepareStatement(sql);
				st.setInt(1, '%'+ idEstudio + '%');
				rs = st.executeQuery();
				
			while (rs.next()) {
				int idE = rs.getInt("idEstudio");
				String tipoE = rs.getString("tipoEstudio");
				String descripcionEstudio = rs.getString("descripcionEstudio");
				int objeto_numeroInventario = rs.getInt("objeto_numeroInventario ");
				e.setIdEstudio(idE);
				e.setTipoEstudio(tipoE);
				e.setDescripcionEstudio(descripcionEstudio);
				e.setObjeto_numeroInventario(objeto_numeroInventario);
				if(existe(e.getIdEstudio()) == true) {
					System.out.println("Los datos del estudio son: ");
					System.out.println(e.toString());
				}
				}
			if(existe(e.getIdEstudio()) == false) {
				System.out.println("No existe un estudio que se corresponda con los datos ingresados");
			}
		
		}catch(SQLException ex) {
			System.out.println("No es posible mostrar los datos del estudio "+ e.getTipoEstudio());
			System.out.println(ex.getMessage());
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
		}catch (Exception ex) {
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
			}catch (SQLException ex) {
				System.out.println("Algo sucedió"+ex.getMessage());
			}

			}
			return e;
	}
	
	//********BUSQUEDA GENERAL********************
	public static EstudioVO getEstudioVOg (String busqueda) throws NegocioException, CafeStoreException {
		Connection con = null;
	    EstudioVO e = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		boolean existe = false;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				e= new EstudioVO ();
				String sql = "select * from estudio where concat (tipoEstudio, descripcionEstudio) like  ? ";
				st = con.prepareStatement(sql);
				st.setString(1,'%'+ busqueda +'%');
				rs = st.executeQuery();
				
			while (rs.next()) {
				int idE = rs.getInt("idEstudio");
				String tipoE = rs.getString("tipoEstudio");
				String descripcionEstudio = rs.getString("descripcionEstudio");
				int objeto_numeroInventario = rs.getInt("objeto_numeroInventario ");
				e.setIdEstudio(idE);
				e.setTipoEstudio(tipoE);
				e.setDescripcionEstudio(descripcionEstudio);
				e.setObjeto_numeroInventario(objeto_numeroInventario);
				if(existe(e.getIdEstudio()) == true) {
					System.out.println("Los datos del estudio son: ");
					System.out.println(e.toString());
				}
				}
			if(existe(e.getIdEstudio()) == false) {
				System.out.println("No existe un estudio que se corresponda con los datos ingresados");
			}
		
		}catch(SQLException ex) {
			System.out.println("No es posible mostrar los datos del estudio ");
			System.out.println(ex.getMessage());
			try {
				con.rollback(); //3- roll back
				System.out.println("Preparando y ejecutando el roll back");
			}catch(SQLException er) {
				System.out.println("No puedo deshacer el roll"+er.getMessage());
			}
		}catch (Exception ex) {
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
			}catch (SQLException ex) {
				System.out.println("Algo sucedió"+ex.getMessage());
			}

			}
			return e;
	}
	
	
	
	
	//********CORROBORAR SI EXISTE POR ID********************
	public static boolean existe(int codigo) throws NegocioException, CafeStoreException {
		Connection con = null;
		EstudioVO e = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		boolean respuesta = false;
		try {
			try {
				con =  Conexion.getConnection();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new CafeStoreException();
			}
			String sql = "select * from estudio where idEstudio  = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, codigo);
			rs = st.executeQuery();
			if (rs.next()) {
				respuesta = true;
			} 
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();

			}

		}
		return respuesta;
	}
	
}
