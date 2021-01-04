package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.pintura.FichaTecnicaVO;

public class FichaTecnicaDAO {
	//********INSERTAR********************
	public static void inserta(FichaTecnicaVO ft) {
		Connection con= null;
		PreparedStatement st = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "insert into fichaTecnica (objetoFT,tituloFT,autorFT,añoPeriodoFT,tecnicaFT,soporteFT,dimensionesFT,generoFT,formatoFT,firmaFT,inscripcionesFT,descripcionFT) values (?,?,?,?,?,?,?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, ft.getObjetoFT() );
			st.setString(2, ft.getTituloFT());
			st.setString(3, ft.getAutorFT());
			st.setString(4, ft.getAñoPeriodoFT());
			st.setString(5, ft.getTecnicaFT());
			st.setString(6, ft.getSoporteFT());
			st.setString(7, ft.getDimensionesFT());
			st.setString(8, ft.getGeneroFT());
			st.setString(9, ft.getFormatoFT());
			st.setString(10, ft.getFirmaFT());
			st.setString(11, ft.getInscripcionesFT());
			st.setString(12, ft.getDescripcionFT());
			st.execute();
			if (existe(ft.getIdFichaTecnica()) == true) {
			       System.out.println("La ficha ya se encuentra registrado");
			}else {
				System.out.println("Se registró correctamente la ficha");
			}
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
	public static void modifica(FichaTecnicaVO ft) {
		PreparedStatement st = null;
		Connection con = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "update fichaTecnica set idFichaTecnica =?,objetoFT=?,tituloFT=?,autorFT=?,añoPeriodoFT=?,tecnicaFT=?,soporteFT=?,dimensionesFT=?,generoFT=?,formatoFT=?,firmaFT=?,inscripcionesFT=?,descripcionFT=? where idFichaTecnica =?";
			st = con.prepareStatement(sql);
			st = con.prepareStatement(sql);
			st.setInt(1, ft.getIdFichaTecnica());
			st.setString(2, ft.getObjetoFT() );
			st.setString(3, ft.getTituloFT());
			st.setString(4, ft.getAutorFT());
			st.setString(5, ft.getAñoPeriodoFT());
			st.setString(6, ft.getTecnicaFT());
			st.setString(7, ft.getSoporteFT());
			st.setString(8, ft.getDimensionesFT());
			st.setString(9, ft.getGeneroFT());
			st.setString(10, ft.getFormatoFT());
			st.setString(11, ft.getFirmaFT());
			st.setString(12, ft.getInscripcionesFT());
			st.setString(13, ft.getDescripcionFT());
			st.setInt(14, ft.getIdFichaTecnica());
			st.execute();
			if (existe(ft.getIdFichaTecnica()) == false) {
			       System.out.println("La ficha que desea modificar no existe");
			}else {
				System.out.println("Se modificó correctamente la ficha ");
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
	public static void elimina(int idFichaTecnica){
		PreparedStatement st = null;
		Connection con = null;
		try {
			con= Conexion.getConnection();
			con.setAutoCommit(false); //1- Transacción
			String sql = "delete from fichaTecnica where idFichaTecnica=?";
			st = con.prepareStatement(sql);
			st.setInt(1,idFichaTecnica);
			if (existe(idFichaTecnica) == false) {
			       System.out.println("La ficha que intenta eliminar no existe");
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
			public static FichaTecnicaVO getObjetoVO (int idFichaTecnica) throws NegocioException, CafeStoreException {
				Connection con = null;
				FichaTecnicaVO ft = null;
				ResultSet rs = null;
				PreparedStatement st = null;
				
					try {
						con= Conexion.getConnection();
						con.setAutoCommit(false); //1- Transacción
						ft= new FichaTecnicaVO ();
						String sql = "select * from fichaTecnica where idFichaTecnica like ?";
						st = con.prepareStatement(sql);
						st.setInt(1, '%'+ idFichaTecnica + '%');
						rs = st.executeQuery();
						
					while (rs.next()) {
						int idFichaTec= rs.getInt("idFichaTecnica");
						String objetoFT = rs.getString("objetoFT");
						String tituloFT = rs.getString("tituloFT");
						String autorFT = rs.getString("autorFT");
						String añoPeriodoFT = rs.getString("añoPeriodoFT");
						String tecnicaFT = rs.getString("tecnicaFT");
						String soporteFT = rs.getString("soporteFT");
						String dimensionesFT= rs.getString("dimensionesFt");
						String generoFT = rs.getString("generoFT");
						String formatoFT = rs.getString("formatoFT");
						String firmaFT = rs.getString("firmaFT");
						String inscripcionesFT = rs.getString("inscripcionesFT");
						String descripcionFT = rs.getString("descripcionFT");
						ft.setIdFichaTecnica(idFichaTec);
						ft.setObjetoFT(objetoFT);
						ft.setTituloFT(tituloFT);
						ft.setAutorFT(autorFT);
						ft.setAñoPeriodoFT(añoPeriodoFT);
						ft.setTecnicaFT(tecnicaFT);
						ft.setSoporteFT(soporteFT);
						ft.setDimensionesFT(dimensionesFT);
						ft.setGeneroFT(generoFT);
						ft.setFormatoFT(formatoFT);
						ft.setFirmaFT(firmaFT);
						ft.setInscripcionesFT(inscripcionesFT);
						ft.setDescripcionFT(descripcionFT);
						if(existe(ft.getIdFichaTecnica()) != false) {
							System.out.println("Los datos de la ficha son: ");
							System.out.println(ft.toString());
						}
						}
					if(existe(ft.getIdFichaTecnica()) == false) {
						System.out.println("No existe una ficha que se corresponda con los datos ingresados");
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
					return ft;
			}


	//********BUSQUEDA GENERAL********************
	public static FichaTecnicaVO getObjetoVO (String busqueda) throws NegocioException, CafeStoreException {
		Connection con = null;
		FichaTecnicaVO ft = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				ft= new FichaTecnicaVO ();
				String sql = "select * from fichaTecnica concat(objetoFT,tituloFT,autorFT,añoPeriodoFT,tecnicaFT,soporteFT,dimensionesFT,generoFT,formatoFT,firmaFT,inscripcionesFT,descripcionFT) like ?";
				st = con.prepareStatement(sql);
				st.setString(1, '%'+ busqueda + '%');
				rs = st.executeQuery();
				
			while (rs.next()) {
				int idFichaTec= rs.getInt("idFichaTecnica");
				String objetoFT = rs.getString("objetoFT");
				String tituloFT = rs.getString("tituloFT");
				String autorFT = rs.getString("autorFT");
				String añoPeriodoFT = rs.getString("añoPeriodoFT");
				String tecnicaFT = rs.getString("tecnicaFT");
				String soporteFT = rs.getString("soporteFT");
				String dimensionesFT= rs.getString("dimensionesFt");
				String generoFT = rs.getString("generoFT");
				String formatoFT = rs.getString("formatoFT");
				String firmaFT = rs.getString("firmaFT");
				String inscripcionesFT = rs.getString("inscripcionesFT");
				String descripcionFT = rs.getString("descripcionFT");
				ft.setIdFichaTecnica(idFichaTec);
				ft.setObjetoFT(objetoFT);
				ft.setTituloFT(tituloFT);
				ft.setAutorFT(autorFT);
				ft.setAñoPeriodoFT(añoPeriodoFT);
				ft.setTecnicaFT(tecnicaFT);
				ft.setSoporteFT(soporteFT);
				ft.setDimensionesFT(dimensionesFT);
				ft.setGeneroFT(generoFT);
				ft.setFormatoFT(formatoFT);
				ft.setFirmaFT(firmaFT);
				ft.setInscripcionesFT(inscripcionesFT);
				ft.setDescripcionFT(descripcionFT);
				if(existe(ft.getIdFichaTecnica()) != false) {
					System.out.println("Los datos de la ficha son: ");
					System.out.println(ft.toString());
				}
				}
			if(existe(ft.getIdFichaTecnica()) == false) {
				System.out.println("No existe una ficha que se corresponda con los datos ingresados");
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
			return ft;
	}

	
		//********CORROBORAR SI EXISTE POR ID********************
		public static boolean existe(int idFichaTecnica) throws NegocioException, CafeStoreException {
			Connection con = null;
			FichaTecnicaVO ft = null;
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
				String sql = "select * from fichaTecnica where idFichaTecnica=?";
				st = con.prepareStatement(sql);
				st.setInt(1, idFichaTecnica);
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
