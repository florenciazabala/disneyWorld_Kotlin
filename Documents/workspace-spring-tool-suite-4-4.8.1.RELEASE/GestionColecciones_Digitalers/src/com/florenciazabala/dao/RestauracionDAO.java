package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.MuseoVO;
import com.florenciazabala.modulos.SalaVO;
import com.florenciazabala.modulos.fichageneral.RestauracionVO;

public class RestauracionDAO {
	//********INSERTAR********************
			public static void inserta(RestauracionVO r) {
				Connection con= null;
				PreparedStatement st = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					String sql = "insert into restauracion (propuestaTratamiento) values (?)";
					st = con.prepareStatement(sql);
					st.setString(1, r.getPropuestaTratamiento());
					st.execute();
					if (existe(r.getIdRestauracion()) == true) {
					       System.out.println("La propuesta ya se encuentra registrada");
					}else {
						System.out.println("Se registró correctamente la propuesta ");
					}
					con.commit();//2- Transacción
				}catch(SQLException e) {
					System.out.println("No es posible insertar la propuesta ");
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
			public static void modifica(RestauracionVO r) {
				PreparedStatement st = null;
				Connection con = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					String sql = "update restauracion set idRestauracion =? propuestaTraramiento=? where propuestaTratamiento = ? ";
					st = con.prepareStatement(sql);
					st.setInt(1, r.getIdRestauracion());
					st.setString(2, r.getPropuestaTratamiento());
					st.setInt(3,r.getIdRestauracion());
					st.execute();
					if (existe(r.getIdRestauracion()) == false) {
					       System.out.println("La propuesta que intenta modificar no existe");
					}else {
						System.out.println("Se actualizaron correctamente los datos de la propuesta");
					}
					con.commit();//2- Transacción
				} catch(SQLException e) {
					System.out.println("No es posible modificar los datos de la propuesta");
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
			public static void elimina(int idRestauracion){
				PreparedStatement st = null;
				Connection con = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					String sql = "delete from restauracion where idRestauracion =?";
					st = con.prepareStatement(sql);
					st.setInt(1, idRestauracion);
					if (existe(idRestauracion) == false) {
					       System.out.println("La propuesta no existe");
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
			public static RestauracionVO getRestauracionVO (int codigo) throws NegocioException, CafeStoreException {
				Connection con = null;
				RestauracionVO r = null;
				ResultSet rs = null;
				PreparedStatement st = null;
				
					try {
						con= Conexion.getConnection();
						con.setAutoCommit(false); //1- Transacción
						r= new RestauracionVO ();
						String sql = "select * from restauracion where idRestauracion =  ? ";
						st = con.prepareStatement(sql);
						st.setInt(1, codigo);
						rs = st.executeQuery();
						
					while (rs.next()) {
						int idRestauracion = rs.getInt("idRestauracion");
						String propuestaTratamiento = rs.getString("propuestaTratamiento");
						r.setIdRestauracion(idRestauracion);
						r.setPropuestaTratamiento(propuestaTratamiento);
						if(existe(r.getIdRestauracion()) == true) {
							System.out.println("Los datos de la propuesta son: ");
							System.out.println(r.toString());
						}
						}
					if(existe(r.getIdRestauracion()) == false) {
						System.out.println("La propuesta no existe");
					}
				
				}catch(SQLException e) {
					System.out.println("No es posible mostrar los datos de la propuesta ");
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
					return r;
			}
			
		
			
			
			//********CORROBORAR SI EXISTE POR ID********************
			public static boolean existe(int codigo) throws NegocioException, CafeStoreException {
				Connection con = null;
				RestauracionVO r = null;
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
					String sql = "select * from restauracion where idRestauracion  = ?";
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
			
}
