package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {
	

	public static Connection getConnection() {
		String hosts = "127.0.0.1";//localhost
		String port = "3306";
		String password = "root";
		String username = "root";
		

		String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		String dbName = "neobecas-integrador";
		
		
		Connection connection;
		try {
			Class.forName(driverClassName);
			
			String url = "jdbc:mysql://" + hosts + ":"+ port +"/"+ dbName +"?allowPublicKeyRetrieval=true&serverTimeZone=UTC&useSSL=false";
			
			connection = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			connection = null;
		}
		
		return connection;
	}


}
