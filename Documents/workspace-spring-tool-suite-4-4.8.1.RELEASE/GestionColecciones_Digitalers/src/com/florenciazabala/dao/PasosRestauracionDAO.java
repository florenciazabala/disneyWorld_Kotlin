package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.fichageneral.PasosRestauracionVO;


public class PasosRestauracionDAO {
	//********INSERTAR********************
		public static void inserta(PasosRestauracionVO pr) {
			Connection con= null;
			PreparedStatement st = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "insert into pasosRestauracion (paso,tratamiento,producto,restauracion_idRestauracion) values (?,?,?,?)";
				st = con.prepareStatement(sql);
				st.setInt(1,pr.getPaso());
				st.setString(2, pr.getTratamiento());
				st.setString(3, pr.getProducto());
				st.setInt(4, pr.getRestauracion_idRestauracion());
				st.execute();
				if (existe(pr.getIdPasosRestauracion()) == true) {
				       System.out.println("El paso ya se encuentra registrado");
				}else {
					System.out.println("Se registró correctamente el paso");
				}
				con.commit();//2- Transacción
			}catch(SQLException e) {
				System.out.println("No es posible insertar el paso");
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
		public static void modifica(PasosRestauracionVO pr) {
			PreparedStatement st = null;
			Connection con = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "update fichaTecnica set paso=?,tratamiento=?,producto=?,restauracion_idRestauracion=? where idPasosRestauracion=?";
				st = con.prepareStatement(sql);
				st = con.prepareStatement(sql);
				st.setInt(1,pr.getPaso());
				st.setString(2, pr.getTratamiento());
				st.setString(3, pr.getProducto());
				st.setInt(4, pr.getRestauracion_idRestauracion());
				st.setInt(5, pr.getIdPasosRestauracion());
				st.execute();
				if (existe(pr.getIdPasosRestauracion()) == false) {
				       System.out.println("El paso que desea modificar no existe");
				}else {
					System.out.println("Se modificó correctamente el paso ");
				}
				con.commit();//2- Transacción
			} catch(SQLException e) {
				System.out.println("No es posible modificar los datos de la ficha");
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
		public static void elimina(int idPasosRestauracion){
			PreparedStatement st = null;
			Connection con = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "delete from pasosRestauracion where idPasosRestauracion=?";
				st = con.prepareStatement(sql);
				st.setInt(1, idPasosRestauracion);
				if (existe(idPasosRestauracion) == false) {
				       System.out.println("El paso que intenta eliminar no existe");
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
				public static PasosRestauracionVO getPasosRestauracionVO (int idPasosRestauracion) throws NegocioException, CafeStoreException {
					Connection con = null;
					PasosRestauracionVO pr = null;
					ResultSet rs = null;
					PreparedStatement st = null;
					
						try {
							con= Conexion.getConnection();
							con.setAutoCommit(false); //1- Transacción
							pr= new PasosRestauracionVO ();
							String sql = "select * from fichaTecnica where idFichaTecnica like ?";
							st = con.prepareStatement(sql);
							st.setInt(1, '%'+ idPasosRestauracion + '%');
							rs = st.executeQuery();
							
						while (rs.next()) {
							int idPasosRest= rs.getInt("idPasosRestauracion");
							int paso = rs.getInt("paso");
							String tratamiento = rs.getString("tratamiento");
							String producto = rs.getString("producto");
							int restauracion_idRestauracion = rs.getInt("restauracion_idRestauracion");
							pr.setIdPasosRestauracion(idPasosRest);
							pr.setPaso(paso);
							pr.setTratamiento(tratamiento);
							pr.setProducto(producto);
							pr.setRestauracion_idRestauracion(restauracion_idRestauracion);
							if(existe(pr.getIdPasosRestauracion()) != false) {
								System.out.println("Los datos del paso son: ");
								System.out.println(pr.toString());
							}
							}
						if(existe(pr.getIdPasosRestauracion()) == false) {
							System.out.println("No existe un paso que se corresponda con los datos ingresados");
						}
					
					}catch(SQLException e) {
						System.out.println("No es posible mostrar los datos del paso");
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
						return pr;
				}


		//********BUSQUEDA GENERAL********************
		public static PasosRestauracionVO getPasosRestauracionVO (String busqueda) throws NegocioException, CafeStoreException {
			Connection con = null;
			PasosRestauracionVO pr = null;
			ResultSet rs = null;
			PreparedStatement st = null;
			
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					pr= new PasosRestauracionVO ();
					String sql = "select * from pasosRestauracion concat(paso,tratamiento,producto,restauracion_idRestauracion) like ?";
					st = con.prepareStatement(sql);
					st.setString(1, '%'+ busqueda + '%');
					rs = st.executeQuery();
					
				while (rs.next()) {
					int idPasosRest= rs.getInt("idPasosRestauracion");
					int paso = rs.getInt("paso");
					String tratamiento = rs.getString("tratamiento");
					String producto = rs.getString("producto");
					int restauracion_idRestauracion = rs.getInt("restauracion_idRestauracion");
					pr.setIdPasosRestauracion(idPasosRest);
					pr.setPaso(paso);
					pr.setTratamiento(tratamiento);
					pr.setProducto(producto);
					pr.setRestauracion_idRestauracion(restauracion_idRestauracion);
					if(existe(pr.getIdPasosRestauracion()) != false) {
						System.out.println("Los datos del paso son: ");
						System.out.println(pr.toString());
					}
					}
				if(existe(pr.getIdPasosRestauracion()) == false) {
					System.out.println("No existe un paso que se corresponda con los datos ingresados");
				}
			}catch(SQLException e) {
				System.out.println("No es posible mostrar los datos del paso");
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
				return pr;
		}

		
			//********CORROBORAR SI EXISTE POR ID********************
			public static boolean existe(int idPasosRestauracion) throws NegocioException, CafeStoreException {
				Connection con = null;
				PasosRestauracionVO pr = null;
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
					String sql = "select * from pasosRestauracion where idPasosRestauracion=?";
					st = con.prepareStatement(sql);
					st.setInt(1, idPasosRestauracion);
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
			
			//********CORROBORAR SI EXISTE POR paso y tratamiento********************
			public static boolean existe(int paso, String tratamiento) throws NegocioException, CafeStoreException {
				Connection con = null;
				PasosRestauracionVO pr = null;
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
					String sql = "select * from pasosRestauracion where paso=? and tratamiento=?";
					st = con.prepareStatement(sql);
					st.setInt(1, paso);
					st.setString(2, tratamiento);
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
