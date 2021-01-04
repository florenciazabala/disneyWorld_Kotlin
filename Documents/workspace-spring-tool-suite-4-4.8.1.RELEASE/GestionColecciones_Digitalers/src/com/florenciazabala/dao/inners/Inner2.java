package com.florenciazabala.dao.inners;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.LoginVO;
import com.florenciazabala.modulos.MuseoVO;
import com.florenciazabala.modulos.UsuarioVO;

public class Inner2 {
	
	static IdLogeo il = null;   //Almacena el id del Login  al momento de resgistrarse y lugo lo vincula a la fk de la tabla usuario
	static IdMuseo im = null;    //Almacena el id de la fk de la tabla usuario  que se vincula al id del museo
	
	//********INNER JOIN --> LOGIN********************
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
				il= new IdLogeo();
				String sql = "select * from login l inner join usuario u on u.login_idLogin = l.idLogin  where (l.nombreUsuario  = ? or u.mailUsuario=?) and l.password= ?";
				st = con.prepareStatement(sql);
				st.setString(1, nombreUsuario);
				st.setString(2, nombreUsuario);
				st.setString(3, password);
				rs = st.executeQuery();
				if (rs.next()) {
					int idLogin = rs.getInt("idLogin");
					l.setIdLogin(idLogin);
					
					respuesta = true;
					il.setIdL(l.getIdLogin());               //Le paso el valor del id del usuario que se logea
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
							im = new IdMuseo ();
							String sql = "SELECT * FROM usuario u "
									+ "INNER JOIN login l ON u.login_idLogin = l.idLogin WHERE l.idLogin= ?";
							st = con.prepareStatement(sql);
							st.setInt(1, il.getIdL());
							rs = st.executeQuery();
							
						while (rs.next()) {
							int idUsuario = rs.getInt("idUsuario");
							String nombreUsuario = rs.getString("nombreUsuario");
							String apellido = rs.getString("apellido");
							int dni = rs.getInt("dni");
							Date fechaNacimiento =rs.getDate("fechaNacimiento");
							String cargo =rs.getString("cargo");
							String mailUsuario = rs.getString("mailUsuario");
							String direccionUsuario = rs.getString("direccionUsuario");
							int telefonoUsuario=rs.getInt("telefonoUsuario");
							int museo_idmuseo = rs.getInt("museo_idmuseo");
							
							u.setIdUsuario(idUsuario);
							u.setNombreUsuario(nombreUsuario);
							u.setApellido(apellido);
							u.setDni(dni);
							u.setFechaNacimiento(fechaNacimiento);
							u.setCargo(cargo);
							u.setMailUsuario(mailUsuario);
							u.setTelefonoUsuario(telefonoUsuario);
							u.setDireccionUsuario(direccionUsuario);
							u.setMuseo_idmuseo(museo_idmuseo);
							
							im.setIdM(museo_idmuseo);
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


         
				
				public static MuseoVO mostrarMuseo () throws NegocioException, CafeStoreException {
					Connection con = null;
					MuseoVO m = null;
					ResultSet rs = null;
					PreparedStatement st = null;
					
						try {
							con= Conexion.getConnection();
							con.setAutoCommit(false); //1- Transacción
							m= new MuseoVO ();
							String sql = "select * from museo m where m.idMuseo =  ? ";
							st = con.prepareStatement(sql);
							st.setInt(1, im.getIdM());
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
							System.out.println(m.toString());
//							if(existe(m.getIdMuseo()) == true) {
//								System.out.println("Los datos del museo son: ");
//								System.out.println(m.toString());
//							}
							}
//						if(existe(m.getIdMuseo()) == false) {
//							System.out.println("El museo no existe");
//						}
					
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
			//Con el id del museo traigo también los objetos	
				
}
