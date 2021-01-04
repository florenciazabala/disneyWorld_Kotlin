package com.florenciazabala.dao.inners;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.ContactoVO;
import com.florenciazabala.modulos.LoginVO;
import com.florenciazabala.modulos.MuseoVO;
import com.florenciazabala.modulos.SalaVO;
import com.florenciazabala.modulos.UsuarioVO;
import com.florenciazabala.*;

public class Inner {
	
	//********INNER JOIN --> LOGIN********************
	public static int idL;
	public static boolean existeUsuario (String nombreUsuario, String password) throws NegocioException, CafeStoreException {
		Connection con = null;
		ResultSet rs = null;
		UsuarioVO u =null;
		LoginVO l=null;
		PreparedStatement st = null;
		boolean respuesta = false;
		try {
			try {
				con =  Conexion.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
				throw new CafeStoreException();
			}
			u = new UsuarioVO ();
			l = new LoginVO();
			String sql = "select * from login l inner join usuario u on u.login_idLogin = l.idLogin  where (l.nombreUsuario  = ? or mailUsuario=?) and l.password= ?";
			st = con.prepareStatement(sql);
			st.setString(1, nombreUsuario);
			st.setString(2, nombreUsuario);
			st.setString(3, password);
			rs = st.executeQuery();
			if (rs.next()) {
				int idLogin = rs.getInt("idLogin");
				l.setIdLogin(idLogin);
				
				String nombreUs =rs.getString("nombreUsuario");
				u.setNombreUsuario(nombreUs);
				
				respuesta = true;
				idL= l.getIdLogin();
				System.out.println("Bienvenido");
			} else {
				String sql2 = "select * from login l inner join usuario u on u.login_idLogin = l.idLogin  where l.nombreUsuario  = ? or mailUsuario=?";
				st = con.prepareStatement(sql2);
				st.setString(1, nombreUsuario);
				st.setString(2, nombreUsuario);
				rs = st.executeQuery();
			if(rs.next()) {
				System.out.println("La contraseña es incorrecta");
			}else {
				System.out.println("El usuario no se encuentra registrado");
			}
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
	
	
	
			public static UsuarioVO mostrarUsuario () throws NegocioException, CafeStoreException {
				Connection con = null;
				UsuarioVO u = null;
				LoginVO l = null;
				ResultSet rs = null;
				PreparedStatement st = null;
					try {
						con= Conexion.getConnection();
						con.setAutoCommit(false); //1- Transacción
						u= new UsuarioVO();
						l= new LoginVO();
						String sql = "SELECT * FROM usuario u "
								+ "INNER JOIN login l ON u.login_idLogin = l.idLogin WHERE l.idLogin= ?";
						st = con.prepareStatement(sql);
						st.setInt(1, idL);
						rs = st.executeQuery();
						
					while (rs.next()) {
						int idUsuario = rs.getInt("idUsuario");
						String nombreUsuario = rs.getString("nombreUsuario");
						String apellido = rs.getString("apellido");
						int dni = rs.getInt("dni");
						Date fechaNacimiento =rs.getDate("fechaNacimiento");
						String cargo =rs.getString("cargo");
						String mailUsuario = rs.getString("mailUsuario");
						String direccionUsuario =rs.getString("direccionUsuario");
						int telefonoUsuario=rs.getInt("telefonoUsuario");
						
						u.setIdUsuario(idUsuario);
						u.setNombreUsuario(nombreUsuario);
						u.setApellido(apellido);
						u.setDni(dni);
						u.setFechaNacimiento(fechaNacimiento);
						u.setCargo(cargo);
						u.setMailUsuario(mailUsuario);
						u.setDireccionUsuario(direccionUsuario);
						u.setTelefonoUsuario(telefonoUsuario);
						System.out.println("Los datos del usuario son: ");
						System.out.println(u.toString());
						
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
			
			
		
	
	//********INNER JOIN --> MUSEO********************
		public static MuseoVO mostrarMuseo (int museo_idmuseoU) throws NegocioException, CafeStoreException {
			Connection con = null;
			MuseoVO m = null;
			ContactoVO c = null;
			ResultSet rs = null;
			PreparedStatement st = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					m= new MuseoVO();
					c= new ContactoVO();
					String sql = "SELECT m.idMuseo, m.nombre, m.direccion, m.telefono, m.email, "
							+ "c.idContacto, c.sede, c.mailSede,c.direccionSede, c.telefonoSede FROM museo m "
							+ "INNER JOIN contacto c ON m.idMuseo=c.museo_idMuseo WHERE idMuseo = ?";
					st = con.prepareStatement(sql);
					st.setInt(1, museo_idmuseoU);
					rs = st.executeQuery();
					
				while (rs.next()) {
					int idMuseo = rs.getInt("idMuseo");
					String nombre = rs.getString("nombre");
					String direccion = rs.getString("direccion");
					int telefono = rs.getInt("telefono");
					String email = rs.getString("email");
					
					int idContacto =rs.getInt("idContacto");
					String sede = rs.getString("sede");
					String mailSede = rs.getString("mailSede");
					String direccionSede = rs.getString("direccionSede");
					int telefonoSede = rs.getInt("telefonoSede");
					
					m.setIdMuseo(idMuseo);
					m.setNombre(nombre);
					m.setDireccion(direccion);
					m.setTelefono(telefono);
					m.setEmail(email);
					
					c.setIdContacto(idContacto);
					c.setSede(sede);
					c.setMailSede(mailSede);
					c.setDireccionSede(direccionSede);
					c.setTelefonoSede(telefonoSede);
					
					System.out.println("Los datos del museo son: ");
					System.out.println(m.toString()+c.toString());
					
					}
				
			
			}catch(SQLException e) {
				System.out.println("No es posible mostrar los datos del museo ");
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
		//********INNER JOIN --> MUSEO********************
		public static MuseoVO mostrarMuseo2 () throws NegocioException, CafeStoreException {
			Connection con = null;
			MuseoVO m = null;
			/*ContactoVO c = null;*/
			ResultSet rs = null;
			PreparedStatement st = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					m= new MuseoVO();
					/*c= new ContactoVO();*/
					String sql = "SELECT m.idMuseo, m.nombre, m.direccion, m.telefono, m.email "
							+ " FROM museo m "
							+ "INNER JOIN contacto c ON m.idMuseo=c.museo_idMuseo INNER JOIN imagenMuseo im ON m.idMuseo=im.museo_idMuseo "
							+ "INNER JOIN sala s ON s.museo_idmuseo = m.idMuseo "
							+ "INNER JOIN usuario u ON m.idMuseo=u.museo_idmuseo "
							+ "INNER JOIN login l ON u.login_idLogin = l.idLogin "
							+ " "
							+ "INNER JOIN objeto o ON o.museo_idmuseo=m.idmuseo"
							+ "where m.idMuseo= 1";
					st = con.prepareStatement(sql);
					/*st.setInt(1, '%'+ museo_idmuseoU +'%');*/
					rs = st.executeQuery();
					
				while (rs.next()) {
					int idMuseo = rs.getInt("idMuseo");
					String nombre = rs.getString("nombre");
					String direccion = rs.getString("direccion");
					int telefono = rs.getInt("telefono");
					String email = rs.getString("email");
					
					/*int idContacto =rs.getInt("idContacto");
					String sede = rs.getString("sede");
					String mailSede = rs.getString("mailSede");
					String direccionSede = rs.getString("direccionSede");
					int telefonoSede = rs.getInt("telefonoSede");*/
					
					m.setIdMuseo(idMuseo);
					m.setNombre(nombre);
					m.setDireccion(direccion);
					m.setTelefono(telefono);
					m.setEmail(email);
					
					/*c.setIdContacto(idContacto);
					c.setSede(sede);
					c.setMailSede(mailSede);
					c.setDireccionSede(direccionSede);
					c.setTelefonoSede(telefonoSede);
					*/
					System.out.println("Los datos del museo son: ");
					System.out.println(m.toString());
					
					}
				
			
			}catch(SQLException e) {
				System.out.println("No es posible mostrar los datos del museo ");
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
	
	
	
	//********INNER JOIN --> sala museo********************
	public static SalaVO unir () throws NegocioException, CafeStoreException {
		Connection con = null;
		SalaVO s = null;
		MuseoVO m= null;
		ResultSet rs = null;
		PreparedStatement st = null;
		boolean existe = false;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				s= new SalaVO ();
				m=new MuseoVO();
				String sql = "SELECT s.numeroSala, s.nombreSala, s.piso, s.museo_idmuseo, m.idMuseo, m.nombre, m.direccion, m.email FROM sala s INNER JOIN museo m ON s.museo_idmuseo = m.idMuseo ORDER BY m.nombre";
				st = con.prepareStatement(sql);
				//st.setInt(1, codigo);
				rs = st.executeQuery();
				
			while (rs.next()) {
				existe=true;
				int numeroSala = rs.getInt("numeroSala");
				String nomb = rs.getString("nombreSala");
				int piso = rs.getInt("piso");
				int museo_idmuseo = rs.getInt("museo_idmuseo");
				
				int idMuseo =rs.getInt("idMuseo");
				String nombM = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				String email = rs.getString("email");
				
				m.setIdMuseo(idMuseo);
				m.setNombre(nombM);
				m.setDireccion(direccion);
				m.setEmail(email);
				
				
				s.setNumeroSala(numeroSala);
				s.setNombreSala(nomb);
				s.setPiso(piso);
				s.setMuseo_idmuseo(museo_idmuseo);
				
				System.out.println(s.toString()+m.toString());
				
				}
			
		
		}catch(SQLException e) {
			System.out.println("No es posible mostrar los datos de la sala "+ s.getNombreSala());
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
			return s;
	}

}
