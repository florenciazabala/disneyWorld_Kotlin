package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.pintura.UnionTipoFichaVO;

public class UnionTipoFichaDAO {
	//********INSERTAR********************
		public static void inserta(UnionTipoFichaVO utf) {
			Connection con= null;
			PreparedStatement st = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "insert into unionTipoFicha (tipologia_idTipologia,examenOrganoleptico_idExamenOrganoleptico,fichaTecnica_idFichaTecnica) values (?,?,?)";
				st = con.prepareStatement(sql);
				st.setInt(1, utf.getTipologia_idTipologia());
				st.setInt(2, utf.getExamenOrganoleptico_idExamenOrganoleptico());
				st.setInt(3, utf.getFichaTecnica_idFichaTecnica());
				st.execute();
				con.commit();//2- Transacción
			}catch(SQLException e) {
				System.out.println("No es posible insertar la ficha");
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
		public static void modifica(UnionTipoFichaVO utf) {
			PreparedStatement st = null;
			Connection con = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "update uninTipoFicha set tipologia_idTipologia=?,examenOrganoleptico_idExamenOrganoleptico=?,fichaTecnica_idFichaTecnica=? where fichaTecnica_idFichaTecnica=?";
				st = con.prepareStatement(sql);
				st = con.prepareStatement(sql);
				st = con.prepareStatement(sql);
				st.setInt(1, utf.getTipologia_idTipologia());
				st.setInt(2, utf.getExamenOrganoleptico_idExamenOrganoleptico());
				st.setInt(3, utf.getFichaTecnica_idFichaTecnica());
				st.execute();
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
		public static void elimina(int idFichaTecnica){
			PreparedStatement st = null;
			Connection con = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "delete from unionTipoFicha where fichaTecnica_idFichaTecnica=?";
				st = con.prepareStatement(sql);
				st.setInt(1,idFichaTecnica);
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
				public static UnionTipoFichaVO getObjetoVO (int idFichaTecnica) throws NegocioException, CafeStoreException {
					Connection con = null;
					UnionTipoFichaVO utf = null;
					ResultSet rs = null;
					PreparedStatement st = null;
					
						try {
							con= Conexion.getConnection();
							con.setAutoCommit(false); //1- Transacción
							utf= new UnionTipoFichaVO ();
							String sql = "select * from unionTipoFicha where fichaTecnica_idFichaTecnica like ?";
							st = con.prepareStatement(sql);
							st.setInt(1, '%'+ idFichaTecnica + '%');
							rs = st.executeQuery();
							
						while (rs.next()) {
							int tipologia_idTipologia= rs.getInt("tipologia_idTipologia");
							int examenOrganoleptico_idExamenOrganoleptico = rs.getInt("	examenOrganoleptico_idExamenOrganoleptico ");
							int fichaTecnica_idFichaTecnica = rs.getInt("fichaTecnica_idFichaTecnica ");
							utf.setTipologia_idTipologia(tipologia_idTipologia);
							utf.setExamenOrganoleptico_idExamenOrganoleptico(examenOrganoleptico_idExamenOrganoleptico);
							utf.setFichaTecnica_idFichaTecnica(fichaTecnica_idFichaTecnica);
							}
					
					}catch(SQLException e) {
						System.out.println("No es posible mostrar los datos de la ficha");
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
						return utf;
				}

		
}
