package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.LoginVO;


public class LoginDAO {
	//********INSERTAR********************
			public static void inserta(LoginVO l) {
				Connection con= null;
				PreparedStatement st = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					String sql = "insert into login (nombreUsuario, password) values (?,?)";
					st = con.prepareStatement(sql);
					st.setString(1, l.getNombreUsuario());
					st.setString(2, l.getPassword());
					st.execute();
					if (existe(l.getNombreUsuario()) == true) {
					       System.out.println("el usuario ya se encuentra registrado");
					}else {
						System.out.println("Se registró correctamente al usuario "+l.getNombreUsuario());
					}
					con.commit();//2- Transacción
				}catch(SQLException e) {
					System.out.println("No es posible insertar al usuario "+ l.getNombreUsuario());
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
			public static void modifica(LoginVO l) {
				PreparedStatement st = null;
				Connection con = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					String sql = "update login set idLogin=?, nombreUsuario=?, password=? where idLogin=?";
					st = con.prepareStatement(sql);
					st.setInt(1, l.getIdLogin() );
					st.setString(2,l.getNombreUsuario() );
					st.setString(3, l.getPassword());
					st.setInt(4, l.getIdLogin());
					st.execute();
					if (existe(l.getNombreUsuario()) == false) {
					       System.out.println("el usuario que intenta modificar no existe");
					}else {
						System.out.println("Se actualizaron correctamente los datos del usuario "+l.getNombreUsuario());
					}
					con.commit();//2- Transacción
				} catch(SQLException e) {
					System.out.println("No es posible modificar los datos del usuario "+ l.getNombreUsuario());
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
			public static void elimina(int idLogin){
				PreparedStatement st = null;
				Connection con = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					String sql = "delete from login where idLogin=?";
					st = con.prepareStatement(sql);
					st.setInt(1, idLogin);
					if (existe(idLogin) == false) {
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

			//********BUSCAR POR NOMBRE********************
			public static LoginVO getLoginVO (String nombreUsuario) throws NegocioException, CafeStoreException {
				Connection con = null;
				LoginVO l = null;
				ResultSet rs = null;
				PreparedStatement st = null;
				boolean existe = false;
				
					try {
						con= Conexion.getConnection();
						con.setAutoCommit(false); //1- Transacción
						l= new LoginVO ();
						String sql = "select * from login where nombreUsuario like  ? ";
						st = con.prepareStatement(sql);
						st.setString(1, '%'+ nombreUsuario + '%');
						rs = st.executeQuery();
						
					while (rs.next()) {
						existe=true;
						int idLogin = rs.getInt("idLogin");
						String nombreU =rs.getString("nombreUsuario");
						String password = rs.getString("password");
						l.setIdLogin(idLogin);
						l.setNombreUsuario(nombreU);
						l.setPassword(password);
						if(existe(l.getNombreUsuario()) != false) {
							System.out.println("Los datos del usuario son: ");
							System.out.println(l.toString());
						}
						}
					if(existe(l.getNombreUsuario()) == false) {
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
					return l;
			}

			//********BUSCAR POR ID********************
			
			public static LoginVO getLoginVO (int idLogin) throws NegocioException, CafeStoreException {
				Connection con = null;
				LoginVO l = null;
				ResultSet rs = null;
				PreparedStatement st = null;
				boolean existe = false;
				
					try {
						con= Conexion.getConnection();
						con.setAutoCommit(false); //1- Transacción
						l= new LoginVO ();
						String sql = "select * from login where idLogin like  ? ";
						st = con.prepareStatement(sql);
						st.setInt(1, '%'+ idLogin + '%');
						rs = st.executeQuery();
						
					while (rs.next()) {
						existe=true;
						int idLog = rs.getInt("idLogin");
						String nombreU =rs.getString("nombreUsuario");
						String password = rs.getString("password");
						l.setIdLogin(idLog);
						l.setNombreUsuario(nombreU);
						l.setPassword(password);
						if(existe(l.getNombreUsuario()) != false) {
							System.out.println("Los datos del usuario son: ");
							System.out.println(l.toString());
						}
						}
					if(existe(l.getNombreUsuario()) == false) {
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
					return l;
			}
			
			
			
			//********CORROBORAR SI EXISTE POR ID********************
			public static boolean existe(int codigo) throws NegocioException, CafeStoreException {
				Connection con = null;
				LoginVO l = null;
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
					String sql = "select * from login where idLogin  = ?";
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
				public static boolean existe(String nombreUsuario) throws NegocioException, CafeStoreException {
					Connection con = null;
					LoginVO l = null;
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
						String sql = "select * from login where nombreUsuario  = ?";
						st = con.prepareStatement(sql);
						st.setString(1, nombreUsuario);
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
