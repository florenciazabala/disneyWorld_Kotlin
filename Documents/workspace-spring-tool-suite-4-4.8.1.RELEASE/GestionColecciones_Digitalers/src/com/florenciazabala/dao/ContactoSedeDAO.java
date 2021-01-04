package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.ContactoVO;


public class ContactoSedeDAO {
	//********INSERTAR********************
			public static void inserta(ContactoVO c) {
				Connection con= null;
				PreparedStatement st = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					String sql = "insert into contacto (sede,mailSede,direccionSede,telefonoSede,museo_idMuseo) values (?,?,?,?,?)";
					st = con.prepareStatement(sql);
					st.setString(1, c.getSede());
					st.setString(2, c.getMailSede());
					st.setString(3, c.getDireccionSede());
					st.setInt(4, c.getTelefonoSede());
					st.setInt(5, c.getMuseo_idMuseo());
					st.execute();
					if (existe(c.getSede()) == true) {
					       System.out.println("La sede ya se encuentra registrado");
					}else {
						System.out.println("Se registró correctamente la sede");
					}
					con.commit();//2- Transacción
				}catch(SQLException e) {
					System.out.println("No es posible insertar la sede");
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
			public static void modifica(ContactoVO c) {
				PreparedStatement st = null;
				Connection con = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					String sql = "update objeto set idContacto=?, sede=?,mailSede=?,direccionSede=?,telefonoSede=?,museo_idMuseo=? where idContacto=?";
					st = con.prepareStatement(sql);
					st = con.prepareStatement(sql);
					st.setString(1, c.getSede());
					st.setString(2, c.getMailSede());
					st.setString(3, c.getDireccionSede());
					st.setInt(4, c.getTelefonoSede());
					st.setInt(5, c.getMuseo_idMuseo());
					st.execute();
					if (existe(c.getSede()) == false) {
					       System.out.println("La sede que desea modificar no existe");
					}else {
						System.out.println("Se modificó correctamente la sede ");
					}
					con.commit();//2- Transacción
				} catch(SQLException e) {
					System.out.println("No es posible modificar los datos de la sede");
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
			public static void elimina(int idContacto){
				PreparedStatement st = null;
				Connection con = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					String sql = "delete from contacto where idContacto=?";
					st = con.prepareStatement(sql);
					st.setInt(1,idContacto);
					if (existe(idContacto) == false) {
					       System.out.println("La sede que intenta eliminar no existe");
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
			//********BUSQUEDA POR ID********************
					public static ContactoVO getObjetoVO (int idContacto) throws NegocioException, CafeStoreException {
						Connection con = null;
						ContactoVO c = null;
						ResultSet rs = null;
						PreparedStatement st = null;
						
							try {
								con= Conexion.getConnection();
								con.setAutoCommit(false); //1- Transacción
								c= new ContactoVO ();
								String sql = "select * from contacto where idContacto like ?";
								st = con.prepareStatement(sql);
								st.setInt(1, '%'+ idContacto + '%');
								rs = st.executeQuery();
								
							while (rs.next()) {
								int idCont= rs.getInt("idContacto");
								String sede = rs.getString("sede");
								String mailSede = rs.getString("mailSede");
								String direccionSede = rs.getString("direccionSede");
								int telefonoSede = rs.getInt("telefonoSede");
								int museo_idMuseo  = rs.getInt("museo_idMuseo");
								c.setIdContacto(idCont);
								c.setSede(sede);
								c.setMailSede(mailSede);
								c.setDireccionSede(direccionSede);
								c.setTelefonoSede(telefonoSede);
								c.setMuseo_idMuseo(museo_idMuseo);
								if(existe(c.getIdContacto()) != false) {
									System.out.println("Los datos de la sede son: ");
									System.out.println(c.toString());
								}
								}
							if(existe(c.getIdContacto()) == false) {
								System.out.println("No existe una sede que se corresponda con los datos ingresados");
							}
						
						}catch(SQLException e) {
							System.out.println("No es posible mostrar los datos del objeto");
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
							return c;
					}


			//********BUSQUEDA GENERAL********************
			public static ContactoVO getObjetoVO (String busqueda) throws NegocioException, CafeStoreException {
				Connection con = null;
				ContactoVO c = null;
				ResultSet rs = null;
				PreparedStatement st = null;
				
					try {
						con= Conexion.getConnection();
						con.setAutoCommit(false); //1- Transacción
						c= new ContactoVO ();
						String sql = "select * from contacto concat(sede,mailSede,direccionSede,telefonoSede,museo_idMuseo) like ?";
						st = con.prepareStatement(sql);
						st.setString(1, '%'+ busqueda + '%');
						rs = st.executeQuery();
						
					while (rs.next()) {
						int idCont= rs.getInt("idContacto");
						String sede = rs.getString("sede");
						String mailSede = rs.getString("mailSede");
						String direccionSede = rs.getString("direccionSede");
						int telefonoSede = rs.getInt("telefonoSede");
						int museo_idMuseo  = rs.getInt("museo_idMuseo");
						c.setIdContacto(idCont);
						c.setSede(sede);
						c.setMailSede(mailSede);
						c.setDireccionSede(direccionSede);
						c.setTelefonoSede(telefonoSede);
						c.setMuseo_idMuseo(museo_idMuseo);
						if(existe(c.getIdContacto()) != false) {
							System.out.println("Los datos de la sede son: ");
							System.out.println(c.toString());
						}
						}
					if(existe(c.getIdContacto()) == false) {
						System.out.println("No existe una sede que se corresponda con los datos ingresados");
					}
				
				}catch(SQLException e) {
					System.out.println("No es posible mostrar los datos del objeto");
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
					return c;
			}

			
				//********CORROBORAR SI EXISTE POR SEDE********************
				public static boolean existe(String sede) throws NegocioException, CafeStoreException {
					Connection con = null;
					ContactoVO c = null;
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
						String sql = "select * from contacto where sede=?";
						st = con.prepareStatement(sql);
						st.setString(1, sede);
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
				public static boolean existe(int idContacto) throws NegocioException, CafeStoreException {
					Connection con = null;
					ContactoVO c = null;
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
						String sql = "select * from contacto where idContacto=?";
						st = con.prepareStatement(sql);
						st.setInt(1, idContacto);
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
