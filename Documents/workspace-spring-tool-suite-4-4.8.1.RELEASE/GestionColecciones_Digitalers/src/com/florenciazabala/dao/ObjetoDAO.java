package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.fichageneral.ObjetoVO;

public class ObjetoDAO {
	//********INSERTAR********************
		public static void inserta(ObjetoVO o) {
			Connection con= null;
			PreparedStatement st = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "insert into estadoConservacion (numeroInventario,codigoMuseo,fechaIngreso,ubicacion,procedencia,propietario,estado,museo_idmuseo,coleccion_idcoleccion1,sala_numeroSala,restauracion_idRestauracion,responsable_idResponsable,tipologia_idTipologia,estadoConservacion_idEstadoConservacion ) "
						+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				st = con.prepareStatement(sql);
				st.setInt(1,o.getNumeroInventario());
				st.setString(2, o.getCodigoMuseo());
				st.setDate(3, o.getFechaIngreso());
				st.setString(4,o.getUbicacion() );
				st.setString(5,o.getProcedencia() );
				st.setString(6,o.getPropietario() );
				st.setString(7,o.getEstado());
				st.setInt(8, o.getMuseo_idmuseo());
				st.setInt(9, o.getColeccion_idcoleccion1());
				st.setInt(10, o.getSala_numeroSala());
				st.setInt(11, o.getRestauracion_idRestauracion());
				st.setInt(12, o.getResponsable_idResponsable());
				st.setInt(13, o.getTipologia_idTipologia());
				st.setInt(14, o.getEstadoConservacion_idEstadoConservacion());
				st.execute();
				if (existe(o.getNumeroInventario()) == true) {
				       System.out.println("El objeto ya se encuentra registrado");
				}else {
					System.out.println("Se registró correctamente el objeto");
				}
				con.commit();//2- Transacción
			}catch(SQLException e) {
				System.out.println("No es posible insertar el objeto");
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
		public static void modifica(ObjetoVO o) {
			PreparedStatement st = null;
			Connection con = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "update objeto set numeroInventario=?,codigoMuseo=?,fechaIngreso=?,ubicacion=?,procedencia=?,propietario=?,estado=?"
						+ ",museo_idmuseo=?,coleccion_idcoleccion1=?,sala_numeroSala=?,restauracion_idRestauracion=?,responsable_idResponsable=?,tipologia_idTipologia=?,estadoConservacion_idEstadoConservacion=? where numeroInventario=?";
				st = con.prepareStatement(sql);
				st.setInt(1,o.getNumeroInventario());
				st.setString(2, o.getCodigoMuseo());
				st.setDate(3, o.getFechaIngreso());
				st.setString(4,o.getUbicacion() );
				st.setString(5,o.getProcedencia() );
				st.setString(6,o.getPropietario() );
				st.setString(7,o.getEstado());
				st.setInt(8, o.getMuseo_idmuseo());
				st.setInt(9, o.getColeccion_idcoleccion1());
				st.setInt(10, o.getSala_numeroSala());
				st.setInt(11, o.getRestauracion_idRestauracion());
				st.setInt(12, o.getResponsable_idResponsable());
				st.setInt(13, o.getTipologia_idTipologia());
				st.setInt(14, o.getEstadoConservacion_idEstadoConservacion());
				st.setInt(15,o.getNumeroInventario());
				st.execute();
				if (existe(o.getNumeroInventario()) == false) {
				       System.out.println("El objeto que desea modificar no existe");
				}else {
					System.out.println("Se registró correctamente el objeto ");
				}
				con.commit();//2- Transacción
			} catch(SQLException e) {
				System.out.println("No es posible modificar los datos del objeto ");
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
		public static void elimina(int numeroInventario){
			PreparedStatement st = null;
			Connection con = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "delete from objeto where numeroInventario=?";
				st = con.prepareStatement(sql);
				st.setInt(1,numeroInventario);
				if (existe(numeroInventario) == false) {
				       System.out.println("El objeto que intenta eliminar no existe");
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
		//********BUSQUEDA POR NUMERO INVENTARIO********************
				public static ObjetoVO getObjetoVO (int numeroInventario) throws NegocioException, CafeStoreException {
					Connection con = null;
					ObjetoVO o = null;
					ResultSet rs = null;
					PreparedStatement st = null;
					
						try {
							con= Conexion.getConnection();
							con.setAutoCommit(false); //1- Transacción
							o= new ObjetoVO ();
							String sql = "select * from objeto where numeroInventario like ?";
							st = con.prepareStatement(sql);
							st.setInt(1, '%'+ numeroInventario + '%');
							rs = st.executeQuery();
							
						while (rs.next()) {
							int numeroInv= rs.getInt("numeroInventario");
							String codigoMuseo = rs.getString("codigoMuseo");
							Date fechaIngreso = rs.getDate("fechaIngreso");
							String ubicacion = rs.getString("ubicacion");
							String procedencia = rs.getString("procedencia");
							String propietario = rs.getString("propietario");
							String estado = rs.getString("estado");
							int museo_idmuseo  = rs.getInt("museo_idmuseo");
							int coleccion_idcoleccion1 = rs.getInt("coleccion_idcoleccion1 ");
							int sala_numeroSala = rs.getInt("sala_numeroSala");
							int restauracion_idRestauracion = rs.getInt("restauracion_idRestauracion");
							int responsable_idResponsable = rs.getInt("responsable_idResponsable");
							int tipologia_idTipologia = rs.getInt("tipologia_idTipologia");
							int estadoConservacion_idEstadoConservacion = rs.getInt("	estadoConservacion_idEstadoConservacion");
							o.setNumeroInventario(numeroInv);
							o.setCodigoMuseo(codigoMuseo);
							o.setFechaIngreso(fechaIngreso);
							o.setUbicacion(ubicacion);
							o.setProcedencia(procedencia);
							o.setPropietario(propietario);
							o.setEstado(estado);
							o.setMuseo_idmuseo(museo_idmuseo);
							o.setColeccion_idcoleccion1(coleccion_idcoleccion1);
							o.setSala_numeroSala(sala_numeroSala);
							o.setRestauracion_idRestauracion(restauracion_idRestauracion);
							o.setResponsable_idResponsable(responsable_idResponsable);
							o.setTipologia_idTipologia(tipologia_idTipologia);
							o.setEstadoConservacion_idEstadoConservacion(estadoConservacion_idEstadoConservacion);
							if(existe(o.getNumeroInventario()) != false) {
								System.out.println("Los datos del objeto son: ");
								System.out.println(o.toString());
							}
							}
						if(existe(o.getNumeroInventario()) == false) {
							System.out.println("No existe un objeto que se corresponda con los datos ingresados");
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
						return o;
				}


		//********BUSQUEDA GENERAL********************
		public static ObjetoVO getObjetoVO (String busqueda) throws NegocioException, CafeStoreException {
			Connection con = null;
			ObjetoVO o = null;
			ResultSet rs = null;
			PreparedStatement st = null;
			
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					o= new ObjetoVO ();
					String sql = "select * from objeto concat(codigoMuseo,fechaIngreso,ubicacion,procedencia,propietario,estado) like ?";
					st = con.prepareStatement(sql);
					st.setString(1, '%'+ busqueda + '%');
					rs = st.executeQuery();
					
				while (rs.next()) {
					int numeroInventario= rs.getInt("numeroInventario");
					String codigoMuseo = rs.getString("codigoMuseo");
					Date fechaIngreso = rs.getDate("fechaIngreso");
					String ubicacion = rs.getString("ubicacion");
					String procedencia = rs.getString("procedencia");
					String propietario = rs.getString("propietario");
					String estado = rs.getString("estado");
					int museo_idmuseo  = rs.getInt("museo_idmuseo");
					int coleccion_idcoleccion1 = rs.getInt("coleccion_idcoleccion1 ");
					int sala_numeroSala = rs.getInt("sala_numeroSala");
					int restauracion_idRestauracion = rs.getInt("restauracion_idRestauracion");
					int responsable_idResponsable = rs.getInt("responsable_idResponsable");
					int tipologia_idTipologia = rs.getInt("tipologia_idTipologia");
					int estadoConservacion_idEstadoConservacion = rs.getInt("	estadoConservacion_idEstadoConservacion");
					o.setNumeroInventario(numeroInventario);
					o.setCodigoMuseo(codigoMuseo);
					o.setFechaIngreso(fechaIngreso);
					o.setUbicacion(ubicacion);
					o.setProcedencia(procedencia);
					o.setPropietario(propietario);
					o.setEstado(estado);
					o.setMuseo_idmuseo(museo_idmuseo);
					o.setColeccion_idcoleccion1(coleccion_idcoleccion1);
					o.setSala_numeroSala(sala_numeroSala);
					o.setRestauracion_idRestauracion(restauracion_idRestauracion);
					o.setResponsable_idResponsable(responsable_idResponsable);
					o.setTipologia_idTipologia(tipologia_idTipologia);
					o.setEstadoConservacion_idEstadoConservacion(estadoConservacion_idEstadoConservacion);
					if(existe(o.getNumeroInventario()) != false) {
						System.out.println("Los datos del objeto son: ");
						System.out.println(o.toString());
					}
					}
				if(existe(o.getNumeroInventario()) == false) {
					System.out.println("No existe un objeto que se corresponda con los datos ingresados");
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
				return o;
		}

		
			//********CORROBORAR SI EXISTE POR NUMERO INVENTARIO********************
			public static boolean existe(int numeroInventario) throws NegocioException, CafeStoreException {
				Connection con = null;
				ObjetoVO o = null;
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
					String sql = "select * from objeto where numeroInventario=?";
					st = con.prepareStatement(sql);
					st.setInt(1, numeroInventario);
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
