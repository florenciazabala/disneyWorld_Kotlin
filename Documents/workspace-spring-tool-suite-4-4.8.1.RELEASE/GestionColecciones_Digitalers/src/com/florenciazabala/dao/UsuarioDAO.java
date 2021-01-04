package com.florenciazabala.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.UsuarioVO;

import java.sql.PreparedStatement;


public class UsuarioDAO {
	
	//********INSERTAR********************
	public static void inserta(UsuarioVO u) {
		Connection con= null;
		PreparedStatement st = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "insert into usuario (idUsuario, nombreUsuario,apellido,dni,fechaNacimiento,cargo,mailUsuario,direccionUsuario,telefonoUsuario,museo_idmuseo,	login_idLogin,	imagenUsuario_idImagenUsuario)"
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, u.getIdUsuario());
			st.setString(2, u.getNombreUsuario());
			st.setString(3, u.getApellido());
			st.setInt(4, u.getDni());
			st.setDate(5, u.getFechaNacimiento());
			st.setString(6, u.getCargo());
			st.setString(7, u.getMailUsuario());
			st.setString(8, u.getDireccionUsuario());
			st.setInt(9, u.getTelefonoUsuario());
			st.setInt(10, u.getMuseo_idmuseo());
			st.setInt(11, u.getLogin_idLogin());
			st.setInt(12, u.getImagenUsuario_idImagenUsuario());
			st.execute();
			if (existe(u.getDni(),u.getMailUsuario()) == true) {
			       System.out.println("el usuario ya se encuentra registrado");
			}else {
				System.out.println("Se registró correctamente al usuario "+u.getNombreUsuario()+u.getApellido());
			}
			con.commit();//2- Transacción
		}catch(SQLException e) {
			System.out.println("No es posible insertar al usuario "+u.getNombreUsuario()+u.getApellido());
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
	public static void modifica(UsuarioVO u) {
		PreparedStatement st = null;
		Connection con = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "update usuario set idUsuario=?, nombreUsuario=?,apellido=?,dni=?,fechaNacimiento=?,cargo=?,mailUsuario=?,direccionUsuario=?,telefonoUsuario=?,museo_idmuseo=?,login_idLogin=?,imagenUsuario_idImagenUsuario=? where idUsuario=?";
			st = con.prepareStatement(sql);
			st.setInt(1, u.getIdUsuario());
			st.setString(2, u.getNombreUsuario());
			st.setString(3, u.getApellido());
			st.setInt(4, u.getDni());
			st.setDate(5, u.getFechaNacimiento());
			st.setString(6, u.getCargo());
			st.setString(7, u.getMailUsuario());
			st.setString(8, u.getDireccionUsuario());
			st.setInt(9, u.getTelefonoUsuario());
			st.setInt(10, u.getMuseo_idmuseo());
			st.setInt(11, u.getLogin_idLogin());
			st.setInt(12, u.getImagenUsuario_idImagenUsuario());
			st.setInt(13, u.getIdUsuario());
			st.execute();
			if (existe(u.getIdUsuario()) == false) {
			       System.out.println("el usuario que intenta modificar no existe");
			}else {
				System.out.println("Se actualizaron correctamente los datos del usuario "+u.getNombreUsuario()+u.getApellido());
			}
			con.commit();//2- Transacción
		} catch(SQLException e) {
			System.out.println("No es posible modificar los datos del usuario "+u.getNombreUsuario()+u.getApellido() );
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
	public static void elimina(int idUsuario){
		PreparedStatement st = null;
		Connection con = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "delete from usuario where idUsuario=?";
			st = con.prepareStatement(sql);
			st.setInt(1, idUsuario);
			if (existe(idUsuario) == false) {
			       System.out.println("El usuario no existe");
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

	//********BUSCAR POR nombre y apellido********************
	public static UsuarioVO getLoginVO (String nombreUsuario, String apellido) throws NegocioException, CafeStoreException {
		Connection con = null;
		UsuarioVO u = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		boolean existe = false;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				u= new UsuarioVO ();
				String sql = "select * from usuario where nombreUsuario like  ? or apellido like ?";
				st = con.prepareStatement(sql);
				st.setString(1, '%'+ nombreUsuario + '%');
				st.setString(1, '%'+ apellido + '%');
				rs = st.executeQuery();
				
			while (rs.next()) {
				existe=true;
				int idUsuario = rs.getInt("idUsuario");
				String nombreU = rs.getString("nombreUsuario");
				String apell = rs.getString("apellido");
				int dni = rs.getInt("dni");
				Date fechaNacimiento = rs.getDate("fechaNacimiento");
				String cargo = rs.getString("cargo");
				String mailUsuario = rs.getString("mailUsuario");
				String direccionUsuario = rs.getString("direccionUsuario");
				int telefonoUsuario = rs.getInt("telefonoUsuario");
				int museo_idmuseo = rs.getInt("museo_idmuseo");
				int login_idLogin = rs.getInt("login_idLogin");
				int imagenUsuario_idImagenUsuario = rs.getInt("imagenUsuario_idImagenUsuario");
				u.setIdUsuario(idUsuario);
				u.setNombreUsuario(nombreU);
				u.setApellido(apell);
				u.setDni(dni);
				u.setFechaNacimiento(fechaNacimiento);
				u.setCargo(cargo);
				u.setMailUsuario(mailUsuario);
				u.setDireccionUsuario(direccionUsuario);
				u.setTelefonoUsuario(telefonoUsuario);
				u.setMuseo_idmuseo(museo_idmuseo);
				u.setLogin_idLogin(login_idLogin);
				u.setImagenUsuario_idImagenUsuario(imagenUsuario_idImagenUsuario);
				if(existe(u.getIdUsuario()) != false) {
					System.out.println("Los datos del usuario son: ");
					System.out.println(u.toString());
				}
				}
			if(existe(u.getIdUsuario()) == false) {
				System.out.println("No existe un usuario que se corresponda con los datos ingresados");
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
			return u;
	}

	//********BUSCAR POR ID********************
	
	public static UsuarioVO getLoginVO (int idUsuario) throws NegocioException, CafeStoreException {
		Connection con = null;
		UsuarioVO u = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		boolean existe = false;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				u= new UsuarioVO ();
				String sql = "select * from usuario where idUsuario like  ? ";
				st = con.prepareStatement(sql);
				st.setInt(1, '%'+ idUsuario + '%');
				rs = st.executeQuery();
				
			while (rs.next()) {
				existe=true;
				int idUs = rs.getInt("idUsuario");
				String nombreU = rs.getString("nombreUsuario");
				String apell = rs.getString("apellido");
				int dni = rs.getInt("dni");
				Date fechaNacimiento = rs.getDate("fechaNacimiento");
				String cargo = rs.getString("cargo");
				String mailUsuario = rs.getString("mailUsuario");
				String direccionUsuario = rs.getString("direccionUsuario");
				int telefonoUsuario = rs.getInt("telefonoUsuario");
				int museo_idmuseo = rs.getInt("museo_idmuseo");
				int login_idLogin = rs.getInt("login_idLogin");
				int imagenUsuario_idImagenUsuario = rs.getInt("imagenUsuario_idImagenUsuario");
				u.setIdUsuario(idUs);
				u.setNombreUsuario(nombreU);
				u.setApellido(apell);
				u.setDni(dni);
				u.setFechaNacimiento(fechaNacimiento);
				u.setCargo(cargo);
				u.setMailUsuario(mailUsuario);
				u.setDireccionUsuario(direccionUsuario);
				u.setTelefonoUsuario(telefonoUsuario);
				u.setMuseo_idmuseo(museo_idmuseo);
				u.setLogin_idLogin(login_idLogin);
				u.setImagenUsuario_idImagenUsuario(imagenUsuario_idImagenUsuario);
				if(existe(u.getIdUsuario()) != false) {
					System.out.println("Los datos del usuario son: ");
					System.out.println(u.toString());
				}
				}
			if(existe(u.getIdUsuario()) == false) {
				System.out.println("No existe un usuario que se corresponda con los datos ingresados");
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
			return u;
	}
	
	//********BUSQUEDA GENERAL********************
	
	public static UsuarioVO getLoginVOg (String busqueda) throws NegocioException, CafeStoreException {
		Connection con = null;
		UsuarioVO u = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				u= new UsuarioVO ();
				String sql = "select * from usuario concat (idUsuario, nombreUsuario,apellido,dni,fechaNacimiento,cargo,mailUsuario,direccionUsuario,telefonoUsuario,museo_idmuseo,	login_idLogin,	imagenUsuario_idImagenUsuario) like  ? ";
				st = con.prepareStatement(sql);
				st.setString(1,'%'+ busqueda +'%');
				rs = st.executeQuery();
				
			while (rs.next()) {
				int idUs = rs.getInt("idUsuario");
				String nombreU = rs.getString("nombreUsuario");
				String apell = rs.getString("apellido");
				int dni = rs.getInt("dni");
				Date fechaNacimiento = rs.getDate("fechaNacimiento");
				String cargo = rs.getString("cargo");
				String mailUsuario = rs.getString("mailUsuario");
				String direccionUsuario = rs.getString("direccionUsuario");
				int telefonoUsuario = rs.getInt("telefonoUsuario");
				int museo_idmuseo = rs.getInt("museo_idmuseo");
				int login_idLogin = rs.getInt("login_idLogin");
				int imagenUsuario_idImagenUsuario = rs.getInt("imagenUsuario_idImagenUsuario");
				u.setIdUsuario(idUs);
				u.setNombreUsuario(nombreU);
				u.setApellido(apell);
				u.setDni(dni);
				u.setFechaNacimiento(fechaNacimiento);
				u.setCargo(cargo);
				u.setMailUsuario(mailUsuario);
				u.setDireccionUsuario(direccionUsuario);
				u.setTelefonoUsuario(telefonoUsuario);
				u.setMuseo_idmuseo(museo_idmuseo);
				u.setLogin_idLogin(login_idLogin);
				u.setImagenUsuario_idImagenUsuario(imagenUsuario_idImagenUsuario);
				if(existe(u.getIdUsuario()) != false) {
					System.out.println("Los datos del usuario son: ");
					System.out.println(u.toString());
				}
				}
			if(existe(u.getIdUsuario()) == false) {
				System.out.println("No existe un usuario que se corresponda con los datos ingresados");
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
			return u;
	}
			
	
	//********CORROBORAR SI EXISTE POR Dni o mail********************
	public static boolean existe(int dni, String mail) throws NegocioException, CafeStoreException {
		Connection con = null;
		UsuarioVO u = null;
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
			String sql = "select * from usuario where dni  = ? OR mailUsuario=?";
			st = con.prepareStatement(sql);
			st.setInt(1, dni);
			st.setString(2, mail);
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
		public static boolean existe(int idUsuario) throws NegocioException, CafeStoreException {
			Connection con = null;
			UsuarioVO u = null;
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
				String sql = "select * from usuario where idUsuario  = ?";
				st = con.prepareStatement(sql);
				st.setInt(1, idUsuario);
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
