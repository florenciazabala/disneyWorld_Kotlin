package com.florenciazabala.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;   /*1- Insertar imagen*/
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.fichageneral.DocumentacionFotograficaVO;


public class DocumentacionFotograficaDAO {
	//********INSERTAR********************
		public static void inserta(int idDocumentacionFotografica, String ruta, int tipoDoc_idTipoDoc, int objeto_numeroInventario) throws IOException {
			Connection con= null;
			PreparedStatement st = null;
			FileInputStream fis = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "insert into documentacionFotografica (idDocumentacionFotografica, ImagenDocF, tipoDoc_idTipoDoc, objeto_numeroInventario) values (?,?,?,?)";
				File file = new File(ruta);/*1- Insertar imagen*/
				fis = new FileInputStream(file);/*2- Insertar imagen*/
				st = con.prepareStatement(sql);
				st.setInt(1, idDocumentacionFotografica);
				st.setBinaryStream(2,fis,(int)file.length());/*3- Insertar imagen*/
				st.setInt(3, tipoDoc_idTipoDoc);
				st.setInt(4, objeto_numeroInventario);
				st.execute();
				con.commit();//2- Transacción
			}catch(SQLException e) {
				System.out.println("No es posible insertar la imagen " );
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
				if(fis!=null) {
					fis.close();
				}
			}catch (SQLException e) {
				System.out.println("Algo sucedió"+e.getMessage());
			}

			}
		}
		//********MODIFICAR********************
				public static void modifica (String ruta, int tipoDoc_idTipoDoc, int idDocumentacionFotografica, int objeto_numeroInventario) throws IOException {
					Connection con= null;
					PreparedStatement st = null;
					FileInputStream fis = null;
					try {
						con= Conexion.getConnection();
						con.setAutoCommit(false); //1- Transacción
						String sql = "update documentacionFotografica set  ImagenDocF =?, tipoDoc_idTipoDoc=?  where idDocumentacionFotografica =?";
						File file = new File(ruta);/*1- Insertar imagen*/
						fis = new FileInputStream(file);/*2- Insertar imagen*/
						st = con.prepareStatement(sql);
						st.setBinaryStream(1,fis,(int)file.length());/*3- Insertar imagen*/
						st.setInt(2, tipoDoc_idTipoDoc);
						st.setInt(3, idDocumentacionFotografica);
						st.setInt(4, objeto_numeroInventario);
						st.execute();
						con.commit();//2- Transacción
					}catch(SQLException e) {
						System.out.println("No es posible insertar la imagen " );
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
						if(fis!=null) {
							fis.close();
						}
					}catch (SQLException e) {
						System.out.println("Algo sucedió"+e.getMessage());
					}

					}
				}
		
		//********ELIMINAR POR ID********************
		public static void elimina(int idDocumentacionFotografica){
			PreparedStatement st = null;
			Connection con = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "delete from documentacionFotografica where idDocumentacionFotografica=?";
				st = con.prepareStatement(sql);
				st.setInt(1,idDocumentacionFotografica );
				if (existe(idDocumentacionFotografica) == false) {
				       System.out.println("El tipo de documento que desea eliminar no existe");
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
		public static DocumentacionFotograficaVO getDocumentacionFotograficaVO (int idDocumentacionFotografica) throws NegocioException, CafeStoreException {
			Connection con = null;
			DocumentacionFotograficaVO df = null;
			ResultSet rs = null;
			PreparedStatement st = null;
			
			
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					df= new DocumentacionFotograficaVO ();
					String sql = "select * from documentacionFotografica where idDocumentacionFotografica like  ? ";
					st = con.prepareStatement(sql);
					st.setInt(1, '%'+ idDocumentacionFotografica + '%');
					rs = st.executeQuery();
					
				while (rs.next()) {
					System.out.println("Las imagenes son: ");
					int idDocumentacion = rs.getInt("idDocumentacionFotografica");
//					int tipoDoc = ("tipoDoc_idTipoDoc");
					Blob blob = rs.getBlob("imagenDocF");
					BufferedImage img = null;
					try {
						 img = ImageIO.read((File) blob);
						 System.out.println(img);
						 } catch (IOException ex) {
							 System.out.println(ex.getMessage());
						 }
					df.setIdDocumentacionFotografica(idDocumentacion);
					df.setImagenDocF(img);
//					df.setTipoDoc_idTipoDoc(tipoDoc);
					
					
					}
				
			
			}catch(SQLException e) {
				System.out.println("No es posible mostrar los datos del tipo de documento ");
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
				return df;
		}

		//********BUSCAR POR TIPO DOC********************
		public static TipoDocVO getTipoDocVO (String tipoDoc) throws NegocioException, CafeStoreException {
			Connection con = null;
			TipoDocVO td = null;
			ResultSet rs = null;
			PreparedStatement st = null;
			boolean existe = false;
			
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					td= new TipoDocVO ();
					String sql = "select * from tipoDoc where tipoDoc like  ? ";
					st = con.prepareStatement(sql);
					st.setString(1, '%'+ tipoDoc + '%');
					rs = st.executeQuery();
					
				while (rs.next()) {
					existe=true;
					int id = rs.getInt("idTipoDoc");
					String tipo = rs.getString("tipoDoc");
					String descripcionTipoDoc = rs.getString("descripcionTipoDoc");
					td.setIdTipoDoc(id);
					td.setTipoDoc(tipo);
					td.setDescripcion(descripcionTipoDoc);
					if(existe(td.getIdTipoDoc()) != false) {
						System.out.println("Los datos del tipo de documento son: ");
						System.out.println(td.toString());
					}
					}
				if(existe(td.getIdTipoDoc()) == false) {
					System.out.println("No existe un tipo de documento que se corresponda con los datos ingresados");
				}
			
			}catch(SQLException e) {
				System.out.println("No es posible mostrar los datos del tipo de documento ");
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
				return td;
		}
		
		
		
		//********CORROBORAR SI EXISTE POR ID********************
		public static boolean existe(int codigo) throws NegocioException, CafeStoreException {
			Connection con = null;
			DocumentacionFotograficaVO df = null;
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
				String sql = "select * from DocumentacionFotografica where idDocumentacionFotografica  = ?";
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
