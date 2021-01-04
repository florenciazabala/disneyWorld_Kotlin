package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.fichageneral.TipologiaVO;

public class TipologiaDAO {
	//********INSERTAR********************
			public static void inserta(TipologiaVO t) {
				Connection con= null;
				PreparedStatement st = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacci�n
					String sql = "insert into tipologia (idTipologia,codigoTipologia,tipologia) values (?,?,?)";
					st = con.prepareStatement(sql);
					st.setInt(1,t.getIdTipologia());
					st.setString(2, t.getCodigoTipologia());
					st.setString(3,t.getTipologia());
					st.execute();
					if (existe(t.getCodigoTipologia(),t.getTipologia()) == true) {
					       System.out.println("La tipologia ya se encuentra registrada");
					}else {
						System.out.println("Se registr� correctamente la tipologia ");
					}
					con.commit();//2- Transacci�n
				}catch(SQLException e) {
					System.out.println("No es posible insertar la tipologia ");
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
					System.out.println("Algo sucedi�"+e.getMessage());
				}

				}
			}
			//********MODIFICAR********************
			public static void modifica(TipologiaVO t) {
				PreparedStatement st = null;
				Connection con = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacci�n
					String sql = "update tipologia set idTipologia=?,codigoTipologia=?,tipologia=? where idTipologia=?";
					st = con.prepareStatement(sql);
					st.setInt(1,t.getIdTipologia());
					st.setString(2, t.getCodigoTipologia());
					st.setString(3,t.getTipologia());
					st.setInt(4,t.getIdTipologia());
					st.execute();
					if (existe(t.getCodigoTipologia(),t.getTipologia()) == true) {
					       System.out.println("La tipologia ya se encuentra registrada");
					}else {
						System.out.println("Se registr� correctamente la tipologia ");
					}
					con.commit();//2- Transacci�n
				} catch(SQLException e) {
					System.out.println("No es posible modificar los datos de la tipologia ");
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
						System.out.println("Algo sucedi�"+e.getMessage());
					}

					}
			}
			
			//********ELIMINAR POR ID********************
			public static void elimina(int idTipologia){
				PreparedStatement st = null;
				Connection con = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacci�n
					String sql = "delete from tipologia where idTipologia=?";
					st = con.prepareStatement(sql);
					st.setInt(1, idTipologia);
					if (existe(idTipologia) == false) {
					       System.out.println("La tipologia no existe");
					}else {
						System.out.println("Los datos se eliminaron correctamente");
					}
					st.execute();
					con.commit();//2- Transacci�n
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
						System.out.println("Algo sucedi�"+e.getMessage());
					}

					}
			}

			//********BUSCAR POR CODIGO Y TIPOLOGIA********************
			public static TipologiaVO getTipologiaVO (String busqueda) throws NegocioException, CafeStoreException {
				Connection con = null;
				TipologiaVO t = null;
				ResultSet rs = null;
				PreparedStatement st = null;
				
					try {
						con= Conexion.getConnection();
						con.setAutoCommit(false); //1- Transacci�n
						t= new TipologiaVO ();
						String sql = "select * from tipologia concat(codigotipologia, tipologia) like ?";
						st = con.prepareStatement(sql);
						st.setString(1, '%'+ busqueda + '%');
						rs = st.executeQuery();
						
					while (rs.next()) {
						int idTipologia= rs.getInt("idTipologia");
						String codigoTipologia = rs.getString("codigoTipologia");
						String tipologia = rs.getString("tipologia");
						t.setIdTipologia(idTipologia);
						t.setCodigoTipologia(codigoTipologia);
						t.setTipologia(tipologia);
						if(existe(t.getCodigoTipologia(),t.getTipologia()) != false) {
							System.out.println("Los datos de la tipologia son: ");
							System.out.println(t.toString());
						}
						}
					if(existe(t.getCodigoTipologia(),t.getTipologia()) == false) {
						System.out.println("No existe una tipologia que se corresponda con los datos ingresados");
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
						System.out.println("Algo sucedi�"+e.getMessage());
					}

					}
					return t;
			}

			
			//********CORROBORAR SI EXISTE POR CODIGO o TIPOLOGIA********************
				public static boolean existe(String codigoTipologia, String tipologia) throws NegocioException, CafeStoreException {
					Connection con = null;
					TipologiaVO t = null;
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
						String sql = "select * from tipologia where codigoTipologia = ? or tipologia=?";
						st = con.prepareStatement(sql);
						st.setString(1, codigoTipologia);
						st.setString(2, tipologia);
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
				public static boolean existe(int idTipologia) throws NegocioException, CafeStoreException {
					Connection con = null;
					TipologiaVO t = null;
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
						String sql = "select * from tipologia where idtipologia=?";
						st = con.prepareStatement(sql);
						st.setInt(1, idTipologia);
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
