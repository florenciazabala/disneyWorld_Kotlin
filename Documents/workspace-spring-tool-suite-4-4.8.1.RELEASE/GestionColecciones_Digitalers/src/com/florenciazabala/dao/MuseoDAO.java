package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.MuseoVO;


public class MuseoDAO {
	
	//********INSERTAR********************
	public static void inserta(MuseoVO m) {
		Connection con= null;
		PreparedStatement st = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "insert into museo (nombre, direccion,telefono,email) values (?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, m.getNombre());
			st.setString(2, m.getDireccion());
			st.setInt(3, m.getTelefono());
			st.setString(4, m.getEmail());
			st.execute();
			if (existe(m.getNombre()) == true) {
			       System.out.println("El museo ya se encuentra registrado");
			}else {
				System.out.println("Se registró correctamente al "+m.getNombre());
			}
			con.commit();//2- Transacción
		}catch(SQLException e) {
			System.out.println("No es posible insertar a "+ m.getNombre());
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
	public static void modifica(MuseoVO m) {
		PreparedStatement st = null;
		Connection con = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "update museo set nombre = ?, direccion = ?, telefono=?, email=? where idMuseo = ?";
			st = con.prepareStatement(sql);
			st.setString(1, m.getNombre());
			st.setString(2, m.getDireccion());
			st.setInt(3, m.getTelefono());
			st.setString(4, m.getEmail());
			st.setInt(5, m.getIdMuseo());
			st.execute();
			if (existe(m.getIdMuseo()) == false) {
			       System.out.println("El museo no existe");
			}else {
				System.out.println("Se actualizaron correctamente los datos del "+m.getNombre());
			}
			con.commit();//2- Transacción
		} catch(SQLException e) {
			System.out.println("No es posible modificar los datos de "+ m.getNombre());
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
	public static void elimina(int idMuseo){
		PreparedStatement st = null;
		Connection con = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "delete from museo where idMuseo = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, idMuseo);
			if (existe(idMuseo) == false) {
			       System.out.println("El museo no existe");
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

	//********BUSCAR POR NOMBRE********************
	public static MuseoVO getMuseoVO (String nombre) throws NegocioException, CafeStoreException {
		Connection con = null;
		MuseoVO m = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				m= new MuseoVO ();
				String sql = "select * from museo where nombre like  ? ";
				st = con.prepareStatement(sql);
				st.setString(1, '%'+ nombre + '%');
				rs = st.executeQuery();
				
			while (rs.next()) {
				int idMuseo = rs.getInt("idMuseo");
				String nomb = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				int telefono = rs.getInt("telefono");
				String email = rs.getString("email");
				
				m.setIdMuseo(idMuseo);
				m.setNombre(nomb);
				m.setDireccion(direccion);
				m.setTelefono(telefono);
				m.setEmail(email);
				if(existe(m.getNombre()) != false) {
					System.out.println("Los datos del museo son: ");
					System.out.println(m.toString());
				}
				}
			if(existe(m.getNombre()) == false) {
				System.out.println("El museo no existe");
			}
		
		}catch(SQLException e) {
			System.out.println("No es posible mostrar los datos de "+ m.getNombre());
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
			return m;
	}

	//********BUSCAR POR ID********************
	public static MuseoVO getMuseoVO (int codigo) throws NegocioException, CafeStoreException {
		Connection con = null;
		MuseoVO m = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		boolean existe = false;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				m= new MuseoVO ();
				String sql = "select * from museo where idMuseo =  ? ";
				st = con.prepareStatement(sql);
				st.setInt(1, codigo);
				rs = st.executeQuery();
				
			while (rs.next()) {
				existe=true;
				int idMuseo = rs.getInt("idMuseo");
				String nomb = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				int telefono = rs.getInt("telefono");
				String email = rs.getString("email");
				
				m.setIdMuseo(idMuseo);
				m.setNombre(nomb);
				m.setDireccion(direccion);
				m.setTelefono(telefono);
				m.setEmail(email);
				if(existe(m.getIdMuseo()) == true) {
					System.out.println("Los datos del museo son: ");
					System.out.println(m.toString());
				}
				}
			if(existe(m.getIdMuseo()) == false) {
				System.out.println("El museo no existe");
			}
		
		}catch(SQLException e) {
			System.out.println("No es posible mostrar los datos de "+ m.getNombre());
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
			return m;
	}
	
	//********BUSQUEDA GENERAL********************
	public static MuseoVO getMuseoVOg (String busqueda) throws NegocioException, CafeStoreException {
		Connection con = null;
		MuseoVO m = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		boolean existe = false;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				m= new MuseoVO ();
				String sql = "select * from museo where concat (nombre,email,direccion) like  ? ";
				st = con.prepareStatement(sql);
				st.setString(1,'%'+ busqueda +'%');
				rs = st.executeQuery();
				
			while (rs.next()) {
				existe=true;
				int idMuseo = rs.getInt("idMuseo");
				String nomb = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				int telefono = rs.getInt("telefono");
				String email = rs.getString("email");
				
				m.setIdMuseo(idMuseo);
				m.setNombre(nomb);
				m.setDireccion(direccion);
				m.setTelefono(telefono);
				m.setEmail(email);
				if(m.getIdMuseo() != 0) {
					System.out.println("Los datos del museo son: ");
					System.out.println(m.toString());
				}
				}
			if(m.getIdMuseo() == 0) {
				System.out.println("El museo no existe");
			}
		
		}catch(SQLException e) {
			System.out.println("No es posible mostrar los datos de "+ m.getNombre());
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
			return m;
	}
	
	
	
	
	
	
	
	//********CORROBORAR SI EXISTE POR ID********************
	public static boolean existe(int codigo) throws NegocioException, CafeStoreException {
		Connection con = null;
		MuseoVO m = null;
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
			String sql = "select * from museo where idMuseo  = ?";
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
	
	//********CORROBORAR SI EXISTE POR NOMBRE********************
		public static boolean existe(String nombre) throws NegocioException, CafeStoreException {
			Connection con = null;
			MuseoVO m = null;
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
				String sql = "select * from museo where nombre  = ?";
				st = con.prepareStatement(sql);
				st.setString(1, nombre);
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


