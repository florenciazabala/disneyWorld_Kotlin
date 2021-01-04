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

public class SalaDAO {
	//********INSERTAR********************
		public static void inserta(SalaVO s) {
			Connection con= null;
			PreparedStatement st = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "insert into sala (numeroSala, nombreSala,piso,museo_idmuseo) values (?,?,?,?)";
				st = con.prepareStatement(sql);
				st.setInt(1, s.getNumeroSala());
				st.setString(2, s.getNombreSala());
				st.setInt(3, s.getPiso());
				st.setInt(4, s.getMuseo_idmuseo());
				st.execute();
				if (existe(s.getNombreSala()) == true) {
				       System.out.println("La sala ya se encuentra registrada");
				}else {
					System.out.println("Se registró correctamente a la sala "+s.getNombreSala());
				}
				con.commit();//2- Transacción
			}catch(SQLException e) {
				System.out.println("No es posible insertar a la sala "+ s.getNombreSala());
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
		public static void modifica(SalaVO s) {
			PreparedStatement st = null;
			Connection con = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "update sala set numeroSala = ?, nombreSala = ?, piso = ? where numeroSala = ? AND museo_idMuseo = ?";
				st = con.prepareStatement(sql);
				st.setInt(1, s.getNumeroSala());
				st.setString(2, s.getNombreSala());
				st.setInt(3, s.getPiso());
				st.setInt(4, s.getNumeroSala());
				st.setInt(5, s.getMuseo_idmuseo());
				st.execute();
				if (existe(s.getNumeroSala()) == false) {
				       System.out.println("La sala que intenta modificar no existe");
				}else {
					System.out.println("Se actualizaron correctamente los datos de la sala "+s.getNombreSala());
				}
				con.commit();//2- Transacción
			} catch(SQLException e) {
				System.out.println("No es posible modificar los datos de la sala "+ s.getNombreSala());
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
		public static void elimina(int numeroSala, int museo_idMuseo){
			PreparedStatement st = null;
			Connection con = null;
			try {
				con= Conexion.getConnection();
				con.setAutoCommit(false); //1- Transacción
				String sql = "delete from sala where numeroSala = ? AND museo_idMuseo = ?";
				st = con.prepareStatement(sql);
				st.setInt(1, numeroSala);
				st.setInt(2, museo_idMuseo);
				if (existe(numeroSala) == false) {
				       System.out.println("La sala no existe");
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
		public static SalaVO getSalaVO (String nombre) throws NegocioException, CafeStoreException {
			Connection con = null;
			SalaVO s = null;
			ResultSet rs = null;
			PreparedStatement st = null;
			boolean existe = false;
			
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					s= new SalaVO ();
					String sql = "select * from sala where nombreSala like  ? ";
					st = con.prepareStatement(sql);
					st.setString(1, '%'+ nombre + '%');
					rs = st.executeQuery();
					
				while (rs.next()) {
					existe=true;
					int numeroSala = rs.getInt("numeroSala");
					String nomb = rs.getString("nombreSala");
					int piso = rs.getInt("piso");
					int museo_idmuseo = rs.getInt("museo_idmuseo");
					s.setNumeroSala(numeroSala);
					s.setNombreSala(nomb);
					s.setPiso(piso);
					s.setMuseo_idmuseo(museo_idmuseo);
					if(existe(s.getNombreSala()) != false) {
						System.out.println("Los datos de la sala son: ");
						System.out.println(s.toString());
					}
					}
				if(s.getNombreSala() == null) {
					System.out.println("No existe una sala que se corresponda con los datos ingresados");
				}
			
			}catch(SQLException e) {
				System.out.println("No es posible mostrar los datos de la sala "+ s.getNombreSala());
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
				return s;
		}

		//********BUSCAR POR ID********************
		public static SalaVO getSalaVO (int codigo) throws NegocioException, CafeStoreException {
			Connection con = null;
			SalaVO s = null;
			ResultSet rs = null;
			PreparedStatement st = null;
			boolean existe = false;
			
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					s= new SalaVO ();
					String sql = "select * from sala where numeroSala =  ? ";
					st = con.prepareStatement(sql);
					st.setInt(1, codigo);
					rs = st.executeQuery();
					
				while (rs.next()) {
					existe=true;
					int numeroSala = rs.getInt("numeroSala");
					String nomb = rs.getString("nombreSala");
					int piso = rs.getInt("piso");
					int museo_idmuseo = rs.getInt("museo_idmuseo");
					s.setNumeroSala(numeroSala);
					s.setNombreSala(nomb);
					s.setPiso(piso);
					s.setMuseo_idmuseo(museo_idmuseo);
					if(existe(s.getNumeroSala()) == true) {
						System.out.println("Los datos de la sala son: ");
						System.out.println(s.toString());
					}
					}
				if(existe(s.getNumeroSala()) == false) {
					System.out.println("La sala no existe");
				}
			
			}catch(SQLException e) {
				System.out.println("No es posible mostrar los datos de la sala "+ s.getNombreSala());
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
				return s;
		}
		
		//********BUSQUEDA GENERAL********************
		public static SalaVO getSalaVOg (String busqueda) throws NegocioException, CafeStoreException {
			Connection con = null;
			SalaVO s = null;
			ResultSet rs = null;
			PreparedStatement st = null;
			boolean existe = false;
			
				try {
					con= Conexion.getConnection();
					con.setAutoCommit(false); //1- Transacción
					s= new SalaVO ();
					String sql = "select * from sala where concat (nombreSala) like  ? ";
					st = con.prepareStatement(sql);
					st.setString(1,'%'+ busqueda +'%');
					rs = st.executeQuery();
					
				while (rs.next()) {
					existe=true;
					int numeroSala = rs.getInt("numeroSala");
					String nomb = rs.getString("nombreSala");
					int piso = rs.getInt("piso");
					int museo_idmuseo = rs.getInt("museo_idmuseo");
					s.setNumeroSala(numeroSala);
					s.setNombreSala(nomb);
					s.setPiso(piso);
					s.setMuseo_idmuseo(museo_idmuseo);
					if(existe(s.getNumeroSala()) == true) {
						System.out.println("Los datos de la sala : ");
						System.out.println(s.toString());
					}
					}
				if(existe(s.getNumeroSala()) == false) {
					System.out.println("La sala no existe");
				}
			
			}catch(SQLException e) {
				System.out.println("No es posible mostrar los datos de la sala "+ s.getNombreSala());
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
				return s;
		}
		
		
		
		
		
		
		
		//********CORROBORAR SI EXISTE POR ID********************
		public static boolean existe(int codigo) throws NegocioException, CafeStoreException {
			Connection con = null;
			SalaVO s = null;
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
				String sql = "select * from sala where numeroSala  = ?";
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
			public static boolean existe(String nombre) throws NegocioException, CafeStoreException {
				Connection con = null;
				SalaVO s = null;
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
					String sql = "select * from sala where nombreSala  = ?";
					st = con.prepareStatement(sql);
					st.setString(1, nombre);
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
			
			
			
			
			//********INNER JOIN********************
			public static SalaVO unir () throws NegocioException, CafeStoreException {
				Connection con = null;
				SalaVO s = null;
				MuseoVO m= null;
				ResultSet rs = null;
				PreparedStatement st = null;
				boolean existe = false;
				
					try {
						con= Conexion.getConnection();
						con.setAutoCommit(false); //1- Transacción
						s= new SalaVO ();
						m=new MuseoVO();
						String sql = "SELECT s.numeroSala, s.nombreSala, s.piso, s.museo_idmuseo, m.idMuseo, m.nombre, m.direccion, m.email FROM sala s INNER JOIN museo m ON s.museo_idmuseo = m.idMuseo ORDER BY m.nombre";
						st = con.prepareStatement(sql);
						//st.setInt(1, codigo);
						rs = st.executeQuery();
						
					while (rs.next()) {
						existe=true;
						int numeroSala = rs.getInt("numeroSala");
						String nomb = rs.getString("nombreSala");
						int piso = rs.getInt("piso");
						int museo_idmuseo = rs.getInt("museo_idmuseo");
						
						int idMuseo =rs.getInt("idMuseo");
						String nombM = rs.getString("nombre");
						String direccion = rs.getString("direccion");
						String email = rs.getString("email");
						
						m.setIdMuseo(idMuseo);
						m.setNombre(nombM);
						m.setDireccion(direccion);
						m.setEmail(email);
						
						
						s.setNumeroSala(numeroSala);
						s.setNombreSala(nomb);
						s.setPiso(piso);
						s.setMuseo_idmuseo(museo_idmuseo);
						
						System.out.println(s.toString()+m.toString());
						
						}
					
				
				}catch(SQLException e) {
					System.out.println("No es posible mostrar los datos de la sala "+ s.getNombreSala());
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
					return s;
			}

}
