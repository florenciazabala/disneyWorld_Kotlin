package com.florenciazabala.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	//Atributos
    static String bd = "gestionmuseo";
    static String login = "root";
    static String pass = "";
    static String url = "jdbc:mysql://localhost/"+bd;
    static Connection con= null;
    
    //Constructor
    public static Connection getConnection() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver"); //Establecemos conexión con el Driver
    		con = DriverManager.getConnection(url, login, pass); //Conexion con la base
    		if (con != null) {
    			System.out.println("Estoy conectada");
    		}
    		
    	}catch(SQLException e) {
    		System.out.println("Error SQL "+e.getMessage());
    	}catch (ClassNotFoundException e) {
    		System.out.println("Error Clase "+e.getMessage());
    	}catch (Exception e) {
    		System.out.println("Error Común "+e.getMessage());
    	}
		return con;
    	
    }
    public static Connection abrir() {
		return con;
	}

	public void cerrar() {
		con = null;
	}
	

}
