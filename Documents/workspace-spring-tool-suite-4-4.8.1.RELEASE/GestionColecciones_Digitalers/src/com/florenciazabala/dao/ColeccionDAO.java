package com.florenciazabala.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.florenciazabala.conexion.Conexion;
import com.florenciazabala.excepciones.CafeStoreException;
import com.florenciazabala.excepciones.NegocioException;
import com.florenciazabala.modulos.ColeccionVO;

public class ColeccionDAO {
	//********INSERTAR********************
			public static void inserta(ColeccionVO c) {
				Connection con= null;
				PreparedStatement st = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacci�n
					String sql = "insert into coleccion (codigo,nombreColeccion,fechaCreacion,descripcion) values (?,?,?,?)";
					st = con.prepareStatement(sql);
					st.setString(1, c.getCodigo());
					st.setString(2, c.getNombreColeccion());
					st.setDate(3, c.getFechaCreacion());
					st.setString(4, c.getDescripcion());
					st.execute();
					if (existe(c.getCodigo()) == true) {
					       System.out.println("La colecci�n ya se encuentra registrada");
					}else {
						System.out.println("Se registr� correctamente a la colecci�n "+c.getNombreColeccion());
					}
					con.commit();//2- Transacci�n
				}catch(SQLException e) {
					System.out.println("No es posible insertar a la colecci�n "+c.getNombreColeccion() );
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
			public static void modifica(ColeccionVO c) {
				PreparedStatement st = null;
				Connection con = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacci�n
					String sql = "update coleccion set codigo=?, nombrecoleccion=?, fechaCreacion=?, descripcion=? where codigo=?";
					st = con.prepareStatement(sql);
					st.setString(1, c.getCodigo());
					st.setString(2, c.getNombreColeccion());
					st.setDate(3, c.getFechaCreacion());
					st.setString(4, c.getDescripcion());
					st.setString(5, c.getCodigo());
					st.execute();
					if (existe(c.getCodigo()) == false) {
					       System.out.println("La coleccion que intenta modificar no existe");
					}else {
						System.out.println("Se actualizaron correctamente los datos de la coleccion "+c.getNombreColeccion());
					}
					con.commit();//2- Transacci�n
				} catch(SQLException e) {
					System.out.println("No es posible modificar los datos de la coleccion "+c.getNombreColeccion());
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
			public static void elimina(String codigo){
				PreparedStatement st = null;
				Connection con = null;
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacci�n
					String sql = "delete from coleccion where codigo=?";
					st = con.prepareStatement(sql);
					st.setString(1, codigo);
					if (existe(codigo) == false) {
					       System.out.println("La coleccion no existe");
					}else {
						System.out.println("Los datos se eliminaron correctamente");
					}
					st.execute();
					con.commit();//2- Transacci�n
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
						System.out.println("Algo sucedi�"+e.getMessage());
					}

					}
			}

			//********BUSCAR POR NOMBRE********************
			public static ColeccionVO getColeccionVO (String nombre) throws NegocioException, CafeStoreException {
				Connection con = null;
				ColeccionVO c = null;
				ResultSet rs = null;
				PreparedStatement st = null;
				boolean existe = false;
				
					try {
						con= Conexion.getConnection();
						con.setAutoCommit(false); //1- Transacci�n
						c= new ColeccionVO ();
						String sql = "select * from coleccion where nombreColeccion like  ? ";
						st = con.prepareStatement(sql);
						st.setString(1, '%'+ nombre + '%');
						rs = st.executeQuery();
						
					while (rs.next()) {
						existe=true;
						int idColeccion = rs.getInt("idColeccion");
						String codigo = rs.getString("codigo");
						String nomb = rs.getString("nombreColeccion");
						Date fechaCreacion = rs.getDate("fechaCreacion");
						String descripcion = rs.getString("descripcion");
						c.setIdColeccion(idColeccion);
						c.setCodigo(codigo);
						c.setNombreColeccion(nomb);
						c.setFechaCreacion(fechaCreacion);
						c.setDescripcion(descripcion);
						if(existe(c.getCodigo()) != false) {
							System.out.println("Los datos de la coleccion son: ");
							System.out.println(c.toString());
						}
						}
					if(c.getCodigo() == null) {
						System.out.println("No existe una coleccion que se corresponda con los datos ingresados");
					}
				
				}catch(SQLException e) {
					System.out.println("No es posible mostrar los datos de la coleccion "+ c.getNombreColeccion());
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
					return c;
			}

			//********BUSCAR POR CODIGO********************
			public static ColeccionVO getColeccionVO2 (String codigo) throws NegocioException, CafeStoreException {
				Connection con = null;
				ColeccionVO c = null;
				ResultSet rs = null;
				PreparedStatement st = null;
				boolean existe = false;
				
					try {
						con= Conexion.getConnection();
						con.setAutoCommit(false); //1- Transacci�n
						c= new ColeccionVO ();
						String sql = "select * from coleccion where codigo like  ? ";
						st = con.prepareStatement(sql);
						st.setString(1, "%"+codigo+"%");
						rs = st.executeQuery();
						
					while (rs.next()) {
						existe=true;
						int idColeccion = rs.getInt("idColeccion");
						String cod = rs.getString("codigo");
						String nomb = rs.getString("nombreColeccion");
						Date fechaCreacion = rs.getDate("fechaCreacion");
						String descripcion = rs.getString("descripcion");
						c.setIdColeccion(idColeccion);
						c.setCodigo(cod);
						c.setNombreColeccion(nomb);
						c.setFechaCreacion(fechaCreacion);
						c.setDescripcion(descripcion);
						if(existe(c.getCodigo()) == true) {
							System.out.println("Los datos de la coleccion que corresponde a su b�squeda son: ");
							System.out.println(c.toString());
						}
						}
					if(existe(c.getCodigo()) == false) {
						System.out.println("La coleccion no existe");
					}
				
				}catch(SQLException e) {
					System.out.println("No es posible mostrar los datos de la coleccion ");
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
					return c;
			}
			
			//********BUSQUEDA GENERAL********************
			public static ColeccionVO getColeccionVOg (String busqueda) throws NegocioException, CafeStoreException {
				Connection con = null;
				ColeccionVO c = null;
				ResultSet rs = null;
				PreparedStatement st = null;
				boolean existe = false;
				
					try {
						con= Conexion.getConnection();
						con.setAutoCommit(false); //1- Transacci�n
						c= new ColeccionVO ();
						String sql = "select * from coleccion where concat (codigo, nombreColeccion, descripcion) like  ? ";
						st = con.prepareStatement(sql);
						st.setString(1,'%'+ busqueda +'%');
						rs = st.executeQuery();
						
					while (rs.next()) {
						existe=true;
						int idColeccion = rs.getInt("idColeccion");
						String cod = rs.getString("codigo");
						String nomb = rs.getString("nombreColeccion");
						Date fechaCreacion = rs.getDate("fechaCreacion");
						String descripcion = rs.getString("descripcion");
						c.setIdColeccion(idColeccion);
						c.setCodigo(cod);
						c.setNombreColeccion(nomb);
						c.setFechaCreacion(fechaCreacion);
						c.setDescripcion(descripcion);
						if(existe(c.getCodigo()) == true) {
							System.out.println("Los datos de la coleccion que corresponden a su b�squeda son : ");
							System.out.println(c.toString());
						}
						}
					if(existe(c.getCodigo()) == false) {
						System.out.println("La coleccion no existe");
					}
				
				}catch(SQLException e) {
					System.out.println("No es posible mostrar los datos de la coleccion "+ c.getNombreColeccion());
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
					return c;
			}
			
			
			
			
			//********CORROBORAR SI EXISTE POR ID********************
			public static boolean existe(int codigo) throws NegocioException, CafeStoreException {
				Connection con = null;
				ColeccionVO c = null;
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
					String sql = "select * from coleccion where idColeccion  = ?";
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
			
			//********CORROBORAR SI EXISTE POR CODIGO********************
				public static boolean existe(String codigo) throws NegocioException, CafeStoreException {
					Connection con = null;
					ColeccionVO c = null;
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
						String sql = "select * from coleccion where codigo  = ?";
						st = con.prepareStatement(sql);
						st.setString(1, codigo);
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
